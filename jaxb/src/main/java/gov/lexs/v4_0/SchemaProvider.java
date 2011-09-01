/*
 *  Copyright 2010 GTRI.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */

package gov.lexs.v4_0;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.SAXException;

/**
 * Provides access to the java.validation.{@link Schema} object, which can be
 * used for LEXS 4.0 schema validation.
 * <br/><br/>
 * @author brad
 * @date Dec 3, 2010
 */
public class SchemaProvider {
    //==========================================================================
    //  Private Static Variables
    //==========================================================================
    private static Map<String, String> SCHEMA_FILE_CACHE = null;
    //==========================================================================
    //  Private Static Methods
    //==========================================================================
    private static InputStream readClasspathResource( String path ) throws IOException {
        InputStream in = null;
        in = SchemaProvider.class.getResourceAsStream(path);
        if( in == null ){
            in = SchemaProvider.class.getResourceAsStream("/"+path);
        }
        if( in == null ){
            in = ClassLoader.getSystemResourceAsStream(path);
        }
        if( in == null ){
            in = ClassLoader.getSystemResourceAsStream("/"+path);
        }
        if( in == null ){
            throw new FileNotFoundException("Unable to locate classpath resource: "+path);
        }
        return in;
    }
    
    private static String asText( String classpathResource ) throws IOException {
        InputStream in = readClasspathResource(classpathResource);
        StringWriter writer = new StringWriter();
        dump(new InputStreamReader(in), writer);
        return writer.toString();
    }//end asText()

    private static void dump( Reader reader, Writer writer ) throws IOException {
        char[] buffer = new char[1024];
        int read = -1;
        while( (read=reader.read(buffer)) > 0 ){
            writer.write(buffer, 0, read);
        }
        writer.flush();
    }//end dump()

    private static void debug( String msg ){
        System.out.println(msg);
        System.out.flush();
    }

    private static void initSchemaCache() throws IOException {
        SCHEMA_FILE_CACHE = new HashMap<String, String>();
        debug("Loading schema file list...");
        String indexList = asText("gov/lexs/v4_0/schemas/xsd.index");
        String[] schemaFiles = indexList.split("\n");
        for( String schemaFile : schemaFiles ){
            schemaFile = schemaFile.trim();
            if( schemaFile == null )
                continue;
            if( schemaFile.length() > 0 && !schemaFile.startsWith("#") ){
                if( schemaFile.contains("IC-ISM-v2.xsd") ){
                    String uri = "urn:us:gov:ic:ism:v2";
                    debug("Storing schema file ["+uri+"] -> "+schemaFile);
                    SCHEMA_FILE_CACHE.put(uri, schemaFile);
                }else if(schemaFile.contains("t-1.xsd") ){
                    String uri = "http://docs.oasis-open.org/wsn/t-1";
                    debug("Storing schema file ["+uri+"] -> "+schemaFile);
                    SCHEMA_FILE_CACHE.put(uri, schemaFile);
                }else if(schemaFile.contains("xenc-schema.xsd") ){
                    String uri = "http://www.w3.org/2001/04/xmlenc#";
                    debug("Storing schema file ["+uri+"] -> "+schemaFile);
                    SCHEMA_FILE_CACHE.put(uri, schemaFile);
                }else{
                    String schemaFileText = asText(schemaFile);
                    Pattern pattern = Pattern.compile("targetNamespace=\"(.*?)\"");
                    Matcher matcher = pattern.matcher(schemaFileText);
                    if( matcher.find() ){
                        String uri = matcher.group(1);
                        debug("Storing schema file ["+uri+"] -> "+schemaFile);
                        SCHEMA_FILE_CACHE.put(uri, schemaFile);
                    }else{
                        debug("Bad File, contains no targetNamespace: "+schemaFile);
                    }
                }
            }
        }
        if( SCHEMA_FILE_CACHE.keySet().size() == 0 ){
            throw new NullPointerException("Did not find any LEXS 4.0 schemas.");
        }
        debug("Successfully loaded "+SCHEMA_FILE_CACHE.keySet().size()+" schemas");
    }//end initSchemaCache()
    //==========================================================================
    //  Public Static Methods
    //==========================================================================
    /**
     * Constructs a {@link Schema} object which can be used to perform LEXS 4.0
     * Schema validation against an instance.  See Also:
     * <a href="http://www.ibm.com/developerworks/xml/library/x-javaxmlvalidapi.html">
     *     http://www.ibm.com/developerworks/xml/library/x-javaxmlvalidapi.html
     * </a>
     * <br/><br/>
     * @return an instance of {@link Schema} for validation.
     * @throws IOException if there is any errors accessing/reading schema files
     * @throws SAXException if the schema files contain a schema error (which
     *      shouldn't happen).
     */
    public static Schema createLexs40Schema() throws IOException, SAXException {
        Schema schema = null;
        if( SCHEMA_FILE_CACHE == null ){
            initSchemaCache();
        }
        List<Source> schemaSources = new ArrayList<Source>();
        for( String uri : SCHEMA_FILE_CACHE.keySet() ){
            String schemaFile = SCHEMA_FILE_CACHE.get(uri);
            InputStream schemaIn = readClasspathResource(schemaFile);
            Source schemaSource = new StreamSource(schemaIn);
            schemaSources.add(schemaSource);
        }
        if( schemaSources.isEmpty() ){
            throw new FileNotFoundException("Error trying to load empty schemas.");
        }
        debug("# Actual schema source count is: "+schemaSources.size());
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        schemaFactory.setResourceResolver(new Lexs40ResourceResolver());
        schema = schemaFactory.newSchema(schemaSources.toArray(new Source[]{}));
        return schema;
    }//end createLexs40Schema()

    private static class Lexs40ResourceResolver implements LSResourceResolver {
        public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId, String baseURI) {
            if( !SCHEMA_FILE_CACHE.containsKey(namespaceURI) ){
                throw new UnsupportedOperationException("Unable to find namespace uri reference: "+namespaceURI);
            }
            String schemaFile = SCHEMA_FILE_CACHE.get(namespaceURI);
            return new Lexs40Input(publicId, systemId, baseURI, schemaFile);
        }
    }//end Lexs40ResourceResolver()

    private static class Lexs40Input implements LSInput {
        private String schemaFile = null;
        private String baseURI = null;
        private String publicId = null;
        private String systemId = null;
        private boolean certifiedText = false;
        private String encoding = "UTF-8"; // Is this right?  FIXME

        public Lexs40Input( String publicId, String systemId, String baseUri, String schemaFile ){
            this.schemaFile = schemaFile;
            this.baseURI = baseUri;
            this.publicId = publicId;
            this.systemId = systemId;
        }

        
        public String getBaseURI() {
            return baseURI;
        }
        
        public InputStream getByteStream() {
            try{
                return readClasspathResource(schemaFile);
            }catch(IOException ioe){
                throw new UnsupportedOperationException("Error creating input stream: "+schemaFile, ioe);
            }
        }
        
        public boolean getCertifiedText() {
            return certifiedText;
        }
        
        public Reader getCharacterStream() {
            return new InputStreamReader(this.getByteStream());
        }
        
        public String getEncoding() {
            return encoding;
        }
        
        public String getPublicId() {
            return this.publicId;
        }
        
        public String getStringData() {
            try{
                return asText(this.schemaFile);
            }catch(IOException ioe){
                throw new UnsupportedOperationException("Error creating text from input stream: "+schemaFile, ioe);
            }
        }
        
        public String getSystemId() {
            return this.systemId;
        }
        
        public void setBaseURI(String baseURI) {
            this.baseURI = baseURI;
        }
        
        public void setByteStream(InputStream byteStream) {
            throw new UnsupportedOperationException("Cannot overwrite byte stream for "+this.schemaFile);
        }
        
        public void setCertifiedText(boolean certifiedText) {
            this.certifiedText = certifiedText;
        }
        
        public void setCharacterStream(Reader characterStream) {
            throw new UnsupportedOperationException("Cannot overwrite character stream for "+this.schemaFile);
        }
        
        public void setEncoding(String encoding) {
            this.encoding = encoding;
        }
        
        public void setPublicId(String publicId) {
            this.publicId = publicId;
        }
        
        public void setStringData(String stringData) {
            throw new UnsupportedOperationException("Cannot overwrite data for "+this.schemaFile);
        }
        
        public void setSystemId(String systemId) {
            this.systemId = systemId;
        }
    }//end Lexs40Input()

}/* end class SchemaProvider */
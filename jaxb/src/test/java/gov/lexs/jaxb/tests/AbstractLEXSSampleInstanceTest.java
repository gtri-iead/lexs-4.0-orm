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

package gov.lexs.jaxb.tests;

import java.io.FileReader;
import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.Difference;
import gov.lexs.v4_0.JAXBUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.custommonkey.xmlunit.XMLUnit;
import org.xml.sax.SAXException;
import static org.junit.Assert.*;

/**
 * FIXME Describe this type.
 * <br/><br/>
 * @author brad
 * @date Dec 2, 2010
 */
public abstract class AbstractLEXSSampleInstanceTest extends AbstractTest {
    //==========================================================================
    //  Test Variables
    //==========================================================================
    private Schema SCHEMA;
    protected static final FileFilter SUB_DIRECTORIES = new FileFilter() {
        @Override
        public boolean accept(File file) {
            return file.isDirectory();
        }
    };
    protected static final FileFilter XML_FILES = new FileFilter() {
        @Override
        public boolean accept(File file) {
            return file.isFile() && file.getName().toLowerCase().endsWith(".xml");
        }
    };
    protected static final FileFilter XSD_FILES = new FileFilter() {
        @Override
        public boolean accept(File file) {
            return file.isFile() && file.getName().toLowerCase().endsWith(".xsd");
        }
    };
    //==========================================================================
    //  Helper Methods
    //==========================================================================
    protected void collectAllFiles(File directory, List<File> files, FileFilter filter) {
        files.addAll(Arrays.asList(directory.listFiles(filter)));
        for( File subdir : directory.listFiles(SUB_DIRECTORIES) ){
            collectAllFiles(subdir, files, filter);
        }
    }//end collectAllXmlFiles()

    protected List<File> getXmlFiles(File directory) {
        List<File> files = new ArrayList<File>();
        this.collectAllFiles(directory, files, XML_FILES);
        return files;
    }

    protected Schema getSchema() throws SAXException {
        if( SCHEMA == null ){
            List<File> xsdFiles = new ArrayList<File>();
            this.collectAllFiles(new File("./src/main/xsd"), xsdFiles, XSD_FILES);
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Source[] schemaSources = new Source[xsdFiles.size()];
            for( int i = 0; i < xsdFiles.size(); i++ ){
                Source source = new StreamSource(xsdFiles.get(i));
                schemaSources[i] = source;
            }
            SCHEMA = schemaFactory.newSchema(schemaSources);
        }
        return SCHEMA;
    }   

    protected void validateAgainstLEXS40Schemas( File file ) throws Exception {
        Schema schema = this.getSchema();
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(file));
    }//end validateAgainstLEXS40Schemas()

    protected void validateAllXml( String directoryName ) throws Exception {
        logger.debug("Collecting XML files...");
        File directory = new File(directoryName);
        assertTrue(directory.exists());
        assertTrue(directory.isDirectory());
        List<File> files = getXmlFiles(directory);
        logger.info("Testing {} files...", files.size());
        for( File xmlFile : files ){
            validateXmlFile( xmlFile );
        }
    }//end validateAllXml()

    protected void validateXmlFile( File xmlFile ) throws Exception {
        logger.info("Testing file {}...", xmlFile);
        Object object = JAXBUtils.unmarshal(xmlFile);
        assertNotNull(object);
        assertTrue( object instanceof JAXBElement );
        File tempDir = new File("./target/jaxb-marshalling-results");
        tempDir.mkdirs();
        File tempFile = File.createTempFile(xmlFile.getName(), ".xml", tempDir);
        JAXBUtils.marshall(object, tempFile);
        try{
            validateAgainstLEXS40Schemas( tempFile );
        }catch(Exception e){
            logger.warn("File "+xmlFile+" failed to validate after going through object transform.", e);
            fail("File "+xmlFile+" did not pass schema validation after jaxb!");
        }
        assertXmlEquivalence( xmlFile, tempFile );
        logger.info("Successfully used JAXB to round-trip and validate file {}!", xmlFile);
    }//end validateXmlFile()

    protected void assertXmlEquivalence( File xmlFile1, File xmlFile2 ) throws Exception {
        XMLUnit.setIgnoreAttributeOrder(true);
        XMLUnit.setIgnoreComments(true);
        XMLUnit.setIgnoreDiffBetweenTextAndCDATA(true);
        XMLUnit.setIgnoreWhitespace(true); 
        XMLUnit.setNormalize(true); // Debatable
        XMLUnit.setNormalizeWhitespace(true); // Debatable
        Diff diff = new Diff(new FileReader(xmlFile1), new FileReader(xmlFile2));
        if( !diff.identical() ){
            DetailedDiff details = new DetailedDiff(diff);
            List<Difference> differences = new ArrayList<Difference>();
            for( Object difObj : details.getAllDifferences() ){
                Difference difference = (Difference) difObj;
                if( isValidDifference(difference) )
                    differences.add(difference);
            }
            if( differences.size() > 0 ){
                logger.warn("Differences after jaxb transform of file {}: ", xmlFile1);
                for( Difference difference : differences ){
                    logger.warn("   "+difference.toString());
                }
                fail("JAXB did not output identical file for: "+xmlFile1);
            }
        }
        logger.info("File {} round-trips successfully!", xmlFile1);
    }//end assertXmlEquivalence()

    protected boolean isValidDifference( Difference difference ) {
        boolean keep = true;
        if( difference.toString().contains("Expected namespace prefix") ){
            keep = false;
        }else if( difference.toString().contains("Expected xsi:schemaLocation") ){
            keep = false;
        }else if( difference.toString().contains("nc:BinaryBase64Object") ){
            keep = false;
        }else if( difference.toString().contains("lexsdigest:EntityItemImageAssociation") ){
            // This is a QName value in the text of another tag.  
            keep = false;
        }else if( difference.toString().contains("xsi:type") ){
            keep = false;
        }
        return keep;
    }//end isValidDifference

    
}/* end class TestJAXBUtils */
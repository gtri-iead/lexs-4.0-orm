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

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;

/**
 * Helps users to work with the generated LEXS 4.0 objects and JAXB.
 */
public final class JAXBUtils {
    //==========================================================================
    //  Private Static Variables
    //==========================================================================
    private static JAXBContext JAXB_CONTEXT = null;
    private static Marshaller MARSHALLER = null;
    private static Unmarshaller UNMARSHALLER = null;
    private static final String NAMESPACE_PREFIX_PROP = "com.sun.xml.bind.namespacePrefixMapper";
    //==========================================================================
    //  Public Static Variables
    //==========================================================================

    //==========================================================================
    //  Private Static Methods
    //==========================================================================
//    private static List<String> listClasses() throws Exception {
//        List<String> classes = new ArrayList<String>();
//        ResourceBundle bundle = ResourceBundle.getBundle("gov.lexs.v4.classlist");
//        Integer count = 0;
//        count = Integer.parseInt(bundle.getString("class.count"));
//        for( int i = 1; i < (count+1); i++ ){
//            String className = bundle.getString("class."+i);
//            if( classes.contains(className) ){
//                classes.add(className);
//            }
//        }
//        return classes;
//    } //end listClasses()

    static {
//        List<String> classNames = null;
//        try{
//            classNames = listClasses();
//        }catch(Exception e){
//            throw new RuntimeException("Error while reading JAXB Classes.", e);
//        }
//        Class[] classes = new Class[classNames.size()];
//        for( int i = 0; i < classNames.size(); i++ ){
//            String name = classNames.get(i);
//            Class clzz = null;
//            try{
//                clzz = Class.forName(name);
//            }catch(Exception e){
//                throw new RuntimeException("Cannot initialize class: "+name, e);
//            }
//            classes[i] = clzz;
//        }
        try{
            JAXB_CONTEXT = JAXBContext.newInstance("gov.lexs.v4_0.jaxb");
            MARSHALLER = createMarshaller();
            UNMARSHALLER = createUnmarshaller();
        }catch(Exception e){
            throw new RuntimeException("Error instantiating JAXBContext.", e);
        }
    }
    //==========================================================================
    //  Public Static Methods
    //==========================================================================
    public static Marshaller createMarshaller(){ return createMarshaller(true); }
    public static Marshaller createMarshaller(Boolean validating) {
        Marshaller marshaller = null;
        if( JAXB_CONTEXT == null )
            throw new NullPointerException("Cannot create marshaller, since JAXBContext is null.  Error loading context.");
        try{
            marshaller = JAXB_CONTEXT.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(NAMESPACE_PREFIX_PROP, new LEXS40NamespacePrefixMapper());
            if( validating )
                marshaller.setSchema(SchemaProvider.createLexs40Schema());
        }catch(Exception e){
            throw new RuntimeException("Unable to create marshaller.", e);
        }
        return marshaller;
    }//end createMarshaller()

    public static Unmarshaller createUnmarshaller(){ return createUnmarshaller(true); }
    public static Unmarshaller createUnmarshaller(Boolean validating) {
        Unmarshaller unmarshaller = null;
        if( JAXB_CONTEXT == null )
            throw new NullPointerException("Cannot create unmarshaller, since JAXBContext is null.  Error loading context.");
        try{
            unmarshaller = JAXB_CONTEXT.createUnmarshaller();
            if( validating )
                unmarshaller.setSchema(SchemaProvider.createLexs40Schema());
        }catch(Exception e){
            throw new RuntimeException("Unable to create unmarshaller.", e);
        }
        return unmarshaller;
    }//end createUnmarshaller()
    //==========================================================================
    //  Marshalling Methods
    //==========================================================================
    public static void marshall(Object object, ContentHandler handler) {
        synchronized(MARSHALLER){
            try{
                MARSHALLER.marshal(object, handler);
            }catch(JAXBException jaxbe){
                throw new RuntimeException("Unable to marshall object.", jaxbe);
            }
        }
    }//end marshall(Object object, ContentHandler handler)

    public static void marshall(Object object, File file) {
        synchronized(MARSHALLER){
            try{
                MARSHALLER.marshal(object, file);
            }catch(JAXBException jaxbe){
                throw new RuntimeException("Unable to marshall object.", jaxbe);
            }
        }
    }//end marshall(Object object, File file)

    public static void marshall(Object object, Node node) {
        synchronized(MARSHALLER){
            try{
                MARSHALLER.marshal(object, node);
            }catch(JAXBException jaxbe){
                throw new RuntimeException("Unable to marshall object.", jaxbe);
            }
        }
    }//end marshall(Object object, Node node)

    public static void marshall(Object object, OutputStream out) {
        synchronized(MARSHALLER){
            try{
                MARSHALLER.marshal(object, out);
            }catch(JAXBException jaxbe){
                throw new RuntimeException("Unable to marshall object.", jaxbe);
            }
        }
    }//end marshall(Object object, OutputStream out)

    public static void marshall(Object object, Result result) {
        synchronized(MARSHALLER){
            try{
                MARSHALLER.marshal(object, result);
            }catch(JAXBException jaxbe){
                throw new RuntimeException("Unable to marshall object.", jaxbe);
            }
        }
    }//end marshall(Object object, Result result)

    public static void marshall(Object object, Writer writer) {
        synchronized(MARSHALLER){
            try{
                MARSHALLER.marshal(object, writer);
            }catch(JAXBException jaxbe){
                throw new RuntimeException("Unable to marshall object.", jaxbe);
            }
        }
    }//end marshall(Object object, Writer writer)

    public static void marshall(Object object, XMLEventWriter writer) {
        synchronized(MARSHALLER){
            try{
                MARSHALLER.marshal(object, writer);
            }catch(JAXBException jaxbe){
                throw new RuntimeException("Unable to marshall object.", jaxbe);
            }
        }
    }//end marshall(Object object, XMLEventWriter writer)

    public static void marshall(Object object, XMLStreamWriter writer) {
        synchronized(MARSHALLER){
            try{
                MARSHALLER.marshal(object, writer);
            }catch(JAXBException jaxbe){
                throw new RuntimeException("Unable to marshall object.", jaxbe);
            }
        }
    }//end marshall(Object object, XMLStreamWriter writer)


    //==========================================================================
    //  Unmarshalling Methods
    //==========================================================================
    public static Object unmarshal(File file) {
        synchronized(UNMARSHALLER){
            try{
                return UNMARSHALLER.unmarshal(file);
            }catch(JAXBException jaxbe){
                throw new RuntimeException("Unable to unmarshal object.", jaxbe);
            }
        }
    }//end unmarshal(File file)

    public static Object unmarshal(InputSource source) {
        synchronized(UNMARSHALLER){
            try{
                return UNMARSHALLER.unmarshal(source);
            }catch(JAXBException jaxbe){
                throw new RuntimeException("Unable to unmarshal object.", jaxbe);
            }
        }
    }//end unmarshal(InputSource source)

    public static Object unmarshal(InputStream in) {
        synchronized(UNMARSHALLER){
            try{
                return UNMARSHALLER.unmarshal(in);
            }catch(JAXBException jaxbe){
                throw new RuntimeException("Unable to unmarshal object.", jaxbe);
            }
        }
    }//end unmarshal(InputStream in)

    public static Object unmarshal(Node node) {
        synchronized(UNMARSHALLER){
            try{
                return UNMARSHALLER.unmarshal(node);
            }catch(JAXBException jaxbe){
                throw new RuntimeException("Unable to unmarshal object.", jaxbe);
            }
        }
    }//end unmarshal(Node node)

    public static Object unmarshal(Reader reader) {
        synchronized(UNMARSHALLER){
            try{
                return UNMARSHALLER.unmarshal(reader);
            }catch(JAXBException jaxbe){
                throw new RuntimeException("Unable to unmarshal object.", jaxbe);
            }
        }
    }//end unmarshal(Reader reader)

    public static Object unmarshal(Source source) {
        synchronized(UNMARSHALLER){
            try{
                return UNMARSHALLER.unmarshal(source);
            }catch(JAXBException jaxbe){
                throw new RuntimeException("Unable to unmarshal object.", jaxbe);
            }
        }
    }//end unmarshal(Source source)

    public static Object unmarshal(URL url) {
        synchronized(UNMARSHALLER){
            try{
                return UNMARSHALLER.unmarshal(url);
            }catch(JAXBException jaxbe){
                throw new RuntimeException("Unable to unmarshal object.", jaxbe);
            }
        }
    }//end unmarshal(URL url)

    public static Object unmarshal(XMLEventReader reader) {
        synchronized(UNMARSHALLER){
            try{
                return UNMARSHALLER.unmarshal(reader);
            }catch(JAXBException jaxbe){
                throw new RuntimeException("Unable to unmarshal object.", jaxbe);
            }
        }
    }//end unmarshal(XMLEventReader reader)

    public static Object unmarshal(XMLStreamReader reader) {
        synchronized(UNMARSHALLER){
            try{
                return UNMARSHALLER.unmarshal(reader);
            }catch(JAXBException jaxbe){
                throw new RuntimeException("Unable to unmarshal object.", jaxbe);
            }
        }
    }//end unmarshal(XMLStreamReader reader)

    public static <T> JAXBElement<T> unmarshal(Reader reader, Class<T> declaredType) {
        synchronized(UNMARSHALLER){
            try{
                return (JAXBElement<T>) UNMARSHALLER.unmarshal(reader);
            }catch(JAXBException jaxbe){
                throw new RuntimeException("Unable to unmarshal object.", jaxbe);
            }
        }
    }//end unmarshal(Reader reader)

    public static <T> JAXBElement<T> unmarshal(InputStream instream, Class<T> declaredType) {
        synchronized(UNMARSHALLER){
            try{
                return (JAXBElement<T>) UNMARSHALLER.unmarshal(instream);
            }catch(JAXBException jaxbe){
                throw new RuntimeException("Unable to unmarshal object.", jaxbe);
            }
        }
    }//end unmarshal(Reader reader)

    public static <T> JAXBElement<T> unmarshal(Node node, Class<T> declaredType) {
        synchronized(UNMARSHALLER){
            try{
                return UNMARSHALLER.unmarshal(node, declaredType);
            }catch(JAXBException jaxbe){
                throw new RuntimeException("Unable to unmarshal object.", jaxbe);
            }
        }
    }//end unmarshal(Node node, Class<T> declaredType)

    public static <T> JAXBElement<T> unmarshal(Source source, Class<T> declaredType) {
        synchronized(UNMARSHALLER){
            try{
                return UNMARSHALLER.unmarshal(source, declaredType);
            }catch(JAXBException jaxbe){
                throw new RuntimeException("Unable to unmarshal object.", jaxbe);
            }
        }
    }//end unmarshal(Source source, Class<T> declaredType)

    public static <T> JAXBElement<T> unmarshal(XMLEventReader reader, Class<T> declaredType) {
        synchronized(UNMARSHALLER){
            try{
                return UNMARSHALLER.unmarshal(reader, declaredType);
            }catch(JAXBException jaxbe){
                throw new RuntimeException("Unable to unmarshal object.", jaxbe);
            }
        }
    }//end unmarshal(XMLEventReader reader, Class<T> declaredType)

    public static <T> JAXBElement<T> unmarshal(XMLStreamReader reader, Class<T> declaredType) {
        synchronized(UNMARSHALLER){
            try{
                return UNMARSHALLER.unmarshal(reader, declaredType);
            }catch(JAXBException jaxbe){
                throw new RuntimeException("Unable to unmarshal object.", jaxbe);
            }
        }
    }//end unmarshal(XMLStreamReader reader, Class<T> declaredType)

}/* end class JAXBUtils */
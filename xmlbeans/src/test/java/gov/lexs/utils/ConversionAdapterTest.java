/*
 * Copyright Georgia Tech Research Institute
 *     Sep 28, 2011
 * 
 *     All rights reserved.
 */

package gov.lexs.utils;

import gov.lexs.AbstractTest;
import gov.ulex.publishdiscover.v20.XmlDoPublishDocumentBean;
import java.io.File;
import junit.framework.Test;
import junit.framework.TestSuite;
import org.apache.xmlbeans.XmlObject;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author es130
 */
public class ConversionAdapterTest extends XMLTestCase {

    private String XML_LOCATION = "src/test/resources/xml/PD-samples/";

    @Override
    public void setUp() throws Exception{
        XMLUnit.setIgnoreComments(true);
        XMLUnit.setIgnoreWhitespace(true);
        XMLUnit.setNormalize(true);
        XMLUnit.setNormalizeWhitespace(true);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ConversionAdapterTest.class  );
    }

    /**
     * test converting from XMLBeans to JDOM
     */
    public void testDoPublishConversion(){
    	String xmlFilePath = XML_LOCATION + "doPublish-all-fields.xml";

        //Create the XMLBeans object
        File allFieldsFile = new File( xmlFilePath );
        XmlDoPublishDocumentBean allFieldsDoc = null;
        try{
            allFieldsDoc = XmlDoPublishDocumentBean.Factory.parse( allFieldsFile );
        }
        catch(Exception e){
            e.printStackTrace();
        }

        //Now convert that object to a JDOM Element
        ConversionAdapterImpl converter = new ConversionAdapterImpl();
        Element jdomElement = converter.getJDOMElement(allFieldsDoc);

        //check and see if the JDOM and XMLBeans objects contain the same search query
        String xmlBeanDoPublish = allFieldsDoc.xmlText();//.getDoPublish().getPublishMessageContainer().getPublishMessageArray(0).xmlText();
        //remove the openning comments
        /*int startIndex = xmlBeanDoPublish.indexOf("<!--");
        int endIndex = xmlBeanDoPublish.indexOf("-->");
        String openningComment = xmlBeanDoPublish.substring(startIndex, endIndex+3);
        xmlBeanDoPublish = xmlBeanDoPublish.replace(openningComment, "");
        */

        Namespace namespace = Namespace.getNamespace("http://usdoj.gov/leisp/lexs/3.1");
        XMLOutputter outputter = new XMLOutputter();
        String jdomSearchQuery = outputter.outputString(jdomElement);

        //TODO: Could do a better check here, but will work for now
        //Check that the do publish message of the converted XMLBeans object is
        //the same as the do publish message of the original XMLBeans object.
        //assertTrue( xmlBeanDoPublish.equals(jdomSearchQuery));
        try{
        	assertXMLEqual(xmlBeanDoPublish, jdomSearchQuery);
        }
        catch(Exception e){
            System.err.println( e.getMessage() );
        }

        //now convert back from JDOM to XMLBeans
        XmlObject convertedXMLBeansObj = converter.getXMLBeansObject(jdomElement);
        //the coverted object should be the same as the original
        String convertedXmlBeanQuery = ((XmlDoPublishDocumentBean)convertedXMLBeansObj).xmlText();//.getDoPublish().getPublishMessageContainer().getPublishMessageArray(0).xmlText();

        //TODO: Could do a better check here, but will work for now
        //Check that the text search query of the converted JDOM element is the
        //same as the text search query of the original XMLBeans object.
        try{
        	assertXMLEqual(xmlBeanDoPublish, convertedXmlBeanQuery);
        }
        catch(Exception e){
            System.err.println( e.getMessage() );
        }
    }

}

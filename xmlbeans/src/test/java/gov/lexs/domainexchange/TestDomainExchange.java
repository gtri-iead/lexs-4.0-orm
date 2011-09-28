/*
 * Copyright Georgia Tech Research Institute
 *     Sep 27, 2011
 * 
 *     All rights reserved.
 */

package gov.lexs.domainexchange;

import gov.lexs.AbstractTest;
import gov.ulex.domainexchange.v20.XmlDomainActionDocumentBean;
import gov.ulex.domainexchange.v20.XmlDomainRequestDocumentBean;
import gov.ulex.domainexchange.v20.XmlDomainResponseDocumentBean;
import java.io.File;
import java.util.ArrayList;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlOptions;

/**
 *
 * @author es130
 */
public class TestDomainExchange extends AbstractTest {

    private String DE_DIR = "src/test/resources/xml/DE-samples";

    public void testDomainAction() throws Exception{
        System.out.println("Entering testDomainAction");
        String filePath = DE_DIR + "/domainAction.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlDomainActionDocumentBean generatedBean = null;
        try{
            generatedBean = XmlDomainActionDocumentBean.Factory.parse( file );
        }
        catch(Exception e){
            e.printStackTrace();
            createdBean = false;
        }
        assertTrue(createdBean);

        XmlOptions validateOptions = new XmlOptions();
        ArrayList errorList = new ArrayList();
        validateOptions.setErrorListener(errorList);
        boolean isValid = generatedBean.validate(validateOptions);
        if( !isValid ){
            for (int i = 0; i < errorList.size(); i++){
                XmlError error = (XmlError)errorList.get(i);
                System.out.println("\n");
                System.out.println("Message: " + error.getMessage() + "\n");
                System.out.println("Location of invalid XML: " +
                error.getCursorLocation().xmlText() + "\n");
            }
        }
        assertTrue( isValid );

        String fileString = getStringFromFile( filePath );
        assertXMLEqual(  fileString, generatedBean.xmlText() );
        System.out.println("Exiting testDomainAction");
    }

    public void testGetDomainRequestGfipm() throws Exception{
        System.out.println("Entering testGetDomainRequestGfipm");
        String filePath = DE_DIR + "/getDomainRequest-gfipm.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlDomainRequestDocumentBean generatedBean = null;
        try{
            generatedBean = XmlDomainRequestDocumentBean.Factory.parse( file );
        }
        catch(Exception e){
            e.printStackTrace();
            createdBean = false;
        }
        assertTrue(createdBean);

        XmlOptions validateOptions = new XmlOptions();
        ArrayList errorList = new ArrayList();
        validateOptions.setErrorListener(errorList);
        boolean isValid = generatedBean.validate(validateOptions);
        if( !isValid ){
            for (int i = 0; i < errorList.size(); i++){
                XmlError error = (XmlError)errorList.get(i);
                System.out.println("\n");
                System.out.println("Message: " + error.getMessage() + "\n");
                System.out.println("Location of invalid XML: " +
                error.getCursorLocation().xmlText() + "\n");
            }
        }
        assertTrue( isValid );

        String fileString = getStringFromFile( filePath );
        assertXMLEqual(  fileString, generatedBean.xmlText() );
        System.out.println("Exiting testGetDomainRequestGfipm");
    }

    public void testGetDomainRequest() throws Exception{
        System.out.println("Entering testGetDomainRequest");
        String filePath = DE_DIR + "/getDomainRequest.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlDomainRequestDocumentBean generatedBean = null;
        try{
            generatedBean = XmlDomainRequestDocumentBean.Factory.parse( file );
        }
        catch(Exception e){
            e.printStackTrace();
            createdBean = false;
        }
        assertTrue(createdBean);

        XmlOptions validateOptions = new XmlOptions();
        ArrayList errorList = new ArrayList();
        validateOptions.setErrorListener(errorList);
        boolean isValid = generatedBean.validate(validateOptions);
        if( !isValid ){
            for (int i = 0; i < errorList.size(); i++){
                XmlError error = (XmlError)errorList.get(i);
                System.out.println("\n");
                System.out.println("Message: " + error.getMessage() + "\n");
                System.out.println("Location of invalid XML: " +
                error.getCursorLocation().xmlText() + "\n");
            }
        }
        assertTrue( isValid );

        String fileString = getStringFromFile( filePath );
        assertXMLEqual(  fileString, generatedBean.xmlText() );
        System.out.println("Exiting testGetDomainRequest");
    }

    public void testGetDomainResponse() throws Exception{
        System.out.println("Entering testGetDomainResponse");
        String filePath = DE_DIR + "/getDomainResponse.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlDomainResponseDocumentBean generatedBean = null;
        try{
            generatedBean = XmlDomainResponseDocumentBean.Factory.parse( file );
        }
        catch(Exception e){
            e.printStackTrace();
            createdBean = false;
        }
        assertTrue(createdBean);

        XmlOptions validateOptions = new XmlOptions();
        ArrayList errorList = new ArrayList();
        validateOptions.setErrorListener(errorList);
        boolean isValid = generatedBean.validate(validateOptions);
        if( !isValid ){
            for (int i = 0; i < errorList.size(); i++){
                XmlError error = (XmlError)errorList.get(i);
                System.out.println("\n");
                System.out.println("Message: " + error.getMessage() + "\n");
                System.out.println("Location of invalid XML: " +
                error.getCursorLocation().xmlText() + "\n");
            }
        }
        assertTrue( isValid );

        String fileString = getStringFromFile( filePath );
        assertXMLEqual(  fileString, generatedBean.xmlText() );
        System.out.println("Exiting testGetDomainResponse");
    }
}

/*
 * Copyright Georgia Tech Research Institute
 *     Sep 27, 2011
 * 
 *     All rights reserved.
 */

package gov.lexs.searchretrieve;

import gov.lexs.AbstractTest;
import gov.ulex.searchretrieve.v20.XmlDoAttachmentSearchRequestDocumentBean;
import gov.ulex.searchretrieve.v20.XmlDoDataItemMetadataSearchRequestDocumentBean;
import gov.ulex.searchretrieve.v20.XmlDoSearchResponseDocumentBean;
import gov.ulex.searchretrieve.v20.XmlDoStructuredSearchRequestDocumentBean;
import gov.ulex.searchretrieve.v20.XmlDoTextSearchRequestDocumentBean;
import gov.ulex.searchretrieve.v20.XmlGetAttachmentRequestDocumentBean;
import gov.ulex.searchretrieve.v20.XmlGetAttachmentResponseDocumentBean;
import gov.ulex.searchretrieve.v20.XmlGetAvailabilityRequestDocumentBean;
import gov.ulex.searchretrieve.v20.XmlGetAvailabilityResponseDocumentBean;
import gov.ulex.searchretrieve.v20.XmlGetCapabilitiesRequestDocumentBean;
import gov.ulex.searchretrieve.v20.XmlGetCapabilitiesResponseDocumentBean;
import gov.ulex.searchretrieve.v20.XmlGetDataItemRequestDocumentBean;
import gov.ulex.searchretrieve.v20.XmlGetDataItemResponseDocumentBean;
import gov.ulex.searchretrieve.v20.XmlGetDataItemWithAttachmentsRequestDocumentBean;
import gov.ulex.searchretrieve.v20.XmlGetDataItemWithAttachmentsResponseDocumentBean;
import gov.ulex.searchretrieve.v20.XmlGetDataOwnersRequestDocumentBean;
import gov.ulex.searchretrieve.v20.XmlGetDataOwnersResponseDocumentBean;
import gov.ulex.searchretrieve.v20.XmlGetRenderedDataItemRequestDocumentBean;
import java.io.File;
import java.util.ArrayList;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlOptions;

/**
 *
 * @author es130
 */
public class TestSearchRetrieve extends AbstractTest{
    
    private String SR_DIR = "src/test/resources/xml/SR-samples";
    
    public void testDoAttachmentSearchRequest() throws Exception{
        System.out.println("Entering testDoAttachmentSearchRequest");
        String filePath = SR_DIR + "/doAttachmentSearchRequest.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlDoAttachmentSearchRequestDocumentBean generatedBean = null;
        try{
            generatedBean = XmlDoAttachmentSearchRequestDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testDoAttachmentSearchRequest");
    }


    public void testDoAttachmentSearchResponse() throws Exception{
        System.out.println("Entering testDoAttachmentSearchResponse");
        String filePath = SR_DIR + "/doAttachmentSearchResponse.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlDoSearchResponseDocumentBean generatedBean = null;
        try{
            generatedBean = XmlDoSearchResponseDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testDoAttachmentSearchResponse");
    }

    public void testDoDataItemMetadataSearchRequest() throws Exception{
        System.out.println("Entering testDoDataItemMetadataSearchRequest");
        String filePath = SR_DIR + "/doDataItemMetadataSearchRequest.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlDoDataItemMetadataSearchRequestDocumentBean generatedBean = null;
        try{
            generatedBean = XmlDoDataItemMetadataSearchRequestDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testDoDataItemMetadataSearchRequest");
    }

    public void testDoDataItemMetadataSearchResponse() throws Exception{
        System.out.println("Entering testDoDataItemMetadataSearchResponse");
        String filePath = SR_DIR + "/doDataItemMetadataSearchResponse.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlDoSearchResponseDocumentBean generatedBean = null;
        try{
            generatedBean = XmlDoSearchResponseDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testDoDataItemMetadataSearchResponse");
    }

    public void testDoStructuredSearchRequestAttributesSearch() throws Exception{
        System.out.println("Entering testDoStructuredSearchRequestAttributesSearch");
        String filePath = SR_DIR + "/doStructuredSearchRequest-attributes-search.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlDoStructuredSearchRequestDocumentBean generatedBean = null;
        try{
            generatedBean = XmlDoStructuredSearchRequestDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testDoStructuredSearchRequestAttributesSearch");
    }

    public void testDoStructuredSearchRequestMetadata() throws Exception{
        System.out.println("Entering testDoStructuredSearchRequestMetadata");
        String filePath = SR_DIR + "/doStructuredSearchRequest-metadata.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlDoStructuredSearchRequestDocumentBean generatedBean = null;
        try{
            generatedBean = XmlDoStructuredSearchRequestDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testDoStructuredSearchRequestMetadata");
    }

    public void testDoStructuredSearchRequestMultipleEntities() throws Exception{
        System.out.println("Entering testDoStructuredSearchRequestMultipleEntities");
        String filePath = SR_DIR + "/doStructuredSearchRequest-multiple-entities.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlDoStructuredSearchRequestDocumentBean generatedBean = null;
        try{
            generatedBean = XmlDoStructuredSearchRequestDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testDoStructuredSearchRequestMultipleEntities");
    }

    public void testDoStructuredSearchRequestWithOptionalFields() throws Exception{
        System.out.println("Entering testDoStructuredSearchRequestWithOptionalFields");
        String filePath = SR_DIR + "/doStructuredSearchRequest-with-optional-fields.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlDoStructuredSearchRequestDocumentBean generatedBean = null;
        try{
            generatedBean = XmlDoStructuredSearchRequestDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testDoStructuredSearchRequestWithOptionalFields");
    }

    public void testDoStructuredSearchRequest() throws Exception{
        System.out.println("Entering testDoStructuredSearchRequest");
        String filePath = SR_DIR + "/doStructuredSearchRequest-attributes-search.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlDoStructuredSearchRequestDocumentBean generatedBean = null;
        try{
            generatedBean = XmlDoStructuredSearchRequestDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testDoStructuredSearchRequest");
    }

    public void testDoStructuredSearchResponseMetadata() throws Exception{
        System.out.println("Entering testDoStructuredSearchResponseMetadata");
        String filePath = SR_DIR + "/doStructuredSearchResponse-metadata.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlDoSearchResponseDocumentBean generatedBean = null;
        try{
            generatedBean = XmlDoSearchResponseDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testDoStructuredSearchResponseMetadata");
    }

    public void testDoStructuredSearchResponseNoHits() throws Exception{
        System.out.println("Entering testDoStructuredSearchResponseNoHits");
        String filePath = SR_DIR + "/doStructuredSearchResponse-no-hits.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlDoSearchResponseDocumentBean generatedBean = null;
        try{
            generatedBean = XmlDoSearchResponseDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testDoStructuredSearchResponseNoHits");
    }

    public void testDoStructuredSearchResponse() throws Exception{
        System.out.println("Entering testDoStructuredSearchResponse");
        String filePath = SR_DIR + "/doStructuredSearchResponse.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlDoSearchResponseDocumentBean generatedBean = null;
        try{
            generatedBean = XmlDoSearchResponseDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testDoStructuredSearchResponse");
    }

    public void testDoTextSearchRequest() throws Exception{
        System.out.println("Entering testDoTextSearchRequest");
        String filePath = SR_DIR + "/doTextSearchRequest.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlDoTextSearchRequestDocumentBean generatedBean = null;
        try{
            generatedBean = XmlDoTextSearchRequestDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testDoTextSearchRequest");
    }

    public void testDoTextSearchResponse() throws Exception{
        System.out.println("Entering testDoTextSearchResponse");
        String filePath = SR_DIR + "/doTextSearchResponse.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlDoSearchResponseDocumentBean generatedBean = null;
        try{
            generatedBean = XmlDoSearchResponseDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testDoTextSearchResponse");
    }

    public void testGetAttachmentRequest() throws Exception{
        System.out.println("Entering testGetAttachmentRequest");
        String filePath = SR_DIR + "/getAttachmentRequest.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlGetAttachmentRequestDocumentBean generatedBean = null;
        try{
            generatedBean = XmlGetAttachmentRequestDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testGetAttachmentRequest");
    }

    public void testGetAttachmentResponse() throws Exception{
        System.out.println("Entering testGetAttachmentResponse");
        String filePath = SR_DIR + "/getAttachmentResponse.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlGetAttachmentResponseDocumentBean generatedBean = null;
        try{
            generatedBean = XmlGetAttachmentResponseDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testGetAttachmentResponse");
    }

    public void testGetAvailabilityRequest() throws Exception{
        System.out.println("Entering testGetAvailabilityRequest");
        String filePath = SR_DIR + "/getAvailabilityRequest.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlGetAvailabilityRequestDocumentBean generatedBean = null;
        try{
            generatedBean = XmlGetAvailabilityRequestDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testGetAvailabilityRequest");
    }
    public void testGetAvailabilityResponse() throws Exception{
        System.out.println("Entering testGetAvailabilityResponse");
        String filePath = SR_DIR + "/getAvailabilityResponse.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlGetAvailabilityResponseDocumentBean generatedBean = null;
        try{
            generatedBean = XmlGetAvailabilityResponseDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testGetAvailabilityResponse");
    }

    public void testGetCapabilitiesRequest() throws Exception{
        System.out.println("Entering testGetCapabilitiesRequest");
        String filePath = SR_DIR + "/getCapabilitiesRequest.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlGetCapabilitiesRequestDocumentBean generatedBean = null;
        try{
            generatedBean = XmlGetCapabilitiesRequestDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testGetCapabilitiesRequest");
    }

    public void testGetCapabilitiesResponse() throws Exception{
        System.out.println("Entering testGetCapabilitiesResponse");
        String filePath = SR_DIR + "/getCapabilitiesResponse.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlGetCapabilitiesResponseDocumentBean generatedBean = null;
        try{
            generatedBean = XmlGetCapabilitiesResponseDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testGetCapabilitiesResponse");
    }
    public void testGetDataItemRequest() throws Exception{
        System.out.println("Entering testGetDataItemRequest");
        String filePath = SR_DIR + "/getDataItemRequest.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlGetDataItemRequestDocumentBean generatedBean = null;
        try{
            generatedBean = XmlGetDataItemRequestDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testGetDataItemRequest");
    }

    public void testGetDataItemResponse() throws Exception{
        System.out.println("Entering testGetDataItemResponse");
        String filePath = SR_DIR + "/getDataItemResponse.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlGetDataItemResponseDocumentBean generatedBean = null;
        try{
            generatedBean = XmlGetDataItemResponseDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testGetDataItemResponse");
    }

    public void testGetDataItemWithAttachmentsRequest() throws Exception{
        System.out.println("Entering testGetDataItemWithAttachmentsRequest");
        String filePath = SR_DIR + "/getDataItemWithAttachmentsRequest.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlGetDataItemWithAttachmentsRequestDocumentBean generatedBean = null;
        try{
            generatedBean = XmlGetDataItemWithAttachmentsRequestDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testGetDataItemWithAttachmentsRequest");
    }

    public void testGetDataItemWithAttachmentsResponse() throws Exception{
        System.out.println("Entering testGetDataItemWithAttachmentsResponse");
        String filePath = SR_DIR + "/getDataItemWithAttachmentsResponse.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlGetDataItemWithAttachmentsResponseDocumentBean generatedBean = null;
        try{
            generatedBean = XmlGetDataItemWithAttachmentsResponseDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testGetDataItemWithAttachmentsResponse");
    }

    public void testGetDataOwnersRequest() throws Exception{
        System.out.println("Entering testGetDataOwnersRequest");
        String filePath = SR_DIR + "/getDataOwnersRequest.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlGetDataOwnersRequestDocumentBean generatedBean = null;
        try{
            generatedBean = XmlGetDataOwnersRequestDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testGetDataOwnersRequest");
    }

    public void testGetDataOwnersResponse() throws Exception{
        System.out.println("Entering testGetDataOwnersResponse");
        String filePath = SR_DIR + "/getDataOwnersResponse.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlGetDataOwnersResponseDocumentBean generatedBean = null;
        try{
            generatedBean = XmlGetDataOwnersResponseDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testGetDataOwnersRequest");
    }

    public void testGetRenderedDataItemRequest() throws Exception{
        System.out.println("Entering testGetRenderedDataItemRequest");
        String filePath = SR_DIR + "/getRenderedDataItemRequest.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlGetRenderedDataItemRequestDocumentBean generatedBean = null;
        try{
            generatedBean = XmlGetRenderedDataItemRequestDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testGetRenderedDataItemRequest");
    }

    public void testGetRenderedDataItemResponse() throws Exception{
        System.out.println("Entering testGetRenderedDataItemResponse");
        String filePath = SR_DIR + "/getRenderedDataItemResponse.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlGetAttachmentResponseDocumentBean generatedBean = null;
        try{
            generatedBean = XmlGetAttachmentResponseDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testGetRenderedDataItemResponse");
    }
}

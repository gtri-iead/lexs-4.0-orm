/*
 * Copyright Georgia Tech Research Institute
 *     Sep 28, 2011
 * 
 *     All rights reserved.
 */

package gov.lexs.subscribenotify;

import gov.lexs.AbstractTest;
import gov.ulex.searchretrieve.v20.XmlGetCapabilitiesRequestDocumentBean;
import gov.ulex.searchretrieve.v20.XmlGetCapabilitiesResponseDocumentBean;
import java.io.File;
import java.util.ArrayList;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlOptions;
import org.oasisopen.docs.wsn.b2.XmlNotifyDocumentBean;
import org.oasisopen.docs.wsn.b2.XmlRenewDocumentBean;
import org.oasisopen.docs.wsn.b2.XmlRenewResponseDocumentBean;
import org.oasisopen.docs.wsn.b2.XmlSubscribeCreationFailedFaultDocumentBean;
import org.oasisopen.docs.wsn.b2.XmlSubscribeDocumentBean;
import org.oasisopen.docs.wsn.b2.XmlSubscribeResponseDocumentBean;
import org.oasisopen.docs.wsn.b2.XmlUnsubscribeDocumentBean;
import org.oasisopen.docs.wsn.b2.XmlUnsubscribeResponseDocumentBean;

/**
 *
 * @author es130
 */
public class TestSubscribeNotify extends AbstractTest{

    private String SN_DIR = "src/test/resources/xml/SN-samples";

    public void testNotifyDataItemRetrievalSubscriptionNotification() throws Exception{
        System.out.println("Entering testNotifyDataItemRetrievalSubscriptionNotification");
        String filePath = SN_DIR + "/Notify-DataItemRetrievalSubscriptionNotification-xinclude.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlNotifyDocumentBean generatedBean = null;
        try{
            generatedBean = XmlNotifyDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testNotifyDataItemRetrievalSubscriptionNotification");
    }

    public void testNotifyDataItemSearchSubscriptionNotification() throws Exception{
        System.out.println("Entering testNotifyDataItemSearchSubscriptionNotification");
        String filePath = SN_DIR + "/Notify-DataItemSearchSubscriptionNotification-xinclude.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlNotifyDocumentBean generatedBean = null;
        try{
            generatedBean = XmlNotifyDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testNotifyDataItemSearchSubscriptionNotification");
    }

    public void testNotifyIdenticalSearchSubscriptionNotification() throws Exception{
        System.out.println("Entering testNotifyIdenticalSearchSubscriptionNotification");
        String filePath = SN_DIR + "/Notify-IdenticalSearchSubscriptionNotification-xinclude.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlNotifyDocumentBean generatedBean = null;
        try{
            generatedBean = XmlNotifyDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testNotifyIdenticalSearchSubscriptionNotification");
    }

    public void testNotifyMatchSubscriptionNotification() throws Exception{
        System.out.println("Entering testNotifyMatchSubscriptionNotification");
        String filePath = SN_DIR + "/Notify-MatchSubscriptionNotification-xinclude.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlNotifyDocumentBean generatedBean = null;
        try{
            generatedBean = XmlNotifyDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testNotifyMatchSubscriptionNotification");
    }

    public void testNotifyTopicSubscriptionNotification() throws Exception{
        System.out.println("Entering testNotifyTopicSubscriptionNotification");
        String filePath = SN_DIR + "/Notify-TopicSubscriptionNotification-xinclude.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlNotifyDocumentBean generatedBean = null;
        try{
            generatedBean = XmlNotifyDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testNotifyTopicSubscriptionNotification");
    }

    public void testRenew() throws Exception{
        System.out.println("Entering testRenew");
        String filePath = SN_DIR + "/Renew-xinclude.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlRenewDocumentBean generatedBean = null;
        try{
            generatedBean = XmlRenewDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testRenew");
    }

    public void testRenewResponse() throws Exception{
        System.out.println("Entering testRenewResponse");
        String filePath = SN_DIR + "/RenewResponse-xinclude.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlRenewResponseDocumentBean generatedBean = null;
        try{
            generatedBean = XmlRenewResponseDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testRenewResponse");
    }

    public void testSubscribeDataItemRetrievalSubscription() throws Exception{
        System.out.println("Entering testSubscribeDataItemRetrievalSubscription");
        String filePath = SN_DIR + "/Subscribe-DataItemRetrievalSubscription-xinclude.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlSubscribeDocumentBean generatedBean = null;
        try{
            generatedBean = XmlSubscribeDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testSubscribeDataItemRetrievalSubscription");
    }

    public void testSubscribeDataItemSearchSubscription() throws Exception{
        System.out.println("Entering testSubscribeDataItemSearchSubscription");
        String filePath = SN_DIR + "/Subscribe-DataItemSearchSubscription-xinclude.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlSubscribeDocumentBean generatedBean = null;
        try{
            generatedBean = XmlSubscribeDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testSubscribeDataItemSearchSubscription");
    }

    public void testSubscribeIdenticalSearchSubscription() throws Exception{
        System.out.println("Entering testSubscribeIdenticalSearchSubscription");
        String filePath = SN_DIR + "/Subscribe-IdenticalSearchSubscription-xinclude.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlSubscribeDocumentBean generatedBean = null;
        try{
            generatedBean = XmlSubscribeDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testSubscribeIdenticalSearchSubscription");
    }

    public void testMatchSubscription() throws Exception{
        System.out.println("Entering testMatchSubscription");
        String filePath = SN_DIR + "/Subscribe-MatchSubscription-xinclude.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlSubscribeDocumentBean generatedBean = null;
        try{
            generatedBean = XmlSubscribeDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testMatchSubscription");
    }

    public void testSimilarSearchSubscription() throws Exception{
        System.out.println("Entering testSimilarSearchSubscription");
        String filePath = SN_DIR + "/Subscribe-SimilarSearchSubscription-xinclude.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlSubscribeDocumentBean generatedBean = null;
        try{
            generatedBean = XmlSubscribeDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testSimilarSearchSubscription");
    }

    public void testTopicSubscription() throws Exception{
        System.out.println("Entering testSimilarSearchSubscription");
        String filePath = SN_DIR + "/Subscribe-TopicSubscription-xinclude.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlSubscribeDocumentBean generatedBean = null;
        try{
            generatedBean = XmlSubscribeDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testTopicSubscription");
    }

    public void testSubscribeResponse() throws Exception{
        System.out.println("Entering testSubscribeResponse");
        String filePath = SN_DIR + "/SubscribeResponse-xinclude.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlSubscribeResponseDocumentBean generatedBean = null;
        try{
            generatedBean = XmlSubscribeResponseDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testSubscribeResponse");
    }

    public void testSubscribeResponseFault() throws Exception{
        System.out.println("Entering testSubscribeResponseFault");
        String filePath = SN_DIR + "/SubscribeResponseFault-xinclude.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlSubscribeCreationFailedFaultDocumentBean generatedBean = null;
        try{
            generatedBean = XmlSubscribeCreationFailedFaultDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testSubscribeResponseFault");
    }

    public void testUnsubscribe() throws Exception{
        System.out.println("Entering testUnsubscribe");
        String filePath = SN_DIR + "/Unsubscribe-xinclude.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlUnsubscribeDocumentBean generatedBean = null;
        try{
            generatedBean = XmlUnsubscribeDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testUnsubscribe");
    }

    public void testUnsubscribeResponse() throws Exception{
        System.out.println("Entering testUnsubscribeResponse");
        String filePath = SN_DIR + "/UnsubscribeResponse-xinclude.xml";
        File file = new File( filePath );
        boolean createdBean = true;

        XmlUnsubscribeResponseDocumentBean generatedBean = null;
        try{
            generatedBean = XmlUnsubscribeResponseDocumentBean.Factory.parse( file );
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
        System.out.println("Exiting testUnsubscribeResponse");
    }

    public void testGetCapabilitiesRequest() throws Exception{
        System.out.println("Entering testGetCapabilitiesRequest");
        String filePath = SN_DIR + "/getCapabilitiesRequest-xinclude.xml";
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
        String filePath = SN_DIR + "/getCapabilitiesResponse-xinclude.xml";
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
}

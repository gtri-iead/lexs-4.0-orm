/*
 * Copyright Georgia Tech Research Institute
 *     Sep 27, 2011
 * 
 *     All rights reserved.
 */

package gov.lexs.publishdiscover.v40;

import gov.lexs.AbstractTest;
import gov.ulex.publishdiscover.v20.XmlDoPublishDocumentBean;
import java.io.File;

/**
 *
 * @author es130
 */
public class TestDoPublishRequest extends AbstractTest {
    public static String PD_ALL_FIELDS = "src/test/resources/xml/PD-samples/doPublish-all-fields.xml";

    public void testAllFields() throws Exception {
        File allFieldsFile = new File( PD_ALL_FIELDS );
        boolean createdBean = true;
        XmlDoPublishDocumentBean allFieldsDoc = null;
        try{
            allFieldsDoc = XmlDoPublishDocumentBean.Factory.parse( allFieldsFile );
        }
        catch(Exception e){
            e.printStackTrace();
            createdBean = false;
        }
        assertTrue(createdBean);
        assertTrue(allFieldsDoc.validate());

        String fileString = getStringFromFile( PD_ALL_FIELDS );
        assertXMLEqual(  fileString, allFieldsDoc.xmlText() );
    }

}

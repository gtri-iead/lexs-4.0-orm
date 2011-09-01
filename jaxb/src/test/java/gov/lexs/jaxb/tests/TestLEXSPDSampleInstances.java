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

import java.io.File;
import org.junit.Test;

/**
 * FIXME Describe this type.
 * <br/><br/>
 * @author brad
 * @date Dec 2, 2010
 */
public class TestLEXSPDSampleInstances extends AbstractLEXSSampleInstanceTest {
    public static final String BASE_DIR = "./src/test/resources/lexs-4.0-samples/xml/PD-samples";
    //==========================================================================
    //  Tests
    //==========================================================================
    @Test
    public void testDoPublishATF_PDSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR+"/doPublish-ATF.xml"));
    }//end testDoPublishATF_PDSampleInstance()

    @Test
    public void testDoPublishAcknowledgeResponse_PDSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR+"/doPublish-AcknowledgeResponse.xml"));
    }//end testDoPublishAcknowledgeResponse_PDSampleInstance()

    @Test
    public void testDoPublishAcknowledgedRequest_PDSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR+"/doPublish-AcknowledgedRequest.xml"));
    }//end testDoPublishAcknowledgedRequest_PDSampleInstance()

    @Test
    public void testDoPublishBOPITSCallList_PDSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR+"/doPublish-BOP-ITS-Call-List.xml"));
    }//end testDoPublishBOPITSCallList_PDSampleInstance()

    @Test
    public void testDoPublishBOPITSCallLog_PDSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR+"/doPublish-BOP-ITS-Call-Log.xml"));
    }//end testDoPublishBOPITSCallLog_PDSampleInstance()

    @Test
    public void testDoPublishAllFields_PDSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR+"/doPublish-all-fields.xml"));
    }//end testDoPublishAllFields_PDSampleInstance()

    @Test
    public void testdoPublishDetailed_PDSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR+"/doPublish-detailed.xml"));
    }//end testdoPublishDetailed_PDSampleInstance()

    @Test
    public void testDoPublishIcism_PDSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR+"/doPublish-icism.xml"));
    }//end testDoPublishIcism_PDSampleInstance()

    @Test
    public void testDoPublishIdentitiesWithPrimary_PDSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR+"/doPublish-identities-with-primary.xml"));
    }//end testDoPublishIdentitiesWithPrimary_PDSampleInstance()

    @Test
    public void testDoPublishIdentitiesWithoutPrimary_PDSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR+"/doPublish-identities-without-primary.xml"));
    }//end testDoPublishIdentitiesWithoutPrimary_PDSampleInstance()

    @Test
    public void testdoPublishMultipleMessages_PDSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR+"/doPublish-multiple-messages.xml"));
    }//end testdoPublishMultipleMessages_PDSampleInstance()

    @Test
    public void testDoPublishMultiplePackages_PDSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR+"/doPublish-multiple-packages.xml"));
    }//end testDoPublishMultiplePackages_PDSampleInstance()

    @Test
    public void testDoPublishNonDigestAware_PDSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR+"/doPublish-non-digest-aware.xml"));
    }//end testDoPublishNonDigestAware_PDSampleInstance()

    @Test
    public void testDoPublishTwoPayloads_PDSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR+"/doPublish-two-payloads.xml"));
    }//end testDoPublishTwoPayloads_PDSampleInstance()

    @Test
    public void testDoPublishWithCommunity_PDSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR+"/doPublish-with-community.xml"));
    }//end testDoPublishWithCommunity_PDSampleInstance()

    @Test
    public void testDoPublish_PDSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR+"/doPublish.xml"));
    }//end testDoPublish_PDSampleInstance()


    
}/* end class TestLEXSPDSampleInstances */
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
public class TestLEXSSRSampleInstances extends AbstractLEXSSampleInstanceTest {
    public static final String BASE_DIR = "./src/test/resources/lexs-4.0-samples/xml/SR-samples";
    //==========================================================================
    //  Tests
    //==========================================================================
    @Test
    public void testGetCapabilitiesRequest_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/getCapabilitiesRequest.xml"));
    }

    @Test
    public void testGetAttachmentResponse_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/getAttachmentResponse.xml"));
    }

    @Test
    public void testGetCapabilitiesResponse_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/getCapabilitiesResponse.xml"));
    }

    @Test
    public void testDoSearchResponseMetadata_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/doSearchResponse-metadata.xml"));
    }

    @Test
    public void test_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/doStructuredSearchResponse-no-hits.xml"));
    }

    @Test
    public void testDoStructuredSearchRequestMetadata_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/doStructuredSearchRequest-metadata.xml"));
    }

    @Test
    public void testDoStructuredSearchResponse_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/doStructuredSearchResponse.xml"));
    }

    @Test
    public void testDoStructuredSearchRequest_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/doStructuredSearchRequest.xml"));
    }

    @Test
    public void testGetAvailabilityResponse_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/getAvailabilityResponse.xml"));
    }

    @Test
    public void testGetAvailabilityRequest_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/getAvailabilityRequest.xml"));
    }

    @Test
    public void testGetAttachmentRequest_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/getAttachmentRequest.xml"));
    }

    @Test
    public void testGetDataOwnersRequest_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/getDataOwnersRequest.xml"));
    }

    @Test
    public void testDoStructuredSearchRequestMultipleEntities_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/doStructuredSearchRequest-multiple-entities.xml"));
    }

    @Test
    public void testGetDataOwnersResponse_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/getDataOwnersResponse.xml"));
    }

    @Test
    public void testGetDataItemRequest_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/getDataItemRequest.xml"));
    }

    @Test
    public void testDoStructuredSearchRequestWithOptionalFields_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/doStructuredSearchRequest-with-optional-fields.xml"));
    }

    @Test
    public void testDoTextSearchRequest_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/doTextSearchRequest.xml"));
    }

    @Test
    public void testDoSearchAttachment_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/doSearch-Attachment.xml"));
    }

    @Test
    public void testDoTextSearchResponse_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/doTextSearchResponse.xml"));
    }

    @Test
    public void testGetDataItemWithAttachmentRequest_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/getDataItemWithAttachmentsRequest.xml"));
    }

    @Test
    public void testGetDataItemResponse_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/getDataItemResponse.xml"));
    }

    @Test
    public void testDoSearchAttachmentResponse_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/doSearch-Attachment-Response.xml"));
    }

    @Test
    public void testGetDataItemWithAttachmentsResponse_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/getDataItemWithAttachmentsResponse.xml"));
    }

    @Test
    public void testDoStructuredSearchRequestAttributesSearch_SRSampleInstance() throws Exception {
        this.validateXmlFile(new File(BASE_DIR + "/doStructuredSearchRequest-attributes-search.xml"));
    }


}/* end class TestLEXSSRSampleInstances */
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

import gov.lexs.v4_0.JAXBUtils;
import gov.lexs.v4_0.jaxb.LexsDigestType;
import java.io.File;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * FIXME Describe this type.
 * <br/><br/>
 * @author brad
 * @date Dec 14, 2010
 */
public class TestXsiNilAttributeCase extends AbstractLEXSSampleInstanceTest {
    //==========================================================================
    //  Tests
    //==========================================================================
    @Test
    public void testXsiNilWithAttributeCaseInstance() throws Exception {

        File xmlFile =
                new File("./src/test/resources/lexs-4.0-samples/xsi-nil-attribute-case.xml");
        
        logger.info("Testing file {}...", xmlFile);
        Object object = JAXBUtils.unmarshal(xmlFile);
        assertNotNull(object);
        assertTrue( object instanceof JAXBElement );
        JAXBElement jaxbe = (JAXBElement) object;
        object = jaxbe.getValue();
        assertNotNull(object);
        assertTrue( object instanceof LexsDigestType );
        LexsDigestType digest = (LexsDigestType) object;
        // TODO Validate digest object in some way.

        File tempDir = new File("./target/jaxb-marshalling-results");
        tempDir.mkdirs();
        File tempFile = File.createTempFile(xmlFile.getName(), ".xml", tempDir);
        JAXBElement<LexsDigestType> outputObject =
                new JAXBElement<LexsDigestType>(
                    new QName("http://lexs.gov/lexs/4.0", "Digest"), LexsDigestType.class, digest);
        JAXBUtils.marshall(outputObject, tempFile);
        try{
            validateAgainstLEXS40Schemas( tempFile );
        }catch(Exception e){
            logger.warn("File "+xmlFile+" failed to validate after going through object transform.", e);
            fail("File "+xmlFile+" did not pass schema validation after jaxb!");
        }
        assertXmlEquivalence( xmlFile, tempFile );
        logger.info("Successfully used JAXB to round-trip and validate file {}!", xmlFile);
    }//end testXsiNilWithAttributeCaseInstance()

}/* end class TestXsiNilAttributeCase */
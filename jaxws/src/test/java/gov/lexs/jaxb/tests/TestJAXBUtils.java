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
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * FIXME Describe this type.
 * <br/><br/>
 * @author brad
 * @date Dec 2, 2010
 */
public class TestJAXBUtils extends AbstractTest {
    //==========================================================================
    //  Tests
    //==========================================================================
    @Test
    public void testJAXBContextInitialized() throws Exception {
        logger.info("Testing the creation of the JAXBContext...");
        logger.debug("Creating marshaller...");
        Marshaller marshaller = JAXBUtils.createMarshaller();
        assertNotNull(marshaller);
        logger.debug("Creating unmarshaller...");
        Unmarshaller unmarshaller = JAXBUtils.createUnmarshaller();
        assertNotNull(unmarshaller);
        logger.info("JAXBContext was successfully initialized.");
    }//end testJAXBContextInitialized()


    
}/* end class TestJAXBUtils */
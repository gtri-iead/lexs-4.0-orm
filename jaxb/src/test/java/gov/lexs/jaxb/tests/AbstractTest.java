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


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FIXME Describe this type.
 * <br/><br/>
 * @author brad
 * @date Dec 1, 2010
 */
public abstract class AbstractTest {
    //==========================================================================
    //  Private Static Variables
    //==========================================================================
    protected static final Logger logger = LoggerFactory.getLogger(AbstractTest.class);
    //==========================================================================
    //  Public Static Variables
    //==========================================================================

    //==========================================================================
    //  Private Static Methods
    //==========================================================================

    //==========================================================================
    //  Public Static Methods
    //==========================================================================
    @Before
    public void printStartingTest() {
        logger.info("============================== Starting Test ==============================");
    }
    @After
    public void printStoppingTest() {
        logger.info("============================== Stopping Test ==============================");
    }

}/* end class AbstractTest */
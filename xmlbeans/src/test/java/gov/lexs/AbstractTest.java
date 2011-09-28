/*
 * Copyright Georgia Tech Research Institute
 *     Sep 27, 2011
 * 
 *     All rights reserved.
 */

package gov.lexs;

import java.io.FileInputStream;
import java.io.IOException;
import org.custommonkey.xmlunit.XMLTestCase;

/**
 *
 * @author es130
 */
public abstract class AbstractTest extends XMLTestCase {
    //==========================================================================
    //  Private Static Variables
    //==========================================================================

    //==========================================================================
    //  Protected Methods
    //==========================================================================
    @Override
    protected void setUp() throws Exception {
        System.out.println("========================= STARTING TEST =============================");
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        System.out.println("========================= STOPPING TEST =============================\n\n");
    }

    public String getStringFromFile(String fullPathFilename) throws IOException {
        FileInputStream fis = new FileInputStream(fullPathFilename);
        int x = fis.available();
        byte b[] = new byte[x];
        fis.read(b);
        return new String(b).toString();
    }

}

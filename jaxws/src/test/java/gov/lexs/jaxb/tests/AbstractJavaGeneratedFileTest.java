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
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FIXME Describe this type.
 * <br/><br/>
 * @author brad
 * @date Dec 1, 2010
 */
public abstract class AbstractJavaGeneratedFileTest extends AbstractTest {
    //==========================================================================
    //  Test Variables
    //==========================================================================
    public static final String GEN_SOURCE_DIR_PATH =
            "./target/generated";
    protected static final FileFilter SUB_DIRECTORIES = new FileFilter() {
        @Override
        public boolean accept(File file) {
            return file.isDirectory();
        }
    };
    protected static final FileFilter JAVA_FILES = new FileFilter() {
        @Override
        public boolean accept(File file) {
            return file.isFile() && file.getName().endsWith(".java");
        }
    };
    //==========================================================================
    //  Test Helper Methods
    //==========================================================================
    protected void collectAllGeneratedJavaFiles(File directory, List<File> files) {
        files.addAll(Arrays.asList(directory.listFiles(JAVA_FILES)));
        for( File subdir : directory.listFiles(SUB_DIRECTORIES) ){
            collectAllGeneratedJavaFiles(subdir, files);
        }
    }//end collectAllGeneratedJavaFiles()

    protected File getGeneratedSourcesDirectory(){
        return new File(GEN_SOURCE_DIR_PATH);
    }

    protected List<File> getJaxbGeneratedJavaFiles() {
        List<File> files = new ArrayList<File>();
        this.collectAllGeneratedJavaFiles(getGeneratedSourcesDirectory(), files);
        return files;
    }

}/* end class AbstractJavaGeneratedFileTest */
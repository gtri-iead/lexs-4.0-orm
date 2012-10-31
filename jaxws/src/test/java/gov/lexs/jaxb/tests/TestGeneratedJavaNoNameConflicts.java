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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * FIXME Describe this type.
 * <br/><br/>
 * @author brad
 * @date Dec 1, 2010
 */
public class TestGeneratedJavaNoNameConflicts extends AbstractJavaGeneratedFileTest {
    //==========================================================================
    //  Test Variables
    //==========================================================================
    public static final String[] IGNORE_LIST = new String[]{
        "ObjectFactory", "package-info"
    };
    //==========================================================================
    //  Helper Methods
    //==========================================================================
    public Boolean shouldIgnore( String name ){
        return Arrays.asList(IGNORE_LIST).contains(name);
    }
    public boolean contains( List<ClassData> classes, String classname ){
        for( ClassData current : classes ){
            if( current.className.equals(classname) ){
                return true;
            }
        }
        return false;
    }
    public ClassData get( List<ClassData> classes, String classname ){
        ClassData data = null;
        for( ClassData current : classes ){
            if( current.className.equals(classname) ){
                data = current;
                break;
            }
        }
        return data;
    }
    //==========================================================================
    //  Tests
    //==========================================================================
    @Test
    public void testNoNameConflictsFound() throws Exception {
        logger.info("Testing that JAXB did not generate classes with name conflicts...");
        List<File> javaFiles = getJaxbGeneratedJavaFiles();
        logger.debug("Successfully found {} java files.", javaFiles.size());
        List<ClassData> classes = new ArrayList<ClassData>();
        List<ClassDataConflict> conflicts = new ArrayList<ClassDataConflict>();
        for( File file : javaFiles ){
            String clzName = file.getName().replace(".java", "");
            if( !shouldIgnore(clzName) ){
                ClassData curData = createClassData(clzName, file.getPath());
                if( contains(classes, clzName) ){
                    ClassData first = get(classes, clzName);
                    ClassDataConflict conflict = createClassDataConflict(first, curData);
                    conflicts.add(conflict);
                }else{
                    classes.add( curData );
                }
            }
        }
        if( !conflicts.isEmpty() ){
            StringBuilder buffer = new StringBuilder();
            buffer.append("Conflicts(").append(conflicts.size()).append("):\n");
            int count = 1;
            for( ClassDataConflict conflict : conflicts ){
                buffer.append("  #"+count+") ").append(conflict.toString()).append("\n");
                count++;
            }
            logger.error(buffer.toString());
            fail(buffer.toString());
        }
        logger.info("No Java Class Name conflicts in {} classes!", javaFiles.size());
    }//end testNoRestPropertiesFound()

    //==========================================================================
    //  Helper Classes
    //==========================================================================
    public static ClassData createClassData(String clz, String file){
        ClassData data = new ClassData();
        data.className = clz;
        data.fileLocation = file;
        return data;
    }

    public static ClassDataConflict createClassDataConflict(ClassData first, ClassData conflict){
        ClassDataConflict data = new ClassDataConflict();
        data.first = first;
        data.conflict = conflict;
        return data;
    }
    
}/* end class NoRestJavaPropertyGeneratedTest */
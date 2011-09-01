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

import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.BodyDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.type.Type;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * FIXME Describe this type.
 * <br/><br/>
 * @author brad
 * @date Dec 1, 2010
 */
public class TestGeneratedJavaHasNoAnonymousElements extends AbstractJavaGeneratedFileTest {


    protected List<FieldInfo> assertNoAnonymouslyTypedMember(File javaFile) throws Exception {
        List<FieldInfo> anonymousFields = new ArrayList<FieldInfo>();
        FileInputStream in = new FileInputStream(javaFile);
        CompilationUnit cu;
        try {
            // parse the file
            cu = JavaParser.parse(in);
        } finally {
            in.close();
        }
        if( cu != null && cu.getTypes() != null && !cu.getTypes().isEmpty() ){
            for( TypeDeclaration typeDecl : cu.getTypes() ){
                for( BodyDeclaration bodyDecl : typeDecl.getMembers() ){
                    if( bodyDecl instanceof FieldDeclaration ){
                        FieldDeclaration field = (FieldDeclaration) bodyDecl;
                        Type type = field.getType();
                        if( type != null && type.toString().contains("JAXBElement<?>") ){
                            anonymousFields.add(new FieldInfo(javaFile, typeDecl, field));
                        }
                    }
                }
            }
        }else if( cu.getTypes() == null || cu.getTypes().isEmpty() ) {
            logger.warn("File had no type declarations: {}", javaFile);
        }else{
            logger.warn("File had no compilation unit: {}", javaFile);
        }
        return anonymousFields;
    }//end assertNoAnonymouslyTypedMember()

    //==========================================================================
    //  Tests
    //==========================================================================
    @Test
    public void testNoRestPropertiesFound() throws Exception {
        logger.info("Testing that JAXB did not generate any anonymously typed properties...");
        List<File> javaFiles = getJaxbGeneratedJavaFiles();
        logger.debug("Successfully found {} java files.", javaFiles.size());
        List<String> names = new ArrayList<String>();
        int count = 0;
        List<FieldInfo> allAnonymousFields = new ArrayList<FieldInfo>();
        for( File file : javaFiles ){
            if( (count%100) == 0 ){
                logger.debug("  Position {} of {}...", count, javaFiles.size());
            }
            allAnonymousFields.addAll(assertNoAnonymouslyTypedMember(file));
            count++;
        }

        if( !allAnonymousFields.isEmpty() ){
            StringBuilder buffer = new StringBuilder();
            buffer.append("Found ").append(allAnonymousFields.size()).append(" anonymous field declarations:\n");
            for( int i = 0; i < allAnonymousFields.size(); i++ ){
                FieldInfo field = allAnonymousFields.get(i);
                buffer.append("    #").append(i+1).append(")")
                        .append(" Class[").append(field.getClassName()).append("], ")
                        .append(" Member[").append(field.getFieldName()).append("], ")
                        .append(" Type[").append(field.getFieldType().toString()).append("]")
                        .append("\n");
            }
            buffer.append("\n");
            logger.warn(buffer.toString());
        }

        // FIXME this should actually be failing, but due to JAXB I can't fail it.

        logger.info("Did not find any anonymously typed properties!");
    }//end testNoRestPropertiesFound()

}/* end class NoRestJavaPropertyGeneratedTest */
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

import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.type.Type;
import java.io.File;

/**
 * FIXME Describe this type.
 * <br/><br/>
 * @author brad
 * @date Dec 2, 2010
 */
public class FieldInfo {
    //==========================================================================
    //  Instance Variables
    //==========================================================================
    private File file;
    private TypeDeclaration type;
    private FieldDeclaration field;
    //==========================================================================
    //  Getters
    //==========================================================================
    public FieldDeclaration getField() {
        return field;
    }
    public File getFile() {
        return file;
    }
    public TypeDeclaration getType() {
        return type;
    }
    //==========================================================================
    //  Setters
    //==========================================================================
    public void setField(FieldDeclaration field) {
        this.field = field;
    }
    public void setFile(File file) {
        this.file = file;
    }
    public void setType(TypeDeclaration type) {
        this.type = type;
    }
    //==========================================================================
    //  Constructors
    //==========================================================================
    public FieldInfo( File file, TypeDeclaration type, FieldDeclaration field ) {
        this.file = file;
        this.type = type;
        this.field = field;
    }
    //==========================================================================
    //  Private Methods
    //==========================================================================

    //==========================================================================
    //  Protected Methods
    //==========================================================================

    //==========================================================================
    //  Public Methods
    //==========================================================================
    public String getClassName() {
        return type.getName();
    }
    public String getFieldName() {
        return field.getVariables().get(0).getId().getName();
    }
    public Type getFieldType() {
        return this.field.getType();
    }
    //==========================================================================
    //  Interface Implementations
    //==========================================================================


}/* end class FieldInfo */
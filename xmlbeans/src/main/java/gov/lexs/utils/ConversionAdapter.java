/*
 * Copyright (c) 1998-2008 GTARC. All Rights Reserved.
 *
 * This code was developed by Georgia Tech Research Institute under
 * contract with the Department of Justice.
 * Funding was provided by the Department of Justice (DOJ).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package gov.lexs.utils;

import org.apache.xmlbeans.XmlObject;
import org.jdom.Element;

/**
 * $Id: ConversionAdapter.java 2169 2009-02-05 20:16:27Z es130 $
 * 
 * This interface defines the methods needed to allow for the conversion of
 * XMLBean objects to JDOM Elements, and vise-versa
 * 
 * @author es130
 */
public interface ConversionAdapter {

    /**
     * Handles converting a XmlBeans XmlObject into a JDOM Element.
     * @param xmlBeansObject the XmlObject to convert
     * @return the JDOM Element for the passed in XmlObject.
     */
    public Element getJDOMElement( XmlObject xmlBeansObject );
    
    /**
     * Handles converting a JDOM Element into a XmlBeans XMLObject
     * @param jdomElement the JDOM element to convert
     * @return the XMLBeans object to return
     */ 
    public XmlObject getXMLBeansObject( Element jdomElement );
}

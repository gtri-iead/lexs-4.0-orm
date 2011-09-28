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

import java.io.IOException;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlSaxHandler;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.SAXOutputter;

/**
 * $Id: ConversionAdapterImpl.java 3628 2009-09-11 18:51:14Z es130 $
 * 
 * This class defines the ConversionAdapter interface and the 
 * methods needed to allow for the conversion of XMLBean objects to 
 * JDOM Elements, and vise-versa
 * 
 * @author es130
 */
public class ConversionAdapterImpl implements ConversionAdapter{
    
    @Override
    public Element getJDOMElement( XmlObject xmlBeansObject ){
        Element element = null;
        SAXBuilder jdomSaxBuilder = new SAXBuilder();
        try{
            Document jdomDocument = jdomSaxBuilder.build(xmlBeansObject.newReader());
            element = ( jdomDocument == null ? null : jdomDocument.getRootElement());
        }
        catch(JDOMException je){
            je.printStackTrace();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        return element;
    }

    @Override
    public XmlObject getXMLBeansObject( Element jdomElement ){
        
        XmlObject xmlBeansObj = null;
        XmlSaxHandler saxHandler = XmlObject.Factory.newXmlSaxHandler();
        
        SAXOutputter saxOutputter = new SAXOutputter( saxHandler.getContentHandler() );
        
        try{
            saxOutputter.output(jdomElement);
            xmlBeansObj = saxHandler.getObject();
        }
        catch(JDOMException je){
            je.printStackTrace();
        }
        catch(XmlException xe){
            xe.printStackTrace();
        }
        
        return xmlBeansObj;
    }
}

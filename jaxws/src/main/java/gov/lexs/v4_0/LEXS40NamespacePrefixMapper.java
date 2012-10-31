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

package gov.lexs.v4_0;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * NamespacePrefixMapper provides mapping of the schema namespaces to the 
 * particular set of prefixes preselected by the user. 
 */
public class LEXS40NamespacePrefixMapper extends NamespacePrefixMapper {
    //==========================================================================
    //  Private Static Variables
    //==========================================================================
    private static Map<String, String> URI_TO_PREFIX_MAPPINGS;
    //==========================================================================
    //  Public Static Variables
    //==========================================================================

    //==========================================================================
    //  Private Static Methods
    //==========================================================================
    private static ResourceBundle getPrefixBundle() throws Exception {
        return ResourceBundle.getBundle("gov.lexs.v4_0.prefixes");
    }
    private static Map<String, String> buildPrefixMapping() throws Exception {
        Map<String, String> prefixes = new HashMap<String, String>();

        ResourceBundle bundle = getPrefixBundle();
        Enumeration<String> keyEnumeration = bundle.getKeys();
        while( keyEnumeration.hasMoreElements() ){
            String prefix = keyEnumeration.nextElement();
            String uri = bundle.getString(prefix);
            prefixes.put(uri, prefix);
        }
        return prefixes;
    }
    static {
        try{
            URI_TO_PREFIX_MAPPINGS = buildPrefixMapping();
        }catch(Exception e){
            throw new RuntimeException("Unable to build prefix list!", e);
        }
    }
    //==========================================================================
    //  Public Static Methods
    //==========================================================================
    public static Map<String, String> getUriToPrefixMappings() {
        if( URI_TO_PREFIX_MAPPINGS == null )
            URI_TO_PREFIX_MAPPINGS = new HashMap<String, String>();
        return URI_TO_PREFIX_MAPPINGS;
    }
    //==========================================================================
    //  Interface Implementations
    //==========================================================================
    @Override
    public String getPreferredPrefix(
            String namespaceUri,
            String suggestion,
            boolean requirePrefix) {
        String preferredPrefix = suggestion;
        Map<String, String> uriToPrefixMappings = this.getUriToPrefixMappings();
        if( uriToPrefixMappings.containsKey(namespaceUri) ){
            preferredPrefix = uriToPrefixMappings.get(namespaceUri);
        }
        return preferredPrefix;
    }

    @Override
    public String[] getPreDeclaredNamespaceUris() {
        Set<String> uris = getUriToPrefixMappings().keySet();
        return uris.toArray(new String[]{});
    }


}/* end class LEXS40NamespacePrefix */
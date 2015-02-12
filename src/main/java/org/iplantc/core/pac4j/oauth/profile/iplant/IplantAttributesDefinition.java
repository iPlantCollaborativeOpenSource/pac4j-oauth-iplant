package org.iplantc.core.pac4j.oauth.profile.iplant;

import org.pac4j.core.profile.converter.Converters;
import org.pac4j.oauth.profile.OAuthAttributesDefinition;

public class IplantAttributesDefinition extends OAuthAttributesDefinition {
    public static final String USERNAME = "username";
    public static final String PREFERRED_USERNAME = "preferred_username";

    public IplantAttributesDefinition() {
        addAttribute(USERNAME, Converters.stringConverter);
        addAttribute(PREFERRED_USERNAME, Converters.stringConverter);
    }
}

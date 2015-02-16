package org.iplantc.core.pac4j.oauth.profile.iplant;

import org.pac4j.core.profile.converter.Converters;
import org.pac4j.oauth.profile.OAuthAttributesDefinition;

public class IplantAttributesDefinition extends OAuthAttributesDefinition {
    public static final String USERNAME = "sub";
    public static final String PREFERRED_USERNAME = "preferred_username";
    public static final String EMAIL = "email";
    public static final String FULL_NAME = "given_name";
    public static final String LAST_NAME = "family_name";
    public static final String FIRST_NAME = "first_name";

    public IplantAttributesDefinition() {
        addAttribute(USERNAME, Converters.stringConverter);
        addAttribute(PREFERRED_USERNAME, Converters.stringConverter);
        addAttribute(EMAIL, Converters.stringConverter);
        addAttribute(FULL_NAME, Converters.stringConverter);
        addAttribute(LAST_NAME, Converters.stringConverter);
        addAttribute(FIRST_NAME, Converters.stringConverter);
    }
}

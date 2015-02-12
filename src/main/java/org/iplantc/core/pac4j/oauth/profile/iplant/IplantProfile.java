package org.iplantc.core.pac4j.oauth.profile.iplant;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.pac4j.core.profile.AttributesDefinition;
import org.pac4j.oauth.profile.OAuth20Profile;

public class IplantProfile extends OAuth20Profile {

    @Override
    public AttributesDefinition getAttributesDefinition() {
        return AttributesDefinitions.iplantDefinition;
    }

    @Override @JsonProperty(IplantAttributesDefinition.USERNAME)
    public String getUsername() {
        return (String) getAttribute(IplantAttributesDefinition.USERNAME);
    }

    public void setUsername(String username) {
        addAttribute(IplantAttributesDefinition.USERNAME, username);
    }

    @JsonProperty(IplantAttributesDefinition.PREFERRED_USERNAME)
    public String getPreferredUsername() {
        return (String) getAttribute(IplantAttributesDefinition.PREFERRED_USERNAME);
    }

    public void setPreferredUsername(String preferredUsername) {
        addAttribute(IplantAttributesDefinition.PREFERRED_USERNAME, preferredUsername);
    }
}

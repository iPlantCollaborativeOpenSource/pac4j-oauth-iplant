package org.iplantc.core.pac4j.oauth.profile.iplant;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.iplantc.core.pac4j.oauth.api.IplantApi;
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

    public void setUsername(final String username) {
        addAttribute(IplantAttributesDefinition.USERNAME, username);
    }

    @JsonProperty(IplantAttributesDefinition.PREFERRED_USERNAME)
    public String getPreferredUsername() {
        return (String) getAttribute(IplantAttributesDefinition.PREFERRED_USERNAME);
    }

    public void setPreferredUsername(final String preferredUsername) {
        addAttribute(IplantAttributesDefinition.PREFERRED_USERNAME, preferredUsername);
    }

    @JsonProperty(IplantAttributesDefinition.EMAIL)
    public String getEmail() {
        return (String) getAttribute(IplantAttributesDefinition.EMAIL);
    }

    public void setEmail(final String email) {
        addAttribute(IplantAttributesDefinition.EMAIL, email);
    }

    @JsonProperty(IplantAttributesDefinition.FULL_NAME)
    public String getFullName() {
        return (String) getAttribute(IplantAttributesDefinition.FULL_NAME);
    }

    public void setFullName(final String fullName) {
        addAttribute(IplantAttributesDefinition.FULL_NAME, fullName);
    }

    @JsonProperty(IplantAttributesDefinition.LAST_NAME)
    public String getLastName() {
        return (String) getAttribute(IplantAttributesDefinition.LAST_NAME);
    }

    public void setLastName(final String lastName) {
        addAttribute(IplantAttributesDefinition.LAST_NAME, lastName);
    }
}

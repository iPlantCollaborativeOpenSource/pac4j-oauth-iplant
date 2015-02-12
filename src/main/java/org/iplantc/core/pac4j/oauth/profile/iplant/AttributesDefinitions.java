package org.iplantc.core.pac4j.oauth.profile.iplant;

import org.pac4j.core.profile.AttributesDefinition;

public class AttributesDefinitions {

    // Prevent instantiation.
    private AttributesDefinitions() {}

    public final static AttributesDefinition iplantDefinition = new IplantAttributesDefinition();
}

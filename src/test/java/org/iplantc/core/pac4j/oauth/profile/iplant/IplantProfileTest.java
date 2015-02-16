package org.iplantc.core.pac4j.oauth.profile.iplant;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class IplantProfileTest {

    private ObjectMapper objectMapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    private InputStream openResource(String name) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
    }

    @Test
    public void shouldDeserializeFullProfile() throws Exception {
        IplantProfile profile = objectMapper.readValue(openResource("full-profile.json"), IplantProfile.class);
        assertEquals("correct username", "ipctest", profile.getUsername());
        assertEquals("correct preferred username", "Ipc Test", profile.getPreferredUsername());
        assertEquals("correct email address", "ipctest@iplantcollaborative.org", profile.getEmail());
        assertEquals("correct full name", "Ipc Test", profile.getFullName());
        assertEquals("correct last name", "Test", profile.getLastName());
    }

    @Test
    public void shouldDeserializeProfileWithoutUsername() throws Exception {
        IplantProfile profile = objectMapper.readValue(openResource("no-username.json"), IplantProfile.class);
        assertNull("null username", profile.getUsername());
        assertEquals("correct preferred username", "Ipc Test", profile.getPreferredUsername());
        assertEquals("correct email address", "ipctest@iplantcollaborative.org", profile.getEmail());
        assertEquals("correct full name", "Ipc Test", profile.getFullName());
        assertEquals("correct last name", "Test", profile.getLastName());
    }

    @Test
    public void shouldDeserializeProfileWithUnknownAttributes() throws Exception {
            IplantProfile profile = objectMapper.readValue(openResource("unknown-properties.json"), IplantProfile.class);
        assertEquals("correct username", "ipctest", profile.getUsername());
        assertEquals("correct preferred useranme", "Ipc Test", profile.getPreferredUsername());
        assertEquals("correct email address", "ipctest@iplantcollaborative.org", profile.getEmail());
        assertEquals("correct full name", "Ipc Test", profile.getFullName());
        assertEquals("correct last name", "Test", profile.getLastName());
    }
}

package org.iplantc.core.pac4j.oauth.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.iplantc.core.pac4j.oauth.api.IplantApi;
import org.iplantc.core.pac4j.oauth.profile.iplant.IplantProfile;
import org.pac4j.core.context.WebContext;
import org.pac4j.oauth.client.BaseOAuth20Client;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.DefaultApi20;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

import java.io.IOException;

public class IplantClient extends BaseOAuth20Client<IplantProfile> {

    private static final String DEFAULT_BASE_URL = "https://agave.iplantc.org/oauth2";

    private final String baseUrl;

    private final DefaultApi20 api;

    private final ObjectMapper objectMapper
             = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    public IplantClient(final String key, final String secret) {
        this(DEFAULT_BASE_URL, key, secret);
    }

    public IplantClient(final String baseUrl, final String key, final String secret) {
        this.baseUrl = baseUrl;
        api = new IplantApi(baseUrl);
        setKey(key);
        setSecret(secret);
    }

    @Override
    protected void internalInit() {
        super.internalInit();
        service = createService();
        setTokenAsHeader(true);
    }

    protected OAuthService createService() {
        return new ServiceBuilder()
                .provider(api)
                .apiKey(getKey())
                .apiSecret(getSecret())
                .callback(getCallbackUrl())
                .scope("openid")
                .debug()
                .build();
    }

    @Override
    protected boolean requiresStateParameter() {
        return false;
    }

    @Override
    protected boolean hasBeenCancelled(WebContext webContext) {
        return false;
    }

    @Override
    protected String getProfileUrl(Token token) {
        return baseUrl + "/userinfo?schema=openid";
    }

    @Override
    protected IplantProfile extractUserProfile(String s) {
        try {
            return objectMapper.readValue(s, IplantProfile.class);
        } catch (JsonProcessingException e) {
            logger.error("unable to process JSON string: " + s, e);
            throw new RuntimeException("invalid user profile service response: " + s, e);
        } catch (IOException e) {
            logger.error("I/O error while processing JSON string: " + s, e);
            throw new RuntimeException("I/O error occurred while extracting user profile", e);
        }
    }

    @Override
    protected IplantClient newClient() {
        return new IplantClient(baseUrl, getKey(), getSecret());
    }
}

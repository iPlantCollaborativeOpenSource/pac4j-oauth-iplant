package org.iplantc.core.pac4j.oauth.api;

import org.scribe.builder.api.DefaultApi20;
import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.extractors.JsonTokenExtractor;
import org.scribe.model.OAuthConfig;
import org.scribe.model.Verb;
import org.scribe.utils.OAuthEncoder;

public class IplantApi extends DefaultApi20 {

    private static final String ACCESS_TOKEN_URL_TEMPLATE
            = "%s/token?grant_type=authorization_code";

    private final static String AUTHORIZE_URL_TEMPLATE
            = "%s/authorize?client_id=%s&redirect_uri=%s&scope=openid&response_type=code";

    private final String baseUrl;

    public IplantApi(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    @Override
    public AccessTokenExtractor getAccessTokenExtractor() {
        return new JsonTokenExtractor();
    }

    @Override
    public String getAccessTokenEndpoint() {
        return String.format(ACCESS_TOKEN_URL_TEMPLATE, getBaseUrl());
    }

    @Override
    public Verb getAccessTokenVerb() {
        return Verb.POST;
    }

    @Override
    public String getAuthorizationUrl(OAuthConfig config) {
        return String.format(AUTHORIZE_URL_TEMPLATE, getBaseUrl(), config.getApiKey(),
                OAuthEncoder.encode(config.getCallback()));
    }
}

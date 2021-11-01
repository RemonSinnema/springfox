package springfox.documentation.service;

import springfox.documentation.builders.HttpLoginPasswordBuilder;

import java.util.List;

public class HttpLoginPasswordScheme extends SecurityScheme {

    public static final HttpLoginPasswordBuilder X_AUTHORIZATION_BUILDER = new HttpLoginPasswordBuilder()
            .authorizationHeader("X-Authorization");

    private final String scheme;
    private final String loginEndpoint;
    private final String authorizationHeader;

    public HttpLoginPasswordScheme(
            String name,
            String description,
            String type,
            String scheme,
            String loginEndpoint,
            String authorizationHeader,
            List<VendorExtension> extensions) {
        super(name, type, description, extensions);
        this.scheme = scheme;
        this.loginEndpoint = loginEndpoint;
        this.authorizationHeader = authorizationHeader;
    }

    public String getScheme() {
        return scheme;
    }

    public String getLoginEndpoint() {
        return loginEndpoint;
    }

    public String getAuthorizationHeader() {
        return authorizationHeader;
    }
}

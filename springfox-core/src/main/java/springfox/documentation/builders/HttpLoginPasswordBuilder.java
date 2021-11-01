package springfox.documentation.builders;

import springfox.documentation.service.HttpLoginPasswordScheme;
import springfox.documentation.service.VendorExtension;

import java.util.ArrayList;
import java.util.List;

import static springfox.documentation.builders.BuilderDefaults.nullToEmptyList;

public class HttpLoginPasswordBuilder {

    private String name;
    private String description;
    private String loginEndpoint;
    private String authorizationHeader;
    private final List<VendorExtension> extensions = new ArrayList<>();

    public HttpLoginPasswordBuilder name(String name) {
        this.name = name;
        return this;
    }

    public HttpLoginPasswordBuilder description(String description) {
        this.description = description;
        return this;
    }

    public HttpLoginPasswordBuilder loginEndpoint(String loginEndpoint) {
        this.loginEndpoint = loginEndpoint;
        return this;
    }

    public HttpLoginPasswordBuilder authorizationHeader(String authorizationHeader) {
        this.authorizationHeader = authorizationHeader;
        return this;
    }

    public HttpLoginPasswordBuilder extensions(List<VendorExtension> extensions) {
        this.extensions.addAll(nullToEmptyList(extensions));
        return this;
    }

    public HttpLoginPasswordScheme build() {
        return new HttpLoginPasswordScheme(
                name,
                description,
                "http",
                "loginPassword",
                loginEndpoint,
                authorizationHeader,
                extensions);
    }

}

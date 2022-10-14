package com.karaaslan.todoapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** The type Swagger configuration. */
@Configuration
public class SwaggerConfiguration {

  /** The constant AUTHORIZATION_HEADER. */
  public static final String AUTHORIZATION_HEADER = "Authorization";

  private ApiInfo apiInfo() {
    return new ApiInfo(
        "My REST API",
        "Some custom description of API.",
        "1.0",
        "Terms of service",
        new Contact(
            "Eyup Erhan KARAASLAN", "www.eyuperhankaraaslan.com", "eyuperhankaraaslan94@gmail.com"),
        "License of API",
        "API license URL",
        Collections.emptyList());
  }

  /**
   * Api docket.
   *
   * @return the docket
   */
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .securityContexts(Arrays.asList(securityContext()))
        .securitySchemes(Arrays.asList(apiKey()))
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build();
  }

  private ApiKey apiKey() {
    return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
  }

  private SecurityContext securityContext() {
    return SecurityContext.builder().securityReferences(defaultAuth()).build();
  }

  /**
   * Default auth list.
   *
   * @return the list
   */
  List<SecurityReference> defaultAuth() {
    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    authorizationScopes[0] = authorizationScope;
    return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
  }
}

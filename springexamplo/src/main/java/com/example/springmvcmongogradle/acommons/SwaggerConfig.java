package com.example.springmvcmongogradle.acommons;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

  @Bean
  public GroupedOpenApi publicApi() {
      return GroupedOpenApi.builder()
              .group("todo")
              .pathsToMatch("/v1/todo/**")
              .build();
  }

  @Bean
  public GroupedOpenApi adminApi() {
      return GroupedOpenApi.builder()
              .group("trello")
              .pathsToMatch("/v1/trello/**")
              .build();
  }



  @Bean
  public OpenAPI springShopOpenAPI() {
      return new OpenAPI()
              .info(new Info().title("Todo")
              .description("Spring todo sample application")
              .version("v1")
              .license(new License().name("SpringDoc").url("http://springdoc.org")))
              .externalDocs(new ExternalDocumentation()
              .description("GitHub")
              .url("https://github.com/Felipe3Ferro"));
  }

}
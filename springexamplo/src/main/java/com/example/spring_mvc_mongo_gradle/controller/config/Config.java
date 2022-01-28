package com.example.spring_mvc_mongo_gradle.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
public class Config {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public UriComponentsBuilder uriComponentsBuilder() {
    return UriComponentsBuilder.newInstance()
        .scheme("https")
        .host("api.trello.com")
        .queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
        .queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3");
  }
}

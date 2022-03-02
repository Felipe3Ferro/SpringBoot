package com.example.spring_mvc_mongo_gradle.controller.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

  // @Bean
  // public RestTemplate restTemplate() {
  //   return new RestTemplate();
  // }


  @Bean 
  public RestTemplate restTemplate2() {
    return new RestTemplateBuilder()
      .rootUri("https://api.trello.com/")
      .build();
  }

}

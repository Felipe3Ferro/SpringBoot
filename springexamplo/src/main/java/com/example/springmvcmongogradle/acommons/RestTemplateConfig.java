package com.example.springmvcmongogradle.acommons;

import com.example.springmvcmongogradle.acommons.exception.ErrorDetail;
import com.example.springmvcmongogradle.acommons.exception.ErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .rootUri("https://api.trello.com")
                .errorHandler(new ErrorHandler())
                .build();
    }


}
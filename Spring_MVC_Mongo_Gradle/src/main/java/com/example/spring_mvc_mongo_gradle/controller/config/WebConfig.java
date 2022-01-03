package com.example.spring_mvc_mongo_gradle.controller.config;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class WebConfig {
    @Bean
    //Serialização é o processo de tradução de estruturas de dados
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> {
            builder.serializers(new LocalDateSerializer(DateTimeFormatter.ISO_LOCAL_DATE));
            builder.deserializers(new LocalDateTimeDeserializer(DateTimeFormatter.ISO_LOCAL_DATE));
        };
    }
} 
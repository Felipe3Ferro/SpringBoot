//package com.example.spring_mvc_mongo_gradle.integration;
//
//import com.example.spring_mvc_mongo_gradle.models.trello.response.CardResponse;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponents;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Component
//@AllArgsConstructor
//public class TrelloCardIntegration {
//
//    private final RestTemplate template;
//
//    public List<CardResponse> getCard(String listId) {
//        UriComponents uri = UriComponentsBuilder.newInstance()
//                .path("/1/lists/" + listId + "/cards")
//                .queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
//                .queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3")
//                .build();
//
//
//        CardResponse[] responseEntity = template.getForObject(uri.toString(), CardResponse[].class);
//        return Arrays.asList(responseEntity);
//    }
//}

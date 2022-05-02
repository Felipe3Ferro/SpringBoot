//package com.example.spring_mvc_mongo_gradle.integration;
//
//import com.example.spring_mvc_mongo_gradle.models.trello.request.ListRequest;
//import com.example.spring_mvc_mongo_gradle.models.trello.response.ListofBoardResponse;
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
//public class ListIntegration {
//
//    private final RestTemplate template;
//
//    public List<ListofBoardResponse> getListofBoardByBoardId(String boardId) {
//        UriComponents uri = UriComponentsBuilder.newInstance()
//                .path("/1/boards/" + boardId + "/lists")
//                .queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
//                .queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3")
//                .build();
//
//        ListofBoardResponse[] responseEntity = template.getForObject(uri.toString(), ListofBoardResponse[].class);
//        return Arrays.asList(responseEntity);
//    }
//
//    public ListofBoardResponse createList(String id, ListRequest listRequest) {
//        UriComponents uri = UriComponentsBuilder.newInstance()
//                .path("/1/boards/"+ id +"/lists")
//                .queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
//                .queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3")
//                .build();
//
//        return template.postForObject(uri.toString(), listRequest, ListofBoardResponse.class);
//    }
//}

package com.example.spring_mvc_mongo_gradle.integration;

import com.example.spring_mvc_mongo_gradle.models.trello.dto.ListofBoardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.response.Board;
import com.example.spring_mvc_mongo_gradle.models.trello.response.Card;
import com.example.spring_mvc_mongo_gradle.models.trello.response.ListofBoard;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class TrelloIntegration {

    private final RestTemplate template;

    public List<Board> getBoard(){
        UriComponents uri = UriComponentsBuilder.newInstance()
                .path("/1/members/me/boards")
                .queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
                .queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3")
                .build();

        Board[] responseEntity = template.getForObject(uri.toString(), Board[].class);
        return Arrays.asList(responseEntity);
    }

    public List<ListofBoard> getListofBoardByBoardId(String boardId) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .path("/1/boards/" + boardId + "/lists")
                .queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
                .queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3")
                .build();

        ListofBoard[] responseEntity = template.getForObject(uri.toString(), ListofBoard[].class);
        return Arrays.asList(responseEntity);
    }

    public Card getCard(String boardId) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .path("/1/boards/" + boardId + "/lists")
                .queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
                .queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3")
                .build();
        return
    }
}

package com.example.springmvcmongogradle.board.integration;

import com.example.springmvcmongogradle.board.models.board.BoardRequest;
import com.example.springmvcmongogradle.board.models.board.BoardResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class BoardIntegration {
    private final RestTemplate template;

    public List<BoardResponse> getBoard() {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .path("/1/members/me/boards")
                .queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
                .queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3")
                .build();

        BoardResponse[] responseEntity = template.getForObject(uri.toString(), BoardResponse[].class);
        return Arrays.asList(responseEntity);
    }

    public BoardResponse createBoard(BoardRequest board) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .path("/1/boards/")
                .queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
                .queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3")
                .build();

        return template.postForObject(uri.toString(), board, BoardResponse.class);
    }

    public void deleteBoardById(String id) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .path("/1/boards/" + id)
                .queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
                .queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3")
                .build();
        template.delete(uri.toString());
    }

    public void updateBoard(String id, BoardRequest board) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .path("/1/boards/" + id)
                .queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
                .queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3")
                .build();
        template.put(uri.toString(), board, BoardResponse.class );
    }
}

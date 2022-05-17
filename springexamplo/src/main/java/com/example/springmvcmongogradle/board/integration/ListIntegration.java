package com.example.springmvcmongogradle.board.integration;

import com.example.springmvcmongogradle.board.models.list.ListRequest;
import com.example.springmvcmongogradle.board.models.list.ListResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class ListIntegration {

    private RestTemplate template;

    public List<ListResponse> getListofBoardByBoardId(String boardId) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .path("/1/boards/" + boardId + "/lists")
                .queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
                .queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3")
                .build();

        ListResponse[] responses = template.getForObject(uri.toString(), ListResponse[].class);
        return Arrays.asList(responses);
    }

    public ListResponse createList(String id, ListRequest listRequest) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .path("/1/boards/"+ id +"/lists")
                .queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
                .queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3")
                .build();

        return template.postForObject(uri.toString(), listRequest, ListResponse.class);
    }

    public void updateList(String id, ListRequest listRequest) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .path("/1/lists/"+id)
                .queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
                .queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3")
                .build();

        template.put(uri.toString(), listRequest, ListResponse.class);
    }
}

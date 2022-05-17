package com.example.springmvcmongogradle.card.integration;

import com.example.springmvcmongogradle.card.models.CardRequest;
import com.example.springmvcmongogradle.card.models.CardResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@AllArgsConstructor
public class CardIntegration {

    private final RestTemplate template;

    public CardResponse createCard(String idList, CardRequest card) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .path("/1/cards/"+idList)
                .queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
                .queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3")
                .build();

        return template.postForObject(uri.toString(), card, CardResponse.class);
    }
}
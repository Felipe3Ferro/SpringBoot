package com.example.springmvcmongogradle.card.controller.v1;

import com.example.springmvcmongogradle.card.models.CardRequest;
import com.example.springmvcmongogradle.card.models.CardResponse;
import com.example.springmvcmongogradle.card.repository.CardRepository;
import com.example.springmvcmongogradle.card.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/trello")
public class CardController {

    private final CardService cardService;
    private final CardRepository cardRepository;

    @PostMapping("/card")
    public CardResponse createCard(@RequestBody CardRequest card){
        return cardService.createCard(card);
    }
    
}

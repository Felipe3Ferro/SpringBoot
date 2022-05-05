package com.example.springmvcmongogradle.card.service;

import com.example.springmvcmongogradle.card.integration.CardIntegration;
import com.example.springmvcmongogradle.card.models.CardRequest;
import com.example.springmvcmongogradle.card.models.CardResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CardService {

    private final CardIntegration cardIntegration;

    public CardResponse createCard(CardRequest card) {
       return cardIntegration.createCard(card);
    }

}

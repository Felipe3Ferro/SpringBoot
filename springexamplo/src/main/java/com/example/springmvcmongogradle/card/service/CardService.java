package com.example.springmvcmongogradle.card.service;

import com.example.springmvcmongogradle.card.integration.CardIntegration;
import com.example.springmvcmongogradle.card.models.CardRequest;
import com.example.springmvcmongogradle.card.models.CardResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CardService {

    private final CardIntegration cardIntegration;

    public CardResponse createCard(String idList, CardRequest card) {
       return cardIntegration.createCard(idList,card);
    }

    public List<CardResponse> getCards() {
        return null;
    }

}

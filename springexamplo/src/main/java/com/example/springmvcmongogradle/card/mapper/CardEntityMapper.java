package com.example.springmvcmongogradle.card.mapper;

import com.example.springmvcmongogradle.card.models.CardEntity;
import com.example.springmvcmongogradle.card.models.CardResponse;

public class CardEntityMapper {

    public static CardEntity toCardEntity(CardResponse cardResponse) {
        return CardEntity.builder()
                .id(cardResponse.getId())
                .name(cardResponse.getName())
                .desc(cardResponse.getDesc())
                .build();
    }

}

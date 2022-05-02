//package com.example.spring_mvc_mongo_gradle.mapper;
//
//import com.example.spring_mvc_mongo_gradle.models.trello.dto.CardDTO;
//import com.example.spring_mvc_mongo_gradle.models.trello.response.CardResponse;
//
//public class CardDTOMapper {
//
//    public static CardDTO toCardDTO(CardResponse cardResponse){
//        return CardDTO.builder()
//                .id(cardResponse.getId())
//                .name(cardResponse.getName())
//                .desc(cardResponse.getDesc())
//                .build();
//    }
//}

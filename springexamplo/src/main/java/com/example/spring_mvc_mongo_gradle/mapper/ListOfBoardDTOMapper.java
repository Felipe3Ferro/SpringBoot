package com.example.spring_mvc_mongo_gradle.mapper;

import com.example.spring_mvc_mongo_gradle.models.trello.dto.ListDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.response.ListofBoardResponse;

public class ListOfBoardDTOMapper {
    public static ListDTO toListofBoardDTO(ListofBoardResponse listofBoardResponse){
        return ListDTO.builder()
                .id(listofBoardResponse.getId())
                .name(listofBoardResponse.getName())
                .build();
    }
}

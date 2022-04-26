package com.example.spring_mvc_mongo_gradle.mapper;

import com.example.spring_mvc_mongo_gradle.models.trello.dto.ListofBoardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.response.ListofBoardResponse;

public class ListOfBoardDTOMapper {
    public static ListofBoardDTO toListofBoardDTO(ListofBoardResponse listofBoardResponse){
        return ListofBoardDTO.builder()
                .id(listofBoardResponse.getId())
                .name(listofBoardResponse.getName())
                .build();
    }
}

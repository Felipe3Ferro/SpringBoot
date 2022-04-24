package com.example.spring_mvc_mongo_gradle.service.mapper;

import com.example.spring_mvc_mongo_gradle.models.trello.dto.BoardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.dto.CardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.dto.ListofBoardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.response.Board;
import com.example.spring_mvc_mongo_gradle.models.trello.response.Card;
import com.example.spring_mvc_mongo_gradle.models.trello.response.ListofBoard;

import java.util.List;

public class TrellotoDTO {

    public static List<BoardDTO> toBoardDTO(List<Board> board){
      return board.stream()
               .map(boardValue ->
                       BoardDTO.builder()
                               .id(boardValue.getId())
                               .name(boardValue.getName())
                               .closed(boardValue.getClosed())
                               .build()
               )
               .toList();
    }

    public static List<ListofBoardDTO> toListofBoardDTO(List<ListofBoard> listOfBoard){
        return listOfBoard.stream()
                .map(varListOfBoardValue ->
                        ListofBoardDTO.builder()
                                .id(varListOfBoardValue.getId())
                                .name(varListOfBoardValue.getName())
                                .desc(varListOfBoardValue.getDesc())
                                .build()
                )
                .toList();

    }

    public static CardDTO toCardDTO(Card card){
        return CardDTO.builder()
                .id(card.getId())
                .name(card.getName())
                .desc(card.getDesc())
                .build();
    }
}

package com.example.springmvcmongogradle.board.mapper.list;

import com.example.springmvcmongogradle.board.models.board.BoardResponse;
import com.example.springmvcmongogradle.board.models.list.ListEntity;
import com.example.springmvcmongogradle.board.models.list.ListResponse;

import java.util.List;

public class ListEntityMapper {

    public static List<ListEntity> toListEntity(List<ListResponse> listResponses){
       return listResponses.stream().map(listValue ->
                ListEntity.builder()
                        .id(listValue.getId())
                        .name(listValue.getName())
                        .desc(listValue.getDesc())
                        .build())
               .toList();
    }
}
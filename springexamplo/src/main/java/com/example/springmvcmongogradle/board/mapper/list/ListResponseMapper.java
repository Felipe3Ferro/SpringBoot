package com.example.springmvcmongogradle.board.mapper.list;

import com.example.springmvcmongogradle.board.models.list.ListEntity;
import com.example.springmvcmongogradle.board.models.list.ListResponse;

import java.util.List;

public class ListResponseMapper {

    public static List<ListResponse> toListResponse(List<ListEntity> listEntities){
        return listEntities.stream().map(listValue ->
                        ListResponse.builder()
                                .id(listValue.getId())
                                .name(listValue.getName())
                                .desc(listValue.getDesc())
                                .build())
                .toList();
    }

}

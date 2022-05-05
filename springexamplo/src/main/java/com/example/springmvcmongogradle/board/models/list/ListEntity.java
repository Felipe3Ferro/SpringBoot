package com.example.springmvcmongogradle.board.models.list;

import com.example.springmvcmongogradle.card.models.CardEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListEntity {
    private String id;
    private String name;
    private String desc;
}

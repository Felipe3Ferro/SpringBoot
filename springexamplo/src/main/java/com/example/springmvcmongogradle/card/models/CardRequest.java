package com.example.springmvcmongogradle.card.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardRequest {
    private String idList;
    private String name;
    private String desc;
}

package com.example.springmvcmongogradle.card.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "card")
public class CardEntity {
    @Id
    private String id;
    private String idList;
    private String name;
    private String desc;
}
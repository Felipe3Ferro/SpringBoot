package com.example.springmvcmongogradle.board.models.board;
import com.example.springmvcmongogradle.board.models.list.ListEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Board")
public class BoardEntity {
    @Id
    private String id;
    private String name;
    private Boolean closed;
    private List<ListEntity> list;
}
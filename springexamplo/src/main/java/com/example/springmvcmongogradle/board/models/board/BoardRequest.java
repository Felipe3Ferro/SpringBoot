package com.example.springmvcmongogradle.board.models.board;
import com.example.springmvcmongogradle.board.models.list.ListRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequest {
    private String name;
    private Boolean defaultLists = false;
    private Boolean closed;
    private List<ListRequest> list;
}

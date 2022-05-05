package com.example.springmvcmongogradle.board.models.board;
import com.example.springmvcmongogradle.board.models.list.ListResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponse {
    private String id;
    private String name;
    private Boolean closed;
    private List<ListResponse> list;
}

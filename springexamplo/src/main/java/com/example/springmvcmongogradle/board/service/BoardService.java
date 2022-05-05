package com.example.springmvcmongogradle.board.service;

import com.example.springmvcmongogradle.board.integration.BoardIntegration;
import com.example.springmvcmongogradle.board.models.board.BoardRequest;
import com.example.springmvcmongogradle.board.models.board.BoardResponse;
import com.example.springmvcmongogradle.board.repository.BoardRepository;
import com.example.springmvcmongogradle.task.exception.NotFoundException;
import com.example.springmvcmongogradle.task.mapper.TaskResponseMapper;
import com.example.springmvcmongogradle.task.models.TaskResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.springmvcmongogradle.board.mapper.board.BoardEntityMapper.toBoardEntity;
import static com.example.springmvcmongogradle.board.mapper.board.BoardResponseMapper.toBoardResponse;
import static com.example.springmvcmongogradle.task.mapper.TaskEntityMapper.toTaskEntity;
import static com.example.springmvcmongogradle.task.mapper.TaskResponseMapper.toTaskResponse;

@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardIntegration boardIntegration;

    public List<BoardResponse> getBoard() {
        return boardIntegration.getBoard();
    }

    public List<BoardResponse> saveBoard(List<BoardResponse> boardResponseList){
        return toBoardResponse(boardRepository.saveAll(toBoardEntity(boardResponseList)));
    }

    public BoardResponse saveBoard(BoardResponse boardResponse){
        return toBoardResponse(boardRepository.save(toBoardEntity(boardResponse)));
    }

    public BoardResponse createBoard(BoardRequest board) {
        return boardIntegration.createBoard(board);
    }

    public void deleteBoard(String id) {
        boardIntegration.deleteBoardById(id);
        boardRepository.deleteById(id);
    }

    public void deleteAllBoard() {
        boardRepository.findAll().forEach(
                boardEntity -> boardIntegration.deleteBoardById(boardEntity.getId())
        );
        boardRepository.deleteAll();
    }

    public BoardResponse updateBoard(String id, BoardRequest boardRequest) {
        boardIntegration.updateBoard(id, boardRequest);
        var boardModel = boardRepository.findById(id).get();


        boardModel.setName(boardRequest.getName());
        boardModel.setClosed(boardRequest.getClosed());

        return toBoardResponse(boardRepository.save(boardModel));
    }
}

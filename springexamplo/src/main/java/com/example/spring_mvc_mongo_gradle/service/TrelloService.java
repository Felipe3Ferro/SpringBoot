package com.example.spring_mvc_mongo_gradle.service;

import com.example.spring_mvc_mongo_gradle.models.trello.dto.BoardDTO;
import com.example.spring_mvc_mongo_gradle.repositories.TrelloRepository;
import com.example.spring_mvc_mongo_gradle.service.facade.FacadeTrello;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TrelloService {

	private final TrelloRepository repository;
	private final FacadeTrello facadeTrello;

	public List<BoardDTO> getBoard(){
		var board = facadeTrello.createBoard();
		repository.saveAll(board);
		return board;
	}

	public void deleteBoard(String id){
		repository.deleteById(id);
	}



	public void deleteAll() {
		repository.deleteAll();
	}
}

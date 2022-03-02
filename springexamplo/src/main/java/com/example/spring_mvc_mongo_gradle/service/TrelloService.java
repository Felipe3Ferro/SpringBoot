package com.example.spring_mvc_mongo_gradle.service;

import com.example.spring_mvc_mongo_gradle.models.Board;
import com.example.spring_mvc_mongo_gradle.models.Card;
import com.example.spring_mvc_mongo_gradle.models.ListofBoard;
import com.example.spring_mvc_mongo_gradle.repositories.TrelloRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TrelloService {

	private final TrelloRepository repository;
	private final RestTemplate template;

	// public List getCardsByBoardId(String id) {

	// return Arrays.stream(getCardsOfListById(id)).map(cards ->
	// cards.getName()).collect(Collectors.toList());

	// }

	public Board createBoard(Board board) {

		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("api.trello.com")
				.path("1/boards/")
				.queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
				.queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3").build();

		Board aux = template.postForObject(uri.toString(), board, Board.class);

		aux.setList(getListFromABoardById(aux.getId()));

		return repository.save(aux);
	}



//	public ListofBoard[] getListFromABoardById(String id) {
//		// https://api.trello.com/1/boards/61eb148bf61d443d512751de/lists
//
//		UriComponents uri = UriComponentsBuilder.newInstance()
//				.scheme("https")
//				.host("api.trello.com")
//				.path("1/boards/")
//				.path(id + "/lists")
//				.queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
//				.queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3").build();
//
//		var response = template.getForObject(uri.toString(), ListofBoard[].class);
//
//		List<ListofBoard> listofBoards = Arrays.stream(response).collect(Collectors.toList());
//
//		for (int i = 0; i < listofBoards.s; i++) {
//			listofBoards[i].setCards(getCardsFromListById(listofBoards[i].getId()));
//		}
//
//		var list = listofBoards.stream().map((ListofBoard board) -> getCardsFromListById(board.getId())).collect(Collectors.toList());
//





		public ListofBoard[] getListFromABoardById(String id) {
		// https://api.trello.com/1/boards/61eb148bf61d443d512751de/lists

		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("api.trello.com")
				.path("1/boards/")
				.path(id + "/lists")
				.queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
				.queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3").build();

		ListofBoard[] listofBoards = template.getForObject(uri.toString(), ListofBoard[].class);


		for (int i = 0; i < listofBoards.length; i++) {
			listofBoards[i].setCards(getCardsFromListById(listofBoards[i].getId()));
		}

		return listofBoards;
	}

	public Card[] getCardsFromListById(String id) {

		// https://api.trello.com/1/lists/61f15dfcc7b3c971222b035d/cards

		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("api.trello.com")
				.path("1/lists/")
				.path(id + "/cards")
				.queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
				.queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3").build();

		Card[] cards = template.getForObject(uri.toString(), Card[].class);

		return cards;
	}

	public Card createCard(Card card, String boardId, String listofBoardId) {

		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("api.trello.com")
				.path("1/cards")
				.queryParam("idList", listofBoardId)
				.queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
				.queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3").build();

		Card aux = template.postForObject(uri.toString(), card, Card.class);

		ListofBoard[] list = repository.findById(boardId).get().getList();

		Card cards[] = {aux};

		for (ListofBoard listofBoard : list) {
			if (listofBoard.getId().equals(listofBoardId)) {
				listofBoard.setCards(cards);
			}
		}

		Optional<Board> board = repository.findById(boardId);

		board.get().setList(list);

		repository.save(board.get());

		return aux;
	}

	public List<Board> getBoard(){
		return repository.findAll();
	}

	public void deleteBoard(String id){
		repository.deleteById(id);
	}

	public void deleteAll() {
		repository.deleteAll();
	}
}
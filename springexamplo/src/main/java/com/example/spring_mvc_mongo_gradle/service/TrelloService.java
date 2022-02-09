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

@AllArgsConstructor
@Service
public class TrelloService {

	private final TrelloRepository repository;
	private final RestTemplate template;

	// public List getCardsByBoardId(String id) {

	// return Arrays.stream(getCardsOfListById(id)).map(cards ->
	// cards.getName()).collect(Collectors.toList());

	// }

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

	public ListofBoard[] getListFromABoardById(String id) {
		// https://api.trello.com/1/boards/61eb148bf61d443d512751de/lists

		UriComponents uri = UriComponentsBuilder.newInstance().build();

		ListofBoard[] listofBoards = template.getForObject(uri.toString(), ListofBoard[].class);

		for (int i = 0; i < listofBoards.length; i++) {
			listofBoards[i].setCards(getCardsFromListById(listofBoards[i].getId()));
		}

		return listofBoards;
	}

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

	public Card createCard(Card card, String boardId, String cardId) {

		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("api.trello.com")
				.path("1/cards")
				.queryParam("idList", "61f16d89d935ce331d7481fe")
				.queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
				.queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3").build();

		Card aux = template.postForObject(uri.toString(), card, Card.class);

		ListofBoard[] list = repository.findById(boardId).get().getList();

		for (ListofBoard listofBoard : list) {
			if (listofBoard.getId().equals(cardId)) {
				Card[] cards = { card };
				listofBoard.setCards(cards);
			}
		}

		return aux;
	}

	public Board getBoard(String id) {
		return repository.findById(id).get();
	}

}
package com.project.kanban.application.card;

import com.project.kanban.domain.entity.card.Card;
import com.project.kanban.domain.entity.card.CardRepository;
import com.project.kanban.domain.entity.card.CardStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardFinder {

	@Autowired
	private CardRepository cardRepository;

	public List<Card> searchByCriteria(String title, CardStatus status, String color) {
		final Specification<Card> cardSpec = CardQuerySpecBuilder.builder()
			.title(title)
			.status(status)
			.color(color)
			.build();

		return cardRepository.findAll(cardSpec);
	}

	public List<Card> searchByQueryDsl(String title, CardStatus status, String color) {
		return cardRepository.search(title, status, color);
	}
}

package com.project.kanban.application.card;

import com.project.kanban.domain.entity.card.Card;
import com.project.kanban.domain.entity.card.CardRepository;
import com.project.kanban.domain.entity.card.CardStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CardModifier {

	@Autowired
	private CardRepository cardRepository;


	public Card modify(final Long cardId, final Card modifyCard) {
		final Card card = cardRepository.findOne(cardId);
		card.modify(modifyCard.getTitle(), modifyCard.getDescription(), modifyCard.getStatus(), modifyCard.getColor());

		return cardRepository.save(card);
	}

	public Card statusChange(final Long cardId, final String status, final int position) {
		final Card card = cardRepository.findOne(cardId);
		final CardStatus cardStatus = CardStatus.find(status);
		card.statusChange(cardStatus, position);

		return cardRepository.save(card);
	}
}

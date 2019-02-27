package com.project.kanban.application.card;

import com.google.common.collect.Lists;
import com.project.kanban.application.query.QuerySpec;
import com.project.kanban.application.query.SpecCombineUtils;
import com.project.kanban.domain.entity.card.Card;
import com.project.kanban.domain.entity.card.CardStatus;
import com.project.kanban.domain.entity.card.Card_;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class CardQuerySpecBuilder {

	private static final QuerySpec<Card> CARD_SPEC = new QuerySpec<>();

	private List<Specification<Card>> cardSpecList = Lists.newArrayList();

	public static CardQuerySpecBuilder builder() {
		return new CardQuerySpecBuilder();
	}

	public Specification<Card> build() {
		return SpecCombineUtils.combine(cardSpecList);
	}

	public CardQuerySpecBuilder title(String title) {
		cardSpecList.add(CARD_SPEC.like(Card_.title, title));
		return this;
	}

	public CardQuerySpecBuilder status(CardStatus status) {
		cardSpecList.add(CARD_SPEC.equalCardStatus(Card_.status, status));
		return this;
	}

	public CardQuerySpecBuilder color(String color) {
		cardSpecList.add(CARD_SPEC.equal(Card_.color, color));
		return this;
	}
}

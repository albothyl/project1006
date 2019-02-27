package com.project.kanban.domain.entity.card;

import java.util.List;

public interface CardRepositoryCustom {
	List<Card> search(String title, CardStatus status, String color);
}

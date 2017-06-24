package com.project.kanban.domain.entity.card;

public enum CardStatus {
	TODO,
	INPROGRESS,
	DONE;

	public static CardStatus find(String state) {
		return CardStatus.valueOf(state.toUpperCase());
	}
}

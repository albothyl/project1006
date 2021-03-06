package com.project.kanban.domain.entity.card;

import com.google.common.collect.Lists;
import com.project.kanban.domain.entity.CommonEntity;
import com.project.kanban.domain.entity.task.Task;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;

@Entity
@Getter
@Table(schema = "kanban", name = "cards")
@NoArgsConstructor
public class Card extends CommonEntity {

	private String title;

	private String description;

	@Enumerated(value = STRING)
	private CardStatus status;

	private String color;

	@JoinColumn(name = "cardId")
	@OneToMany(cascade = ALL, fetch = FetchType.EAGER)
	private List<Task> tasks = Lists.newArrayList();

	public static Card create(Long id, String title, String description, CardStatus status, String color) {
		Card card = new Card();
		card.id = id;
		card.title = title;
		card.description = description;
		card.status = status;
		card.color = color;

		return card;
	}

	public void modify(String title, String description, CardStatus status, String color) {
		this.title = title;
		this.description = description;
		this.status = status;
		this.color = color;
	}

	public void changeStatus(CardStatus cardStatus) {
		this.status = cardStatus;
	}
}

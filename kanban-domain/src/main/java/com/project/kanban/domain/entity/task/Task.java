package com.project.kanban.domain.entity.task;

import com.project.kanban.domain.entity.CommonEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(schema = "kanban", name = "tasks")
public class Task extends CommonEntity {

	private Long cardId;
	private String name;
	private boolean done;

	public static Task create(Long id, Long cardId, String name, boolean done) {
		Task task = new Task();
		task.id = id;
		task.cardId = cardId;
		task.name = name;
		task.done = done;

		return task;
	}

	public void toggle() {
		this.done = !this.done;
	}
}

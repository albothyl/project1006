package com.project.kanban.application.task;

import com.project.kanban.domain.entity.card.Card;
import com.project.kanban.domain.entity.card.CardRepository;
import com.project.kanban.domain.entity.task.Task;
import com.project.kanban.domain.entity.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class TaskModifier {

	@Autowired
	private CardRepository cardRepository;

	@Autowired
	private TaskRepository taskRepository;


	public Task add(final Task task) {
		return taskRepository.save(task);
	}

	public void toggle(final Long cardId, final Long taskId) {
		final Card card = cardRepository.findOne(cardId);
		final Task task = findTaskById(card, taskId);
		task.toggle();

		cardRepository.save(card);
	}

	public void delete(final Long taskId) {
		taskRepository.delete(taskId);
	}

	private Task findTaskById(final Card card, final Long taskId) {
		return card.getTasks().stream()
			.filter(t -> t.getId().equals(taskId))
			.findAny().get();
	}
}

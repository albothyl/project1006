package com.project.kanban.application.task;

import com.project.kanban.domain.entity.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.project.kanban.application.task.TaskConverter.convertToEntity;

@CrossOrigin
@RestController
@RequestMapping(value = "/v1")
public class TaskController {

	@Autowired
	private TaskModifier taskModifier;


	@PostMapping(value = "/cards/{cardId}/tasks")
	public Task add(@PathVariable("cardId") Long cardId, @RequestBody TaskDto taskDto) {
		final Task task = convertToEntity(taskDto);

		return taskModifier.add(task);
	}

	@DeleteMapping(value = "/cards/{cardId}/tasks/{taskId}")
	public void delete(@PathVariable("cardId") Long cardId, @PathVariable("taskId") Long taskId) {
		taskModifier.delete(taskId);
	}

	@PatchMapping(value = "/cards/{cardId}/tasks/{taskId}")
	public void toggle(@PathVariable("cardId") Long cardId, @PathVariable("taskId") Long taskId) {
		taskModifier.toggle(cardId, taskId);
	}
}

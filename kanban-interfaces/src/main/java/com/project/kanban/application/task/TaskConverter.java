package com.project.kanban.application.task;

import com.project.kanban.domain.entity.task.Task;
import org.springframework.core.convert.converter.Converter;

import java.util.function.Function;

public class TaskConverter {

	public static final Converter<Task, TaskDto> TO_DTO = TaskConverter::convertToDto;

	public static TaskDto convertToDto(final Task task) {
		return TO_DTO_FUNC.apply(task);
	}

	public static final Function<Task, TaskDto> TO_DTO_FUNC = task -> TaskDto.builder()
		.id(task.getId())
		.cardId(task.getCardId())
		.name(task.getName())
		.done(task.isDone())
		.createdAt(task.getCreatedAt())
		.modifiedAt(task.getModifiedAt())
		.build();

	public static final Converter<TaskDto, Task> TO_ENTITY = TaskConverter::convertToEntity;

	public static Task convertToEntity(final TaskDto taskDto) {
		return TO_ENTITY_FUNC.apply(taskDto);
	}

	public static final Function<TaskDto, Task> TO_ENTITY_FUNC = taskDto -> Task.create(
		taskDto.getId(),
		taskDto.getCardId(),
		taskDto.getName(),
		taskDto.isDone()
	);
}

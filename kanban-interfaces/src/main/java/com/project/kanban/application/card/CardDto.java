package com.project.kanban.application.card;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.project.kanban.application.task.TaskDto;
import com.project.kanban.application.utils.LocalDateTimeJsonDeserializer;
import com.project.kanban.application.utils.LocalDateTimeJsonSerializer;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {
	private long id;
	private String title;
	private String description;
	private String color;
	private String status;
	private List<TaskDto> tasks;
	@JsonSerialize(using = LocalDateTimeJsonSerializer.class)
	@JsonDeserialize(using = LocalDateTimeJsonDeserializer.class)
	private LocalDateTime created_at;
	@JsonSerialize(using = LocalDateTimeJsonSerializer.class)
	@JsonDeserialize(using = LocalDateTimeJsonDeserializer.class)
	private LocalDateTime updated_at;
}

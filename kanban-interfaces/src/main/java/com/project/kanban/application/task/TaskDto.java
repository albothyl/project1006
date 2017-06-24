package com.project.kanban.application.task;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.project.kanban.application.utils.LocalDateTimeJsonDeserializer;
import com.project.kanban.application.utils.LocalDateTimeJsonSerializer;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
	private long id;
	private long cardId;
	private String name;
	private boolean done;
	@JsonSerialize(using = LocalDateTimeJsonSerializer.class)
	@JsonDeserialize(using = LocalDateTimeJsonDeserializer.class)
	private LocalDateTime createdAt;
	@JsonSerialize(using = LocalDateTimeJsonSerializer.class)
	@JsonDeserialize(using = LocalDateTimeJsonDeserializer.class)
	private LocalDateTime modifiedAt;
}

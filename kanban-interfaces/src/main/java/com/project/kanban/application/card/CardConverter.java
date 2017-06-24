package com.project.kanban.application.card;

import com.google.common.collect.Lists;
import com.project.kanban.application.task.TaskConverter;
import com.project.kanban.application.task.TaskDto;
import com.project.kanban.domain.entity.card.Card;
import com.project.kanban.domain.entity.card.CardStatus;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class CardConverter {

	public static final Converter<Card, CardDto> TO_DTO = CardConverter::convertToDto;

	public static CardDto convertToDto(final Card card) {
		return TO_DTO_FUNC.apply(card);
	}

	public static final Function<Card, CardDto> TO_DTO_FUNC = card ->
	{
		List<TaskDto> taskDtoList = Lists.newArrayList();
		if (!ObjectUtils.isEmpty(card.getTasks())) {
			taskDtoList = card.getTasks().stream().map(TaskConverter.TO_DTO_FUNC).collect(toList());
		}

		return CardDto.builder()
			.id(card.getId())
			.title(card.getTitle())
			.description(card.getDescription())
			.color(card.getColor())
			.status(card.getStatus().name())
			.tasks(taskDtoList)
			.created_at(card.getCreatedAt())
			.updated_at(card.getModifiedAt())
			.build();
	};

	public static final Converter<CardDto, Card> TO_ENTITY = CardConverter::convertToEntity;

	public static Card convertToEntity(final CardDto cardDto) {
		return TO_ENTITY_FUNC.apply(cardDto);
	}

	public static final Function<CardDto, Card> TO_ENTITY_FUNC = cardDto -> Card.create(
		cardDto.getId(),
		cardDto.getTitle(),
		cardDto.getDescription(),
		CardStatus.find(cardDto.getStatus()),
		cardDto.getColor()
	);
}

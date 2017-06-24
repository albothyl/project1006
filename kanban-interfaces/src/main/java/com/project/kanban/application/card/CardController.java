package com.project.kanban.application.card;

import com.project.kanban.domain.entity.card.Card;
import com.project.kanban.domain.entity.card.CardRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.project.kanban.application.card.CardConverter.TO_DTO_FUNC;
import static com.project.kanban.application.card.CardConverter.convertToDto;
import static com.project.kanban.application.card.CardConverter.convertToEntity;

@CrossOrigin
@RestController
@RequestMapping(value = "/v1")
public class CardController {

	@Autowired
	private CardRepository cardRepository;

	@Autowired
	private CardModifier cardModifier;


	@GetMapping(value = "/cards")
	public List<CardDto> getAllCardList() {
		return cardRepository.findAll().stream().map(TO_DTO_FUNC).collect(Collectors.toList());
	}

	@PostMapping(value = "/cards")
	public CardDto add(@RequestBody CardDto cardDto) {
		final Card card = convertToEntity(cardDto);
		final Card savedCard = cardRepository.save(card);

		return convertToDto(savedCard);
	}

	@PutMapping(value = "/cards/{cardId}")
	public CardDto modify(@PathVariable("cardId") Long cardId, @RequestBody CardDto cardDto) {
		final Card modifyCard = convertToEntity(cardDto);
		final Card modifiedCard = cardModifier.modify(cardId, modifyCard);

		return convertToDto(modifiedCard);
	}

	@PatchMapping(value = "/cards/{cardId}")
	public CardDto statusChange(@PathVariable("cardId") Long cardId, @RequestBody cardStatusDto cardStatusDto) {
		final Card changedCard = cardModifier.statusChange(cardId, cardStatusDto.getStatus(), cardStatusDto.getPosition());

		return convertToDto(changedCard);
	}

	@Getter
	private static class cardStatusDto {
		private String status;
		private int position;
	}
}

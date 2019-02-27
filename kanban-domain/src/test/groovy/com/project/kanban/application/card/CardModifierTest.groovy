package com.project.kanban.application.card

import com.project.kanban.domain.entity.card.Card
import com.project.kanban.domain.entity.card.CardRepository
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

class CardModifierTest extends Specification {

	def cardRepository = Mock(CardRepository)

	def sut = new CardModifier(cardRepository: cardRepository)

	def "card modify test"() {
		given:
		def card = EnhancedRandom.random(Card)
		def newCard = EnhancedRandom.random(Card)
		def cardId = EnhancedRandom.random(Long)

		when:
		sut.modify(cardId, newCard)

		then:
		1 * cardRepository.findOne(_) >> card
		1 * cardRepository.save(_)
	}
}

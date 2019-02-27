package com.project.kanban.domain.entity.card

import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

class CardTest extends Specification {

	def "card create test"() {
		given:
		def cardId = EnhancedRandom.random(Long)
		def cardTitle = EnhancedRandom.random(String)
		def cardDescription = EnhancedRandom.random(String)
		def cardStatus = EnhancedRandom.random(CardStatus)
		def cardColor = EnhancedRandom.random(String)

		when:
		def sut = Card.create(cardId, cardTitle, cardDescription, cardStatus, cardColor)

		then:
		with(sut) {
			id == cardId
			title == cardTitle
			description == cardDescription
			status == cardStatus
			color == cardColor
			tasks.isEmpty()
		}
	}

	def "card modify test"() {
		given:
		def sut = EnhancedRandom.random(Card)

		def cardTitle = EnhancedRandom.random(String)
		def cardDescription = EnhancedRandom.random(String)
		def cardStatus = EnhancedRandom.random(CardStatus)
		def cardColor = EnhancedRandom.random(String)

		when:
		sut.modify(cardTitle, cardDescription, cardStatus, cardColor)

		then:
		with(sut) {
			title == cardTitle
			description == cardDescription
			status == cardStatus
			color == cardColor
		}
	}

	def "card statusChange test"() {
		given:
		def sut = EnhancedRandom.random(Card)
		def cardStatus = EnhancedRandom.random(CardStatus)

		when:
		sut.changeStatus(cardStatus)

		then:
		sut.status == cardStatus
	}
}

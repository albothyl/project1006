package com.project.kanban.domain.entity.card

import com.project.kanban.application.card.CardFinder
import com.project.kanban.configuration.ConfigurationPropertiesApplicationContextInitializer
import com.project.kanban.configuration.KanbanDomainApplicationContextConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

@Transactional
@ActiveProfiles(profiles = "local")
@ContextConfiguration(initializers = ConfigurationPropertiesApplicationContextInitializer, classes = [KanbanDomainApplicationContextConfig])
class CardFinderIntegrationTest extends Specification {

	@Autowired
	CardFinder cardFinder

	def "Card Search by Criteria Test"() {
		given:
		def cardTitle = "Apply"
		def cardStatus = CardStatus.INPROGRESS
		def cardColor = "#c9c9c9"

		when:
		def cardList = cardFinder.searchByCriteria(cardTitle, cardStatus, cardColor)

		then:
		cardList.size() == 1
	}

	def "Card Search by QueryDsl Test"() {
		given:
		def cardTitle = "Apply"
		def cardStatus = CardStatus.INPROGRESS
		def cardColor = "#c9c9c9"

		when:
		def cardList = cardFinder.searchByQueryDsl(cardTitle, cardStatus, cardColor)

		then:
		cardList.size() == 1
	}
}

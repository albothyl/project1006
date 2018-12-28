package com.project.kanban.domain.entity.card

import com.project.kanban.configuration.ConfigurationPropertiesApplicationContextInitializer
import com.project.kanban.configuration.KanbanDomainJpaConfig
import io.github.benas.randombeans.api.EnhancedRandom
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.ObjectUtils
import spock.lang.Specification

@Transactional
@ActiveProfiles(profiles = "local")
@ContextConfiguration(initializers = ConfigurationPropertiesApplicationContextInitializer, classes = [KanbanDomainJpaConfig])
class CardEntityIntegrationTest extends Specification {

	@Autowired
	CardRepository cardRepository

	def "CARD CRUD TEST"() {
		given:
		Card card = EnhancedRandom.random(Card)

		when: "Save"
		Card saved_Card = cardRepository.save(card)

		then:
		assert saved_Card.getTitle().equals(card.getTitle())
		assert saved_Card.getDescription().equals(card.getDescription())
		assert saved_Card.getStatus() == card.getStatus()

		when: "Find"
		Card founded_card = cardRepository.findOne(saved_Card.getId())
		then:
		assert founded_card.getId().equals(saved_Card.getId())

		when: "Update"
		founded_card.title = "updatedCard"
		Card updated_card = cardRepository.saveAndFlush(founded_card)
		then:
		assert updated_card.getTitle().equals("updatedCard")

		when: "Delete"
		cardRepository.delete(updated_card.getId())
		Card deleted_card = cardRepository.findOne(updated_card.getId())
		then:
		assert ObjectUtils.isEmpty(deleted_card)
	}
}

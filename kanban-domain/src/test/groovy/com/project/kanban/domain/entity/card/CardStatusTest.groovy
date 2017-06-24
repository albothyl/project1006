package com.project.kanban.domain.entity.card

import spock.lang.Specification

class CardStatusTest extends Specification {
	def "FindTest"() {
		given:
		when:
		then:
		where:
		STATE << ["TODO", "IN", ""]
	}
}

package com.project.kanban.domain.entity.card

import spock.lang.Specification
import spock.lang.Unroll

class CardStatusTest extends Specification {

	@Unroll
	def "CardStatus에 해당하는 문자열(#STATE)이 들어왔을 경우 해당하는 #RESULT를 반환한다"() {
		when:
		def cardStatus = CardStatus.find(STATE)

		then:
		cardStatus == RESULT

		where:
		STATE        | RESULT
		"TODO"       | CardStatus.TODO
		"ToDo"       | CardStatus.TODO
		"todo"       | CardStatus.TODO
		"INPROGRESS" | CardStatus.INPROGRESS
		"InProgress" | CardStatus.INPROGRESS
		"inprogress" | CardStatus.INPROGRESS
		"DONE"       | CardStatus.DONE
		"Done"       | CardStatus.DONE
	}

	@Unroll
	def "잘못된 문자열(#STATE)이 들어왔을 경우 해당하는 #EXCEPTION을 발생한다"() {
		when:
		CardStatus.find(STATE)

		then:
		thrown(EXCEPTION)

		where:
		STATE | EXCEPTION
		""    | IllegalArgumentException
		null  | NullPointerException
	}
}

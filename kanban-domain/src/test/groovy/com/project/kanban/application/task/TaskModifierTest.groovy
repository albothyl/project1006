package com.project.kanban.application.task

import com.project.kanban.domain.entity.card.Card
import com.project.kanban.domain.entity.card.CardRepository
import com.project.kanban.domain.entity.task.Task
import com.project.kanban.domain.entity.task.TaskRepository
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

class TaskModifierTest extends Specification {

	def cardRepository = Mock(CardRepository)
	def taskRepository = Mock(TaskRepository)

	def sut = new TaskModifier(
			cardRepository: cardRepository,
			taskRepository: taskRepository
	)

	def "add test"() {
		given:
		def task = EnhancedRandom.random(Task)

		when:
		sut.add(task)

		then:
		1 * taskRepository.save(_)
	}

	def "delete test"() {
		given:
		def taskId = EnhancedRandom.random(Long)

		when:
		sut.delete(taskId)

		then:
		1 * taskRepository.delete(_)
	}

	def "Card에서 입력한 taskId의 task가 있으면 해당 task를 반환한다"() {
		given:
		def task = EnhancedRandom.random(Task)
		def card = EnhancedRandom.random(Card)
		card.tasks.add(task)

		when:
		def foundTask = sut.findTaskById(card, task.id)

		then:
		foundTask == task
	}
}

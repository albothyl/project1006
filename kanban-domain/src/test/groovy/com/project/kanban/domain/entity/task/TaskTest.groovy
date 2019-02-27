package com.project.kanban.domain.entity.task

import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification
import spock.lang.Unroll

class TaskTest extends Specification {

	def "task created test"() {
		given:
		def taskId = EnhancedRandom.random(Long)
		def taskCardId = EnhancedRandom.random(Long)
		def taskName = EnhancedRandom.random(String)
		def taskDone = EnhancedRandom.random(Boolean)

		when:
		def task = Task.create(taskId, taskCardId, taskName, taskDone)

		then:
		with(task) {
			id == taskId
			cardId == taskCardId
			name == taskName
			done == taskDone
		}
	}

	@Unroll
	def "task toggle test"() {
		given:
		def task = EnhancedRandom.random(Task, "done")
		task.done = DONE

		when:
		task.toggle()

		then:
		task.done == RESULT

		where:
		DONE  | RESULT
		true  | false
		false | true
	}
}

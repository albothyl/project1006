package com.project.kanban.domain.entity.task

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
class TaskEntityIntegrationTest extends Specification {

	@Autowired
	TaskRepository taskRepository

	def "TASK CRUD TEST"() {
		given:
		Task task = EnhancedRandom.random(Task)

		when: "Save"
		Task saved_task = taskRepository.save(task)
		then:
		assert saved_task.getCardId().equals(task.getCardId())
		assert saved_task.getName().equals(task.getName())
		assert saved_task.isDone() == task.isDone()
		assert saved_task.isDeleted() == task.isDeleted()

		when: "Find"
		Task founded_task = taskRepository.findOne(saved_task.getId())
		then:
		assert founded_task.getId().equals(saved_task.getId())

		when: "Update"
		founded_task.name = "updatedTask"
		Task updated_task = taskRepository.saveAndFlush(founded_task)
		then:
		assert updated_task.getName().equals("updatedTask")

		when: "Delete"
		taskRepository.delete(updated_task.getId())
		Task deleted_task = taskRepository.findOne(updated_task.getId())
		then:
		assert ObjectUtils.isEmpty(deleted_task)
	}
}

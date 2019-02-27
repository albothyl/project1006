package com.project.kanban.domain.entity.card;

import com.project.kanban.application.query.KanbanRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends KanbanRepository<Card, Long>, CardRepositoryCustom {
}

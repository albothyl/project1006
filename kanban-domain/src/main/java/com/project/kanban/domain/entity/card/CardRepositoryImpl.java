package com.project.kanban.domain.entity.card;

import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CardRepositoryImpl implements CardRepositoryCustom {

	@PersistenceContext(unitName = "kanban")
	private EntityManager entityManager;

	@Override
	public List<Card> search(String title, CardStatus status, String color) {

		JPAQuery jpaQuery = new JPAQuery(entityManager);
		QCard card = QCard.card;

		jpaQuery.from(card)
			.where(card.title.like("%" + title + "%"))
			.where(card.status.eq(status))
			.where(card.color.eq(color))
			.orderBy(card.id.desc());

		return jpaQuery.fetch();
	}
}

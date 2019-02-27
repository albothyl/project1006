package com.project.kanban.application.query;

import com.project.kanban.domain.entity.card.CardStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import javax.persistence.metamodel.SingularAttribute;

public class QuerySpec<T> {
	public Specification<T> equal(SingularAttribute<T, String> attribute, String value) {
		if (StringUtils.isBlank(value)) {
			return null;
		}

		return (root, query, builder) -> builder.equal(root.get(attribute), value);
	}

	public Specification<T> equal(SingularAttribute<T, Long> attribute, Long value) {
		if (ObjectUtils.isEmpty(value)) {
			return null;
		}

		return (root, query, builder) -> builder.equal(root.get(attribute), value);
	}

	public Specification<T> like(SingularAttribute<T, String> attribute, String value) {
		if (StringUtils.isBlank(value)) {
			return null;
		}

		return (root, query, builder) -> builder.like(root.get(attribute), "%" + value + "%");
	}

	public Specification<T> equalCardStatus(SingularAttribute<T, CardStatus> attribute, CardStatus value) {
		if (ObjectUtils.isEmpty(value)) {
			return null;
		}

		return (root, query, builder) -> builder.equal(root.get(attribute), value);
	}
}

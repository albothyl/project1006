package com.project.kanban.application.query;

import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class SpecCombineUtils {

	public static <T> Specification<T> combine(List<Specification<T>> specList) {
		Iterator<Specification<T>> specificationList = specList.stream()
			.filter(it -> it != null)
			.collect(Collectors.toList())
			.iterator();

		return combineSpecifications(specificationList);
	}

	private static <T> Specifications<T> combineSpecifications(Iterator<Specification<T>> iterator) {
		Specifications<T> where = Specifications.where(iterator.hasNext() ? iterator.next() : null);
		while (iterator.hasNext()) {
			where = where.and(iterator.next());
		}

		return where;
	}
}

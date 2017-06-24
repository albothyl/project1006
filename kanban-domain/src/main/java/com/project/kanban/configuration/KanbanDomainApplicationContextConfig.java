package com.project.kanban.configuration;

import com.project.kanban.domain.KanbanDomain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Import({ KanbanDomainJpaConfig.class })
@ComponentScan(basePackageClasses = { KanbanDomain.class })
public class KanbanDomainApplicationContextConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}

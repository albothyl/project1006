package com.project.kanban.configuration;

import com.project.kanban.application.KanbanApi;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = { KanbanApi.class })
public class KanbanApiServletApplicationContextConfig extends WebMvcConfigurerAdapter {

//	@Override
//	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//		argumentResolvers.add(new PageableHandlerMethodArgumentResolver());
//	}
}

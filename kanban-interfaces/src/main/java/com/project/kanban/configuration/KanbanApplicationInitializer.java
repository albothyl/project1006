package com.project.kanban.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class KanbanApplicationInitializer extends AbstractApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		loadRootApplicationContext(servletContext, KanbanDomainApplicationContextConfig.class);
		loadDefaultFilters(servletContext);
		addDispatcherServlet(servletContext, "apiServlet", KanbanApiServletApplicationContextConfig.class, "/api/*");
		addDispatcherServlet(servletContext, "webServlet", KanbanWebServletApplicationContextConfig.class, "/");
	}
}

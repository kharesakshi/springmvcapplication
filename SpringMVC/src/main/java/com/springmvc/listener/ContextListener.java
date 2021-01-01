package com.springmvc.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.WebListener;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.DispatcherServlet;

import com.springmvc.config.MvcConfiguration;

@WebListener
public class ContextListener implements ServletContextListener {
	
	ContextLoaderListener wrappedListener;
	
	public ContextListener() {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.registerShutdownHook();
		context.register(getContextConfiguration());
		wrappedListener = new ContextLoaderListener(context);
	}

	private Class<?> getContextConfiguration() {
		return MvcConfiguration.class;
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		final ServletContext servletContext = sce.getServletContext();
		wrappedListener.contextInitialized(sce);
		WebApplicationContext webAppCtx = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		Dynamic dynamic = servletContext.addServlet("SpringDispatcher", new DispatcherServlet(webAppCtx));
		dynamic.addMapping("/");
		dynamic.setLoadOnStartup(1);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		wrappedListener.contextDestroyed(sce);
	}

}

package org.groupsoft.training.spring_training_mvc;

import org.groupsoft.training.spring_training_mvc.config.AppConfig;
import org.groupsoft.training.spring_training_mvc.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("In Servlet Mapping");
		return new String[] { "/" };
	}

}

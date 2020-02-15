package com.amdocs.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.amdocs.config.AppConfig;

/**
 * It is a FC that we need to configure/provide 
 * Configuration Class & URL Mapping Details
 */

public class AppInit  extends AbstractAnnotationConfigDispatcherServletInitializer{

	// Provide Spring Config file as Input to FC(web.xml)
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[ ] {AppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	// URL Pattern
	@Override
	protected String[] getServletMappings() {
		return new String[ ] {"/"};
	}
}
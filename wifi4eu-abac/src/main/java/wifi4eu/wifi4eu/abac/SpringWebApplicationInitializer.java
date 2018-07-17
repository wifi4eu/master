package wifi4eu.wifi4eu.abac;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
public class SpringWebApplicationInitializer {
}
*/

public class SpringWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
		implements WebApplicationInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SpringRestConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringRestConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/api/*" };
	}
}

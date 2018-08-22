package eu.europa.ec.digit.eui.angular2clistarter.servlet;

import eu.europa.ec.digit.eui.angular2clistarter.spring.SpringRestConfiguration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer implements WebApplicationInitializer {
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

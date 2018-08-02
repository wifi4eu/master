package wifi4eu.wifi4eu.abac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan
public class ApplicationViewResolver implements WebMvcConfigurer{
	
	
	
	@Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /** Workaround to make file upload work with spring boot
	 * Reference: https://github.com/spring-projects/spring-boot/issues/2958
	 * */
	@Bean
	@Order(0)
	public MultipartFilter multipartFilter() {
		return new MultipartFilter();
	}

}

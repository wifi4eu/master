package wifi4eu.wifi4eu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/config/exportImport.properties")
public class ServiceConfig {
}

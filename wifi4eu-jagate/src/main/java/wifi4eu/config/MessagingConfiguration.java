package wifi4eu.config;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.TransactionAwareConnectionFactoryProxy;
import org.springframework.jms.support.destination.JndiDestinationResolver;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.jndi.JndiTemplate;
import wifi4eu.jagate.jms.handlers.JmsErrorHandler;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.Properties;

@Configuration
@EnableJms
@ComponentScan(basePackages = "wifi4eu.jagate.jms")
public class MessagingConfiguration {

	@Autowired
	private Environment env;

	@Autowired
	private JmsErrorHandler jmsErrorHandler;

	@Autowired
    private BeanFactory springContextBeanFactory;

	@Bean
	public ConnectionFactory jmsConnectionFactory() throws NamingException {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(InitialContext.PROVIDER_URL, "t3://eindhoven.cc.cec.eu.int:12140,maastricht.cc.cec.eu.int:12140");
		env.put(InitialContext.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		env.put(InitialContext.SECURITY_PRINCIPAL, "infsoread");
		env.put(InitialContext.SECURITY_CREDENTIALS, "infsoread1");
		Context context = new InitialContext(env);
		ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("jagate/jms/factory");

		return connectionFactory;
	}


	@Bean
	public DefaultJmsListenerContainerFactory esContainerFactory() throws NamingException{
		DefaultJmsListenerContainerFactory factory =
		new DefaultJmsListenerContainerFactory();
		factory.setErrorHandler(jmsErrorHandler);
		factory.setConnectionFactory(jmsConnectionFactory());
		//factory.setDestinationResolver(destinationResolver());
		//factory.setMessageConverter(new XStreamMessageConverter()); //to do, implement
		factory.setSessionTransacted(env.getProperty("jagate.jms.connections.transacted", Boolean.class));
		factory.setConcurrency(env.getProperty("jagate.jms.connections.concurrent"));

		return factory;
	}

}

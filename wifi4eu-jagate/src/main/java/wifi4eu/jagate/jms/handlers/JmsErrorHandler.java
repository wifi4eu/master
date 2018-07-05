package wifi4eu.jagate.jms.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;

@Service
public class JmsErrorHandler implements ErrorHandler {

    private static final Logger logger = LoggerFactory.getLogger(JmsErrorHandler.class);

    public void handleError(Throwable t) {
        logger.error("Error during JMS message processing", t);
    }

}

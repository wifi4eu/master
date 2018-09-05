package wifi4eu.wifi4eu.abac.integration;

import eu.cec.digit.ecas.client.script.ScriptClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EcasProxyTicketClient {

    private final Logger log = LoggerFactory.getLogger(EcasProxyTicketClient.class);

    private ScriptClient scriptClient;


    public EcasProxyTicketClient(ScriptClient scriptClient) {
        this.scriptClient = scriptClient;
    }

    public String getEcasServiceTicket(String targetService) {
            String serviceTicket = null;

            try {
                serviceTicket = this.scriptClient.getServiceTicket(targetService);
                log.info("ServiceTicket obtained for \"" + targetService + "\" starts with \"" + serviceTicket.substring(0, serviceTicket.length() / 2) + "\"");
            } catch (Exception e) {
                log.error("Unable to obtain a Service Ticket (check the ScriptClient configuration)", e);
            }

        return serviceTicket;
    }
}

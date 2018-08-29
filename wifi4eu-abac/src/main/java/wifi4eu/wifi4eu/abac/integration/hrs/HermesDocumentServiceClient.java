package wifi4eu.wifi4eu.abac.integration.hrs;

import generated.hrs.ws.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HermesDocumentServiceClient {

    private static final Logger logger = LoggerFactory.getLogger(HermesDocumentServiceClient.class);

    private DocumentService port;

    public HermesDocumentServiceClient(DocumentService port) {
        this.port = port;
    }
}

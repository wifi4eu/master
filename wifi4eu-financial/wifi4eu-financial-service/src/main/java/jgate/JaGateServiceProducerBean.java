package jgate;

//import eu.europa.ec.rdg.compass.processes.pdm.exception.PDMCPAException;
import eu.europa.ec.rdg.framework.service.util.ContextMap;
import eu.europa.ec.rdg.jagate.business.legalentity.v6.LegalEntityComponent;
import eu.europa.ec.rdg.jagate.ws.legalentity.v6.ILegalEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import java.util.Properties;

@Stateless
public class JaGateServiceProducerBean {

	private static Logger LOGGER = LoggerFactory.getLogger(JaGateServiceProducerBean.class);
	private static final String JAGATE_FINANCIAL_LEGALENTITY_WSDL_V6 = "http://158.167.240.93:1041/RDGServices/FinancialLegalEntity/v6?wsdl";

	public JaGateServiceProducerBean() {
		super();
	}
	
	public ILegalEntityService getLegalEntityServiceV6(){

		try{
			Properties properties = ContextMap.create(JAGATE_FINANCIAL_LEGALENTITY_WSDL_V6, "pdmurf_user", "pdmurf_user");
			return new LegalEntityComponent().getWebService(properties);
		}
		catch(Exception e) {
			LOGGER.error("WSDL: {}", JAGATE_FINANCIAL_LEGALENTITY_WSDL_V6, e);
			RuntimeException rte = new RuntimeException("JaGate LegalEntityService V6 WS not available", e);
			throw rte;
		}
	}

}

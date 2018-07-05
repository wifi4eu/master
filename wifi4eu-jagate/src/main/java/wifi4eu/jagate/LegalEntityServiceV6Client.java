package eu.europa.ec.research.fp.integration.abac.adapter.v6.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.PostConstruct;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceFeature;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import weblogic.jws.jaxws.ClientPolicyFeature;
import weblogic.jws.jaxws.policy.InputStreamPolicySource;
import weblogic.wsee.security.unt.ClientUNTCredentialProvider;
import weblogic.xml.crypto.wss.WSSecurityContext;

import com.sun.xml.ws.client.BindingProviderProperties;

import eu.europa.ec.rdg.jagate.ws.domain.event.base.v2.JagateAbstractEvent;
import eu.europa.ec.rdg.jagate.ws.domain.event.legalentity.finish.v2.ChangedFieldType;
import eu.europa.ec.rdg.jagate.ws.domain.event.legalentity.finish.v2.CreateOrUpdateFinishedEvent;
import eu.europa.ec.rdg.jagate.ws.domain.event.legalentity.interrupted.v1.CreateOrUpdateInterruptedEvent;
import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v4.FollowUpFelInfoType;
import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v4.RejectedFelInfoType;
import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6.BlockedFelInfoType;
import eu.europa.ec.rdg.jagate.ws.legalentity.v6.ILegalEntityService;
import eu.europa.ec.rdg.jagate.ws.legalentity.v6.LegalEntityServiceV6;
import eu.europa.ec.rdg.jagate.ws.legalentity.v6.interfaces.CreateLegalEntityRequestType;
import eu.europa.ec.rdg.jagate.ws.legalentity.v6.interfaces.CreateLegalEntityResponseType;
import eu.europa.ec.rdg.jagate.ws.legalentity.v6.interfaces.SearchLegalEntityRequestType;
import eu.europa.ec.rdg.jagate.ws.legalentity.v6.interfaces.SearchLegalEntityResponseType;
import eu.europa.ec.rdg.jagate.ws.legalentity.v6.interfaces.SearchLegalEntityResultType;
import eu.europa.ec.rdg.jagate.ws.legalentity.v6.interfaces.UpdateLegalEntityRequestType;
import eu.europa.ec.rdg.jagate.ws.legalentity.v6.interfaces.UpdateLegalEntityResponseType;
import eu.europa.ec.research.fp.eda.EventBodyTypeV1Processor;
import eu.europa.ec.research.fp.integration.abac.adapter.AbacIntegrationAdapter;
import eu.europa.ec.research.fp.integration.abac.adapter.AbacIntegrationAdapterListener;
import eu.europa.ec.research.fp.integration.abac.adapter.AbacProtocolBreachException;
import eu.europa.ec.research.fp.integration.abac.adapter.AbacUnreachableException;
import eu.europa.ec.research.fp.integration.abac.model.AbacEventData;
import eu.europa.ec.research.fp.integration.abac.model.ChangedField;
import eu.europa.ec.research.fp.integration.abac.model.FactCoreWithDocsDTO;
import eu.europa.ec.research.fp.integration.abac.model.jagaterequest.PendingJagateRequest;
import eu.europa.ec.research.fp.integration.abac.model.jagaterequest.PendingJagateRequestDAO;
import eu.europa.ec.research.fp.integration.support.service.IOPLogService;
import eu.europa.ec.research.fp.pdm.model.DocumentDTO;
import eu.europa.ec.research.fp.pdm.model.abac.AbacLegalEntityDTO;
import eu.europa.ec.research.fp.pdm.model.abac.AbacSearchCriteriaDTO;
import eu.europa.ec.research.fp.pdm.model.fact.revised.FactCoreDTO;
import eu.europa.ec.research.fp.support.application.ExecutionContext;
import eu.europa.ec.research.fp.support.log.LogRequired;
import eu.europa.ec.research.fp.support.log.LogRequired.FormatType;
import eu.europa.ec.research.fp.support.mapping.BeanMapper;

@Component("abac-integration-adapter")
@LogRequired(format = FormatType.SUMMARY)
public class AbacIntegrationAdapterImpl implements AbacIntegrationAdapter, EventBodyTypeV1Processor<JagateAbstractEvent>, ApplicationContextAware  {

    private static final Logger logger = Logger.getLogger(AbacIntegrationAdapterImpl.class);

	private static final int MAX_DOC_NUMBER = 3;

    @Value("classpath:JagateModel/WSDL-secured/LegalEntityV6.wsdl")
    private URL jagateLegalEntityWSDL;

    @Value("classpath:/JagateModel/Policies/digestUsernameToken2007.xml.policy")
    private String policy;

    @Value("${pdmurf.integration.abac.jagate.ws.username}")
    private String userName;

    @Value("${pdmurf.integration.abac.jagate.ws.endpoint}")
    private String endPoint;

    @Value("${pdmurf.integration.abac.jagate.ws.passwd}")
    private String passwd;

	@Value("${pdmurf.integration.abac.max.search.results}")
	private int maxSearchResults;

	@Value("${pdmurf.integration.abac.jagate.max.docs.size}")
	private long maxDocumentsSize;

	@Value("${pdmurf.integration.abac.jagate.on}")
	private boolean jagateIntegrationActive;

	@Value("${pdmurf.integration.abac.jagate.offline.fel}")
	private String diagnosticFel;

	@Value("${pdmurf.integration.abac.jagate.ws.timeout}")
	private int timeout;

	@Autowired
	private AbacIntegrationAdapterListener abacIntegrationAdapterListener;

	@Autowired
	private IOPLogService iOPLogService;

	@Autowired
	private PendingJagateRequestDAO pendingJagateRequestDAO;

	private boolean simulateUnreachable;

	private static final String JAGATE_REQUEST_ID_PREFIX = "JAG.";

	public static final String CUSTOMER_ONLY_FLAG = "customerOnlyFlag";

	public static final String SECOND_REGISTRATION_NUMBER = "secondRegNumber";

    private ApplicationContext ctx;

    private ILegalEntityService port;

    private final ReentrantLock AbacOnlineDetection_LOCK = new ReentrantLock();

	@Autowired
    @Qualifier("abac-integration-mapper-v6")
    private BeanMapper mapper;

    @PostConstruct
    public void init() {

        try {
        	QName qName = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6", "LegalEntityServiceV6");
        	LegalEntityServiceV6 legalEntityService = new LegalEntityServiceV6(jagateLegalEntityWSDL, qName);
            port = legalEntityService.getPort(ILegalEntityService.class, getWebServiceFeatures(policy));
            configurePort(port);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }

    // -----------------------------------------
    // 	IAbacIntegrationAdapter interface
    // -----------------------------------------

	@Override
	@LogRequired(format = FormatType.SUMMARY, logException=false)
	public List<AbacLegalEntityDTO> findBySearchCriteria(AbacSearchCriteriaDTO abacSearchCriteriaDTO) throws AbacUnreachableException {

		if (simulateUnreachable) {
			throwUnreachableException(new RuntimeException("simulated ABAC unreachable error!"));
		}

		if ((abacSearchCriteriaDTO.getVat() == null) && (abacSearchCriteriaDTO.getRegNbr() == null) && (abacSearchCriteriaDTO.getName() == null) &&
			(abacSearchCriteriaDTO.getCity() == null) && (abacSearchCriteriaDTO.getCountry() == null) && (abacSearchCriteriaDTO.getFelId() == null)) {
			throw new IllegalArgumentException("At least one of the search criteria fields needs to be non null");
		}

		SearchLegalEntityResponseType response = null;
		try{
			response = new LegalEntityServiceV6XMLDumpDecorator(port, iOPLogService).searchLegalEntity(mapper.map(abacSearchCriteriaDTO, SearchLegalEntityRequestType.class));
		}catch(Exception e) {
			throwUnreachableException(e);
		}
		List<SearchLegalEntityResultType> jagateSearchList = response.getLegalEntity();
		return mapper.mapList(jagateSearchList, AbacLegalEntityDTO.class);
	}

	@Override
	@LogRequired(format = FormatType.SUMMARY, logException=false)
	public AbacLegalEntityDTO findDetailsByFel(String felId) throws AbacUnreachableException {

		AbacSearchCriteriaDTO abacSearchCriteriaDTO = new AbacSearchCriteriaDTO();
		abacSearchCriteriaDTO.setFelId(felId);
		List<AbacLegalEntityDTO> searchFelList = findBySearchCriteria(abacSearchCriteriaDTO);
		if (CollectionUtils.isNotEmpty(searchFelList)) {
			return searchFelList.get(0);
		} else {
			return null;
		}
	}

	@Override
	@LogRequired(format = FormatType.SUMMARY, logException=false)
	public String requestFelCreationOrUpdate(FactCoreDTO coreDTO, List<DocumentDTO> documents, String worker) throws AbacUnreachableException, AbacProtocolBreachException {

		if (simulateUnreachable) {
			throwUnreachableException(new RuntimeException("simulated ABAC unreachable error!"));
		}

		FactCoreWithDocsDTO factCoreWithDocsDTO = new FactCoreWithDocsDTO();
		factCoreWithDocsDTO.setFactCoreDTO(coreDTO);
		factCoreWithDocsDTO.setListOfDocuments(documents);
		factCoreWithDocsDTO.setWorker(worker);
		String felId = coreDTO.getFelId();

		if ((felId == null) || (felId.startsWith(JAGATE_REQUEST_ID_PREFIX))){

			CreateLegalEntityRequestType creationRequest = mapper.map(factCoreWithDocsDTO, CreateLegalEntityRequestType.class);
			CreateLegalEntityResponseType creationResponse = null;
			try{
				creationResponse = new LegalEntityServiceV6XMLDumpDecorator(port, iOPLogService).createLegalEntity(creationRequest);
			}catch(Exception e) {
				throwUnreachableException(e);
			}
			if (creationResponse == null) {
				throw new AbacProtocolBreachException("Received a null response from Jagate while requesting fel creation for core : " + coreDTO);
			}else if (creationResponse.getLocalObjectForeignId() == null) {
				throw new AbacProtocolBreachException("Received no request Id from Jagate while requesting fel creation for core : " + coreDTO);
			}else {
				savePendingCreationRequest(creationResponse.getLocalObjectForeignId());
				return creationResponse.getLocalObjectForeignId();
			}

		} else {
			UpdateLegalEntityRequestType updateRequest = mapper.map(factCoreWithDocsDTO, UpdateLegalEntityRequestType.class);
			UpdateLegalEntityResponseType updateResponse = null;
			try{
				updateResponse = new LegalEntityServiceV6XMLDumpDecorator(port, iOPLogService).updateLegalEntity(updateRequest);
			}catch(Exception e) {
				throwUnreachableException(e);
			}
			if (updateResponse == null) {
				throw new AbacProtocolBreachException("Received a null response from Jagate while requesting fel update for core : " + coreDTO);
			}else if (updateResponse.getLocalObjectForeignId() == null) {
				throw new AbacProtocolBreachException("Received no request Id from Jagate while requesting fel update for core : " + coreDTO);
			}else {
				savePendingUpdateRequest(updateResponse.getLocalObjectForeignId(), felId);
				return felId;
			}
		}
	}

	@Override
	public int getSearchResultsMaximum() {
		return maxSearchResults;
	}

	@Override
	public long getMaximumSizeOfDocuments(){
		return maxDocumentsSize;
	}

	@Override
	public int getMaximumNumberOfDocuments() {
		return MAX_DOC_NUMBER;
	}

	@Override
	public String getRequestIdPrefix() {
		return JAGATE_REQUEST_ID_PREFIX;
	}

	@Override
	public void setJagateIntegrationActive(boolean active) {
		this.jagateIntegrationActive = active;
	}

	@Override
	public boolean isJagateIntegrationActive() {
		return this.jagateIntegrationActive;
	}

	@Override
	public void setAbacUnreachableSimulationActive(boolean active) {
		this.simulateUnreachable = active;
	}

	@Override
	public boolean isAbacUnreachableSimulationActive() {
		return this.simulateUnreachable;
	}

	@Override
	public boolean isSimulationOfAbacUnreachableActive() {
		return this.simulateUnreachable;
	}

	@Override
	public void simulateUnreachableAbac(boolean activateSimulation) {
		this.simulateUnreachable = activateSimulation;
	}

    // -----------------------------------------
	// EventProcessor interface
    // -----------------------------------------

	@Override
	public Object validate(JagateAbstractEvent t) {
		return null;
	}

	/**
	 * Handles the following types of events :
	 *
	 * CreateOrUpdateInterruptedEvent
	 *		requestId (temporary fel, mandatory)
	 *		felId (optional, present only if there is an official fel � not a temporary one)
	 *		errorMessage (optional, present if error)
	 *		rejectionInfo (optional, present if rejected)
	 *		followupInfo (optional, present if follow-up)
     *
	 *	CreateOrUpdateFinishedEvent
     *      requestId(temporary fel, optional. Present if the update came from a request initiated by a jagate client (e.g. PDM) only)
     *      felId (mandatory)
	 *		blockedInfo (present if status blocked, absent = valid)
	 *		ews (optional, if early warning flag is set)
     *
	 *	CreateOrUpdateInterruptedRequest is issued for creation and update requests initiated by a jagate client (e.g. PDM).
	 *	CreateorUpdateFinishedEvent  is issued for creation, update requests initiated by a jagate client (e.g. PDM), and updates initiated by ABAC.
     *
	 */
	@Override
	@LogRequired(format = FormatType.SUMMARY)
	public void process(final String eventId, JagateAbstractEvent event) {

		if (event instanceof CreateOrUpdateInterruptedEvent) {

			processCreateOrUpdateInterruptedEvent((CreateOrUpdateInterruptedEvent) event);

		} else if (event instanceof CreateOrUpdateFinishedEvent) {

			processCreateOrUpdateFinishedEvent((CreateOrUpdateFinishedEvent) event);

		} else {

			logger.warn("received event has no recognized type. it will be ignored... :" + event);
		}
	}

	// -----------------------------------------
	// private definitions
    // -----------------------------------------

	private void throwUnreachableException(Throwable cause) {
		// no need for two or more threads checking abac connectivity. one is enough.
		new AbacOnlineDetection().start();
		throw new AbacUnreachableException(cause);
	}

	private class AbacOnlineDetection extends Thread {

		public AbacOnlineDetection() {
			super("AbacOnlineDetection");
			setDaemon(true);
		}

		@Override
		public void run() {
			if (AbacOnlineDetection_LOCK.tryLock()) {
				try{
					while(true) {
						try{
							Thread.sleep(6000);
							if (!simulateUnreachable) {
								SearchLegalEntityRequestType diagnosticRequest = new SearchLegalEntityRequestType();
								diagnosticRequest.setFELId(diagnosticFel);
								new LegalEntityServiceV6XMLDumpDecorator(port, iOPLogService).searchLegalEntity(diagnosticRequest);
								logger.info("ABAC is online again. Offline recovery detection thread exiting.");
								break;
							}
						}catch(InterruptedException e) {
							logger.error(e);
							break;
						}catch(Exception e) {
							logger.info("ABAC failed online diagnostic [reason (full stacktrace in debug mode only) : " + e + "]. Retrying in 1 min...");
							if (logger.isDebugEnabled()) {
								logger.debug(e);
							}
						}
					}
					abacIntegrationAdapterListener.connectivityReestablished();
				}finally {
					AbacOnlineDetection_LOCK.unlock();
				}
			}
		}
	}

	private void processCreateOrUpdateInterruptedEvent(CreateOrUpdateInterruptedEvent interruptedEvent) throws AbacProtocolBreachException {

		String requestId = interruptedEvent.getRequestId();
		if (StringUtils.isEmpty(requestId)) {
			throw new AbacProtocolBreachException("Interruption event does not carry a requestId !");
		}

		String felId = interruptedEvent.getFelId();
		if (felId == null) { // true for creation requests. false for update requests
			felId = requestId;
		}

		try {
			boolean processed = false;
			String errorMsg = interruptedEvent.getErrorMessage();
			if (errorMsg != null) {
				abacIntegrationAdapterListener.felCreationOrUpdateError(felId, errorMsg);
				processed = true;
			}

			FollowUpFelInfoType followUpFelInfo = interruptedEvent.getFollowUpInfo();
			if (!processed && followUpFelInfo != null) {
				abacIntegrationAdapterListener.felCreationOrUpdateNeedsFollowUp(felId, followUpFelInfo.getFreeTextReason());
				processed = true;
			}

			RejectedFelInfoType rejectedFelInfoType = interruptedEvent.getRejectionInfo();
			if (!processed && rejectedFelInfoType != null) {
				abacIntegrationAdapterListener.felCreationOrUpdateRejected(felId, rejectedFelInfoType.getFreeTextReason(), rejectedFelInfoType.getMasterIdentifier());
				processed = true;
			}
			if(processed) {
				deletePendingRequest(requestId);
				logger.debug("processed pending request with ID: " + requestId);
			} else {
				logger.warn("interrupted event has no error, rejection, or followup nature. it will be ignored...:" + interruptedEvent);
			}
		} catch (Exception e) {
			logger.error("Unable to process CreateOrUpdateInterruptedEvent.", e);
		}
	}

	private void processCreateOrUpdateFinishedEvent(CreateOrUpdateFinishedEvent finishedEvent) {

		AbacEventData abacEventData = new AbacEventData();

		BlockedFelInfoType blockedFelInfo = finishedEvent.getBlockedInfo();
		if (blockedFelInfo != null) {
			abacEventData.setBlockedFelInfoCode(blockedFelInfo.getCode());
			abacEventData.setBlockedFelInfoReason(blockedFelInfo.getFreeTextReason());
			abacEventData.setHasBlockedFelInfo(true);
		}

		// Set the codes and messages to be communicated to VS
		List<ChangedFieldType> changedFields = finishedEvent.getChangedFields();
		if (CollectionUtils.isNotEmpty(changedFields)) {
			for (ChangedFieldType changedFieldType : changedFields) {
				ChangedField changedField = new ChangedField();
				changedField.setFreeTextReason(changedFieldType.getFreeTextReason());
			    if(CUSTOMER_ONLY_FLAG.equalsIgnoreCase(changedFieldType.getKey())){
                    changedField.setKey(CUSTOMER_ONLY_FLAG);
                    changedField.setValue(changedFieldType.getValue().isBooleanValue());
				} else if (SECOND_REGISTRATION_NUMBER.equalsIgnoreCase(changedFieldType.getKey())){
					changedField.setKey(SECOND_REGISTRATION_NUMBER);
					changedField.setValue(changedFieldType.getValue().getStringValue());
                }
			    if(changedField.getKey() != null) {
			    	abacEventData.getChangedFields().put(changedField.getKey(), changedField);
			    }
			}
		}

		String requestId = finishedEvent.getRequestId();
		String felId = finishedEvent.getFelId();

		if (requestId != null && isPendingRequest(requestId)) {
		    abacIntegrationAdapterListener.felCreationOrUpdate(requestId, felId, abacEventData);
			deletePendingRequest(requestId);
		} else {
			if (blockedFelInfo != null) {
				abacIntegrationAdapterListener.nonPDMInitiatedUpdateBlocked(felId, abacEventData);
			} else {
				abacIntegrationAdapterListener.nonPDMInitiatedUpdateAccepted(felId, abacEventData);
			}
		}
	}

	private void configurePort(Object port) {
        Map<String, Object> rc = ((BindingProvider) port).getRequestContext();
        rc.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endPoint);
        List<ClientUNTCredentialProvider> credProviders = new ArrayList<ClientUNTCredentialProvider>();
        credProviders.add(new ClientUNTCredentialProvider(userName.getBytes(), passwd.getBytes()));
        rc.put(WSSecurityContext.CREDENTIAL_PROVIDER_LIST, credProviders);
        rc.put(BindingProviderProperties.CONNECT_TIMEOUT, timeout);
        rc.put(BindingProviderProperties.REQUEST_TIMEOUT, timeout);

    }

    protected WebServiceFeature[] getWebServiceFeatures(String policyPath) throws IOException {
        List<WebServiceFeature> out = new LinkedList<WebServiceFeature>();
        ClientPolicyFeature clientPolicyFeature = new ClientPolicyFeature();
        Resource policyResource = ctx.getResource(policyPath);
        InputStream policyResourceInputStream = policyResource.getInputStream();
        clientPolicyFeature.setEffectivePolicy(new InputStreamPolicySource(policyResourceInputStream));
        out.add(clientPolicyFeature);
        return out.toArray(new WebServiceFeature[out.size()]);
    }

	private void savePendingCreationRequest(String requestId) {
		PendingJagateRequest pendingRequest = new PendingJagateRequest(requestId, null, ExecutionContext.getCurrentContext().getPic());
		pendingJagateRequestDAO.create(pendingRequest);
	}

	private void savePendingUpdateRequest(String requestId, String felId) {
		PendingJagateRequest pendingRequest = new PendingJagateRequest(requestId, felId, ExecutionContext.getCurrentContext().getPic());
		pendingJagateRequestDAO.create(pendingRequest);
	}

	private void deletePendingRequest(String requestId) {
		PendingJagateRequest request = pendingJagateRequestDAO.findById(requestId);
		if (request != null) {
			pendingJagateRequestDAO.delete(request);
		}
	}

	/**
	 * Legacy requests will not have their jag key stored in the new
	 * pending_requests table.
	 */
	private boolean isPendingRequest(String requestId) {
		return (pendingJagateRequestDAO.findById(requestId) != null);
	}

}

package eu.europa.ec.jagate.financiallegalentity;


import eu.europa.ec.jagate.financiallegalentity.exception.AbacProtocolBreachException;
import eu.europa.ec.jagate.financiallegalentity.exception.AbacUnreachableException;
import eu.europa.ec.jagate.financiallegalentity.model.LegalEntityJagate;
import eu.europa.ec.rdg.jagate.ws.domain.base.v2.AresDocument;
import eu.europa.ec.rdg.jagate.ws.domain.base.v2.AresDocumentList;
import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6.LawBodyRegistration;
import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6.LegalEntityAddressType;
import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6.LegalEntityStatusType;
import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6.PublicBodyAccountGroupType;
import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6.PublicLawBody;
import eu.europa.ec.rdg.jagate.ws.domain.visa.v1.BasicVisa;
import eu.europa.ec.rdg.jagate.ws.legalentity.v6.ILegalEntityService;
import eu.europa.ec.rdg.jagate.ws.legalentity.v6.interfaces.CreateLegalEntityRequestType;
import eu.europa.ec.rdg.jagate.ws.legalentity.v6.interfaces.CreateLegalEntityResponseType;
import eu.europa.ec.rdg.jagate.ws.legalentity.v6.interfaces.GetStatusByFelIdRequestType;
import eu.europa.ec.rdg.jagate.ws.legalentity.v6.interfaces.GetStatusByFelIdResponseType;
import eu.europa.ec.rdg.jagate.ws.legalentity.v6.interfaces.GetStatusByPicRequestType;
import eu.europa.ec.rdg.jagate.ws.legalentity.v6.interfaces.GetStatusByPicResponseType;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class JaGateServiceBean{

	public static final String VISA_AGENT_ID = "HAMEEMO";
	public static final String VISA_WORKFLOW_CENTER = "THIRD PARTY (0100001)";
	public static final String VISA_DG = "31016199";
	private Logger LOGGER=LoggerFactory.getLogger(JaGateServiceBean.class);
	
	@EJB
	private JaGateServiceProducerBean jagateServiceProducer;

	public LegalEntityStatus getLegalEntityStatusByPic(String pic) throws Exception
	{
		LOGGER.debug("start getting legal entity status for pic: " + pic);
		LegalEntityStatusType leStatusType=null;	
		
		if(StringUtils.isEmpty(pic)) throw new Exception("ERROR retrieving Legal Entity Status from Jagate, PIC cannot be null.");

		try{
			GetStatusByPicRequestType getStatusByPicRequest=new GetStatusByPicRequestType();
			getStatusByPicRequest.getPic().add(pic);
			
			ILegalEntityService port= jagateServiceProducer.getLegalEntityServiceV6();
			
			GetStatusByPicResponseType response= port.getStatusByPic(getStatusByPicRequest);
			if(CollectionUtils.isNotEmpty(response.getStatus())){
				leStatusType = response.getStatus().get(0);
			}
			return (null==leStatusType)? null : LegalEntityStatus.valueOf(leStatusType.getStatus());	
		}
		catch(Exception e){
			LOGGER.error("ERROR retrieving Legal Entity Status from Jagate for PIC:{}",pic, e);
			throw new Exception("ERROR retrieving Legal Entity Status from Jagate for PIC:"+pic+" - ", e);
		}
		
	}

	public LegalEntityStatus getLegalEntityStatusByFel(String fel) throws Exception
	{
		LegalEntityStatusType leStatusType=null;		
		
		if(StringUtils.isEmpty(fel)) throw new Exception("ERROR retrieving Legal Entity Status from Jagate, FEL cannot be null.");

		try{
			GetStatusByFelIdRequestType getStatusByFelRequest=new GetStatusByFelIdRequestType();
			getStatusByFelRequest.getFelId().add(fel);
			
			ILegalEntityService port= jagateServiceProducer.getLegalEntityServiceV6();			
			GetStatusByFelIdResponseType response= port.getStatusByFelId(getStatusByFelRequest);
			if(CollectionUtils.isNotEmpty(response.getStatus())){
				leStatusType = response.getStatus().get(0);
			}
			
			return (null==leStatusType)? null : LegalEntityStatus.valueOf(leStatusType.getStatus());	
		}
		catch(Exception e){
			LOGGER.error("ERROR retrieving Legal Entity Status from Jagate for FEL:{}",fel, e);
			throw new Exception("ERROR retrieving Legal Entity Status from Jagate for FEL:"+fel+" - ", e);
		}
		
	}

    public String requestFelCreation(LegalEntityJagate legalEntityJagate) throws Exception {

        CreateLegalEntityRequestType creationRequest = mapLegalEntityToCreateLegalEntityRequestType(legalEntityJagate);

        //add visa
		addVisaToCreateLegalEntityRequestType(creationRequest);

        CreateLegalEntityResponseType creationResponse = null;
        try{
            ILegalEntityService port= jagateServiceProducer.getLegalEntityServiceV6();
            creationResponse = port.createLegalEntity(creationRequest);
        }catch(Exception e) {
            throw new AbacUnreachableException(e);
        }
        if (creationResponse == null) {
            throw new AbacProtocolBreachException("Received a null response from Jagate while requesting fel creation for : " + legalEntityJagate);
        }else if (creationResponse.getLocalObjectForeignId() == null) {
            throw new AbacProtocolBreachException("Received no request Id from Jagate while requesting fel creation for : " + legalEntityJagate);
        }else {
            return creationResponse.getLocalObjectForeignId();
        }
    }

    private CreateLegalEntityRequestType mapLegalEntityToCreateLegalEntityRequestType(LegalEntityJagate legalEntityJagate){
        CreateLegalEntityRequestType creationRequest = new CreateLegalEntityRequestType();

		creationRequest.setPublicLawBody(new PublicLawBody());

		LawBodyRegistration lawBodyRegistration = new LawBodyRegistration();
		lawBodyRegistration.setRegistrationAuthority(legalEntityJagate.getRegistrationAuthority());
		lawBodyRegistration.setRegistrationDate(new java.sql.Timestamp(legalEntityJagate.getLegistrationDate().getTime()));
		lawBodyRegistration.setRegistrationNumber(legalEntityJagate.getLegalRegNumber());

		creationRequest.getPublicLawBody().setLanguageCode(legalEntityJagate.getOfficialLanguage());
		creationRequest.getPublicLawBody().setRegistrationInfo(lawBodyRegistration);


		creationRequest.getPublicLawBody().setAddress(new LegalEntityAddressType());
		creationRequest.getPublicLawBody().getAddress().setCity(legalEntityJagate.getCity());
		creationRequest.getPublicLawBody().getAddress().setPostalCode(legalEntityJagate.getPostalCode());
		creationRequest.getPublicLawBody().getAddress().setStreet(legalEntityJagate.getStreet());
        creationRequest.getPublicLawBody().getAddress().setCountry(legalEntityJagate.getCountry());
        creationRequest.getPublicLawBody().setAbacLegalForm(legalEntityJagate.getAbacLegalForm());

        creationRequest.getPublicLawBody().setAccountGroup(legalEntityJagate.getAccountGroupType());
		creationRequest.getPublicLawBody().setOfficialName(legalEntityJagate.getOfficialName());

		creationRequest.getPublicLawBody().setAccountGroup(PublicBodyAccountGroupType.OTHER_PUBLIC_BODIES);
		creationRequest.getPublicLawBody().setNonProfit(true);

		//todo: remove hardcoded reference
		AresDocument aresDoc= new AresDocument();
		aresDoc.setAresReference("Ares(2018)3164502");
		aresDoc.setDescription("GENERIC");

		creationRequest.setAresDocumentList(new AresDocumentList());
		creationRequest.getAresDocumentList().getAresDocument().add(aresDoc);

        return creationRequest;
    }

    private void addVisaToCreateLegalEntityRequestType(CreateLegalEntityRequestType creationRequest){
		BasicVisa basicVisa = new BasicVisa();
		basicVisa.setAgentId(VISA_AGENT_ID);
		basicVisa.setWorkflowCenterCode(VISA_WORKFLOW_CENTER);
		basicVisa.setDG(VISA_DG);

		creationRequest.setVisa(basicVisa);
	}
	
}

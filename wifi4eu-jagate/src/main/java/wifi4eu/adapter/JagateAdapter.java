package wifi4eu.adapter;

import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6.LawBodyRegistration;
import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6.LegalEntityAddressType;
import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6.PublicBodyAccountGroupType;
import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6.PublicLawBody;
import generated.jagate.model.CreateLegalEntityRequestType;
import generated.jagate.model.CreateLegalEntityResponseType;
import generated.jagate.model.coderef.V3.CodeRefType;
import generated.jagate.ws.domain.base.v2.AresDocument;
import generated.jagate.ws.domain.base.v2.AresDocumentList;
import generated.jagate.ws.domain.visa.v1.BasicVisa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import wifi4eu.jagate.LegalEntityServiceV6Client;
import wifi4eu.jagate.exception.AbacProtocolBreachException;
import wifi4eu.jagate.exception.AbacUnreachableException;
import wifi4eu.jagate.util.Date2XMLGregorianCalendarConverter;
import wifi4eu.model.Country;
import wifi4eu.model.Language;
import wifi4eu.model.Municipality;
import wifi4eu.service.CDMService;

import java.util.Date;

@Component
public class JagateAdapter {

	private Logger LOGGER= LoggerFactory.getLogger(JagateAdapter.class);

	@Autowired
	LegalEntityServiceV6Client legalEntityServiceV6Client;

	@Autowired
	CDMService cdmService;


	public static final String VISA_AGENT_ID = "alexand";
	public static final String VISA_WORKFLOW_CENTER = "REA_OPERATIONAL";
	public static final String VISA_DG = "31016199";

	
	public String createLegalEntity(Municipality municipality) {
		CreateLegalEntityRequestType creationRequest = mapLegalEntityToCreateLegalEntityRequestType(municipality);

		//add visa
		addVisaToCreateLegalEntityRequestType(creationRequest);

		String creationResponse = null;
		try{
			creationResponse = legalEntityServiceV6Client.requestFelCreation(creationRequest);
		}catch(Exception e) {
			throw new AbacUnreachableException(e);
		}
		if (creationResponse == null) {
			throw new AbacProtocolBreachException("Received a null response from Jagate while requesting fel creation for : " + municipality);
		}else {
			return creationResponse;
		}
	}


	private CreateLegalEntityRequestType mapLegalEntityToCreateLegalEntityRequestType(Municipality municipality){
		CreateLegalEntityRequestType creationRequest = new CreateLegalEntityRequestType();

		creationRequest.setPublicLawBody(new PublicLawBody());

		Language language = cdmService.findLanguageByCode("en");
		CodeRefType codeRefLanguage = new CodeRefType();
		codeRefLanguage.setId(language.getCcm2Code());
		codeRefLanguage.setAbbreviation(language.getCode());
		codeRefLanguage.setDescription(language.getName());

		Country country = municipality.getCountry();
		CodeRefType codeRefCountry = new CodeRefType();
		codeRefCountry.setId(country.getCcm2Code());
		codeRefCountry.setAbbreviation(country.getCode());
		codeRefCountry.setDescription(country.getName());

		creationRequest.getPublicLawBody().setLanguageCode(codeRefLanguage);


		creationRequest.getPublicLawBody().setAddress(new LegalEntityAddressType());
		creationRequest.getPublicLawBody().getAddress().setPostalCode(municipality.getPostalCode());
		creationRequest.getPublicLawBody().getAddress().setPoBox("000");
		creationRequest.getPublicLawBody().getAddress().setStreet(municipality.getAddress());
		creationRequest.getPublicLawBody().getAddress().setCity("BXL");
		creationRequest.getPublicLawBody().getAddress().setCountry(codeRefCountry);


		creationRequest.getPublicLawBody().setAccountGroup(PublicBodyAccountGroupType.OTHER_PUBLIC_BODIES);
		creationRequest.getPublicLawBody().setOfficialName(municipality.getName());
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

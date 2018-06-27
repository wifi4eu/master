package jgate;



import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6.LegalEntityStatusType;
import eu.europa.ec.rdg.jagate.ws.legalentity.v6.ILegalEntityService;
import eu.europa.ec.rdg.jagate.ws.legalentity.v6.interfaces.GetStatusByFelIdRequestType;
import eu.europa.ec.rdg.jagate.ws.legalentity.v6.interfaces.GetStatusByFelIdResponseType;
import eu.europa.ec.rdg.jagate.ws.legalentity.v6.interfaces.GetStatusByPicRequestType;
import eu.europa.ec.rdg.jagate.ws.legalentity.v6.interfaces.GetStatusByPicResponseType;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class JaGateServiceBean implements JaGateService {

	private Logger LOGGER=LoggerFactory.getLogger(JaGateServiceBean.class);
	
	@EJB
	private JaGateServiceProducerBean jagateServiceProducer;

	
	@Override
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

	@Override
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
	
}

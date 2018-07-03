package cec.budg.soatube.client.sync;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;

import eu.europa.ec.budg.abac.message.v1.MessageHeaderType;
import eu.europa.ec.budg.abac.soatube.service.es.sync.v1.Soatube;
import eu.europa.ec.budg.abac.soatube.service.es.sync.v1.Soatube_Service;
import eu.europa.ec.budg.abac.soatube.v1.SoatubeRequestType;
import eu.europa.ec.budg.abac.soatube.v1.SoatubeResponseType;

@Stateless(name="SoatubeWSClient")
public class SoatubeWSClient implements SoatubeWSClientLocal{
	
	@Resource(name="budg-endpoint")
	String endpoint;
	@Resource(name="budg-user")
	String user;
	@Resource(name="budg-password")
	String password;
	Soatube_Service service;
	
	private static Logger LOGGER = Logger.getLogger("budg.soa.logging");
	
	@PostConstruct
	private void init() {
		if (endpoint.endsWith("/")) endpoint = endpoint.substring(0, endpoint.length() - 1); 
		service=new Soatube_Service();
	}
	
	
	public HashMap<String, String> sendMessage(String messageCorrelationId) throws Exception{

		HashMap<String, String> retHashMap = new HashMap<String, String>();

		Soatube soaTubeSOAP = service.getSoatubeSOAP();
		SoatubeRequestType request=new SoatubeRequestType();
		MessageHeaderType msgHeader=new MessageHeaderType();		
		msgHeader.setMessageCorrelationId(messageCorrelationId);
		request.setMessageHeader(msgHeader);
	
		BindingProvider bp = (BindingProvider)soaTubeSOAP;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint + "/abac/service/Soatube/v1");
		//bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint + "/eu/europa/ec/budg/abac/soatube/v1");
		bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, user);
		bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
			
		SoatubeResponseType response = soaTubeSOAP.invoke(request);
		
		retHashMap.put("DB_NAME", response.getDatabaseName());
		retHashMap.put("APP_VERSION", response.getApplicationVersion());
		if(response.getMessageHeader()!=null){
			retHashMap.put("MessageCorID", response.getMessageHeader().getMessageCorrelationId());
		}
		
		
		return retHashMap;
	}
	
}

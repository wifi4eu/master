package wifi4eu.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifi4eu.adapter.JagateAdapter;
import wifi4eu.model.Municipality;

@Service
public class JagateService {
	
	@Autowired JagateAdapter jagateAdapter;
	@Autowired MunicipalityService municipalityService;
	
	public void createLegalEntities() {
    	
    	//Take all municipalities that still don't have a Jagate Key and request the creation of a Legal Entity 
    	List<Municipality> municipalities = municipalityService.listMunicipalitiesWithoutJagateKey();		
    	for (Municipality municipality : municipalities) {
    		
    		//Request creation of legal entity
    		String jagKey = jagateAdapter.createLegalEntity(municipality);
			municipality.setJagateKey(jagKey);
			
			//Save the time when the request to jagate was made
    		municipality.setJagateCreationRequestDate(Calendar.getInstance().getTime());
			municipalityService.saveMunicipality(municipality);			
		}
	}	

}

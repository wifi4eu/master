package wifi4eu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifi4eu.model.Municipality;

@Service
public class BatchService {

    @Autowired MunicipalityService municipalityService;
    @Autowired JagateService jagateService;
    
	public void startSynchronization() {
		List<Municipality> municipalities = municipalityService.listMunicipalitiesWithoutJagateKey();
		
    	for (Municipality municipality : municipalities) {
			jagateService.sync(municipality);
		}		
	}

}

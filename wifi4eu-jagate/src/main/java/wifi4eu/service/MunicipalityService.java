package wifi4eu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import wifi4eu.dao.MunicipalityRepository;
import wifi4eu.model.Municipality;

@Service
public class MunicipalityService {
	
	@Autowired private MunicipalityRepository municipalityRepository;
	@Autowired Environment env;
	
	private static int FIRST_PAGE = 0;
	
	public List<Municipality> listMunicipalitiesWithoutJagateKey() {
		Pageable pageable = new PageRequest(FIRST_PAGE, Integer.parseInt(env.getProperty("batch.jagate.max.records")));
		return municipalityRepository.findByJagateKeyIsNullAndJagateCreationRequestDateIsNullOrderByName(pageable);
	}
	
	public List<Municipality> listAllMunicipalities() {		
		return municipalityRepository.findByOrderByName();
	}
	
	public Municipality saveMunicipality(Municipality municipality) {
		return municipalityRepository.save(municipality);
	}

}

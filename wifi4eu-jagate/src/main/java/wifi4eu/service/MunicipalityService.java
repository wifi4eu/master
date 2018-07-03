package wifi4eu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifi4eu.dao.MunicipalityRepository;
import wifi4eu.model.Municipality;

@Service
public class MunicipalityService {
	
	@Autowired
	private MunicipalityRepository municipalityRepository;
	
	public List<Municipality> listMunicipalitiesWithoutJagateKey() {
		return municipalityRepository.findByJagateKeyIsNull();
	}

}

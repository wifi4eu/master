package wifi4eu.wifi4eu.abac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.abac.data.dto.IMonitoringRowProjection;
import wifi4eu.wifi4eu.abac.data.entity.Country;
import wifi4eu.wifi4eu.abac.data.repository.CountryRepository;
import wifi4eu.wifi4eu.abac.data.repository.LegalEntityRepository;

import java.util.List;


@Service
public class MonitoringService {

	@Autowired
	private LegalEntityRepository legalEntityRepository;

	@Autowired
	private CountryRepository countryRepository;

	public List<IMonitoringRowProjection> getMonitoringData(){
		return legalEntityRepository.findMonitoringData();
	}
	
	public List<Country> getCountries(){
		return countryRepository.findCountries();
	}
}

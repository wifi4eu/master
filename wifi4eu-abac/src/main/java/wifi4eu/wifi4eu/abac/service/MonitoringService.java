package wifi4eu.wifi4eu.abac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifi4eu.wifi4eu.abac.entity.Country;
import wifi4eu.wifi4eu.abac.entity.MonitoringRow;
import wifi4eu.wifi4eu.abac.repository.LegalEntityRepository;

@Service
public class MonitoringService {

	private LegalEntityRepository legalEntityRepository;
	
	@Autowired
	public MonitoringService(LegalEntityRepository legalEntityRepository) {
		this.legalEntityRepository=legalEntityRepository;
	}
	
	public List<MonitoringRow> getMonitoringData(){
		return legalEntityRepository.findMonitoringData();
	}
	
	public List<Country> getCountries(){
		return legalEntityRepository.findCountries();
	}
}

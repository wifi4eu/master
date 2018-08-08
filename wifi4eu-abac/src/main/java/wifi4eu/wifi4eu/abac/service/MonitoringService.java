package wifi4eu.wifi4eu.abac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifi4eu.wifi4eu.abac.data.dto.IMonitoringRowProjection;
import wifi4eu.wifi4eu.abac.data.dto.MonitoringRow;
import wifi4eu.wifi4eu.abac.data.repository.LegalEntityRepository;
import wifi4eu.wifi4eu.abac.data.entity.Country;


@Service
public class MonitoringService {

	private LegalEntityRepository legalEntityRepository;
	
	@Autowired
	public MonitoringService(LegalEntityRepository legalEntityRepository) {
		this.legalEntityRepository=legalEntityRepository;
	}
	
	public List<IMonitoringRowProjection> getMonitoringData(){
		return legalEntityRepository.findMonitoringData();
	}
	
	public List<Country> getCountries(){
		return legalEntityRepository.findCountries();
	}
}

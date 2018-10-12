package wifi4eu.wifi4eu.abac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifi4eu.wifi4eu.abac.data.dto.BAFMonitoringRow;
import wifi4eu.wifi4eu.abac.data.dto.MonitoringRow;
import wifi4eu.wifi4eu.abac.data.entity.Country;
import wifi4eu.wifi4eu.abac.data.entity.ImportLog;
import wifi4eu.wifi4eu.abac.data.repository.BankAccountRepository;
import wifi4eu.wifi4eu.abac.data.repository.CountryRepository;
import wifi4eu.wifi4eu.abac.data.repository.ImportLogRepository;
import wifi4eu.wifi4eu.abac.data.repository.LegalEntityRepository;

import java.util.List;

@Service
public class MonitoringService {

	@Autowired
	private LegalEntityRepository legalEntityRepository;
	
	@Autowired
	private BankAccountRepository bankAccountRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private ImportLogRepository importLogRepository;

	public List<MonitoringRow> getMonitoringData(){
		return legalEntityRepository.findMonitoringData();
	}
	
	public List<BAFMonitoringRow> getBAFMonitoringData(){
		return bankAccountRepository.findMonitoringData();
	}
	
	public List<Country> getCountries(){
		return countryRepository.findCountries();
	}
	
	public List<ImportLog> getImportLogByBatchRef(String batchRef){
		return importLogRepository.findByBatchRef(batchRef);
	}
}

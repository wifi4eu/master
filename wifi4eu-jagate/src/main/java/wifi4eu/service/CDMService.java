package wifi4eu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifi4eu.dao.CountryRepository;
import wifi4eu.dao.LanguageRepository;
import wifi4eu.model.Country;
import wifi4eu.model.Language;

@Service
public class CDMService {
	
	@Autowired private CountryRepository countryRepository;
	@Autowired private LanguageRepository languageRepository;
	
	public List<Country> listAllCountries() {		
		return countryRepository.findByOrderByName();
	}
	
	public Country findCountryByCode(String code) {		
		return countryRepository.findByCodeIgnoreCase(code);
	}
	
	public List<Language> listAllLanguages() {		
		return languageRepository.findByOrderByName();
	}
	
	public Language findLanguageByCode(String code) {		
		return languageRepository.findByCodeIgnoreCase(code);
	}		

}

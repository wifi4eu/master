package wifi4eu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import wifi4eu.model.Country;
import wifi4eu.model.Language;
import wifi4eu.service.CDMService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/cdm")
public class CDMController {
	
	@Autowired CDMService cdmService;
	
    @RequestMapping(value="/countries", method=RequestMethod.GET)
    public List<Country> listCountries() {
    	List<Country> countries = cdmService.listAllCountries();
    	return countries;
    }
    
    @RequestMapping(value="/countries/{code}", method=RequestMethod.GET)
    public Country getCountry(@PathVariable String code) {
    	Country country = cdmService.findCountryByCode(code);
    	return country;
    }
    
    @RequestMapping(value="/languages", method=RequestMethod.GET)
    public List<Language> listLanguages() {
    	List<Language> languages = cdmService.listAllLanguages();
    	return languages;
    }
    
    @RequestMapping(value="/languages/{code}", method=RequestMethod.GET)
    public Language getLanguage(@PathVariable String code) {
    	Language language = cdmService.findLanguageByCode(code);
    	return language;
    }      
}

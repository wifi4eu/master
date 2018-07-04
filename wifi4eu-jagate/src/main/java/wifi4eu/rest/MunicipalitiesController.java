package wifi4eu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import wifi4eu.model.Municipality;
import wifi4eu.service.MunicipalityService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/municipalities")
public class MunicipalitiesController {
	
	@Autowired MunicipalityService municipalityService;
	
    @RequestMapping(value="", method=RequestMethod.GET)
    public List<Municipality> listMunicipalities() {
    	List<Municipality> municipalities = municipalityService.listAllMunicipalities();
    	return municipalities;
    }

}

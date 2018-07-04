package wifi4eu.rest;

import java.util.List;

import generated.jagate.model.CheckBankAccountFormatRequestType;
import generated.jagate.model.CheckBankAccountFormatType;
import generated.jagate.ws.service.BankAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import wifi4eu.jagate.BankAccountServiceV5Client;
import wifi4eu.model.Municipality;
import wifi4eu.service.MunicipalityService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/municipalities")
public class MunicipalitiesController {
	
	@Autowired MunicipalityService municipalityService;

    @Autowired
    BankAccountServiceV5Client bankAccountServiceClient;
	
    @RequestMapping(value="", method=RequestMethod.GET)
    public List<Municipality> municipalities() {

        CheckBankAccountFormatRequestType checkBankAccountFormatRequestType = new CheckBankAccountFormatRequestType();
        checkBankAccountFormatRequestType.setContent(new CheckBankAccountFormatType());

        try {
            bankAccountServiceClient.checkBankAccountFormat(checkBankAccountFormatRequestType);
        } catch (BankAccountException e) {
            e.printStackTrace();
        }

        List<Municipality> municipalities = municipalityService.listAllMunicipalities();
    	return municipalities;
    }

}

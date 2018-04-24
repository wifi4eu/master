package wifi4eu.wifi4eu.service.voucher.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.service.location.NutsService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class VoucherAssignmentUtil {

   /* @Autowired
    private static NutsService nutsService;

    @Autowired
    private static RegistrationService registrationService;

    @Autowired
    private static MunicipalityService municipalityService;*/

    public static List<ApplicationDTO> assign(List<ApplicationDTO> inputList,
                                              HashMap<String, Integer> maxCountries,
                                              HashMap<String, Integer> minCountries,
                                              RegistrationService registrationService,
                                              MunicipalityService municipalityService,
                                              NutsService nutsService){

        List<ApplicationDTO> output = new ArrayList<>();
        HashMap<String, Integer> countriesCounter = initHash(nutsService);
        Integer totalAssignedVouchers = 0;

        for(ApplicationDTO application : inputList){
            // STEP 1: check if application is already in the outlist
            if(output.contains(application)){
              continue;
            }

            RegistrationDTO registration = registrationService.getRegistrationById(application.getRegistrationId());
            MunicipalityDTO municipality = municipalityService.getMunicipalityById(registration.getMunicipalityId());

            //STEP 2:

            if(countriesCounter.get(municipality.getCountry()) >= maxCountries.get(municipality.getCountry())){
                // Used for exclude the application from final list
                application.setVoucherAwarded(false);
            }
            else{
                countriesCounter.put(municipality.getCountry(), countriesCounter.get(municipality.getCountry()) + 1);
                // Used for include the application from final list
                application.setVoucherAwarded(true);
                totalAssignedVouchers += 1;
            }
            output.add(application);
        }
        return output;
    }

    private static HashMap<String, Integer> initHash(NutsService nutsService){
        HashMap<String, Integer> countryHash = new HashMap<>();
        List<NutsDTO> nutsDTOList = nutsService.getNutsByLevel(0);
        for (NutsDTO country: nutsDTOList){
            //TODO
            countryHash.put(country.getLabel(), 0);
        }
        return countryHash;
    }

}

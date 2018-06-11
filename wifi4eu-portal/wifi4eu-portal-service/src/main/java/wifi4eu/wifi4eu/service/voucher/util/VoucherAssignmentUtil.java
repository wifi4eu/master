package wifi4eu.wifi4eu.service.voucher.util;

import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.service.location.NutsService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VoucherAssignmentUtil {

    public static List<ApplicationDTO> assign(List<ApplicationDTO> inputList,
                                              HashMap<String, Integer> maxCountries,
                                              HashMap<String, Integer> minCountries,
                                              RegistrationService registrationService,
                                              MunicipalityService municipalityService,
                                              NutsService nutsService){
        List<ApplicationDTO> output = new ArrayList<>();
        return output;
    }

}

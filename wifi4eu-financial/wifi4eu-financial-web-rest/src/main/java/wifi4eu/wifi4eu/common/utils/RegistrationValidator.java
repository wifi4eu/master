package wifi4eu.wifi4eu.common.utils;

import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;

public class RegistrationValidator {

    public static void validate(RegistrationDTO registrationDTO) throws Exception {

        if(registrationDTO.getStatus() != 0){
            throw new Exception("Incorrect registration status");
        }
    }
}

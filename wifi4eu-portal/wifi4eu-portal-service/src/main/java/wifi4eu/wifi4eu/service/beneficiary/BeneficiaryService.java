package wifi4eu.wifi4eu.service.beneficiary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDTO;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BeneficiaryService {
    @Autowired
    UserService userService;

    @Autowired
    MunicipalityService municipalityService;

    @Autowired
    RegistrationService registrationService;

    @Transactional
    public List<RegistrationDTO> submitBeneficiaryRegistration(BeneficiaryDTO beneficiaryDTO) {
        List<UserDTO> resUsers = new ArrayList<>();
        for (UserDTO user : beneficiaryDTO.getUsers()) {
            user.setCreateDate(new Date().getTime());
            String password = UUID.randomUUID().toString().replace("-", "").substring(0, 7);
            user.setPassword(password);
            user.setVerified(false);
            resUsers.add(userService.createUser(user));
        }
        List<MunicipalityDTO> resMunicipalities = new ArrayList<>();
        for (MunicipalityDTO municipality : beneficiaryDTO.getMunicipalities()) {
            resMunicipalities.add(municipalityService.createMunicipality(municipality));
        }
        List<RegistrationDTO> registrations = new ArrayList<>();
        if (beneficiaryDTO.isRepresenting()) {
            UserDTO representativeUser = resUsers.get(0);
            if (representativeUser != null) {
                for (int i = 0; i < resMunicipalities.size(); i++) {
                    RegistrationDTO registration = new RegistrationDTO();
                    registration.setRole("Mayor");
                    registration.setMunicipalityId(resMunicipalities.get(i).getId());
                    registration.setUserId(resUsers.get(i + 1).getId());
                    registrations.add(registrationService.createRegistration(registration));
                    registration = new RegistrationDTO();
                    registration.setRole("Representative");
                    registration.setMunicipalityId(resMunicipalities.get(i).getId());
                    registration.setUserId(representativeUser.getId());
                    registrations.add(registrationService.createRegistration(registration));
                }
            } else {
                return null;
            }
        } else {
            for (int i = 0; i < resMunicipalities.size(); i++) {
                RegistrationDTO registration = new RegistrationDTO();
                registration.setRole("Mayor");
                registration.setMunicipalityId(resMunicipalities.get(i).getId());
                registration.setUserId(resUsers.get(i).getId());
                registrations.add(registrationService.createRegistration(registration));
            }
        }
        return registrations;
    }
}
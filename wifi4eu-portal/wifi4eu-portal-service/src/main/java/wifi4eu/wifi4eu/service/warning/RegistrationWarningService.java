package wifi4eu.wifi4eu.service.warning;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.entity.warnings.RegistrationWarning;
import wifi4eu.wifi4eu.mapper.registration.RegistrationMapper;
import wifi4eu.wifi4eu.mapper.registrationWarning.RegistrationWarningMapper;
import wifi4eu.wifi4eu.repository.registration.RegistrationRepository;
import wifi4eu.wifi4eu.repository.warning.RegistrationWarningRepository;
import wifi4eu.wifi4eu.service.location.LauService;
import wifi4eu.wifi4eu.service.mayor.MayorService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserService;

import java.util.List;


@Service
public class RegistrationWarningService {
    @Autowired
    MunicipalityService municipalityService;

    @Autowired
    UserService userService;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    LauService lauService;

    @Autowired
    MayorService mayorService;

    @Autowired
    RegistrationMapper registrationMapper;

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    RegistrationWarningRepository registrationWarningRepository;
    @Autowired
    RegistrationWarningMapper registrationWarningMapper;

    public boolean registrationHasWarning1(RegistrationDTO registration) {
        boolean warning1 = false;
        MunicipalityDTO municipality = municipalityService.getMunicipalityById(registration.getMunicipalityId());
        if (municipality != null) {
            LauDTO lau = lauService.getLauById(municipality.getLauId());
            MayorDTO mayor = mayorService.getMayorByMunicipalityId(municipality.getId());
            if (registration != null && mayor != null && lau != null) {
                UserDTO user = userService.getUserById(registration.getUserId());
                if (user.getEmail() != null && user.getEcasEmail() != null && mayor.getEmail() != null) {
                    switch (lau.getCountryCode().toUpperCase()) {
                        case "AT":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".at") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".at") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".at")) {
                                warning1 = true;
                            }
                            break;
                        case "BE":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".be") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".be") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".be")) {
                                warning1 = true;
                            }
                            break;
                        case "BG":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".bg") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".bg") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".bg")) {
                                warning1 = true;
                            }
                            break;
                        case "HR":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".hr") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".hr") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".hr")) {
                                warning1 = true;
                            }
                            break;
                        case "CY":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".cy") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".cy") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".cy")) {
                                warning1 = true;
                            }
                            break;
                        case "CZ":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".cz") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".cz") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".cz")) {
                                warning1 = true;
                            }
                            break;
                        case "DK":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".dk") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".dk") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".dk")) {
                                warning1 = true;
                            }
                            break;
                        case "EE":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".ee") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".ee") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".ee")) {
                                warning1 = true;
                            }
                            break;
                        case "FI":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".fi") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".fi") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".fi")) {
                                warning1 = true;
                            }
                            break;
                        case "FR":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".fr") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".fr") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".fr")) {
                                warning1 = true;
                            }
                            break;
                        case "DE":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".de") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".de") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".de")) {
                                warning1 = true;
                            }
                            break;
                        case "EL":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".el") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".el") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".el")) {
                                warning1 = true;
                            }
                            break;
                        case "HU":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".hu") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".hu") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".hu")) {
                                warning1 = true;
                            }
                            break;
                        case "IS":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".is") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".is") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".is")) {
                                warning1 = true;
                            }
                            break;
                        case "IE":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".ie") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".ie") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".ie")) {
                                warning1 = true;
                            }
                            break;
                        case "IT":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".it") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".it") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".it")) {
                                warning1 = true;
                            }
                            break;
                        case "LV":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".lv") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".lv") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".lv")) {
                                warning1 = true;
                            }
                            break;
                        case "LT":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".lt") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".lt") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".lt")) {
                                warning1 = true;
                            }
                            break;
                        case "LU":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".lu") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".lu") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".lu")) {
                                warning1 = true;
                            }
                            break;
                        case "MT":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".mt") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".mt") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".mt")) {
                                warning1 = true;
                            }
                            break;
                        case "NL":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".nl") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".nl") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".nl")) {
                                warning1 = true;
                            }
                            break;
                        case "NO":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".no") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".no") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".no")) {
                                warning1 = true;
                            }
                            break;
                        case "PL":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".pl") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".pl") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".pl")) {
                                warning1 = true;
                            }
                            break;
                        case "PT":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".pt") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".pt") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".pt")) {
                                warning1 = true;
                            }
                            break;
                        case "RO":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".ro") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".ro") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".ro")) {
                                warning1 = true;
                            }
                            break;
                        case "SK":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".sk") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".sk") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".sk")) {
                                warning1 = true;
                            }
                            break;
                        case "SI":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".si") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".si") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".si")) {
                                warning1 = true;
                            }
                            break;
                        case "ES":
                            if (!(
                                    user.getEmail().trim().toLowerCase().endsWith(".es") ||
                                            user.getEmail().trim().toLowerCase().endsWith(".cat") ||
                                            user.getEmail().trim().toLowerCase().endsWith(".gal") ||
                                            user.getEmail().trim().toLowerCase().endsWith(".eus")
                            ) || !(
                                    user.getEcasEmail().trim().toLowerCase().endsWith(".es") ||
                                            user.getEcasEmail().trim().toLowerCase().endsWith(".cat") ||
                                            user.getEcasEmail().trim().toLowerCase().endsWith(".gal") ||
                                            user.getEcasEmail().trim().toLowerCase().endsWith(".eus")
                            ) || !(
                                    mayor.getEmail().trim().toLowerCase().endsWith(".es") ||
                                            mayor.getEmail().trim().toLowerCase().endsWith(".cat") ||
                                            mayor.getEmail().trim().toLowerCase().endsWith(".gal") ||
                                            mayor.getEmail().trim().toLowerCase().endsWith(".eus")
                            )) {
                                warning1 = true;
                            }
                            break;
                        case "SE":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".se") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".se") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".se")) {
                                warning1 = true;
                            }
                            break;
                        case "UK":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".uk") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".uk") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".uk")) {
                                warning1 = true;
                            }
                            break;
                    }
                }
            }
        }
        return warning1;
    }


    public boolean registrationHasWarning3(RegistrationDTO registration) {
        boolean warning3 = false;
        MunicipalityDTO municipality = municipalityService.getMunicipalityById(registration.getMunicipalityId());
        if (municipality != null) {
            LauDTO lau = lauService.getLauById(municipality.getLauId());
            MayorDTO mayor = mayorService.getMayorByMunicipalityId(municipality.getId());
            if (registration != null && mayor != null && lau != null) {
                UserDTO user = userService.getUserById(registration.getUserId());
                if (user.getEmail() != null && user.getEcasEmail() != null && mayor.getEmail() != null) {
                    switch (lau.getCountryCode().toUpperCase()) {
                        case "AT":
                            if (!(user.getLang().toLowerCase().equals("de"))) {
                                warning3 = true;
                            }
                            break;
                        case "BE":
                            if (!(user.getLang().toLowerCase().equals("de") ||
                                    user.getLang().toLowerCase().equals("nl") ||
                                    user.getLang().toLowerCase().equals("fr"))) {
                                warning3 = true;
                            }
                            break;
                        case "BG":
                            if (!(user.getLang().toLowerCase().equals("bg"))) {
                                warning3 = true;
                            }
                            break;
                        case "HR":
                            if (!(user.getLang().toLowerCase().equals("hr"))) {
                                warning3 = true;
                            }
                            break;
                        case "CY":
                            if (!(user.getLang().toLowerCase().equals("el"))) {
                                warning3 = true;
                            }
                            break;
                        case "CZ":
                            if (!(user.getLang().toLowerCase().equals("cs"))) {
                                warning3 = true;
                            }
                            break;
                        case "DK":
                            if (!(user.getLang().toLowerCase().equals("da"))) {
                                warning3 = true;
                            }
                            break;
                        case "EE":
                            if (!(user.getLang().toLowerCase().equals("et"))) {
                                warning3 = true;
                            }
                            break;
                        case "FI":
                            if (!(user.getLang().toLowerCase().equals("fi") ||
                                    user.getLang().toLowerCase().equals("sv"))) {
                                warning3 = true;
                            }
                            break;
                        case "FR":
                            if (!(user.getLang().toLowerCase().equals("fr"))) {
                                warning3 = true;
                            }
                            break;
                        case "DE":
                            if (!(user.getLang().toLowerCase().equals("de"))) {
                                warning3 = true;
                            }
                            break;
                        case "EL":
                            if (!(user.getLang().toLowerCase().equals("el"))) {
                                warning3 = true;
                            }
                            break;
                        case "HU":
                            if (!(user.getLang().toLowerCase().equals("hu"))) {
                                warning3 = true;
                            }
                            break;
                        case "IS":
                            if (!(user.getLang().toLowerCase().equals("en"))) {
                                warning3 = true;
                            }
                            break;
                        case "IE":
                            if (!(user.getLang().toLowerCase().equals("en") ||
                                    user.getLang().toLowerCase().equals("ga"))) {
                                warning3 = true;
                            }
                            break;
                        case "IT":
                            if (!(user.getLang().toLowerCase().equals("it"))) {
                                warning3 = true;
                            }
                            break;
                        case "LV":
                            if (!(user.getLang().toLowerCase().equals("lv"))) {
                                warning3 = true;
                            }
                            break;
                        case "LT":
                            if (!(user.getLang().toLowerCase().equals("lt"))) {
                                warning3 = true;
                            }
                            break;
                        case "LU":
                            if (!(user.getLang().toLowerCase().equals("fr") ||
                                    user.getLang().toLowerCase().equals("de"))) {
                                warning3 = true;
                            }
                            break;
                        case "MT":
                            if (!(user.getLang().toLowerCase().equals("mt") ||
                                    user.getLang().toLowerCase().equals("en"))) {
                                warning3 = true;
                            }
                            break;
                        case "NL":
                            if (!(user.getLang().toLowerCase().equals("nl"))) {
                                warning3 = true;
                            }
                            break;
                        case "NO":
                            if (!(user.getLang().toLowerCase().equals("en"))) {
                                warning3 = true;
                            }
                            break;
                        case "PL":
                            if (!(user.getLang().toLowerCase().equals("pl"))) {
                                warning3 = true;
                            }
                            break;
                        case "PT":
                            if (!(user.getLang().toLowerCase().equals("pt"))) {
                                warning3 = true;
                            }
                            break;
                        case "RO":
                            if (!(user.getLang().toLowerCase().equals("ro"))) {
                                warning3 = true;
                            }
                            break;
                        case "SK":
                            if (!(user.getLang().toLowerCase().equals("sk"))) {
                                warning3 = true;
                            }
                            break;
                        case "SI":
                            if (!(user.getLang().toLowerCase().equals("sl"))) {
                                warning3 = true;
                            }
                            break;
                        case "ES":
                            if (!(user.getLang().toLowerCase().equals("es"))) {
                                warning3 = true;
                            }
                            break;
                        case "SE":
                            if (!(user.getLang().toLowerCase().equals("sv"))) {
                                warning3 = true;
                            }
                            break;
                        case "UK":
                            if (!(user.getLang().toLowerCase().equals("en"))) {
                                warning3 = true;
                            }
                            break;
                    }
                }
            }
        }
        return warning3;
    }

    public List<RegistrationDTO> getRegistrationsByIp(String ip) {
        return registrationMapper.toDTOList(Lists.newArrayList(registrationRepository.findByIpRegistration(ip)));
    }

    public boolean registrationHasWarning2(RegistrationDTO registration) {
        boolean warning2 = false;
        MunicipalityDTO municipality = municipalityService.getMunicipalityById(registration.getMunicipalityId());
        if (municipality != null && registration != null) {
            List<RegistrationDTO> ipRegistrations = getRegistrationsByIp(registration.getIpRegistration());
            for (RegistrationDTO ipRegistration : ipRegistrations) {
                MunicipalityDTO ipMunicipality = municipalityService.getMunicipalityById(ipRegistration.getMunicipalityId());
                if (ipRegistration.getId() != registration.getId() && ipMunicipality.getLauId() == municipality.getLauId()) {
                    warning2 = true;
                }
            }
        }
        return warning2;
    }

    public ResponseDTO uploadRegistrationWarnings() {
        ResponseDTO responseDTO = new ResponseDTO();
        List<Registration> oldRegistrations = Lists.newArrayList(registrationRepository.findAll());

        for (Registration oldRegistration : oldRegistrations) {
            createWarningsByRegistration(registrationMapper.toDTO(oldRegistration));
        }
        responseDTO.setSuccess(true);
        return responseDTO;
    }

    public void createWarningsByRegistration(RegistrationDTO registrationDTO) {
        if (registrationHasWarning1(registrationDTO)) {
            Registration registration = registrationMapper.toEntity(registrationDTO);
            RegistrationWarning registrationWarnings = new RegistrationWarning();
            registrationWarnings.setRegistration(registration);
            registrationWarnings.setWarning(1);
            registrationWarningRepository.save(registrationWarnings);
        }

//        if (registrationHasWarning2(registrationDTO)) {
//            Registration registration = registrationMapper.toEntity(registrationDTO);
//            RegistrationWarning registrationWarnings = new RegistrationWarning();
//            registrationWarnings.setRegistration(registration);
//            registrationWarnings.setWarning(2);
//            registrationWarningRepository.save(registrationWarnings);
//        }

        if (registrationHasWarning3(registrationDTO)) {
            Registration registration = registrationMapper.toEntity(registrationDTO);
            RegistrationWarning registrationWarnings = new RegistrationWarning();
            registrationWarnings.setRegistration(registration);
            registrationWarnings.setWarning(3);
            registrationWarningRepository.save(registrationWarnings);
        }
    }

    public List<RegistrationWarningDTO> getWarningsByRegistrationId(int registrationId) {
        return registrationWarningMapper.toDTOList(Lists.newArrayList(registrationWarningRepository.findAllByRegistrationId(registrationId)));
    }


}

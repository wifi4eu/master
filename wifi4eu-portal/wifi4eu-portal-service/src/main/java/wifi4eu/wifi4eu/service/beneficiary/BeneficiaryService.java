package wifi4eu.wifi4eu.service.beneficiary;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.enums.RegistrationStatus;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.thread.ThreadService;
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

    @Autowired
    ThreadService threadService;

    private final Logger _log = LoggerFactory.getLogger(BeneficiaryService.class);

    private List<Integer> municipalitiesLauIdToHold = new ArrayList<>();
    private final String MAYOR = "Mayor";
    private final String REPRESENTATIVE = "Representative";

    @Transactional
    public List<RegistrationDTO> submitBeneficiaryRegistration(BeneficiaryDTO beneficiaryDTO) {
        List<UserDTO> resUsers = getUserList(beneficiaryDTO);
        List<MunicipalityDTO> resMunicipalities = getMunicipalityList(beneficiaryDTO);

        List<RegistrationDTO> registrations = new ArrayList<>();
        if (beneficiaryDTO.isRepresenting()) {
            UserDTO representativeUser = resUsers.get(0);
            if (representativeUser != null) {
                for (int i = 0; i < resMunicipalities.size(); i++) {
                    RegistrationDTO registration = generateNewRegistration(MAYOR, resMunicipalities.get(i).getId(), resUsers.get(i + 1).getId(), resMunicipalities.get(i));
                    registrations.add(registrationService.createRegistration(registration));

                    registration = generateNewRegistration(REPRESENTATIVE, resMunicipalities.get(i).getId(), representativeUser.getId(), resMunicipalities.get(i));
                    registrations.add(registrationService.createRegistration(registration));
                }
            } else {
                return null;
            }
        } else {
            for (int i = 0; i < resMunicipalities.size(); i++) {
                RegistrationDTO registration = generateNewRegistration(MAYOR, resMunicipalities.get(i).getId(), resUsers.get(i).getId(), resMunicipalities.get(i));
                registrations.add(registrationService.createRegistration(registration));
            }
        }
        return registrations;
    }

    private RegistrationDTO generateNewRegistration(final String role, final int municipalityId, final int userId, final MunicipalityDTO aMunicipalityDTO) {
        RegistrationDTO registration = new RegistrationDTO();

        registration.setRole(role);
        registration.setMunicipalityId(municipalityId);
        registration.setUserId(userId);
        registration.setStatus(generateRegistrationStatus(aMunicipalityDTO));

        return registration;
    }

    private int generateRegistrationStatus(MunicipalityDTO aMunicipalityDTO) {
        if (municipalitiesLauIdToHold.contains(aMunicipalityDTO.getLauId())) {
            return RegistrationStatus.HOLD.getValue();
        } else {
            return RegistrationStatus.OK.getValue();
        }
    }

    private List<UserDTO> getUserList(final BeneficiaryDTO beneficiaryDTO) {
        List<UserDTO> resUsers = new ArrayList<>();

        for (UserDTO user : beneficiaryDTO.getUsers()) {
            user.setCreateDate(new Date().getTime());
            String password = "12345678";
            user.setPassword(password);
            user.setVerified(true);
            resUsers.add(userService.createUser(user));
        }

        return resUsers;
    }

    private List<MunicipalityDTO> getMunicipalityList(final BeneficiaryDTO beneficiaryDTO) {
        List<MunicipalityDTO> resMunicipalities = new ArrayList<>();

        for (MunicipalityDTO municipality : beneficiaryDTO.getMunicipalities()) {
            List<MunicipalityDTO> municipalitiesWithSameLau = municipalityService.getMunicipalitiesByLauId(municipality.getLauId());
            if (!municipalitiesWithSameLau.isEmpty()) {
                if (threadService.getThreadByLauId(municipality.getLauId()) == null) {
                    ThreadDTO thread = new ThreadDTO();
                    thread.setLauId(municipality.getLauId());
                    thread.setTitle(municipality.getName());
                    threadService.createThread(thread);
                }
                updateRegistrationStatusToHold(municipalitiesWithSameLau);
                municipalitiesLauIdToHold.add(municipality.getLauId());
            }
            resMunicipalities.add(municipalityService.createMunicipality(municipality));
        }
        return resMunicipalities;
    }

    /**
     * The update registration status to hold
     */
    private void updateRegistrationStatusToHold(List<MunicipalityDTO> municipalitiesWithSameLau) {
        final String LOG_STATUS_2_HOLD = "Registraion Id {0} updated to the status HOLD";

        for (MunicipalityDTO aMunicipality : municipalitiesWithSameLau) {
            final List<RegistrationDTO> registrations = registrationService.getRegistrationsByMunicipalityId(aMunicipality.getId());
            for (RegistrationDTO aRegistrationDTO : registrations) {
                aRegistrationDTO.setStatus(RegistrationStatus.HOLD.getValue());
                registrationService.createRegistration(aRegistrationDTO);

                _log.info(MessageFormat.format(LOG_STATUS_2_HOLD, aRegistrationDTO.getId()));
            }
        }
    }
}
package wifi4eu.wifi4eu.service.beneficiary;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.enums.RegistrationStatus;
import wifi4eu.wifi4eu.service.mayor.MayorService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.thread.ThreadService;
import wifi4eu.wifi4eu.service.user.UserService;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Autowired
    MayorService mayorService;

    private final Logger _log = LoggerFactory.getLogger(BeneficiaryService.class);

    private List<Integer> municipalitiesLauIdToHold = new ArrayList<>();
    private final String MAYOR = "Mayor";
    private final String REPRESENTATIVE = "Representative";

    @Transactional
    public List<RegistrationDTO> submitBeneficiaryRegistration(BeneficiaryDTO beneficiaryDTO) throws Exception {
        UserDTO user = beneficiaryDTO.getUser();
        user.setCreateDate(new Date().getTime());
        String password = "12345678";
        user.setPassword(password);
        user.setVerified(true);
        UserDTO resUser = userService.createUser(user);
        List<MunicipalityDTO> resMunicipalities = getMunicipalityList(beneficiaryDTO);
        List<RegistrationDTO> registrations = new ArrayList<>();
        for (int i = 0; i < resMunicipalities.size(); i++) {
            MunicipalityDTO municipality = resMunicipalities.get(i);
            MayorDTO mayor = beneficiaryDTO.getMayors().get(i);
            mayor.setMunicipalityId(municipality.getId());
            mayorService.createMayor(mayor);
            RegistrationDTO registration = generateNewRegistration(REPRESENTATIVE, municipality, resUser.getId());
            registrations.add(registrationService.createRegistration(registration));
        }
        return registrations;
    }

    private RegistrationDTO generateNewRegistration(final String role, final MunicipalityDTO municipality, final int userId) {
        RegistrationDTO registration = new RegistrationDTO();
        registration.setRole(role);
        registration.setMunicipalityId(municipality.getId());
        registration.setUserId(userId);
        registration.setStatus(generateRegistrationStatus(municipality));
        return registration;
    }

    private int generateRegistrationStatus(MunicipalityDTO aMunicipalityDTO) {
        if (municipalitiesLauIdToHold.contains(aMunicipalityDTO.getLauId())) {
            return RegistrationStatus.HOLD.getValue();
        } else {
            return RegistrationStatus.OK.getValue();
        }
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

    public List<BeneficiaryDTO> getBeneficiariesByThreadId(int threadId) {
        List<BeneficiaryDTO> beneficiaries = new ArrayList<>();
        ThreadDTO thread = threadService.getThreadById(threadId);
        List<MunicipalityDTO> municipalities = municipalityService.getMunicipalitiesByLauId(thread.getLauId());
        for (MunicipalityDTO municipality : municipalities) {
            System.out.println("MUNICIPALITY whatever");
            BeneficiaryDTO beneficiary = new BeneficiaryDTO();
            List<RegistrationDTO> registrations = registrationService.getRegistrationsByMunicipalityId(municipality.getId());
            for (RegistrationDTO registration : registrations) {
                System.out.println("REGISTRATION something");
                if (registration.getRole().equals(REPRESENTATIVE)) {
                    System.out.println("Let's set the user");
                    beneficiary.setUser(userService.getUserById(registration.getUserId()));
                }
            }
            List<MunicipalityDTO> municipalityList = new ArrayList<>();
            municipalityList.add(municipality);
            beneficiary.setMunicipalities(municipalityList);
            if (registrations.size() > 1) {
                beneficiary.setRepresentsMultipleMunicipalities(true);
            } else {
                beneficiary.setRepresentsMultipleMunicipalities(false);
            }
            beneficiaries.add(beneficiary);
        }
        return beneficiaries;
    }
}
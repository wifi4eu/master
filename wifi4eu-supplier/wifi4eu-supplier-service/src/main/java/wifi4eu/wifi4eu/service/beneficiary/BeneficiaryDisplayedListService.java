package wifi4eu.wifi4eu.service.beneficiary;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.cns.CNSManager;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.mapper.beneficiary.BeneficiaryDisplayedListMapper;
import wifi4eu.wifi4eu.mapper.registration.RegistrationMapper;
import wifi4eu.wifi4eu.repository.beneficiary.BeneficiaryDisplayedListRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationRepository;

@Service("beneficiary")
public class BeneficiaryDisplayedListService {

    @Autowired
    BeneficiaryDisplayedListMapper beneficiaryDisplayedListMapper;

    @Autowired
    BeneficiaryDisplayedListRepository beneficiaryDisplayedListRepository;

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    RegistrationMapper registrationMapper;

    @Autowired
    CNSManager cnsManager;

    private final Logger _log = LoggerFactory.getLogger(BeneficiaryDisplayedListService.class);

    @Transactional
    public ResponseDTO findBeneficiariesList() {
        ResponseDTO response = new ResponseDTO();
        response.setSuccess(true);
        response.setData(beneficiaryDisplayedListMapper.toDTOList(Lists.newArrayList(beneficiaryDisplayedListRepository.findBeneficiariesList())));
        return response;
    }

    @Transactional
    public ResponseDTO confirmWifiIndicatorByMunicipalityId(int id) {
        ResponseDTO response = new ResponseDTO();
        Registration registration = registrationRepository.findByMunicipalityIdAndStatus(id, 2);
        if (registration != null) {
            registration.setWifiIndicator(true);
            registrationRepository.save(registration);
            String email = registration.getUser().getEmail();
            String name = registration.getUser().getName();
            response.setSuccess(true);
            // response.setData(registrationMapper.toDTO(registration));
            // response.setData(registration);
            response.setData("WiFi Indicator updated successfully");
            cnsManager.sendInstallationConfirmationNotification(email,name);
        } else {
            response.setSuccess(false);
            response.setData("Error querying municipality - registration");
            response.setError(new ErrorDTO(404, "error.404.beneficiaryNotFound"));
        }
        return response;
    }

}

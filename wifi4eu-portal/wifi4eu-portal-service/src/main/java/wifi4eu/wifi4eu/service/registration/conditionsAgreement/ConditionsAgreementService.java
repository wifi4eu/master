package wifi4eu.wifi4eu.service.registration.conditionsAgreement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.ConditionsAgreementDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.entity.registration.ConditionsAgreement;
import wifi4eu.wifi4eu.mapper.registration.ConditionsAgreementMapper;
import wifi4eu.wifi4eu.repository.registration.ConditionsAgreementRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.call.CallService;

import java.util.Date;

@Service("portalConditionsAgreementService")
public class ConditionsAgreementService {

    @Autowired
    ConditionsAgreementMapper conditionsAgreementMapper;

    @Autowired
    ConditionsAgreementRepository conditionsAgreementRepository;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    CallService callService;

    public ConditionsAgreementDTO saveConditionsAgreementDTO(UserDTO user, ConditionsAgreementDTO conditionsAgreementDTO) throws Exception {
        // userConnected.getId(), conditionsAgreementDTO.getRegistrationId(), conditionsAgreementDTO.getStatus()

        if (callService.getCurrentCall() != null) {
            Integer callId = callService.getCurrentCall().getId();
            if (applicationService.getApplicationByCallIdAndRegistrationId(callId, conditionsAgreementDTO.getRegistrationId()) != null) {
                throw new Exception("You can not uncheck the agreement");
            }
        }

        conditionsAgreementDTO.setUserId(user.getId());
        conditionsAgreementDTO.setChangeStatusDate(new Date());
        return conditionsAgreementMapper.toDTO(conditionsAgreementRepository.save(conditionsAgreementMapper.toEntity(conditionsAgreementDTO)));
    }

    public int getStatusConditionsAgreement(Integer supplierId) {
        ConditionsAgreement conditionsAgreement = conditionsAgreementRepository.findFirstByRegistrationIdOrderByIdDesc(supplierId);

        return conditionsAgreement == null ? 0 : conditionsAgreement.getStatus();
    }
}

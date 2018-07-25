package wifi4eu.wifi4eu.service.registration.conditionsAgreement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.ConditionsAgreementDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.entity.registration.ConditionsAgreement;
import wifi4eu.wifi4eu.mapper.registration.ConditionsAgreementMapper;
import wifi4eu.wifi4eu.repository.registration.ConditionsAgreementRepository;

import java.util.Date;

@Service("portalConditionsAgreementService")
public class ConditionsAgreementService {

    @Autowired
    ConditionsAgreementMapper conditionsAgreementMapper;

    @Autowired
    ConditionsAgreementRepository conditionsAgreementRepository;

    public ConditionsAgreementDTO saveConditionsAgreementDTO(UserDTO user, ConditionsAgreementDTO conditionsAgreementDTO){
        // userConnected.getId(), conditionsAgreementDTO.getRegistrationId(), conditionsAgreementDTO.getStatus()
        conditionsAgreementDTO.setUserId(user.getId());
        conditionsAgreementDTO.setChangeStatusDate(new Date());
        return conditionsAgreementMapper.toDTO(conditionsAgreementRepository.save(conditionsAgreementMapper.toEntity(conditionsAgreementDTO)));
    }

    public int getStatusConditionsAgreement(Integer supplierId){
        ConditionsAgreement conditionsAgreement = conditionsAgreementRepository.findFirstByRegistrationIdOrderByIdDesc(supplierId);

        return conditionsAgreement == null ? 0 : conditionsAgreement.getStatus();
    }
}

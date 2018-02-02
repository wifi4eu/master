package wifi4eu.wifi4eu.service.registration;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.mapper.registration.RegistrationMapper;
import wifi4eu.wifi4eu.repository.registration.RegistrationRepository;

import java.util.List;

@Service
public class RegistrationService {
    @Autowired
    RegistrationMapper registrationMapper;

    @Autowired
    RegistrationRepository registrationRepository;

    public List<RegistrationDTO> getRegistrationsByUserId(int userId) {
        return registrationMapper.toDTOList(Lists.newArrayList(registrationRepository.findByUserId(userId)));
    }

    public boolean checkIfRegistrationIsKO(int userId) {
        List<RegistrationDTO> registrations = getRegistrationsByUserId(userId);
        for (RegistrationDTO registration : registrations) {
            if (registration.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }
}
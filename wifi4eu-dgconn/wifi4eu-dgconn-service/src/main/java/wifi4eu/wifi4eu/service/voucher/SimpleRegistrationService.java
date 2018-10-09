package wifi4eu.wifi4eu.service.voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.SimpleRegistrationDTO;
import wifi4eu.wifi4eu.common.mapper.voucher.SimpleRegistrationMapper;
import wifi4eu.wifi4eu.repository.voucher.SimpleRegistrationRepository;

import java.util.List;

@Service
public class SimpleRegistrationService {

    @Autowired
    private SimpleRegistrationRepository simpleRegistrationRepository;

    @Autowired
    private SimpleRegistrationMapper simpleRegistrationMapper;

    public List<SimpleRegistrationDTO> findAll(){
        return simpleRegistrationMapper.toDTOList(simpleRegistrationRepository.findAllSimpleRegistrationsFromApplications());
    }

}

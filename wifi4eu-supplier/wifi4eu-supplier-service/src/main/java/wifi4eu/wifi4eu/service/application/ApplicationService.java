package wifi4eu.wifi4eu.service.application;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.mapper.application.ApplicationMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;

import java.text.MessageFormat;
import java.time.DateTimeException;
import java.util.*;

@Service
public class ApplicationService {
    @Value("${mail.server.location}")
    private String baseUrl;

    @Autowired
    ApplicationMapper applicationMapper;

    @Autowired
    ApplicationRepository applicationRepository;


    public List<ApplicationDTO> getApplicationsBySupplierId(int supplierId) {
        return applicationMapper.toDTOList(Lists.newArrayList(applicationRepository.findBySupplierId(supplierId)));
    }


    @Transactional
    public ApplicationDTO deleteApplication(int applicationId) {
        ApplicationDTO applicationDTO = applicationMapper.toDTO(applicationRepository.findOne(applicationId));
        if (applicationDTO != null) {
            applicationRepository.delete(applicationMapper.toEntity(applicationDTO));
            return applicationDTO;
        } else {
            return null;
        }
    }


    public List<ApplicationDTO> getApplicationsByRegistrationId(int registrationId) {
        return applicationMapper.toDTOList(Lists.newArrayList(applicationRepository.findByRegistrationId(registrationId)));
    }
}
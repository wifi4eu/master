package wifi4eu.wifi4eu.service.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.ApplicationAuthorizedPersonDTO;
import wifi4eu.wifi4eu.mapper.application.ApplicantAuthorizedPersonMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationAuthorizedPersonRepository;

@Service
public class ApplicationAuthorizedPersonService {

    @Autowired
    ApplicantAuthorizedPersonMapper applicantAuthorizedPersonMapper;

    @Autowired
    ApplicationAuthorizedPersonRepository applicationAuthorizedPersonRepository;


    public ApplicationAuthorizedPersonDTO findByApplicationAndAuthorisedPerson(int applicationId, int authorizedPerson) {
        return applicantAuthorizedPersonMapper.toDTO(applicationAuthorizedPersonRepository.findByApplicationIdAndAuthorizedPerson(applicationId, authorizedPerson));
    }

    public Boolean findByApplicationUserAuthorized(int applicationId, int userId){
        return applicationAuthorizedPersonRepository.findByApplicationUserAuthorized(applicationId, userId);
    }
}

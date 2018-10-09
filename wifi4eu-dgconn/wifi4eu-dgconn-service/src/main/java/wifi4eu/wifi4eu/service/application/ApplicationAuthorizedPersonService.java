package wifi4eu.wifi4eu.service.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.ApplicationAuthorizedPersonDTO;
import wifi4eu.wifi4eu.common.dto.model.UserAuthorizedPersonDTO;
import wifi4eu.wifi4eu.common.mapper.application.ApplicantAuthorizedPersonMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationAuthorizedPersonRepository;

import java.util.List;

@Service
public class ApplicationAuthorizedPersonService {

    @Autowired
    ApplicantAuthorizedPersonMapper applicantAuthorizedPersonMapper;

    @Autowired
    ApplicationAuthorizedPersonRepository applicationAuthorizedPersonRepository;


    public ApplicationAuthorizedPersonDTO findByApplicationAndAuthorisedPerson(int applicationId, int authorizedPerson) {
        return applicantAuthorizedPersonMapper.toDTO(applicationAuthorizedPersonRepository.findByApplicationIdAndAuthorizedPerson(applicationId, authorizedPerson));
    }

    public List<ApplicationAuthorizedPersonDTO> findByApplication(int applicationId) {
        return applicantAuthorizedPersonMapper.toDTOList(applicationAuthorizedPersonRepository.findByApplicationIdOrderByAuthorizedPerson(applicationId));
    }

    public void updateAuthorization(UserAuthorizedPersonDTO userAuthorizedPersonDTO){
        if (userAuthorizedPersonDTO.isAuthorized()){
            ApplicationAuthorizedPersonDTO applicationAuthorizedPersonDTO = new ApplicationAuthorizedPersonDTO();
            applicationAuthorizedPersonDTO.setApplicationId(userAuthorizedPersonDTO.getApplicationId());
            applicationAuthorizedPersonDTO.setAuthorized_person(userAuthorizedPersonDTO.getUserId());

            applicationAuthorizedPersonRepository.save(applicantAuthorizedPersonMapper.toEntity(applicationAuthorizedPersonDTO));

        }else {
            applicationAuthorizedPersonRepository.deleteByUserIdAndApplicationId(userAuthorizedPersonDTO.getUserId(), userAuthorizedPersonDTO.getApplicationId());
        }
    }
}

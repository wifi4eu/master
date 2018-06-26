package wifi4eu.wifi4eu.service.warning;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationWarningDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.entity.application.ApplicationIssueUtil;
import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.entity.warnings.RegistrationWarning;
import wifi4eu.wifi4eu.mapper.registration.RegistrationMapper;
import wifi4eu.wifi4eu.mapper.registrationWarning.RegistrationWarningMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationIssueUtilRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationRepository;
import wifi4eu.wifi4eu.repository.warning.RegistrationWarningRepository;
import wifi4eu.wifi4eu.service.application.ApplicationWarningsChecker;

import java.util.ArrayList;
import java.util.List;


@Service
public class RegistrationWarningService {

    Logger _log = LoggerFactory.getLogger(RegistrationWarningService.class);

    @Autowired
    RegistrationMapper registrationMapper;

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    ApplicationIssueUtilRepository applicationIssueUtilRepository;

    @Autowired
    RegistrationWarningRepository registrationWarningRepository;
    @Autowired
    RegistrationWarningMapper registrationWarningMapper;

    public List<RegistrationDTO> getRegistrationsByIp(String ip) {
        return registrationMapper.toDTOList(Lists.newArrayList(registrationRepository.findByIpRegistration(ip)));
    }

    public ResponseDTO uploadRegistrationWarnings() {
        ResponseDTO responseDTO = new ResponseDTO();
        createWarningsForAllRegistrations();
        responseDTO.setSuccess(true);
        return responseDTO;
    }

    public void createWarningsForAllRegistrations() {
        List<ApplicationIssueUtil> applicationIssueUtilList = applicationIssueUtilRepository.findAllApplicationIssueUtil();
        List<RegistrationWarning> toSaveList = new ArrayList<>();

        for (ApplicationIssueUtil applicationIssueUtil : applicationIssueUtilList) {
            if (ApplicationWarningsChecker.registrationHasWarning1(applicationIssueUtil)) {
                RegistrationWarning registrationWarnings = new RegistrationWarning();
                registrationWarnings.setRegistration(Integer.valueOf(applicationIssueUtil.getRegistrationId()));
                registrationWarnings.setWarning(1);
                toSaveList.add(registrationWarnings);
            }

        /*if (ApplicationWarningsChecker.registrationHasWarning2(applicationIssueUtil)) {
            Registration registration = registrationMapper.toEntity(registrationDTO);
            RegistrationWarning registrationWarnings = new RegistrationWarning();
            registrationWarnings.setRegistration(applicationIssueUtil.getId());
            registrationWarnings.setWarning(2);
            toSaveList.add(registrationWarnings);
        }*/

            if (ApplicationWarningsChecker.registrationHasWarning3(applicationIssueUtil)) {
                RegistrationWarning registrationWarnings = new RegistrationWarning();
                registrationWarnings.setRegistration(Integer.valueOf(applicationIssueUtil.getRegistrationId()));
                registrationWarnings.setWarning(3);
                toSaveList.add(registrationWarnings);
            }
        }
        registrationWarningRepository.save(toSaveList);
    }

    public void createWarningsByRegistration(RegistrationDTO registrationDTO) {
        ApplicationIssueUtil applicationIssueUtil = applicationIssueUtilRepository.findRegistrationIssueUtilsByRegistrationId(registrationDTO.getId());

        if (ApplicationWarningsChecker.registrationHasWarning1(applicationIssueUtil)) {
            Registration registration = registrationMapper.toEntity(registrationDTO);
            RegistrationWarning registrationWarnings = new RegistrationWarning();
            registrationWarnings.setRegistration(registration.getId());
            registrationWarnings.setWarning(1);
            registrationWarningRepository.save(registrationWarnings);
        }


        /*if (ApplicationWarningsChecker.registrationHasWarning2(applicationIssueUtil)) {
            Registration registration = registrationMapper.toEntity(registrationDTO);
            RegistrationWarning registrationWarnings = new RegistrationWarning();
            registrationWarnings.setRegistration(applicationIssueUtil.getId());
            registrationWarnings.setWarning(2);
            toSaveList.add(registrationWarnings);
        }*/

        if (ApplicationWarningsChecker.registrationHasWarning3(applicationIssueUtil)) {
            Registration registration = registrationMapper.toEntity(registrationDTO);
            RegistrationWarning registrationWarnings = new RegistrationWarning();
            registrationWarnings.setRegistration(registration.getId());
            registrationWarnings.setWarning(3);
            registrationWarningRepository.save(registrationWarnings);
        }
    }

    public List<RegistrationWarningDTO> getWarningsByRegistrationId(int registrationId) {
        return registrationWarningMapper.toDTOList(Lists.newArrayList(registrationWarningRepository.findAllByRegistrationId(registrationId)));
    }


}

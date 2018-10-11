package wifi4eu.wifi4eu.service.application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.entity.application.Application;
import wifi4eu.wifi4eu.mapper.application.ApplicationMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.call.CallRepository;

import java.util.Date;
import java.util.List;

@Service
public class ApplicationService {

    private static final Logger _log = LogManager.getLogger(ApplicationService.class);

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private CallRepository callRepository;

    @Autowired
    ApplicationMapper applicationMapper;

    @Autowired
    TaskExecutor taskExecutor;

    @Autowired
    ApplicationContext context;

    public Integer[] sendEmailApplications(Integer callId) throws AppException {
        if (Validator.isNull(callRepository.findOne(callId))){
            throw new AppException("Call ID " + callId + " does not exist");
        }
        Integer sentEmailsMunicipalities = 0;
        _log.info("Create Application Emails - STARTING");
        // List<ApplicationDTO> applicationList = applicationMapper.toDTOList(applicationRepository.findByCreateApplicationEmailNotSent(callId, new Date().getTime()));
        List<Application.ApplicationApplyEmail> applicationList = applicationRepository.findByCreateApplicationEmailNotSentCustom(callId, new Date().getTime());
        _log.info("Create Application Emails - There is " + applicationList.size() + " municipalities to be sent");
        for (Application.ApplicationApplyEmail app : applicationList) {
           //  _log.info("appId : "+app.getId()+" registrationId : "+app.getRegistrationId());
            /*
            _log.info("Processing application: " + app.getId());
            taskExecutor.execute(context.getBean(ProcessApplicationMailTask.class, app));
            sentEmailsMunicipalities++;
            */
        }
        _log.info("Create Application Emails - FINISHED");
        return new Integer[] {sentEmailsMunicipalities};
    }



}
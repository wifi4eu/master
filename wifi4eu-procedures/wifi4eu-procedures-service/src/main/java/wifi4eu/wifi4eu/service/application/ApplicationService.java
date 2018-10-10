package wifi4eu.wifi4eu.service.application;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import wifi4eu.wifi4eu.common.dto.mail.MailData;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.mail.MailHelper;
import wifi4eu.wifi4eu.common.service.mail.MailService;
import wifi4eu.wifi4eu.common.service.mail.SendMailBySMTPTask;
import wifi4eu.wifi4eu.entity.municipality.Municipality;
import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.mapper.application.ApplicationMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.call.CallRepository;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.repository.user.UserRepository;
import wifi4eu.wifi4eu.service.user.UserConstants;

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
        _log.debug("Create Application Emails - STARTING");
        // in case of server failure also search for applications that weren't sent the email and that were created at least four hours ago
        List<ApplicationDTO> applicationList = applicationMapper.toDTOList(applicationRepository.findByCreateApplicationEmailNotSent(callId, new Date().getTime()));
        _log.info("Create Application Emails - There is " + applicationList.size() + " municipalities to be sent the email in this " +
                "last four hours.");
        for (ApplicationDTO app : applicationList) {
            taskExecutor.execute(context.getBean(ProcessApplicationMailTask.class, app));
            sentEmailsMunicipalities++;
        }
        _log.debug("Create Application Emails - FINISHED");
        return new Integer[] {sentEmailsMunicipalities};
    }



}
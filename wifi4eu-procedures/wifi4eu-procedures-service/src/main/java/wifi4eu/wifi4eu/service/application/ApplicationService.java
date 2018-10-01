package wifi4eu.wifi4eu.service.application;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import wifi4eu.wifi4eu.common.dto.mail.MailData;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.mail.MailHelper;
import wifi4eu.wifi4eu.common.service.mail.MailService;
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

    @Value("${mail.server.location}")
    private String baseUrl;

    @Autowired
    private MailService mailService;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private MunicipalityRepository municipalityRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private CallRepository callRepository;

    @Autowired
    ApplicationMapper applicationMapper;

    public void sendCreateApplicationEmail(User user, Integer municipalityId, ApplicationDTO application) throws Exception {
        Locale locale = new Locale(UserConstants.DEFAULT_LANG);
        if (user.getLang() != null) {
            locale = new Locale(user.getLang());
        } else {
            _log.warn("Create Application Emails - The user " + user.getEcasUsername() + " has not specified a language");
        }

    	MailData mailData = MailHelper.buildMailCreateApplication(user.getEcasEmail(), MailService.FROM_ADDRESS, municipalityId, "createApplication", locale);
    	mailService.sendMail(mailData, true);

        application.setSentEmail(true);
        applicationMapper.toDTO(applicationRepository.save(applicationMapper.toEntity(application)));
        _log.log(Level.getLevel("BUSINESS"), "Create Application Emails - Email will be sent to " + user.getEcasEmail() + " for the " + "application id: " + application.getId());
    }

    public Integer[] sendEmailApplications(Integer callId) throws Exception {
        if (Validator.isNull(callRepository.findOne(callId))){
            throw new AppException("Call ID " + callId + " does not exist");
        }
        Integer sentEmailsUsers = 0;
        Integer sentEmailsMunicipalities = 0;
        _log.debug("Create Application Emails - STARTING");
        //in case of server failure also search for applications that weren't sent the email and that were created at least four hours ago
        List<ApplicationDTO> applicationList = applicationMapper.toDTOList(applicationRepository.findByCreateApplicationEmailNotSent(callId, new Date().getTime()));
        _log.info("Create Application Emails - There is " + applicationList.size() + " municipalities to be sent the email in this " +
                "last four hours.");
        for (ApplicationDTO app : applicationList) {
            Integer municipalityId = municipalityRepository.findByRegistrationId(app.getRegistrationId()).getId();
            List<User> users = userRepository.findUsersByRegistrationId(app.getRegistrationId());
            if(users != null && !users.isEmpty()) {
                for (User user : users) {
                    if (municipalityId != null && user != null) {
                        applicationService.sendCreateApplicationEmail(user, municipalityId, app);
                        sentEmailsUsers++;
                    } else {
                        _log.error("Create Application Emails - inconsistency in data. User or municipality is null. Application id: " + app.getId());
                    }
                }
            } else {
                _log.error("Create Application Emails - No users are related to the municipality. Application id: " + app.getId());
            }
            sentEmailsMunicipalities++;
        }
        _log.debug("Create Application Emails - FINISHED");
        return new Integer[] {sentEmailsUsers, sentEmailsMunicipalities};
    }

}
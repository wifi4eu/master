package wifi4eu.wifi4eu.service.application;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.call.CallRepository;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.repository.user.UserRepository;
import wifi4eu.wifi4eu.service.user.UserConstants;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.util.MailService;

import wifi4eu.wifi4eu.mapper.application.ApplicationMapper;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@Service
public class ApplicationService {
    @Value("${mail.server.location}")
    private String baseUrl;

    private static final Logger _log = LogManager.getLogger(ApplicationService.class);

    @Autowired
    private MailService mailService;

    @Autowired
    private UserService userService;

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
            _log.warn("SCHEDULED TASK: Create Application Emails - The user " + user.getEcasUsername() + " has not specified a language");
        }
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.voucherApply.subject");
        String msgBody = bundle.getString("mail.voucherApply.body");
        if (!userService.isLocalHost()) {

        }
            mailService.sendEmailAsync(user.getEcasEmail(), MailService.FROM_ADDRESS, subject, msgBody, municipalityId, "createApplication");
            application.setSentEmail(true);
            applicationMapper.toDTO(applicationRepository.save(applicationMapper.toEntity(application)));
            _log.log(Level.getLevel("BUSINESS"), "SCHEDULED TASK: Create Application Emails - Email will be sent to " + user.getEcasEmail() + " for the " + "application id: " + application.getId());
    }

    public Integer[] sendEmailApplications(Integer callId) throws Exception {
        Integer sentEmailsUsers = 0;
        Integer sentEmailsMunicipalities = 0;
        _log.debug("SCHEDULED TASK: Create Application Emails - STARTING");
        //in case of server failure also search for applications that weren't sent the email and that were created at least four hours ago
        List<ApplicationDTO> applicationList = applicationMapper.toDTOList(applicationRepository.findByCreateApplicationEmailNotSent(callId, new Date().getTime()));
        _log.info("SCHEDULED TASK: Create Application Emails - There is " + applicationList.size() + " municipalities to be sent the email in this " +
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
                        _log.error("SCHEDULED TASK: Create Application Emails - inconsistency in data. User or municipality is null. Application id: " + app.getId());
                    }
                }
            } else {
                _log.error("SCHEDULED TASK: Create Application Emails - No users are related to the municipality. Application id: " + app.getId());
            }
            sentEmailsMunicipalities++;
        }
        _log.debug("SCHEDULED TASK: Create Application Emails - FINISHED");
        return new Integer[] {sentEmailsUsers, sentEmailsMunicipalities};
    }

}
package wifi4eu.wifi4eu.service.application;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.common.dto.mail.MailData;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.mail.MailHelper;
import wifi4eu.wifi4eu.common.mapper.application.ApplicationMapper;
import wifi4eu.wifi4eu.common.service.mail.MailService;
import wifi4eu.wifi4eu.entity.municipality.Municipality;
import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.repository.user.UserRepository;
import wifi4eu.wifi4eu.service.user.UserConstants;

import java.util.Date;
import java.util.List;
import java.util.Locale;

@Component
@Scope("prototype")
public abstract class ProcessApplicationMailTask implements Runnable {
	private final Logger _log = LogManager.getLogger(ProcessApplicationMailTask.class);

	@Autowired
	protected MunicipalityRepository municipalityRepository;

	@Autowired
	protected UserRepository userRepository;

	@Autowired
	protected MailService mailService;

	@Autowired
	protected ApplicationMapper applicationMapper;

	@Autowired
	protected ApplicationRepository applicationRepository;


	protected ApplicationDTO application;

	public ProcessApplicationMailTask(ApplicationDTO application) {
		super();
		this.application= application;
	}
	@Override
	public void run() {
		_log.debug("Logging email");
		int appId = application.getId();
		try {
			Integer municipalityId = municipalityRepository.findByRegistrationId(application.getRegistrationId()).getId();
			List<User> users = userRepository.findUsersByRegistrationId(application.getRegistrationId());
			if(Validator.isNotNull(users) && !users.isEmpty()) {
				for (User user : users) {
					if (Validator.isNotNull(municipalityId) && Validator.isNotNull(user)) {
						sendCreateApplicationEmail(user, municipalityId, application);
					} else {
						_log.error("Create Application Emails - inconsistency in data. User or municipality is null. Application id: " + application.getId());
					}
				}
			} else {
				_log.error("Create Application Emails - No users are related to the municipality. Application id: " + application.getId());
			}
		} catch (Exception ex) {
			_log.error("Error processing the mail for the application: " + appId, ex.getMessage());
		}

	}

	public void sendCreateApplicationEmail(User user, Integer municipalityId, ApplicationDTO application) {
		Locale locale = new Locale(UserConstants.DEFAULT_LANG);
		if (Validator.isNotNull(user.getLang())) {
			locale = new Locale(user.getLang());
		} else {
			_log.warn("Create Application Emails - The user " + user.getEcasUsername() + " has not specified a language");
		}
		Municipality municipality = municipalityRepository.findOne(municipalityId);
		if (Validator.isNotNull(municipality)) {
			MailData mailData = MailHelper.buildMailCreateApplication(user.getEcasEmail(), MailService.FROM_ADDRESS, municipalityId, municipality.getName(),"createApplication", locale);
			mailService.sendMail(mailData, true);
			application.setSentEmail(true);
			application.setSentEmailDate(new Date());
			applicationMapper.toDTO(applicationRepository.save(applicationMapper.toEntity(application)));
			_log.log(Level.getLevel("BUSINESS"), "Create Application Emails - Email will be sent to " + user.getEcasEmail() + " for the " + "application id: " + application.getId());
		}
	}
}

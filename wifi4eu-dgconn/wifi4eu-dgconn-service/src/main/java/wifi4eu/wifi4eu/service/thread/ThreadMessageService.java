package wifi4eu.wifi4eu.service.thread;

import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifi4eu.wifi4eu.common.dto.mail.MailData;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.ThreadDTO;
import wifi4eu.wifi4eu.common.dto.model.ThreadMessageDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.mail.MailHelper;
import wifi4eu.wifi4eu.common.service.mail.MailService;
import wifi4eu.wifi4eu.common.mapper.thread.ThreadMessageMapper;
import wifi4eu.wifi4eu.common.mapper.user.UserMapper;
import wifi4eu.wifi4eu.repository.thread.ThreadMessageRepository;
import wifi4eu.wifi4eu.repository.user.UserRepository;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.supplier.SupplierService;
import wifi4eu.wifi4eu.service.user.UserConstants;
import wifi4eu.wifi4eu.service.user.UserService;

@Service
public class ThreadMessageService {
    Logger _log = LogManager.getLogger(ThreadMessageService.class);

    @Autowired
    ThreadMessageMapper threadMessageMapper;

    @Autowired
    ThreadMessageRepository threadMessageRepository;

    @Autowired
    ThreadService threadService;

    @Autowired
    MunicipalityService municipalityService;

    @Autowired
    SupplierService supplierService;

    @Autowired
    UserService userService;

    @Autowired
    MailService mailService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    public ThreadMessageDTO createThreadMessage(ThreadMessageDTO threadMessageDTO) {
    	if (threadMessageDTO.getId() != 0) {
    		_log.warn("Call to a create method with id set, the value has been removed ({})", threadMessageDTO.getId());
    		threadMessageDTO.setId(0);	
    	}
        ThreadMessageDTO threadMessage = threadMessageMapper.toDTO(threadMessageRepository.save(threadMessageMapper.toEntity(threadMessageDTO)));
        ThreadDTO thread = threadService.getThreadById(threadMessage.getThreadId());
        if (thread.getType() == 1) {
            List<MunicipalityDTO> municipalities = municipalityService.getMunicipalitiesByLauId(Integer.valueOf(thread.getReason()));
            if (municipalities.size() <= 10) {
                if (!userService.isLocalHost()) {
                    for (MunicipalityDTO municipality : municipalities) {
                        UserDTO user = userMapper.toDTO(userRepository.findMainUserFromRegistration(municipality.getRegistrations().get(0).getId()));
                        if (user != null) {
                            Locale locale = new Locale(UserConstants.DEFAULT_LANG);
                            if (user.getLang() != null) {
                                locale = new Locale(user.getLang());
                            }

                            MailData mailData = MailHelper.buildMailNewThreadMessage(
                            		user.getEcasEmail(), MailService.FROM_ADDRESS, 
                            		municipality.getId(), "createThreadMessage", locale);
                        	mailService.sendMail(mailData, false);
                        }
                    }
                }
            }
        }
        return threadMessage;
    }
}
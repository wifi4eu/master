package wifi4eu.wifi4eu.service.thread;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.mapper.thread.ThreadMessageMapper;
import wifi4eu.wifi4eu.repository.thread.ThreadMessageRepository;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.supplier.SupplierService;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.util.MailService;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@Service
public class ThreadMessageService {
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

    public List<ThreadMessageDTO> getAllThreadMessages() {
        return threadMessageMapper.toDTOList(Lists.newArrayList(threadMessageRepository.findAll()));
    }

    public ThreadMessageDTO getThreadMessageById(int threadMessageId) {
        return threadMessageMapper.toDTO(threadMessageRepository.findOne(threadMessageId));
    }

    public ThreadMessageDTO createThreadMessage(ThreadMessageDTO threadMessageDTO) {
        ThreadMessageDTO threadMessage = threadMessageMapper.toDTO(threadMessageRepository.save(threadMessageMapper.toEntity(threadMessageDTO)));
        ThreadDTO thread = threadService.getThreadById(threadMessage.getThreadId());
        switch (thread.getType()) {
            case 1:
                List<MunicipalityDTO> municipalities = municipalityService.getMunicipalitiesByLauId(Integer.valueOf(thread.getReason()));
                if (municipalities.size() <= 10) {
                    if (!userService.isLocalHost()) {
                        for (MunicipalityDTO municipality : municipalities) {
                            UserDTO user = userService.getUserById(municipality.getRegistrations().get(0).getUserId());
                            if (user != null) {
                                Locale locale = userService.initLocale();
                                ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
                                String subject = bundle.getString("mail.thread.subject");
                                String msgBody = bundle.getString("mail.thread.body");
                                mailService.sendEmail(user.getEmail(), MailService.FROM_ADDRESS, subject, msgBody);
                            }
                        }
                    }
                }
                break;
            case 2:
            case 3: {
                List<SupplierDTO> suppliers = null;
                if (thread.getType() == 2) {
                    suppliers = supplierService.getSuppliersByVat(thread.getReason());
                } else if (thread.getType() == 3) {
                    suppliers = supplierService.getSuppliersByAccountNumber(thread.getReason());
                }
                if (suppliers.size() <= 10) {
                    if (!userService.isLocalHost()) {
                        for (SupplierDTO supplier : suppliers) {
                            UserDTO user = userService.getUserById(supplier.getUserId());
                            if (user != null) {
                                Locale locale = userService.initLocale();
                                ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
                                String subject = bundle.getString("mail.thread.subject");
                                String msgBody = bundle.getString("mail.thread.body");
                                mailService.sendEmail(user.getEmail(), MailService.FROM_ADDRESS, subject, msgBody);
                            }
                        }
                    }
                }
                break;
            }
        }
        return threadMessage;
    }

    public ThreadMessageDTO deleteThreadMessage(int threadMessageId) {
        ThreadMessageDTO threadMessageDTO = threadMessageMapper.toDTO(threadMessageRepository.findOne(threadMessageId));
        if (threadMessageDTO != null) {
            threadMessageRepository.delete(threadMessageMapper.toEntity(threadMessageDTO));
            return threadMessageDTO;
        } else {
            return null;
        }
    }
}
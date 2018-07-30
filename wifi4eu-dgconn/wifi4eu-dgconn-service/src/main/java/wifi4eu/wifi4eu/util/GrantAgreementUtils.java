package wifi4eu.wifi4eu.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.entity.grantAgreement.GrantAgreement;
import wifi4eu.wifi4eu.service.user.UserConstants;
import wifi4eu.wifi4eu.service.user.UserService;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

@Service
public class GrantAgreementUtils {

    @Autowired
    MailService mailService;

    @Autowired
    UserService userService;

    public boolean sendEmailSignPdfNotified(int userId, String email, Long days){
        if (email != null && email.trim().length() > 0 && days != null) {
            UserDTO user = userService.getUserById(userId);
            if (user != null) {
                Locale locale = new Locale(UserConstants.DEFAULT_LANG);
                if (user.getLang() != null) {
                    locale = new Locale(user.getLang());
                }
                ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
                // missing set message
                String subject = bundle.getString("mail.dgConn.requestDocuments.subject");
                String msgBody = bundle.getString("mail.dgConn.requestDocuments.body");
                String additionalInfoUrl = userService.getBaseUrl() + "supplier-portal/additional-info";
                msgBody = MessageFormat.format(msgBody, additionalInfoUrl);
                if (!userService.isLocalHost()) {
                    mailService.sendEmail(user.getEcasEmail(), MailService.FROM_ADDRESS, subject, msgBody);
                }
                return true;
            }
        }
        return true;
    }


}

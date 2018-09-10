package wifi4eu.wifi4eu.util;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifi4eu.wifi4eu.common.dto.mail.MailData;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.mail.MailHelper;
import wifi4eu.wifi4eu.common.service.mail.MailService;
import wifi4eu.wifi4eu.service.user.UserConstants;
import wifi4eu.wifi4eu.service.user.UserService;

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
                
                int daysMessage = Math.abs(Integer.parseInt(days.toString()));
		        MailData mailData = MailHelper.buildMailGrantAgreementReminder(
		        		email, MailService.FROM_ADDRESS, daysMessage, locale);
		    	mailService.sendMail(mailData, true);

                return true;
            }
        }
        return true;
    }

}

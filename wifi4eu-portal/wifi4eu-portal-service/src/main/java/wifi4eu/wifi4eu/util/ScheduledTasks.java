package wifi4eu.wifi4eu.util;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.queue.CloudQueueMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.mapper.application.ApplicationMapper;
import wifi4eu.wifi4eu.mapper.helpdesk.HelpdeskIssueMapper;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.azurequeue.AzureQueueService;
import wifi4eu.wifi4eu.service.call.CallService;
import wifi4eu.wifi4eu.service.helpdesk.HelpdeskService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserConstants;
import wifi4eu.wifi4eu.service.user.UserService;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Random;

@EnableScheduling
@Controller
public class ScheduledTasks {

    @Autowired
    private MailService mailService;

    @Autowired
    private HelpdeskService helpdeskService;

    @Autowired
    private HelpdeskIssueMapper helpdeskIssueMapper;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private UserService userService;

    @Autowired
    private AzureQueueService azureQueueService;

    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private CallService callService;

    private static final Logger _log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Scheduled(cron = "0 0/5 * * * ?")
    public void scheduleAzureQueue() throws InvalidKeyException, StorageException, URISyntaxException {
        Random rand = new Random();
        int randomQueue = rand.nextInt(10);
        azureQueueService.setAzureQueue("stress-" + randomQueue);
        List<CloudQueueMessage> list = azureQueueService.peekMessagesAzureQueue(32, 600);

        for (CloudQueueMessage cloudQueueMessage : list) {
            String queueMessage = cloudQueueMessage.getMessageContentAsString();
            String idRegistration = queueMessage.substring(queueMessage.indexOf("(") + 1);
            idRegistration = idRegistration.substring(0, idRegistration.indexOf(")"));

            String idCall = queueMessage.substring(queueMessage.indexOf("@") + 1);
            idCall = idCall.substring(0, idCall.indexOf("@"));

            ApplicationDTO applicationDTO = new ApplicationDTO();

            applicationDTO.setRegistrationId(Integer.parseInt(idRegistration));
            applicationDTO.setDate(new Date().getTime());
            applicationDTO.setCallId(Integer.parseInt(idCall));

            if (applicationService.getApplicationsByRegistrationId(applicationDTO.getRegistrationId()).size() == 0) {
                applicationService.createApplication(applicationDTO);
            }

            azureQueueService.removeMessageAzureQueue(cloudQueueMessage);
        }
    }

    @Scheduled(cron = "0 0/30 * * * ?")
    public void scheduleHelpdeskIssues() {

        List<HelpdeskIssueDTO> helpdeskIssueDTOS = helpdeskService.getAllHelpdeskIssueNoSubmited();

        for (HelpdeskIssueDTO helpdeskIssue : helpdeskIssueDTOS) {
            HelpdeskTicketDTO helpdeskTicketDTO = new HelpdeskTicketDTO();

            helpdeskTicketDTO.setEmailAdress(helpdeskIssue.getFromEmail());
            helpdeskTicketDTO.setEmailAdressconf(helpdeskTicketDTO.getEmailAdress());
            helpdeskTicketDTO.setUuid("wifi4eu_" + helpdeskIssue.getId());

            UserDTO userDTO = userService.getUserByEcasEmail(helpdeskIssue.getFromEmail());


            if (userDTO != null) {
                helpdeskTicketDTO.setFirstname(userDTO.getName());
                helpdeskTicketDTO.setLastname(userDTO.getSurname());

                helpdeskTicketDTO.setTxtsubjext(helpdeskIssue.getTopic());
                helpdeskTicketDTO.setQuestion(helpdeskIssue.getSummary());

                String result = executePost("https://webtools.ec.europa.eu/form-tools/process.php", helpdeskTicketDTO.toString());
                if (result != null && result.contains("Thankyou.js")) {
                    helpdeskIssue.setTicket(true);
                    helpdeskService.createHelpdeskIssue(helpdeskIssue);
                }
            }
        }
    }


    @Scheduled(cron = "0 0 8 ? * MON-FRI")
    public void sendDocRequest() {
        List<RegistrationDTO> registrationDTOS = registrationService.getAllRegistrations();
        for (RegistrationDTO registrationDTO : registrationDTOS) {
            if (registrationDTO != null && registrationDTO.getMailCounter() > 0) {
                UserDTO user = userService.getUserById(registrationDTO.getUserId());
                if (user != null && user.getEcasEmail() != null) {
                    if (!userService.isLocalHost()) {
                        Locale locale = new Locale(UserConstants.DEFAULT_LANG);
                        if (user.getLang() != null) {
                            locale = new Locale(user.getLang());
                        }
                        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
                        String subject = bundle.getString("mail.dgConn.requestDocuments.subject");
                        String msgBody = bundle.getString("mail.dgConn.requestDocuments.body");
                        String additionalInfoUrl = userService.getBaseUrl() + "beneficiary-portal/voucher";
                        msgBody = MessageFormat.format(msgBody, additionalInfoUrl);

                        mailService.sendEmail(user.getEcasEmail(), MailService.FROM_ADDRESS, subject, msgBody);
                    }
                    int mailCounter = registrationDTO.getMailCounter() - 1;
                    registrationDTO.setMailCounter(mailCounter);
                    registrationService.createRegistration(registrationDTO);
                }
            }

        }
    }

    public static String executePost(String targetURL, String urlParameters) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US,en;q=0.9,es-ES;q=0.8,es;q=0.7");
            connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
            connection.setRequestProperty("Referer", "https://forms.communi-k.eu/livewebtools/WebForms/Standard/Standard.php?en");
            connection.setRequestProperty("Origin", "https://forms.communi-k.eu");
            connection.setRequestProperty("Host", "webtools.ec.europa.eu");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            _log.error(e.getMessage());
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }


}

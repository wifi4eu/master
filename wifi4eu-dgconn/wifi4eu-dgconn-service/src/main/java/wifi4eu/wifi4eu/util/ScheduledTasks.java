package wifi4eu.wifi4eu.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.GetResponse;

import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskIssueDTO;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskTicketDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.voucher.VoucherAssignment;
import wifi4eu.wifi4eu.repository.grantAgreement.GrantAgreementRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationUsersRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherAssignmentRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherSimulationRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.helpdesk.HelpdeskService;
import wifi4eu.wifi4eu.service.user.UserService;

@Configuration
@PropertySource("classpath:env.properties")
@EnableScheduling
@Controller
public class ScheduledTasks {
	
    private static final Logger _log = LogManager.getLogger(ScheduledTasks.class);

    private final static String QUEUE_NAME = "wifi4eu_apply";

    @Value("${rabbitmq.host}")
    private String rabbitMQHost;

    @Value("${rabbitmq.username}")
    private String rabbitUsername;

    @Value("${rabbitmq.password}")
    private String rabbitPassword;
    
	@Value("${serco.helpdesk.endpoint}")
	private String sercoHelpdeskEndpoint;

    @Value("${serco.helpdesk.formid}")
    private String helpdeskFormId;

    @Autowired
    private HelpdeskService helpdeskService;

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private VoucherAssignmentRepository voucherAssignmentRepository;

    @Autowired
    private VoucherSimulationRepository voucherSimulationRepository;

    @Autowired
    GrantAgreementRepository grantAgreementRepository;

    @Autowired
    RegistrationUsersRepository registrationUsersRepository;

    @Autowired
    GrantAgreementUtils grantAgreementUtils;

    @Autowired
    DateUtils dateUtils;
    
    /**
     * This cron method consumes the messages from the RabbitMQ
     */
    //-- DGCONN-NOT-NECESSARY @Scheduled(cron = "0 0/10 * * * ?")
    public void queueConsumer(HttpServletRequest request) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Consuming messages from the queue");
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(rabbitMQHost);
            factory.setUsername(rabbitUsername);
            factory.setPassword(rabbitPassword);
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            boolean autoAck = false;

            int iterationCounter = 0;
            //try to process 100 messages from the queue
            for (int i = 0; i < 1000; i++) {
                iterationCounter++;
                GetResponse response = channel.basicGet(QUEUE_NAME, autoAck);
                if (response == null) {
                    // No message retrieved.
                    _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - The queue is empty");
                    break;
                } else {

                    Date wdStartDate = new Date();
                    long deliveryTag = processQueueMessage(response, request);
                    Date wdEndDate = new Date();

                    //time the process has taken in millisecons
                    long wdProcessTime = wdEndDate.getTime() - wdStartDate.getTime();
                    long messageCount = response.getMessageCount();

                    if (deliveryTag != 0) {
                        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Sent with delivery tag " + deliveryTag);
                        channel.basicAck(deliveryTag, false); // acknowledge receipt of the message
                    } else {
                        _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Cannot process a message" + response);
                    }
                    _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - wdProcessTime: " + wdProcessTime + " messageCount: " + messageCount + " iterationCounter: " + iterationCounter);
                    if (wdProcessTime < 100 && messageCount > 200 && messageCount % 9 != 1) {
                        i--;
                    } else if (wdProcessTime > 500) {
                        break;
                    }
                }
            }

            channel.close();
            _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - The queue channel has been closed");
            connection.close();
            _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - The queue connection has been closed");
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Cannot process the queue", e);
        }
    }

    //-- DGCONN-NOT-NECESSARY @Scheduled(cron = "0 0 9,17 * * MON-FRI")
    @Scheduled(cron = "0 0 9,10,11,12,13,14,15,16,17,18 * * MON-FRI")
    public void scheduleHelpdeskIssues() {
    	final String confirmationMessage = "Thank you for your message.";
    	
        _log.debug("Running DGConn Scheduled Task - HelpDeskIssues");

        List<HelpdeskIssueDTO> helpdeskIssueDTOS = helpdeskService.getAllHelpdeskIssueNoSubmited();
        _log.info("helpdeskIssueDTOS.size() [{}]", helpdeskIssueDTOS == null ? "NULL" : helpdeskIssueDTOS.size());

        if (helpdeskIssueDTOS != null) {

        	for (HelpdeskIssueDTO helpdeskIssue : helpdeskIssueDTOS) {
        		_log.info("Processing ticket id[{}]", helpdeskIssue.getId());

        		try {
        			HelpdeskTicketDTO helpdeskTicketDTO = new HelpdeskTicketDTO();
        			helpdeskTicketDTO.setForm_tools_form_id(this.helpdeskFormId);
        			helpdeskTicketDTO.setEmailAdress(helpdeskIssue.getFromEmail());
        			helpdeskTicketDTO.setEmailAdressconf(helpdeskTicketDTO.getEmailAdress());
        			helpdeskTicketDTO.setUuid("wifi4eu_" + helpdeskIssue.getId());
        			UserDTO userDTO = userService.getUserByEcasEmail(helpdeskIssue.getFromEmail());
    				_log.info("userDTO id[{}]", userDTO == null ? "NULL" : userDTO.getId());

        			if (userDTO != null) {
        				String escapedFirstName = URLEncoder.encode(userDTO.getName(), "UTF-8");
        				String escapedLastName = URLEncoder.encode(userDTO.getSurname(), "UTF-8");
        				String escapedTopic = URLEncoder.encode(helpdeskIssue.getTopic(), "UTF-8");
        				String escapedQuestion = URLEncoder.encode(helpdeskIssue.getSummary(), "UTF-8");
        				
        				helpdeskTicketDTO.setFirstname(escapedFirstName);
        				helpdeskTicketDTO.setLastname(escapedLastName);
        				helpdeskTicketDTO.setTxtsubjext(escapedTopic);
        				helpdeskTicketDTO.setQuestion(escapedQuestion);
        				
        				String result = executePost(sercoHelpdeskEndpoint, helpdeskTicketDTO.toString());

        				_log.info("Result posting to queue [{}]", result);

        				if (result != null && result.contains(confirmationMessage)) {
        					_log.info("Updating Helpdesk issue");

        					helpdeskIssue.setTicket(true);
        					helpdeskService.createOrUpdateHelpdeskIssue(helpdeskIssue);

        					_log.info("Helpdesk issue updated");
        				} else {
        					_log.info("The result do not contain the proper text");
        				}
        			} else {
        				_log.info("Cannot retrieve the user for this helpdesk issue");
        			}
        		} catch (Exception e) {
        			_log.error("Cannot process this helpdesk issue", e);
        		}
        	}
        }
    }

    private long processQueueMessage(GetResponse response, HttpServletRequest request) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Sending document request");
        try {
            AMQP.BasicProperties props = response.getProps();
            byte[] body = response.getBody();
            Envelope envelope = response.getEnvelope();

            // deserialize JSON object from the body
            ObjectMapper mapper = new ObjectMapper();
            QueueApplicationElement qae = mapper.readValue(body, QueueApplicationElement.class);

            ApplicationDTO applicationDTO = applicationService.registerApplication(qae.getCallId(), qae.getUserId(), qae.getRegistrationId(),
                    qae.getFileUploadTimestamp(), qae.getQueueTimestamp(), request);

            long deliveryTag = 0;

            if (applicationDTO != null) {
                deliveryTag = response.getEnvelope().getDeliveryTag();
                _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - The application delivery tag is " + deliveryTag);
            }
            return deliveryTag;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Cannot read a message from the queue", e);
            return 0;
        }
    }

    public static String executePost(String targetURL, String urlParameters) {
        HttpURLConnection connection = null;
        
        _log.info("targetUrl [{}] urlParameters.length[{}], urlParameters[{}]", targetURL, (urlParameters == null ? "NULL" : urlParameters.length()), (urlParameters.length() <= 100 ? urlParameters : urlParameters.substring(0, 100)));
//        _log.info("targetUrl [{}] urlParameters.length[{}], urlParameters[{}]", targetURL, (urlParameters == null ? "NULL" : urlParameters.length()), urlParameters);
        
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
            _log.error(e.getMessage(), e);
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    @Scheduled(cron = "0 0 4 * * *", zone = "Europe/Madrid")
    public void sendMessageNotSigned() {
        _log.debug("SCHEDULED TASK: Reminder email for users who haven't signed after 7 or 14 days before the notification date - START");
        ArrayList<VoucherAssignment.VoucherAssignmentGetIdAndNotificationDate> voucherAssignment = voucherAssignmentRepository.findByNotifiedDateNotNull();
        LocalDate localCurrentDate = dateUtils.getLocalTimeFromDate(new Date());
        LocalDate notifiedDate;
        for (int i = 0; i < voucherAssignment.size(); i++) {
            notifiedDate = dateUtils.getLocalTimeFromDate(new Date(voucherAssignment.get(i).getNotifiedDate()));
            long days = ChronoUnit.DAYS.between(localCurrentDate, notifiedDate);
            if (days == -7 || days == -14) {
                ArrayList<Integer> applicationIds = null;
                applicationIds = voucherSimulationRepository.findApplicationIdsFromVoucherAssignmentAndSelectionStatus(voucherAssignment.get(i).getId());
                if (applicationIds != null) {
                    for (int j = 0; j < applicationIds.size(); j++) {
                        if (grantAgreementRepository.countByApplicationId(applicationIds.get(j)) <= 0) {
                            String emailUser = registrationUsersRepository.findContactEmailFromApplicationId(applicationIds.get(j));
                            Integer userId = registrationUsersRepository.findUserIdFromApplicationId(applicationIds.get(j));
                            grantAgreementUtils.sendEmailSignPdfNotified(userId, emailUser, days);
                        }
                    }
                }
            }
        }

        _log.debug("SCHEDULED TASK: Reminder email for users who haven't signed after 7 or 14 days before the notification date - FINISH");
    }

}

package wifi4eu.wifi4eu.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
import com.google.common.collect.Lists;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.GetResponse;

import wifi4eu.wifi4eu.common.dto.mail.MailData;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskIssueDTO;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskTicketDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.mail.MailHelper;
import wifi4eu.wifi4eu.common.service.mail.MailService;
import wifi4eu.wifi4eu.entity.registration.RegistrationUsers;
import wifi4eu.wifi4eu.mapper.user.UserMapper;
import wifi4eu.wifi4eu.repository.registration.RegistrationUsersRepository;
import wifi4eu.wifi4eu.repository.user.UserRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.helpdesk.HelpdeskService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserConstants;
import wifi4eu.wifi4eu.service.user.UserService;

@Configuration
@PropertySource("classpath:env.properties")
@EnableScheduling
@Controller
public class ScheduledTasks {

    @Autowired
    private MailService mailService;

    @Autowired
    private HelpdeskService helpdeskService;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RegistrationUsersRepository registrationUsersRepository;

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

    /**
     * This cron method consumes the messages from the RabbitMQ
     */
    //-- DGCONN-NOT-NECESSARY @Scheduled(cron = "0 0/10 * * * ?")
    public void queueConsumer(HttpServletRequest request) {
        _log.debug("Consuming messages from the queue");
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
                    _log.debug("The queue is empty");
                    break;
                } else {

                    Date wdStartDate = new Date();
                    long deliveryTag = processQueueMessage(response, request);
                    Date wdEndDate = new Date();

                    //time the process has taken in milliseconds
                    long wdProcessTime = wdEndDate.getTime() - wdStartDate.getTime();
                    long messageCount = response.getMessageCount();

                    if (deliveryTag != 0) {
                        _log.debug("Sent with delivery tag " + deliveryTag);
                        channel.basicAck(deliveryTag, false); // acknowledge receipt of the message
                    } else {
                        _log.error("Cannot process a message" + response);
                    }
                    _log.debug("wdProcessTime: " + wdProcessTime + " messageCount: " + messageCount + " iterationCounter: " + iterationCounter);
                    if (wdProcessTime < 100 && messageCount > 200 && messageCount % 9 != 1) {
                        i--;
                    } else if (wdProcessTime > 500) {
                        break;
                    }
                }
            }

            channel.close();
            _log.debug("The queue channel has been closed");
            connection.close();
            _log.debug("The queue connection has been closed");
        } catch (Exception e) {
            _log.error("Cannot process the queue", e);
        }
    }

    //-- DGCONN-NOT-NECESSARY @Scheduled(cron = "0 0 9,17 * * MON-FRI")
    public void scheduleHelpdeskIssues() {
        _log.debug("Starting helpdesk issues scheduled");
        List<HelpdeskIssueDTO> helpdeskIssueDTOS = helpdeskService.getAllHelpdeskIssueNoSubmited();

        if (helpdeskIssueDTOS != null) {
        	_log.info("helpdeskIssueDTOS.size() [{}]", helpdeskIssueDTOS.size());

        	for (HelpdeskIssueDTO helpdeskIssue : helpdeskIssueDTOS) {
        		_log.info("Processing ticket id[{}]", helpdeskIssue.getId());

        		try {
        			HelpdeskTicketDTO helpdeskTicketDTO = new HelpdeskTicketDTO();
        			helpdeskTicketDTO.setForm_tools_form_id(this.helpdeskFormId);
        			helpdeskTicketDTO.setEmailAdress(helpdeskIssue.getFromEmail());
        			helpdeskTicketDTO.setEmailAdressconf(helpdeskTicketDTO.getEmailAdress());
        			helpdeskTicketDTO.setUuid("wifi4eu_" + helpdeskIssue.getId());
        			UserDTO userDTO = userService.getUserByEcasEmail(helpdeskIssue.getFromEmail());

        			if (userDTO != null) {
        				helpdeskTicketDTO.setFirstname(userDTO.getName());
        				helpdeskTicketDTO.setLastname(userDTO.getSurname());
        				helpdeskTicketDTO.setTxtsubjext(helpdeskIssue.getTopic());
        				helpdeskTicketDTO.setQuestion(helpdeskIssue.getSummary());
        				String result = executePost(this.sercoHelpdeskEndpoint, helpdeskTicketDTO.toString());

        				_log.info("Result posting to queue [{}]", result);

        				if (result != null && result.contains("Thankyou.js")) {
        					_log.info("Updating Helpdesk issue");

        					helpdeskIssue.setTicket(true);
        					helpdeskService.createOrUpdateHelpdeskIssue(helpdeskIssue);

        					_log.info("Helpdesk issue updated");
        				} else {
        					_log.error("The result do not contain the proper text");
        				}
        			} else {
        				_log.error("Cannot retrieve the user for this helpdesk issue");
        			}
        		} catch (Exception e) {
        			_log.error("Cannot process this helpdesk issue", e);
        		}
        	}
        }
    }

    //-- DGCONN-NOT-NECESSARY @Scheduled(cron = "0 0 8 ? * MON-FRI")
    public void sendDocRequest() {
        _log.debug("Sending document request");
        List<RegistrationDTO> registrationDTOS = registrationService.getAllRegistrations();
        for (RegistrationDTO registrationDTO : registrationDTOS) {
            try {
                if (registrationDTO != null && registrationDTO.getMailCounter() > 0) {
                    UserDTO user = userMapper.toDTO(userRepository.findMainUserFromRegistration(registrationDTO.getId()));

                    if (user != null && user.getEcasEmail() != null) {
                        if (!userService.isLocalHost()) {
                            Locale locale = new Locale(UserConstants.DEFAULT_LANG);
                            if (user.getLang() != null) {
                                locale = new Locale(user.getLang());
                            }
                            
                            String additionalInfoUrl = userService.getBaseUrl() + "beneficiary-portal/voucher";
                            MailData mailData = MailHelper.buildMailRequestSupportingDocumentsForRegistration(
                            		user.getEcasEmail(), MailService.FROM_ADDRESS, additionalInfoUrl, 
                            		registrationDTO.getMunicipalityId(), "sendDocRequest", locale);
                        	mailService.sendMail(mailData, false);
                        }
                        int mailCounter = registrationDTO.getMailCounter() - 1;
                        registrationDTO.setMailCounter(mailCounter);
                        registrationService.createRegistration(registrationDTO);
                        _log.debug("Document request sent for registration with id " + registrationDTO.getId());
                    }
                }
            } catch (Exception e) {
                _log.error("Cannot send document request for this registration", e);
            }
        }
    }

    private long processQueueMessage(GetResponse response, HttpServletRequest request) {
        _log.debug("Sending document request");
        try {
            AMQP.BasicProperties props = response.getProps();
            byte[] body = response.getBody();
            Envelope envelope = response.getEnvelope();

            // deserialize JSON object from the body
            ObjectMapper mapper = new ObjectMapper();
            QueueApplicationElement qae = mapper.readValue(body, QueueApplicationElement.class);

            ApplicationDTO applicationDTO = applicationService.registerApplication(qae.getCallId(), qae.getUserId(), qae.getRegistrationId(), qae.getMunicipalityId(),
                    qae.getFileUploadTimestamp(), qae.getQueueTimestamp(), request);

            long deliveryTag = 0;

            if (applicationDTO != null) {
                deliveryTag = response.getEnvelope().getDeliveryTag();
                _log.debug("The application delivery tag is " + deliveryTag);
            }
            return deliveryTag;
        } catch (Exception e) {
            _log.error("Cannot read a message from the queue", e);
            return 0;
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

    @Scheduled(cron = "59 59 23 * * *")
    public void contactEmailTimer() {
        List<RegistrationUsers> registrationUsers = Lists.newArrayList(registrationUsersRepository.findAll());
        for (int i = 0; registrationUsers.size() > i; i++) {
            RegistrationUsers registrationUser = registrationUsersRepository.findOne(i);
            if (registrationUser.getUserId() == null && (registrationUser.getCreationDate().toInstant().plus(24, ChronoUnit.HOURS).compareTo(new Date().toInstant()) == -1)) {
                registrationUsersRepository.delete(registrationUsers);
            }
        }
    }

}

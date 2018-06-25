package wifi4eu.wifi4eu.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.mapper.application.ApplicationMapper;
import wifi4eu.wifi4eu.mapper.helpdesk.HelpdeskIssueMapper;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.azurequeue.AzureQueueService;
import wifi4eu.wifi4eu.service.call.CallService;
import wifi4eu.wifi4eu.service.helpdesk.HelpdeskService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserConstants;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

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

    private static final Logger _log = LogManager.getLogger(ScheduledTasks.class);

    UserContext userContext;
    UserDTO userConnected;

    private final static String QUEUE_NAME = "wifi4eu_apply";

    @Value("${rabbitmq.host}")
    private String rabbitMQHost;

    @Value("${rabbitmq.username}")
    private String rabbitUsername;

    @Value("${rabbitmq.password}")
    private String rabbitPassword;

    /**
     * This cron method consumes the messages from the RabbitMQ
     */
    //-- DGCONN-NOT-NECESSARY @Scheduled(cron = "0 0/10 * * * ?")
    public void queueConsumer(HttpServletRequest request) {
        userContext = UserHolder.getUser();
        userConnected = userService.getUserByUserContext(userContext);
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
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Cannot process the queue", e.getMessage());
        }
    }

    //-- DGCONN-NOT-NECESSARY @Scheduled(cron = "0 0 9,17 * * MON-FRI")
    public void scheduleHelpdeskIssues() {
        userContext = UserHolder.getUser();
        userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Starting helpdesk issues scheduled");
        boolean isSuccesOperation = true;
        List<HelpdeskIssueDTO> helpdeskIssueDTOS = helpdeskService.getAllHelpdeskIssueNoSubmited();

        for (HelpdeskIssueDTO helpdeskIssue : helpdeskIssueDTOS) {

            try {
                HelpdeskTicketDTO helpdeskTicketDTO = new HelpdeskTicketDTO();

                helpdeskTicketDTO.setEmailAdress(helpdeskIssue.getFromEmail());
                helpdeskTicketDTO.setEmailAdressconf(helpdeskTicketDTO.getEmailAdress());
                helpdeskTicketDTO.setUuid(HelpdeskConstants.UUID_WIFI + helpdeskIssue.getId());

                UserDTO userDTO = userService.getUserByEcasEmail(helpdeskIssue.getFromEmail());

                if (userDTO != null) {
                    helpdeskTicketDTO.setFirstname(userDTO.getName());
                    helpdeskTicketDTO.setLastname(userDTO.getSurname());

                    helpdeskTicketDTO.setTxtsubjext(helpdeskIssue.getTopic());
                    helpdeskTicketDTO.setQuestion(helpdeskIssue.getSummary());

                    boolean result = executePost(helpdeskTicketDTO.toString());
                    isSuccesOperation = isSuccesOperation && result;

                    if (result) {
                        helpdeskIssue.setTicket(true);
                        helpdeskService.createHelpdeskIssue(helpdeskIssue);
                    } else {
                        _log.error("result that not containt proper text, the " + helpdeskTicketDTO.getUuid() + " helpdesk issue fails");
                    }
                } else {
                    _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Cannot retrieve the user for this helpdesk issue");
                }

            } catch (Exception e) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Cannot process this helpdesk issue", e.getMessage());
            }
        }
    }

    //-- DGCONN-NOT-NECESSARY @Scheduled(cron = "0 0 8 ? * MON-FRI")
    public void sendDocRequest() {
        userContext = UserHolder.getUser();
        userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Sending document request");
        List<RegistrationDTO> registrationDTOS = registrationService.getAllRegistrations();
        for (RegistrationDTO registrationDTO : registrationDTOS) {
            try {
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
                        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Document request sent for registration with id " + registrationDTO.getId());
                    }
                }
            } catch (Exception e) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Cannot send document rquest for this registration", e.getMessage());
            }
        }
    }

    private long processQueueMessage(GetResponse response, HttpServletRequest request) {
        userContext = UserHolder.getUser();
        userConnected = userService.getUserByUserContext(userContext);
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
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Cannot read a message from the queue", e.getMessage());
            return 0;
        }
    }

    @SuppressWarnings("Duplicates")
    private boolean executePost(String urlParameters) {
        try {
            HttpClient httpClient = getHttpClient();
            if (httpClient != null) {
                HttpPost postRequest = new HttpPost(HelpdeskConstants.HELPDESK_URL);
                postRequest.addHeader(HelpdeskConstants.CONTENT_TYPE, HelpdeskConstants.CONTENT_TYPE_VALUE);
                postRequest.addHeader(HelpdeskConstants.CONNECTION, HelpdeskConstants.CONNECTION_VALUE);
                postRequest.addHeader(HelpdeskConstants.CONTENT_LANGUAGE, HelpdeskConstants.CONTENT_LANGUAGE_VALUE);
                postRequest.addHeader(HelpdeskConstants.ACCEPT, HelpdeskConstants.ACCEPT_VALUE);
                postRequest.addHeader(HelpdeskConstants.REFERER, HelpdeskConstants.REFERER_VALUE);
                postRequest.addHeader(HelpdeskConstants.ORIGIN, HelpdeskConstants.ORIGIN_VALUE);
                postRequest.addHeader(HelpdeskConstants.HOST, HelpdeskConstants.HOST_VALUE);

                postRequest.setEntity(new StringEntity(urlParameters, HelpdeskConstants.CHARSET_UTF8));
                HttpResponse httpResponse = httpClient.execute(postRequest, new BasicHttpContext());
                if (httpResponse != null) {
                    if (httpResponse.getHeaders(HelpdeskConstants.LOCATION).length > 0) {
                        return true;
                    }
                }

            }
        } catch (Exception e) {
            _log.error(e.getMessage());
        }

        return false;
    }

    @SuppressWarnings("Duplicates")
    private HttpClient getHttpClient() throws Exception {
        HttpClient httpClient = null;
        HttpClientBuilder httpClientBuilder = HttpClients.custom();

        SSLContextBuilder builder = new SSLContextBuilder();
        builder.loadTrustMaterial(null, new TrustStrategy() {
            public boolean isTrusted(X509Certificate[] x509Certificate, String hostname) throws CertificateException {
                return true;
            }
        });

        SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(builder.build());
        httpClientBuilder = httpClientBuilder.setSSLSocketFactory(sslSocketFactory);
        httpClient = httpClientBuilder.build();

        return httpClient;
    }


}

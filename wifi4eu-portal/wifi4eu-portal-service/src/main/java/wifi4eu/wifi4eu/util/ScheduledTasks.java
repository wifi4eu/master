package wifi4eu.wifi4eu.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskIssueDTO;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskTicketDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.mapper.helpdesk.HelpdeskIssueMapper;
import wifi4eu.wifi4eu.service.helpdesk.HelpdeskService;
import wifi4eu.wifi4eu.service.user.UserService;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@EnableScheduling
@Controller
public class ScheduledTasks {

    @Autowired
    private HelpdeskService helpdeskService;

    @Autowired
    private HelpdeskIssueMapper helpdeskIssueMapper;

    @Autowired
    private UserService userService;

    private static final Logger _log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Scheduled(cron = "0 0/30 * * * ?") // Every 30 minutes
    //@Scheduled(cron = "*/10 * * * * ?") //Every 10 seconds
    public void scheduleHelpdeskIssues() {

        List<HelpdeskIssueDTO> helpdeskIssueDTOS = helpdeskService.getAllHelpdeskIssueNoSubmited();

        for (HelpdeskIssueDTO helpdeskIssue: helpdeskIssueDTOS) {
            HelpdeskTicketDTO helpdeskTicketDTO = new HelpdeskTicketDTO();

            helpdeskTicketDTO.setEmailAdress(helpdeskIssue.getFromEmail());
            helpdeskTicketDTO.setEmailAdressconf(helpdeskTicketDTO.getEmailAdress());

            UserDTO userDTO = userService.getUserByEcasEmail(helpdeskIssue.getFromEmail());

            helpdeskTicketDTO.setFirstname(userDTO.getName());
            helpdeskTicketDTO.setLastname(userDTO.getSurname());

            helpdeskTicketDTO.setTxtsubjext(helpdeskIssue.getTopic());
            helpdeskTicketDTO.setQuestion(helpdeskIssue.getSummary());

            String result = executePost("https://webtools.ec.europa.eu/form-tools/process.php", helpdeskTicketDTO.toString());
            if(result != null && result.contains("Thankyou.js")){
                helpdeskIssue.setTicket(true);
                helpdeskService.createHelpdeskIssue(helpdeskIssue);
            }
        }
    }

    public static String executePost(String targetURL, String urlParameters) {
        HttpURLConnection connection = null;
        try {
            //Create connection
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

            //Send request
            DataOutputStream wr = new DataOutputStream (
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            //Get Response
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

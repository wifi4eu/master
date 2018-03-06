package wifi4eu.wifi4eu.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskIssueDTO;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskTicketDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.entity.helpdesk.HelpdeskIssue;
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
    private UserService userService;

    @Scheduled(cron = "*/30 * * * * ?")
    public void scheduleHelpdeskIssues() {

        List<HelpdeskIssueDTO> helpdeskIssueDTOS = helpdeskService.getAllHelpdeskIssueNoSubmited();

        for (HelpdeskIssueDTO helpdeskIssue: helpdeskIssueDTOS) {
            System.out.println("before - " + helpdeskIssueDTOS);

            HelpdeskTicketDTO helpdeskTicketDTO = new HelpdeskTicketDTO();

            helpdeskTicketDTO.setEmailAdress(helpdeskIssue.getFromEmail());

            UserDTO userDTO = userService.getUserByEmail(helpdeskIssue.getFromEmail());

            helpdeskTicketDTO.setFirstname(userDTO.getName());
            helpdeskTicketDTO.setLastname(userDTO.getSurname());

            helpdeskTicketDTO.setTxtsubjext(helpdeskIssue.getTopic());
            helpdeskTicketDTO.setQuestion(helpdeskIssue.getSummary());

            //helpdeskIssue.setTicket(true);

            //HelpdeskIssueDTO issueDTO = helpdeskService.createHelpdeskIssue(helpdeskIssue);
            //System.out.println("After - " + issueDTO);
            executePost("https://webtools.ec.europa.eu/form-tools/process.php", helpdeskTicketDTO.toString());
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

            connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

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
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }


}

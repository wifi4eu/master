package wifi4eu.edcc.rest.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wifi4eu.edcc.rest.controller.dto.ResponseDTO;
import wifi4eu.edcc.rest.service.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
 
@RestController
@PropertySource("classpath:server.properties")
public class EdccHelpdeskRestController {

    private final String URL_REST = "/wifi4eu/api/helpdesk/issues/create";
 
    @Autowired
    UserService userService;

    @Value("${server.local.address}")
    private String url;
 

    @RequestMapping(value = "/edcc/helpdesk/", method = RequestMethod.GET, produces = "application/json")
    public ResponseDTO createHelpdeskIssuesPublic() throws Exception {
        System.out.println("Creating EDCC helpdesk issues public method");
        return sendGet();
    }

    private ResponseDTO sendGet() throws Exception {
        URL obj = new URL(url + URL_REST);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                    con.getInputStream()) );
        StringBuilder response = new StringBuilder();
        String inputLine = null;

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        Gson json = new Gson();
        return json.fromJson(response.toString(), ResponseDTO.class);
    }
 
}
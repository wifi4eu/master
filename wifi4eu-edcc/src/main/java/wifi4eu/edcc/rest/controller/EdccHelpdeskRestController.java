package wifi4eu.edcc.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wifi4eu.edcc.rest.controller.dto.ResponseDTO;
import wifi4eu.edcc.rest.model.User;
import wifi4eu.edcc.rest.service.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;
 
@RestController
public class EdccHelpdeskRestController {
 
    @Autowired
    UserService userService;  //Service which will do all data retrieval/manipulation work
 
     
    //-------------------Retrieve All Users ----------------------------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }


    //-------------------Retrieve Single User --------------------------------------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


    //-------------------Generate EDCC helpdesk issues -----------------------------------------------------------------

    @RequestMapping(value = "/user/edcc/", method = RequestMethod.GET, produces = "application/json")
    public ResponseDTO createHelpdeskIssuesPublic() throws Exception {
        System.out.println("Creating EDCC helpdesk issues public method");
        return sendGet();
    }

    private ResponseDTO sendGet() throws Exception {
        //TODO: It must be localhost to avoid ECAS Login. Test all the ports from upper environments
        final String url = "http://localhost:8080/wifi4eu/api/helpdesk/issues/create";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()) );
        StringBuilder response = new StringBuilder();
        String inputLine = null;

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        Gson g = new Gson();
        return g.fromJson(response.toString(), ResponseDTO.class);
    }
 
}
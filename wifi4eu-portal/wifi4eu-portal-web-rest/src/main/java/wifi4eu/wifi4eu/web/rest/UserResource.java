package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/user", description = "User object REST API services")
@RequestMapping("user")
public class UserResource {
}
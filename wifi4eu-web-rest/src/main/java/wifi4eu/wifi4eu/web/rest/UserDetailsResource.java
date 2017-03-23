package wifi4eu.wifi4eu.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.security.UserContext;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("user-details")
public class UserDetailsResource {
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    UserContext getIdentity(HttpServletRequest request) {
        return (UserContext) request.getSession(true).getAttribute(Constant.USER);
    }
}

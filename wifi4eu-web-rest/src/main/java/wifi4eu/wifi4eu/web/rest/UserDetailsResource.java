package wifi4eu.wifi4eu.web.rest;

import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.Constant;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user-details")
public class UserDetailsResource {
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody UserContext getIdentity(HttpServletRequest request) {
        return (UserContext) request.getSession(true).getAttribute(Constant.USER);
    }
}

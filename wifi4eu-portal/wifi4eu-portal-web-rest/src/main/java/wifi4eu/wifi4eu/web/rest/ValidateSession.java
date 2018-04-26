package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/websock", description = "Websocket")
@RequestMapping("websock")
public class ValidateSession {

    @ApiOperation(value = "Get session status")
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Boolean isInvalidatedSession() {
        HttpSession session = RecoverHttpSession.session();
        long activeSession = session.getLastAccessedTime() - session.getCreationTime();
        long timestampSeconds = TimeUnit.MILLISECONDS.toSeconds(activeSession);

        return timestampSeconds > session.getMaxInactiveInterval();
    }

}
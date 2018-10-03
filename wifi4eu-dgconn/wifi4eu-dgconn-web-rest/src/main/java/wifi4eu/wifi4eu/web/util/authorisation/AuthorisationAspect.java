package wifi4eu.wifi4eu.web.util.authorisation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletResponse;

/*
    TODO: use Spring Security instead. Right now we follow the way it was done before, please see wifi4eu.wifi4eu.web.filter.UserFilter.
    Alternative to use: @UserType5Allowed.
 */
@Component
@Aspect
public class AuthorisationAspect {

    private static final Logger logger = LoggerFactory.getLogger(AuthorisationAspect.class);

    @Autowired
    private UserService userService;

    @Around(value = "execution(* wifi4eu.wifi4eu.web.cnect.rest.*.*(..)) " +
            "&& (@target(wifi4eu.wifi4eu.web.util.authorisation.DashboardUsersOnly) || @annotation(wifi4eu.wifi4eu.web.util.authorisation.DashboardUsersOnly))")
    public Object before(ProceedingJoinPoint joinPoint) throws Throwable {
        return proceed(joinPoint);
    }

    private Object proceed(ProceedingJoinPoint joinPoint) throws Throwable {
        Object returnValue = null;
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        if (Validator.isNull(userConnected) || userConnected.getType() != 5) {
            logger.error("No permissions for " + userConnected.getEcasUsername());

            HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
            response.sendError(HttpStatus.NOT_FOUND.value());
        } else {
            logger.debug("User {} has access level 5", userConnected.getEcasUsername());

            returnValue = joinPoint.proceed();
        }

        return returnValue;
    }

}

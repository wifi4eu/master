package wifi4eu.wifi4eu.web.util.ecas;

import eu.cec.digit.ecas.client.jaas.DetailedUser;
import eu.cec.digit.ecas.client.validation.AbstractUserDetailsExtraGroupHandler;
import eu.cec.digit.ecas.client.validation.DetailedAuthenticationSuccess;
import eu.cec.digit.ecas.client.validation.ExtraGroupHandlingException;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.service.security.SecurityService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class RbacEcasExtraGroupHandler extends AbstractUserDetailsExtraGroupHandler {

    private static final long serialVersionUID = 5471585585352261455L;

    public final List<?> getGroups(DetailedAuthenticationSuccess detailedAuthenticationSuccess) throws ExtraGroupHandlingException {
        final WebApplicationContext currentWebApplicationContext = ContextLoader.getCurrentWebApplicationContext();

        if(currentWebApplicationContext == null) {
            throw new AppException("EcasExtraGroupHandler does not work if the spring webapp context is not present");
        }

        final SecurityService securityService = currentWebApplicationContext.getBean(SecurityService.class);

        return securityService.getSecurityUserRoles(detailedAuthenticationSuccess.getEmail());
    }


}
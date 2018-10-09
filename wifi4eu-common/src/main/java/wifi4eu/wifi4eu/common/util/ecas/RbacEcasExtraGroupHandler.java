package wifi4eu.wifi4eu.common.util.ecas;

import eu.cec.digit.ecas.client.validation.AbstractUserDetailsExtraGroupHandler;
import eu.cec.digit.ecas.client.validation.DetailedAuthenticationSuccess;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import wifi4eu.wifi4eu.common.exception.AppException;

import java.util.List;

public class RbacEcasExtraGroupHandler extends AbstractUserDetailsExtraGroupHandler {

    private static final long serialVersionUID = 5471585585352261455L;

    public final List<?> getGroups(DetailedAuthenticationSuccess detailedAuthenticationSuccess) {
        final WebApplicationContext currentWebApplicationContext = ContextLoader.getCurrentWebApplicationContext();

        if(currentWebApplicationContext == null) {
            throw new AppException("EcasExtraGroupHandler does not work if the spring webapp context is not present");
        }

        //final SecurityService securityService = currentWebApplicationContext.getBean(SecurityService.class);

        return null;
        //return securityService.getSecurityUserRoles(detailedAuthenticationSuccess.getEmail());
    }


}
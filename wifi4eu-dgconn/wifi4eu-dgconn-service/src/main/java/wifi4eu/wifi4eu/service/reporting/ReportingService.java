package wifi4eu.wifi4eu.service.reporting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.util.reporting.ExcelReportsRunnable;

@Service
public class ReportingService {

    @Autowired
    PermissionChecker permissionChecker;

    @Autowired
    UserService userService;

    public ResponseDTO generateCallOpenReport(){
        if (!permissionChecker.checkIfDashboardUser()) {
            throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
        }
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        ResponseDTO response = new ResponseDTO();
        (new Thread(new ExcelReportsRunnable(Constant.REPORTING_CALL_OPEN, userConnected.getName(),userConnected.getEcasEmail(), userConnected.getLang()))).start();
        response.setSuccess(true);
        response.setData("reports.generate.success");
        return response;
    }

    public ResponseDTO generateTypesInstallationReport(){
        if (!permissionChecker.checkIfDashboardUser()) {
            throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
        }
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        ResponseDTO response = new ResponseDTO();
        (new Thread(new ExcelReportsRunnable(Constant.REPORTING_TYPES_INSTALLATION_REPORT, userConnected.getName(),userConnected.getEcasEmail(), userConnected.getLang()))).start();
        response.setSuccess(true);
        response.setData("reports.generate.success");
        return response;
    }
}

package wifi4eu.wifi4eu.service.reporting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.call.Call;
import wifi4eu.wifi4eu.repository.call.CallRepository;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.util.reporting.ExcelReportsRunnable;

import java.util.ArrayList;

@Service
public class ReportingService {

    @Autowired
    private PermissionChecker permissionChecker;

    @Autowired
    private UserService userService;

    @Autowired
    private CallRepository callRepository;

    public ResponseDTO generateCallOpenReport(){
        if (!permissionChecker.checkIfDashboardUser()) {
            throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
        }
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        ResponseDTO response = new ResponseDTO();
        if (Validator.isNotNull(callRepository.getIdCurrentCall())) {
            (new Thread(new ExcelReportsRunnable(Constant.REPORTING_CALL_OPEN, userConnected.getName(), userConnected.getEcasEmail(), userConnected.getLang()))).start();
            response.setSuccess(true);
            response.setData("reports.generate.success");
        } else {
            response.setSuccess(false);
            response.setData("reports.generate.callOpen.callNotFound");
            response.setError(new ErrorDTO(400,"reports.generate.callOpen.callNotFound"));
        }
        return response;
    }

    public ResponseDTO generateTypesInstallationReport(){
        if (!permissionChecker.checkIfDashboardUser()) {
            throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
        }
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        ResponseDTO response = new ResponseDTO();
        ArrayList<Call> calls = callRepository.findCallsIncludeCurrent();
        if (calls.size() > 0){
            (new Thread(new ExcelReportsRunnable(Constant.REPORTING_TYPES_INSTALLATION_REPORT, userConnected.getName(),userConnected.getEcasEmail(), userConnected.getLang()))).start();
            response.setSuccess(true);
            response.setData("reports.generate.success");
        } else {
            response.setSuccess(false);
            response.setData("reports.generate.typesIr.callNotFound");
            response.setError(new ErrorDTO(400,"reports.generate.typesIr.callNotFound"));
        }
        return response;
    }
}

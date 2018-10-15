package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.application.ApplyVoucher;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.service.application.ApplyVoucherService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/applyvoucher", description = "Apply Voucher object REST API services")
@RequestMapping("applyvoucher")
public class ApplyVoucherResource {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionChecker permissionChecker;

    @Autowired
    ApplyVoucherService applyVoucherService;

    Logger _log = LogManager.getLogger(ApplyVoucherResource.class);

    @ApiOperation(value = "Get data for apply for voucher by specific user id")
    @RequestMapping(value = "/data/user/{userId}/call/{callId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ApplyVoucher> getDataForApplyVoucherByUserIdAndCallId(@PathVariable("userId") final Integer userId, @PathVariable("callId") final Integer callId, @RequestParam("date") final Long timestamp, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting data for apply for voucher by user id " + userId);
        try {
            permissionChecker.check(RightConstants.USER_TABLE + userId);
            List<ApplyVoucher> applyVouchers = applyVoucherService.getDataForApplyVoucher(callId, userId);
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Data for apply for voucher retrieved successfully");
            return applyVouchers;
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve this data for apply for voucher", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- This data for apply for voucher cannot been retrieved", e);
            return null;
        }
    }

    // DO NOT DELETE, DUMMY ENDPOINT TO GENERATE SWAGGER
    @ApiOperation(value = "Edit")
    @RequestMapping(value = "/edit", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public ResponseDTO editBeneficiary(@RequestBody ApplyVoucher request) {
        ResponseDTO response = new ResponseDTO();
        response.setSuccess(false);
        response.setData("Not implemented");
        return response;
    }

}

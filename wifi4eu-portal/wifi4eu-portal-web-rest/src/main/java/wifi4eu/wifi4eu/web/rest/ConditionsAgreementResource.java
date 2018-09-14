package wifi4eu.wifi4eu.web.rest;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.ConditionsAgreementDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.RequestIpRetriever;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.service.registration.conditionsAgreement.ConditionsAgreementService;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/conditionsAgreement", description = "ConditionsAgreement object REST API services")
@RequestMapping("conditionsAgreement")
public class ConditionsAgreementResource {

    @Autowired
    private PermissionChecker permissionChecker;

    @Autowired
    private UserService userService;

    @Autowired
    private ConditionsAgreementService conditionsAgreementService;

    @Autowired
    ApplicationService applicationService;

    Logger _log = LogManager.getLogger(ConditionsAgreementResource.class);

    @ApiOperation(value = "Change ConditionsAgreement Status")
    @RequestMapping(value = "/changeConditionsAgreementStatus", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO changeConditionsAgreementStatus(@RequestBody final ConditionsAgreementDTO conditionsAgreementDTO, HttpServletResponse response, HttpServletRequest request) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);

        try {
            // PREVENT BENEFICIARY CANNOT UNCLICK CONDITIONS AGREEMENT IF HE ALREADY APPLIED FOR A VOUCHER 
            // List<ApplicationDTO> applications = applicationService.getApplicationsByRegistrationId(conditionsAgreementDTO.getRegistrationId());
            // if(applications != null || !applications.isEmpty()) {
            //    throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            // }
            if (!permissionChecker.check(RightConstants.REGISTRATIONS_TABLE + conditionsAgreementDTO.getRegistrationId())) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - Condition agreement saved correctly");
            ConditionsAgreementDTO conditionsAgreementDTOReturned = conditionsAgreementService.saveConditionsAgreementDTO(userConnected, conditionsAgreementDTO);
            // return the value of the status of conditions agreement
            return new ResponseDTO(true, conditionsAgreementDTOReturned.getStatus(), null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to save condition agreements ", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- The condition agreement cannot been saved", e);
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "Get the conditions agreement status")
    @RequestMapping(value = "/getConditionsAgreementStatus/{registrationId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseDTO getConditionsAgreementStatus(@PathVariable("registrationId") final Integer registrationId, HttpServletResponse response, HttpServletRequest request) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);

        try {
            if (!permissionChecker.check(RightConstants.REGISTRATIONS_TABLE + registrationId)) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Get Current ConditionsAgreement Status From Registration [Id = " + registrationId + "]");
            return new ResponseDTO(true, conditionsAgreementService.getStatusConditionsAgreement(registrationId), null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permissions to save get ConditionsAgreement Status From Registration ", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- The condition agreement can not be recovered", e);
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        }
    }
}

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
import wifi4eu.wifi4eu.common.dto.model.OrganizationDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.organization.OrganizationService;
import wifi4eu.wifi4eu.service.user.UserService;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/organization", description = "Organization object REST API services")
@RequestMapping("organization")
public class OrganizationResource {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    UserService userService;

    @ApiOperation(value = "Get organization")
    @RequestMapping(value = "/{organizationId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public OrganizationDTO getOrganizationById(@PathVariable("organizationId") final Integer organizationId) {
        UserContext user = UserHolder.getUser();
        if (user == null || userService.getUserByUserContext(user) == null) {
            throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
        }
        return organizationService.getOrganizationById(organizationId);
    }

    @ApiOperation(value = "Get organizations by specific country")
    @RequestMapping(value = "/country/{country}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<OrganizationDTO> getOrganizationsByCountry(@PathVariable("country") final String country) {
        UserContext user = UserHolder.getUser();
        if (user == null || userService.getUserByUserContext(user) == null) {
            throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
        }
        return organizationService.getOrganizationsByCountry(country);
    }
}
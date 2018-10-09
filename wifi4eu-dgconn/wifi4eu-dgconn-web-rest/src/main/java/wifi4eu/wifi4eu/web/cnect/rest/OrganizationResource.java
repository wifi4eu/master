package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.OrganizationDTO;
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

    @ApiOperation(value = "Get all the organizations")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<OrganizationDTO> allOrganizations() {
        UserContext user = UserHolder.getUser();
        if(user == null ||  userService.getUserByUserContext(user)==null) {
            throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
        }
        return organizationService.getAllOrganizations();
    }

    @ApiOperation(value = "Get organization by specific id")
    @RequestMapping(value = "/{organizationId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public OrganizationDTO getOrganizationById(@PathVariable("organizationId") final Integer organizationId) {
        UserContext user = UserHolder.getUser();
        if(user == null ||  userService.getUserByUserContext(user)==null) {
            throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
        }
        return organizationService.getOrganizationById(organizationId);
    }

    /*
        @ApiOperation(value = "Create organization")
        @RequestMapping(method = RequestMethod.POST)
        @ResponseStatus(HttpStatus.CREATED)
        @ResponseBody
        public ResponseDTO createOrganization(@RequestBody final OrganizationDTO organizationDTO) {
            try {
                _log.info("createOrganization");
                OrganizationDTO resOrganization = organizationService.createOrganization(organizationDTO);
                return new ResponseDTO(true, resOrganization, null);
            } catch (Exception e) {
                if (_log.isErrorEnabled()) {
                    _log.error("Error on 'createOrganization' operation.", e);
                }
                return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
            }
        }

        @ApiOperation(value = "Delete organization by specific id")
        @RequestMapping(method = RequestMethod.DELETE)
        @ResponseBody
        public ResponseDTO deleteOrganization(@RequestBody final Integer organizationId) {
            try {
                _log.info("deleteOrganization: " + organizationId);
                OrganizationDTO resOrganization = organizationService.deleteOrganization(organizationId);
                return new ResponseDTO(true, resOrganization, null);
            } catch (Exception e) {
                if (_log.isErrorEnabled()) {
                    _log.error("Error on 'deleteOrganization' operation.", e);
                }
                return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
            }
        }
    */
    @ApiOperation(value = "Get organizations by specific country")
    @RequestMapping(value = "/country/{country}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<OrganizationDTO> getOrganizationsByCountry(@PathVariable("country") final String country) {
        UserContext user = UserHolder.getUser();
        if(user == null ||  userService.getUserByUserContext(user)==null) {
            throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
        }
        return organizationService.getOrganizationsByCountry(country);
    }
}
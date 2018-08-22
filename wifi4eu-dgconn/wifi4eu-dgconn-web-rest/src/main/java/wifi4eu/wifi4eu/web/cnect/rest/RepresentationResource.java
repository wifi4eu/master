package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import wifi4eu.wifi4eu.service.representation.RepresentationService;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/representation", description = "Representation object REST API services")
@RequestMapping("representation")
public class RepresentationResource {
    @Autowired
    private RepresentationService representationService;

    Logger _log = LogManager.getLogger(RepresentationResource.class);

    /*
    @ApiOperation(value = "Get all the representations")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<RepresentationDTO> allRepresentations() {
        _log.info("allRepresentations");
        return representationService.getAllRepresentations();
    }

    @ApiOperation(value = "Get representation by specific id")
    @RequestMapping(value = "/{representationId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public RepresentationDTO getRepresentationById(@PathVariable("representationId") final Integer representationId) {
        _log.info("getRepresentationById: " + representationId);
        return representationService.getRepresentationById(representationId);
    }

    @ApiOperation(value = "Create representation")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createRepresentation(@RequestBody final RepresentationDTO representationDTO) {
        try {
            _log.info("createRepresentation");
            RepresentationDTO resRepresentation = representationService.createRepresentation(representationDTO);
            return new ResponseDTO(true, resRepresentation, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'createRepresentation' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Delete representation by specific id")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteRepresentation(@RequestBody final Integer representationId) {
        try {
            _log.info("deleteRepresentation: " + representationId);
            RepresentationDTO resRepresentation = representationService.deleteRepresentation(representationId);
            return new ResponseDTO(true, resRepresentation, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'deleteRepresentation' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Get representation by mayor id")
    @RequestMapping(value = "/mayor/{mayorId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public RepresentationDTO getRepresentationByMayorId(@PathVariable("mayorId") final Integer mayorId) {
        _log.info("getRepresentationByMayorId: " + mayorId);
        return representationService.getRepresentationByMayorId(mayorId);
    }

    @ApiOperation(value = "Get representation by municipality id")
    @RequestMapping(value = "/municipality/{municipalityId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<RepresentationDTO> getRepresentationByMunicipalityId(@PathVariable("municipalityId") final Integer municipalityId) {
        _log.info("getRepresentationByMunicipalityId: " + municipalityId);
        return representationService.getRepresentationByMunicipalityId(municipalityId);
    }
    */
}
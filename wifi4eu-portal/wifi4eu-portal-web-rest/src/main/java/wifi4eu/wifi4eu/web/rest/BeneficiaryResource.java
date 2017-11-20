package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.text.MessageFormat;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDTO;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.ThreadDTO;
import wifi4eu.wifi4eu.common.dto.model.ThreadMessageDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.enums.RegistrationStatus;
import wifi4eu.wifi4eu.service.beneficiary.BeneficiaryService;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/beneficiary", description = "Beneficiary object REST API services")
@RequestMapping("beneficiary")
public class BeneficiaryResource {
    @Autowired
    private BeneficiaryService beneficiaryService;

    @Autowired
    private ThreadResource threadResource;

    @Autowired
    private RegistrationResource registrationResource;

    @Autowired
    private MunicipalityResource municipalityResource;

    private final Logger _log = LoggerFactory.getLogger(BeneficiaryResource.class);

    private final int NOT_FOUND = -1;

    private final String LOG_CONFLICT_REGISTRATION_PROCESS = "There was a conflict in the new registration process. The municipality is already used. It launches a new forum's thread";
    private final String LOG_SUCCESS_PROCESS = "Registration process success";
    private final String LOG_NULL_RESPONSE = "The 'representativeUser' from 'BeneficiaryService.submitBeneficiaryRegistration' is null";
    private final String LOG_STATUS_2_HOLD = "Registraion Id {0} updated to the status HOLD";
    private final String LOG_ERROR_FINDING_LAU = "The {0} MunicipalityId's lau was not found. Was there an error adding the new registration?";

    private List<Integer> municipalitiesWithSameLau = new ArrayList<>();


    @ApiOperation(value = "Submit beneficiary registration")
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO submitBeneficiaryRegistration(@RequestBody final BeneficiaryDTO beneficiaryDTO) {
        try {
            _log.info("submitBeneficiaryRegistration");
            List<RegistrationDTO> resRegistrations = beneficiaryService.submitBeneficiaryRegistration(beneficiaryDTO);
            return new ResponseDTO(true, resRegistrations, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }

}
package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import wifi4eu.wifi4eu.common.dto.model.BenPubSupDTO;
import wifi4eu.wifi4eu.common.dto.model.GlobalCommitmentDTO;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.service.exportImport.GlobalCommitmentsService;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*")
@Controller
@Api(value = "/configureGlobalCommitments", description = "Global Commitments")
@RequestMapping("configureGlobalCommitments")
public class GlobalCommitmentsResource {
    @Autowired
    private UserService userService;
    @Autowired
    private GlobalCommitmentsService globalCommitmentsService;

    private final Logger _log = LoggerFactory.getLogger(GlobalCommitmentsResource.class);

    /*@ApiOperation(value = "Configure Global Commitments")
    @RequestMapping(value = "/configureGlobalCommitments", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO configureGlobalCommitments() {
        try {
            _log.info("configureGlobalCommitments");
            ResponseDTO res = new ResponseDTO(true, null, null);
            res.setData(globalCommitmentsService.findGlobalCommitments());
            return res;
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("can't retrieve beneficiaries", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }*/

    /*@ApiOperation(value = "Configure Global Commitments")
    @RequestMapping(value = "/configureGlobalCommitments", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody*/
    @ApiOperation(value = "Configure Global Commitments")
    @RequestMapping(method = RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public ResponseDTO configureGlobalCommitments(){
        try {
        //return globalCommitmentsService.findGlobalCommitments();
            List<GlobalCommitmentDTO> globalCommitmentsList = globalCommitmentsService.findGlobalCommitments();
            return new ResponseDTO(true, globalCommitmentsList, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }

}
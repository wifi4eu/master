package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.BenPubSupDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.dgconn.DgconnService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/dgconn", description = "DgconnResource")
@RequestMapping("dgconn")
public class DgconnResource {

    Logger _log = Logger.getLogger(DgconnResource.class);

    @Autowired
    private DgconnService dgconnService;

    @ApiOperation(value = "Distribute vouchers")
    @RequestMapping(value = "/distribute", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public ResponseDTO distribute() {
        try {
            List<BenPubSupDTO> benPubSupDTOList = dgconnService.distribute();
            return new ResponseDTO(true, benPubSupDTOList, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }
}

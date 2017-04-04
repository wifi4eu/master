package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.VoucherDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.voucher.VoucherService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by rgarcita on 23/02/2017.
 */
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:4200")
@Controller
@Api(value = "/voucher", description = "VoucherResource")
@RequestMapping("voucher")
public class VoucherResource {

    Logger _log = LoggerFactory.getLogger(VoucherResource.class);

    @Autowired
    private VoucherService voucherService;

    @ApiOperation(value = "create Voucher request")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO create(@RequestBody final VoucherDTO voucherDTO, final HttpServletResponse response) {

        VoucherDTO resVoucherDTO;

        try {
            resVoucherDTO = voucherService.create(voucherDTO);
            return new ResponseDTO(true, resVoucherDTO, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }

    }

    @ApiOperation(value = "get all vouchers by voucherId")
    @RequestMapping(value = "/{voucherId}", method = RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public VoucherDTO findByVoucherId(@PathVariable("voucherId") final Long voucherId, final HttpServletResponse response) {
        _log.info("findByVoucherId " + voucherId);

        return voucherService.findByVoucherId(voucherId);

    }

    @ApiOperation(value = "get all vouchers for a specific call")
    @RequestMapping(value = "/call/{callId}", method = RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public List<VoucherDTO> findByCallId(@PathVariable("callId") final Long callId, final HttpServletResponse response) {
        _log.info("findByCall " + callId);

        return voucherService.findByCallId(callId);

    }


}

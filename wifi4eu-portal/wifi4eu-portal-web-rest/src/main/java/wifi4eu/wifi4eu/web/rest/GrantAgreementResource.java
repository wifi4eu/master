package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.grantAgreement.GrantAgreementService;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;


@CrossOrigin(origins = "*")
@Controller
@Api(value = "/grantAgreement", description = "Grant Agreement REST API services")
@RequestMapping("grantAgreement")
public class GrantAgreementResource {

    @Autowired
    GrantAgreementService grantAgreementService;

    @ApiOperation(value = "Confirm or request revision of installation report")
    @RequestMapping(value = "/exportBeneficiary", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<byte[]> downloadGrantAgreementPdf(HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "grantAgreementPdf.pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ByteArrayOutputStream file = grantAgreementService.downloadGrantAgreementPdf();
        return new ResponseEntity<>(file.toByteArray(), headers, HttpStatus.OK);
    }

}

package wifi4eu.wifi4eu.web.rest;

import com.google.common.base.Preconditions;
import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDTO;
import wifi4eu.wifi4eu.service.security.UserService;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by rgarcita on 08/02/2017.
 */

@Controller
@Api(description = "BeneficiaryResource")
@RequestMapping("beneficiary")
public class BeneficiaryResource {

    Logger _log = Logger.getLogger(BeneficiaryResource.class);

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final BeneficiaryDTO beneficiaryDTO, final HttpServletResponse response) {

        userService.create(beneficiaryDTO);

    }

}

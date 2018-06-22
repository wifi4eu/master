package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(description = "TestResource")
@RequestMapping(value="/test2")
@ResponseStatus(HttpStatus.OK)

public class TestResource2 {

    private Logger _log = LogManager.getLogger(TestResource2.class);

    @ApiOperation(value = "Test resource for Swagger implementation")
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getSomething() {

        _log.error("org.apache.Logger error is working");
        _log.warn("org.apache.Logger warn is working");
        _log.info("org.apache.Logger info is working");
        _log.debug("org.apache.Logger debug is working");
        return "hello eUI";
    }

}
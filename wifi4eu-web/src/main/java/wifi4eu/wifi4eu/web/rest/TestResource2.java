package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@Controller
@Api(description = "TestResource")
@RequestMapping(value="/test2")
@ResponseStatus(HttpStatus.OK)

public class TestResource2 {

    private Logger _log = LoggerFactory.getLogger(TestResource2.class);

    @ApiOperation(value = "Test resource for Swagger implementation")
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getSomething() {

        _log.error("org.slf4j.Logger error is working");
        _log.warn("org.slf4j.Logger warn is working");
        _log.info("org.slf4j.Logger info is working");
        _log.debug("org.slf4j.Logger debug is working");
        _log.trace("org.slf4j.Logger trace is working");
        return "hello eUI";
    }

}
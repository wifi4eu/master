package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "TestResource")
@RequestMapping("/")
@ResponseStatus(HttpStatus.OK)
public class TestResource3 {

    Logger _log = LogManager.getLogger(TestResource3.class);

    @ApiOperation(value = "Test resource for Swagger implementation")
    @RequestMapping(value = "/test3",
            method = RequestMethod.GET)
    public String getSomething() {

        _log.error("org.apache.log4j.Logger error is working");
        _log.warn("org.apache.log4j.Logger warn is working");
        _log.info("org.apache.log4j.Logger info is working");
        _log.debug("org.apache.log4j.Logger debug is working");

        return "hello eUI";
    }

}
package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Test resource for Swagger implementation")
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getSomething() {
        return "hello eUI";
    }

}
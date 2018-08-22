package wifi4eu.supplier.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
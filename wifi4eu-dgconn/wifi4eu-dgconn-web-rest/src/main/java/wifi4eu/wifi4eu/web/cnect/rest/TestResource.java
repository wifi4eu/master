package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
@CrossOrigin(origins = "*")
@Controller
@Api(description = "TestResource")
@RequestMapping("test")
@ResponseStatus(HttpStatus.OK)
public class TestResource {

    @ApiOperation(value = "Test resource for Swagger implementation")
    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String getSomething() {
        return "hello eUI";
    }

}
*/

/*
    @RequestMapping(value="/user/{userId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getIdentityByUserId(@PathVariable String userId) {
        try {
            UserDTO dto = adminService.findByUserId(userId);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch(NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
	}
*/
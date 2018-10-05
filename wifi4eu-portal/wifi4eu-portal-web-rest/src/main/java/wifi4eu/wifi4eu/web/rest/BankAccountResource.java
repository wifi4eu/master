package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/bankAccount", description = "Bank accounts of supplier")
@RequestMapping("BankAccount")
public class BankAccountResource {


}

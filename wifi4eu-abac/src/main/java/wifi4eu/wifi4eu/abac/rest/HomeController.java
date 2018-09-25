package wifi4eu.wifi4eu.abac.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String home() {
		return "redirect:/screen/home";
	}
	
	@RequestMapping(value = "/index.html")
	public String index() {
		return "redirect:/screen/home";
	}

	@PreAuthorize("hasRole('ROLE_INEA_OFFICER')")
	@RequestMapping(value = "/screen/*")
	public String screen() {
		return "index";
	}

}

package wifi4eu.wifi4eu.abac;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {
	
	@RequestMapping(value = "/")
	public String home() {
		return "redirect:/screen/home";
	}
	
	@RequestMapping(value = "/index.html")
	public String index() {
		return "redirect:/screen/home";
	}
	
	@RequestMapping(value = "/screen/*")
	public String screen() {
		return "index";
	}

}

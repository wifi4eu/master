package wifi4eu.wifi4eu.abac.rest;

import java.io.IOException;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController implements ErrorController {

	private static final String PATH_HOME_PAGE = "/";
	private static final String PATH_ERROR_PAGE = "/error";

	@RequestMapping(value = PATH_HOME_PAGE)
	public String getHome(Model model) throws IOException {
		return "uploadForm";
	}

	@RequestMapping(value = PATH_ERROR_PAGE)
	public String error() {
		return "Error handling";
	}

	@Override
	public String getErrorPath() {
		return PATH_ERROR_PAGE;
	}
}

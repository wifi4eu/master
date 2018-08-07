package wifi4eu.wifi4eu.abac.rest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import wifi4eu.wifi4eu.abac.rest.vo.ResponseVO;
import wifi4eu.wifi4eu.abac.service.ImportDataService;
import wifi4eu.wifi4eu.abac.service.LegalEntityService;

@Controller
@RequestMapping(path = "legalEntity")
public class LegalEntityController {

	private final Logger log = LoggerFactory.getLogger(LegalEntityController.class);

	@Autowired
	private LegalEntityService legalEntityService;

	@Autowired
	private ImportDataService importDataService;

	@RequestMapping(value = "import", method = RequestMethod.POST, produces = "application/json")
	public void importLegalEntity(@RequestParam("file") MultipartFile file) throws IOException {

		importDataService.importLegalEntities(file.getBytes());

		// write result and return
		ResponseVO result = new ResponseVO();
		result.setSuccess(true);
		result.setData("Imported OK!");
		//return result;
		//return null;
	}

	@RequestMapping(value = "export", method = RequestMethod.GET, produces = "text/csv")
	public ResponseEntity<byte[]> exportLegalEntity(final HttpServletResponse response, Model model) throws Exception {
		log.info("exportLegalEntity");

		ResponseEntity<byte[]> responseReturn = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("text/csv"));
		String filename = "exportLegalEntity.csv";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

		log.info("exportLegalEntity - generating csv file content");
		String responseData = legalEntityService.exportLegalEntityFile();
		// getBytes(Charset.forName("UTF-8"));
		responseReturn = new ResponseEntity<byte[]>(responseData.getBytes(StandardCharsets.UTF_8), headers, HttpStatus.OK);

		model.addAttribute("exportResult", "File exported successfully...");
		log.info("exportLegalEntity - csv file exported successfully");

		return responseReturn;
	}
}
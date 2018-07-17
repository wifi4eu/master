package wifi4eu.wifi4eu.abac.rest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wifi4eu.wifi4eu.abac.rest.vo.ResponseVO;
import wifi4eu.wifi4eu.abac.service.LegalEntityService;

@RestController
@RequestMapping(path = "legalEntity")
public class LegalEntityController {

	private final Logger log = LoggerFactory.getLogger(LegalEntityController.class);

	private LegalEntityService legalEntityService;

	@Autowired
	public LegalEntityController(LegalEntityService legalEntityService) {
		this.legalEntityService = legalEntityService;
	}

	/**
	 * Check if the provided content type is one of the valid values.
	 * 
	 * @param contentType
	 * @param validContentTypes
	 * @return
	 */
	private boolean checkContentType(String contentType, String[] validContentTypes) {
		for (String item : validContentTypes) {
			if (item.equals(contentType)) {
				return true;
			}
		}
		return false;
	}

	// @ PostMapping("import")
	// public String importLegalEntity(@RequestParam("file") MultipartFile file,
	// RedirectAttributes redirectAttributes) throws IOException {
	@RequestMapping(value = "import", method = RequestMethod.POST, produces = "application/json")
	public ResponseVO importLegalEntity(@RequestBody String file) throws IOException {
		log.info("importLegalEntity");

		/*
		 * String[] validContentTypes = new String[] { "application/vnd.ms-excel",
		 * "text/csv" };
		 * 
		 * if (file == null || file.isEmpty()) {
		 * log.info("importLegalEntity - not valid file");
		 * redirectAttributes.addFlashAttribute("importResult",
		 * "The file was null or empty, please upload a valid file"); } else if
		 * (!checkContentType(file.getContentType(), validContentTypes)) {
		 * log.info("importLegalEntity - not valid content type");
		 * redirectAttributes.addFlashAttribute("importResult",
		 * "The file is not valid, please upload a CSV file"); } else {
		 * log.info("importLegalEntity - processing file");
		 * legalEntityService.importLegalEntityFile(file);
		 * 
		 * redirectAttributes.addFlashAttribute("importResult",
		 * "File successfully uploaded " + file.getOriginalFilename() + "!"); }
		 */

		legalEntityService.importLegalEntityContent(file);

		// write result and return
		ResponseVO result = new ResponseVO();
		result.setSuccess(true);
		result.setData("Imported OK!");
		return result;
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
		responseReturn = new ResponseEntity<byte[]>(responseData.getBytes(StandardCharsets.UTF_8), headers,
				HttpStatus.OK);

		model.addAttribute("exportResult", "File exported successfully...");
		log.info("exportLegalEntity - csv file exported successfully");

		return responseReturn;
	}

	@RequestMapping(value = "show", method = RequestMethod.GET, produces = "application/json")
	public ResponseVO showLegalEntity() throws IOException {
		log.info("showLegalEntity");

		String responseData = legalEntityService.showLegalEntityFile();

		// write result and return
		ResponseVO result = new ResponseVO();
		result.setSuccess(true);
		result.setData(responseData);
		return result;
	}

}
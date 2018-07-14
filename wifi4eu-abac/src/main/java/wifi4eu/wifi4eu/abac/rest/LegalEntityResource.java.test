package wifi4eu.wifi4eu.abac.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import wifi4eu.wifi4eu.abac.service.LegalEntityService;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;

@RestController
@Api(value = "/legalEntity")
@RequestMapping(path = "/legalEntity")
public class LegalEntityResource {

	@Autowired
	private LegalEntityService legalEntityService;

	private final Logger log = LoggerFactory.getLogger(LegalEntityResource.class);

	@ApiOperation(value = "Import a CSV file with legal entities to create in ABAC")
	@RequestMapping(value = "/import", method = RequestMethod.POST, produces = "application/JSON")
	@ResponseBody
	public ResponseDTO importLegalEntity(final HttpServletResponse response) {
		// @ PostMapping("import")
		// public String importLegalEntity(@RequestParam("file") MultipartFile file,
		// Model model) throws IOException {

		log.info("importLegalEntity");

		try {
			return new ResponseDTO(legalEntityService.importLegalEntity(), null, null);
		} catch (AccessDeniedException ade) {
			log.error("Error with permission on operation.", ade);
			return new ResponseDTO(false, null, new ErrorDTO(403, ade.getMessage()));
		} catch (Exception e) {
			log.error("Error on operation.", e);
			return new ResponseDTO(false, null, new ErrorDTO(500, e.getMessage()));
		}
	}

	@ApiOperation(value = "Export a CSV file with created legal entities in ABAC")
	@RequestMapping(value = "/export", method = RequestMethod.GET, produces = "text/csv")
	@ResponseBody
	public ResponseEntity<byte[]> exportLegalEntity(final HttpServletResponse response) throws Exception {
		// @ PostMapping("export")
		// public String exportLegalEntity(@RequestParam("file") MultipartFile file,
		// Model model) throws IOException {

		log.info("exportLegalEntity");

		// WIFIFOREU-2498 JSON -> CSV
		ResponseEntity<byte[]> responseReturn = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("text/csv"));
		String filename = "exportLegalEntity.csv";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

		log.info("exportLegalEntity - generating csv file content");
		String responseData = legalEntityService.exportLegalEntity().getData().toString();
		// getBytes(Charset.forName("UTF-8"));
		responseReturn = new ResponseEntity<>(responseData.getBytes(), headers, HttpStatus.OK);

		log.info("exportLegalEntity - csv file exported successfully");
		return responseReturn;
	}

	@RequestMapping(value = "test", method = RequestMethod.GET, produces = "text/plain")
	public String testRest() throws IOException {
		return "OK";
	}
}
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wifi4eu.wifi4eu.abac.data.entity.ExportFile;
import wifi4eu.wifi4eu.abac.rest.vo.ResponseVO;
import wifi4eu.wifi4eu.abac.service.LegalCommitmentService;

@RestController
@RequestMapping(path = "legalCommitment")
public class LegalCommitmentController {

	private final Logger log = LoggerFactory.getLogger(LegalCommitmentController.class);

	private LegalCommitmentService legalCommitmentService;

	@Autowired
	public LegalCommitmentController(LegalCommitmentService legalCommitmentService) {
		this.legalCommitmentService = legalCommitmentService;
	}

	@RequestMapping(value = "import", method = RequestMethod.POST, produces = "application/json")
	public ResponseVO importLegalCommitment(@RequestBody String file) throws IOException {
		log.info("importLegalCommitment");

		legalCommitmentService.importLegalCommitmentContent(file);

		// write result and return
		ResponseVO result = new ResponseVO();
		result.setSuccess(true);
		result.setData("Imported OK!");
		return result;
	}

	@RequestMapping(value = "export", method = RequestMethod.GET, produces = "application/zip")
	public ResponseEntity<byte[]> exportLegalCommitment(final HttpServletResponse response, Model model)
			throws Exception {
		log.info("exportLegalCommitment");

		log.info("exportLegalCommitment - generating file content");
		ExportFile responseFile = legalCommitmentService.exportLegalCommitmentContent("exportLegalCommitment");

		log.info("exportLegalCommitment - serving response");
		ResponseEntity<byte[]> responseReturn = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(responseFile.getMimetype()));
		headers.setContentDispositionFormData(responseFile.getFilename(), responseFile.getFilename());
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

		responseReturn = new ResponseEntity<byte[]>(responseFile.getData(), headers, HttpStatus.OK);

		log.info("exportLegalCommitment - file exported successfully");

		return responseReturn;
	}

}
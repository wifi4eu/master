package wifi4eu.wifi4eu.abac.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import wifi4eu.wifi4eu.abac.data.dto.FileDTO;
import wifi4eu.wifi4eu.abac.data.entity.ImportLog;
import wifi4eu.wifi4eu.abac.rest.vo.ResponseVO;
import wifi4eu.wifi4eu.abac.service.ExportDataService;
import wifi4eu.wifi4eu.abac.service.ImportDataService;
import wifi4eu.wifi4eu.abac.service.LegalCommitmentService;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping(path = "legalCommitment")
public class LegalCommitmentController {

	private final Logger log = LoggerFactory.getLogger(LegalCommitmentController.class);

	@Autowired
	private ImportDataService importDataService;

	@Autowired
	private ExportDataService exportDataService;

	@Autowired
	private LegalCommitmentService legalCommitmentService;

	@PreAuthorize ("hasRole('ROLE_INEA_OFFICER')")
	@RequestMapping(value = "import", method = RequestMethod.POST, produces = "application/json")
	public ResponseVO importLegalCommitment(@RequestParam("file") MultipartFile file) {
		log.info("importLegalCommitment");
		ResponseVO result = new ResponseVO();
		try {
			ImportLog importLog = importDataService.importLegalCommitments(file.getOriginalFilename(), file.getBytes());
			if (!StringUtils.isEmpty(importLog.getErrors())) {
				log.error("error importing");
				result.error("error importing");
			} else {
				result.success("Imported OK!");
			}
		}catch(Exception e) {
			log.error(e.getMessage());
			result.error(e.getMessage());
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_INEA_OFFICER')")
	@RequestMapping(value = "export", method = RequestMethod.GET, produces = "application/zip")
	public ResponseEntity<byte[]> exportLegalCommitment(final HttpServletResponse response, Model model) throws Exception {
		log.info("exportLegalCommitment");

		FileDTO fileDTO = exportDataService.exportLegalCommitments();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("text/csv"));
		headers.setContentDispositionFormData(fileDTO.getFileName(), fileDTO.getFileName());
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

		ResponseEntity<byte[]> responseReturn = new ResponseEntity<byte[]>(fileDTO.getContent(), headers, HttpStatus.OK);

		return  responseReturn;
	}

	@PreAuthorize ("hasRole('ROLE_INEA_COUNTER_SIGN')")
	@RequestMapping(value = "countersign", method = RequestMethod.POST, produces = "application/json")
	public ResponseVO counterSign(@RequestBody List<Long> legalEntityIds) {

		log.info("Requested countersignature");

		ResponseVO result = new ResponseVO();
		try {
			legalCommitmentService.requestCountersignature(legalEntityIds);
			result.success("counter-signatures requested!");
		}catch(Exception e) {
			log.error(e.getMessage());
			result.error(e.getMessage());
		}
		return result;
	}

}
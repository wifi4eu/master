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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import wifi4eu.wifi4eu.abac.data.dto.FileDTO;
import wifi4eu.wifi4eu.abac.rest.vo.ResponseVO;
import wifi4eu.wifi4eu.abac.service.BudgetaryCommitmentService;
import wifi4eu.wifi4eu.abac.service.ExportDataService;
import wifi4eu.wifi4eu.abac.service.ImportDataService;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping(path = "budgetaryCommitment")
public class BudgetaryCommitmentController {

	private final Logger log = LoggerFactory.getLogger(BudgetaryCommitmentController.class);

	@Autowired
	private ImportDataService importDataService;

	@Autowired
	private ExportDataService exportDataService;

	@Autowired
	private BudgetaryCommitmentService budgetaryCommitmentService;

	@PreAuthorize("hasRole('ROLE_INEA_OFFICER')")
	@RequestMapping(value = "import", method = RequestMethod.POST, produces = "application/json")
	public ResponseVO importBudgetaryCommitment(@RequestParam("file") MultipartFile file) {
		log.info("importBudgetaryCommitment");

		ResponseVO result = new ResponseVO();
		try {
			importDataService.importBudgetaryCommitments(file.getOriginalFilename(), file.getBytes());
			result.success("Imported OK!");
		}catch(Exception e) {
			result.error(e.getMessage());
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_INEA_OFFICER')")
	@RequestMapping(value = "export", method = RequestMethod.GET, produces = "text/csv")
	public ResponseEntity<byte[]> exportBudgetaryCommitment(final HttpServletResponse response, Model model)
			throws Exception {
		log.info("exportBudgetaryCommitment");

		FileDTO fileDTO = exportDataService.exportBudgetaryCommitments();
		ResponseEntity<byte[]> responseReturn = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("text/csv"));
		headers.setContentDispositionFormData(fileDTO.getFileName(), fileDTO.getFileName());
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

		// getBytes(Charset.forName("UTF-8"));
		responseReturn = new ResponseEntity<byte[]>(fileDTO.getContent(), headers, HttpStatus.OK);

		log.info("exportBudgetaryCommitment - csv file exported successfully");

		return responseReturn;
	}

}
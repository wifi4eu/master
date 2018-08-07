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
import wifi4eu.wifi4eu.abac.service.BudgetaryCommitmentService;

@RestController
@RequestMapping(path = "budgetaryCommitment")
public class BudgetaryCommitmentController {

	private final Logger log = LoggerFactory.getLogger(BudgetaryCommitmentController.class);

	private BudgetaryCommitmentService budgetaryCommitmentService;

	@Autowired
	public BudgetaryCommitmentController(BudgetaryCommitmentService budgetaryCommitmentService) {
		this.budgetaryCommitmentService = budgetaryCommitmentService;
	}

	@RequestMapping(value = "import", method = RequestMethod.POST, produces = "application/json")
	public ResponseVO importBudgetaryCommitment(@RequestBody String file) {
		log.info("importBudgetaryCommitment");
		ResponseVO result = new ResponseVO();
		try {
			budgetaryCommitmentService.importBudgetaryCommitmentyContent(file);
			result.success("Imported OK!");
		}catch(Exception e) {
			result.error(e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "export", method = RequestMethod.GET, produces = "text/csv")
	public ResponseEntity<byte[]> exportBudgetaryCommitment(final HttpServletResponse response, Model model)
			throws Exception {
		log.info("exportBudgetaryCommitment");

		ResponseEntity<byte[]> responseReturn = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("text/csv"));
		String filename = "exportBudgetaryCommitment.csv";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

		log.info("exportBudgetaryCommitment - generating csv file content");
		String responseData = budgetaryCommitmentService.exportBudgetaryCommitmentyContent();
		// getBytes(Charset.forName("UTF-8"));
		responseReturn = new ResponseEntity<byte[]>(responseData.getBytes(StandardCharsets.UTF_8), headers,
				HttpStatus.OK);

		log.info("exportBudgetaryCommitment - csv file exported successfully");

		return responseReturn;
	}

}
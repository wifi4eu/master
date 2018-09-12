package wifi4eu.wifi4eu.abac.rest;

import javax.servlet.http.HttpServletResponse;

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
import wifi4eu.wifi4eu.abac.service.DocumentService;
import wifi4eu.wifi4eu.abac.service.ExportDataService;
import wifi4eu.wifi4eu.abac.service.ImportDataService;
import wifi4eu.wifi4eu.abac.service.LegalEntityService;

@RestController
@RequestMapping(path = "legalEntity")
public class LegalEntityController {

	private final Logger log = LoggerFactory.getLogger(LegalEntityController.class);

	@Autowired
	private LegalEntityService legalEntityService;

	@Autowired
	private ImportDataService importDataService;

	@Autowired
	private ExportDataService exportDataService;

	@Autowired
	private DocumentService documentService;

	@PreAuthorize("hasRole('ROLE_INEA_OFFICER')")
	@RequestMapping(value = "import", method = RequestMethod.POST, produces = "application/json")
	public ResponseVO importLegalEntity(@RequestParam("file") MultipartFile file) {
		ResponseVO result = new ResponseVO();
		try {
			importDataService.importLegalEntities(file.getBytes());
			result.success("Imported OK!");
		}catch(Exception e) {
			log.error(e.getMessage());
			result.error(e.getMessage());
		}
		return result;
	}

	@PreAuthorize ("hasRole('ROLE_INEA_OFFICER')")
	@RequestMapping(value = "export", method = RequestMethod.GET, produces = "text/csv")
	public ResponseEntity<byte[]> exportLegalEntity(final HttpServletResponse response, Model model) throws Exception {
		log.info("exportLegalEntity");

		FileDTO fileDTO = exportDataService.exportLegalEntities();

		ResponseEntity<byte[]> responseReturn = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("text/csv"));
		headers.setContentDispositionFormData(fileDTO.getFileName(), fileDTO.getFileName());
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

		responseReturn = new ResponseEntity<byte[]>(fileDTO.getContent(), headers, HttpStatus.OK);
		return responseReturn;
	}
}
package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.dto.rest.ServerErrorResponseDTO;
import wifi4eu.wifi4eu.service.exportImport.ExportImportAbacService;
import wifi4eu.wifi4eu.web.util.authorisation.DashboardUsersOnly;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


@CrossOrigin(origins = "*")
@Controller
@Api(value = "/exportImport", description = "Export and import registration data")
@RequestMapping("exportImport")
@DashboardUsersOnly
public class ExportImportAbacResource {

    private static final Logger logger = LoggerFactory.getLogger(ExportImportAbacResource.class);

    private static final String APPLICATION_JSON = "application/JSON";
    private static final String APPLICATION_ZIP = "application/zip";
    private static final String TEXT_CSV = "text/csv";
    private static final String IMPORT_FILE = "importFile";

    @Value("${lef.export.zip.fileName}")
    private String lefExportZipFileName;

    @Value("${budgetaryCommitment.export.fileName}")
    private String budgetaryCommitmentZipFileName;

    @Value("${legalCommitment.export.zip.fileName}")
    private String legalCommitmentZipFileName;

    @Autowired
    private ExportImportAbacService exportImportAbacService;

    @RequestMapping(value = "/importLegalEntityFBCValidate", method = RequestMethod.POST, produces = APPLICATION_JSON)
    @ResponseBody
    public ResponseDTO importLegalEntitiesFromAbac(@Valid @NotNull @RequestParam(IMPORT_FILE) MultipartFile file) {
        try {
            logger.debug("importLegalEntityFBCValidate: file size = {}", file.getSize());

            boolean success = exportImportAbacService.importLegalEntitiesFromAbac(file.getInputStream());

            logger.debug("Import of the LEF result: {}", success);

            return new ResponseDTO(success);
        } catch (Exception e) {
            logger.error("Error in operation.", e);
            return new ServerErrorResponseDTO(e.getMessage());
        }
    }

    @RequestMapping(value = "/importBudgetaryCommitment", method = RequestMethod.POST, produces = APPLICATION_JSON)
    @ResponseBody
    public ResponseDTO importBudgetaryCommitment(@Valid @NotNull @RequestParam(IMPORT_FILE) MultipartFile file) {
        logger.debug("importBudgetaryCommitment: file size = {}", file.getSize());
        try {
            boolean success = exportImportAbacService.importBudgetaryCommitment(file.getInputStream());

            return new ResponseDTO(success);
        } catch (IOException e) {
            logger.error("Error in operation.", e);
            return new ServerErrorResponseDTO(e.getMessage());
        }
    }

    @RequestMapping(value = "/importLegalCommitment", method = RequestMethod.POST, produces = APPLICATION_JSON)
    @ResponseBody
    public ResponseDTO importLegalCommitment(@Valid @NotNull @RequestParam(IMPORT_FILE) MultipartFile file) {
        logger.debug("importLegalCommitment: file size = {}", file.getSize());
        try {
            boolean success = exportImportAbacService.importLegalCommitment(file.getInputStream());

            return new ResponseDTO(success);
        } catch (IOException e) {
            logger.error("Error in operation.", e);
            return new ServerErrorResponseDTO(e.getMessage());
        }
    }

    @ApiOperation(value = "Export Beneficiary Information")
    @RequestMapping(value = "/exportBeneficiaryInformation", method = RequestMethod.GET, produces = APPLICATION_ZIP)
    @ResponseBody
    public ResponseEntity<byte[]> exportBeneficiaryInformation() throws IOException {
        logger.debug("exportBeneficiaryInformation");

        ByteArrayOutputStream file = exportImportAbacService.exportLegalEntities();

        HttpHeaders httpHeaders = createHeaders(lefExportZipFileName, APPLICATION_ZIP);
        ResponseEntity<byte[]> responseReturn = new ResponseEntity<>(file.toByteArray(), httpHeaders, HttpStatus.OK);

        logger.info("exportBeneficiaryInformation - csv file exported successfully");
        return responseReturn;
    }

    @ApiOperation(value = "Export Budgetary Commitment")
    @RequestMapping(value = "/exportBudgetaryCommitment", method = RequestMethod.GET, produces = TEXT_CSV)
    @ResponseBody
    public ResponseEntity<byte[]> exportBudgetaryCommitment() throws IOException {
        logger.debug("exportBudgetaryCommitment");

        byte[] responseData = exportImportAbacService.exportBudgetaryCommitment();

        HttpHeaders httpHeaders = createHeaders(budgetaryCommitmentZipFileName, TEXT_CSV);
        ResponseEntity<byte[]> responseReturn = new ResponseEntity<>(responseData, httpHeaders, HttpStatus.OK);

        logger.debug("exportBudgetaryCommitment - csv file exported successfully");
        return responseReturn;
    }

    @RequestMapping(value = "/exportLegalCommitment", method = RequestMethod.GET, produces = APPLICATION_ZIP)
    @ResponseBody
    public ResponseEntity<byte[]> exportLegalCommitment() throws IOException {
        logger.debug("exportLegalCommitment");

        ByteArrayOutputStream file = exportImportAbacService.exportLegalCommitment();

        HttpHeaders httpHeaders = createHeaders(legalCommitmentZipFileName, APPLICATION_ZIP);
        ResponseEntity<byte[]> responseReturn = new ResponseEntity<>(file.toByteArray(), httpHeaders, HttpStatus.OK);

        logger.debug("exportLegalCommitmentInformation - csv file exported successfully");
        return responseReturn;
    }

    @RequestMapping(value = "/importDgBudgList", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO importRegistrationData(@Valid @NotNull @RequestParam(IMPORT_FILE) MultipartFile file) {
        try {
            logger.debug("importDgBudgList");

            boolean success = exportImportAbacService.importDgBudgList(file.getInputStream());

            return new ResponseDTO(success);
        } catch (Exception e) {
            logger.error("Error in operation.", e);
            return new ServerErrorResponseDTO(e.getMessage());
        }
    }

    private HttpHeaders createHeaders(String filename, String mediaType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(mediaType));

        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return headers;
    }
}
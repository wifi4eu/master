package wifi4eu.wifi4eu.service.exportImport;

import com.google.common.collect.Lists;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;
import wifi4eu.wifi4eu.common.dto.model.ExportImportRegistrationDataDTO;
import wifi4eu.wifi4eu.common.dto.model.LauDTO;
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.service.azureblobstorage.AzureBlobConnector;
import wifi4eu.wifi4eu.entity.application.Application;
import wifi4eu.wifi4eu.entity.exportImport.AbacStatus;
import wifi4eu.wifi4eu.entity.exportImport.BeneficiaryInformation;
import wifi4eu.wifi4eu.entity.exportImport.BudgetaryCommitment;
import wifi4eu.wifi4eu.entity.exportImport.ExportFile;
import wifi4eu.wifi4eu.entity.exportImport.ExportImportLegalCommitmentInformation;
import wifi4eu.wifi4eu.entity.exportImport.ExportImportRegistrationData;
import wifi4eu.wifi4eu.entity.exportImport.GlobalCommitment;
import wifi4eu.wifi4eu.entity.grantAgreement.GrantAgreement;
import wifi4eu.wifi4eu.entity.mayor.Mayor;
import wifi4eu.wifi4eu.entity.municipality.Municipality;
import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.entity.representation.Representation;
import wifi4eu.wifi4eu.mapper.exportImport.ExportImportRegistrationDataMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.exportImport.BeneficiaryInformationRepository;
import wifi4eu.wifi4eu.repository.exportImport.BudgetaryCommitmentRepository;
import wifi4eu.wifi4eu.repository.exportImport.ExportImportRegistrationDataRepository;
import wifi4eu.wifi4eu.repository.exportImport.GlobalCommitmentRepository;
import wifi4eu.wifi4eu.repository.grantAgreement.GrantAgreementRepository;
import wifi4eu.wifi4eu.repository.mayor.MayorRepository;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.repository.representation.RepresentationRepository;
import wifi4eu.wifi4eu.service.exportImport.file.CreateFile;
import wifi4eu.wifi4eu.service.location.LauService;
import wifi4eu.wifi4eu.service.mayor.MayorService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.util.DateUtils;
import wifi4eu.wifi4eu.util.ExportFileUtils;
import wifi4eu.wifi4eu.util.ZipFileReader;
import wifi4eu.wifi4eu.util.parsing.BudgetaryCommitmentCSVColumn;
import wifi4eu.wifi4eu.util.parsing.LegalCommitmentCSVColumn;
import wifi4eu.wifi4eu.util.parsing.LegalCommitmentDocumentCSVColumn;
import wifi4eu.wifi4eu.util.parsing.LegalEntityCSVColumn;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author jlopezri
 */
@Service
@Transactional
public class ExportImportAbacServiceImpl implements ExportImportAbacService {

    private final Logger _log = LoggerFactory.getLogger(ExportImportAbacServiceImpl.class);

    private static final String ERROR_WRITING_DOWN_TO_THE_CSV_FILE = "Error writing down to the CSV file. The record will be skipped.";

    private static final String THE_RECORD_WAS_SKIPPED_AS_ITS_STATUS_IS_NOT_VALID = "The record was skipped as its status is not valid";

    @Autowired
    private ExportImportRegistrationDataMapper exportImportRegistrationDataMapper;

    @Autowired
    private ExportImportRegistrationDataRepository exportImportRegistrationDataRepository;

    @Autowired
    private BeneficiaryInformationRepository beneficiaryInformationRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private LauService lauService;

    @Autowired
    private MunicipalityService municipalityService;

    @Autowired
    private MunicipalityRepository municipalityRepository;

    @Autowired
    private MayorService mayorService;

    @Autowired
    private MayorRepository mayorRepository;

    @Autowired
    private RepresentationRepository representationRepository;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private ExportFileUtils exportFileUtilities;

    @Autowired
    private DateUtils dateUtilities;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private AzureBlobConnector azureBlobConnector;

    @Autowired
    private BudgetaryCommitmentRepository budgetaryCommitmentRepository;

    @Autowired
    private GlobalCommitmentRepository globalCommitmentRepository;

    @Autowired
    private GrantAgreementRepository grantAgreementRepository;

    @Autowired
    private ApplicationRepository applicationRepository;



    @Value("${budgetary.commitment.amount:15000}")
    private int grantedAmount;

    @Value("${lef.export.legalEntities.fileName}")
    private String lefExportDataFileName;

    @Value("${lef.export.documents.fileName}")
    private String lefExportDocumentsFileName;

    @Value("${legalCommitment.export.fileName}")
    private String legalCommitmentExportFileName;

    @Value("${legalCommitment.import.information.fileName}")
    private String legalCommitmentImportFileName;

    @Value("${legalCommitment.import.documents.fileName}")
    private String legalCommitmentImportDocumentsFileName;


    @Override
    public boolean importLegalEntitiesFromAbac(InputStream fileDataStream) throws IOException {
        _log.debug("importLegalEntityFBCValidate");

        try (InputStreamReader inputStreamReader = new InputStreamReader(fileDataStream)) {

            CSVParser csvParser = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(inputStreamReader);
            csvParser.forEach(csvRecord -> {
                ExportImportRegistrationData validatedLEF = parseValidatedLEF(csvRecord);
                if (validatedLEF != null) {
                    //todo: this is not going to work in case there is already one record
                    exportImportRegistrationDataRepository.save(validatedLEF);
                }
            });
        }
        return true;
    }

    private ExportImportRegistrationData parseValidatedLEF(CSVRecord csvRecord) {
        ExportImportRegistrationData municipalitiesAbac = null;
        String abacReference = csvRecord.get(LegalEntityCSVColumn.MUNICIPALITY_ABAC_REFERENCE);
        if (StringUtils.isNotEmpty(abacReference)) {
            String municipalityId = csvRecord.get(LegalEntityCSVColumn.MUNICIPALITY_PORTAL_ID);
            String abacStatus = csvRecord.get(LegalEntityCSVColumn.MUNICIPALITY_ABAC_STATUS);
            String abacLatinName = csvRecord.get(LegalEntityCSVColumn.MUNICIPALITY_ABAC_LATIN_NAME);

            _log.debug("ABAC Reference from LEF reference [{}] and status [{}]", abacReference, abacStatus);

            try {
                Municipality municipality = municipalityRepository.findOne(Integer.parseInt(municipalityId));
                if (municipality != null) {
                    municipalitiesAbac = new ExportImportRegistrationData();
                    municipalitiesAbac.setMunicipality(municipality);
                    municipalitiesAbac.setAbacReference(abacReference);
                    municipalitiesAbac.setAbacStandarName(abacLatinName);
                } else {
                    _log.warn("Municipality cannot be found: [{}]. Skipped.", municipalityId);
                }
            } catch (NumberFormatException e) {
                _log.error("Error parsing the CSV", e);
            }
        } else {
            _log.info("ABAC Reference is Empty");
        }
        return municipalitiesAbac;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public ByteArrayOutputStream exportLegalEntities() throws IOException {
        _log.debug("exportBeneficiaryInformation");

        List<ExportFile> exportFiles = new ArrayList<>();

        ByteArrayOutputStream entitiesOutputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream documentsOutputStream = new ByteArrayOutputStream();
        try (OutputStreamWriter entitiesOutputStreamWriter = new OutputStreamWriter(entitiesOutputStream, StandardCharsets.UTF_8);
             CSVPrinter entitiesPrinter = new CSVPrinter(entitiesOutputStreamWriter, exportFileUtilities.getMunicipalitiesCsvHeaders());
             OutputStreamWriter documentsOutputStreamWriter = new OutputStreamWriter(documentsOutputStream, StandardCharsets.UTF_8);
             CSVPrinter documentsPrinter = new CSVPrinter(documentsOutputStreamWriter, exportFileUtilities.getMunicipalitiesDocCsvHeaders())) {

            List<BeneficiaryInformation> beneficiariesInformation = beneficiaryInformationRepository.getBeneficiariesInformationSignedAndNotCounterSigned();

            if (CollectionUtils.isNotEmpty(beneficiariesInformation)) {
                Set<String> loadedMunicipalities = new HashSet<>();

                beneficiariesInformation.forEach(beneficiaryInformation -> {
                    processBeneficiaryInformation(beneficiaryInformation, loadedMunicipalities, entitiesPrinter);
                    processDocumentInformation(beneficiaryInformation, documentsPrinter, exportFiles);
                });
            }

        }

        // Add the Beneficiary CSV file
        ExportFile csvBeneficiariesFile = new ExportFile(lefExportDataFileName, entitiesOutputStream.toByteArray());
        exportFiles.add(csvBeneficiariesFile);

        // Add the Document CSV file
        ExportFile csvDocumentsFile = new ExportFile(lefExportDocumentsFileName, documentsOutputStream.toByteArray());
        exportFiles.add(csvDocumentsFile);

        return exportFileUtilities.generateZipFileStream(exportFiles);
    }

    private void processBeneficiaryInformation(BeneficiaryInformation beneficiaryInformation, Set<String> loadedMunicipalities, CSVPrinter csvPrinter) {

        // needed because BeneficiaryInformation is not an entity but a cartesian product of municipalities x legal files, and we don't want to export a municipality more than once
        if (loadedMunicipalities.contains(beneficiaryInformation.getMun_id())) {
            return;
        } else {
            loadedMunicipalities.add(beneficiaryInformation.getMun_id());
        }

        // Address include the address street and number, and must be between quotes to escape the comma ","
        beneficiaryInformation.setMun_address(ExportFileUtils.QUOTE + beneficiaryInformation.getMun_address() + ExportFileUtils.QUOTE);

        try {
            csvPrinter.printRecord(
                    defaultEmpty(beneficiaryInformation.getMun_id()),
                    defaultEmpty(beneficiaryInformation.getMun_name()),
                    defaultEmpty(beneficiaryInformation.getMun_abacName()),
                    defaultEmpty(beneficiaryInformation.getMun_address()),
                    defaultEmpty(beneficiaryInformation.getMun_postalCode()),
                    defaultEmpty(beneficiaryInformation.getMun_city()),
                    defaultEmpty(beneficiaryInformation.getMun_countryCodeISO()),
                    defaultEmpty(beneficiaryInformation.getMun_languageCodeISO()),
                    defaultEmpty(beneficiaryInformation.getMun_registrationNumber()),
                    defaultEmpty(beneficiaryInformation.getMun_abacReference()),
                    defaultEmpty(beneficiaryInformation.getMun_callNumber())
            );
        } catch (IOException e) {
            _log.error(ERROR_WRITING_DOWN_TO_THE_CSV_FILE, e);
        }
    }

    private String defaultEmpty(Object source) {
        return source != null ? source.toString() : "";
    }

    private String defaultEmpty(String source) {
        return StringUtils.defaultString(source);
    }

    private void processDocumentInformation(BeneficiaryInformation beneficiaryInformation, CSVPrinter csvPrinter, List<ExportFile> exportFiles) {

        //if (StringUtils.isNotBlank(beneficiaryInformation.getAzureUri())) {

            //String fileName = getMunicipalityPrefixedFileName(beneficiaryInformation);

            try {
                String fileName = "lef_supporting_document-" + beneficiaryInformation.getMun_id() + ".pdf";

                csvPrinter.printRecord(
                        beneficiaryInformation.getMun_id(),
                        beneficiaryInformation.getDoc_portalId(),
                        "lef_supporting_document.pdf",
                        fileName,
                        "application/pdf",
                        dateUtilities.convertDate2String(beneficiaryInformation.getDoc_date()),
                        defaultEmpty(beneficiaryInformation.getDoc_type()),
                        defaultEmpty(beneficiaryInformation.getAresReference())
                );

                /* we should really keep this instead
                csvPrinter.printRecord(
                        beneficiaryInformation.getMun_id(),
                        defaultEmpty(beneficiaryInformation.getDoc_portalId()),
                        StringUtils.defaultString(beneficiaryInformation.getDoc_name(), fileName),
                        fileName,
                        defaultEmpty(beneficiaryInformation.getDoc_mimeType()),
                        dateUtilities.convertDate2String(beneficiaryInformation.getDoc_date()),
                        defaultEmpty(beneficiaryInformation.getDoc_type()),
                        defaultEmpty(beneficiaryInformation.getAresReference())
                );

                // What if a file is too big?
                String base64FileData = azureBlobConnector.downloadLegalFile(beneficiaryInformation.getAzureUri());
                byte[] fileData = StringUtils.isNotEmpty(base64FileData) ? Base64Utils.decodeFromString(base64FileData) : new byte[0];
                */

                ByteArrayOutputStream os = new ByteArrayOutputStream();
                createBeneficiaryAbacPDF(beneficiaryInformation, os);
                ExportFile exportFile = new ExportFile(fileName, os.toByteArray());
                exportFiles.add(exportFile);
            } catch (IOException e) {
                _log.error(ERROR_WRITING_DOWN_TO_THE_CSV_FILE, e);
            }

        //}
    }

    /**
     * Meant as a temporary solution while we try to convince BUDG that this is meaningless
     * Create a pdf containing municipality and mayor/representation data
     *
     * @param beneficiaryInformation
     * @param os
     * @return
     */
    private OutputStream createBeneficiaryAbacPDF(BeneficiaryInformation beneficiaryInformation, OutputStream os) {
        Document document = new Document();
        try {
            int chapterNum = 0;
            PdfWriter.getInstance(document, os);
            document.open();
            Font tittleFont = FontFactory.getFont(FontFactory.HELVETICA, 24, Font.BOLD);
            Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC);
            Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

            Chunk titleTxt = new Chunk("LEF supporting document", tittleFont);
            Paragraph titlePar = new Paragraph(titleTxt);
            titlePar.setAlignment(Element.ALIGN_CENTER);
            Chapter titleCh = new Chapter(titlePar, chapterNum++);

            Chunk municipalityTitleTxt = new Chunk("Municipality information", chapterFont);
            Chapter municipalityChapter = new Chapter(new Paragraph(municipalityTitleTxt), chapterNum++);
            municipalityChapter.setNumberDepth(0);

            StringBuilder municipalityParagraphText = new StringBuilder();
            municipalityParagraphText.append("Municipality id: ").append(beneficiaryInformation.getMun_id()).append("\n");
            municipalityParagraphText.append("Municipality name: ").append(beneficiaryInformation.getMun_name()).append("\n");
            municipalityParagraphText.append("Municipality ABAC name: ").append(beneficiaryInformation.getMun_abacName()).append("\n");
            municipalityParagraphText.append("Municipality adress: ").append(beneficiaryInformation.getMun_address()).append("\n");
            municipalityParagraphText.append("Municipality postal code: ").append(beneficiaryInformation.getMun_postalCode()).append("\n");
            municipalityParagraphText.append("Municipality country code: ").append(beneficiaryInformation.getMun_countryCodeISO()).append("\n");

            municipalityChapter.add(new Paragraph(municipalityParagraphText.toString(), paragraphFont));
            document.add(municipalityChapter);

            Mayor mayor = mayorRepository.findByMunicipalityId(Integer.parseInt(beneficiaryInformation.getMun_id()));
            if (mayor != null) {
                Chunk mayorTitleText = new Chunk("Mayor information", chapterFont);
                Chapter mayorChapter = new Chapter(new Paragraph(mayorTitleText), chapterNum++);
                mayorChapter.setNumberDepth(0);

                StringBuilder mayorParagraphText = new StringBuilder();
                mayorParagraphText.append("Mayor id: ").append(mayor.getId()).append("\n");
                mayorParagraphText.append("Mayor name: ").append(mayor.getName()).append("\n");
                mayorParagraphText.append("Mayor surname: ").append(mayor.getSurname()).append("\n");
                mayorParagraphText.append("Mayor email: ").append(mayor.getEmail()).append("\n");

                mayorChapter.add(new Paragraph(mayorParagraphText.toString(), paragraphFont));
                document.add(mayorChapter);
            }

            Iterable<Representation> representations = representationRepository.findByMunicipalityId(Integer.parseInt(beneficiaryInformation.getMun_id()));
            if (representations.iterator().hasNext()) {
                Chunk representationsTitleText = new Chunk("Representations information", chapterFont);
                Chapter representationsChapter = new Chapter(new Paragraph(representationsTitleText), chapterNum++);
                representationsChapter.setNumberDepth(0);
                representations.forEach(representation -> {
                    StringBuilder representationParagraphText = new StringBuilder();
                    Mayor mayorRep = representation.getMayor();
                    representationParagraphText.append("Mayor id: ").append(mayorRep.getId()).append("\n");
                    representationParagraphText.append("Mayor name: ").append(mayorRep.getName()).append("\n");
                    representationParagraphText.append("Mayor surname: ").append(mayorRep.getSurname()).append("\n");
                    representationParagraphText.append("Mayor email: ").append(mayorRep.getEmail()).append("\n");
                    representationsChapter.add(new Paragraph(representationParagraphText.toString(), paragraphFont));
                });
                document.add(representationsChapter);
            }

            document.close();
        } catch (DocumentException e) {
            _log.error("unable to create beneficiary pdf", e);
        }
        return os;
    }

    private String getMunicipalityPrefixedFileName(BeneficiaryInformation beneficiaryInformation) {
        return StringUtils.isNotEmpty(beneficiaryInformation.getDoc_fileName()) ? beneficiaryInformation.getDoc_portalId() + "-" + beneficiaryInformation.getDoc_fileName() : Strings.EMPTY;
    }

    @Override
    @Deprecated
    public void exportRegistrationData() throws Exception {
        _log.debug("exportRegistrationData");

        List<ExportImportRegistrationDataDTO> exportImportRegistrationDataList = exportImportRegistrationDataMapper
                .toDTOList(Lists.newArrayList(exportImportRegistrationDataRepository.findExportImportRD()));
        String[] header = {"EU Rank", "Country Rank", "Country Name", "Municipality name", "Issue",
                "Number of registrations"};
        String[][] document = new String[exportImportRegistrationDataList.size()][7];
        Integer[][] countryCount = new Integer[exportImportRegistrationDataList.size()][2];
        for (int i = 0; i < exportImportRegistrationDataList.size(); i++) {
            String country = exportImportRegistrationDataList.get(i).getCountryName();
            String municipailty = exportImportRegistrationDataList.get(i).getMunicipalityName();
            int countCountry = 0;
            int countMunicipality = 0;
            for (int u = 0; u < exportImportRegistrationDataList.size(); u++) {
                if (country.equals(exportImportRegistrationDataList.get(u).getCountryName())) {
                    countCountry++;
                    countryCount[u][0] = countCountry;
                    countryCount[u][1] = exportImportRegistrationDataList.get(u).getEuRank();

                }
                if (municipailty.equals(exportImportRegistrationDataList.get(u).getMunicipalityName())) {
                    countMunicipality++;
                }
            }
            document[i][0] = String.valueOf(exportImportRegistrationDataList.get(i).getEuRank());
            for (int w = 0; w < countryCount.length; w++) {
                if (null != countryCount[w][0]) {
                    if (exportImportRegistrationDataList.get(i).getEuRank() == countryCount[w][1]) {
                        document[i][1] = String.valueOf(countryCount[w][0]);
                    }
                }
            }
            document[i][2] = exportImportRegistrationDataList.get(i).getCountryName();
            document[i][3] = exportImportRegistrationDataList.get(i).getMunicipalityName();
            Municipality municipality = municipalityRepository
                    .findOne(exportImportRegistrationDataList.get(i).getMunicipality());
            document[i][4] = String.valueOf(setIssueToDgconnBeneficiary(municipality.getLau().getId()));
            document[i][5] = String.valueOf(countMunicipality);
        }
        CreateFile cF = new CreateFile(httpServletRequest);
        cF.createExcelFileRegistrationData(header, document, "ExportRegistrationData.xlsx");
    }

    @Override
    public boolean importDgBudgList(InputStream inputStream) throws Exception {
        _log.debug("importDgBudgList");

        try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream)) {

            CSVParser csvParser = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(inputStreamReader);
            csvParser.forEach(this::updateAbacData);
        }
        return true;
    }

    private void updateAbacData(CSVRecord csvRecord) {
        Integer municipalityId = Integer.parseInt(csvRecord.get(LegalEntityCSVColumn.MUNICIPALITY_PORTAL_ID));
        List<ExportImportRegistrationData> exportImportRegistrationData = exportImportRegistrationDataRepository.findByMunicipalityId(municipalityId);

        if (CollectionUtils.isNotEmpty(exportImportRegistrationData)) {
            exportImportRegistrationData.forEach(data -> {

                String abacName = csvRecord.get(LegalEntityCSVColumn.MUNICIPALITY_ABAC_LATIN_NAME.getValue());
                data.setAbacStandarName(abacName);

                String abacReference = csvRecord.get(LegalEntityCSVColumn.MUNICIPALITY_ABAC_REFERENCE.getValue());
                data.setAbacReference(abacReference);

            });

            exportImportRegistrationDataRepository.save(exportImportRegistrationData);
        }
    }

    @Override
    public byte[] exportBudgetaryCommitment() throws IOException {
        _log.debug("exportBudgetaryCommitment");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
             CSVPrinter printer = new CSVPrinter(outputStreamWriter, getBudgetaryCommitmentCSVHeaders())) {
            List<BudgetaryCommitment> budgetaryCommitments = createBudgetaryCommitments();
            budgetaryCommitments.forEach(budgetaryCommitment -> {
                _log.debug("Writing a CSV record for the municipality with an id [{}]", budgetaryCommitment.getMunicipality().getId());

                writeBudgetaryCommitmentRecord(printer, budgetaryCommitment);
            });
        }

        return outputStream.toByteArray();
    }

    private List<BudgetaryCommitment> createBudgetaryCommitments() {
        List<ExportImportRegistrationData> exportImportRegistrationData = exportImportRegistrationDataRepository.findRegistrationDataForBudgetaryCommitment();
        if (CollectionUtils.isNotEmpty(exportImportRegistrationData)) {

            // TODO: take all. Later we will select the one based on the call.
            List<GlobalCommitment> currentGlobalCommitments = globalCommitmentRepository.findAllByOrderByPriority();
            if (CollectionUtils.isNotEmpty(currentGlobalCommitments)) {

                List<BudgetaryCommitment> budgetaryCommitments = new ArrayList<>();

                int globalCommitmentIndex = 0;
                GlobalCommitment[] globalCommitments = currentGlobalCommitments.toArray(new GlobalCommitment[0]);

                for (ExportImportRegistrationData registrationData : exportImportRegistrationData) {

                    int neededAmount = grantedAmount;
                    while (neededAmount > 0) {

                        int currentGlobalAmount = globalCommitments[globalCommitmentIndex].getAmmount();

                        if (currentGlobalAmount <= 0 && globalCommitmentIndex >= globalCommitments.length - 1) {
                            // It means that there are no Global Commitments with money
                            break;
                        } else {
                            if (currentGlobalAmount > 0) {
                                globalCommitments[globalCommitmentIndex].setAmmount(Math.max(currentGlobalAmount - neededAmount, 0));

                                BudgetaryCommitment budgetaryCommitment = new BudgetaryCommitment();
                                budgetaryCommitment.setMunicipality(registrationData.getMunicipality());
                                budgetaryCommitment.setGlobalCommitment(globalCommitments[globalCommitmentIndex]);
                                budgetaryCommitment.setPosition(globalCommitmentIndex + 1);
                                budgetaryCommitment.setAmmount(Math.min(currentGlobalAmount, neededAmount));
                                budgetaryCommitments.add(budgetaryCommitment);

                                neededAmount -= budgetaryCommitment.getAmmount();
                            } else {
                                ++globalCommitmentIndex;
                            }
                        }
                    }

                }

                globalCommitmentRepository.save(Arrays.asList(globalCommitments));
                budgetaryCommitmentRepository.save(budgetaryCommitments);

                return budgetaryCommitments;
            }
        }
        return Collections.emptyList();
    }

    private CSVFormat getBudgetaryCommitmentCSVHeaders() {
        return CSVFormat.EXCEL.withHeader(
                BudgetaryCommitmentCSVColumn.MUNICIPALITY_ID.getValue(),
                BudgetaryCommitmentCSVColumn.GLOBAL_COMMITMENT_ABAC_KEY.getValue(),
                BudgetaryCommitmentCSVColumn.COMMITMENT_LEVEL2_POSITION.getValue(),
                BudgetaryCommitmentCSVColumn.COMMITMENT_LEVEL2_POSITION_AMOUNT.getValue()
        );
    }

    private void writeBudgetaryCommitmentRecord(CSVPrinter printer, BudgetaryCommitment budgetaryCommitment) {
        try {
            printer.printRecord(
                    budgetaryCommitment.getMunicipality().getId(),
                    budgetaryCommitment.getGlobalCommitment().getGlobalCommitment(),
                    budgetaryCommitment.getPosition(),
                    budgetaryCommitment.getAmmount()
            );
        } catch (IOException e) {
            _log.error("Error writing a BC record to a CSV file", e);
        }
    }

    @Deprecated
    private Integer setIssueToDgconnBeneficiary(Integer lauId) {
        int issueType = 0;
        LauDTO lau = lauService.getLauById(lauId);
        List<MunicipalityDTO> municipalities = municipalityService.getMunicipalitiesByLauId(lauId);
        for (MunicipalityDTO municipality : municipalities) {
            MayorDTO mayor = mayorService.getMayorByMunicipalityId(municipality.getId());
            RegistrationDTO registration = registrationService.getRegistrationByMunicipalityId(municipality.getId());
            if (registration != null && mayor != null) {
                UserDTO user = userService.getMainUserByIdFromRegistration(registration.getId());
                if (user != null) {
                    switch (lau.getCountryCode().toUpperCase()) {
                        case "AT":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".at")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".at")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".at")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("de"))) {
                                issueType = 3;
                            }
                            break;
                        case "BE":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".be")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".be")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".be")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("de") || user.getLang().toLowerCase().equals("nl")
                                    || user.getLang().toLowerCase().equals("fr"))) {
                                issueType = 3;
                            }
                            break;
                        case "BG":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".bg")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".bg")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".bg")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("bg"))) {
                                issueType = 3;
                            }
                            break;
                        case "HR":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".hr")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".hr")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".hr")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("hr"))) {
                                issueType = 3;
                            }
                            break;
                        case "CY":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".cy")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".cy")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".cy")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("el"))) {
                                issueType = 3;
                            }
                            break;
                        case "CZ":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".cz")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".cz")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".cz")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("cs"))) {
                                issueType = 3;
                            }
                            break;
                        case "DK":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".dk")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".dk")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".dk")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("da"))) {
                                issueType = 3;
                            }
                            break;
                        case "EE":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".ee")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".ee")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".ee")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("et"))) {
                                issueType = 3;
                            }
                            break;
                        case "FI":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".fi")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".fi")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".fi")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("fi") || user.getLang().toLowerCase().equals("sv"))) {
                                issueType = 3;
                            }
                            break;
                        case "FR":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".fr")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".fr")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".fr")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("fr"))) {
                                issueType = 3;
                            }
                            break;
                        case "DE":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".de")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".de")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".de")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("de"))) {
                                issueType = 3;
                            }
                            break;
                        case "EL":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".el")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".el")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".el")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("el"))) {
                                issueType = 3;
                            }
                            break;
                        case "HU":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".hu")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".hu")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".hu")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("hu"))) {
                                issueType = 3;
                            }
                            break;
                        case "IS":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".is")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".is")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".is")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("en"))) {
                                issueType = 3;
                            }
                            break;
                        case "IE":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".ie")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".ie")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".ie")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("en") || user.getLang().toLowerCase().equals("ga"))) {
                                issueType = 3;
                            }
                            break;
                        case "IT":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".it")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".it")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".it")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("it"))) {
                                issueType = 3;
                            }
                            break;
                        case "LV":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".lv")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".lv")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".lv")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("lv"))) {
                                issueType = 3;
                            }
                            break;
                        case "LT":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".lt")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".lt")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".lt")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("lt"))) {
                                issueType = 3;
                            }
                            break;
                        case "LU":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".lu")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".lu")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".lu")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("fr") || user.getLang().toLowerCase().equals("de"))) {
                                issueType = 3;
                            }
                            break;
                        case "MT":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".mt")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".mt")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".mt")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("mt") || user.getLang().toLowerCase().equals("en"))) {
                                issueType = 3;
                            }
                            break;
                        case "NL":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".nl")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".nl")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".nl")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("nl"))) {
                                issueType = 3;
                            }
                            break;
                        case "NO":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".no")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".no")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".no")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("en"))) {
                                issueType = 3;
                            }
                            break;
                        case "PL":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".pl")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".pl")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".pl")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("pl"))) {
                                issueType = 3;
                            }
                            break;
                        case "PT":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".pt")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".pt")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".pt")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("pt"))) {
                                issueType = 3;
                            }
                            break;
                        case "RO":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".ro")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".ro")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".ro")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("ro"))) {
                                issueType = 3;
                            }
                            break;
                        case "SK":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".sk")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".sk")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".sk")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("sk"))) {
                                issueType = 3;
                            }
                            break;
                        case "SI":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".si")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".si")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".si")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("sl"))) {
                                issueType = 3;
                            }
                            break;
                        case "ES":
                            if (!(user.getEmail().trim().toLowerCase().endsWith(".es")
                                    || user.getEmail().trim().toLowerCase().endsWith(".cat")
                                    || user.getEmail().trim().toLowerCase().endsWith(".gal")
                                    || user.getEmail().trim().toLowerCase().endsWith(".eus"))
                                    || !(user.getEcasEmail().trim().toLowerCase().endsWith(".es")
                                    || user.getEcasEmail().trim().toLowerCase().endsWith(".cat")
                                    || user.getEcasEmail().trim().toLowerCase().endsWith(".gal")
                                    || user.getEcasEmail().trim().toLowerCase().endsWith(".eus"))
                                    || !(mayor.getEmail().trim().toLowerCase().endsWith(".es")
                                    || mayor.getEmail().trim().toLowerCase().endsWith(".cat")
                                    || mayor.getEmail().trim().toLowerCase().endsWith(".gal")
                                    || mayor.getEmail().trim().toLowerCase().endsWith(".eus"))) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("es"))) {
                                issueType = 3;
                            }
                            break;
                        case "SE":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".se")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".se")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".se")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("sv"))) {
                                issueType = 3;
                            }
                            break;
                        case "UK":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".uk")
                                    || !user.getEcasEmail().trim().toLowerCase().endsWith(".uk")
                                    || !mayor.getEmail().trim().toLowerCase().endsWith(".uk")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("en"))) {
                                issueType = 3;
                            }
                            break;
                    }
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
        return issueType;
    }

    @Override
    public boolean importBudgetaryCommitment(InputStream fileDataStream) throws IOException {
        _log.debug("importBudgetaryCommitment");

        try (InputStreamReader inputStreamReader = new InputStreamReader(fileDataStream)) {
            CSVParser csvParser = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(inputStreamReader);
            csvParser.forEach(csvRecord -> {
                BudgetaryCommitment budgetaryCommitment = parseBudgetaryCommitment(csvRecord);
                if (budgetaryCommitment != null) {
                    budgetaryCommitmentRepository.save(budgetaryCommitment);
                }
            });
        }
        return true;
    }

    private BudgetaryCommitment parseBudgetaryCommitment(CSVRecord csvRecord) {

        AbacStatus abacStatus = AbacStatus.fromValue(csvRecord.get(BudgetaryCommitmentCSVColumn.ABAC_STATUS));
        if (abacStatus == AbacStatus.ABAC_VALID) {
            String municipalityId = csvRecord.get(BudgetaryCommitmentCSVColumn.MUNICIPALITY_ID);
            String commitmentLevel2Position = csvRecord.get(BudgetaryCommitmentCSVColumn.COMMITMENT_LEVEL2_POSITION);
            String commitmentLevel2PositionAmount = csvRecord.get(BudgetaryCommitmentCSVColumn.COMMITMENT_LEVEL2_POSITION_AMOUNT);

            BudgetaryCommitment budgetaryCommitment = budgetaryCommitmentRepository.findByMunicipalityIdAndPositionAndAmmount(
                    Integer.parseInt(municipalityId),
                    Integer.parseInt(commitmentLevel2Position),
                    Integer.parseInt(commitmentLevel2PositionAmount)
            );

            if (budgetaryCommitment != null) {
                String level2AbacKey = csvRecord.get(BudgetaryCommitmentCSVColumn.COMMITMENT_LEVEL2_ABAC_KEY);
                budgetaryCommitment.setAbacBcKey(level2AbacKey);

                return budgetaryCommitment;
            }
        } else {
            _log.warn(THE_RECORD_WAS_SKIPPED_AS_ITS_STATUS_IS_NOT_VALID);
        }

        return null;
    }

    @Override
    public boolean importLegalCommitment(InputStream inputStream) throws IOException {

        // TODO: needs o be improved for the really big files
        byte[] zipFile = IOUtils.toByteArray(inputStream);

        ZipFileReader.ZipFileEntry informationFile = parseEntryFromFile(new ByteArrayInputStream(zipFile), legalCommitmentImportFileName);

        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(informationFile.getContent());
             InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream)) {

            Map<Integer, String> municipalityDocuments = parseLegalCommitmentFileNames(new ByteArrayInputStream(zipFile));

            CSVParser csvParser = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(inputStreamReader);
            csvParser.forEach(csvRecord -> {

                AbacStatus abacStatus = AbacStatus.fromValue(csvRecord.get(LegalCommitmentCSVColumn.ABAC_STATUS));
                if (abacStatus == AbacStatus.ABAC_VALID) {
                    updateGrantAgreement(csvRecord, municipalityDocuments, zipFile);
                } else {
                    _log.warn(THE_RECORD_WAS_SKIPPED_AS_ITS_STATUS_IS_NOT_VALID);
                }
            });
        }

        return true;
    }

    private void updateGrantAgreement(CSVRecord csvRecord, Map<Integer, String> municipalityDocuments, byte[] zipFile) {

        Integer municipalityId = Integer.parseInt(csvRecord.get(LegalCommitmentCSVColumn.MUNICIPALITY_ID));

        GrantAgreement grantAgreement =
                grantAgreementRepository.findByApplicationRegistrationMunicipalityIdAndDateCounterSignatureIsNull(municipalityId);

        List<BudgetaryCommitment> budgetaryCommitments = budgetaryCommitmentRepository.findByMunicipalityId(municipalityId);

        if (grantAgreement == null) {
            _log.error("Cannot find a grant agreement for the municipality [{}]", municipalityId);
        } else {
            Date counterSignatureDate = dateUtilities.convertToDate(csvRecord.get(LegalCommitmentCSVColumn.COUNTERSIGNATURE_DATE));
            grantAgreement.setDateCounterSignature(counterSignatureDate);

            String abacLCKey = csvRecord.get(LegalCommitmentCSVColumn.ABAC_KEY);

            String pdfFileName = municipalityDocuments.get(municipalityId);

            if (StringUtils.isEmpty(pdfFileName)) {
                _log.error("Inconsistency in the documents list and legal commitments files. Specified pdf file cannot be found.");
            } else {
                //save the countersigned grant agreement
                String counterSignedDocumentPath = uploadCounterSignedDocument(pdfFileName, zipFile);
                grantAgreement.setDocumentLocationCounterSigned(counterSignedDocumentPath);
                grantAgreementRepository.save(grantAgreement);

                //save the abac LC key in all positions of the budgetary commitment (1 or 2 positions)
                budgetaryCommitments.forEach(budgetaryCommitment -> {
                    budgetaryCommitment.setAbacLcKey(abacLCKey);
                    budgetaryCommitmentRepository.save(budgetaryCommitment);
                });
            }

        }
    }

    private String uploadCounterSignedDocument(String pdfFileName, byte[] zipFile) {
        try {

            ZipFileReader.ZipFileEntry pdfFile = parseEntryFromFile(new ByteArrayInputStream(zipFile), pdfFileName);

            if (pdfFile == null || pdfFile.getContent() == null) {
                throw new IllegalStateException("Error parsing a file " + pdfFileName + ". Please, check if Zip file is consistent.");
            }

            return azureBlobConnector.uploadLegalFile(pdfFileName, new ByteArrayInputStream(pdfFile.getContent()), pdfFile.getContent().length);
        } catch (IOException e) {
            _log.error("Error processing and uploading the file " + pdfFileName, e);
        }

        return null;
    }

    private Map<Integer, String> parseLegalCommitmentFileNames(ByteArrayInputStream zipFile) throws IOException {

        ZipFileReader.ZipFileEntry documentFile = parseEntryFromFile(zipFile, legalCommitmentImportDocumentsFileName);

        // TODO: needs o be improved for the really big files
        // Too heavy to hold all FileEntries thus we keep only file names.
        Map<Integer, String> municipalityDocuments = new HashMap<>();

        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(documentFile.getContent());
             InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream)) {

            CSVParser csvParser = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(inputStreamReader);
            csvParser.forEach(csvRecord -> {

                String municipalityId = csvRecord.get(LegalCommitmentDocumentCSVColumn.MUNICIPALITY_ID);
                String documentFileName = csvRecord.get(LegalCommitmentDocumentCSVColumn.DOC_FILE_NAME);

                municipalityDocuments.put(Integer.parseInt(municipalityId), documentFileName);

            });
        }

        return municipalityDocuments;
    }

    private ZipFileReader.ZipFileEntry parseEntryFromFile(InputStream zipFile, String fileName) throws IOException {

        try (ZipFileReader zipFileReader = new ZipFileReader(zipFile)) {

            ZipFileReader.ZipFileEntry fileEntry = zipFileReader.getFileEntry(fileName);
            if (fileEntry != null) {
                return fileEntry;
            } else {
                throw new IllegalStateException("File " + fileName + " is missing");
            }

        }
    }

    @Override
    @Transactional(readOnly = true)
    public ByteArrayOutputStream exportLegalCommitment() throws IOException {

        _log.debug("exportLegalCommitment");

        List<ExportFile> exportFiles = new ArrayList<>();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
             CSVPrinter printer = new CSVPrinter(outputStreamWriter, CSVFormat.EXCEL.withHeader(
                     "mun_id", "doc_portalId", "doc_name", "doc_fileName", "doc_mimeType", "doc_date", "doc_type", "ares_reference"
             ))) {

            List<ExportImportLegalCommitmentInformation> legalCommitmentsInformations = searchLegalCommitments();
            this._log.debug("legalCommitmentsData.size [{}]", legalCommitmentsInformations.size());

            if (CollectionUtils.isNotEmpty(legalCommitmentsInformations)) {
                for (ExportImportLegalCommitmentInformation legalCommitmentInformation : legalCommitmentsInformations) {

                    List<ExportFile> listExportFile = legalCommitmentInformation.getFiles();

                    for (ExportFile exportFile : listExportFile) {

                        try {
                            printer.printRecord(
                                    legalCommitmentInformation.getMunicipalityId(),
                                    legalCommitmentInformation.getDocumentId(),
                                    legalCommitmentInformation.getDocumentName(),
                                    legalCommitmentInformation.getZipFileDocumentName(),
                                    legalCommitmentInformation.getDocumentMimeType(),
                                    legalCommitmentInformation.getDocumentSignatureDate(),
                                    legalCommitmentInformation.getDocumentType(),
                                    legalCommitmentInformation.getAresReference()
                            );
                        } catch (IOException e) {
                            _log.error("Error writing a BC record to a CSV file", e);
                        }

                        exportFiles.add(exportFile);
                    }
                }

            }
        }

        // Add the Legal Commitment CSV file
        byte[] fileBytes = outputStream.toByteArray();

        this._log.debug("Exporting to file. FileName [{}]", legalCommitmentExportFileName);

        ExportFile csvLegalCommitmentsFile = new ExportFile(legalCommitmentExportFileName, fileBytes);
        exportFiles.add(csvLegalCommitmentsFile);

        return exportFileUtilities.generateZipFileStream(exportFiles);
    }


    private List<ExportImportLegalCommitmentInformation> searchLegalCommitments() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        List<BudgetaryCommitment> listBudgetaryCommitment = budgetaryCommitmentRepository.findByAbacBcKeyIsNotNullAndAbacLcKeyIsNull();
        this._log.debug("listBudgetaryCommitment.size [{}]", listBudgetaryCommitment.size());
        List<Application> listApplications = new ArrayList<>();

        // TODO Change this query logic
        for (BudgetaryCommitment budgetaryCommitment : listBudgetaryCommitment) {
            Municipality municipality = budgetaryCommitment.getMunicipality();
            List<Registration> listRegistrations = municipality.getRegistrations();

            List<Integer> registrationIds = listRegistrations.stream().map(Registration::getId).collect(Collectors.toList());
            List<Application> applications = applicationRepository.findByRegistrationIdIn(registrationIds);
            if (CollectionUtils.isNotEmpty(applications)) {
                listApplications.addAll(applications);
            }
        }

        int listApplicationsSize = listApplications.size();
        this._log.debug("Applications.size [{}]", listApplicationsSize);

        List<ExportImportLegalCommitmentInformation> listLegalCommitmentInformation = new ArrayList<>();
        int i = 0;

        for (Application application : listApplications) {
            Integer applicationId = application.getId();

            this._log.debug("Processing applications. Application.Id [{}]. Progress [{}]/[{}]", applicationId, ++i, listApplicationsSize);

            List<GrantAgreement> listGrantAgreement = application.getGrantAgreements();
            this._log.debug("   listGrantAgreement.size()[{}]", listGrantAgreement.size());

            GrantAgreement grantAgreement = !listGrantAgreement.isEmpty() ? listGrantAgreement.get(0) : null;
            this._log.debug("   First Grant Agreement. grantAgreement.id [{}]", grantAgreement == null ? "NULL" : grantAgreement.getId());

            ExportImportLegalCommitmentInformation legalCommitmentInformation = new ExportImportLegalCommitmentInformation();
            legalCommitmentInformation.setFiles(new ArrayList<>());

            if (grantAgreement != null) {
                String documentLocation = grantAgreement.getDocumentLocation();

                _log.debug("Downloading from URI [{}]", documentLocation);

                URL aURL = null;
                try {
                    aURL = new URL(documentLocation);
                } catch (MalformedURLException e) {
                    _log.error("Error", e);
                }

                if (aURL != null) {
                    String path = aURL.getPath();

                    String fileName = path.substring(path.lastIndexOf("/") + 1);

                    legalCommitmentInformation.setMunicipalityId(application.getRegistration().getMunicipality().getId().longValue());
                    legalCommitmentInformation.setDocumentId(grantAgreement.getId().longValue());
                    legalCommitmentInformation.setDocumentName(fileName);
                    legalCommitmentInformation.setZipFileDocumentName(grantAgreement.getId() + "-" + fileName);
                    legalCommitmentInformation.setDocumentMimeType("application/pdf");

                    String signatureDate = sdf.format(grantAgreement.getDateSignature());
                    legalCommitmentInformation.setDocumentSignatureDate(signatureDate);
                    legalCommitmentInformation.setDocumentType("GRANT_AGREEMENT");
                    legalCommitmentInformation.setAresReference("");

                    byte[] fileContent = this.azureBlobConnector.downloadFileByUri(documentLocation);

                    byte[] fileData = fileContent == null ? new byte[0] : fileContent;
                    this._log.debug("   Downloaded fileContent.length [{}] bytes", fileContent == null ? "NULL" : fileContent.length);
                    ExportFile exportFile = new ExportFile(legalCommitmentInformation.getZipFileDocumentName(), fileData);

                    legalCommitmentInformation.getFiles().add(exportFile);
                }
            }

            listLegalCommitmentInformation.add(legalCommitmentInformation);
        }

        return listLegalCommitmentInformation;
    }
}
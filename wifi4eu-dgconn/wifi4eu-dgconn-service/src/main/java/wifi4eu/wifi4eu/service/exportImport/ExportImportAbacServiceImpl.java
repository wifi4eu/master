package wifi4eu.wifi4eu.service.exportImport;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.io.ByteOrderMark;
import org.apache.commons.io.IOUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.input.BOMInputStream;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
import wifi4eu.wifi4eu.entity.municipality.Municipality;
import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.exportImport.BudgetaryCommitmentRepository;
import wifi4eu.wifi4eu.repository.exportImport.ExportImportRegistrationDataRepository;
import wifi4eu.wifi4eu.repository.exportImport.GlobalCommitmentRepository;
import wifi4eu.wifi4eu.repository.grantAgreement.GrantAgreementRepository;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.util.DateUtils;
import wifi4eu.wifi4eu.util.ExportFileUtils;
import wifi4eu.wifi4eu.util.ZipFileReader;
import wifi4eu.wifi4eu.util.parsing.BudgetaryCommitmentCSVColumn;
import wifi4eu.wifi4eu.util.parsing.LegalCommitmentCSVColumn;
import wifi4eu.wifi4eu.util.parsing.LegalCommitmentDocumentCSVColumn;
import wifi4eu.wifi4eu.util.parsing.LegalEntityCSVColumn;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

@Service
@Transactional
public class ExportImportAbacServiceImpl implements ExportImportAbacService {

    private static final Logger _log = LoggerFactory.getLogger(ExportImportAbacServiceImpl.class);

    private static final String ERROR_WRITING_DOWN_TO_THE_CSV_FILE = "Error writing down to the CSV file. The record will be skipped.";

    private static final String THE_RECORD_WAS_SKIPPED_AS_ITS_STATUS_IS_NOT_VALID = "The record was skipped as its status is not valid";

    @Autowired
    private LEFDocumentGeneratorService lefDocumentGeneratorService;

    @Autowired
    private ExportImportRegistrationDataRepository exportImportRegistrationDataRepository;

    @Autowired
    private MunicipalityRepository municipalityRepository;

    @Autowired
    private ExportFileUtils exportFileUtilities;

    @Autowired
    private DateUtils dateUtilities;

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

    @Value("${budgetaryCommitment.amount:15000}")
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

        try (InputStreamReader inputStreamReader = new InputStreamReader(new BOMInputStream(fileDataStream, ByteOrderMark.UTF_16LE), StandardCharsets.UTF_16LE)) {

            CSVParser csvParser = CSVFormat.TDF.withFirstRecordAsHeader().parse(inputStreamReader);
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
            String abacStatus = csvRecord.get(LegalEntityCSVColumn.MUNICIPALITY_ABAC_STATUS);
            _log.debug("ABAC Reference from LEF reference [{}] and status [{}]", abacReference, abacStatus);

            String municipalityId = csvRecord.get(LegalEntityCSVColumn.MUNICIPALITY_PORTAL_ID);

            try {
                Municipality municipality = municipalityRepository.findOne(Integer.parseInt(municipalityId));
                if (municipality != null) {
                    if (municipality.getMunicipalitiesAbac().isEmpty()) {
                        municipalitiesAbac = new ExportImportRegistrationData();
                        municipalitiesAbac.setMunicipality(municipality);
                    } else {
                        municipalitiesAbac = municipality.getMunicipalitiesAbac().get(0);
                    }

                    municipalitiesAbac.setAbacReference(abacReference);

                    String abacLatinName = csvRecord.get(LegalEntityCSVColumn.MUNICIPALITY_ABAC_LATIN_NAME);
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

        //prepend a BOM for excel to open properly the files
        IOUtils.write(ByteOrderMark.UTF_16LE.getBytes(), entitiesOutputStream);
        IOUtils.write(ByteOrderMark.UTF_16LE.getBytes(), documentsOutputStream);

        try (OutputStreamWriter entitiesOutputStreamWriter = new OutputStreamWriter(entitiesOutputStream, StandardCharsets.UTF_16LE);
             CSVPrinter entitiesPrinter = new CSVPrinter(entitiesOutputStreamWriter, exportFileUtilities.getMunicipalitiesCsvHeaders());
             OutputStreamWriter documentsOutputStreamWriter = new OutputStreamWriter(documentsOutputStream, StandardCharsets.UTF_16LE);
             CSVPrinter documentsPrinter = new CSVPrinter(documentsOutputStreamWriter, exportFileUtilities.getMunicipalitiesDocCsvHeaders())) {


            List<BeneficiaryInformation> beneficiariesInformation = municipalityRepository.findBeneficiaryInformation();

            if (CollectionUtils.isNotEmpty(beneficiariesInformation)) {
                Set<Integer> loadedMunicipalities = new HashSet<>();
                Set<Integer> documentGeneratedMunicipalities = new HashSet<>();

                beneficiariesInformation.forEach(beneficiaryInformation -> {
                    processBeneficiaryInformation(beneficiaryInformation, loadedMunicipalities, entitiesPrinter);
                    processDocumentInformation(beneficiaryInformation, documentGeneratedMunicipalities, documentsPrinter, exportFiles);
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

    private void processBeneficiaryInformation(BeneficiaryInformation beneficiaryInformation, Set<Integer> loadedMunicipalities, CSVPrinter csvPrinter) {

        // needed because BeneficiaryInformation is not an entity but a cartesian product of municipalities x legal files, and we don't want to export a municipality more than once
        if (loadedMunicipalities.contains(beneficiaryInformation.getMun_id())) {
            return;
        } else {
            loadedMunicipalities.add(beneficiaryInformation.getMun_id());
        }

        // Address include the address street and number, and must be between quotes to escape the comma ","

        try {
            csvPrinter.printRecord(
                    defaultEmpty(beneficiaryInformation.getMun_id()),
                    defaultEmpty(beneficiaryInformation.getMun_name()),
                    defaultEmpty(beneficiaryInformation.getMun_abacName()),
                    defaultEmpty(beneficiaryInformation.getFullAddress()),
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

    private void processDocumentInformation(BeneficiaryInformation beneficiaryInformation, Set<Integer> documentGeneratedMunicipalities, CSVPrinter csvPrinter, List<ExportFile> exportFiles) {

        // needed because BeneficiaryInformation is not an entity but a cartesian product of municipalities x legal files, and we don't want to export a municipality more than once
        if (documentGeneratedMunicipalities.contains(beneficiaryInformation.getMun_id())) {
            return;
        } else {
            documentGeneratedMunicipalities.add(beneficiaryInformation.getMun_id());
        }

        try {

            byte[] fileData = null;

            /*
            if (StringUtils.isNotEmpty(beneficiaryInformation.getAzureUri())) {
                String base64FileData = azureBlobConnector.downloadLegalFile(beneficiaryInformation.getAzureUri());
                if (StringUtils.isNotEmpty(base64FileData)) {
                    fileData = Base64Utils.decodeFromString(base64FileData);
                }
            }
            */

            String fileName = "lef_supporting_document-" + beneficiaryInformation.getMun_id() + ".pdf";

            //if (fileData == null) {
                //generate a new pdf file
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                lefDocumentGeneratorService.generateLefPdf(municipalityRepository.getOne(beneficiaryInformation.getMun_id()), os);
                fileData = os.toByteArray();
            //}

            ExportFile exportFile = new ExportFile(fileName, fileData);
            exportFiles.add(exportFile);

            csvPrinter.printRecord(
                    beneficiaryInformation.getMun_id(),
                    beneficiaryInformation.getDoc_portalId(),
                    "lef_supporting_document",
                    fileName,
                    "application/pdf",
                    dateUtilities.convertDate2String(beneficiaryInformation.getDoc_date()),
                    defaultEmpty(beneficiaryInformation.getDoc_type()),
                    defaultEmpty(beneficiaryInformation.getAresReference())
            );

        } catch (IOException e) {
            _log.error(ERROR_WRITING_DOWN_TO_THE_CSV_FILE, e);
        }
    }

    @Override
    public boolean importDgBudgList(InputStream inputStream) throws Exception {
        _log.debug("importDgBudgList");

        try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream)) {

            CSVParser csvParser = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(inputStreamReader);
            csvParser.forEach(this::createAbacData);
        }
        return true;
    }

    // TODO: close to importLegalEntitiesFromAbac, can it be replaced?
    private void createAbacData(CSVRecord csvRecord) {
        Integer municipalityId = Integer.parseInt(csvRecord.get(LegalEntityCSVColumn.MUNICIPALITY_PORTAL_ID));

        Municipality municipality = municipalityRepository.findOne(municipalityId);

        if (municipality != null) {
            String abacName = StringUtils.defaultIfBlank(csvRecord.get(LegalEntityCSVColumn.MUNICIPALITY_ABAC_LATIN_NAME.getValue()), null);
            String abacReference = StringUtils.defaultIfBlank(csvRecord.get(LegalEntityCSVColumn.MUNICIPALITY_ABAC_REFERENCE.getValue()), null);

            if (!municipality.getMunicipalitiesAbac().isEmpty()) {
                // If it exists, normally it should be only one.
                for (ExportImportRegistrationData municipalitiesAbac : municipality.getMunicipalitiesAbac()) {
                    municipalitiesAbac.setAbacStandarName(abacName);
                    municipalitiesAbac.setAbacReference(abacReference);

                    exportImportRegistrationDataRepository.save(municipalitiesAbac);
                }
            } else {
                ExportImportRegistrationData municipalitiesAbac = new ExportImportRegistrationData();
                municipalitiesAbac.setMunicipality(municipality);
                municipalitiesAbac.setAbacStandarName(abacName);
                municipalitiesAbac.setAbacReference(abacReference);

                exportImportRegistrationDataRepository.save(municipalitiesAbac);
            }
        } else {
            _log.warn("Municipality [{}] was not found. Skipped.");
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
            _log.debug("legalCommitmentsData.size [{}]", legalCommitmentsInformations.size());

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

        _log.debug("Exporting to file. FileName [{}]", legalCommitmentExportFileName);

        ExportFile csvLegalCommitmentsFile = new ExportFile(legalCommitmentExportFileName, fileBytes);
        exportFiles.add(csvLegalCommitmentsFile);

        return exportFileUtilities.generateZipFileStream(exportFiles);
    }


    private List<ExportImportLegalCommitmentInformation> searchLegalCommitments() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        List<BudgetaryCommitment> listBudgetaryCommitment = budgetaryCommitmentRepository.findByAbacBcKeyIsNotNullAndAbacLcKeyIsNull();
        _log.debug("listBudgetaryCommitment.size [{}]", listBudgetaryCommitment.size());
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
        _log.debug("Applications.size [{}]", listApplicationsSize);

        List<ExportImportLegalCommitmentInformation> listLegalCommitmentInformation = new ArrayList<>();
        int i = 0;

        for (Application application : listApplications) {
            Integer applicationId = application.getId();

            _log.debug("Processing applications. Application.Id [{}]. Progress [{}]/[{}]", applicationId, ++i, listApplicationsSize);

            List<GrantAgreement> listGrantAgreement = application.getGrantAgreements();
            _log.debug("   listGrantAgreement.size()[{}]", listGrantAgreement.size());

            GrantAgreement grantAgreement = !listGrantAgreement.isEmpty() ? listGrantAgreement.get(0) : null;
            _log.debug("   First Grant Agreement. grantAgreement.id [{}]", grantAgreement == null ? "NULL" : grantAgreement.getId());

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
                    _log.debug("   Downloaded fileContent.length [{}] bytes", fileContent == null ? "NULL" : fileContent.length);
                    ExportFile exportFile = new ExportFile(legalCommitmentInformation.getZipFileDocumentName(), fileData);

                    legalCommitmentInformation.getFiles().add(exportFile);
                }
            }

            listLegalCommitmentInformation.add(legalCommitmentInformation);
        }

        return listLegalCommitmentInformation;
    }

}
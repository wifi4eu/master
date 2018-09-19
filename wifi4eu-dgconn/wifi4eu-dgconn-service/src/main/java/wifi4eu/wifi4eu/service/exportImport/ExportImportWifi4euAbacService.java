package wifi4eu.wifi4eu.service.exportImport;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;
import wifi4eu.wifi4eu.common.dto.model.ExportImportRegistrationDataDTO;
import wifi4eu.wifi4eu.common.dto.model.LauDTO;
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.service.azureblobstorage.AzureBlobConnector;
import wifi4eu.wifi4eu.entity.exportImport.AbacStatus;
import wifi4eu.wifi4eu.entity.exportImport.BeneficiaryInformation;
import wifi4eu.wifi4eu.entity.exportImport.BudgetaryCommitment;
import wifi4eu.wifi4eu.entity.exportImport.ExportFile;
import wifi4eu.wifi4eu.entity.exportImport.ExportImportRegistrationData;
import wifi4eu.wifi4eu.entity.exportImport.GlobalCommitment;
import wifi4eu.wifi4eu.entity.municipality.Municipality;
import wifi4eu.wifi4eu.mapper.exportImport.ExportImportBudgetaryCommitmentMapper;
import wifi4eu.wifi4eu.mapper.exportImport.ExportImportRegistrationDataMapper;
import wifi4eu.wifi4eu.repository.exportImport.BeneficiaryInformationRepository;
import wifi4eu.wifi4eu.repository.exportImport.BudgetaryCommitmentRepository;
import wifi4eu.wifi4eu.repository.exportImport.ExportImportBudgetaryCommitmentRepository;
import wifi4eu.wifi4eu.repository.exportImport.ExportImportRegistrationDataRepository;
import wifi4eu.wifi4eu.repository.exportImport.GlobalCommitmentRepository;
import wifi4eu.wifi4eu.repository.exportImport.ValidatedLefRepository;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.service.exportImport.file.CreateFile;
import wifi4eu.wifi4eu.service.exportImport.file.ReadFile;
import wifi4eu.wifi4eu.service.location.LauService;
import wifi4eu.wifi4eu.service.mayor.MayorService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.util.DateUtils;
import wifi4eu.wifi4eu.util.ExportFileUtils;
import wifi4eu.wifi4eu.util.ZipFileReader;
import wifi4eu.wifi4eu.util.parsing.BudgetaryCommitmentCSVColumn;
import wifi4eu.wifi4eu.util.parsing.LegalEntityCSVColumn;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * @author jlopezri
 */
@Service
public class ExportImportWifi4euAbacService {

    private final Logger _log = LoggerFactory.getLogger(ExportImportWifi4euAbacService.class);

    private static final String FILENAME_EXPORT_DOCUMENTS_DATA = "portal_exportBeneficiaryDocuments.csv";

    private static final String FILENAME_EXPORT_BENEFICIARIES_DATA = "portal_exportBeneficiaryInformation.csv";

    // TODO: make it an external property @Value
    private static final Integer GRANTED_AMOUNT = 15000;

    @Autowired
    private ExportImportRegistrationDataMapper exportImportRegistrationDataMapper;

    @Autowired
    private ExportImportRegistrationDataRepository exportImportRegistrationDataRepository;

    @Autowired
    private ExportImportBudgetaryCommitmentMapper exportImportBudgetaryCommitmentMapper;

    @Autowired
    private ExportImportBudgetaryCommitmentRepository exportImportBudgetaryCommitmentRepository;

    @Autowired
    private BeneficiaryInformationRepository beneficiaryInformationRepository;

    @Autowired
    private ValidatedLefRepository validatedLefRepository;

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

    @Transactional
    public boolean importLegalEntityFBCValidate(InputStream fileDataStream) throws IOException {
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
        String abacReference = csvRecord.get(LegalEntityCSVColumn.MUNICIPALITY_ABAC_REFERENCE);
        if (StringUtils.isNotEmpty(abacReference)) {
            String municipalityId = csvRecord.get(LegalEntityCSVColumn.MUNICIPALITY_PORTAL_ID);
            String abacStatus = csvRecord.get(LegalEntityCSVColumn.MUNICIPALITY_ABAC_STATUS);
            String abacLatinName = csvRecord.get(LegalEntityCSVColumn.MUNICIPALITY_ABAC_LATIN_NAME);

            _log.info("ABAC Reference from LEF reference [{}] and status [{}]", abacReference, abacStatus);

            try {
                ExportImportRegistrationData municpalitiesAbac = new ExportImportRegistrationData();
                Municipality municipality = municipalityRepository.findOne(Integer.parseInt(municipalityId));
                municpalitiesAbac.setMunicipality(municipality);
                municpalitiesAbac.setAbacReference(abacReference);
                municpalitiesAbac.setAbacStandarName(abacLatinName);

                return municpalitiesAbac;
            } catch (NumberFormatException e) {
                _log.error("Error parsing the CSV", e);
            }
        } else {
            _log.info("ABAC Reference is Empty");
        }
        return null;
    }

    public ByteArrayOutputStream exportBeneficiaryInformation() {
        _log.debug("exportBeneficiaryInformation");

        // Preparation for the Beneficiary CSV file
        StringBuilder csvBeneficiaryData = new StringBuilder();
        String csvMunicipalitiesHeaders = exportFileUtilities.getMunicipalitiesCsvHeaders();
        csvBeneficiaryData.append(csvMunicipalitiesHeaders).append("\r\n");

        // Preparation for the Documents CSV file
        StringBuilder csvDocumentData = new StringBuilder();
        String csvDocumentHeaders = exportFileUtilities.getMunicipalitiesDocCsvHeaders();
        csvDocumentData.append(csvDocumentHeaders).append("\r\n");

        List<ExportFile> exportFiles = new ArrayList<>();
        List<BeneficiaryInformation> beneficiariesInformation = beneficiaryInformationRepository.getBeneficiariesInformationSignedAndNotCounterSigned();

        if (CollectionUtils.isNotEmpty(beneficiariesInformation)) {
            beneficiariesInformation.forEach(beneficiaryInformation -> {
                processBeneficiaryInformation(beneficiaryInformation, csvBeneficiaryData);
                processDocumentInformation(beneficiaryInformation, csvDocumentData, exportFiles);
            });
        }

        // Add the Beneficiary CSV file
        ExportFile csvBeneficiariesFile = new ExportFile(FILENAME_EXPORT_BENEFICIARIES_DATA, csvBeneficiaryData.toString().getBytes());
        exportFiles.add(csvBeneficiariesFile);

        // Add the Document CSV file
        ExportFile csvDocumentsFile = new ExportFile(FILENAME_EXPORT_DOCUMENTS_DATA, csvDocumentData.toString().getBytes());
        exportFiles.add(csvDocumentsFile);

        return exportFileUtilities.generateZipFileStream(exportFiles);
    }

    private void processBeneficiaryInformation(BeneficiaryInformation beneficiaryInformation, StringBuilder csvBeneficiaryData) {
        // Language code is stored as ISO 2 and should be ISO 3
        String langCode = beneficiaryInformation.getMun_languageCodeISO();
        if (langCode != null && !langCode.isEmpty()) {
            Locale locale = new Locale(langCode);
            beneficiaryInformation.setMun_languageCodeISO(locale.getISO3Language());
        } else {
            _log.warn("No language was specified for register: " + beneficiaryInformation.getMun_registrationNumber());
        }

        // Address include the address street and number, and must be between quotes to escape the comma ","
        beneficiaryInformation.setMun_address(ExportFileUtils.QUOTE + beneficiaryInformation.getMun_address() + ExportFileUtils.QUOTE);

        csvBeneficiaryData.append(defaultEmpty(beneficiaryInformation.getMun_id())).append(ExportFileUtils.SEPARATOR)
                .append(defaultEmpty(beneficiaryInformation.getMun_name())).append(ExportFileUtils.SEPARATOR)
                .append(defaultEmpty(beneficiaryInformation.getMun_abacName())).append(ExportFileUtils.SEPARATOR)
                .append(defaultEmpty(beneficiaryInformation.getMun_address())).append(ExportFileUtils.SEPARATOR)
                .append(defaultEmpty(beneficiaryInformation.getMun_postalCode())).append(ExportFileUtils.SEPARATOR)
                .append(defaultEmpty(beneficiaryInformation.getMun_city())).append(ExportFileUtils.SEPARATOR)
                .append(defaultEmpty(beneficiaryInformation.getMun_countryCodeISO())).append(ExportFileUtils.SEPARATOR)
                .append(defaultEmpty(beneficiaryInformation.getMun_languageCodeISO())).append(ExportFileUtils.SEPARATOR)
                .append(defaultEmpty(beneficiaryInformation.getMun_registrationNumber())).append(ExportFileUtils.SEPARATOR)
                .append(defaultEmpty(beneficiaryInformation.getMun_abacReference())).append(ExportFileUtils.SEPARATOR)
                .append(defaultEmpty(beneficiaryInformation.getMun_callNumber()));
        csvBeneficiaryData.append("\r\n");
    }

    private String defaultEmpty(Object source) {
        return source != null ? source.toString() : "";
    }

    private String defaultEmpty(String source) {
        return StringUtils.defaultString(source);
    }

    private void processDocumentInformation(BeneficiaryInformation beneficiaryInformation, StringBuilder csvDocumentData, List<ExportFile> exportFiles) {
        if (StringUtils.isNotBlank(beneficiaryInformation.getAzureUri())) {
            // What if a file is too big?
            String base64FileData = azureBlobConnector.downloadLegalFile(beneficiaryInformation.getAzureUri());
            byte[] fileData = StringUtils.isNotEmpty(base64FileData) ? Base64Utils.decodeFromString(base64FileData) : new byte[0];
            ExportFile exportFile = new ExportFile(beneficiaryInformation.getDoc_fileName(), fileData);
            exportFiles.add(exportFile);
        }
        csvDocumentData.append(beneficiaryInformation.getMun_id()).append(ExportFileUtils.SEPARATOR)
                .append(defaultEmpty(beneficiaryInformation.getDoc_portalId())).append(ExportFileUtils.SEPARATOR)
                .append(StringUtils.defaultString(beneficiaryInformation.getDoc_name(), beneficiaryInformation.getDoc_fileName())).append(ExportFileUtils.SEPARATOR)
                .append(defaultEmpty(beneficiaryInformation.getDoc_fileName())).append(ExportFileUtils.SEPARATOR)
                .append(defaultEmpty(beneficiaryInformation.getDoc_mimeType())).append(ExportFileUtils.SEPARATOR)
                .append(dateUtilities.convertDate2String(beneficiaryInformation.getDoc_date())).append(ExportFileUtils.SEPARATOR)
                .append(defaultEmpty(beneficiaryInformation.getDoc_type())).append(ExportFileUtils.SEPARATOR)
                .append(defaultEmpty(beneficiaryInformation.getAresReference()));
        csvDocumentData.append("\r\n");
    }

    public void exportRegistrationData() throws Exception {
        _log.info("exportRegistrationData");
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

    @Transactional
    public void importRegistrationData() throws Exception {
        _log.debug("importRegistrationData");
        ReadFile rF = new ReadFile(exportImportRegistrationDataRepository, exportImportRegistrationDataMapper);
        rF.readExcelFileRegistrationData();
    }

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

                    int neededAmount = GRANTED_AMOUNT;
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


    private Integer setIssueToDgconnBeneficiary(Integer lauId) {
        Integer issueType = 0;
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


    @Transactional
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

        AbacStatus abacStatus = AbacStatus.valueOf(csvRecord.get(BudgetaryCommitmentCSVColumn.ABAC_STATUS));
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
        }

        return null;
    }

    public boolean importLegalCommitment(InputStream inputStream) {

        try (ZipFileReader zipFileReader = new ZipFileReader(inputStream)) {
            ZipFileReader.ZipFileEntry fileEntry = zipFileReader.nextEntry();

            // if (fileEntry.getName())

        } catch (IOException e) {
            _log.error("Error parsing Zip file", e);
        }

    }
}
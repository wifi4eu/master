package wifi4eu.wifi4eu.service.exportImport;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import wifi4eu.wifi4eu.common.dto.model.ExportImportBeneficiaryInformationDTO;
import wifi4eu.wifi4eu.common.dto.model.ExportImportBudgetaryCommitmentDTO;
import wifi4eu.wifi4eu.common.dto.model.ExportImportRegistrationDataDTO;
import wifi4eu.wifi4eu.common.dto.model.LauDTO;
import wifi4eu.wifi4eu.common.dto.model.LegalFileDTO;
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.helper.ParserCSV2JSON;
import wifi4eu.wifi4eu.common.helper.ParserJSON2CSV;
import wifi4eu.wifi4eu.entity.exportImport.ExportFile;
import wifi4eu.wifi4eu.entity.exportImport.ValidatedLEF;
import wifi4eu.wifi4eu.entity.municipality.Municipality;
import wifi4eu.wifi4eu.mapper.exportImport.ExportImportBeneficiaryInformationMapper;
import wifi4eu.wifi4eu.mapper.exportImport.ExportImportBudgetaryCommitmentMapper;
import wifi4eu.wifi4eu.mapper.exportImport.ExportImportRegistrationDataMapper;
import wifi4eu.wifi4eu.repository.exportImport.ExportImportBeneficiaryInformationRepository;
import wifi4eu.wifi4eu.repository.exportImport.ExportImportBudgetaryCommitmentRepository;
import wifi4eu.wifi4eu.repository.exportImport.ExportImportRegistrationDataRepository;
import wifi4eu.wifi4eu.repository.exportImport.ValidatedLefRepository;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.service.exportImport.file.CreateFile;
import wifi4eu.wifi4eu.service.exportImport.file.ReadFile;
import wifi4eu.wifi4eu.service.location.LauService;
import wifi4eu.wifi4eu.service.mayor.MayorService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.registration.legal_files.LegalFilesService;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.util.DateUtilities;
import wifi4eu.wifi4eu.util.ExportFileUtilities;

/**
 * @author jlopezri
 *
 */
@Service
public class ExportImportWifi4euAbacService {
	@Autowired
	ExportImportRegistrationDataMapper exportImportRegistrationDataMapper;

	@Autowired
	ExportImportRegistrationDataRepository exportImportRegistrationDataRepository;

	@Autowired
	ExportImportBeneficiaryInformationMapper exportImportBeneficiaryInformationMapper;

	@Autowired
	ExportImportBeneficiaryInformationRepository exportImportBeneficiaryInformationRepository;

	@Autowired
	ExportImportBudgetaryCommitmentMapper exportImportBudgetaryCommitmentMapper;

	@Autowired
	ExportImportBudgetaryCommitmentRepository exportImportBudgetaryCommitmentRepository;

	@Autowired
	ValidatedLefRepository validatedLefRepository;

	@Autowired
	UserService userService;

	@Autowired
	LauService lauService;

	@Autowired
	MunicipalityService municipalityService;

	@Autowired
	MunicipalityRepository municipalityRepository;

	@Autowired
	MayorService mayorService;

	@Autowired
	RegistrationService registrationService;

	@Autowired
	LegalFilesService legalFileService;

	@Autowired
	DateUtilities dateUtilities;

	@Autowired
	ExportFileUtilities exportFileUtilities;

	@Autowired
	HttpServletRequest httpServletRequest;

	private static final String FILENAME_EXPORT_DOCUMENTS_DATA = "exportBeneficiaryDocuments.csv";

	private static final String FILENAME_EXPORT_BENEFICIARIES_DATA = "exportBeneficiaryInformation.csv";

	private final Logger _log = LoggerFactory.getLogger(ExportImportWifi4euAbacService.class);

	@Transactional
	public boolean importLegalEntityFBCValidate() throws Exception {
		_log.info("importLegalEntityFBCValidate");
		JFileChooser fc = new JFileChooser();
		fc.setAcceptAllFileFilterUsed(false);

		// WIFIFOREU-2498 JSON -> CSV
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files (*.csv)", "csv");

		fc.setFileFilter(filter);
		int response = fc.showOpenDialog(null);
		if (response == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			String content = new String(Files.readAllBytes(file.toPath()));

			// WIFIFOREU-2498 JSON -> CSV - Process the CSV input file into the expected
			// JSON format
			String jsonStringFile = ParserCSV2JSON.parseCSV2JSON(content, "validatedLEF");

			JsonParser parser = new JsonParser();
			JsonObject resultJson = parser.parse(jsonStringFile).getAsJsonArray().getAsJsonObject();
			JsonArray callsJsonArrayLef = resultJson.getAsJsonArray("validatedLEF");
			for (int i = 0; i < callsJsonArrayLef.size(); i++) {
				JsonObject callJson = callsJsonArrayLef.get(i).getAsJsonObject();
				// JsonObject applicationJson =
				// parser.parse(gson.toJson(callsJsonArrayLef.get(i))).getAsJsonObject();
				//// CallDTO call = gson.fromJson(callJson, CallDTO.class);
				//// JsonArray lefVals = resultJson.getAsJsonArray("idLef");
				// JsonArray lefVals = callJson.getAsJsonArray("idLef");
				// for (int u = 0; u < lefVals.size(); u++) {
				// JsonObject jsonStringLef = lefVals.get(u).getAsJsonObject();
				int idLef = callJson.get("idLef").getAsInt();
				// String status = callJson.get("status").getAsString();
				// ValidateLEF validatedLEF=new
				// ValidateLEF(Integer.parseInt(callJson.get("idLef").toString()),
				// callJson.get("status").toString());
				ValidatedLEF validatedLEF = new ValidatedLEF(idLef);
				validatedLefRepository.save(validatedLEF);
				// }
			}
			// JsonArray callsJsonArrayBc = resultJson.getAsJsonArray("validatedBC");
			// for (int i = 0; i < callsJsonArrayBc.size(); i++) {
			// JsonObject callJson = callsJsonArrayBc.get(i).getAsJsonObject();
			//// CallDTO call = gson.fromJson(callJson, CallDTO.class);
			//// JsonArray lefBcs = resultJson.getAsJsonArray("idBc");
			// JsonArray lefBcs = callJson.getAsJsonArray("idBc");
			// for (int u = 0; u < lefBcs.size(); u++) {
			// JsonObject jsonStringLef = lefBcs.get(u).getAsJsonObject();
			// JsonObject lefBc = jsonStringLef.getAsJsonObject("idBc");
			// ValidatedBC validatedBC=new ValidatedBC(Integer.parseInt(lefBc.toString()));
			// validatedBcRepository.save(validatedBC);
			// }
			// }
			return true;
		}
		return false;
	}

	public ByteArrayOutputStream exportBeneficiaryInformation() throws Exception {
		_log.info("exportBeneficiaryInformation");

		List<ExportFile> exportFiles = new ArrayList<ExportFile>();

		List<ExportImportBeneficiaryInformationDTO> applicationsBeneficiaryInformation = exportImportBeneficiaryInformationMapper
				.toDTOList(Lists.newArrayList(exportImportBeneficiaryInformationRepository.findExportImportBI()));

		/**
		 * Commented because the JSON approach doesn't provide the values for all the
		 * required fields.
		 */
		// if (applicationsBeneficiaryInformation != null &&
		// !applicationsBeneficiaryInformation.isEmpty()) {
		// // Generate JSON from the list of beneficiaries (original code)
		// JsonArray result =
		// generateJsonWithMunicipalitiesToExport(applicationsBeneficiaryInformation);
		// String beneficiaryDataJSON = result.toString();
		//
		// // Generate CSV from JSON (parser)
		// String csvData = ParserJSON2CSV.parseJSON2CSV(beneficiaryDataJSON,
		// "beneficiaryInformation",
		// new String[] { "id", "mun_OfficialName", "mun_OfficialAddress", "org_Name",
		// "org_TypeCode",
		// "sup_Name", "sup_BankAccount", "reg_RegistartionNumber" });
		// }

		includeBeneficiariesDataToExport(exportFiles, applicationsBeneficiaryInformation);

		includeDocumentsDataToExport(exportFiles, applicationsBeneficiaryInformation);

		return exportFileUtilities.generateZipFileStream(exportFiles);
	}

	/**
	 * Generates a JSON with the municipalities to export.
	 * 
	 * @param applicationsBeneficiaryInformation
	 * @return
	 */
	private JsonArray generateJsonWithMunicipalitiesToExport(
			List<ExportImportBeneficiaryInformationDTO> applicationsBeneficiaryInformation) {
		Gson gson = new GsonBuilder().create();
		JsonParser parser = new JsonParser();
		JsonObject rootElement = new JsonObject();
		JsonArray result = new JsonArray();

		JsonArray applicationsBeneficiaryInformationJsonArray = new JsonArray();

		for (ExportImportBeneficiaryInformationDTO application : applicationsBeneficiaryInformation) {
			JsonObject applicationJson = parser.parse(gson.toJson(application)).getAsJsonObject();
			applicationsBeneficiaryInformationJsonArray.add(applicationJson);
		}

		rootElement.add("beneficiaryInformation", applicationsBeneficiaryInformationJsonArray);
		result.add(rootElement);

		return result;
	}

	/**
	 * Generates a CSV file which includes the beneficiaries data to export.
	 * 
	 * @param exportFiles
	 * @param applicationsBeneficiaryInformation
	 * @return
	 */
	private void includeBeneficiariesDataToExport(List<ExportFile> exportFiles,
			List<ExportImportBeneficiaryInformationDTO> applicationsBeneficiaryInformation) {
		StringBuilder csvData = new StringBuilder();

		// Generate headers of the CSV file
		csvData.append(exportFileUtilities.generateCSVHeaders(exportFileUtilities.csvMunicipalitiesHeaders))
				.append("\r\n");

		if (applicationsBeneficiaryInformation != null && !applicationsBeneficiaryInformation.isEmpty()) {

			// Gather data of the CSV file
			for (ExportImportBeneficiaryInformationDTO exportImportBeneficiaryInformationDTO : applicationsBeneficiaryInformation) {
				String name = exportImportBeneficiaryInformationDTO.getMun_OfficialName();
				String address = exportImportBeneficiaryInformationDTO.getMun_OfficialAddress();
				Integer munId = exportImportBeneficiaryInformationDTO.getId();
				MunicipalityDTO municipality = municipalityService.getMunicipalityById(munId);
				String postalCode = municipality.getPostalCode();
				Integer lauId = municipality.getLauId();
				LauDTO lau = lauService.getLauById(lauId);
				String city = lau.getName2();
				String countryCode = lau.getCountryCode();
				Integer regId = exportImportBeneficiaryInformationDTO.getReg_RegistartionNumber();
				RegistrationDTO registration = registrationService.getRegistrationById(regId);

				// TODO jlopezri Recover language code - only found a 2 char code language in
				// the users table, but not sure which user we should check. Hardcoded language
				// code to test.
				String langCode = "en";

				csvData.append(munId).append(exportFileUtilities.SEPARATOR).append(name)
						.append(exportFileUtilities.SEPARATOR).append(address).append(exportFileUtilities.SEPARATOR)
						.append(postalCode).append(exportFileUtilities.SEPARATOR).append(city)
						.append(exportFileUtilities.SEPARATOR).append(countryCode).append(exportFileUtilities.SEPARATOR)
						.append(langCode).append(exportFileUtilities.SEPARATOR).append(regId);
				csvData.append("\r\n");
			}
		}

		// Add CSV with the documents list
		ExportFile csvBeneficiariesData = new ExportFile(FILENAME_EXPORT_BENEFICIARIES_DATA,
				csvData.toString().getBytes());
		exportFiles.add(csvBeneficiariesData);
	}

	/**
	 * Generates a CSV file and includes it in the list of files to export, also it
	 * includes the related documents (grant signed) to the municipalities to
	 * export).
	 * 
	 * @param exportFiles
	 * @param applicationsBeneficiaryInformation
	 * @return
	 */
	private void includeDocumentsDataToExport(List<ExportFile> exportFiles,
			List<ExportImportBeneficiaryInformationDTO> applicationsBeneficiaryInformation) {
		StringBuilder csvData = new StringBuilder();

		// Generate headers of the CSV file
		csvData.append(exportFileUtilities.generateCSVHeaders(exportFileUtilities.csvDocumentHeaders)).append("\r\n");

		if (applicationsBeneficiaryInformation != null && !applicationsBeneficiaryInformation.isEmpty()) {

			// Gather data of the CSV file and include the files into the list
			for (ExportImportBeneficiaryInformationDTO exportImportBeneficiaryInformationDTO : applicationsBeneficiaryInformation) {
				Integer munId = exportImportBeneficiaryInformationDTO.getId();
				Integer regId = exportImportBeneficiaryInformationDTO.getReg_RegistartionNumber();
				RegistrationDTO registration = registrationService.getRegistrationById(regId);

				// TODO jlopezri Recover legal file - assumption: we have to recover legal_file1
				LegalFileDTO legalFile = legalFileService.getLegalFileByRegistrationIdFileType(regId,
						Integer.valueOf(1));

				if (legalFile != null) {
					// Generate CSV entry
					String name = "file" + legalFile.getId();
					String mimetype = legalFile.getFileMime();
					String date = dateUtilities.convertDate2String(legalFile.getUploadTime());
					String type = "GRANT AGREEMENT SIGNATURE";
					csvData.append(munId).append(exportFileUtilities.SEPARATOR).append(legalFile.getId())
							.append(exportFileUtilities.SEPARATOR).append(name).append(exportFileUtilities.SEPARATOR)
							.append(mimetype).append(exportFileUtilities.SEPARATOR).append(date)
							.append(exportFileUtilities.SEPARATOR).append(type);
					csvData.append("\r\n");

					// Add file to export
					ExportFile exportFile = new ExportFile(name, legalFile.getFileData().getBytes());
					exportFiles.add(exportFile);
				}
			}
		}

		// Add CSV with the documents list
		ExportFile csvDocumentsData = new ExportFile(FILENAME_EXPORT_DOCUMENTS_DATA, csvData.toString().getBytes());
		exportFiles.add(csvDocumentsData);
	}

	public void exportRegistrationData() throws Exception {
		_log.info("exportRegistrationData");
		List<ExportImportRegistrationDataDTO> exportImportRegistrationDataList = exportImportRegistrationDataMapper
				.toDTOList(Lists.newArrayList(exportImportRegistrationDataRepository.findExportImportRD()));
		String[] header = { "EU Rank", "Country Rank", "Country Name", "Municipality name", "Issue",
				"Number of registrations" };
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
		_log.info("importRegistrationData");
		ReadFile rF = new ReadFile(exportImportRegistrationDataRepository, exportImportRegistrationDataMapper);
		rF.readExcelFileRegistrationData();
	}

	public ResponseDTO exportBudgetaryCommitment() throws Exception {
		_log.info("exportBudgetaryCommitment");
		ResponseDTO result = new ResponseDTO();
		Gson gson = new GsonBuilder().create();
		JsonParser parser = new JsonParser();
		JsonObject resultJson = new JsonObject();
		List<ExportImportBudgetaryCommitmentDTO> applicationsBudgetaryCommitment = exportImportBudgetaryCommitmentMapper
				.toDTOList(Lists.newArrayList(exportImportBudgetaryCommitmentRepository.findExportImportBC()));
		JsonArray applicationsBudgetaryCommitmentJsonArray = new JsonArray();
		if (applicationsBudgetaryCommitment != null && !applicationsBudgetaryCommitment.isEmpty()) {
			for (ExportImportBudgetaryCommitmentDTO application : applicationsBudgetaryCommitment) {
				JsonObject applicationJson = parser.parse(gson.toJson(application)).getAsJsonObject();
				applicationsBudgetaryCommitmentJsonArray.add(applicationJson);
			}
		}
		resultJson.addProperty("createTime", new Date().getTime());
		resultJson.add("budgetaryCommitment", applicationsBudgetaryCommitmentJsonArray);
		result.setSuccess(true);
		result.setData("[" + resultJson.toString() + "]");

		// WIFIFOREU-2498 JSON -> CSV - Process the JSON output file into the expected
		// CSV
		String csvStringFile = ParserJSON2CSV.parseJSON2CSV((String) result.getData(), "budgetaryCommitment",
				new String[] { "id", "mun_OfficialName", "mun_OfficialAddress", "org_Name", "org_TypeCode", "sup_Name",
						"sup_BankAccount", "reg_RegistartionNumber", "app_VoucherAwarded", "app_BcStatus",
						"app_BcExport", "app_BcImport", "app_LefStatus", "app_LefExport", "app_LefImport" });
		result.setData(csvStringFile);

		result.setError(null);
		return result;
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

}
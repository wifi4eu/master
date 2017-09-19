package wifi4eu.wifi4eu.service.abac;

import com.google.common.collect.Lists;
import com.google.gson.*;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.dto.security.UserDTO;
import wifi4eu.wifi4eu.mapper.beneficiary.LegalEntityMapper;
import wifi4eu.wifi4eu.mapper.location.LauMapper;
import wifi4eu.wifi4eu.mapper.security.UserMapper;
import wifi4eu.wifi4eu.mapper.supplier.BenPubSupMapper;
import wifi4eu.wifi4eu.mapper.supplier.SupplierMapper;
import wifi4eu.wifi4eu.repository.beneficiary.LegalEntityRepository;
import wifi4eu.wifi4eu.repository.beneficiary.MayorRepository;
import wifi4eu.wifi4eu.repository.location.LocationLauRepository;
import wifi4eu.wifi4eu.repository.security.SecurityUserRepository;
import wifi4eu.wifi4eu.repository.supplier.BenPubSupRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierRepository;
import wifi4eu.wifi4eu.service.beneficiary.BeneficiaryService;
import wifi4eu.wifi4eu.service.call.CallService;
import wifi4eu.wifi4eu.mapper.beneficiary.MayorMapper;

/**
 * Created by jmagrinc on 08/05/2017.
 */
@Service
public class AbacService {
    private final static Logger _log = Logger.getLogger(AbacService.class);
    private final static String _version = "0.0.2";

    @Autowired
    private MayorRepository mayorRepository;

    @Autowired
    private MayorMapper mayorMapper;

    @Autowired
    private LegalEntityMapper legalEntityMapper;

    @Autowired
    private LegalEntityRepository legalEntityRepository;

    @Autowired
    private BeneficiaryService beneficiaryService;

    @Autowired
    private CallService callService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SecurityUserRepository securityUserRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierMapper supplierMapper;

    @Autowired
    private BenPubSupRepository benPubSupRepository;

    @Autowired
    private BenPubSupMapper benPubSupMapper;

    @Autowired
    private LocationLauRepository locationLauRepository;

    @Autowired
    private LauMapper lauMapper;

    public ResponseDTO exportAbacInformation() {
        ResponseDTO result = new ResponseDTO();
        Gson gson = new GsonBuilder().create();
        JsonParser parser = new JsonParser();
        JsonObject resultJson = new JsonObject();
        List<CallDTO> calls = callService.getAllCalls();
        JsonArray callsJsonArray = new JsonArray();
        if (calls != null && !calls.isEmpty()) {
            for (CallDTO call : calls) {
                JsonObject callJson =  parser.parse(gson.toJson(call)).getAsJsonObject();
                JsonArray applicationsJsonArray = new JsonArray();
                List<BenPubSupDTO> applications = beneficiaryService.findByPublicationId(call.getCallId());
                if (applications != null && !applications.isEmpty()) {
                    for (BenPubSupDTO application : applications) {
                        JsonObject applicationJson = new JsonObject();
                        applicationJson.addProperty("benPubSubId", application.getBenPubSubId());
                        JsonObject legalEntityJson = null;
                        LegalEntityDTO legalEntity = legalEntityMapper.toDTO(legalEntityRepository.findOne(application.getBeneficiaryId()));
                        if (legalEntity != null) {
                            legalEntityJson =  parser.parse(gson.toJson(legalEntity)).getAsJsonObject();
                        }
                        JsonObject mayorJson = null;
                        MayorDTO mayor = mayorMapper.toDTO(mayorRepository.findByLegalEntityId(application.getBeneficiaryId()));
                        if (mayor != null) {
                            mayorJson =  parser.parse(gson.toJson(mayor)).getAsJsonObject();
                        }
                        JsonObject userJson = null;
                        UserDTO user = userMapper.toDTO(securityUserRepository.findByUserTypeId(mayor.getMayorId()));
                        if (user != null) {
                            userJson =  parser.parse(gson.toJson(user)).getAsJsonObject();
                            userJson.remove("password");
                        }
                        JsonObject supplierJson = new JsonObject();
                        if (application.getSupplierId() != null) {
                            SupplierDTO supplier = supplierMapper.toDTO(supplierRepository.findOne(application.getSupplierId()));
                            supplierJson =  parser.parse(gson.toJson(supplier)).getAsJsonObject();
                            supplierJson.remove("logo");
                        }
                        if (legalEntityJson != null && mayorJson != null && userJson != null) {
                            JsonObject beneficiaryJson = new JsonObject();
                            beneficiaryJson.add("legalEntity", legalEntityJson);
                            beneficiaryJson.add("mayor", mayorJson);
                            beneficiaryJson.add("user", userJson);
                            applicationJson.add("beneficiary", beneficiaryJson);
                            applicationJson.addProperty("awarded", application.isAwarded());
                            applicationJson.add("supplier", supplierJson);
                            applicationJson.addProperty("date", application.getDate().getTime());
                            applicationsJsonArray.add(applicationJson);
                            long exportDate = new Date().getTime();
                            application.setLefExport(exportDate);
                            application.setBcExport(exportDate);
                            application.setLcExport(exportDate);
                            benPubSupRepository.save(benPubSupMapper.toEntity(application));
                        }
                    }
                }
                callJson.add("applications", applicationsJsonArray);
                callsJsonArray.add(callJson);
            }
        }
        resultJson.addProperty("version", _version);
        resultJson.addProperty("createTime", new Date().getTime());
        resultJson.add("calls", callsJsonArray);
        result.setSuccess(true);
        result.setData(resultJson.toString());
        result.setError(null);
        return result;
    }

    /**
     * Generates a JSON Object from the upload file and starts parsing it
     * @param jsonString
     * @return
     */
    public ResponseDTO processAbacInformation(String jsonString) {
        _log.info("[I] processAbacInformation");

        ResponseDTO result = new ResponseDTO();
        result.setSuccess(true);

        if (jsonString != null && jsonString.length() > 0 && jsonString.startsWith("{") && jsonString.endsWith("}")) {
            Gson gson = new Gson();
            JsonElement element = gson.fromJson(jsonString, JsonElement.class);
            JsonObject jsonObj = element.getAsJsonObject();

            if (!jsonObj.isJsonNull() && jsonObj.isJsonObject()) {
                //-- JSON version control
                if (jsonObj.has("version") && jsonObj.get("version").getAsString().equals(_version)) {
                    result = parseAbacImportJSON(jsonObj);
                } else {
                    return getErrorResponseDTO(500, "The JSON file is not at its last version. Please, generate a new version of the JSON file.");
                }
            }
        } else {
            return getErrorResponseDTO(500, "The JSON is malformed. Please, generate a new version of the JSON file.");
        }

        _log.info("[F] processAbacInformation");
        return result;
    }

    /**
     * Given a publicationId generates a JSON with the current applications status
     * @param publicationId
     * @return
     */
    public ResponseDTO getPublicationAppliersInfo(long publicationId) {
        ResponseDTO result = new ResponseDTO();
        List<BenPubSupDTO> publicationAppliers = benPubSupMapper.toDTOList(benPubSupRepository.findByPublicationId(publicationId));
        JsonArray resultJson = new JsonArray();
        if (publicationAppliers != null && !publicationAppliers.isEmpty()) {
            for (BenPubSupDTO applier : publicationAppliers) {
                JsonObject applierJson = new JsonObject();
                long legalEntityId = 0;
                String municipalityName = null;
                long mayorId = 0;
                String mayorName = null;
                long supplierId = 0;
                String supplierName = null;
                if (applier.getBeneficiaryId() != null) {
                    LegalEntityDTO legalEntityDTO = legalEntityMapper.toDTO(legalEntityRepository.findOne(applier.getBeneficiaryId()));
                    if (legalEntityDTO != null) {
                        legalEntityId = legalEntityDTO.getLegalEntityId();
                        municipalityName = lauMapper.toDTO(locationLauRepository.findByLau2AndCountryCode(legalEntityDTO.getMunicipalityCode(), legalEntityDTO.getCountryCode())).getName1();
                        MayorDTO mayorDTO = mayorMapper.toDTO(mayorRepository.findByLegalEntityId(legalEntityDTO.getLegalEntityId()));
                        if (mayorDTO != null) {
                            mayorId = mayorDTO.getMayorId();
                            mayorName = mayorDTO.getName();
                        }
                    }
                }
                if (applier.getSupplierId() != null) {
                    SupplierDTO supplierDTO = supplierMapper.toDTO(supplierRepository.findOne(applier.getSupplierId()));
                    if (supplierDTO != null) {
                        supplierId = supplierDTO.getSupplierId();
                        supplierName = supplierDTO.getName();
                    }
                }
                applierJson.addProperty("legalEntityId", legalEntityId);
                applierJson.addProperty("municipalityName", municipalityName);
                applierJson.addProperty("mayorId", mayorId);
                applierJson.addProperty("mayorName", mayorName);
                applierJson.addProperty("voucherAwarded", applier.isAwarded());
                applierJson.addProperty("supplierId", supplierId);
                applierJson.addProperty("supplierName", supplierName);
                applierJson.addProperty("lefExportDate", applier.getLefExport());
                applierJson.addProperty("lefImportDate", applier.getLefImport());
                applierJson.addProperty("lefStatus", applier.getLefStatus());
                applierJson.addProperty("bcExportDate", applier.getBcExport());
                applierJson.addProperty("bcImportDate", applier.getBcImport());
                applierJson.addProperty("bcStatus", applier.getBcStatus());
                applierJson.addProperty("lcExportDate", applier.getLcExport());
                applierJson.addProperty("lcImportDate", applier.getLcImport());
                applierJson.addProperty("lcStatus", applier.getLcStatus());
                applierJson.addProperty("lastAbacMessage", applier.getLastAbacMessage());
                resultJson.add(applierJson);
            }
            result.setSuccess(true);
            result.setData(resultJson.toString());
            result.setError(null);
        } else {
            result.setSuccess(false);
            result.setData(null);
            result.setError(new ErrorDTO(200, "NoAppliersForPublication"));
        }
        return result;
    }

    /**
     * Iterates over the Json to get the data
     * @param importedJSON
     * @return
     */
    private ResponseDTO parseAbacImportJSON(JsonObject importedJSON) {
        _log.info("[I] parseAbacImportJSON");

        ResponseDTO result = new ResponseDTO();
        result.setSuccess(true);

        if (!importedJSON.isJsonNull() && importedJSON.has("publications")) {
            if (importedJSON.get("publications").isJsonArray()) {
                JsonArray publications = importedJSON.getAsJsonArray("publications");
                for (int i = 0; i < publications.size(); i++) {
                    if (!parsePublication(publications.get(i))) {
                        return getErrorResponseDTO(500, "Malformed input JSON");
                    }
                }
            } else if (importedJSON.get("publications").isJsonObject()) {
                if (!parsePublication(importedJSON.get("publications"))) {
                    return getErrorResponseDTO(500, "Malformed input JSON");
                }
            }
        } else {
            return getErrorResponseDTO(500, "Malformed input JSON");
        }

        _log.info("[F] parseAbacImportJSON");
        return result;
    }

    private boolean parsePublication(JsonElement publicationElement) {
        if (!publicationElement.isJsonNull() && publicationElement.isJsonObject()) {
            JsonObject publication = publicationElement.getAsJsonObject();
            if (publication.get("appliers").isJsonArray()) {
                JsonArray publicationAppliers = publication.getAsJsonArray("appliers");
                for (int i = 0; i < publicationAppliers.size(); i++) {
                    if (!parsePublicationApplier(publicationAppliers.get(i))) {
                        return false;
                    }
                }
            } else if (publication.get("appliers").isJsonObject()) {
                if (!parsePublicationApplier(publication.get("appliers"))) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    private boolean parsePublicationApplier(JsonElement beneficiaryElement) {
        if (!beneficiaryElement.isJsonNull() && beneficiaryElement.isJsonObject()) {
            JsonObject beneficiary = beneficiaryElement.getAsJsonObject();
            if (!beneficiary.isJsonNull() && beneficiary.isJsonObject() && beneficiary.has("benPubSubId") && beneficiary.has("status")) {
                long benPubSubId = beneficiary.get("benPubSubId").getAsLong();
                JsonObject status = beneficiary.getAsJsonObject("status");
                updateBenPubSubInformation(benPubSubId, status);
            } else {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * Parse the information from the status object and persists it
     * @param benPubSubId
     * @param status
     * @return
     */
    private ResponseDTO updateBenPubSubInformation(long benPubSubId, JsonObject status) {
        _log.info("[I] parseAbacImportJSON");

        ResponseDTO success = new ResponseDTO();
        success.setSuccess(true);

        if (benPubSubId > 0 && !status.isJsonNull() && status.isJsonObject() && status.has("action")
                && status.has("result") && status.has("message")) {
            BenPubSupDTO benPubSub = benPubSupMapper.toDTO(benPubSupRepository.findOne(benPubSubId));

            if (benPubSub != null) {
                String action = status.get("action").getAsString();
                boolean actionResult = status.get("result").getAsBoolean();
                String message = status.get("message").getAsString();

                if (action.equalsIgnoreCase("budget_commitment")) {
                    //benPubSub.setBudgetCommited(actionResult);
                } else if (action.equalsIgnoreCase("budged_link_commitment")) {
                    //-- Check if the budget was commited before set to linked
                    /*
                    if (benPubSub.isBudgetCommited()) {
                        benPubSub.setBudgetLinked(actionResult);
                    } else {
                        return getErrorResponseDTO(500, "Can not set Awarded before budget_commitment && budged_link_commitment for " + benPubSubId);
                    }
                    */
                } else if (action.equalsIgnoreCase("beneficiary_approval")) {
                    //-- Check if the budget was commited && linked before set to awarded
                    /*
                    if (benPubSub.isBudgetCommited() && benPubSub.isBudgetLinked()) {
                        benPubSub.setAwarded(actionResult); //-- Awarded is the last step, when the installation is successful
                    } else {
                        return getErrorResponseDTO(500, "Can not set Awarded before budget_commitment && budged_link_commitment for " + benPubSubId);
                    }
                    */
                } else {
                    return getErrorResponseDTO(500, "Action: " + action + "not found for " + benPubSubId);
                }

                benPubSub.setLastAbacMessage(message);
                benPubSub = updateAbacStatus(benPubSub);

                //-- Save new state
                benPubSub = benPubSupMapper.toDTO(benPubSupRepository.save(benPubSupMapper.toEntity(benPubSub)));
            } else {
                return getErrorResponseDTO(500, "Does not exist BenPubSub with Id " + benPubSubId);
            }
        } else {
            return getErrorResponseDTO(500, "Could not update BenPubSub for " + benPubSubId);
        }


        _log.info("[F] parseAbacImportJSON");
        return success;
    }

    /**
     * Generates an ErrorDTO Object within a ResponseDTO
     * @param errorCode
     * @param errorMsg
     * @return
     */
    private ResponseDTO getErrorResponseDTO(long errorCode, String errorMsg) {
        ResponseDTO result = new ResponseDTO();
        ErrorDTO error = new ErrorDTO();

        error.setErrorCode(errorCode);
        error.setErrorMessage(errorMsg);
        result.setSuccess(false);
        result.setError(error);

        return result;
    }

    /**
     * Fills a JSONObject with information about the publication applier
     * @param applier
     * @return
     */
    private JsonObject fillApplierInformation(BenPubSupDTO applier) {
        _log.info("[I] fillApplierInformation");

        if (applier == null || applier.getBeneficiaryId() <= 0) {
            _log.error("[fillApplierInformation] Invalid parameters");
            return null;
        }

        JsonObject applierInformation = new JsonObject();

        JsonObject  mayorJSON = new JsonObject();
        JsonObject  supplierInformation = new JsonObject();
        JsonObject  statusJSON = new JsonObject();

        LegalEntityDTO legalEntityDto = legalEntityMapper.toDTO(legalEntityRepository.findOne(applier.getBeneficiaryId()));
        if (legalEntityDto != null && legalEntityDto.getLegalEntityId() != 0) {
            JsonObject legalEntityJSON = new JsonObject();
            legalEntityJSON.addProperty("legalEntityId", legalEntityDto.getLegalEntityId());
            legalEntityJSON.addProperty("countryCode", legalEntityDto.getCountryCode());
            legalEntityJSON.addProperty("municipalityCode", legalEntityDto.getMunicipalityCode());
            legalEntityJSON.addProperty("address", legalEntityDto.getAddress());
            legalEntityJSON.addProperty("addressNum", legalEntityDto.getAddressNum());
            legalEntityJSON.addProperty("postalCode", legalEntityDto.getPostalCode());

            MayorDTO mayorDto = mayorMapper.toDTO(mayorRepository.findByLegalEntityId(legalEntityDto.getLegalEntityId()));
            if (mayorDto != null) {
                UserDTO user = userMapper.toDTO(securityUserRepository.findByUserTypeId(mayorDto.getMayorId()));

                JsonObject userJSON = new JsonObject();
                if (user != null && user.getUserId() > 0) {
                    userJSON.addProperty("userId", user.getUserId());
                    userJSON.addProperty("email", user.getEmail());
                    userJSON.addProperty("createDate", user.getCreateDate().getTime());
                    userJSON.addProperty("userType", user.getUserType());
                    userJSON.addProperty("userTypeId", user.getUserTypeId());
                }

                mayorJSON.addProperty("mayorId", mayorDto.getMayorId());
                mayorJSON.addProperty("treatment", mayorDto.getTreatment());
                mayorJSON.addProperty("name", mayorDto.getName());
                mayorJSON.addProperty("surname", mayorDto.getSurname());
                mayorJSON.addProperty("email", mayorDto.getEmail());
                mayorJSON.add("legalEntity", legalEntityJSON);
                mayorJSON.add("user", userJSON);
            }
        }

        if (applier.getSupplierId() != null) {
            SupplierDTO supplier = supplierMapper.toDTO(supplierRepository.findOne(applier.getSupplierId()));

            if (supplier != null) {
                supplierInformation.addProperty("supplierId", supplier.getSupplierId());
                supplierInformation.addProperty("name", supplier.getName());
                supplierInformation.addProperty("address", supplier.getAddress());
                supplierInformation.addProperty("vat", supplier.getVat());
                supplierInformation.addProperty("bic", supplier.getBic());
                supplierInformation.addProperty("accountNumber", supplier.getAccountNumber());
                supplierInformation.addProperty("contactName", supplier.getContactName());
                supplierInformation.addProperty("contactSurname", supplier.getContactSurname());
                supplierInformation.addProperty("contactPhonePrefix", supplier.getContactPhonePrefix());
                supplierInformation.addProperty("contactPhoneNumber", supplier.getContactPhoneNumber());
                supplierInformation.addProperty("contactEmail", supplier.getContactEmail());
                supplierInformation.addProperty("nutsIds", supplier.getNutsIds());
            }
        }

        //statusJSON.addProperty("budgetCommited", applier.isBudgetCommited());
        //statusJSON.addProperty("budgedLinked", applier.isBudgetLinked());
        statusJSON.addProperty("approved", applier.isAwarded());

        applierInformation.addProperty("benPubSubId", applier.getBenPubSubId());
        applierInformation.add("beneficiary", mayorJSON);
        applierInformation.add("supplier", supplierInformation);
        applierInformation.add("status", statusJSON);

        _log.info("[F] fillApplierInformation");
        return applierInformation;
    }

    private BenPubSupDTO updateAbacStatus(BenPubSupDTO benPubSupDTO) {
        LegalEntityDTO legalEntityDto = legalEntityMapper.toDTO(legalEntityRepository.findOne(benPubSupDTO.getBeneficiaryId()));
        if (benPubSupDTO.getSupplierId() == null) {
            //benPubSupDTO.setAbacStatus(false);
            return benPubSupMapper.toDTO(benPubSupRepository.save(benPubSupMapper.toEntity(benPubSupDTO)));
        }
        SupplierDTO supplierDTO = supplierMapper.toDTO(supplierRepository.findOne(benPubSupDTO.getSupplierId()));
        /*
        if (legalEntityDto.isAbacStatus() && supplierDTO.isAbacStatus()) {
            benPubSupDTO.setAbacStatus(true);
        } else {
            benPubSupDTO.setAbacStatus(false);
        }
        */
        return benPubSupMapper.toDTO(benPubSupRepository.save(benPubSupMapper.toEntity(benPubSupDTO)));
    }

}
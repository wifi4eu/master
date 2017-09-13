package wifi4eu.wifi4eu.service.abac;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.dto.security.UserDTO;
import wifi4eu.wifi4eu.mapper.beneficiary.LegalEntityMapper;
import wifi4eu.wifi4eu.mapper.security.UserMapper;
import wifi4eu.wifi4eu.mapper.supplier.BenPubSupMapper;
import wifi4eu.wifi4eu.mapper.supplier.SupplierMapper;
import wifi4eu.wifi4eu.repository.beneficiary.LegalEntityRepository;
import wifi4eu.wifi4eu.repository.beneficiary.MayorRepository;
import wifi4eu.wifi4eu.repository.security.SecurityUserRepository;
import wifi4eu.wifi4eu.repository.supplier.BenPubSupRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierRepository;
import wifi4eu.wifi4eu.service.beneficiary.BeneficiaryService;
import wifi4eu.wifi4eu.service.call.CallService;
import wifi4eu.wifi4eu.mapper.beneficiary.MayorMapper;
import com.google.gson.JsonObject;

import java.util.Date;

import java.util.List;

/**
 * Created by jmagrinc on 08/05/2017.
 */
@Service
public class AbacService {
    private final static Logger _log = Logger.getLogger(AbacService.class);
    private final static String _version = "0.0.1";

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

    /**
     * Returns a JSON with the current status of the publications and appliers
     * @return
     */
    public ResponseDTO exportAbacInformation() {
        _log.info("Creating exportAbacInformation...");

        ResponseDTO result = new ResponseDTO();
        result.setSuccess(true);

        JsonObject resultJSON = new JsonObject();
        JsonArray publicationsArrayJSON = new JsonArray();

        List<CallDTO> publicatons = callService.getAllCalls();

        if (publicatons != null && !publicatons.isEmpty()) {
            for (CallDTO publication : publicatons) {
                JsonObject publicationJSON = new JsonObject();
                JsonArray publicationAppliersJSON = new JsonArray();

                List<BenPubSupDTO> publicationAppliers = beneficiaryService.findByPublicationId(publication.getCallId());
                if (publicationAppliers != null && !publicationAppliers.isEmpty()) {
                    for (BenPubSupDTO applier : publicationAppliers) {
                        JsonObject applierJSON = fillApplierInformation(applier);

                        if(applierJSON != null) {
                            publicationAppliersJSON.add(applierJSON);
                        }
                    }
                }

                publicationJSON.addProperty("publicationId", publication.getCallId());
                publicationJSON.add("appliers", publicationAppliersJSON);

                publicationsArrayJSON.add(publicationJSON);
            }
        }

        resultJSON.addProperty("version", _version);
        resultJSON.addProperty("createTime", new Date().getTime());
        resultJSON.add("publications", publicationsArrayJSON);

        result.setData(resultJSON.toString());

        _log.info("Finished exportAbacInformation.");
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
        _log.info("[I] getPublicationAppliersInfo");

        ResponseDTO result = new ResponseDTO();
        result.setSuccess(true);
        JsonArray resultJSON = new JsonArray();

        if (publicationId > 0 ) {
            List<BenPubSupDTO> publicationAppliers = benPubSupMapper.toDTOList(benPubSupRepository.findByPublicationId(publicationId));

            if (publicationAppliers != null && !publicationAppliers.isEmpty()) {

                for (BenPubSupDTO applier : publicationAppliers) {
                    applier = updateAbacStatus(applier);
                    JsonObject applierJSON = new JsonObject();
                    String beneficiaryName = "";
                    String supplierName = "";

                    if (applier.getBeneficiaryId() > 0) {
                        LegalEntityDTO legalEntityDto = legalEntityMapper.toDTO(legalEntityRepository.findOne(applier.getBeneficiaryId()));

                        if (legalEntityDto != null) {
                            MayorDTO mayorDto = mayorMapper.toDTO(mayorRepository.findByLegalEntityId(legalEntityDto.getLegalEntityId()));

                            if (mayorDto != null) {
                                if (mayorDto.getName().length() > 0) {
                                    beneficiaryName = mayorDto.getName();
                                }

                                if (mayorDto.getSurname().length() > 0) {
                                    beneficiaryName += " " + mayorDto.getSurname();
                                }

                                beneficiaryName = beneficiaryName.trim();
                            }
                        }
                    }

                    if (applier.getSupplierId() != null) {
                        SupplierDTO supplier = supplierMapper.toDTO(supplierRepository.findOne(applier.getSupplierId()));

                        if (supplier != null) {
                            supplierName = supplier.getName();
                        }
                    }

                    //-- Fill the object
                    applierJSON.addProperty("beneficiaryId", applier.getBeneficiaryId());
                    applierJSON.addProperty("beneficiaryName", beneficiaryName);
                    applierJSON.addProperty("supplierId", applier.getSupplierId());
                    applierJSON.addProperty("supplierName", supplierName);
                    applierJSON.addProperty("isBudgedCommited", applier.isBudgetCommited());
                    applierJSON.addProperty("isBudgedLinked", applier.isBudgetLinked());
                    applierJSON.addProperty("isAwarded", applier.isAwarded());
                    applierJSON.addProperty("lastAbacMessage", applier.getLastAbacMessage());
                    applierJSON.addProperty("abacStatus", applier.isAbacStatus());

                    resultJSON.add(applierJSON);
                }

            } else {
                return getErrorResponseDTO(500, "The JSON file is not at its last version. Please, generate a new version of the JSON file.");
            }

        } else {
            return getErrorResponseDTO(500, "The JSON file is not at its last version. Please, generate a new version of the JSON file.");
        }

        result.setData(resultJSON.toString());

        _log.info("[F] getPublicationAppliersInfo");
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
                    benPubSub.setBudgetCommited(actionResult);
                } else if (action.equalsIgnoreCase("budged_link_commitment")) {
                    //-- Check if the budget was commited before set to linked
                    if (benPubSub.isBudgetCommited()) {
                        benPubSub.setBudgetLinked(actionResult);
                    } else {
                        return getErrorResponseDTO(500, "Can not set Awarded before budget_commitment && budged_link_commitment for " + benPubSubId);
                    }
                } else if (action.equalsIgnoreCase("beneficiary_approval")) {
                    //-- Check if the budget was commited && linked before set to awarded
                    if (benPubSub.isBudgetCommited() && benPubSub.isBudgetLinked()) {
                        benPubSub.setAwarded(actionResult); //-- Awarded is the last step, when the installation is successful
                    } else {
                        return getErrorResponseDTO(500, "Can not set Awarded before budget_commitment && budged_link_commitment for " + benPubSubId);
                    }
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

        statusJSON.addProperty("budgetCommited", applier.isBudgetCommited());
        statusJSON.addProperty("budgetLinked", applier.isBudgetLinked());
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
            benPubSupDTO.setAbacStatus(false);
            return benPubSupMapper.toDTO(benPubSupRepository.save(benPubSupMapper.toEntity(benPubSupDTO)));
        }
        SupplierDTO supplierDTO = supplierMapper.toDTO(supplierRepository.findOne(benPubSupDTO.getSupplierId()));
        if (legalEntityDto.isAbacStatus() && supplierDTO.isAbacStatus()) {
            benPubSupDTO.setAbacStatus(true);
        } else {
            benPubSupDTO.setAbacStatus(false);
        }
        return benPubSupMapper.toDTO(benPubSupRepository.save(benPubSupMapper.toEntity(benPubSupDTO)));
    }

}
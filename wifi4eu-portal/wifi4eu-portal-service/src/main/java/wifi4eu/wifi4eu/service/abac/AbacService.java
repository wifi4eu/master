package wifi4eu.wifi4eu.service.abac;

import com.google.common.collect.Lists;
import com.google.gson.*;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.dto.security.UserDTO;
import wifi4eu.wifi4eu.mapper.beneficiary.LegalEntityMapper;
import wifi4eu.wifi4eu.mapper.beneficiary.MayorMapper;
import wifi4eu.wifi4eu.mapper.call.CallMapper;
import wifi4eu.wifi4eu.mapper.location.LauMapper;
import wifi4eu.wifi4eu.mapper.security.UserMapper;
import wifi4eu.wifi4eu.mapper.supplier.BenPubSupMapper;
import wifi4eu.wifi4eu.mapper.supplier.SupplierMapper;
import wifi4eu.wifi4eu.repository.beneficiary.LegalEntityRepository;
import wifi4eu.wifi4eu.repository.beneficiary.MayorRepository;
import wifi4eu.wifi4eu.repository.call.CallRepository;
import wifi4eu.wifi4eu.repository.location.LocationLauRepository;
import wifi4eu.wifi4eu.repository.security.SecurityUserRepository;
import wifi4eu.wifi4eu.repository.supplier.BenPubSupRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierRepository;

@Service
public class AbacService {
    private final static String _version = "0.0.2";

    @Autowired
    private BenPubSupMapper benPubSupMapper;

    @Autowired
    private BenPubSupRepository benPubSupRepository;

    @Autowired
    private CallMapper callMapper;

    @Autowired
    private CallRepository callRepository;

    @Autowired
    private LauMapper lauMapper;

    @Autowired
    private LocationLauRepository locationLauRepository;

    @Autowired
    private LegalEntityMapper legalEntityMapper;

    @Autowired
    private LegalEntityRepository legalEntityRepository;

    @Autowired
    private MayorMapper mayorMapper;

    @Autowired
    private MayorRepository mayorRepository;

    @Autowired
    private SupplierMapper supplierMapper;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SecurityUserRepository securityUserRepository;

    public ResponseDTO exportAbacInformation() {
        ResponseDTO result = new ResponseDTO();
        Gson gson = new GsonBuilder().create();
        JsonParser parser = new JsonParser();
        JsonObject resultJson = new JsonObject();
        List<CallDTO> calls = callMapper.toDTOList(Lists.newArrayList(callRepository.findAll()));
        JsonArray callsJsonArray = new JsonArray();
        if (calls != null && !calls.isEmpty()) {
            for (CallDTO call : calls) {
                JsonObject callJson =  parser.parse(gson.toJson(call)).getAsJsonObject();
                JsonArray applicationsJsonArray = new JsonArray();
                List<BenPubSupDTO> applications = benPubSupMapper.toDTOList(benPubSupRepository.findByPublicationId(call.getCallId()));
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

    public ResponseDTO importAbacInformation(String jsonString) {
        ResponseDTO result = new ResponseDTO();
        Gson gson = new GsonBuilder().create();
        JsonParser parser = new JsonParser();
        JsonObject resultJson = parser.parse(jsonString).getAsJsonObject();
        JsonArray applicationsJsonArray = resultJson.getAsJsonArray("applications");
        for (int i = 0; i < applicationsJsonArray.size(); i++) {
            JsonObject applicationJson = applicationsJsonArray.get(i).getAsJsonObject();
            BenPubSupDTO importedApplication = gson.fromJson(applicationJson, BenPubSupDTO.class);
            if (importedApplication.getBenPubSubId() != null) {
                BenPubSupDTO application = benPubSupMapper.toDTO(benPubSupRepository.findOne(importedApplication.getBenPubSubId()));
                if (application.getBenPubSubId().equals(importedApplication.getBenPubSubId()) &&
                        application.getBeneficiaryId().equals(importedApplication.getBeneficiaryId()) &&
                        application.getPublicationId().equals(importedApplication.getPublicationId())) {
                    application.setLefStatus(importedApplication.getLefStatus());
                    application.setBcStatus(importedApplication.getBcStatus());
                    application.setLcStatus(importedApplication.getLcStatus());
                    Long importDate = new Date().getTime();
                    application.setLefImport(importDate);
                    application.setBcImport(importDate);
                    application.setLcImport(importDate);
                    benPubSupRepository.save(benPubSupMapper.toEntity(application));
                }
            }
        }
        result.setSuccess(true);
        result.setData("Succesful import");
        result.setError(null);
        return result;
    }

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

}
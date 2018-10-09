package wifi4eu.wifi4eu.service.financial;

import com.google.common.collect.Lists;
import com.google.gson.*;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.dto.security.UserDTO;
import wifi4eu.wifi4eu.common.mapper.beneficiary.LegalEntityMapper;
import wifi4eu.wifi4eu.common.mapper.beneficiary.MayorMapper;
import wifi4eu.wifi4eu.common.mapper.call.CallMapper;
import wifi4eu.wifi4eu.common.mapper.security.UserMapper;
import wifi4eu.wifi4eu.common.mapper.supplier.BenPubSupMapper;
import wifi4eu.wifi4eu.common.mapper.supplier.SupplierMapper;
import wifi4eu.wifi4eu.repository.beneficiary.LegalEntityRepository;
import wifi4eu.wifi4eu.repository.beneficiary.MayorRepository;
import wifi4eu.wifi4eu.repository.call.CallRepository;
import wifi4eu.wifi4eu.repository.security.SecurityUserRepository;
import wifi4eu.wifi4eu.repository.supplier.BenPubSupRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierRepository;

@Service
public class FinancialService {
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
    private LegalEntityMapper legalEntityMapper;

    @Autowired
    private LegalEntityRepository legalEntityRepository;

    @Autowired
    private MayorMapper mayorMapper;

    @Autowired
    private MayorRepository mayorRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SecurityUserRepository userRepository;

    @Autowired
    private SupplierMapper supplierMapper;

    @Autowired
    private SupplierRepository supplierRepository;

    public ResponseDTO importAbacInformation(String jsonString) {
        ResponseDTO result = new ResponseDTO();
        Gson gson = new GsonBuilder().create();
        JsonParser parser = new JsonParser();
        JsonObject resultJson = parser.parse(jsonString).getAsJsonObject();
        JsonArray callsJsonArray = resultJson.getAsJsonArray("calls");
        for (int i = 0; i < callsJsonArray.size(); i++) {
            JsonObject callJson = callsJsonArray.get(i).getAsJsonObject();
            CallDTO call = gson.fromJson(callJson, CallDTO.class);
            JsonArray applicationsJsonArray = callJson.getAsJsonArray("applications");
            for (int j = 0; j < applicationsJsonArray.size(); j++) {
                JsonObject applicationJson = applicationsJsonArray.get(j).getAsJsonObject();
                BenPubSupDTO application = BenPubSupDTO.createNewApplication();
                application.setBenPubSubId(applicationJson.get("benPubSubId").getAsLong());
                JsonObject beneficiary = applicationJson.getAsJsonObject("beneficiary");
                LegalEntityDTO legalEntity = gson.fromJson(beneficiary.getAsJsonObject("legalEntity"), LegalEntityDTO.class);
                MayorDTO mayor = gson.fromJson(beneficiary.getAsJsonObject("mayor"), MayorDTO.class);
                UserDTO user = gson.fromJson(beneficiary.getAsJsonObject("user"), UserDTO.class);
                SupplierDTO supplier = gson.fromJson(applicationJson.getAsJsonObject("supplier"), SupplierDTO.class);
                application.setAwarded(applicationJson.get("awarded").getAsBoolean());
                application.setDate(new Date(applicationJson.get("date").getAsLong()));
                application.setPublicationId(call.getCallId());
                application.setBeneficiaryId(legalEntity.getLegalEntityId());
                legalEntityRepository.save(legalEntityMapper.toEntity(legalEntity));
                mayorRepository.save(mayorMapper.toEntity(mayor));
                userRepository.save(userMapper.toEntity(user));
                if (supplier.getSupplierId() != null) {
                    application.setSupplierId(supplier.getSupplierId());
                    supplierRepository.save(supplierMapper.toEntity(supplier));
                }
                Long importDate = new Date().getTime();
                application.setLefImport(importDate);
                application.setBcImport(importDate);
                application.setLcImport(importDate);
                benPubSupRepository.save(benPubSupMapper.toEntity(application));
            }
            callRepository.save(callMapper.toEntity(call));
        }
        result.setSuccess(true);
        result.setData("Succesful import");
        result.setError(null);
        return result;
    }

    public ResponseDTO exportAbacInformation() {
        ResponseDTO result = new ResponseDTO();
        Gson gson = new GsonBuilder().create();
        JsonParser parser = new JsonParser();
        JsonObject resultJson = new JsonObject();
        List<BenPubSupDTO> applications = benPubSupMapper.toDTOList(Lists.newArrayList(benPubSupRepository.findAll()));
        JsonArray applicationsJsonArray = new JsonArray();
        if (applications != null && !applications.isEmpty()) {
            for (BenPubSupDTO application : applications) {
                long exportDate = new Date().getTime();
                application.setLefExport(exportDate);
                application.setBcExport(exportDate);
                application.setLcExport(exportDate);
                benPubSupRepository.save(benPubSupMapper.toEntity(application));
                JsonObject applicationJson = parser.parse(gson.toJson(application)).getAsJsonObject();
                applicationsJsonArray.add(applicationJson);
            }
        }
        resultJson.addProperty("version", _version);
        resultJson.addProperty("createTime", new Date().getTime());
        resultJson.add("applications", applicationsJsonArray);
        result.setSuccess(true);
        result.setData(resultJson.toString());
        result.setError(null);
        return result;
    }

}
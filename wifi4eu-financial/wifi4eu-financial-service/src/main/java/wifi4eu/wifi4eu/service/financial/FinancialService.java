package wifi4eu.wifi4eu.service.financial;

import com.google.common.collect.Lists;
import com.google.gson.*;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.List;
import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.security.UserDTO;
import wifi4eu.wifi4eu.mapper.beneficiary.LegalEntityMapper;
import wifi4eu.wifi4eu.mapper.beneficiary.MayorMapper;
import wifi4eu.wifi4eu.mapper.call.CallMapper;
import wifi4eu.wifi4eu.mapper.security.UserMapper;
import wifi4eu.wifi4eu.mapper.supplier.BenPubSupMapper;
import wifi4eu.wifi4eu.mapper.supplier.SupplierMapper;
import wifi4eu.wifi4eu.repository.beneficiary.LegalEntityRepository;
import wifi4eu.wifi4eu.repository.beneficiary.MayorRepository;
import wifi4eu.wifi4eu.repository.call.CallRepository;
import wifi4eu.wifi4eu.repository.security.SecurityUserRepository;
import wifi4eu.wifi4eu.repository.supplier.BenPubSupRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierRepository;

/**
 * Created by lviverof on 29/08/2017.
 */

@Service
public class FinancialService {
    @Autowired
    CallRepository callRepository;

    @Autowired
    CallMapper callMapper;

    @Autowired
    LegalEntityRepository legalEntityRepository;

    @Autowired
    LegalEntityMapper legalEntityMapper;

    @Autowired
    MayorRepository mayorRepository;

    @Autowired
    MayorMapper mayorMapper;

    @Autowired
    SecurityUserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    SupplierMapper supplierMapper;

    @Autowired
    BenPubSupRepository benPubSupRepository;

    @Autowired
    BenPubSupMapper benPubSupMapper;

    public boolean importJson(String jsonStringFile) {
        System.out.println("Start Import JSON");
        JSONObject json = new JSONObject(jsonStringFile);
        if (!checkJsonFileFormat(json)) {
            return false;
        }
        return uploadDataToDB(jsonStringFile);
    }

    public String exportJson() {
        Gson gson = new GsonBuilder().create();
        Writer writer = new StringWriter();
        try {
            JsonWriter jsonWriter = gson.newJsonWriter(writer);
            jsonWriter.beginObject();
            jsonWriter.name("version").value("0.0.1");
            jsonWriter.name("createTime").value(new Date().getTime());
            jsonWriter.name("publications").beginArray();
            List<CallDTO> calls = callMapper.toDTOList(Lists.newArrayList(callRepository.findAll()));
            for (CallDTO call : calls) {
                jsonWriter.beginObject();
                jsonWriter.name("publicationId").value(call.getCallId());
                jsonWriter.name("appliers").beginArray();
                List<BenPubSupDTO> appliers = benPubSupMapper.toDTOList(Lists.newArrayList(benPubSupRepository.findByPublicationId(call.getCallId())));
                for (BenPubSupDTO applier : appliers) {
                    LegalEntityDTO legalEntity = legalEntityMapper.toDTO(legalEntityRepository.findOne(applier.getBeneficiaryId()));
                    MayorDTO mayor = mayorMapper.toDTO(mayorRepository.findByLegalEntityId(legalEntity.getLegalEntityId()));
                    UserDTO user = userMapper.toDTO(userRepository.findByUserTypeId(mayor.getMayorId()));
                    jsonWriter.beginObject();
                    jsonWriter.name("benPubSubId").value(applier.getBenPubSubId());
                    jsonWriter.name("beneficiary");
                    JsonObject mayorJson = gson.toJsonTree(mayor).getAsJsonObject();
                    mayorJson.remove("legalEntityId");
                    JsonObject entityJson = gson.toJsonTree(legalEntity).getAsJsonObject();
                    entityJson.remove("legalCheckbox1");
                    entityJson.remove("legalCheckbox2");
                    entityJson.remove("legalCheckbox3");
                    entityJson.remove("abacStatus");
                    mayorJson.add("legalEntity", entityJson);
                    JsonObject userJson = gson.toJsonTree(user).getAsJsonObject();
                    userJson.remove("password");
                    userJson.remove("accessDate");
                    userJson.remove("roles");
                    mayorJson.add("user", userJson);
                    jsonWriter.jsonValue(mayorJson.toString());
                    jsonWriter.name("supplier");
                    if (applier.getSupplierId() != null) {
                        SupplierDTO supplier = supplierMapper.toDTO(supplierRepository.findOne(applier.getSupplierId()));
                        JsonObject supplierJson = gson.toJsonTree(supplier).getAsJsonObject();
                        supplierJson.remove("legalCheck1");
                        supplierJson.remove("legalCheck2");
                        supplierJson.remove("createDate");
                        supplierJson.remove("logo");
                        supplierJson.remove("abacStatus");
                        jsonWriter.jsonValue(supplierJson.toString());
                    } else {
                        jsonWriter.beginObject();
                        jsonWriter.endObject();
                    }
                    jsonWriter.name("status");
                    jsonWriter.beginObject();
                    jsonWriter.name("budgetCommited").value(applier.isBudgetCommited());
                    jsonWriter.name("budgetLinked").value(applier.isBudgetLinked());
                    jsonWriter.name("approved").value(applier.isAwarded());
                    jsonWriter.endObject();
                    jsonWriter.endObject();
                }
                jsonWriter.endArray();
                jsonWriter.endObject();
            }
            jsonWriter.endArray();
            jsonWriter.endObject();
            System.out.println(writer.toString());
            return writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getLocalizedMessage();
        }
    }

    public boolean checkJsonFileFormat(JSONObject json) {
        try {
            JSONArray publications = json.getJSONArray("publications");
            for (int i = 0; i < publications.length(); i++) {
                JSONObject publication = publications.getJSONObject(i);
                JSONArray appliers = publication.getJSONArray("appliers");
                for (int j = 0; j < appliers.length(); j++) {
                    JSONObject applier = appliers.getJSONObject(j);
                    if (applier.has("benPubSubId")) {
                        if (applier.get("benPubSubId").toString() == null || applier.get("benPubSubId").toString().trim().isEmpty()) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                    if (applier.has("beneficiary")) {
                        JSONObject benef = applier.getJSONObject("beneficiary");
                        if (benef.has("mayorId")) {
                            if (benef.get("mayorId") == null || benef.get("mayorId").toString().trim().isEmpty()) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                        if (benef.has("treatment")) {
                            if (benef.get("treatment") == null || benef.get("treatment").toString().trim().isEmpty()) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                        if (benef.has("name")) {
                            if (benef.get("name") == null || benef.get("name").toString().trim().isEmpty()) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                        if (benef.has("surname")) {
                            if (benef.get("surname") == null || benef.get("surname").toString().trim().isEmpty()) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                        if (benef.has("email")) {
                            if (benef.get("email") == null || benef.get("email").toString().trim().isEmpty()) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                        if (benef.has("legalEntity")) {
                            JSONObject entity = benef.getJSONObject("legalEntity");
                            if (entity.has("legalEntityId")) {
                                if (entity.get("legalEntityId") == null || entity.get("legalEntityId").toString().trim().isEmpty()) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                            if (entity.has("countryCode")) {
                                if (entity.get("countryCode") == null || entity.get("countryCode").toString().trim().isEmpty()) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                            if (entity.has("municipalityCode")) {
                                if (entity.get("municipalityCode") == null || entity.get("municipalityCode").toString().trim().isEmpty()) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                            if (entity.has("address")) {
                                if (entity.get("address") == null || entity.get("address").toString().trim().isEmpty()) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                            if (entity.has("addressNum")) {
                                if (entity.get("addressNum") == null || entity.get("addressNum").toString().trim().isEmpty()) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                            if (entity.has("postalCode")) {
                                if (entity.get("postalCode") == null || entity.get("postalCode").toString().trim().isEmpty()) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                        if (benef.has("user")) {
                            JSONObject user = benef.getJSONObject("user");
                            if (user.has("userId")) {
                                if (user.get("userId") == null || user.get("userId").toString().trim().isEmpty()) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                            if (user.has("email")) {
                                if (user.get("email") == null || user.get("email").toString().trim().isEmpty()) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                            if (user.has("createDate")) {
                                if (user.get("createDate") == null || user.get("createDate").toString().trim().isEmpty()) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                            if (user.has("userType")) {
                                if (user.get("userType") == null || user.get("userType").toString().trim().isEmpty()) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                            if (user.has("userTypeId")) {
                                if (user.get("userTypeId") == null || user.get("userTypeId").toString().trim().isEmpty()) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                    if (applier.has("supplier")) {
                        JSONObject supplier = applier.getJSONObject("supplier");
                        if (supplier.length() > 0) {
                            if (supplier.has("supplierId")) {
                                if (supplier.get("supplierId") == null || supplier.get("supplierId").toString().trim().isEmpty()) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                            if (supplier.has("name")) {
                                if (supplier.get("name") == null || supplier.get("name").toString().trim().isEmpty()) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                            if (supplier.has("address")) {
                                if (supplier.get("address") == null || supplier.get("address").toString().trim().isEmpty()) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                            if (supplier.has("vat")) {
                                if (supplier.get("vat") == null || supplier.get("vat").toString().trim().isEmpty()) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                            if (supplier.has("bic")) {
                                if (supplier.get("bic") == null || supplier.get("bic").toString().trim().isEmpty()) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                            if (supplier.has("accountNumber")) {
                                if (supplier.get("accountNumber") == null || supplier.get("accountNumber").toString().trim().isEmpty()) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                            if (supplier.has("contactName")) {
                                if (supplier.get("contactName") == null || supplier.get("contactName").toString().trim().isEmpty()) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                            if (supplier.has("contactSurname")) {
                                if (supplier.get("contactSurname") == null || supplier.get("contactSurname").toString().trim().isEmpty()) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                            if (supplier.has("contactPhonePrefix")) {
                                if (supplier.get("contactPhonePrefix") == null || supplier.get("contactPhonePrefix").toString().trim().isEmpty()) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                            if (supplier.has("contactPhoneNumber")) {
                                if (supplier.get("contactPhoneNumber") == null || supplier.get("contactPhoneNumber").toString().trim().isEmpty()) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                            if (supplier.has("contactEmail")) {
                                if (supplier.get("contactEmail") == null || supplier.get("contactEmail").toString().trim().isEmpty()) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                            if (supplier.has("nutsIds")) {
                                if (supplier.get("nutsIds") == null || supplier.get("nutsIds").toString().trim().isEmpty()) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                        }
                    } else {
                        return false;
                    }
                    if (applier.has("status")) {
                        JSONObject status = applier.getJSONObject("status");
                        if (status.has("budgetCommited")) {
                            if (status.get("budgetCommited") == null || status.get("budgetCommited").toString().trim().isEmpty()) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                        if (status.has("budgedLinked")) {
                            if (status.get("budgedLinked") == null || status.get("budgedLinked").toString().trim().isEmpty()) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                        if (status.has("approved")) {
                            if (status.get("approved") == null || status.get("approved").toString().trim().isEmpty()) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
            return true;
        } catch (JSONException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean uploadDataToDB(String jsonString) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, TimestampTypeAdapter.getTimestampTypeAdapter()).create();
        JsonObject json = new JsonParser().parse(jsonString).getAsJsonObject();
        JsonArray publications = json.getAsJsonArray("publications");
        for (int i = 0; i < publications.size(); i++) {
            JsonObject publication = publications.get(i).getAsJsonObject();
            CallDTO callDTO = new CallDTO();
            callDTO.setCallId(publication.getAsJsonPrimitive("publicationId").getAsLong());
            callDTO.setEvent("Gson Test");
            callDTO.setStartDate(new Date().getTime() /  1000);
            callDTO.setEndDate(new Date().getTime() / 1000 + 1000);
            JsonArray appliers = publication.getAsJsonArray("appliers");
            callRepository.save(callMapper.toEntity(callDTO));
            for (int j = 0; j < appliers.size(); j++) {
                JsonObject applier = appliers.get(j).getAsJsonObject();
                BenPubSupDTO benPubSupDTO = new BenPubSupDTO();
                benPubSupDTO.setBenPubSubId(applier.getAsJsonPrimitive("benPubSubId").getAsLong());
                JsonObject beneficiary = applier.getAsJsonObject("beneficiary");
                MayorDTO mayorDTO = gson.fromJson(beneficiary, MayorDTO.class);
                JsonObject entity = beneficiary.getAsJsonObject("legalEntity");
                LegalEntityDTO legalEntityDTO = gson.fromJson(entity, LegalEntityDTO.class);
                JsonObject user = beneficiary.getAsJsonObject("user");
                UserDTO userDTO = gson.fromJson(user, UserDTO.class);
                JsonObject supplier = applier.getAsJsonObject("supplier");
                SupplierDTO supplierDTO = gson.fromJson(supplier, SupplierDTO.class);
                benPubSupDTO.setPublicationId(callDTO.getCallId());
                benPubSupDTO.setBeneficiaryId(legalEntityDTO.getLegalEntityId());
                benPubSupDTO.setAwarded(applier.getAsJsonObject("status").getAsJsonPrimitive("approved").getAsBoolean());
                benPubSupDTO.setBudgetCommited(applier.getAsJsonObject("status").getAsJsonPrimitive("budgetCommited").getAsBoolean());
                benPubSupDTO.setBudgetLinked(applier.getAsJsonObject("status").getAsJsonPrimitive("budgetLinked").getAsBoolean());
                mayorDTO.setLegalEntityId(legalEntityDTO.getLegalEntityId());
                legalEntityRepository.save(legalEntityMapper.toEntity(legalEntityDTO));
                mayorRepository.save(mayorMapper.toEntity(mayorDTO));
                userRepository.save(userMapper.toEntity(userDTO));
                if (supplierDTO != null) {
                    benPubSupDTO.setSupplierId(supplierDTO.getSupplierId());
                    supplierRepository.save(supplierMapper.toEntity(supplierDTO));
                }
                benPubSupRepository.save(benPubSupMapper.toEntity(benPubSupDTO));
            }
        }
        return true;
    }
}
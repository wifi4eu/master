package wifi4eu.wifi4eu.service.financial;

import com.google.common.collect.Lists;
import eu.europa.ec.budg.abac.legal_entity.v2.LegalEntitySearchCriteriaType;
import eu.europa.ec.budg.abac.legal_entity.v2.LegalEntitySearchRequestType;
import eu.europa.ec.budg.abac.legal_entity.service.es.sync.v2.LegalEntity;
import eu.europa.ec.budg.abac.legal_entity.v2.LegalEntitySearchResponseType;
import eu.europa.ec.budg.abac.message.v1.MessageHeaderType;


import org.json.*;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import eu.europa.ec.budg.abac.search_criterion.v1.*;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.security.UserDTO;
import wifi4eu.wifi4eu.entity.supplier.BenPubSup;
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
        uploadDataToDB(json);
        return true;
    }

    public String exportJson() {
        try {
            Writer writer = new StringWriter();
            JSONWriter jsonWriter = new JSONWriter(writer);
            List<CallDTO> calls = callMapper.toDTOList(Lists.newArrayList(callRepository.findAll()));
            jsonWriter.object();
            jsonWriter.key("version");
            jsonWriter.value("0.0.1");
            jsonWriter.key("createTime");
            jsonWriter.value(new Date().getTime());
            jsonWriter.key("publications");
            jsonWriter.array();
            for (CallDTO call : calls) {
                jsonWriter.object();
                jsonWriter.key("publicationId");
                jsonWriter.value(call.getCallId());
                List<BenPubSupDTO> appliers = benPubSupMapper.toDTOList(Lists.newArrayList(benPubSupRepository.findByPublicationId(call.getCallId())));
                jsonWriter.key("appliers");
                jsonWriter.array();
                for (BenPubSupDTO applier : appliers) {
                    jsonWriter.object();
                    jsonWriter.key("benPubSubId");
                    jsonWriter.value(applier.getBenPubSubId());
                    jsonWriter.key("beneficiary");
                    jsonWriter.object();
                    jsonWriter = writeJsonBeneficiary(jsonWriter, applier.getBeneficiaryId());
                    jsonWriter.endObject();
                    jsonWriter.key("supplier");
                    jsonWriter.object();
                    jsonWriter = writeJsonSupplier(jsonWriter, applier.getSupplierId());
                    jsonWriter.endObject();
                    jsonWriter.key("status");
                    jsonWriter.object();
                    jsonWriter = writeJsonStatus(jsonWriter, applier);
                    jsonWriter.endObject();
                    jsonWriter.endObject();
                }
                jsonWriter.endArray();
                jsonWriter.endObject();
            }
            jsonWriter.endArray();
            jsonWriter.endObject();
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
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

    public boolean uploadDataToDB(JSONObject json) {
        try {
            JSONArray publications = json.getJSONArray("publications");
            for (int i = 0; i < publications.length(); i++) {
                JSONObject publication = publications.getJSONObject(i);
                CallDTO callDTO = new CallDTO();
                callDTO.setCallId(publication.getLong("publicationId"));
                callDTO.setEvent("JSON Test");
                callDTO.setStartDate(new Date().getTime() /  1000);
                callDTO.setEndDate(new Date().getTime() / 1000 + 1000);
                callRepository.save(callMapper.toEntity(callDTO));
                JSONArray appliers = publication.getJSONArray("appliers");
                for (int j = 0; j < appliers.length(); j++) {
                    JSONObject applier = appliers.getJSONObject(j);
                    BenPubSupDTO benPubSupDTO = new BenPubSupDTO();
                    benPubSupDTO.setBenPubSubId(applier.getLong("benPubSubId"));
                    JSONObject benef = applier.getJSONObject("beneficiary");
                    MayorDTO mayorDTO = new MayorDTO();
                    mayorDTO.setMayorId(benef.getLong("mayorId"));
                    mayorDTO.setTreatment(benef.getString("treatment"));
                    mayorDTO.setName(benef.getString("name"));
                    mayorDTO.setSurname(benef.getString("surname"));
                    mayorDTO.setEmail(benef.getString("email"));
                    JSONObject legalEntity = benef.getJSONObject("legalEntity");
                    LegalEntityDTO legalEntityDTO = new LegalEntityDTO();
                    legalEntityDTO.setLegalEntityId(legalEntity.getInt("legalEntityId"));
                    legalEntityDTO.setCountryCode(legalEntity.getString("countryCode"));
                    legalEntityDTO.setMunicipalityCode(legalEntity.getString("municipalityCode"));
                    legalEntityDTO.setAddress(legalEntity.getString("address"));
                    legalEntityDTO.setAddressNum(legalEntity.getString("addressNum"));
                    legalEntityDTO.setPostalCode(legalEntity.getString("postalCode"));
                    legalEntityRepository.save(legalEntityMapper.toEntity(legalEntityDTO));
                    mayorDTO.setLegalEntityId(legalEntityDTO.getLegalEntityId());
                    mayorRepository.save(mayorMapper.toEntity(mayorDTO));
                    JSONObject user = benef.getJSONObject("user");
                    UserDTO userDTO = new UserDTO();
                    userDTO.setUserId(user.getLong("userId"));
                    userDTO.setEmail(user.getString("email"));
                    userDTO.setCreateDate(new Date(user.getLong("createDate")));
                    userDTO.setUserType(user.getLong("userType"));
                    userDTO.setUserTypeId(user.getLong("userTypeId"));
                    userRepository.save(userMapper.toEntity(userDTO));
                    JSONObject supplier = applier.getJSONObject("supplier");
                    SupplierDTO supplierDTO = new SupplierDTO();
                    supplierDTO.setSupplierId(supplier.getLong("supplierId"));
                    supplierDTO.setName(supplier.getString("name"));
                    supplierDTO.setAddress(supplier.getString("address"));
                    supplierDTO.setVat(supplier.getString("vat"));
                    supplierDTO.setBic(supplier.getString("bic"));
                    supplierDTO.setAccountNumber(supplier.getString("accountNumber"));
                    supplierDTO.setContactName(supplier.getString("contactName"));
                    supplierDTO.setContactSurname(supplier.getString("contactSurname"));
                    supplierDTO.setContactPhonePrefix(supplier.getString("contactPhonePrefix"));
                    supplierDTO.setContactPhoneNumber(supplier.getString("contactPhoneNumber"));
                    supplierDTO.setContactEmail(supplier.getString("contactEmail"));
                    supplierDTO.setNutsIds(supplier.getString("nutsIds"));
                    supplierRepository.save(supplierMapper.toEntity(supplierDTO));
                    JSONObject benPubSup = applier.getJSONObject("status");
                    benPubSupDTO.setBudgetCommited(benPubSup.getBoolean("budgetCommited"));
                    benPubSupDTO.setBudgetLinked(benPubSup.getBoolean("budgedLinked"));
                    benPubSupDTO.setAwarded(benPubSup.getBoolean("approved"));
                    benPubSupDTO.setBeneficiaryId(legalEntity.getLong("legalEntityId"));
                    benPubSupDTO.setPublicationId(publication.getLong("publicationId"));
                    benPubSupDTO.setSupplierId(supplier.getLong("supplierId"));
                    benPubSupRepository.save(benPubSupMapper.toEntity(benPubSupDTO));
                }
            }
            return true;
        } catch (JSONException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public JSONWriter writeJsonBeneficiary(JSONWriter writer, long beneficiaryId) {
        LegalEntityDTO legalEntity = legalEntityMapper.toDTO(legalEntityRepository.findOne(beneficiaryId));
        MayorDTO mayor = mayorMapper.toDTO(mayorRepository.findByLegalEntityId(legalEntity.getLegalEntityId()));
        UserDTO user = userMapper.toDTO(userRepository.findByUserTypeId(mayor.getMayorId()));
        writer.key("mayorId");
        writer.value(mayor.getMayorId());
        writer.key("treatment");
        writer.value(mayor.getTreatment());
        writer.key("name");
        writer.value(mayor.getName());
        writer.key("surname");
        writer.value(mayor.getSurname());
        writer.key("email");
        writer.value(mayor.getEmail());
        writer.key("legalEntity");
        writer.object();
        writer.key("legalEntityId");
        writer.value(legalEntity.getLegalEntityId());
        writer.key("countryCode");
        writer.value(legalEntity.getCountryCode());
        writer.key("municipalityCode");
        writer.value(legalEntity.getMunicipalityCode());
        writer.key("address");
        writer.value(legalEntity.getAddress());
        writer.key("addressNum");
        writer.value(legalEntity.getAddressNum());
        writer.key("postalCode");
        writer.value(legalEntity.getPostalCode());
        writer.endObject();
        writer.key("user");
        writer.object();
        writer.key("userId");
        writer.value(user.getUserId());
        writer.key("email");
        writer.value(user.getEmail());
        writer.key("createDate");
        writer.value(user.getCreateDate().getTime());
        writer.key("userType");
        writer.value(user.getUserType());
        writer.key("userTypeId");
        writer.value(user.getUserTypeId());
        writer.endObject();
        return writer;
    }

    public JSONWriter writeJsonSupplier(JSONWriter writer, long supplierId) {
        SupplierDTO supplier = supplierMapper.toDTO(supplierRepository.findOne(supplierId));
        writer.key("supplierId");
        writer.value(supplier.getSupplierId());
        writer.key("name");
        writer.value(supplier.getName());
        writer.key("address");
        writer.value(supplier.getAddress());
        writer.key("vat");
        writer.value(supplier.getVat());
        writer.key("bic");
        writer.value(supplier.getBic());
        writer.key("accountNumber");
        writer.value(supplier.getAccountNumber());
        writer.key("contactName");
        writer.value(supplier.getContactName());
        writer.key("contactSurname");
        writer.value(supplier.getContactSurname());
        writer.key("contactPhonePrefix");
        writer.value(supplier.getContactPhonePrefix());
        writer.key("contactPhoneNumber");
        writer.value(supplier.getContactPhoneNumber());
        writer.key("contactEmail");
        writer.value(supplier.getContactEmail());
        writer.key("nutsIds");
        writer.value(supplier.getNutsIds());
        return writer;
    }

    public JSONWriter writeJsonStatus(JSONWriter writer, BenPubSupDTO applier) {
        writer.key("budgetCommited");
        writer.value(applier.isBudgetCommited());
        writer.key("budgetLinked");
        writer.value(applier.isBudgetLinked());
        writer.key("approved");
        writer.value(applier.isAwarded());
        return writer;
    }
}

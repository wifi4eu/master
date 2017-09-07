package wifi4eu.wifi4eu.service.financial;

import eu.europa.ec.budg.abac.ares_document.v1.AresDocumentsType;
import eu.europa.ec.budg.abac.legal_entity.service.es.async.v1.LegalEntityPort;
import eu.europa.ec.budg.abac.legal_entity.service.es.sync.v2.LegalEntity;
import eu.europa.ec.budg.abac.legal_entity.v2.*;
import eu.europa.ec.budg.abac.legal_entity_bank_account_link.v1.LegalEntityBankAccountLinkType;
import eu.europa.ec.budg.abac.message.v1.BusinessRuleMessageResponseType;
import eu.europa.ec.budg.abac.message.v1.MessageHeaderType;


import eu.europa.ec.budg.abac.workflow.v1.VisaType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import eu.europa.ec.budg.abac.search_criterion.v1.*;
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

//@Autowired
//private FinancialRepository financialRepository;

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

        /*Lucia*/

        try {

            // CREATE SERVICE

            System.out.println("IN!");

            LegalEntityCreateRequestType lecrt = new LegalEntityCreateRequestType();
            LegalEntityCheckCreateRequestType leccrt = new LegalEntityCheckCreateRequestType();
            EuropeanParliamentMemberCreateType epmct = new EuropeanParliamentMemberCreateType();
            ExStaffMemberCreateType esmct = new ExStaffMemberCreateType();
            PrivatePersonCreateType ppct = new PrivatePersonCreateType();
            StaffMemberCreateType smct = new StaffMemberCreateType();
            PublicLawBodyCreateType publiclbct = new PublicLawBodyCreateType();
            PrivateLawBodyCreateType privatelbct = new PrivateLawBodyCreateType();
            VisaType vt = new VisaType();
            AresDocumentsType aresDocType = new AresDocumentsType();
            IdentificationDocumentType identDocType = new IdentificationDocumentType();
            LegalEntityCreateType.LegalEntityBankAccountLinks lEBankAccountLink = new LegalEntityCreateType.LegalEntityBankAccountLinks();
            BigInteger bigInteger = null;


//          EX STAFF MEMBER
            esmct.setNupNumber("SetNupNumber");
            esmct.setAccountGroupCode("AccountGroupCode");
            esmct.setAresDocuments(aresDocType);
            esmct.setBirthCity("Spain");
            esmct.setBirthCountryCode("ES");
            esmct.setBudgetCompanyCode("ES");
            esmct.setBusinessName("BusinessName");
            esmct.setDriverLicense(identDocType);
            esmct.setDuplicateCheckBypassFlag(false);
            esmct.setFirstName("Testing");
            esmct.setIdentityCard(identDocType);
            esmct.setIsACustomerOnly(true);
            esmct.setIsSelfEmployed(true);
            esmct.setLanguageCode("ES");
            esmct.setLegalEntityBankAccountLinks(lEBankAccountLink);
            esmct.setLightValidationFlag(true);

//          EUROPEAN PARLIAMENT MEMBER
            epmct.setIdentityCard(identDocType);
            epmct.setLegalEntityBankAccountLinks(lEBankAccountLink);
            epmct.setFirstName("Testing Dos");
            epmct.setLanguageCode("ES");
            epmct.setIsACustomerOnly(true);
            epmct.setDuplicateCheckBypassFlag(false);

//          PRIVATE PERSON
            ppct.setBusinessName("Private Person");
            ppct.setFirstName("Testing Tres");
            ppct.setIdentityCard(identDocType);
            ppct.setLanguageCode("EN");
            ppct.setVatNumber("00000000000001");

//          STAFF MEMBER
            smct.setIdentityCard(identDocType);
            smct.setLanguageCode("ES");
            smct.setDuplicateCheckBypassFlag(false);
            smct.setPersonalId(bigInteger);
            smct.setAccountGroupCode("Wifi4EU");

//          PUBLIC LAW BODY
            publiclbct.setAccountGroupCode("wifi4eu");
            publiclbct.setAcronym("wifi para todos");
            publiclbct.setIsACustomerOnly(false);
            publiclbct.setLanguageCode("EN");
            publiclbct.setLegalFormCode("ALLRIGHT");

//          PRIVATE LAW BODY
            privatelbct.setAccountGroupCode("wifi4eu..");
            privatelbct.setAcronym("wifi para todos!");
            privatelbct.setIsACustomerOnly(false);
            privatelbct.setLanguageCode("ES");
            privatelbct.setLegalFormCode("ALLRIGHT2");

//          VISA
            vt.setActionCode("ACCEPT?");
            vt.setAgentId("Visa Agent ID");
            vt.setCommentText("OK. Up to date.");
            vt.setPersonId("Person ID");
            vt.setSignature("Signed...");

//          LEGAL ENTITY CREATE REQUEST TYPE
            lecrt.setEuropeanParliamentMember(epmct);
            lecrt.setExStaffMember(esmct);
            lecrt.setPrivatePerson(ppct);
            lecrt.setStaffMember(smct);
            lecrt.setPublicLawBody(publiclbct);
            lecrt.setPrivateLawBody(privatelbct);
            lecrt.setVisa(vt);


            System.out.println("PRINTING HASHCODE------------------------------" + lecrt.hashCode());

            //lanzar la petición al servicio

            eu.europa.ec.budg.abac.legal_entity.service.es.async.v1.LegalEntity leAsync = new eu.europa.ec.budg.abac.legal_entity.service.es.async.v1.LegalEntity();


            BusinessRuleMessageResponseType bRMRT = leAsync.getLegalEntitySOAP().create(lecrt);

            System.out.println("PRINTING BUSINESSRKULEMESSAGERESPONSETYPE------------------------------" + bRMRT);
            System.out.println("PRINTING MESSAGE HEADER ---------------------------------------" + bRMRT.getMessageHeader());
            System.out.println("PRINTING MESSAGE FAULT------------------------------" + bRMRT.getMessageFault());
            System.out.println("PRINTING BUSSINESS RULE REJECTION LIST ------------------------------" + bRMRT.getBusinessRuleRejectionList());
            System.out.println("PRINTING BUSINES RULE REJECTION RETURN CODE ------------------------------------------" + bRMRT.getBusinessRuleRejectionReturnCode());

//            LegalEntitySearchResponseType leSearchResponse = le.getLegalEntitySOAP().cre(aresDocType);


            // SEARCH SERVICE
            // preparar el objeto a enviar

            System.out.println("IN!");
//            LegalEntity le = new LegalEntity();
//
//            LegalEntitySearchRequestType lesrt = new LegalEntitySearchRequestType();
//            MessageHeaderType mHType = new MessageHeaderType();
//            LegalEntitySearchCriteriaType searchCriteria = new LegalEntitySearchCriteriaType();
//            TextCriterionType txtCriterionType = new TextCriterionType();
//            DateCriterionType dateCriterionT = new DateCriterionType();
//            NumberCriterionType numCriterionT = new NumberCriterionType();
//            IndicatorCriterionType indicCriterionT = new IndicatorCriterionType();
//            OracleTextCriterionType oracleTxtCritT = new OracleTextCriterionType();
//
//            searchCriteria.setRegistrationCountryCode(txtCriterionType);
//            searchCriteria.setRegistrationDate(dateCriterionT);
//            searchCriteria.setRegistrationNumber(txtCriterionType);
//            searchCriteria.setCurrentWorkflowLevel(numCriterionT);
//            searchCriteria.setRegistrationNumber(txtCriterionType);
//            searchCriteria.setAnyDocumentIssuingCountryCode(txtCriterionType);
//            searchCriteria.setAcronym(txtCriterionType);
//            searchCriteria.setAbacKey(txtCriterionType);
//            searchCriteria.setAccountGroupCode(txtCriterionType);
//            searchCriteria.setAnyDocumentNumber(txtCriterionType);
//            searchCriteria.setBirthCountryCode(txtCriterionType);
//            searchCriteria.setBlockedFlag(indicCriterionT);
//            searchCriteria.setWholeName(oracleTxtCritT);
//            searchCriteria.setVat(txtCriterionType);
//            searchCriteria.setResponsibleUsers(txtCriterionType);
//            searchCriteria.setRegistrationAuth(txtCriterionType);
//            searchCriteria.setPassportIssuingCountryCode(txtCriterionType);
//            searchCriteria.setPassportNumber(txtCriterionType);
//            searchCriteria.setOtherDocumentNumber(txtCriterionType);
//            searchCriteria.setOfficialName(oracleTxtCritT);
//            searchCriteria.setOfficialAddressStreetNr(txtCriterionType);
//            searchCriteria.setOfficialAddressPostCode(txtCriterionType);
//
//            System.out.println("MIDDLE IN!");
//
//            lesrt.setSearchCriteria(searchCriteria);
//            lesrt.setStartIndex(0);
//            lesrt.setBlockingSize(100);
//            lesrt.setMessageHeader(mHType);
//            lesrt.setDebug(true);
//
//            // lanzar la petición
//            System.out.println("READY TO GO!");
//            LegalEntity le = new LegalEntity();
//
//            LegalEntitySearchResponseType leSearchResponse = le.getLegalEntitySOAP().search(lesrt);
//
//
//            // getters del response
//
//            System.out.println("row count: " + leSearchResponse.getRowCount());
//            leSearchResponse.getLegalEntitySearchChoiceGroup();

            System.out.println("OK.");


        /*End Lucia*/

//            File file = new File("C:\\test-abac.xml");
//
//            System.out.println("IN DAVID CODE!");
//
//            if (!file.exists()) {
////                return new ResponseAbac(false, null, "The file cannot be exported.");
//                return "{\"test\":\"" + leSearchResponse.getRowCount() + "\",\"version\":\"0.0.1\",\"createTime\":1503299572754,\"publications\":[{\"publicationId\":1701,\"appliers\":[{\"benPubSubId\":11701,\"beneficiary\":{\"mayorId\":7251,\"treatment\":\"ms\",\"name\":\"e\",\"surname\":\"e\",\"email\":\"priscilla.p.barros@gmail.com\",\"legalEntity\":{\"legalEntityId\":7251,\"countryCode\":\"ES\",\"municipalityCode\":\"01022\",\"address\":\"e\",\"addressNum\":\"1\",\"postalCode\":\"122\"},\"user\":{\"userId\":7253,\"email\":\"priscilla.p.barros@gmail.com\",\"createDate\":1501834958000,\"userType\":2,\"userTypeId\":7252}},\"supplier\":false,\"status\":{\"budgetCommited\":false,\"budgedLinked\":false,\"approved\":false}}]}]}";
//
//            }
//            byte[] encoded = Files.readAllBytes(file.toPath());
//            String content = new String(encoded, Charset.defaultCharset());
//            JSONObject jsonObject = XML.toJSONObject(content);
////            return new ResponseAbac(true, jsonObject.toString(), "Export succesful!");
//            System.out.println("IN MIDDLE DAVID CODE!");
//            return "{\"test\":\"" + leSearchResponse.getRowCount() + "\",\"version\":\"0.0.1\",\"createTime\":1503299572754,\"publications\":[{\"publicationId\":1701,\"appliers\":[{\"benPubSubId\":11701,\"beneficiary\":{\"mayorId\":7251,\"treatment\":\"ms\",\"name\":\"e\",\"surname\":\"e\",\"email\":\"priscilla.p.barros@gmail.com\",\"legalEntity\":{\"legalEntityId\":7251,\"countryCode\":\"ES\",\"municipalityCode\":\"01022\",\"address\":\"e\",\"addressNum\":\"1\",\"postalCode\":\"122\"},\"user\":{\"userId\":7253,\"email\":\"priscilla.p.barros@gmail.com\",\"createDate\":1501834958000,\"userType\":2,\"userTypeId\":7252}},\"supplier\":false,\"status\":{\"budgetCommited\":false,\"budgedLinked\":false,\"approved\":false}}]}]}";
//
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
//            return new ResponseAbac(false, e.getMessage(), "Something went wrong during the export process.");
            System.out.println("END DAVID CODE!");
            return "{\"test\":\"" + e.getMessage() + "\",\"version\":\"0.0.1\",\"createTime\":1503299572754,\"publications\":[{\"publicationId\":1701,\"appliers\":[{\"benPubSubId\":11701,\"beneficiary\":{\"mayorId\":7251,\"treatment\":\"ms\",\"name\":\"e\",\"surname\":\"e\",\"email\":\"priscilla.p.barros@gmail.com\",\"legalEntity\":{\"legalEntityId\":7251,\"countryCode\":\"ES\",\"municipalityCode\":\"01022\",\"address\":\"e\",\"addressNum\":\"1\",\"postalCode\":\"122\"},\"user\":{\"userId\":7253,\"email\":\"priscilla.p.barros@gmail.com\",\"createDate\":1501834958000,\"userType\":2,\"userTypeId\":7252}},\"supplier\":false,\"status\":{\"budgetCommited\":false,\"budgedLinked\":false,\"approved\":false}}]}]}";

        }
        return "{\"version\":\"0.0.1\",\"createTime\":1503299572754,\"publications\":[{\"publicationId\":1701,\"appliers\":[{\"benPubSubId\":11701,\"beneficiary\":{\"mayorId\":7251,\"treatment\":\"ms\",\"name\":\"e\",\"surname\":\"e\",\"email\":\"priscilla.p.barros@gmail.com\",\"legalEntity\":{\"legalEntityId\":7251,\"countryCode\":\"ES\",\"municipalityCode\":\"01022\",\"address\":\"e\",\"addressNum\":\"1\",\"postalCode\":\"122\"},\"user\":{\"userId\":7253,\"email\":\"priscilla.p.barros@gmail.com\",\"createDate\":1501834958000,\"userType\":2,\"userTypeId\":7252}},\"supplier\":false,\"status\":{\"budgetCommited\":false,\"budgedLinked\":false,\"approved\":false}}]}]}";
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
                callDTO.setStartDate(new Date().getTime() / 1000);
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

}

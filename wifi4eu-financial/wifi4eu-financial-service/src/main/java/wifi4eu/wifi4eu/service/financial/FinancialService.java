package wifi4eu.wifi4eu.service.financial;

import eu.europa.ec.budg.abac.legal_entity.v2.LegalEntitySearchCriteriaType;
import eu.europa.ec.budg.abac.legal_entity.v2.LegalEntitySearchRequestType;
import eu.europa.ec.budg.abac.legal_entity.service.es.sync.v2.LegalEntity;
import eu.europa.ec.budg.abac.legal_entity.v2.LegalEntitySearchResponseType;
import eu.europa.ec.budg.abac.message.v1.MessageHeaderType;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;

import org.springframework.stereotype.Service;
import eu.europa.ec.budg.abac.search_criterion.v1.*;

/**
 * Created by lviverof on 29/08/2017.
 */

//@Autowired
//private FinancialRepository financialRepository;

@Service
public class FinancialService {


    public boolean importJson(String jsonStringFile) {
        System.out.println("Start Import JSON 2");
        JSONObject json = new JSONObject(jsonStringFile);
        if (!checkJsonFileFormat(json)) {
            return false;
        }
        return true;
    }

    public String exportJson() {

        /*Lucia*/

        try {

            // preparar el objeto a enviar

            System.out.println("IN!");

            LegalEntitySearchRequestType lesrt = new LegalEntitySearchRequestType();
            MessageHeaderType mHType = new MessageHeaderType();
            LegalEntitySearchCriteriaType searchCriteria = new LegalEntitySearchCriteriaType();
            TextCriterionType txtCriterionType = new TextCriterionType();
            DateCriterionType dateCriterionT = new DateCriterionType();
            NumberCriterionType numCriterionT = new NumberCriterionType();
            IndicatorCriterionType indicCriterionT = new IndicatorCriterionType();
            OracleTextCriterionType oracleTxtCritT = new OracleTextCriterionType();
//            TextCriterionOperatorType txtCritOperT = new TextCriterionOperatorType();
//
//            txtCriterionType.setOperator(txtCritOperT);
//            txtCriterionType.setSort();
//            txtCriterionType.setValue();
//            txtCriterionType.setValue2();

            searchCriteria.setRegistrationCountryCode(txtCriterionType);
            searchCriteria.setRegistrationDate(dateCriterionT);
            searchCriteria.setRegistrationNumber(txtCriterionType);
            searchCriteria.setCurrentWorkflowLevel(numCriterionT);
            searchCriteria.setRegistrationNumber(txtCriterionType);
            searchCriteria.setAnyDocumentIssuingCountryCode(txtCriterionType);
            searchCriteria.setAcronym(txtCriterionType);
            searchCriteria.setAbacKey(txtCriterionType);
            searchCriteria.setAccountGroupCode(txtCriterionType);
            searchCriteria.setAnyDocumentNumber(txtCriterionType);
            searchCriteria.setBirthCountryCode(txtCriterionType);
            searchCriteria.setBlockedFlag(indicCriterionT);
            searchCriteria.setWholeName(oracleTxtCritT);
            searchCriteria.setVat(txtCriterionType);
            searchCriteria.setResponsibleUsers(txtCriterionType);
            searchCriteria.setRegistrationAuth(txtCriterionType);
            searchCriteria.setPassportIssuingCountryCode(txtCriterionType);
            searchCriteria.setPassportNumber(txtCriterionType);
            searchCriteria.setOtherDocumentNumber(txtCriterionType);
            searchCriteria.setOfficialName(oracleTxtCritT);
            searchCriteria.setOfficialAddressStreetNr(txtCriterionType);
            searchCriteria.setOfficialAddressPostCode(txtCriterionType);

            System.out.println("MIDDLE IN!");

            lesrt.setSearchCriteria(searchCriteria);
            lesrt.setStartIndex(0);
            lesrt.setBlockingSize(100);
            lesrt.setMessageHeader(mHType);
            lesrt.setDebug(true);

            // lanzar la petición

            LegalEntity le = new LegalEntity();
            LegalEntitySearchResponseType leSearchResponse = le.getLegalEntitySOAP().search(lesrt);


            // getters del response

            System.out.println("row count: " + leSearchResponse.getRowCount());
            leSearchResponse.getLegalEntitySearchChoiceGroup();

            System.out.println("OK.");


        /*End Lucia*/

            File file = new File("C:\\test-abac.xml");

            System.out.println("IN DAVID CODE!");

            if (!file.exists()) {
//                return new ResponseAbac(false, null, "The file cannot be exported.");
                return "{\"test\":\"" + leSearchResponse.getRowCount() + "\",\"version\":\"0.0.1\",\"createTime\":1503299572754,\"publications\":[{\"publicationId\":1701,\"appliers\":[{\"benPubSubId\":11701,\"beneficiary\":{\"mayorId\":7251,\"treatment\":\"ms\",\"name\":\"e\",\"surname\":\"e\",\"email\":\"priscilla.p.barros@gmail.com\",\"legalEntity\":{\"legalEntityId\":7251,\"countryCode\":\"ES\",\"municipalityCode\":\"01022\",\"address\":\"e\",\"addressNum\":\"1\",\"postalCode\":\"122\"},\"user\":{\"userId\":7253,\"email\":\"priscilla.p.barros@gmail.com\",\"createDate\":1501834958000,\"userType\":2,\"userTypeId\":7252}},\"supplier\":false,\"status\":{\"budgetCommited\":false,\"budgedLinked\":false,\"approved\":false}}]}]}";

            }
            byte[] encoded = Files.readAllBytes(file.toPath());
            String content = new String(encoded, Charset.defaultCharset());
            JSONObject jsonObject = XML.toJSONObject(content);
//            return new ResponseAbac(true, jsonObject.toString(), "Export succesful!");
            System.out.println("IN MIDDLE DAVID CODE!");
            return "{\"test\":\"" + leSearchResponse.getRowCount() + "\",\"version\":\"0.0.1\",\"createTime\":1503299572754,\"publications\":[{\"publicationId\":1701,\"appliers\":[{\"benPubSubId\":11701,\"beneficiary\":{\"mayorId\":7251,\"treatment\":\"ms\",\"name\":\"e\",\"surname\":\"e\",\"email\":\"priscilla.p.barros@gmail.com\",\"legalEntity\":{\"legalEntityId\":7251,\"countryCode\":\"ES\",\"municipalityCode\":\"01022\",\"address\":\"e\",\"addressNum\":\"1\",\"postalCode\":\"122\"},\"user\":{\"userId\":7253,\"email\":\"priscilla.p.barros@gmail.com\",\"createDate\":1501834958000,\"userType\":2,\"userTypeId\":7252}},\"supplier\":false,\"status\":{\"budgetCommited\":false,\"budgedLinked\":false,\"approved\":false}}]}]}";

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
//            return new ResponseAbac(false, e.getMessage(), "Something went wrong during the export process.");
            System.out.println("END DAVID CODE!");
            return "{\"test\":\"" + e.getMessage() + "\",\"version\":\"0.0.1\",\"createTime\":1503299572754,\"publications\":[{\"publicationId\":1701,\"appliers\":[{\"benPubSubId\":11701,\"beneficiary\":{\"mayorId\":7251,\"treatment\":\"ms\",\"name\":\"e\",\"surname\":\"e\",\"email\":\"priscilla.p.barros@gmail.com\",\"legalEntity\":{\"legalEntityId\":7251,\"countryCode\":\"ES\",\"municipalityCode\":\"01022\",\"address\":\"e\",\"addressNum\":\"1\",\"postalCode\":\"122\"},\"user\":{\"userId\":7253,\"email\":\"priscilla.p.barros@gmail.com\",\"createDate\":1501834958000,\"userType\":2,\"userTypeId\":7252}},\"supplier\":false,\"status\":{\"budgetCommited\":false,\"budgedLinked\":false,\"approved\":false}}]}]}";

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
                        if (!applier.isNull("supplier")) {
                            JSONObject supplier = applier.getJSONObject("supplier");
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
                        if (status.has("budgetLinked")) {
                            if (status.get("budgetLinked") == null || status.get("budgetLinked").toString().trim().isEmpty()) {
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
            return false;
        }
    }

}

package wifi4eu.wifi4eu.service.financial;

import javax.servlet.http.HttpServletResponse;

import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.legal_entity.v2.LegalEntitySearchRequestType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.legal_entity.v2.LegalEntitySearchType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.legal_entity.v2.LegalEntitySearchRequestType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.legal_entity.service.es.sync.v2.LegalEntity;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.legal_entity.v2.*;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.message.v1.MessageHeaderType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.search_criterion.v1.*;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;

import java.util.Date;
import java.util.List;

/**
 * Created by lviverof on 29/08/2017.
 */

//@Autowired
//private FinancialRepository financialRepository;

@Service
public class FinancialService {


    public String importJson(String jsonStringFile) {
        System.out.println("Start Import JSON 2");
        JSONObject json = new JSONObject(jsonStringFile);
//        if (!checkJsonFileFormat(json)) {
//            return new ResponseAbac(false, null, "The JSON file you imported doesn't have the correct format.");
//        }
        String xml = XML.toString(json);
        File file = new File("C:\\test-abac.xml");
        try {
            FileOutputStream out = new FileOutputStream(file);
            if (!file.exists()) {
                file.createNewFile();
            }
            out.write(xml.getBytes());
            out.flush();
            out.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
//            return new ResponseAbac(true, e.getMessage(), "Something went wrong during the import process.");
        }
//        return new ResponseAbac(true, xml, "Import succesful!");
        return "{\"version\":\"0.0.1\",\"createTime\":1503299572754,\"publications\":[{\"publicationId\":1701,\"appliers\":[{\"benPubSubId\":11701,\"beneficiary\":{\"mayorId\":7251,\"treatment\":\"ms\",\"name\":\"e\",\"surname\":\"e\",\"email\":\"priscilla.p.barros@gmail.com\",\"legalEntity\":{\"legalEntityId\":7251,\"countryCode\":\"ES\",\"municipalityCode\":\"01022\",\"address\":\"e\",\"addressNum\":\"1\",\"postalCode\":\"122\"},\"user\":{\"userId\":7253,\"email\":\"priscilla.p.barros@gmail.com\",\"createDate\":1501834958000,\"userType\":2,\"userTypeId\":7252}},\"supplier\":false,\"status\":{\"budgetCommited\":false,\"budgedLinked\":false,\"approved\":false}}]}]}";
    }

    public String exportJson() {

        /*Lucia*/

        try {

//            // preparar el objeto a enviar
//
//            System.out.println("IN!");
//
//            LegalEntitySearchRequestType lesrt = new LegalEntitySearchRequestType();
//            MessageHeaderType mHType = new MessageHeaderType();
//            LegalEntitySearchCriteriaType searchCriteria = new LegalEntitySearchCriteriaType();
//            TextCriterionType txtCriterionType = new TextCriterionType();
//            DateCriterionType dateCriterionT = new DateCriterionType();
//            NumberCriterionType numCriterionT = new NumberCriterionType();
//            IndicatorCriterionType indicCriterionT = new IndicatorCriterionType();
//            OracleTextCriterionType oracleTxtCritT = new OracleTextCriterionType();
////            TextCriterionOperatorType txtCritOperT = new TextCriterionOperatorType();
////
////            txtCriterionType.setOperator(txtCritOperT);
////            txtCriterionType.setSort();
////            txtCriterionType.setValue();
////            txtCriterionType.setValue2();
//
//            searchCriteria.setRegistrationCountryCode(dateCriterionT);
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
//
//            LegalEntity le = new LegalEntity();
//            LegalEntitySearchResponseType leSearchResponse = le.getLegalEntitySOAP().search(lesrt);
//
//
//            // getters del response
//
//            System.out.println("row count: " + leSearchResponse.getRowCount());
//            leSearchResponse.getLegalEntitySearchChoiceGroup();
//
//            System.out.println("OK.");
//
//
//        /*End Lucia*/
//
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
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println(e.getMessage());
////            return new ResponseAbac(false, e.getMessage(), "Something went wrong during the export process.");
//            System.out.println("END DAVID CODE!");
//            return "{\"test\":\"" + e.getMessage() + "\",\"version\":\"0.0.1\",\"createTime\":1503299572754,\"publications\":[{\"publicationId\":1701,\"appliers\":[{\"benPubSubId\":11701,\"beneficiary\":{\"mayorId\":7251,\"treatment\":\"ms\",\"name\":\"e\",\"surname\":\"e\",\"email\":\"priscilla.p.barros@gmail.com\",\"legalEntity\":{\"legalEntityId\":7251,\"countryCode\":\"ES\",\"municipalityCode\":\"01022\",\"address\":\"e\",\"addressNum\":\"1\",\"postalCode\":\"122\"},\"user\":{\"userId\":7253,\"email\":\"priscilla.p.barros@gmail.com\",\"createDate\":1501834958000,\"userType\":2,\"userTypeId\":7252}},\"supplier\":false,\"status\":{\"budgetCommited\":false,\"budgedLinked\":false,\"approved\":false}}]}]}";
//
//        }
//
//    }
//
//    public boolean checkJsonFileFormat(JSONObject json) {
//        try {
//            boolean correct = true;
//            JSONArray publications = json.getJSONArray("publications");
//            for (int i = 0; i < publications.length(); i++) {
//                JSONObject publication = publications.getJSONObject(i);
//                JSONArray appliers = publication.getJSONArray("appliers");
//                for (int j = 0; j < appliers.length(); j++) {
//                    JSONObject applier = appliers.getJSONObject(j);
//                    if (!applier.has("benPubSubId") || !applier.has("beneficiary") || !applier.has("supplier") || !applier.has("status")) {
//                        correct = false;
//                    }
//                }
//            }
            return "correct";
        } catch (JSONException e) {
            return "error";
        }
    }

}

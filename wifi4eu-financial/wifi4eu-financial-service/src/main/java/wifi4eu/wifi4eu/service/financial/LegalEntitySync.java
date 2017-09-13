package wifi4eu.wifi4eu.service.financial;


import eu.europa.ec.budg.abac.legal_entity.service.es.sync.v2.FaultMessage;
import eu.europa.ec.budg.abac.legal_entity.service.es.sync.v2.LegalEntity;
import eu.europa.ec.budg.abac.legal_entity.v2.LegalEntitySearchCriteriaType;
import eu.europa.ec.budg.abac.legal_entity.v2.LegalEntitySearchRequestType;
import eu.europa.ec.budg.abac.legal_entity.v2.LegalEntitySearchResponseType;
import eu.europa.ec.budg.abac.message.v1.MessageHeaderType;
import eu.europa.ec.budg.abac.search_criterion.v1.*;
import org.json.JSONException;


import java.io.IOException;

public class LegalEntitySync {

    public static String leSearch() throws IOException {
        try {

//         SEARCH SERVICE LEGAL ENTITY

            LegalEntity le = new LegalEntity();

            LegalEntitySearchRequestType lesrt = new LegalEntitySearchRequestType();


            LegalEntitySearchResponseType leSearchResponse = le.getLegalEntitySOAP().search(lesrt);

            System.out.println("LEGAL ENTITY SYNC :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::>");
            System.out.println("ROW COUNT ---------------------------------------> " + leSearchResponse.getRowCount());

            return "true";
        } catch (FaultMessage faultMessage) {
            faultMessage.printStackTrace();
        }
        return "false";
    }
}


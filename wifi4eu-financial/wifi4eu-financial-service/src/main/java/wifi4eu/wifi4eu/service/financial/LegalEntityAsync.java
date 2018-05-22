package wifi4eu.wifi4eu.service.financial;

import eu.europa.ec.budg.abac.ares_document.v1.AresDocumentsType;
import eu.europa.ec.budg.abac.legal_entity.service.es.sync.v2.LegalEntity;
import eu.europa.ec.budg.abac.legal_entity.v2.*;
import eu.europa.ec.budg.abac.message.v1.BusinessRuleMessageResponseType;
import eu.europa.ec.budg.abac.messagefault.v1.FaultMessage;
import eu.europa.ec.budg.abac.workflow.v1.VisaType;

import java.io.IOException;
import java.math.BigInteger;

public class LegalEntityAsync {

    public static String leCreate() throws IOException {
//        try {
//
//            LegalEntityCreateRequestType lecrt = new LegalEntityCreateRequestType();
//
//
//            eu.europa.ec.budg.abac.legal_entity.service.es.async.v1.LegalEntity leAsync = new eu.europa.ec.budg.abac.legal_entity.service.es.async.v1.LegalEntity();
//
//
//            BusinessRuleMessageResponseType bRMRT = leAsync.getLegalEntitySOAP().create(lecrt);
//            System.out.println("LEGAL ENTITY ASYNC:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::>");
//            System.out.println("PRINTING BUSINES RULE REJECTION RETURN CODE ------------------------------------------" + bRMRT.getBusinessRuleRejectionReturnCode());
//
//
//            return "true";
//        } catch (FaultMessage faultMessage) {
//            faultMessage.printStackTrace();
//        }
        return "false";
    }
}

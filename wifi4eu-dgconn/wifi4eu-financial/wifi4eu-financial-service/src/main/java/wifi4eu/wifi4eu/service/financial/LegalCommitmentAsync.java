package wifi4eu.wifi4eu.service.financial;


import eu.europa.ec.budg.abac.legal_commitment.service.es.async.v1.LegalCommitment;
import eu.europa.ec.budg.abac.legal_commitment.v1.LegalCommitmentCreateBaseRequestType;
import eu.europa.ec.budg.abac.message.v1.BusinessRuleMessageResponseType;
import eu.europa.ec.budg.abac.messagefault.v1.FaultMessage;

import java.io.IOException;

public class LegalCommitmentAsync {

    public static String lcCreate() throws IOException {
        try {

            LegalCommitment leAsync = new LegalCommitment();


            LegalCommitmentCreateBaseRequestType lccbrt = new LegalCommitmentCreateBaseRequestType();

            BusinessRuleMessageResponseType bRMRT = leAsync.getLegalCommitment().createBase(lccbrt);
            System.out.println("LEGAL COMMITMENT ASYNC:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::>");
            System.out.println("PRINTING BUSINES RULE REJECTION RETURN CODE ------------------------------------------" + bRMRT.getBusinessRuleRejectionReturnCode());


            return "true";
        } catch (FaultMessage faultMessage) {
            faultMessage.printStackTrace();
        }
        return "false";
    }
}

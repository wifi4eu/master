package wifi4eu.wifi4eu.service.financial;

import eu.europa.ec.budg.abac.budgetary_commitment_level2.service.es.async.v1.BudgetaryCommitmentLevel2;
import eu.europa.ec.budg.abac.budgetary_commitment_level2.v1.BudgetaryCommitmentLevel2CreateRequestType;
import eu.europa.ec.budg.abac.message.v1.BusinessRuleMessageResponseType;
import eu.europa.ec.budg.abac.messagefault.v1.FaultMessage;

import java.io.IOException;

public class BudgetaryCommitmentAsync {


    public static String bcCreate() throws IOException {
        try {

            BudgetaryCommitmentLevel2 bc2 = new BudgetaryCommitmentLevel2();

            BudgetaryCommitmentLevel2CreateRequestType bccrt = new BudgetaryCommitmentLevel2CreateRequestType();

            BusinessRuleMessageResponseType brmrtbc = bc2.getBudgetaryCommitmentLevel2SOAP().create(bccrt);

            System.out.println("BUDGETARY COMMITMENT ASYNC :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::>");
            System.out.println("PRINTING BUSINES RULE REJECTION RETURN CODE ------------------------------------------" + brmrtbc.getBusinessRuleRejectionReturnCode());

            return "true";
        } catch (FaultMessage faultMessage) {
            faultMessage.printStackTrace();
        }
        return "false";
    }
}

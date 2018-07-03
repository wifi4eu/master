package wifi4eu.wifi4eu.service.financial;

import eu.europa.ec.budg.abac.budgetary_commitment_level1.service.es.sync.v1.BudgetaryCommitmentLevel1;
import eu.europa.ec.budg.abac.budgetary_commitment_level1.v1.BudgetaryCommitmentLevel1SearchRequestType;
import eu.europa.ec.budg.abac.budgetary_commitment_level1.v1.BudgetaryCommitmentLevel1SearchResponseType;
import eu.europa.ec.budg.abac.messagefault.v1.FaultMessage;


import java.io.IOException;

public class BudgetaryCommitmentSync {

    public static String bcSearch() throws IOException {
        try {

            //SEARCH SERVICE BUDGETARY COMMITMENT


            BudgetaryCommitmentLevel1 bc = new BudgetaryCommitmentLevel1();

            BudgetaryCommitmentLevel1SearchRequestType bcl1srt = new BudgetaryCommitmentLevel1SearchRequestType();


            BudgetaryCommitmentLevel1SearchResponseType bcsr = bc.getBudgetaryCommitmentLevel1SOAP().search(bcl1srt);

            System.out.println("BUDGETARY COMMITMENT SYNC :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::>");
            System.out.println("PRINTING FULL ROW COUNT ----------------> " + bcsr.getFullRowCount());


            return "true";
        } catch (FaultMessage faultMessage) {
            faultMessage.printStackTrace();
        }
        return "false";
    }
}
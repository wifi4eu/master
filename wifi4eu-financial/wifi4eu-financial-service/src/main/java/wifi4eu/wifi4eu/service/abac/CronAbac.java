package wifi4eu.wifi4eu.service.abac;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.service.financial.BudgetaryCommitmentAsync;
import wifi4eu.wifi4eu.service.financial.BudgetaryCommitmentSync;
import wifi4eu.wifi4eu.service.financial.LegalEntityAsync;
import wifi4eu.wifi4eu.service.financial.LegalEntitySync;

import java.io.IOException;
import java.util.Date;

@Component
@EnableScheduling
public class CronAbac {

    @Scheduled(cron = "*/10 * * * * ?")
    public void abacService() {
        try {
            BudgetaryCommitmentSync.bcSearch();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "*/10 * * * * ?")
    public void abacService2() {
        try {
            LegalEntitySync.leSearch();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "*/10 * * * * ?")
    public void abacService3() {
        try {
            BudgetaryCommitmentAsync.bcCreate();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "*/10 * * * * ?")
    public void abacService4() {
        try {
            LegalEntityAsync.leCreate();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}







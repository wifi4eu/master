package wifi4eu.wifi4eu.util.reporting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.cns.CNSManager;
import wifi4eu.wifi4eu.common.helper.BeanUtil;
import wifi4eu.wifi4eu.common.helper.Validator;

import java.util.Locale;

@Configurable
public class ExcelReportsRunnable implements Runnable {


    private static final Logger logger = LoggerFactory.getLogger(ExcelReportsRunnable.class);

    CNSManager cnsManager;
    ReportingSystemManager reportingSystemManager;
    String currentQuery;
    String name;
    String email;
    String lang;
    String urlFinal;

    public ExcelReportsRunnable(String currentQuery, String name, String email, String lang){
        this.currentQuery = currentQuery;
        this.name = name;
        this.email = email;
        this.lang = lang;
        this.reportingSystemManager = BeanUtil.getBean(ReportingSystemManager.class);
        this.cnsManager = BeanUtil.getBean(CNSManager.class);
        // this.cnsManager = cnsManager;
        // this.nutsRepository = nutsRepository;
    }

    public ExcelReportsRunnable(){

    }

    @Override
    public void run(){
        System.out.println("Hello from a thread! numberQuery : "+currentQuery);
        this.urlFinal = reportingSystemManager.generateReportingExcel(currentQuery);
        sendEmailWithUrl();
    }

    private void sendEmailWithUrl(){
        logger.info("Send Email With Url");
        if (Validator.isNotNull(urlFinal)) {
            logger.info("email => " + email + " name => " + name + " urlFinal => " + urlFinal + " lang => " + lang);
            if (!email.isEmpty() && !name.isEmpty() && !urlFinal.isEmpty()) {
                Locale locale = new Locale(Constant.REPORTING_DEFAULT_LANG);
                String lang = this.lang;
                if(Validator.isNotNull(lang)){
                    locale = new Locale(lang);
                }
                cnsManager.sendReportingSystemCallOpen(email, name, urlFinal, locale);
            }
        } else {
            System.out.println("URL not generated correctly");
        }
    }

}

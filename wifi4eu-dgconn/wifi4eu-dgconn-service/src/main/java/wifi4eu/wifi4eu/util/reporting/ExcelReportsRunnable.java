package wifi4eu.wifi4eu.util.reporting;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;

import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.dto.mail.MailData;
import wifi4eu.wifi4eu.common.helper.BeanUtil;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.mail.MailHelper;
import wifi4eu.wifi4eu.common.service.mail.MailService;

@Configurable
public class ExcelReportsRunnable implements Runnable {


    private static final Logger logger = LoggerFactory.getLogger(ExcelReportsRunnable.class);

    MailService mailService;
    ReportingSystemManager reportingSystemManager;

    String currentQuery;
    String name;
    String email;
    String lang;
    String urlFinal;
    Integer callId;

    public ExcelReportsRunnable(String currentQuery, String name, String email, String lang) {
        this.currentQuery = currentQuery;
        this.name = name;
        this.email = email;
        this.lang = lang;
        this.reportingSystemManager = BeanUtil.getBean(ReportingSystemManager.class);
        this.mailService = BeanUtil.getBean(MailService.class);
    }

    public ExcelReportsRunnable(String currentQuery, String name, String email, String lang, Integer callId) {
        this.currentQuery = currentQuery;
        this.name = name;
        this.email = email;
        this.lang = lang;
        this.callId = callId;
        this.reportingSystemManager = BeanUtil.getBean(ReportingSystemManager.class);
        this.mailService = BeanUtil.getBean(MailService.class);
    }

    public ExcelReportsRunnable() {

    }

    @Override
    public void run() {
        // System.out.println("Hello from a thread! numberQuery : "+currentQuery);
        if (Validator.isNotNull(callId)) {
            this.urlFinal = reportingSystemManager.generateReportingExcel(currentQuery, callId);
        } else {
            this.urlFinal = reportingSystemManager.generateReportingExcel(currentQuery);
        }
        sendEmailWithUrl();
    }

    private void sendEmailWithUrl() {
        logger.debug("Send Email With Url");
        if (Validator.isNotNull(urlFinal)) {
            logger.debug("email => " + email + " name => " + name + " urlFinal => " + urlFinal + " lang => " + lang);
            if (!email.isEmpty() && !name.isEmpty() && !urlFinal.isEmpty()) {
                Locale locale = new Locale(Constant.REPORTING_DEFAULT_LANG);
                String lang = this.lang;
                if (Validator.isNotNull(lang)) {
                    locale = new Locale(lang);
                }

                MailData mailData = MailHelper.buildMailReportingSystemCallOpen(email, name, urlFinal, locale);
                mailService.sendMail(mailData, true);
            }
        } else {
            logger.debug("URL not generated correctly");
        }
    }

}

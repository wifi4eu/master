package wifi4eu.wifi4eu.util.reporting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.common.Constant;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Configurable
@Component
public class GenerateReports {

    @Autowired
    ReportingUtils reportingUtils;

    private final Logger _log = LogManager.getLogger(GenerateReports.class);

    public byte[] generateExcelFileBytes(String currentQuery) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        switch (currentQuery){

            case Constant.REPORTING_CALL_OPEN:
                reportingUtils.generateCallOpenReporting(workbook);
                break;

            case Constant.REPORTING_TIME_TO_INFORM:
                reportingUtils.generateTimeToInformReporting(workbook);
                break;

            case Constant.REPORTING_TYPES_INSTALLATION_REPORT:
                reportingUtils.generateTypesInstallationReport(workbook);
                break;

            default:
                break;
        }

        _log.info("Your excel file has been generated!");
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            workbook.write(bos);
            return bos.toByteArray();
        } finally {
            workbook.close();
        }
    }

    public byte[] generateExcelFileBytes(String currentQuery, Integer callId) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        switch (currentQuery){

            case Constant.REPORTING_PRE_SELECTION:
                reportingUtils.generatePreSelectionReporting(workbook, callId);
                break;

            case Constant.REPORTING_NOTIFICATIONS_SENT_OUT:
                reportingUtils.generateNotificationsSentOutReporting(workbook, callId);
                break;

            default:
                break;
        }

        _log.info("Your excel file has been generated!");
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            workbook.write(bos);
            return bos.toByteArray();
        } finally {
            workbook.close();
        }
    }

}

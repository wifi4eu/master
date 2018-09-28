package wifi4eu.wifi4eu.util.reporting;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.util.reports.*;

import java.util.Iterator;

@Component
public class ReportingUtils {

    @Autowired
    ReportTypesInstallation reportTypesInstallation;

    @Autowired
    ReportCallOpen reportCallOpen;

    @Autowired
    ReportPreSelection reportPreSelection;

    @Autowired
    ReportNotificationsSentOut reportNotificationsSentOut;
/*
    @Autowired
    ReportTimeToInform reportTimeToInform;*/

    public void generateTypesInstallationReport(HSSFWorkbook workbook) {
        reportTypesInstallation.generate(workbook);
    }

    public void generateCallOpenReporting(HSSFWorkbook workbook) {
        reportCallOpen.generate(workbook);
    }

    public void generatePreSelectionReporting(HSSFWorkbook workbook, Integer callId) {
        reportPreSelection.generate(workbook, callId);
    }

    public void generateNotificationsSentOutReporting(HSSFWorkbook workbook, Integer callId) {
        reportNotificationsSentOut.generate(workbook, callId);
    }

    /*public void generateTimeToInformReporting(HSSFWorkbook workbook) {
        reportTimeToInform.generate(workbook);
    }*/

    public static void autoSizeColumns(HSSFWorkbook workbook) {
        int numberOfSheets = workbook.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            HSSFSheet sheet = workbook.getSheetAt(i);
            if (sheet.getPhysicalNumberOfRows() > 0) {
                HSSFRow row = sheet.getRow(0);
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    int columnIndex = cell.getColumnIndex();
                    sheet.autoSizeColumn(columnIndex);
                }
            }
        }
    }
}


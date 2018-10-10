package wifi4eu.wifi4eu.util.reporting;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.util.reports.ReportCallOpen;
import wifi4eu.wifi4eu.util.reports.ReportTypesInstallation;

import java.util.Iterator;

@Component
public class ReportingUtils {

    @Autowired
    private ReportTypesInstallation reportTypesInstallation;

    @Autowired
    private ReportCallOpen reportCallOpen;

    public void generateTypesInstallationReport(HSSFWorkbook workbook) {
        reportTypesInstallation.generate(workbook);
    }

    public void generateCallOpenReporting(HSSFWorkbook workbook) {
        reportCallOpen.generate(workbook);
    }

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


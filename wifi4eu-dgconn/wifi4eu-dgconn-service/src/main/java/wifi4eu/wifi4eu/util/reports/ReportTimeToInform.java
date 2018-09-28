package wifi4eu.wifi4eu.util.reports;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.util.reporting.ReportingUtils;

@Component
public class ReportTimeToInform {

    static String[] fields = {"Number of days between the closure of the call until button Send notifications to all applicants is pressed", "Number of applicants"};
    static String[] totalValues = {"daysNumber", "applicants"};

   /* public void generate(HSSFWorkbook workbook) {
        if (Validator.isNotNull(callRepository.getIdCurrentCall())) {
            HSSFSheet sheet = workbook.createSheet("State of play Report");
            int numColumn = 0;
            HSSFRow firstRow = sheet.createRow((short) numColumn);
            firstRow.createCell(0).setCellValue(callRepository.getNameCurrentCall());
            firstRow.createCell(1).setCellValue("Total");
            firstRow.createCell(2).setCellValue("%");
            numColumn++;
            HSSFRow row;
            for (int i = numColumn; i <= fields.length; i++) {
                row = sheet.createRow((short) i);
                row.createCell(0).setCellValue(fields[i - 1]);
            }
            generateTotalValues(sheet, 0);
            generateTotalPercentValues(sheet, 0);
            putCountriesCallOpen(sheet, firstRow, 3);
            ReportingUtils.autoSizeColumns(workbook);
        } else {
            // send email notifying that no open call is available?
            System.out.println("No call open found");
        }
    }*/

}

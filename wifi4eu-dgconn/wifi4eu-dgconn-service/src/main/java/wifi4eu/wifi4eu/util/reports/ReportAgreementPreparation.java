package wifi4eu.wifi4eu.util.reports;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.repository.call.CallRepository;
import wifi4eu.wifi4eu.util.reporting.ReportingUtils;

import java.util.HashMap;
import java.util.Map;

@Component
public class ReportAgreementPreparation {

    @Autowired
    CallRepository callRepository;

    static String[] fields = {"Max number of GA to be signed according to the selection Decision", "Number of GA signed by beneficiaries (1st signature only)", "Number of remaining GA to be signed by beneficiaries", "Number of GA counter-signed by INEA", "Number of GA counter signed from the reserve list", "Number of remaining GA to be counter-signed by INEA"};
    static String[] totalValues = {"maxNumber", "signedGA", "remainingGA", "counterSignedGA", "counterFromReserve", "remainingCounterSigned"};

    public void generate(HSSFWorkbook workbook, Integer callId) {
        if (Validator.isNotNull(callRepository.findAllCallsClosedNotified())) {
            HSSFSheet sheet = workbook.createSheet("Grant agreement preparation");
            int numColumn = 0;
            HSSFRow firstRow = sheet.createRow((short) numColumn);
            firstRow.createCell(0).setCellValue(callRepository.findOne(callId).getEvent());
            firstRow.createCell(1).setCellValue("Total");
            firstRow.createCell(2).setCellValue("%");
            numColumn++;
            HSSFRow row;
            for (int i = numColumn; i <= fields.length; i++) {
                row = sheet.createRow((short) i);
                row.createCell(0).setCellValue(fields[i - 1]);
            }
            generateTotalValues(sheet, callId, 0);
            ReportingUtils.autoSizeColumns(workbook);
        } else {
            // send email notifying that no closed calls available?
            System.out.println("No call found");
        }
    }

    private void generateTotalValues(HSSFSheet sheet, Integer callId, Integer idNut){
        int column = 1;
        Map<String, Object> allValues = getAllValues(callId, idNut);
    }

    @Transactional
    private Map<String, Object> getAllValues(Integer callId, Integer idNut){
        Map<String, Object> mapResult = new HashMap<>();
        Integer maxNumber = getMaxNumber(callId, idNut);
        Integer signedGA;
        Integer remainingGA;
        Integer counterSignedGA;
        Integer counterFromReserve;
        Integer remainingCounterSigned;
        mapResult.put("maxNumber", maxNumber);
        mapResult.put("signedGA", signedGA);
        mapResult.put("remainingGA", remainingGA);
        mapResult.put("counterSignedGA", counterSignedGA);
        mapResult.put("counterFromReserve", counterFromReserve);
        mapResult.put("remainingCounterSigned", remainingCounterSigned);
        return mapResult;
    }

    @Transactional
    private Integer getMaxNumber(Integer callId, Integer idNut){
        if(idNut != 0){
            return 
        }else{
            return
        }
    }

}

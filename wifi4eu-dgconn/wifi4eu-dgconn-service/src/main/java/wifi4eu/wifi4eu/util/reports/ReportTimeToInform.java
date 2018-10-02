package wifi4eu.wifi4eu.util.reports;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.CallDTO;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.utils.Utils;
import wifi4eu.wifi4eu.entity.location.NutCallCustom;
import wifi4eu.wifi4eu.mapper.call.CallMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.call.CallRepository;
import wifi4eu.wifi4eu.util.reporting.ReportingUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ReportTimeToInform {

    @Autowired
    CallRepository callRepository;

    @Autowired
    CallMapper callMapper;

    @Autowired
    ApplicationRepository applicationRepository;

    static String[] fields = {"Number of days between the closure of the call until button Send notifications to all applicants is pressed", "Number of applicants"};
    static String[] totalValues = {"daysNumber", "applicants"};
    List<Integer> averageNumbers = null;
    List<Integer> weightedValues = null;

    public void generate(HSSFWorkbook workbook) {
        if (Validator.isNotNull(callRepository.findAllCallsClosed())) {
            HSSFSheet sheet = workbook.createSheet("State of play Report");
            int numColumn = 0;
            Integer callsClosedNum = callRepository.countCallsClosed();
            List<CallDTO> calls = callMapper.toDTOList(callRepository.findAllCallsClosed());
            HSSFRow firstRow = sheet.createRow((short) numColumn);
            firstRow.createCell(0).setCellValue("");
            for (CallDTO call : calls) {
                numColumn++;
                firstRow.createCell(numColumn).setCellValue(call.getEvent());
            }
            firstRow.createCell(callsClosedNum + 1).setCellValue("Average");
            firstRow.createCell(callsClosedNum + 2).setCellValue("Weighted average");
            numColumn = 1;
            HSSFRow row;
            for (int i = numColumn; i <= fields.length; i++) {
                row = sheet.createRow((short) i);
                row.createCell(0).setCellValue(fields[i - 1]);
            }
            generateValuesByCall(sheet, firstRow, 1);
            generateAverage(sheet, callsClosedNum +1);
            generateWeightedAverage(sheet, callsClosedNum +2);
            ReportingUtils.autoSizeColumns(workbook);
        } else {
            // send email notifying that no open call is available?
            System.out.println("No calls found");
        }
    }

    private void generateValuesByCall(HSSFSheet sheet, HSSFRow row, Integer numColumn){
        List<CallDTO> calls = callMapper.toDTOList(callRepository.findAllCallsClosed());
        HSSFRow initialRow = row;
        int[] passedCalls = new int[calls.size()];
        int a = 0;
        for(CallDTO call: calls){
            if(!Utils.contains(passedCalls, call.getId())){
                row.createCell(numColumn).setCellValue(call.getEvent());
                Map<String, Object> allValues = getAllValues(call.getId());
                String[] callValues ={"daysNumber", "applicants"};
                int takeNumber = 0;
                for(int i = 1; i <= totalValues.length; i++){
                    row = sheet.getRow(i);
                    String valueSet = "" + allValues.get(callValues[takeNumber]);
                    row.createCell(numColumn).setCellValue(valueSet);
                    takeNumber++;
                }
                numColumn++;
                row = initialRow;
                passedCalls[a] = call.getId();
                a++;
            }
        }
    }


    private void generateAverage(HSSFSheet sheet, Integer numColumn) {
        
    }

    private void generateWeightedAverage(HSSFSheet sheet, Integer numColumn) {

    }

    @Transactional
    private Map<String, Object> getAllValues(Integer callId) {
        Map<String, Object> mapResult = new HashMap<>();
        Integer daysNumber = getDaysNumberByCall(callId);
        Integer applicants = getApplicantsByCall(callId);
        mapResult.put("daysNumber", daysNumber);
        mapResult.put("applicants", applicants);
        return mapResult;
    }

    @Transactional
    private Integer getDaysNumberByCall(Integer callId) {
        Integer res = applicationRepository.findDaysBetweenCloseAndNotified(callId);
        averageNumbers.add(res);
        return res;
    }

    @Transactional
    private Integer getApplicantsByCall(Integer callId) {
        Integer res = Integer.valueOf(applicationRepository.countApplicationsForCallId(callId).intValue());
        weightedValues.add(res);
        return res;
    }


}

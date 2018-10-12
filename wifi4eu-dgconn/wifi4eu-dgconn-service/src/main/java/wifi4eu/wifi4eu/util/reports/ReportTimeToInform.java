package wifi4eu.wifi4eu.util.reports;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import java.text.DecimalFormat;
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

    public void generate(HSSFWorkbook workbook) {
        if (Validator.isNotNull(callRepository.findAllCallsClosedNotified())) {
            HSSFSheet sheet = workbook.createSheet("Time to Inform report");
            int numColumn = 0;
            Integer callsClosedNum = callRepository.countCallsClosedNotified();
            List<CallDTO> calls = callMapper.toDTOList(callRepository.findAllCallsClosedNotified());
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
            generateAverage(sheet, callsClosedNum + 1);
            generateWeightedAverage(sheet, callsClosedNum + 2);
            ReportingUtils.autoSizeColumns(workbook);
        } else {
            // send email notifying that no open call is available?
            System.out.println("No calls notified found");
        }
    }

    private void generateValuesByCall(HSSFSheet sheet, HSSFRow row, Integer numColumn) {
        List<CallDTO> calls = callMapper.toDTOList(callRepository.findAllCallsClosedNotified());
        HSSFRow initialRow = row;
        int[] passedCalls = new int[calls.size()];
        int a = 0;
        for (CallDTO call : calls) {
            if (!Utils.contains(passedCalls, call.getId())) {
                row.createCell(numColumn).setCellValue(call.getEvent());
                Map<String, Object> allValues = getAllValues(call.getId());
                String[] callValues = {"daysNumber", "applicants"};
                int takeNumber = 0;
                for (int i = 1; i <= totalValues.length; i++) {
                    row = sheet.getRow(i);
                    DecimalFormat df = new DecimalFormat("#.##");
                    String valueSet = "" + df.format(allValues.get(callValues[takeNumber]));
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

    private void generateAverage(HSSFSheet sheet, Integer column) {
        double average = 0;
        HSSFRow row = sheet.getRow(1);
        List<CallDTO> calls = callMapper.toDTOList(callRepository.findAllCallsClosedNotified());
        for (CallDTO call : calls) {
            average += applicationRepository.findDaysBetweenCloseAndNotified(call.getId());
        }
        average = average / calls.size();
        if (Validator.isNull(average)) average = 0;
        DecimalFormat df = new DecimalFormat("#.##");
        String valueSet = "" + df.format(average);
        row.createCell(column).setCellValue(valueSet);
        row.createCell(column +1).setCellValue("-");
    }

    private void generateWeightedAverage(HSSFSheet sheet, Integer column) {
        double weightedAverage = 0;
        double totalNotified = applicationRepository.countApplicationsNotified();
        HSSFRow row = sheet.getRow(2);
        List<CallDTO> calls = callMapper.toDTOList(callRepository.findAllCallsClosedNotified());
        for (CallDTO call : calls) {
            int res = applicationRepository.countApplicationsForCallId(call.getId()).intValue();
            weightedAverage += res * (res/totalNotified);
        }
        weightedAverage = weightedAverage / calls.size();
        if (Validator.isNull(weightedAverage)) weightedAverage = 0;
        DecimalFormat df = new DecimalFormat("#.##");
        String valueSet = "" + df.format(weightedAverage);
        row.createCell(column).setCellValue(valueSet);
        row.createCell(column -1).setCellValue("-");
    }

    @Transactional
    private Map<String, Object> getAllValues(Integer callId) {
        Map<String, Object> mapResult = new HashMap<>();
        double daysNumber = getDaysNumberByCall(callId);
        Integer applicants = getApplicantsByCall(callId);
        mapResult.put("daysNumber", daysNumber);
        mapResult.put("applicants", applicants);
        return mapResult;
    }

    @Transactional
    private double getDaysNumberByCall(Integer callId) {
        return applicationRepository.findDaysBetweenCloseAndNotified(callId);
    }

    @Transactional
    private Integer getApplicantsByCall(Integer callId) {
        return applicationRepository.countApplicationsForCallId(callId).intValue();
    }


}

package wifi4eu.wifi4eu.util.reports;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.CallDTO;
import wifi4eu.wifi4eu.common.enums.SelectionStatus;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.utils.Utils;
import wifi4eu.wifi4eu.mapper.call.CallMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.call.CallRepository;
import wifi4eu.wifi4eu.util.reporting.ReportingUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ReportTimeToGrant {

    @Autowired
    CallRepository callRepository;

    @Autowired
    CallMapper callMapper;

    @Autowired
    ApplicationRepository applicationRepository;

    static String[] fields = {"Average time for GA from the main list", "Average time for GA from the reserve list", "Average time per GA", "Total number of GA"};
    static String[] totalValues = {"averageMain", "averageReserve", "averageGA", "totalGA"};

    public void generate(HSSFWorkbook workbook) {
        if (Validator.isNotNull(callRepository.findAllCallsClosedNotified())) {
            HSSFSheet sheet = workbook.createSheet("Time to Grant report");
            int numColumn = 0;
            Integer callsClosedNum = callRepository.countCallsClosedNotified();
            List<CallDTO> calls = callMapper.toDTOList(callRepository.findAllCallsClosedNotified());
            HSSFRow firstRow = sheet.createRow((short) numColumn);
            firstRow.createCell(0).setCellValue("");
            for (CallDTO call : calls) {
                numColumn++;
                firstRow.createCell(numColumn).setCellValue(call.getEvent());
            }
            firstRow.createCell(callsClosedNum + 1).setCellValue("Overall average");
            firstRow.createCell(callsClosedNum + 2).setCellValue("Overall weighted average");
            numColumn = 1;
            HSSFRow row;
            for (int i = numColumn; i <= fields.length; i++) {
                row = sheet.createRow((short) i);
                row.createCell(0).setCellValue(fields[i - 1]);
            }
            generateValuesByCall(sheet, firstRow, 1);
            /*generateAverage(sheet, callsClosedNum + 1);
            generateWeightedAverage(sheet, callsClosedNum + 2);*/
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
                String[] callValues = {"averageMain", "averageReserve", "averageGA", "totalGA"};
                int takeNumber = 0;
                for (int i = 1; i <= totalValues.length; i++) {
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

    @Transactional
    private Map<String, Object> getAllValues(Integer callId) {
        Map<String, Object> mapResult = new HashMap<>();
        double averageMain = getDaysBetweenNotifiedAndSigned(callId, SelectionStatus.SELECTED.getValue());
        double averageReserve = getDaysBetweenNotifiedAndSigned(callId, SelectionStatus.RESERVE_LIST.getValue());
        Integer averageGA = getApplicantsByCall(callId);
        Integer totalGA = getApplicantsByCall(callId);
        mapResult.put("averageMain", averageMain);
        mapResult.put("averageReserve", averageReserve);
        mapResult.put("averageGA", averageGA);
        mapResult.put("totalGA", totalGA);
        return mapResult;
    }

    private double generateCallAverage(Integer callId, Integer status){
        double average = 0;
        CallDTO callDTO = callMapper.toDTO(callRepository.findOne(callId));




        return average;
    }

    @Transactional
    private double getDaysBetweenNotifiedAndSigned(Integer callId, Integer status){
        return applicationRepository.findDaysBetweenNotifiedAndSigned(callId, status);
    }

    @Transactional
    private Integer getApplicantsByCall(Integer callId) {
        return applicationRepository.countApplicationsForCallId(callId).intValue();
    }

}

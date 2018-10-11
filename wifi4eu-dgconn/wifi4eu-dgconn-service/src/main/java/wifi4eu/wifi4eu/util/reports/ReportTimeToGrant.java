package wifi4eu.wifi4eu.util.reports;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.dto.model.CallDTO;
import wifi4eu.wifi4eu.common.dto.model.GrantAgreementDTO;
import wifi4eu.wifi4eu.common.enums.SelectionStatus;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.utils.Utils;
import wifi4eu.wifi4eu.mapper.application.ApplicationMapper;
import wifi4eu.wifi4eu.mapper.call.CallMapper;
import wifi4eu.wifi4eu.mapper.grantAgreement.GrantAgreementMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.call.CallRepository;
import wifi4eu.wifi4eu.repository.grantAgreement.GrantAgreementRepository;
import wifi4eu.wifi4eu.util.reporting.ReportingUtils;

import java.text.DecimalFormat;
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

    @Autowired
    ApplicationMapper applicationMapper;

    @Autowired
    GrantAgreementRepository grantAgreementRepository;

    @Autowired
    GrantAgreementMapper grantAgreementMapper;

    Logger _log = LogManager.getLogger(ReportTimeToGrant.class);

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
            generateOverallAverage(sheet, callsClosedNum + 1);
            generateOverallWeightedAverage(sheet, callsClosedNum + 2);
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

    private void generateOverallAverage(HSSFSheet sheet, Integer numColumn) {
        Map<String, Object> allValues = getAllOverallAverage();
        HSSFRow row;
        String[] totalValues = {"averageMainAverage", "averageReserveAverage", "averageGAAverage", "totalGAAverage"};
        int takeNumber = 0;
        for (int i = 1; i <= totalValues.length; i++) {
            row = sheet.getRow(i);
            String valueSet = (String) allValues.get(totalValues[takeNumber]);
            if (Validator.isNull(valueSet)) valueSet = "0";
            row.createCell(numColumn).setCellValue(valueSet);
            takeNumber++;
        }
    }

    private void generateOverallWeightedAverage(HSSFSheet sheet, Integer numColumn) {
        Map<String, Object> allValues = getAllOverallWeightedAverage();
        _log.info("MapValues. " + allValues);
        HSSFRow row;
        String[] totalValues = {"averageMainWeightedAverage", "averageReserveWeightedAverage", "averageGAWeightedAverage", "totalGAWeightedAverage"};
        int takeNumber = 0;
        for (int i = 1; i <= totalValues.length; i++) {
            row = sheet.getRow(i);
            String valueSet = (String) allValues.get(totalValues[takeNumber]);
            _log.info(totalValues[takeNumber] + " - " + allValues.get(totalValues[takeNumber]));
            if (Validator.isNull(valueSet)) valueSet = "0";
            row.createCell(numColumn).setCellValue(valueSet);
            takeNumber++;
        }
    }

    @Transactional
    private Map<String, Object> getAllValues(Integer callId) {
        Map<String, Object> mapResult = new HashMap<>();
        double averageMain = generateCallAverage(callId, SelectionStatus.SELECTED.getValue());
        double averageReserve = generateCallAverage(callId, SelectionStatus.RESERVE_LIST.getValue());
        double averageGA = generateCallAverage(callId, 0);
        Integer totalGA = countApplicantsDoubleSignedByCall(callId);
        DecimalFormat df = new DecimalFormat("#.##");
        mapResult.put("averageMain", df.format(averageMain));
        mapResult.put("averageReserve", df.format(averageReserve));
        mapResult.put("averageGA", df.format(averageGA));
        mapResult.put("totalGA", df.format(totalGA));
        return mapResult;
    }

    @Transactional
    private Map<String, Object> getAllOverallAverage() {
        Map<String, Object> mapResult = new HashMap<>();
        List<CallDTO> calls = callMapper.toDTOList(callRepository.findAllCallsClosedNotified());
        double averageMain = 0;
        double averageReserve = 0;
        double averageGA = 0;
        Integer totalGA = applicationRepository.countAllApplicationsDoubleSigned();
        for (CallDTO call : calls) {
            averageMain += generateCallAverage(call.getId(), SelectionStatus.SELECTED.getValue());
            averageReserve += generateCallAverage(call.getId(), SelectionStatus.RESERVE_LIST.getValue());
            averageGA += generateCallAverage(call.getId(), 0);
        }
        if (Validator.isNull(averageMain)) averageMain = 0;
        if (Validator.isNull(averageReserve)) averageReserve = 0;
        if (Validator.isNull(averageGA)) averageGA = 0;
        DecimalFormat df = new DecimalFormat("#.##");
        mapResult.put("averageMainAverage", df.format(averageMain / calls.size()));
        mapResult.put("averageReserveAverage", df.format(averageReserve / calls.size()));
        mapResult.put("averageGAAverage", df.format(averageGA / calls.size()));
        mapResult.put("totalGAAverage", df.format(totalGA / calls.size()));
        return mapResult;
    }


    @Transactional
    private Map<String, Object> getAllOverallWeightedAverage() {
        Map<String, Object> mapResult = new HashMap<>();
        List<CallDTO> calls = callMapper.toDTOList(callRepository.findAllCallsClosedNotified());
        double averageMain = 0;
        double averageReserve = 0;
        double averageGA = 0;
        Integer totalGA = 0;
        Integer totalApplicationsDS = applicationRepository.countAllApplicationsDoubleSigned();
        for (CallDTO call : calls) {
            Integer totalGACall = countApplicantsDoubleSignedByCall(call.getId());
            Integer totalGACallSelected = applicationRepository.countGrantAgreementsCounterSignedReserved(call.getId());
            Integer totalGACallReserved = applicationRepository.countGrantAgreementsCounterSignedSelected(call.getId());
            if (totalApplicationsDS == 0) {
                averageMain += 0;
                averageReserve += 0;
                averageGA += 0;
            } else {
                averageMain += (generateCallAverage(call.getId(), SelectionStatus.SELECTED.getValue()) * (totalGACallSelected / totalApplicationsDS));
                averageReserve += (generateCallAverage(call.getId(), SelectionStatus.RESERVE_LIST.getValue()) * (totalGACallReserved / totalApplicationsDS));
                averageGA += (generateCallAverage(call.getId(), 0) * (totalGACall / totalApplicationsDS));
            }
        }
        DecimalFormat df = new DecimalFormat("#.##");
        mapResult.put("averageMainWeightedAverage", df.format(averageMain / calls.size()));
        mapResult.put("averageReserveWeightedAverage", df.format(averageReserve / calls.size()));
        mapResult.put("averageGAWeightedAverage", df.format(averageGA / calls.size()));
        mapResult.put("totalGAWeightedAverage", df.format(totalGA / calls.size()));
        return mapResult;
    }

    private double generateCallAverage(Integer callId, Integer status) {
        double average = 0;
        List<ApplicationDTO> applications;
        if (status != 0) {
            applications = applicationMapper.toDTOList(applicationRepository.findFilteredApplicationsDoubleSignedForCall(callId, status));
            if (Validator.isNotNull(applications)) {
                for (ApplicationDTO applicationDTO : applications) {
                    average += getDaysBetweenNotifiedAndSigned(callId, applicationDTO.getId());
                }
            }
        } else {
            applications = applicationMapper.toDTOList(applicationRepository.findAllApplicationsDoubleSignedForCall(callId));
            if (Validator.isNotNull(applications)) {
                for (ApplicationDTO applicationDTO : applications) {
                    average += getDaysBetweenNotifiedAndSigned(callId, applicationDTO.getId());
                }
            }
        }
        average = average / applications.size();
        if (Validator.isNull(average)) average = 0;
        return average;
    }


    @Transactional
    private double getDaysBetweenNotifiedAndSigned(Integer callId, Integer applicationId) {
        return applicationRepository.findDaysBetweenNotifiedAndSignedFiltered(callId, applicationId);
    }

    @Transactional
    private Integer countApplicantsDoubleSignedByCall(Integer callId) {
        return applicationRepository.countAllApplicationsDoubleSignedForCall(callId);
    }

}

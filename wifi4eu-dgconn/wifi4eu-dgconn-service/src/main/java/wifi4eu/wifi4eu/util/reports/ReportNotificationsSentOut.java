package wifi4eu.wifi4eu.util.reports;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.enums.SelectionStatus;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.utils.Utils;
import wifi4eu.wifi4eu.entity.location.NutCallCustom;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.call.CallRepository;
import wifi4eu.wifi4eu.repository.location.NutCallCustomRepository;
import wifi4eu.wifi4eu.util.reporting.ReportingUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class ReportNotificationsSentOut {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private CallRepository callRepository;

    @Autowired
    private NutCallCustomRepository nutCallCustomRepository;

    private static String[] fields = {"Number of applicants", "Number of pre-selected applicants", "Number of applicants in reserve list", "Number of unsuccessful applicants (not in the pre-selection list, not in the reserve list)", "Number of duplicates", "Number of duplicates invalidated", "Number of follow-up (supporting documents)", "Number of invalidated for reason 1: After the follow-up request, the applicant provided a document which was corrupt/impossible to open in the format supplied.", "Number of invalidated for reason 2: After the follow-up request, the applicant provided the same document(s) as originally supplied with the application.", "Number of invalidated for reason 3: After the follow-up request, the applicant provided a document which was unreadable.", "Number of invalidated for reason 4: After the follow-up request, the applicant provided a document which was incomplete", "Number of invalidated for reason 5: After the follow-up request, the applicant provided a document which was incorrect/did not correspond to the required document (or still contained incorrect information).", "Number of invalidated for reason 6: After the follow-up request, the applicant provided a document which was missing a signature.", "Number of invalidated for reason 7: The deadline for the request of correction of the required supporting documents passed without compliance by the applicant.", "Number of invalidated for reason 8: The application included a merged municipality.", "Number of invalidated for reason 9: Due to irregularities found in the application, it was invalidated."};
    private static String[] totalValues = {"applicants", "preSelectedApplicants", "reservedApplicants", "unsuccessfulApplicants", "duplicates", "duplicatesInvalidated", "followUp", "invalidatedReason1", "invalidatedReason2", "invalidatedReason3", "invalidatedReason4", "invalidatedReason5", "invalidatedReason6", "invalidatedReason7", "invalidatedReason8", "invalidatedReason9"};

    public void generate(HSSFWorkbook workbook, Integer callId) {
        if (Validator.isNotNull(callRepository.getIdCurrentCall())) {
            HSSFSheet sheet = workbook.createSheet("Status after notifications");
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
            generateTotalPercentValues(sheet, callId, 0);
            putCountriesByCall(sheet, firstRow, 3, callId);
            ReportingUtils.autoSizeColumns(workbook);
        } else {
            // send email notifying that no open call is available?
            System.out.println("No call found");
        }
    }

    private void generateTotalValues(HSSFSheet sheet, Integer callId, Integer idNut) {
        int column = 1;
        Map<String, Object> allValues = getAllValues(callId, idNut);
        HSSFRow row;
        int takeNumber = 0;
        for (int i = 1; i <= totalValues.length; i++) {
            row = sheet.getRow(i);
            String valueSet = allValues.get(totalValues[takeNumber]).toString();
            if (Validator.isNull(valueSet)) valueSet = "0";
            row.createCell(column).setCellValue(valueSet);
            takeNumber++;
        }
    }

    private void generateTotalPercentValues(HSSFSheet sheet, Integer callId, Integer idNut) {
        int column = 2;
        Map<String, Object> allValues = getAllPercentages(callId, idNut);
        HSSFRow row;
        String[] totalValues = {"applicantsPercent", "preSelectedApplicantsPercent", "reservedApplicantsPercent", "unsuccessfulApplicantsPercent", "duplicatesPercent", "duplicatesInvalidatedPercent", "followUpPercent", "invalidatedReason1Percent", "invalidatedReason2Percent", "invalidatedReason3Percent", "invalidatedReason4Percent", "invalidatedReason5Percent", "invalidatedReason6Percent", "invalidatedReason7Percent", "invalidatedReason8Percent", "invalidatedReason9Percent"};
        int takeNumber = 0;
        for (int i = 1; i <= totalValues.length; i++) {
            row = sheet.getRow(i);
            String valueSet = (String) allValues.get(totalValues[takeNumber]);
            if (Validator.isNull(valueSet)) valueSet = "0";
            row.createCell(column).setCellValue(valueSet);
            takeNumber++;
        }
    }

    private void putCountriesByCall(HSSFSheet sheet, HSSFRow row, int numColumn, Integer callId) {
        ArrayList<NutCallCustom> nuts = nutCallCustomRepository.findNutsAndCallNameByCall(callId);
        HSSFRow initialRow = row;
        int[] passedNuts = new int[nuts.size()];
        int a = 0;

        for (NutCallCustom nut : nuts) {
            if (!Utils.contains(passedNuts, nut.getId())) {
                row.createCell(numColumn).setCellValue(nut.getLabel());
                Map<String, Object> allValues = getAllValues(callId, nut.id);
                String[] totalValues = {"applicants", "preSelectedApplicants", "reservedApplicants", "unsuccessfulApplicants", "duplicates", "duplicatesInvalidated", "followUp", "invalidatedReason1", "invalidatedReason2", "invalidatedReason3", "invalidatedReason4", "invalidatedReason5", "invalidatedReason6", "invalidatedReason7", "invalidatedReason8", "invalidatedReason9"};
                int takeNumber = 0;
                for (int i = 1; i <= totalValues.length; i++) {
                    row = sheet.getRow(i);
                    String valueSet = "" + allValues.get(totalValues[takeNumber]);
                    row.createCell(numColumn).setCellValue(valueSet);
                    takeNumber++;
                }
                numColumn++;
                row = initialRow;
                passedNuts[a] = nut.getId();
                a++;
            }
        }
    }

    @Transactional
    private Map<String, Object> getAllValues(Integer callId, Integer idNut) {
        Map<String, Object> mapResult = new HashMap<>();
        Integer applicants = getAllApplicants(callId, idNut);
        Integer preselectedApplicants = getPreselectedApplicants(callId, idNut);
        Integer reservedApplicants = getReservedApplicants(callId, idNut);
        Integer unsuccessfulApplicants = getUnsuccessfulApplicants(callId, idNut);
        Integer duplicates = getDuplicates(callId, idNut);
        Integer duplicatesInvalidated = getDuplicatesInvalidated(callId, idNut);
        Integer followUp = getFollowUp(callId, idNut);
        Integer invalidatedReason1 = getInvalidatedReason(callId, idNut, 1);
        Integer invalidatedReason2 = getInvalidatedReason(callId, idNut, 2);
        Integer invalidatedReason3 = getInvalidatedReason(callId, idNut, 3);
        Integer invalidatedReason4 = getInvalidatedReason(callId, idNut, 4);
        Integer invalidatedReason5 = getInvalidatedReason(callId, idNut, 5);
        Integer invalidatedReason6 = getInvalidatedReason(callId, idNut, 6);
        Integer invalidatedReason7 = getInvalidatedReason(callId, idNut, 7);
        Integer invalidatedReason8 = getInvalidatedReason(callId, idNut, 8);
        Integer invalidatedReason9 = getInvalidatedReason(callId, idNut, 9);
        mapResult.put("applicants", applicants);
        mapResult.put("preSelectedApplicants", preselectedApplicants);
        mapResult.put("reservedApplicants", reservedApplicants);
        mapResult.put("unsuccessfulApplicants", unsuccessfulApplicants);
        mapResult.put("duplicates", duplicates);
        mapResult.put("duplicatesInvalidated", duplicatesInvalidated);
        mapResult.put("followUp", followUp);
        mapResult.put("invalidatedReason1", invalidatedReason1);
        mapResult.put("invalidatedReason2", invalidatedReason2);
        mapResult.put("invalidatedReason3", invalidatedReason3);
        mapResult.put("invalidatedReason4", invalidatedReason4);
        mapResult.put("invalidatedReason5", invalidatedReason5);
        mapResult.put("invalidatedReason6", invalidatedReason6);
        mapResult.put("invalidatedReason7", invalidatedReason7);
        mapResult.put("invalidatedReason8", invalidatedReason8);
        mapResult.put("invalidatedReason9", invalidatedReason9);
        return mapResult;
    }

    @Transactional
    private Map<String, Object> getAllPercentages(Integer callId, Integer idNut) {
        Map<String, Object> mapResult = new HashMap<>();
        Integer applicants = getAllApplicants(callId, idNut);
        Integer preselectedApplicants = getPreselectedApplicants(callId, idNut);
        Integer reservedApplicants = getReservedApplicants(callId, idNut);
        Integer unsuccessfulApplicants = getUnsuccessfulApplicants(callId, idNut);
        Integer duplicates = getDuplicates(callId, idNut);
        Integer duplicatesInvalidated = getDuplicatesInvalidated(callId, idNut);
        Integer followUp = getFollowUp(callId, idNut);
        Integer invalidatedReason1 = getInvalidatedReason(callId, idNut, 1);
        Integer invalidatedReason2 = getInvalidatedReason(callId, idNut, 2);
        Integer invalidatedReason3 = getInvalidatedReason(callId, idNut, 3);
        Integer invalidatedReason4 = getInvalidatedReason(callId, idNut, 4);
        Integer invalidatedReason5 = getInvalidatedReason(callId, idNut, 5);
        Integer invalidatedReason6 = getInvalidatedReason(callId, idNut, 6);
        Integer invalidatedReason7 = getInvalidatedReason(callId, idNut, 7);
        Integer invalidatedReason8 = getInvalidatedReason(callId, idNut, 8);
        Integer invalidatedReason9 = getInvalidatedReason(callId, idNut, 9);
        DecimalFormat df = new DecimalFormat("#.##");
        mapResult.put("applicantsPercent", df.format((applicants * 100.0f) / applicants));
        mapResult.put("preSelectedApplicantsPercent", df.format((preselectedApplicants * 100.0f) / applicants));
        mapResult.put("reservedApplicantsPercent", df.format((reservedApplicants * 100.0f) / applicants));
        mapResult.put("unsuccessfulApplicantsPercent", df.format((unsuccessfulApplicants * 100.0f) / applicants));
        mapResult.put("duplicatesPercent", df.format((duplicates * 100.0f) / applicants));
        mapResult.put("duplicatesInvalidatedPercent", df.format((duplicatesInvalidated * 100.0f) / applicants));
        mapResult.put("followUpPercent", df.format((followUp * 100.0f) / applicants));
        mapResult.put("invalidatedReason1Percent", df.format((invalidatedReason1 * 100.0f) / applicants));
        mapResult.put("invalidatedReason2Percent", df.format((invalidatedReason2 * 100.0f) / applicants));
        mapResult.put("invalidatedReason3Percent", df.format((invalidatedReason3 * 100.0f) / applicants));
        mapResult.put("invalidatedReason4Percent", df.format((invalidatedReason4 * 100.0f) / applicants));
        mapResult.put("invalidatedReason5Percent", df.format((invalidatedReason5 * 100.0f) / applicants));
        mapResult.put("invalidatedReason6Percent", df.format((invalidatedReason6 * 100.0f) / applicants));
        mapResult.put("invalidatedReason7Percent", df.format((invalidatedReason7 * 100.0f) / applicants));
        mapResult.put("invalidatedReason8Percent", df.format((invalidatedReason8 * 100.0f) / applicants));
        mapResult.put("invalidatedReason9Percent", df.format((invalidatedReason9 * 100.0f) / applicants));
        return mapResult;
    }

    @Transactional
    private Integer getAllApplicants(Integer callId, Integer idNut) {
        if (idNut != 0) {
            return applicationRepository.countApplicationsForSelectedCall(callId, idNut);
        } else {
            return applicationRepository.countApplicationsForSelectedCall(callId);
        }
    }

    @Transactional
    private Integer getPreselectedApplicants(Integer callId, Integer idNut) {
        if (idNut != 0) {
            return applicationRepository.countPreSelectedApplicationsByCall(callId, idNut);
        } else {
            return applicationRepository.countPreSelectedApplicationsByCall(callId);
        }
    }

    @Transactional
    private Integer getReservedApplicants(Integer callId, Integer idNut) {
        if (idNut != 0) {
            return applicationRepository.countApplicationsSelectedInVoucherAssignmentByCall(callId, idNut, SelectionStatus.RESERVE_LIST.getValue());
        } else {
            return applicationRepository.countApplicationsSelectedInVoucherAssignmentByCall(callId, SelectionStatus.RESERVE_LIST.getValue());
        }
    }

    @Transactional
    private Integer getUnsuccessfulApplicants(Integer callId, Integer idNut) {
        if (idNut != 0) {
            return applicationRepository.countUnsuccessfulApplicantsByCall(callId, idNut);
        } else {
            return applicationRepository.countUnsuccessfulApplicantsByCall(callId);
        }
    }

    @Transactional
    private Integer getDuplicates(Integer callId, Integer idNut) {
        if (idNut != 0) {
            return applicationRepository.countApplicationDuplicatesByCall(callId, idNut);
        } else {
            return applicationRepository.countApplicationDuplicatesByCall(callId);
        }
    }

    @Transactional
    private Integer getDuplicatesInvalidated(Integer callId, Integer idNut) {
        if (idNut != 0) {
            return applicationRepository.countApplicationDuplicatesInvalidatedByCall(callId, idNut);
        } else {
            return applicationRepository.countApplicationDuplicatesInvalidatedByCall(callId);
        }
    }

    @Transactional
    private Integer getFollowUp(Integer callId, Integer idNut) {
        if (idNut != 0) {
            return applicationRepository.countFollowUpApplicationsByCall(callId, idNut);
        } else {
            return applicationRepository.countFollowUpApplicationsByCall(callId);
        }
    }

    @Transactional
    private Integer getInvalidatedReason(Integer callId, Integer idNut, Integer reason) {
        if (idNut != 0) {
            return applicationRepository.countApplicationsInvalidatedByReasonAndCall(callId, idNut, reason);
        } else {
            return applicationRepository.countApplicationsInvalidatedByReasonAndCall(callId, reason);
        }
    }
}

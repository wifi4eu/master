package wifi4eu.wifi4eu.util.reports;

import com.google.common.collect.Lists;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.utils.Utils;
import wifi4eu.wifi4eu.entity.application.Application;
import wifi4eu.wifi4eu.entity.location.NutCallCustom;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.call.CallRepository;
import wifi4eu.wifi4eu.repository.location.NutCallCustomRepository;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.repository.warning.RegistrationWarningRepository;
import wifi4eu.wifi4eu.util.reporting.ReportingUtils;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ReportCallOpen {

    @Autowired
    CallRepository callRepository;

    @Autowired
    MunicipalityRepository municipalityRepository;

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    NutCallCustomRepository nutCallCustomRepository;

    @Autowired
    RegistrationWarningRepository registrationWarningRepository;

    private Integer idCurrentCall = 0,
            warningsType1 = 0,
            warningsType2 = 0,
            warningsType3 = 0,
            warning1Applicant = 0,
            warning2Applicant = 0,
            warning3Applicant = 0;

    static String[] fields = {"Number of applicants for the current call up to date", "Number of applicants with 1 warning (NO MATTER WHICH WARNING)", "Number of applicants with 2 warnings (NO MATTER WHICH WARNING)", "Number of applicants with 3 warnings (NO MATTER WHICH WARNING)", "Number of applicants with warning 1 (may have more than 1 warning)", "Number of applicants with warning 2 (may have more than 1 warning)", "Number of applicants with warning 3 (may have more than 1 warning)", "Number of duplicates", "Number of duplicates invalidated", "Number of invalidated for reason 1: After the follow-up request, the application provided a document which was corrupt/impossible to open in the format supplied", "Number of invalidated for reason 2: After the follow-up request, the applicant provided the same document(s) as originally supplied with the application", "Number of invalidated for reason 3: After the follow-up request, the applicant provided a document which was unreadable", "Number of invalidated for reason 4: After the follow-up request, the applicant provided a document which was incomplete", "Number of invalidated for reason 5: After the follow-up request, the applicant provided a document which was incorrect/did not correspond to the required document (or still contained incorrect information)", "Number of invalidated for reason 6: After the follow-up request, the applicant provided a document which was missing a signature", "Number of invalidated for reason 7: The deadline for the request of correction of the required supporting documents passed without compliance by the applicant", "Number of invalidated for reason 8: The application included a merged municipality","Number of invalidated for reason 9: Due to irregularities found in the application, it was invalidated"};
    static String[] totalValues = {"callApplicants", "warning1Applicant", "warning2Applicant", "warning3Applicant", "warningsType1", "warningsType2", "warningsType3", "numberDuplicates", "numberDuplicatesInvalidated", "reason1", "reason2", "reason3", "reason4", "reason5", "reason6", "reason7", "reason8", "reason9"};

    public void generate(HSSFWorkbook workbook) {
        if (Validator.isNotNull(callRepository.getIdCurrentCall())) {
            idCurrentCall = callRepository.getIdCurrentCall();
            HSSFSheet sheet = workbook.createSheet("State of play Report");
            int numColumn = 0;
            HSSFRow firstRow = sheet.createRow((short) numColumn);
            firstRow.createCell(0).setCellValue(callRepository.getNameByCallId(idCurrentCall));
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
    }

    private void putCountriesCallOpen(HSSFSheet sheet, HSSFRow row, int numColumn) {
        ArrayList<NutCallCustom> nuts = nutCallCustomRepository.findNutsByCall(idCurrentCall);
        HSSFRow intialRow = row;
        int[] passedNuts = new int[nuts.size()];
        int a = 0;
        for (NutCallCustom nut : nuts) {
            if (!Utils.contains(passedNuts, nut.getId())) {
                row.createCell(numColumn).setCellValue(nut.getLabel());
                Map<String, Object> allValues = getAllValues(nut.id);
                String[] totalValues = {"callApplicants", "warning1Applicant", "warning2Applicant", "warning3Applicant", "warningsType1", "warningsType2", "warningsType3", "numberDuplicates", "numberDuplicatesInvalidated", "reason1", "reason2", "reason3", "reason4", "reason5", "reason6", "reason7", "reason8", "reason9"};
                int takeNumber = 0;
                for (int i = 1; i <= totalValues.length; i++) {
                    row = sheet.getRow(i);
                    String valueSet = "" + allValues.get(totalValues[takeNumber]);
                    row.createCell(numColumn).setCellValue(valueSet);
                    takeNumber++;
                }
                numColumn++;
                row = intialRow;
                passedNuts[a] = nut.getId();
                a++;
            }
        }
    }

    private void generateTotalValues(HSSFSheet sheet, int idNut) {
        int column = 1;
        Map<String, Object> allValues = getAllValues(idNut);
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

    private void generateTotalPercentValues(HSSFSheet sheet, int idNut) {
        int column = 2;
        Map<String, Object> allValues = getAllPercentages(idNut);
        HSSFRow row;
        String[] totalValues = {"callApplicantsPercent", "warning1ApplicantPercent", "warning2ApplicantPercent", "warning3ApplicantPercent", "warningsType1Percent", "warningsType2Percent", "warningsType3Percent", "numberDuplicatesPercent", "numberDuplicatesInvalidatedPercent", "reason1Percent", "reason2Percent", "reason3Percent", "reason4Percent", "reason5Percent", "reason6Percent", "reason7Percent", "reason8Percent", "reason9Percent"};
        int takeNumber = 0;
        for (int i = 1; i <= totalValues.length; i++) {
            row = sheet.getRow(i);
            String valueSet = (String) allValues.get(totalValues[takeNumber]);
            if (Validator.isNull(valueSet)) valueSet = "0";
            row.createCell(column).setCellValue(valueSet);
            takeNumber++;
        }
    }

    @Transactional
    private boolean registrationHasWarning(Integer registrationId, Integer warningType) {
        boolean warning = false;
        if (Validator.isNotNull(registrationId) && Validator.isNotNull(warningType)) {
            warning = registrationWarningRepository.countByRegistrationAndWarning(registrationId,warningType) > 0;
        }
        return warning;
    }

    @Transactional
    private int getCountRegistrationWarnings(Integer registrationId) {
        int warnings = 0;
        if (Validator.isNotNull(registrationId)) {
            warnings = registrationWarningRepository.countByRegistration(registrationId);
        }
        return warnings;
    }

    @Transactional
    private Map<String, Object> getAllValues(int idNut) {
        Map<String, Object> mapResult = new HashMap<>();
        int callApplicants = getAllCallApplicants(idNut);
        // calculate warnings by type
        warningsType1 = 0;
        warningsType2 = 0;
        warningsType3 = 0;
        getWarningsByType(idNut);
        warning1Applicant = 0;
        warning2Applicant = 0;
        warning3Applicant = 0;
        // calculate how much applicants with warnings
        getApplicantsWithWarnings(idNut);
        int numberDuplicates = getNumberDuplicates(idNut);
        int numberDuplicatesInvalidated = getNumberDuplicatesInvalidated(idNut);
        int reason1 = getNumberInvalidatedByReason(1, idNut);
        int reason2 = getNumberInvalidatedByReason(2, idNut);
        int reason3 = getNumberInvalidatedByReason(3, idNut);
        int reason4 = getNumberInvalidatedByReason(4, idNut);
        int reason5 = getNumberInvalidatedByReason(5, idNut);
        int reason6 = getNumberInvalidatedByReason(6, idNut);
        int reason7 = getNumberInvalidatedByReason(7, idNut);
        int reason8 = getNumberInvalidatedByReason(8, idNut);
        int reason9 = getNumberInvalidatedByReason(9, idNut);
        mapResult.put("callApplicants", callApplicants);
        mapResult.put("warning1Applicant", warning1Applicant);
        mapResult.put("warning2Applicant", warning2Applicant);
        mapResult.put("warning3Applicant", warning3Applicant);
        mapResult.put("warningsType1", warningsType1);
        mapResult.put("warningsType2", warningsType2);
        mapResult.put("warningsType3", warningsType3);
        mapResult.put("numberDuplicates", numberDuplicates);
        mapResult.put("numberDuplicatesInvalidated", numberDuplicatesInvalidated);
        mapResult.put("reason1", reason1);
        mapResult.put("reason2", reason2);
        mapResult.put("reason3", reason3);
        mapResult.put("reason4", reason4);
        mapResult.put("reason5", reason5);
        mapResult.put("reason6", reason6);
        mapResult.put("reason7", reason7);
        mapResult.put("reason8", reason8);
        mapResult.put("reason9", reason9);
        return mapResult;
    }

    @Transactional
    private Map<String, Object> getAllPercentages(int idNut) {
        Map<String, Object> mapResult = new HashMap<>();
        int callApplicants = getAllCallApplicants(idNut);
        int callApplicantsInvalidated = getAllCallApplicantsInvalidated(idNut);
        int numberDuplicates = getNumberDuplicates(idNut);
        int numberDuplicatesInvalidated = getNumberDuplicatesInvalidated(idNut);
        int reason1 = getNumberInvalidatedByReason(1, idNut);
        int reason2 = getNumberInvalidatedByReason(2, idNut);
        int reason3 = getNumberInvalidatedByReason(3, idNut);
        int reason4 = getNumberInvalidatedByReason(4, idNut);
        int reason5 = getNumberInvalidatedByReason(5, idNut);
        int reason6 = getNumberInvalidatedByReason(6, idNut);
        int reason7 = getNumberInvalidatedByReason(7, idNut);
        int reason8 = getNumberInvalidatedByReason(8, idNut);
        int reason9 = getNumberInvalidatedByReason(9, idNut);
        DecimalFormat df = new DecimalFormat("#.##");
        mapResult.put("callApplicantsPercent", df.format((callApplicants * 100.0f) / callApplicants));
        mapResult.put("warning1ApplicantPercent", df.format((warning1Applicant * 100.0f) / callApplicants));
        mapResult.put("warning2ApplicantPercent", df.format((warning2Applicant * 100.0f) / callApplicants));
        mapResult.put("warning3ApplicantPercent", df.format((warning3Applicant * 100.0f) / callApplicants));
        mapResult.put("warningsType1Percent", df.format((warningsType1 * 100.0f) / callApplicants));
        mapResult.put("warningsType2Percent", df.format((warningsType2 * 100.0f) / callApplicants));
        mapResult.put("warningsType3Percent", df.format((warningsType3 * 100.0f) / callApplicants));
        mapResult.put("numberDuplicatesPercent", df.format((numberDuplicates * 100.0f) / callApplicants));
        mapResult.put("numberDuplicatesInvalidatedPercent", df.format((numberDuplicatesInvalidated * 100.0f) / callApplicants));
        if (callApplicantsInvalidated > 0){
            mapResult.put("reason1Percent", df.format((reason1 * 100.0f) / callApplicantsInvalidated));
            mapResult.put("reason2Percent", df.format((reason2 * 100.0f) / callApplicantsInvalidated));
            mapResult.put("reason3Percent", df.format((reason3 * 100.0f) / callApplicantsInvalidated));
            mapResult.put("reason4Percent", df.format((reason4 * 100.0f) / callApplicantsInvalidated));
            mapResult.put("reason5Percent", df.format((reason5 * 100.0f) / callApplicantsInvalidated));
            mapResult.put("reason6Percent", df.format((reason6 * 100.0f) / callApplicantsInvalidated));
            mapResult.put("reason7Percent", df.format((reason7 * 100.0f) / callApplicantsInvalidated));
            mapResult.put("reason8Percent", df.format((reason8 * 100.0f) / callApplicantsInvalidated));
            mapResult.put("reason9Percent", df.format((reason9 * 100.0f) / callApplicantsInvalidated));
        } else {
            mapResult.put("reason1Percent", df.format(0.00));
            mapResult.put("reason2Percent", df.format(0.00));
            mapResult.put("reason3Percent", df.format(0.00));
            mapResult.put("reason4Percent", df.format(0.00));
            mapResult.put("reason5Percent", df.format(0.00));
            mapResult.put("reason6Percent", df.format(0.00));
            mapResult.put("reason7Percent", df.format(0.00));
            mapResult.put("reason8Percent", df.format(0.00));
            mapResult.put("reason9Percent", df.format(0.00));
        }
        return mapResult;
    }

    @Transactional
    private int getNumberInvalidatedByReason(int reason, int idNut){
        int numberInvalidatedByReason;
        if (idNut != 0){
            numberInvalidatedByReason = applicationRepository.findApplicationsInvalidatedByCallAndReasonAndNut(idCurrentCall, reason, idNut);
        } else {
            numberInvalidatedByReason = applicationRepository.findApplicationInvalidatedByCallAndReason(idCurrentCall,reason);
        }
        return numberInvalidatedByReason;
    }

    @Transactional
    private void getApplicantsWithWarnings(int idNut) {
        int counterWarnings;
        ArrayList<Application> allApplicants;
        if (idNut != 0) {
            allApplicants = Lists.newArrayList(applicationRepository.findApplicationsByCallId(idCurrentCall, idNut));
        } else {
            allApplicants = Lists.newArrayList(applicationRepository.findApplicationsByCallId(idCurrentCall));
        }
        if (Validator.isNotNull(allApplicants)) {
            for (int i = 0; i < allApplicants.size(); i++) {
                counterWarnings = getCountRegistrationWarnings(allApplicants.get(i).getRegistrationId());
                switch (counterWarnings){
                    case 1:
                        warning1Applicant++;
                        break;
                    case 2:
                        warning2Applicant++;
                        break;
                    case 3:
                        warning3Applicant++;
                        break;
                }
            }
        }
    }

    @Transactional
    private void getWarningsByType(int idNut) {
        ArrayList<Application> allApplicants;
        if (idNut != 0) {
            allApplicants = Lists.newArrayList(applicationRepository.findApplicationsByCallId(idCurrentCall, idNut));
        } else {
            allApplicants = Lists.newArrayList(applicationRepository.findApplicationsByCallId(idCurrentCall));
        }
        if (Validator.isNotNull(allApplicants)) {
            for (int i = 0; i < allApplicants.size(); i++) {
                // TODO - Implement custom query to retrieve all the counts with one query - Need Entity / DTO
                // SELECT (select count(*) from registration_warnings where warning = 1 and registration_id = 22758) as warning1,
                //(select count(*) as warning1 from registration_warnings where warning = 2 and registration_id = 22758) as warning2,
                //(select count(*) as warning1 from registration_warnings where warning = 3 and registration_id = 22758) as warning3
                if (registrationHasWarning(allApplicants.get(i).getRegistrationId(), 1)) {
                    warningsType1++;
                }
                if (registrationHasWarning(allApplicants.get(i).getRegistrationId(), 2)) {
                    warningsType2++;
                }
                if (registrationHasWarning(allApplicants.get(i).getRegistrationId(), 2)) {
                    warningsType3++;
                }
            }
        }
    }

    @Transactional
    private int getAllCallApplicants(int idNut) {
        if (idNut != 0) {
            return (int) applicationRepository.countApplicationsByCallId(idCurrentCall, idNut);
        } else {
            return (int) applicationRepository.countApplicationsForCurrentCall(idCurrentCall);
        }
    }

    @Transactional
    private int getAllCallApplicantsInvalidated(int idNut) {
        if (idNut != 0) {
            return (int) applicationRepository.countApplicationsByCallIdInvalidated(idCurrentCall, idNut);
        } else {
            return (int) applicationRepository.countApplicationsByCallIdInvalidated(idCurrentCall);
        }
    }

    @Transactional
    private int getNumberDuplicates(int idNut) {
        int numberDuplicates = 0;
        long municipalityDuplicates;
        ArrayList<String> allMunicipalities = null;
        if (idNut == 0) {
            List<Integer> countListed = Lists.newArrayList(applicationRepository.countAplicationsDuplicatedForCallId(idCurrentCall));
            for (Integer i : countListed) {
                if (i != 0) {
                    numberDuplicates += i - 1;
                }
            }
        } else {
            allMunicipalities = Lists.newArrayList(municipalityRepository.findAllMunicipalitiesByCountryAndCallId(idCurrentCall, idNut));
        }
        if (idNut != 0) {
            for (String m : allMunicipalities) {
                municipalityDuplicates = applicationRepository.countApplicationsForMunicipalityByCountryAndCallId(idCurrentCall, idNut, m);
                if (municipalityDuplicates != 0) {
                    numberDuplicates += (int) municipalityDuplicates - 1;
                }
            }
        }
        return numberDuplicates;
    }

    @Transactional
    private int getNumberDuplicatesInvalidated(int idNut) {
        int numberDuplicatesInvalidated = 0;
        long municipalityDuplicates;
        ArrayList<String> allMunicipalities = null;
        if (idNut == 0) {
            List<Integer> countListed = Lists.newArrayList(applicationRepository.countAplicationsDuplicatedByCallIdInvalidated(idCurrentCall));
            for (Integer i : countListed) {
                if (i != 0) {
                    numberDuplicatesInvalidated += i - 1;
                }
            }
        } else {
            allMunicipalities = Lists.newArrayList(municipalityRepository.findAllMunicipalitiesByCountryAndCallId(idCurrentCall, idNut));
        }
        if (idNut != 0) {
            for (String m : allMunicipalities) {
                municipalityDuplicates = applicationRepository.countApplicationsForMunicipalityByCountryInvalidated(idCurrentCall, idNut, m);
                if (municipalityDuplicates != 0) {
                    numberDuplicatesInvalidated += (int) municipalityDuplicates - 1;
                }
            }
        }
        return numberDuplicatesInvalidated;
    }
}


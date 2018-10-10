package wifi4eu.wifi4eu.util.reports;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
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
public class ReportAgreementPreparation {

    @Autowired
    CallRepository callRepository;

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    NutCallCustomRepository nutCallCustomRepository;

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
            generateTotalPercentValues(sheet, callId, 0);
            putCountriesByCall(sheet, firstRow, 3, callId);
            ReportingUtils.autoSizeColumns(workbook);
        } else {
            // send email notifying that no closed calls available?
            System.out.println("No call found");
        }
    }

    private void generateTotalValues(HSSFSheet sheet, Integer callId, Integer idNut){
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

    private void generateTotalPercentValues(HSSFSheet sheet, Integer callId, Integer idNut){
        int column = 2;
        Map<String, Object> allValues = getAllPercentages(callId, idNut);
        HSSFRow row;
        String[] totalValues = {"maxNumberPercent", "signedGAPercent", "remainingGAPercent", "counterSignedGAPercent", "counterFromReservePercent", "remainingCounterSignedPercent"};
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
                String[] totalValues = {"maxNumber", "signedGA", "remainingGA", "counterSignedGA", "counterFromReserve", "remainingCounterSigned"};
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
    private Map<String, Object> getAllValues(Integer callId, Integer idNut){
        Map<String, Object> mapResult = new HashMap<>();
        Integer maxNumber = getMaxNumber(callId, idNut);
        Integer signedGA = getSignedGA(callId, idNut);
        Integer remainingGA = maxNumber - signedGA;
        Integer counterSignedGA = getCounterSignedGA(callId, idNut);
        Integer counterFromReserve = getCounterFromReserve(callId, idNut);
        Integer remainingCounterSigned = signedGA - counterSignedGA;
        mapResult.put("maxNumber", maxNumber);
        mapResult.put("signedGA", signedGA);
        mapResult.put("remainingGA", remainingGA);
        mapResult.put("counterSignedGA", counterSignedGA);
        mapResult.put("counterFromReserve", counterFromReserve);
        mapResult.put("remainingCounterSigned", remainingCounterSigned);
        return mapResult;
    }

    @Transactional
    private Map<String, Object> getAllPercentages(Integer callId, Integer idNut){
        Map<String, Object> mapResult = new HashMap<>();
        Integer maxNumber = getMaxNumber(callId, idNut);
        Integer signedGA = getSignedGA(callId, idNut);
        Integer remainingGA = maxNumber - signedGA;
        Integer counterSignedGA = getCounterSignedGA(callId, idNut);
        Integer counterFromReserve = getCounterFromReserve(callId, idNut);
        Integer remainingCounterSigned = signedGA - counterSignedGA;
        DecimalFormat df = new DecimalFormat("#.##");
        mapResult.put("maxNumberPercent", "-");
        mapResult.put("signedGAPercent", df.format((signedGA * 100.0f)/maxNumber));
        mapResult.put("remainingGAPercent", df.format((remainingGA * 100.0f)/maxNumber));
        mapResult.put("counterSignedGAPercent", df.format((counterSignedGA * 100.0f)/maxNumber));
        mapResult.put("counterFromReservePercent", df.format((counterFromReserve * 100.0f)/maxNumber));
        mapResult.put("remainingCounterSignedPercent", df.format((remainingCounterSigned * 100.0f)/maxNumber));
        return mapResult;
    }

    @Transactional
    private Integer getMaxNumber(Integer callId, Integer idNut){
        if(idNut != 0){
            return applicationRepository.countApplicationsForSelectedCall(callId, idNut);
        }else{
            return applicationRepository.countApplicationsForSelectedCall(callId);
        }
    }

    @Transactional
    private Integer getSignedGA(Integer callId, Integer idNut){
        if(idNut != 0){
            return applicationRepository.countGrantAgreementsSigned(callId, idNut);
        }else{
            return applicationRepository.countGrantAgreementsSigned(callId);
        }
    }

    @Transactional
    private Integer getCounterSignedGA(Integer callId, Integer idNut){
        if(idNut != 0){
            return applicationRepository.countGrantAgreementsCounterSigned(callId, idNut);
        }else{
            return applicationRepository.countGrantAgreementsCounterSigned(callId);
        }
    }

    @Transactional
    private Integer getCounterFromReserve(Integer callId, Integer idNut){
        if(idNut != 0){
            return applicationRepository.countGrantAgreementsCounterSignedReserved(callId, idNut);
        }else{
            return applicationRepository.countGrantAgreementsCounterSignedReserved(callId);
        }
    }
}

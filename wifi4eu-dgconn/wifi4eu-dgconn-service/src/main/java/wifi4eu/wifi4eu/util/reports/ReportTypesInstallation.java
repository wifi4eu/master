package wifi4eu.wifi4eu.util.reports;

import com.google.common.collect.Lists;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.math.Statistics;
import wifi4eu.wifi4eu.common.utils.Utils;
import wifi4eu.wifi4eu.entity.call.Call;
import wifi4eu.wifi4eu.entity.location.NutCallCustom;
import wifi4eu.wifi4eu.entity.municipality.Municipality;
import wifi4eu.wifi4eu.repository.access_point.AccessPointRepository;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.call.CallRepository;
import wifi4eu.wifi4eu.repository.location.NutCallCustomRepository;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.util.reporting.ReportingUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;

@Component
public class ReportTypesInstallation {

    @Autowired
    private CallRepository callRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private NutCallCustomRepository nutCallCustomRepository;

    @Autowired
    private MunicipalityRepository municipalityRepository;

    @Autowired
    private AccessPointRepository accessPointRepository;

    private static String[] fields = {"Number of beneficiaries", "Number of installation sites", "Average number of Indoor AP", "Standard deviation for Indoor AP", "Average number of Outdoor AP", "Standard deviation for Outdoor AP"};

    int beneficiariesNumber = 0;
    int installationSitesNumber = 0;
    float averageIndoor = 0;
    float averageOutdoor = 0;
    float deviationStandardIndoor = 0;
    float deviationStandardOutdoor = 0;

    public void generate(HSSFWorkbook workbook){
        HSSFSheet sheet;
        ArrayList<Call> calls = callRepository.findCallsIncludeCurrent();
        for (Call call : calls) {
            if (applicationRepository.countApplicationsForCallId(call.getId()) > 0) {
                sheet = workbook.createSheet(call.getEvent());
                int numColumn = 0;
                HSSFRow firstRow = sheet.createRow((short) numColumn);
                firstRow.createCell(0).setCellValue("");
                numColumn++;
                HSSFRow row;
                for (int i = numColumn; i <= fields.length; i++) {
                    row = sheet.createRow((short) i);
                    row.createCell(0).setCellValue(fields[i - 1]);
                }
                ArrayList<NutCallCustom> nuts = Lists.newArrayList(nutCallCustomRepository.findNutsByCall(call.getId()));
                for (NutCallCustom nut : nuts) {
                    putCountriesTypesInstallations(sheet, call.getId(), numColumn, nut);
                    numColumn++;
                }

                // nuts finished, total of the call part
                generateTotalForTheCallValues(numColumn, sheet);
            }
        }

        // new Sheet with total of the calls calculations
        sheet = workbook.createSheet("Total for all Calls");
        int numColumn = 0;
        HSSFRow firstRow = sheet.createRow((short) numColumn);
        firstRow.createCell(0).setCellValue("");
        numColumn++;
        HSSFRow row;
        for (int i = numColumn; i <= fields.length; i++) {
            row = sheet.createRow((short) i);
            row.createCell(0).setCellValue(fields[i - 1]);
        }

        ArrayList<NutCallCustom> nuts = Lists.newArrayList(nutCallCustomRepository.findNutsUsedFromTopCurrentCall());
        numColumn = 1;
        int[] passedNuts = new int[nuts.size()];
        int a = 0;
        for (NutCallCustom nut : nuts) {
            if (!Utils.contains(passedNuts,nut.getId())){
                putTotalCallsValues(firstRow, sheet, nut, numColumn);
                passedNuts[a] = nut.getId();
                numColumn++;
                a++;
            }
        }
        ReportingUtils.autoSizeColumns(workbook);
    }

    private void putCountriesTypesInstallations(HSSFSheet sheet, int idCall, int numColumn, NutCallCustom nut){
        HSSFRow rowNut = sheet.getRow(0);
        rowNut.createCell(numColumn).setCellValue(nut.getLabel());
        for (int i = 1; i <= fields.length; i++) {
            HSSFRow row = sheet.getRow(i);
            if (Validator.isNotNull(row)) {
                row.createCell(numColumn).setCellValue(getValueForDefinedCallAndNutFromFieldsArray(fields[i - 1], idCall, nut.getId()));
            }
        }
    }

    private void putTotalCallsValues(HSSFRow row, HSSFSheet sheet, NutCallCustom nut, int numColumn) {
        row.createCell(numColumn).setCellValue(nut.getLabel());
        for (int i = 1; i <= fields.length; i++) {
            row = sheet.getRow(i);
            if (Validator.isNotNull(row)) {
                row.createCell(numColumn).setCellValue(getValueForGeneralCallFromFieldsArray(fields[i - 1], nut.getId()));
            }
        }
    }

    private String calculateDeviationAccessPointsPerNut(int idNut, boolean type){
        ArrayList<Municipality> municipalities = municipalityRepository.findAllByNut(idNut);
        double[] arrayDouble = new double[municipalities.size()];
        if (arrayDouble.length > 1){
            int i = 0;
            for(Municipality municipality : municipalities) {
                arrayDouble[i] = accessPointRepository.countAccessPointsByTypeIndoorAndMunicipality(type,municipality.getId());
                i++;
            }

            // CALCULATE THE STANDARD DEVIATION
            Statistics statistics = new Statistics(arrayDouble);
            double a = statistics.getStdDev();
            DecimalFormat df = new DecimalFormat("#.##");
            return df.format(a);
        }

        return "0.0";
    }

    private void generateTotalForTheCallValues(int numColumn, HSSFSheet sheet){
        HSSFRow row = sheet.getRow(0);
        row.createCell(numColumn).setCellValue("TOTAL FOR THE CALL");
        for (int i = 1; i <= fields.length; i++){
            row = sheet.getRow(i);
            row.createCell(numColumn).setCellValue(getTotalForTheCallValues(fields[i - 1]));
        }
        beneficiariesNumber = 0;
        installationSitesNumber = 0;
        averageIndoor = 0;
        averageOutdoor = 0;
        deviationStandardIndoor = 0;
        deviationStandardOutdoor = 0;
    }

    private String getTotalForTheCallValues(String field) {
        String value;
        switch (field) {
            case "Number of beneficiaries":
                value = String.valueOf(beneficiariesNumber);
                break;

            case "Number of installation sites":
                value = String.valueOf(installationSitesNumber);
                break;

            case "Average number of Indoor AP":
                value = String.valueOf(averageIndoor);
                break;

            case "Standard deviation for Indoor AP":
                value = String.valueOf(deviationStandardIndoor);
                break;

            case "Average number of Outdoor AP":
                value = String.valueOf(averageOutdoor);
                break;

            case "Standard deviation for Outdoor AP":
                value = String.valueOf(deviationStandardOutdoor);
                break;

            default:
                value = "-";
                break;
        }

        return value;
    }

    private String getValueForDefinedCallAndNutFromFieldsArray(String field, int idCall, int idNut) {
        String value;
        DecimalFormat df = new DecimalFormat("#.##");
        switch (field) {
            case "Number of beneficiaries":
                value = String.valueOf(applicationRepository.getNumberBeneficiariesByCallIdAndNut(idCall,idNut));
                beneficiariesNumber += Integer.valueOf(value);
                break;

            case "Number of installation sites":
                value = String.valueOf(applicationRepository.countInstallationSitesValidatedForCurrentCallAndNut(idCall, idNut));
                installationSitesNumber += Integer.valueOf(value);
                break;

            case "Average number of Indoor AP":
                value = df.format((float) (applicationRepository.countAccessPointsForCurrentCallAndNut(true, idCall, idNut)) / (applicationRepository.getNumberBeneficiariesByCallIdAndNut(idCall,idNut)));
                if (value.equals("∞")){
                    value = "0";
                }
                averageIndoor += Float.parseFloat(value.replace(",","."));
                break;

            case "Standard deviation for Indoor AP":
                value = calculateDeviationAccessPoints(idCall, idNut, true);
                deviationStandardIndoor += Float.parseFloat(value.replace(",","."));
                break;

            case "Average number of Outdoor AP":
                value = df.format((float) (applicationRepository.countAccessPointsForCurrentCallAndNut(false, idCall, idNut)) / (applicationRepository.getNumberBeneficiariesByCallIdAndNut(idCall,idNut)));
                if (value.equals("∞")){
                    value = "0";
                }
                averageOutdoor += Float.parseFloat(value.replace(",","."));
                break;

            case "Standard deviation for Outdoor AP":
                value = calculateDeviationAccessPoints(idCall, idNut, false);
                deviationStandardOutdoor += Float.parseFloat(value.replace(",","."));
                break;

            default:
                value = "-";
                break;
        }
        return value;
    }

    private String getValueForGeneralCallFromFieldsArray(String field, int idNut){
        String value;
        DecimalFormat df = new DecimalFormat("#.##");
        switch (field) {
            case "Number of beneficiaries":
                value = String.valueOf(applicationRepository.getNumberBeneficiariesByNut(idNut));
                break;

            case "Number of installation sites":
                value = String.valueOf(applicationRepository.countInstallationSitesValidatedForNut(idNut));
                break;

            case "Average number of Indoor AP":
                value = df.format((float) (applicationRepository.countAccessPointsForNut(true, idNut)) / (applicationRepository.getNumberBeneficiariesByNut(idNut)));
                if (value.equals("∞")){
                    value = "0";
                }
                break;

            case "Standard deviation for Indoor AP":
                value = calculateDeviationAccessPointsPerNut(idNut, true);
                break;

            case "Average number of Outdoor AP":
                value = df.format((float) (applicationRepository.countAccessPointsForNut(false, idNut)) / (applicationRepository.getNumberBeneficiariesByNut(idNut)));
                if (value.equals("∞")){
                    value = "0";
                }
                break;

            case "Standard deviation for Outdoor AP":
                value = calculateDeviationAccessPointsPerNut(idNut, false);
                break;

            default:
                value = "-";
                break;
        }

        return value;
    }


    private String calculateDeviationAccessPoints(int idCall, int idNut, boolean type){
        ArrayList<Municipality> municipalities = municipalityRepository.findAllByCallAndNut(idCall, idNut);
        double[] arrayDouble = new double[municipalities.size()];
        if (arrayDouble.length > 1){
            int i = 0;
            for(Municipality municipality : municipalities) {
                arrayDouble[i] = accessPointRepository.countAccessPointsByTypeIndoorAndMunicipality(type,municipality.getId());
                i++;
            }

            // CALCULATE THE STANDARD DEVIATION
            Statistics statistics = new Statistics(arrayDouble);
            double a = statistics.getStdDev();
            DecimalFormat df = new DecimalFormat("#.##");
            return df.format(a);
        }
        return "0.0";
    }

}


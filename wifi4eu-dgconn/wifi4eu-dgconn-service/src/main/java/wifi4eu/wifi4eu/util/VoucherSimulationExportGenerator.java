package wifi4eu.wifi4eu.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationWarningDTO;
import wifi4eu.wifi4eu.common.dto.model.VoucherAssignmentDTO;
import wifi4eu.wifi4eu.common.dto.model.VoucherSimulationDTO;
import wifi4eu.wifi4eu.common.enums.SelectionStatus;
import wifi4eu.wifi4eu.common.enums.VoucherAssignmentStatus;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.entity.voucher.VoucherSimulation;
import wifi4eu.wifi4eu.repository.voucher.VoucherAssignmentRepository;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VoucherSimulationExportGenerator<T> {

    private List<T> data;
    private Class dataClass;
    private ArrayList<String> fieldNames;
    private ArrayList<String> displayedFieldNames;
    private T parent;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");

    public VoucherSimulationExportGenerator(List<T> data, T parent, Class dataClass) {
        this.data = data;
        this.dataClass = dataClass;
        this.parent = parent;
        generateFields();
    }

    public ByteArrayOutputStream exportExcelFile(String sheetName) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            Workbook workbook = new HSSFWorkbook();
            Sheet sheet = workbook.createSheet(sheetName);
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < displayedFieldNames.size(); i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(displayedFieldNames.get(i));
                cell.setCellStyle(headerCellStyle);
            }
            int rowIndex = 1;
            for (T obj : data) {
                Row row = sheet.createRow(rowIndex);
                for (int i = 0; i < fieldNames.size(); i++) {
                    Cell cell = row.createCell(i);
                    Field field;

                    if(fieldNames.get(i).equalsIgnoreCase("changes")){
                        VoucherSimulationDTO voucherSimulationDTO = (VoucherSimulationDTO) obj;
                        ApplicationDTO applicationDTO = voucherSimulationDTO.getApplication();

                        String value;

                        if(Validator.isNotNull(applicationDTO) && !applicationDTO.getPreSelectedFlag()){
                            value = "NEW";
                        }else{
                            value = "-";
                        }
                        cell.setCellValue(value);
                    }
                    else if(fieldNames.get(i).equalsIgnoreCase("issues")){
                      VoucherSimulationDTO voucherSimulationDTO = (VoucherSimulationDTO) obj;
                      List<RegistrationWarningDTO> warnings = voucherSimulationDTO.getRegistrationWarningDTO();

                      List<String> wList = new ArrayList<String>();
                      warnings.stream().forEach(x -> wList.add("WARNING " + x.getWarning()));

                      cell.setCellValue(String.join(", ", wList));
                    }
                    else if(fieldNames.get(i).equalsIgnoreCase("registration")){
                        VoucherSimulationDTO voucherSimulationDTO = (VoucherSimulationDTO) obj;
                        Integer status = voucherSimulationDTO.getApplication().getRegistrationId();
                        cell.setCellValue( status);
                    }
                    else if (fieldNames.get(i).equalsIgnoreCase("status")){

                        VoucherSimulationDTO voucherSimulationDTO = (VoucherSimulationDTO) obj;
                        Integer status = voucherSimulationDTO.getApplication().getStatus();
                        String value;
                        switch (status) {
                            case 0:
                                value = "Applied";
                                break;
                            case 1:
                                value = "Invalid";
                                break;
                            case 2:
                                value = "Valid";
                                break;
                            case 3:
                                value = "Pending followup";
                                break;
                            default:
                                value = "";
                                break;
                        }
                        cell.setCellValue( value);
                    } else if(fieldNames.get(i).equalsIgnoreCase("appdate")) {
                        VoucherSimulationDTO voucherSimulationDTO = (VoucherSimulationDTO) obj;
                        Date applicationDate = new Date(voucherSimulationDTO.getApplication().getDate());
                        cell.setCellValue(dateFormat.format(applicationDate));
                    } else {

                        if (fieldNames.get(i).equalsIgnoreCase("registrationId")) {
                            field = obj.getClass().getDeclaredField("application.registrationId");
                        } else {
                            field = obj.getClass().getDeclaredField(fieldNames.get(i));
                        }
                        field.setAccessible(true);
                        cell.setCellValue(generateCellValue(field, obj));
                    }
                }
                rowIndex++;
            }
            for (int i = 0; i < fieldNames.size(); i++) {
                sheet.autoSizeColumn(i);
            }
            workbook.write(baos);
            baos.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baos;
    }

    private void generateFields() {
        fieldNames = new ArrayList<>();
        displayedFieldNames = new ArrayList<>();
        if (dataClass == VoucherSimulationDTO.class || dataClass == VoucherSimulation.class) {
            fieldNames.add("euRank");
            displayedFieldNames.add("Eu Rank");
            fieldNames.add("countryRank");
            displayedFieldNames.add("Country Rank");

            if(((VoucherAssignmentDTO) parent).getStatus() != VoucherAssignmentStatus.FREEZE_LIST.getValue()){
                displayedFieldNames.add("changes");
                fieldNames.add("Changes");
            }

            fieldNames.add("selectionStatus");
            displayedFieldNames.add("Selection Status");
            fieldNames.add("country");
            displayedFieldNames.add("Country");
            fieldNames.add("municipalityName");
            displayedFieldNames.add("Municipality Name");
            fieldNames.add("issues");
            displayedFieldNames.add("Issue");
            fieldNames.add("status");
            displayedFieldNames.add("Status");
            fieldNames.add("numApplications");
            displayedFieldNames.add("Duplicated");
            //-- New ones
            fieldNames.add("appdate");
            displayedFieldNames.add("Apply date");
//            fieldNames.add("rejected");
//            displayedFieldNames.add("Rejected");
            fieldNames.add("registration");
            displayedFieldNames.add("Registration ID");
            fieldNames.add("municipality");
            displayedFieldNames.add("Municipality ID");
            fieldNames.add("application");
            displayedFieldNames.add("Application ID");
        }
    }

    private String generateCellValue(Field field, T objectData) throws IllegalAccessException {
        String value = "";
        if (field.get(objectData) != null) {
            if (dataClass == VoucherSimulationDTO.class || dataClass == VoucherSimulation.class) {
                ApplicationDTO applicationDTO;
                switch (field.getName()) {
                    case "countryRank":
                    case "euRank":
                        value = field.get(objectData).toString();
                        if(value.equalsIgnoreCase(String.valueOf(Integer.MAX_VALUE))){
                            value = "";
                        }
                        break;
                    case "selectionStatus":
                        if((int) field.get(objectData) == SelectionStatus.MAIN_LIST.getValue()){
                            value = "Main list";
                        }
                        else if((int) field.get(objectData) == SelectionStatus.RESERVE_LIST.getValue()){
                            value = "Reserve list";
                        }
                        else if((int) field.get(objectData) == SelectionStatus.REJECTED.getValue()){
                            value = "Rejected";
                        }
                        else if((int) field.get(objectData) == SelectionStatus.SELECTED.getValue()){
                            value = "Selected";
                        }
                        break;
                    case "numApplications":
                        if((int) field.get(objectData) > 1){
                            value = "YES";
                        }else{
                            value = "NO";
                        }
                        break;
                    case "issues":
                        int issueStatus = (int) field.get(objectData);
                        switch (issueStatus) {
                            case 1:
                            case 2:
                            case 3:
                                value = "WARNING " + issueStatus;
                                break;
                            default:
                                value = "";
                                break;
                        }
                        break;
//                    case "rejected":
//                        if((int) field.get(objectData) == 1){
//                            value = "YES";
//                        }
//                        else{
//                            value = "NO";
//                        }
//                        break;
                    case "application":
                        applicationDTO = (ApplicationDTO) field.get(objectData);
                        value = String.valueOf(applicationDTO.getId());
                        break;
                    default:
                        value = field.get(objectData).toString();
                        break;
                }
            }
        }
        return value;
    }
}

package wifi4eu.wifi4eu.service.exportImport.excelFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.JFileChooser;


import wifi4eu.wifi4eu.mapper.exportImport.ExportImportRegistrationDataMapper;
import wifi4eu.wifi4eu.repository.exportImport.ExportImportRegistrationDataReporsitory;
import wifi4eu.wifi4eu.common.dto.model.ExportImportRegistrationDataDTO;
//import wifi4eu.wifi4eu.mapper.municipality.MunicipalityMapper;
//import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;


import java.util.List;
import java.util.ArrayList;


public class ReadExcelFile {

    public ExportImportRegistrationDataMapper exportImportRegistrationDataMapper;
    public ExportImportRegistrationDataReporsitory exportImportRegistrationDataReporsitory;

    public ReadExcelFile(){}

    public ReadExcelFile(ExportImportRegistrationDataReporsitory exportImportRegistrationDataReporsitory, ExportImportRegistrationDataMapper exportImportRegistrationDataMapper) {
        this.exportImportRegistrationDataMapper = exportImportRegistrationDataMapper;
        this.exportImportRegistrationDataReporsitory = exportImportRegistrationDataReporsitory;
    }

    public void readExcelFile(){
        JFileChooser fc = new JFileChooser();
        int respuesta = fc.showOpenDialog(null);
        File archivoElegido=null;
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            archivoElegido = fc.getSelectedFile();
        }

        try (FileInputStream file = new FileInputStream(archivoElegido)) {
            XSSFWorkbook worbook = new XSSFWorkbook(file);
            XSSFSheet sheet = worbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row row;

            int count=0;
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                if(count>0) {
                      ExportImportRegistrationDataDTO eI=new ExportImportRegistrationDataDTO();
                      eI.setId(Integer.parseInt(row.getCell(0).getStringCellValue()));
                      eI.setEuRank(Integer.parseInt(row.getCell(0).getStringCellValue()));
                      eI.setCountryRank(Integer.parseInt(row.getCell(1).getStringCellValue()));
                      eI.setCountryName(row.getCell(2).getStringCellValue());
                      eI.setMunicipalityName(row.getCell(3).getStringCellValue());
                      eI.setIssue(row.getCell(4).getStringCellValue());
                      eI.setNumberOfRegistrations(Integer.parseInt(row.getCell(5).getStringCellValue()));
                      //eI.setAbacReference((int)row.getCell(6).getNumericCellValue());
                      eI.setAbacReference(Integer.parseInt(row.getCell(6).getStringCellValue()));
                      eI.setAbacStandarName(row.getCell(7).getStringCellValue());
                      eI.setMunicipality(Integer.parseInt(row.getCell(0).getStringCellValue()));
                      exportImportRegistrationDataReporsitory.save(exportImportRegistrationDataMapper.toEntity(eI));
                }
                count++;
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

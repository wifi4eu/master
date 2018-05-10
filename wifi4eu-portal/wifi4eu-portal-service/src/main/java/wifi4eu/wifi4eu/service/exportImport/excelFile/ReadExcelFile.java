package wifi4eu.wifi4eu.service.exportImport.excelFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.JFileChooser;


import wifi4eu.wifi4eu.mapper.exportImport.ExportImportRegistrationDataMapper;
import wifi4eu.wifi4eu.repository.exportImport.ExportImportRegistrationDataRepository;
import wifi4eu.wifi4eu.common.dto.model.ExportImportRegistrationDataDTO;


public class ReadExcelFile {

    public ExportImportRegistrationDataMapper exportImportRegistrationDataMapper;
    public ExportImportRegistrationDataRepository exportImportRegistrationDataRepository;

    public ReadExcelFile(){}

    public ReadExcelFile(ExportImportRegistrationDataRepository exportImportRegistrationDataRepository, ExportImportRegistrationDataMapper exportImportRegistrationDataMapper) {
        this.exportImportRegistrationDataMapper = exportImportRegistrationDataMapper;
        this.exportImportRegistrationDataRepository = exportImportRegistrationDataRepository;
    }

    public void readExcelFile(){
        JFileChooser fc = new JFileChooser();
        int response = fc.showOpenDialog(null);
        File fil=null;
        if (response == JFileChooser.APPROVE_OPTION) {
            fil = fc.getSelectedFile();
        }

        try (FileInputStream file = new FileInputStream(fil)) {
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
                      eI.setAbacReference(row.getCell(6).getStringCellValue());
                      eI.setAbacStandarName(row.getCell(7).getStringCellValue());
                      eI.setMunicipality(Integer.parseInt(row.getCell(0).getStringCellValue()));
                      exportImportRegistrationDataRepository.save(exportImportRegistrationDataMapper.toEntity(eI));
                }
                count++;
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

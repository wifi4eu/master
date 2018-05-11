package wifi4eu.wifi4eu.service.exportImport.excelFile;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import wifi4eu.wifi4eu.common.dto.model.ExportImportLEFDTO;
import wifi4eu.wifi4eu.mapper.exportImport.ExportImportLEFMapper;
import wifi4eu.wifi4eu.repository.exportImport.ExportImportLEFRepository;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;


public class ReadExcelFile {

    public ExportImportLEFMapper exportImportLEFMapper;
    public ExportImportLEFRepository exportImportLEFRepository;

    public ReadExcelFile(){}

    public ReadExcelFile(ExportImportLEFRepository exportImportLEFRepository, ExportImportLEFMapper exportImportLEFMapper) {
        this.exportImportLEFMapper = exportImportLEFMapper;
        this.exportImportLEFRepository = exportImportLEFRepository;
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
                      ExportImportLEFDTO eI=new ExportImportLEFDTO();
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
//                      exportImportLEFRepository.save(exportImportLEFMapper.toEntity(eI));
                }
                count++;
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

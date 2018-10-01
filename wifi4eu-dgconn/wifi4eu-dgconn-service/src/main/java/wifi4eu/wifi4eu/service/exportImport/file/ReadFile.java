package wifi4eu.wifi4eu.service.exportImport.file;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import com.microsoft.applicationinsights.core.dependencies.apachecommons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


import wifi4eu.wifi4eu.mapper.exportImport.ExportImportRegistrationDataMapper;
import wifi4eu.wifi4eu.repository.exportImport.ExportImportRegistrationDataRepository;
import wifi4eu.wifi4eu.common.dto.model.ExportImportRegistrationDataDTO;


public class ReadFile {

    public ExportImportRegistrationDataMapper exportImportRegistrationDataMapper;
    public ExportImportRegistrationDataRepository exportImportRegistrationDataRepository;

    public ReadFile(){}

    public ReadFile(ExportImportRegistrationDataRepository exportImportRegistrationDataRepository, ExportImportRegistrationDataMapper exportImportRegistrationDataMapper) {
        this.exportImportRegistrationDataMapper = exportImportRegistrationDataMapper;
        this.exportImportRegistrationDataRepository = exportImportRegistrationDataRepository;
    }

    public void readExcelFileEntityFBCValidate(){
        JFileChooser fc = new JFileChooser();
        int response = fc.showOpenDialog(null);
        File fil = null;
        if (response == JFileChooser.APPROVE_OPTION) {
            fil = fc.getSelectedFile();
        }
        try (FileInputStream file = new FileInputStream(fil)) {
            XSSFWorkbook worbook = new XSSFWorkbook(file);
            XSSFSheet sheet = worbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row row;
            int count = 0;
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                if (count > 0) {
                    ExportImportRegistrationDataDTO eI = new ExportImportRegistrationDataDTO();
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

    public void readExcelFileRegistrationData() throws Exception {
        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xls", "xlsx");
        fc.setFileFilter(filter);
        int response = fc.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            FileInputStream fis = new FileInputStream(file);
            Workbook workbook;
            String fileExtension = FilenameUtils.getExtension(file.getName());
            if (fileExtension.equals("xls")) {
                workbook = new HSSFWorkbook(fis);
            } else if (fileExtension.equals("xlsx")) {
                workbook = new XSSFWorkbook(fis);
            } else {
                throw new Exception("The extension of the file is incorrect. It must be an Excel file.");
            }
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row row;
            int count = 0;
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                if (count > 0) {
                    ExportImportRegistrationDataDTO eI = new ExportImportRegistrationDataDTO();
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
        } else {
            throw new Exception("No file has been chosen.");
        }
    }
}

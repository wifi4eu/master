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

//    public MunicipalityMapper municipalityMapper;
//    public MunicipalityRepository municipalityRepository;
    public ExportImportRegistrationDataMapper exportImportRegistrationDataMapper;
    public ExportImportRegistrationDataReporsitory exportImportRegistrationDataReporsitory;

    public ReadExcelFile(){}

//    public ReadExcelFile(MunicipalityRepository municipalityRepository, MunicipalityMapper municipalityMapper, ExportImportRegistrationDataReporsitory exportImportRegistrationDataReporsitory, ExportImportRegistrationDataMapper exportImportRegistrationDataMapper) {
//        this.municipalityMapper = municipalityMapper;
//        this.municipalityRepository = municipalityRepository;
//        this.exportImportRegistrationDataMapper = exportImportRegistrationDataMapper;
//        this.exportImportRegistrationDataReporsitory = exportImportRegistrationDataReporsitory;
//    }

    public ReadExcelFile(ExportImportRegistrationDataReporsitory exportImportRegistrationDataReporsitory, ExportImportRegistrationDataMapper exportImportRegistrationDataMapper) {
        this.exportImportRegistrationDataMapper = exportImportRegistrationDataMapper;
        this.exportImportRegistrationDataReporsitory = exportImportRegistrationDataReporsitory;
    }

    public void readExcelFile(){
        JFileChooser fc = new JFileChooser();
        //Mostrar la ventana para abrir archivo y recoger la respuesta
        //En el parámetro del showOpenDialog se indica la ventana
        //  al que estará asociado. Con el valor this se asocia a la
        //  ventana que la abre.
        int respuesta = fc.showOpenDialog(null);
        //int respuesta = fc.showSaveDialog(this);
        //Comprobar si se ha pulsado Aceptar
        File archivoElegido=null;
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            //Crear un objeto File con el archivo elegido
            archivoElegido = fc.getSelectedFile();
            //Mostrar el nombre del archvivo en un campo de texto
            //txtNombre.setText(archivoElegido.getName());
        }

            //String rutaArchivo = "C:\\importFiles\\" + nombreArchivo;
            //String rutaArchivo = "C:\\" + nombreArchivo;
            String rutaArchivo = "C:\\" + archivoElegido.getName();
            String hoja = "Sheet1";

            //try (FileInputStream file = new FileInputStream(new File(rutaArchivo))) {
            try (FileInputStream file = new FileInputStream(archivoElegido)) {
                // leer archivo excel
                XSSFWorkbook worbook = new XSSFWorkbook(file);
                //obtener la hoja que se va leer
                XSSFSheet sheet = worbook.getSheetAt(0);
                //obtener todas las filas de la hoja excel
                Iterator<Row> rowIterator = sheet.iterator();

                Row row;
                // se recorre cada fila hasta el final
                int count=0;
                while (rowIterator.hasNext()) {
                    row = rowIterator.next();
                    if(count>0) {
                          ExportImportRegistrationDataDTO eI=new ExportImportRegistrationDataDTO();
                          eI.setId(Integer.parseInt(row.getCell(0).getStringCellValue()));
                          eI.setrId(Integer.parseInt(row.getCell(0).getStringCellValue()));
                          eI.setmCountry(row.getCell(2).getStringCellValue());
                          eI.setmName(row.getCell(3).getStringCellValue());
                          eI.setuName("null");
                          eI.setuEcasEmail("null");
                          eI.setuEcasUserName("null");
                          eI.setuType("null");
                          eI.setAbacReference(row.getCell(6).getStringCellValue());
                          eI.setAbacStandarName(row.getCell(7).getStringCellValue());
                          eI.setMunicipality(Integer.parseInt(row.getCell(0).getStringCellValue()));
                          exportImportRegistrationDataReporsitory.save(exportImportRegistrationDataMapper.toEntity(eI));
//                        MunicipalityDTO mu=new MunicipalityDTO();
//                        mu.setId(count+4);
//                        mu.setName(row.getCell(1).getStringCellValue());
//                        mu.setAddress(row.getCell(2).getStringCellValue());
//                        mu.setAddressNum(row.getCell(3).getStringCellValue());
//                        mu.setPostalCode(row.getCell(4).getStringCellValue());
//                        mu.setCountry(row.getCell(5).getStringCellValue());
//                        mu.setLauId(Integer.parseInt(row.getCell(6).getStringCellValue()));
//                        List<RegistrationDTO> lReg=new  ArrayList<RegistrationDTO>();
//                        RegistrationDTO reg=new RegistrationDTO();
//                        reg.setId(count+4);
//                        reg.setUserId(1);
//                        reg.setMunicipalityId(1);
//                        reg.setRole("Representative");
//                        reg.setStatus(0);
//                        reg.setLegalFile1(null);
//                        reg.setLegalFile2(null);
//                        reg.setLegalFile3(null);
//                        reg.setLegalFile4(null);
//                        lReg.add(reg);
//                        mu.setRegistrations(lReg);
//                        municipalityRepository.save(municipalityMapper.toEntity(mu));

                    }
                    count++;
//                    //se obtiene las celdas por fila
//                    Iterator<Cell> cellIterator = row.cellIterator();
//                    Cell cell;
//                    //se recorre cada celda
//                    while (cellIterator.hasNext()) {
//                        // se obtiene la celda en específico y se la imprime
//                        cell = cellIterator.next();
//                        System.out.print(cell.getStringCellValue()+" | ");
//                    }
//                    System.out.println();
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
}

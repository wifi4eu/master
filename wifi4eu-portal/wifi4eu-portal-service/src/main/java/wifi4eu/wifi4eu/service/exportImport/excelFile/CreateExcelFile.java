package wifi4eu.wifi4eu.service.exportImport.excelFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcelFile {

public CreateExcelFile(){}

public void createExcelFile(String [] header,  String [][] document){
        String nombreArchivo="ExportRegistrationData.csv";
        String rutaArchivo= "C:\\exportFiles\\"+nombreArchivo;
        //String rutaArchivo= "C:\\Users\\"+nombreArchivo;
        //String rutaArchivo= nombreArchivo;
        String hoja="Sheet1";

        XSSFWorkbook libro= new XSSFWorkbook();
        XSSFSheet hoja1 = libro.createSheet(hoja);

        //poner negrita a la cabecera
        CellStyle style = libro.createCellStyle();
        Font font = libro.createFont();
        font.setBold(true);
        style.setFont(font);


        //generar los datos para el documento
        for (int i = 0; i <= document.length; i++) {
            XSSFRow row=hoja1.createRow(i);//se crea las filas
            for (int j = 0; j <header.length; j++) {
                if (i==0) {//para la cabecera
                    XSSFCell cell= row.createCell(j);//se crea las celdas para la cabecera, junto con la posición
                    cell.setCellStyle(style); // se añade el style crea anteriormente
                    cell.setCellValue(header[j]);//se añade el contenido
                }else{//para el contenido
                    XSSFCell cell= row.createCell(j);//se crea las celdas para la contenido, junto con la posición
                    cell.setCellValue(document[i-1][j]); //se añade el contenido
                }
            }
        }

        File file;
        file = new File(rutaArchivo);
        try (FileOutputStream fileOuS = new FileOutputStream(file)){
            if (file.exists()) {// si el archivo existe se elimina
                file.delete();
                //System.out.println("Archivo eliminado");
            }
            libro.write(fileOuS);
            fileOuS.flush();
            fileOuS.close();
            //System.out.println("Archivo Creado");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }


    }

}

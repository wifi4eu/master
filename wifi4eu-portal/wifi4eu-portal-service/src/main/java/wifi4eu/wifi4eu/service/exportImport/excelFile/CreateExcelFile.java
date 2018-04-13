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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;

public class CreateExcelFile{

public CreateExcelFile(){}

public void createExcelFile(String [] header, String [][] document, HttpServletRequest request, HttpServletResponse response)throws UnsupportedEncodingException{
        //String nombreArchivo="ExportRegistrationData.csv";
        //String rutaArchivo= "C:\\exportFiles\\"+nombreArchivo;
    String path = this.getClass().getClassLoader().getResource("").getPath();
    String fullPath = URLDecoder.decode(path, "UTF-8");
    String pathArr[] = fullPath.split("/WEB-INF/classes/");
    System.out.println(fullPath);
    System.out.println(pathArr[0]);
    fullPath = pathArr[0];
        String rutaArchivo= fullPath+"/ExportRegistrationData.csv";
        String hoja="Sheet1";
        XSSFWorkbook libro= new XSSFWorkbook();
        XSSFSheet hoja1 = libro.createSheet(hoja);
        CellStyle style = libro.createCellStyle();
        Font font = libro.createFont();
        font.setBold(true);
        style.setFont(font);

        for (int i = 0; i <= document.length; i++) {
            XSSFRow row=hoja1.createRow(i);
            for (int j = 0; j <header.length; j++) {
                if (i==0) {
                    XSSFCell cell= row.createCell(j);
                    cell.setCellStyle(style);
                    cell.setCellValue(header[j]);
                }else{
                    XSSFCell cell= row.createCell(j);
                    cell.setCellValue(document[i-1][j]);
                }
            }
        }

        File file;
        file = new File(rutaArchivo);
        try (FileOutputStream fileOuS = new FileOutputStream(file)){
            if (file.exists()) {
                file.delete();

            }
            libro.write(fileOuS);
            fileOuS.flush();
            fileOuS.close();

            FileDownload fD=new FileDownload();
            fD.doGet(request, response);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

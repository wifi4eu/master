package wifi4eu.wifi4eu.service.exportImport.excelFile;

import java.io.*;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.net.URLDecoder;
import java.net.InetAddress;
import java.net.URL;
import java.net.URISyntaxException;
import java.net.MalformedURLException;
import java.awt.Desktop;


public class CreateExcelFile{

    public CreateExcelFile(){}

    public void createExcelFile(String [] header, String [][] document)throws UnsupportedEncodingException, IOException{
        //String nombreArchivo="ExportRegistrationData.csv";
        //String rutaArchivo= "C:\\exportFiles\\"+nombreArchivo;
        String path = this.getClass().getClassLoader().getResource("").getPath();
        String fullPath = URLDecoder.decode(path, "UTF-8");
        String pathArr[] = fullPath.split("/WEB-INF/classes/");
        System.out.println(fullPath);
        System.out.println(pathArr[0]);
        fullPath = pathArr[0];
        fullPath=fullPath.substring(1,fullPath.length());
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

        File file = new File(rutaArchivo);
        try (FileOutputStream fileOuS = new FileOutputStream(file)){
            if (file.exists()) {
                file.delete();

            }
            libro.write(fileOuS);
            fileOuS.flush();
            fileOuS.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        String host = InetAddress.getLocalHost().getCanonicalHostName();
        try {
            String fullUrlPath="http://"+host+":8080/wifi4eu/ExportRegistrationData.csv";
            URL url = new URL(fullUrlPath);
            try {
                Desktop.getDesktop().browse(url.toURI());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
    }
}

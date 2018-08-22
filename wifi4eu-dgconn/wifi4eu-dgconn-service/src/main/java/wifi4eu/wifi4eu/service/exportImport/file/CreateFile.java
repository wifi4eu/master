package wifi4eu.wifi4eu.service.exportImport.file;

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
import javax.servlet.http.HttpServletRequest;

public class CreateFile {
    public HttpServletRequest httpServletRequest;

    public CreateFile(){}

    public CreateFile(HttpServletRequest httpServletRequest){
        this.httpServletRequest=httpServletRequest;
    }

    public void createExcelFileRegistrationData(String [] header, String [][] document, String fileName)throws UnsupportedEncodingException, IOException{
        String path = this.getClass().getClassLoader().getResource("").getPath();
        String fullPath = URLDecoder.decode(path, "UTF-8");
        String pathArr[] = fullPath.split("/WEB-INF/classes/");
//        String pathArr[] = fullPath.split("/WEB-INF/");
        fullPath = pathArr[0];
        fullPath=fullPath.substring(1,fullPath.length());
        String protocol=httpServletRequest.getScheme();
        String port=String.valueOf(httpServletRequest.getServerPort());
        //String hostName=httpServletRequest.getServerName();
        String hostName = InetAddress.getLocalHost().getCanonicalHostName();
        String app=httpServletRequest.getContextPath();
        //String fileName="ExportRegistrationData.csv";
//        String filePath= fullPath+"/abacFiles/"+fileName;
        String filePath= fullPath+"/"+fileName;
        String sheet="Sheet1";
        XSSFWorkbook book= new XSSFWorkbook();
        XSSFSheet hoja1 = book.createSheet(sheet);
        CellStyle style = book.createCellStyle();
        Font font = book.createFont();
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

        //File fil = new File(fullPath+"/abacFiles/");
        File file = new File(filePath);
        try (FileOutputStream fileOuS = new FileOutputStream(file)){
            if (file.exists()) {
                file.delete();

            }
            book.write(fileOuS);
            fileOuS.flush();
            fileOuS.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        try {
//            String fullUrlPath = protocol+"://"+hostName+":"+port+app+"/abacFiles/"+fileName;
            String fullUrlPath = protocol+"://"+hostName+":"+port+app+"/"+fileName;
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

    public void createExcelFileBeneficiaryInformation(String [] header, String [][] document, String fileName)throws UnsupportedEncodingException, IOException{
        String path = this.getClass().getClassLoader().getResource("").getPath();
        String fullPath = URLDecoder.decode(path, "UTF-8");
        String pathArr[] = fullPath.split("/WEB-INF/classes/");
//        String pathArr[] = fullPath.split("/WEB-INF/");
        fullPath = pathArr[0];
        fullPath=fullPath.substring(1,fullPath.length());
        String protocol=httpServletRequest.getScheme();
        String port=String.valueOf(httpServletRequest.getServerPort());
        //String hostName=httpServletRequest.getServerName();
        String hostName = InetAddress.getLocalHost().getCanonicalHostName();
        String app=httpServletRequest.getContextPath();
        //String fileName="ExportRegistrationData.csv";
//        String filePath= fullPath+"/abacFiles/"+fileName;
        String filePath= fullPath+"/"+fileName;
        String sheet="Sheet1";
        XSSFWorkbook book= new XSSFWorkbook();
        XSSFSheet hoja1 = book.createSheet(sheet);
        CellStyle style = book.createCellStyle();
        Font font = book.createFont();
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

        //File fil = new File(fullPath+"/abacFiles/");
        File file = new File(filePath);
        try (FileOutputStream fileOuS = new FileOutputStream(file)){
            if (file.exists()) {
                file.delete();

            }
            book.write(fileOuS);
            fileOuS.flush();
            fileOuS.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        try {
//            String fullUrlPath = protocol+"://"+hostName+":"+port+app+"/abacFiles/"+fileName;
            String fullUrlPath = protocol+"://"+hostName+":"+port+app+"/"+fileName;
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

    public void createExcelFileBudgetaryCommitment(String [] header, String [][] document, String fileName)throws UnsupportedEncodingException, IOException{
        String path = this.getClass().getClassLoader().getResource("").getPath();
        String fullPath = URLDecoder.decode(path, "UTF-8");
        String pathArr[] = fullPath.split("/WEB-INF/classes/");
//        String pathArr[] = fullPath.split("/WEB-INF/");
        fullPath = pathArr[0];
        fullPath=fullPath.substring(1,fullPath.length());
        String protocol=httpServletRequest.getScheme();
        String port=String.valueOf(httpServletRequest.getServerPort());
        //String hostName=httpServletRequest.getServerName();
        String hostName = InetAddress.getLocalHost().getCanonicalHostName();
        String app=httpServletRequest.getContextPath();
        //String fileName="ExportRegistrationData.csv";
//        String filePath= fullPath+"/abacFiles/"+fileName;
        String filePath= fullPath+"/"+fileName;
        String sheet="Sheet1";
        XSSFWorkbook book= new XSSFWorkbook();
        XSSFSheet hoja1 = book.createSheet(sheet);
        CellStyle style = book.createCellStyle();
        Font font = book.createFont();
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

        //File fil = new File(fullPath+"/abacFiles/");
        File file = new File(filePath);
        try (FileOutputStream fileOuS = new FileOutputStream(file)){
            if (file.exists()) {
                file.delete();

            }
            book.write(fileOuS);
            fileOuS.flush();
            fileOuS.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        try {
//            String fullUrlPath = protocol+"://"+hostName+":"+port+app+"/abacFiles/"+fileName;
            String fullUrlPath = protocol+"://"+hostName+":"+port+app+"/"+fileName;
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

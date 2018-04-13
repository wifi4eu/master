package wifi4eu.wifi4eu.service.exportImport.excelFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;
import java.awt.Desktop;
import java.net.URISyntaxException;
import java.net.MalformedURLException;

public class FileDownload extends HttpServlet{

    private static final int BYTES_DOWNLOAD = 1024;

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException{

        String path = this.getClass().getClassLoader().getResource("").getPath();
        String fullPath = URLDecoder.decode(path, "UTF-8");
        String pathArr[] = fullPath.split("/WEB-INF/classes/");
        System.out.println(fullPath);
        System.out.println(pathArr[0]);
        fullPath = pathArr[0];
        URL url=null;
        try {
            fullPath=fullPath.substring(1,(fullPath.length()-1));
            url = new URL(fullPath);
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

//        response.setContentType("text/plain");
////        response.setHeader("Content-Disposition",
////                "attachment;filename=downloadname.txt");
//        response.setHeader("Content-Disposition",
//                "attachment;filename=/ExportRegistrationData.csv");
//        ServletContext ctx = getServletContext();
////        InputStream is = ctx.getResourceAsStream("/testing.txt");
//        InputStream is = ctx.getResourceAsStream(fullPath+"/ExportRegistrationData.csv");
//        int read=0;
//        byte[] bytes = new byte[BYTES_DOWNLOAD];
//        OutputStream os = response.getOutputStream();
//
//        while((read = is.read(bytes))!= -1){
//            os.write(bytes, 0, read);
//        }
//        os.flush();
//        os.close();
    }
}
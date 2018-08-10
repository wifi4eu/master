package wifi4eu.wifi4eu.apply;

import org.apache.commons.io.IOUtils;
import org.sqlite.SQLiteConfig;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Util {

    public static String getResource(String path) throws IOException {

        InputStream in = Util.class.getResourceAsStream(path);
        return IOUtils.toString(in, SQLiteConfig.Encoding.UTF8.toString());
    }


    public static String getStackTrace(Exception ex) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        return sw.toString();
    }
}

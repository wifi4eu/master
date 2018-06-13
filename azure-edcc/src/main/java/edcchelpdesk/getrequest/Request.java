package edcchelpdesk.getrequest;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


public class Request {

    public Request(){

    }

    public Object send(final String url, final String method, final Map<String, String> headers, final Type class2ParseResult) throws Exception {
        final HttpURLConnection con = createConnection(url, method, headers);
        final int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return generateJson(response, class2ParseResult);
    }

    private HttpURLConnection createConnection(final String url, final String method, final Map<String, String> headers) throws Exception {
        URL sourceUrl = new URL(url);
        HttpURLConnection con = (HttpURLConnection) sourceUrl.openConnection();
        con.setRequestMethod(method);

        for (Map.Entry<String, String> header : headers.entrySet()) {
            con.setRequestProperty(header.getKey(), header.getValue());
        }

        return con;
    }

    private Object generateJson(StringBuilder response, final Type class2ParseResult) {
        final Gson gson = new Gson();
        return gson.fromJson(response.toString(), class2ParseResult);
    }

}

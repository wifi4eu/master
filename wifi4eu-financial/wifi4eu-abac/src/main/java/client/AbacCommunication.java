package client;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Scanner;

@RestController
public class AbacCommunication {
    @RequestMapping(value = "/importJson", method = RequestMethod.POST, produces = "application/JSON")
    public ResponseAbac importJson(@RequestBody final String jsonStringFile, final HttpServletResponse response) {
        JSONObject json = new JSONObject(jsonStringFile);
        if (!checkJsonFileFormat(json)) {
            return new ResponseAbac(false, null, "The JSON file you imported doesn't have the correct format.");
        }
        String xml = XML.toString(json);
        File file = new File("C:\\test-abac.xml");
        try {
            FileOutputStream out = new FileOutputStream(file);
            if (!file.exists()) {
                file.createNewFile();
            }
            out.write(xml.getBytes());
            out.flush();
            out.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return new ResponseAbac(true, e.getMessage(), "Something went wrong during the import process.");
        }
        return new ResponseAbac(true, xml, "Import succesful!");
    }

    @RequestMapping(value = "/exportJson", method = RequestMethod.GET, produces = "application/JSON")
    public ResponseAbac exportJson(final HttpServletResponse response) {
        File file = new File("C:\\test-abac.xml");
        try {
            if (!file.exists()) {
                return new ResponseAbac(false, null, "The file cannot be exported.");
            }
            byte[] encoded = Files.readAllBytes(file.toPath());
            String content = new String(encoded, Charset.defaultCharset());
            JSONObject jsonObject = XML.toJSONObject(content);
            return new ResponseAbac(true, jsonObject.toString(), "Export succesful!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return new ResponseAbac(false, e.getMessage(), "Something went wrong during the export process.");
        }
    }

    public boolean checkJsonFileFormat(JSONObject json) {
        try {
            boolean correct = true;
            JSONArray publications = json.getJSONArray("publications");
            for (int i = 0; i < publications.length(); i++) {
                JSONObject publication = publications.getJSONObject(i);
                JSONArray appliers = publication.getJSONArray("appliers");
                for (int j = 0; j < appliers.length(); j++) {
                    JSONObject applier = appliers.getJSONObject(j);
                    if (!applier.has("benPubSubId") || !applier.has("beneficiary") || !applier.has("supplier") || !applier.has("status")) {
                        correct = false;
                    }
                }
            }
            return correct;
        } catch (JSONException e) {
            return false;
        }
    }
}

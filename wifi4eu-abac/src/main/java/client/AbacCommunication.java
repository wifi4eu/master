package client;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
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
            return new ResponseAbac(true, null, "Something went wrong during the import process.");
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
            String content = new Scanner(file).next();
            JSONObject jsonObject = XML.toJSONObject(content);
            return new ResponseAbac(true, jsonObject.toString(), "Export succesful!");
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return new ResponseAbac(false, null, "Something went wrong during the export process.");
        }
    }

    public boolean checkJsonFileFormat(JSONObject json) {
        boolean correct = false;
        if (json.has("publications")) {
            if (json.has("appliers")) {
                correct = true;
                JSONArray appliers = json.getJSONArray("appliers");
                for (int i = 0; i < appliers.length(); i++) {
                    JSONObject applier = appliers.getJSONObject(i);
                    if (!applier.has("benPubSubId") || !applier.has("beneficiary") || !applier.has("supplier") || !applier.has("status") ) {
                        correct = false;
                    }
                }
            }
        }
        return correct;
    }
}

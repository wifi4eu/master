package wifi4eu.wifi4eu.abac.rest;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;



@RestController
@RequestMapping(path="/svc")
public class UploadLEFService {

    @PostMapping("upload/LEF")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model)
            throws IOException  {

        // Save file on system
        if (true) {

            model.addAttribute("msg", "File uploaded successfully.");
        } else {
            model.addAttribute("msg", "Please select a valid file..");
        }

        return "fileUploadForm";
    }

    @RequestMapping( value = "test", method = RequestMethod.GET, produces = "text/plain")
    public String testRest() throws IOException {
        return "OK";
    }
}
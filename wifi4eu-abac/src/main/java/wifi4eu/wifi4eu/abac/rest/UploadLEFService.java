package wifi4eu.wifi4eu.abac.rest;

import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wifi4eu.wifi4eu.abac.rest.vo.ResponseVO;

@RestController
@RequestMapping(path="/svc")
public class UploadLEFService {

    @PostMapping("upload/LEF")
    
    public String singleFileUpload(@RequestBody String csvContents) throws IOException  {

    	boolean fileOk=true;
        // Save file on system

    	ResponseVO response=new ResponseVO();
    	
        if(fileOk){
        	response.setSuccess(true);
        	response.setData("File uploaded successfully.");
        	response.setXtotalCount(0);
        } else {
        	response.setSuccess(false);
        	response.setData("Please select a valid file.");
        }
        return response.toJson();
    }

    @RequestMapping( value = "test", method = RequestMethod.GET, produces = "text/plain")
    public String testRest() throws IOException {
        return "OK";
    }
}
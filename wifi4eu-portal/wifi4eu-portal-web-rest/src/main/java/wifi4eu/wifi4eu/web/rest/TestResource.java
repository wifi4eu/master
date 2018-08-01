package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;
import wifi4eu.wifi4eu.repository.registration.legal_files.LegalFilesRepository;
import wifi4eu.wifi4eu.service.location.NutsService;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(description = "TestResource")
@RequestMapping("test")
@ResponseStatus(HttpStatus.OK)
public class TestResource {

    /*@Autowired
    NutsService nutsService;

    @Autowired
    LegalFilesRepository legalFilesRepository;

    String basePath = "C:\\Gerard\\Wifi4EU\\top-30";

    @ApiOperation(value = "Test resource for Swagger implementation")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String exportDocuments() throws IOException {

        List<NutsDTO> nutsList = nutsService.getNutsByLevel(0);

        String fileName = "";
        String fileFolder="";
        Integer count = 0;

        for(NutsDTO nuts : nutsList){

            count = 0;
            String countryCode = nuts.getCountryCode();

            if(countryCode.equals("DK") || countryCode.equals("EE") || countryCode.equals("LV") || countryCode.equals("LT")
                    || countryCode.equals("LU") || countryCode.equals("HU") || countryCode.equals("MT")
                    || countryCode.equals("NL") || countryCode.equals("FI") || countryCode.equals("UK")) {
                createFolderIfNotexists(countryCode);

            *//*List<LegalFiles> listFiles = legalFilesRepository.getAllFilesForCountryTop30Registrations(countryCode, "application/pdf");



            for(LegalFiles file : listFiles){


                createFolderIfNotexists(countryCode, String.valueOf(file.getRegistration()));

                fileName = file.getRegistration() + "_" + file.getFileType() + ".pdf";;
                fileFolder = String.valueOf(file.getRegistration());
                if(createFile(fileFolder, fileName, file.getFileData())){
                    count ++;
                }
                if(count > 30){
                    break;
                }
            }

            if(count >= 30){
                continue;
            }*//*


                List<LegalFiles> listFiles = legalFilesRepository.getAllFilesForCountryTop30RegistrationsF1F3(countryCode, "application/pdf");
                for (LegalFiles file : listFiles) {


                    createFolderIfNotexists(countryCode, String.valueOf(file.getRegistration()));

                    fileName = file.getRegistration() + "_" + file.getFileType() + ".pdf";
                    ;
                    fileFolder = String.valueOf(file.getRegistration());
                    createFile(fileFolder, fileName, file.getFileData(), countryCode);
                }

            *//*if(count >= 30){
                continue;
            }



            listFiles = legalFilesRepository.getAllFilesForCountryTop30Registrations(countryCode, "image/png");
            for(LegalFiles file : listFiles){


                createFolderIfNotexists(countryCode, String.valueOf(file.getRegistration()));

                fileName = file.getRegistration() + "_" + file.getFileType() + ".png";
                fileFolder = String.valueOf(file.getRegistration());
                if(createFile(fileFolder, fileName, file.getFileData(), countryCode)){
                    count ++;
                }
                if(count > 30){
                    break;
                }
            }

            if(count >= 30){
                continue;
            }

            listFiles = legalFilesRepository.getAllFilesForCountryTop30Registrations(countryCode, "image/jpeg");
            for(LegalFiles file : listFiles){


                createFolderIfNotexists(countryCode, String.valueOf(file.getRegistration()));

                fileName = file.getRegistration() + "_" + file.getFileType() + ".jpg";
                fileFolder = String.valueOf(file.getRegistration());
                if(createFile(fileFolder, fileName, file.getFileData(), countryCode)){
                    count ++;
                }
                if(count > 30){
                    break;
                }
            }

            if(count >= 30){
                continue;
            }*//*
                System.out.println("Missing " + (30 - count) + " files for country " + countryCode);
            }

        }

        return "hello eUI";
    }

    private void createFolderIfNotexists(String countryCode, String s) {
        createFolderIfNotexists(countryCode + "\\" + s);
    }

    private boolean createFile(String fileFolder, String fileName, String fileData, String countryCode) throws IOException {

        byte[] data = Base64.decodeBase64(fileData);
        try (OutputStream stream = new FileOutputStream(basePath + "\\" + countryCode + "\\" + fileFolder + "\\" + fileName)) {
            stream.write(data);
        }
        return true;

    }

    private void createFolderIfNotexists(String registration) {
        Path path = FileSystems.getDefault().getPath(basePath + "\\" + registration);
        if(!Files.exists(path)) {
            File dir = new File(basePath + "\\" + registration);
            dir.mkdir();
        }
    }*/

}

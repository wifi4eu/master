package wifi4eu.wifi4eu.service.voucher.util;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.location.LauService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class ScenariosService {

    public static final String SCENARIO1_XLSX = "C:\\scenario_list1.xlsx";
    public static final String SCENARIO2_XLSX = "C:\\scenario_list2.xlsx";
    public static final String SCENARIO3_XLSX = "C:\\scenario_list3.xlsx";

    @Autowired
    LauService lauService;

    @Autowired
    MunicipalityService municipalityService;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    UserService userService;

    @Autowired
    RegistrationService registrationService;

    public ScenariosService(){

    }

    @Transactional
    public void readScenarioExcel(int index, int callId, HttpServletRequest request) throws IOException, InvalidFormatException {

        UserContext userContext = UserHolder.getUser();
        UserDTO user = userService.getUserByUserContext(userContext);

        if(callId <= 0){
          callId = 1;
        }

        File file = new File("");

        if(index == 1){
            file = new File(SCENARIO1_XLSX);
        }
        else if(index == 2){
            file = new File(SCENARIO2_XLSX);
        }else if(index == 3){
            file = new File(SCENARIO3_XLSX);
        }

        Workbook workbook = new XSSFWorkbook(file);


        Sheet sheet = workbook.getSheetAt(0);

        DataFormatter dataFormatter = new DataFormatter();

        Iterator<Row> rowIterator = sheet.rowIterator();

        List<List<String>> rows = new ArrayList<>();

        List<String> muns = new ArrayList<>();
        List<String> countries = new ArrayList<>();

        try{

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if(row.getRowNum() > 0){
                    // Now let's iterate over the columns of the current row
                    Iterator<Cell> cellIterator = row.cellIterator();

                    List<String> cellsRow = new ArrayList<>();

                    ApplicationDTO applicationDTO = new ApplicationDTO();
                    MunicipalityDTO municipalityDTO = new MunicipalityDTO();
                    RegistrationDTO registrationDTO = new RegistrationDTO();

                    String country = "";
                    String mun = "";

                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        String cellValue = dataFormatter.formatCellValue(cell);
                        cellsRow.add(cellValue); cellValue = cellValue.trim();

                        switch (cell.getColumnIndex()){
                            case 0:
                                Date date = new Date(cellValue);
                                long unix = date.getTime()/1000;
                                applicationDTO.setDate(date.getTime());
                                break;
                            case 1:
                                municipalityDTO.setCountry(cellValue);
                                country = cellValue;
                                break;
                            case 2:
                                mun = cellValue;
                                break;
                            case 3:
                                if(cellValue.equalsIgnoreCase("Applied")){
                                    applicationDTO.setStatus(0);
                                }
                                else if(cellValue.equalsIgnoreCase("Application invalid")){
                                    applicationDTO.setStatus(1);
                                }
                                else if(cellValue.equalsIgnoreCase("Application valid")){
                                    applicationDTO.setStatus(2);
                                }
                                else if(cellValue.equalsIgnoreCase("Application pending follow up")){
                                    applicationDTO.setStatus(3);
                                }
                                break;
                        }
                    }

                    if(country.contains(" (")){
                        country = country.substring(country.indexOf("(")+1, country.length());
                        country = "%"+country;
                    }
                    if(mun.contains(" - ")){
                        if(country.contains("BULGARIA")){
                            mun = mun.substring(0, mun.indexOf("-")-2);
                            mun = mun+"%";
                        }else{
                            mun = mun.substring(mun.indexOf("-")+2, mun.length());
                            mun = "%"+mun;
                        }

                    }
                    /*country = country.replaceAll("\\s+$", "");*/
                    if(country.trim().equalsIgnoreCase("ITALIA")){
                        country = country.trim().concat("%");
                    }

                    if(country.trim().equalsIgnoreCase("IRELAND") && mun.trim().contains("Bouzov")){
                        mun = "South Dublin";
                    }

                    List<LauDTO> lauDTOList = lauService.getLauByName1Country(country, mun);

                    if(lauDTOList.size() > 0){
                        LauDTO lauDTO = lauDTOList.get(0);
                        municipalityDTO.setName(lauDTO.getName1());
                        municipalityDTO.setLauId(lauDTO.getId());
                        municipalityDTO.setAddress("address" + row.getRowNum());

                        MunicipalityDTO resM = municipalityService.saveMunicipality(municipalityDTO);
                        registrationDTO.setMunicipalityId(resM.getId());
                        registrationDTO.setAllFilesFlag(1);
                        RegistrationDTO resR = registrationService.createRegistration(registrationDTO);
                        applicationDTO.setCallId(callId);
                        applicationDTO.setRegistrationId(resR.getId());
                        ApplicationDTO resA = applicationService.createApplication(applicationDTO, request);
                    }
                    else{
                        lauDTOList = lauService.getLauByName1(mun);
                        if(lauDTOList.size() > 0){
                            LauDTO lauDTO = lauDTOList.get(0);

                            municipalityDTO.setName(lauDTO.getName1());
                            municipalityDTO.setLauId(lauDTO.getId());
                            municipalityDTO.setAddress("address" + row.getRowNum());

                            MunicipalityDTO resM = municipalityService.saveMunicipality(municipalityDTO);
                            registrationDTO.setMunicipalityId(resM.getId());
                            registrationDTO.setAllFilesFlag(1);
                            RegistrationDTO resR = registrationService.createRegistration(registrationDTO);
                            applicationDTO.setCallId(callId);
                            applicationDTO.setRegistrationId(resR.getId());
                            ApplicationDTO resA = applicationService.createApplication(applicationDTO, request);
                        }else{
                            if(mun.contains("-")){
                                mun = mun.substring(mun.indexOf("-")+1, mun.length());
                                mun = "%"+mun;
                            }
                            lauDTOList = lauService.getLauByName1(mun);
                            if(lauDTOList.size() > 0){
                                LauDTO lauDTO = lauDTOList.get(0);

                                municipalityDTO.setName(lauDTO.getName1());
                                municipalityDTO.setLauId(lauDTO.getId());
                                municipalityDTO.setAddress("address" + row.getRowNum());

                                MunicipalityDTO resM = municipalityService.saveMunicipality(municipalityDTO);
                                registrationDTO.setMunicipalityId(resM.getId());
                                registrationDTO.setAllFilesFlag(1);
                                RegistrationDTO resR = registrationService.createRegistration(registrationDTO);
                                applicationDTO.setCallId(callId);
                                applicationDTO.setRegistrationId(resR.getId());
                                ApplicationDTO resA = applicationService.createApplication(applicationDTO, request);
                            }else{
                                mun = mun.concat("%");

                                lauDTOList = lauService.getLauByName1(mun);
                                if(lauDTOList.size() > 0){
                                    LauDTO lauDTO = lauDTOList.get(0);

                                    municipalityDTO.setName(lauDTO.getName1());
                                    municipalityDTO.setLauId(lauDTO.getId());
                                    municipalityDTO.setAddress("address" + row.getRowNum());

                                    MunicipalityDTO resM = municipalityService.saveMunicipality(municipalityDTO);
                                    registrationDTO.setMunicipalityId(resM.getId());
                                    registrationDTO.setAllFilesFlag(1);
                                    RegistrationDTO resR = registrationService.createRegistration(registrationDTO);
                                    applicationDTO.setCallId(callId);
                                    applicationDTO.setRegistrationId(resR.getId());
                                    ApplicationDTO resA = applicationService.createApplication(applicationDTO, request);
                                }
                                else{
                                  muns.add(mun);
                                  countries.add(country);
                                }
                            }
                        }
                    }

                    rows.add(cellsRow);
                }
            }

            int i = 0;
            for (String string : muns) {
                System.out.println(string);
                System.out.println(countries.get(i));
                i++;
            }
            System.out.println(i);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

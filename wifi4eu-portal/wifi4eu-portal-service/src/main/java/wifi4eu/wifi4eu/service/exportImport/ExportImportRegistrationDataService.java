package wifi4eu.wifi4eu.service.exportImport;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.mapper.municipality.MunicipalityMapper;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.service.exportImport.excelFile.CreateExcelFile;
import wifi4eu.wifi4eu.service.exportImport.excelFile.ReadExcelFile;

import java.util.List;

@Service
public class ExportImportRegistrationDataService {
//    @Autowired
//    UserService userService;
    @Autowired
    MunicipalityMapper municipalityMapper;

    @Autowired
    MunicipalityRepository municipalityRepository;

    private final Logger _log = LoggerFactory.getLogger(ExportImportRegistrationDataService.class);


    public void exportRegistrationData() throws Exception {
          _log.info("exportRegistrationData");
           List<MunicipalityDTO> municipalityList = municipalityMapper.toDTOList(Lists.newArrayList(municipalityRepository.findAll()));
           CreateExcelFile cF=new CreateExcelFile();
           String [] header={"id", "name", "address", "addressNum", "postalCode", "country", "lauId"};
           String [][] document=new String[municipalityList.size()][7];
           for(int i=0; i<municipalityList.size(); i++){
               document[i][0]=String.valueOf(municipalityList.get(i).getId());
               document[i][1]=municipalityList.get(i).getName();
               document[i][2]=municipalityList.get(i).getAddress();
               document[i][3]=municipalityList.get(i).getAddressNum();
               document[i][4]=municipalityList.get(i).getPostalCode();
               document[i][5]=municipalityList.get(i).getCountry();
               document[i][6]=String.valueOf(municipalityList.get(i).getLauId());
           }
           cF.createExcelFile(header, document);
//           List<MunicipalityDTO> municipalityList = municipalityMapper.toDTOList(Lists.newArrayList(municipalityRepository.findExport()));

//        //ExportRegistrationDataDTO exportRegistrationDataDTO = exportRegistrationDataMapper.toDTOList(Lists.newArrayList(exportRegistrationDataRepository.findAll()));
//        for exportRegistrationDataDTO escribir en un archivo excel.
    }

    @Transactional
    //public void importRegistrationData(String name) throws Exception{
        public void importRegistrationData() throws Exception{
          _log.info("importRegistrationData");
//        // pides el nombre del archivo excel y lo vas a buscar a la carpeta predefinida
//        // lee archivo y mientras lees archivo
//        mayorMapper.toDTO(mayorRepository.save(mayorMapper.toEntity(mayorDTO)));
//        //end for
    }


}
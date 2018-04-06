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
import wifi4eu.wifi4eu.common.dto.model.ExportImportRegistrationDataDTO;
import wifi4eu.wifi4eu.mapper.exportImport.ExportImportRegistrationDataMapper;
import wifi4eu.wifi4eu.repository.exportImport.ExportImportRegistrationDataReporsitory;
import wifi4eu.wifi4eu.service.exportImport.excelFile.CreateExcelFile;
import wifi4eu.wifi4eu.service.exportImport.excelFile.ReadExcelFile;

import java.util.List;

@Service
public class ExportImportRegistrationDataService {
//    @Autowired
//    MunicipalityMapper municipalityMapper;
//
//    @Autowired
//    MunicipalityRepository municipalityRepository;

    @Autowired
    ExportImportRegistrationDataMapper exportImportRegistrationDataMapper;

    @Autowired
    ExportImportRegistrationDataReporsitory exportImportRegistrationDataReporsitory;

    private final Logger _log = LoggerFactory.getLogger(ExportImportRegistrationDataService.class);

    public void exportRegistrationData() throws Exception {
          _log.info("exportRegistrationData");
           //List<MunicipalityDTO> municipalityList = municipalityMapper.toDTOList(Lists.newArrayList(municipalityRepository.findAll()));
           List<ExportImportRegistrationDataDTO> exportImportRegistrationDataList = exportImportRegistrationDataMapper.toDTOList(Lists.newArrayList(exportImportRegistrationDataReporsitory.findExportImport()));
           CreateExcelFile cF=new CreateExcelFile();
           //String [] header={"id", "name", "address", "addressNum", "postalCode", "country", "lauId"};
           String [] header={"EU Rank", "Country Rank", "Country Name", "Municipality name", "Issue", "Number of registrations"};
           String [][] document=new String[exportImportRegistrationDataList.size()][7];
//           for(int i=0; i<municipalityList.size(); i++){
//               document[i][0]=String.valueOf(municipalityList.get(i).getId());
//               document[i][1]=municipalityList.get(i).getName();
//               document[i][2]=municipalityList.get(i).getAddress();
//               document[i][3]=municipalityList.get(i).getAddressNum();
//               document[i][4]=municipalityList.get(i).getPostalCode();
//               document[i][5]=municipalityList.get(i).getCountry();
//               document[i][6]=String.valueOf(municipalityList.get(i).getLauId());
//           }
            for(int i=0; i<exportImportRegistrationDataList.size(); i++){
                document[i][0]=String.valueOf(exportImportRegistrationDataList.get(i).getrId());
                document[i][1]=exportImportRegistrationDataList.get(i).getmCountry();
                document[i][2]=exportImportRegistrationDataList.get(i).getmCountry();
                document[i][3]=exportImportRegistrationDataList.get(i).getmName();
                document[i][4]=exportImportRegistrationDataList.get(i).getmName();
                document[i][5]=exportImportRegistrationDataList.get(i).getmName();
            }
           cF.createExcelFile(header, document);
//           List<MunicipalityDTO> municipalityList = municipalityMapper.toDTOList(Lists.newArrayList(municipalityRepository.findExport()));
//           xportRegistrationDataDTO exportRegistrationDataDTO = exportRegistrationDataMapper.toDTOList(Lists.newArrayList(exportRegistrationDataRepository.findAll()));
    }

    @Transactional
    //public void importRegistrationData(String name) throws Exception{
        public void importRegistrationData() throws Exception{
          _log.info("importRegistrationData");
          //ReadExcelFile rF=new ReadExcelFile(municipalityRepository, municipalityMapper, exportImportRegistrationDataReporsitory, exportImportRegistrationDataMapper);
          ReadExcelFile rF=new ReadExcelFile(exportImportRegistrationDataReporsitory, exportImportRegistrationDataMapper);
          rF.readExcelFile();
//        // pides el nombre del archivo excel y lo vas a buscar a la carpeta predefinida
//        // lee archivo y mientras lees archivo
//        mayorMapper.toDTO(mayorRepository.save(mayorMapper.toEntity(mayorDTO)));
//        //end for
    }


}
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
    @Autowired
    ExportImportRegistrationDataMapper exportImportRegistrationDataMapper;

    @Autowired
    ExportImportRegistrationDataReporsitory exportImportRegistrationDataReporsitory;

    private final Logger _log = LoggerFactory.getLogger(ExportImportRegistrationDataService.class);

    public void exportRegistrationData() throws Exception {
          _log.info("exportRegistrationData");
           List<ExportImportRegistrationDataDTO> exportImportRegistrationDataList = exportImportRegistrationDataMapper.toDTOList(Lists.newArrayList(exportImportRegistrationDataReporsitory.findExportImport()));
           CreateExcelFile cF=new CreateExcelFile();
           String [] header={"EU Rank", "Country Rank", "Country Name", "Municipality name", "Issue", "Number of registrations"};
           String [][] document=new String[exportImportRegistrationDataList.size()][7];
           //Crear operaciones para eurank, countryrank, issue i number Rgistration
            for(int i=0; i<exportImportRegistrationDataList.size(); i++){
                String country=exportImportRegistrationDataList.get(i).getCountryName();
                String municipailty=exportImportRegistrationDataList.get(i).getMunicipalityName();
                int countCountry=0;
                int countMunicipality=0;
                for(int u=0; u<exportImportRegistrationDataList.size(); u++){
                    if(country.equals(exportImportRegistrationDataList.get(u).getCountryName())){
                        countCountry++;
                    }
                    if(municipailty.equals(exportImportRegistrationDataList.get(u).getMunicipalityName())){
                        countMunicipality++;
                    }
                }
                document[i][0]=String.valueOf(exportImportRegistrationDataList.get(i).getEuRank());
                document[i][1]=String.valueOf(countCountry);
                document[i][2]=exportImportRegistrationDataList.get(i).getCountryName();
                document[i][3]=exportImportRegistrationDataList.get(i).getMunicipalityName();
                document[i][4]=String.valueOf(exportImportRegistrationDataList.get(i).getEuRank());
                document[i][5]=String.valueOf(countMunicipality);
            }
           cF.createExcelFile(header, document);
    }

    @Transactional
    public void importRegistrationData() throws Exception{
          _log.info("importRegistrationData");
          ReadExcelFile rF=new ReadExcelFile(exportImportRegistrationDataReporsitory, exportImportRegistrationDataMapper);
          rF.readExcelFile();
    }


}
package wifi4eu.wifi4eu.service.exportImport;

import cec.budg.soatube.client.async.JmsProducerLocal;
import com.google.gson.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.mapper.exportImport.ValidatedLEFMapper;
import wifi4eu.wifi4eu.repository.exportImport.ValidatedLEFRepository;
import wifi4eu.wifi4eu.mapper.exportImport.ValidatedBCMapper;
import wifi4eu.wifi4eu.repository.exportImport.ValidatedBCRepository;
import wifi4eu.wifi4eu.service.exportImport.callAbac.CallAbac;
import wifi4eu.wifi4eu.service.exportImport.callAbac.JsonToXml;
import wifi4eu.wifi4eu.common.dto.model.ValidatedLEFDTO;
import wifi4eu.wifi4eu.common.dto.model.ValidatedBCDTO;
import java.util.Date;
import java.util.List;import com.google.common.collect.Lists;



@Service
public class ExportImportFinancialAbacService {
    @Autowired
    ValidatedLEFMapper validatedLEFMapper;

    @Autowired
    ValidatedLEFRepository validatedLEFRepository;

    @Autowired
    ValidatedBCMapper validatedBCMapper;

    @Autowired
    ValidatedBCRepository validatedBCRepository;


    private final Logger _log = LoggerFactory.getLogger(ExportImportFinancialAbacService.class);

    @Transactional
    public void importLegalEntityF(JmsProducerLocal jmsProducer, final String jsonStringFile) throws Exception{
        _log.info("importLegalEntityF");
        JsonToXml jX=new JsonToXml();
        String xml=jX.jsonToXml(jsonStringFile);
        CallAbac rF=new CallAbac();
        //Call and save the result.
        rF.readImportFileLEF(jmsProducer, xml);
    }

    @Transactional
    public void importBudgetaryCommitment(JmsProducerLocal jmsProducer, final String jsonStringFile) throws Exception{
        _log.info("importBudgetaryCommitment");
        JsonToXml jX=new JsonToXml();
        String xml=jX.jsonToXml(jsonStringFile);
        CallAbac rF=new CallAbac();
        //Call and save the result.
        rF.readImportFileBC(jmsProducer, xml);
    }

    public ResponseDTO exportLegalEntityFBCValidate() {
        _log.info("exportLegalEntityFBCValidate");
        ResponseDTO result = new ResponseDTO();
        Gson gson = new GsonBuilder().create();
        JsonParser parser = new JsonParser();
        JsonObject resultJson = new JsonObject();
        //Leer Tables ValidatedLef y ValidatedBC y poner el resultado en un ResultDTO.
        List<ValidatedLEFDTO> applicationsLEF = validatedLEFMapper.toDTOList(Lists.newArrayList(validatedLEFRepository.findLEF()));
        JsonArray applicationsLEFJsonArray = new JsonArray();
        if (applicationsLEF != null && !applicationsLEF.isEmpty()) {
            for (ValidatedLEFDTO application : applicationsLEF) {
//                long exportDate = new Date().getTime();
//                application.setLefExport(exportDate);
//                application.setBcExport(exportDate);
//                application.setLcExport(exportDate);
//                benPubSupRepository.save(benPubSupMapper.toEntity(application));
                JsonObject applicationJson = parser.parse(gson.toJson(application)).getAsJsonObject();
                //applicationsLEFJsonArray.add(applicationJson+", {\"status\":MOD/0}");
                applicationsLEFJsonArray.add(applicationJson);
            }
        }
//        resultJson.addProperty("version", _version);
        resultJson.addProperty("createTime", new Date().getTime());
        resultJson.add("validatedLEF", applicationsLEFJsonArray);

//        List<ValidatedBCDTO> applicationsBC = validatedBCMapper.toDTOList(Lists.newArrayList(validatedBCRepository.findBC()));
//        JsonArray applicationsBCJsonArray = new JsonArray();
//        if (applicationsBC != null && !applicationsBC.isEmpty()) {
//            for (ValidatedBCDTO application : applicationsBC) {
////                long exportDate = new Date().getTime();
////                application.setLefExport(exportDate);
////                application.setBcExport(exportDate);
////                application.setLcExport(exportDate);
////                benPubSupRepository.save(benPubSupMapper.toEntity(application));
//                JsonObject applicationJson = parser.parse(gson.toJson(application)).getAsJsonObject();
//                applicationsBCJsonArray.add(applicationJson);
//            }
//        }
////        resultJson.addProperty("version", _version);
//        resultJson.add("validatedBC", applicationsBCJsonArray);
        result.setSuccess(true);
//        result.setData(resultJson.toString());
        result.setData("[" + resultJson.toString() + "]");
        result.setError(null);
        return result;
    }

}
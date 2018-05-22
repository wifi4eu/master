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



@Service
public class ExportImportWifi4euFinancialAbacService {
    @Autowired
    ValidatedLEFMapper validatedLEFMapper;

    @Autowired
    ValidatedLEFRepository validatedLEFRepository;

    @Autowired
    ValidatedBCMapper validatedBCMapper;

    @Autowired
    ValidatedBCRepository validatedBCRepository;


    private final Logger _log = LoggerFactory.getLogger(ExportImportWifi4euFinancialAbacService.class);

    @Transactional
    public void importLegalEntityF(JmsProducerLocal jmsProducer, final String jsonStringFile) throws Exception{
            _log.info("importLegalEntityF");
            //Call and save the result.
            JsonToXml jX=new JsonToXml();
            String xml=jX.jsonToXml(jsonStringFile);
            //CallAbac rF=new CallAbac(exportImportLEFRepository, exportImportLEFMapper);
            CallAbac rF=new CallAbac();
            rF.readImportFileLEF(jmsProducer, xml);
    }

    @Transactional
    public void importBudgetaryCommitment(JmsProducerLocal jmsProducer, final String jsonStringFile) throws Exception{
            _log.info("importBudgetaryCommitment");
            //Call and save the result.
            JsonToXml jX=new JsonToXml();
            String xml=jX.jsonToXml(jsonStringFile);
            //CallAbac rF=new CallAbac(exportImportLEFRepository, exportImportLEFMapper);
            CallAbac rF=new CallAbac();
            rF.readImportFileBC(jmsProducer, xml);
    }

    public ResponseDTO exportLegalEntityFBCValidate() throws Exception {
        _log.info("exportLegalEntityFBCValidate");

        ResponseDTO result = new ResponseDTO();
        Gson gson = new GsonBuilder().create();
        JsonParser parser = new JsonParser();
        JsonObject resultJson = new JsonObject();
//        List<BenPubSupDTO> applications = benPubSupMapper.toDTOList(Lists.newArrayList(benPubSupRepository.findAll()));
//        JsonArray applicationsJsonArray = new JsonArray();
//        if (applications != null && !applications.isEmpty()) {
//            for (BenPubSupDTO application : applications) {
//                long exportDate = new Date().getTime();
//                application.setLefExport(exportDate);
//                application.setBcExport(exportDate);
//                application.setLcExport(exportDate);
//                benPubSupRepository.save(benPubSupMapper.toEntity(application));
//                JsonObject applicationJson = parser.parse(gson.toJson(application)).getAsJsonObject();
//                applicationsJsonArray.add(applicationJson);
//            }
//        }
//        resultJson.addProperty("version", _version);
//        resultJson.addProperty("createTime", new Date().getTime());
//        resultJson.add("applications", applicationsJsonArray);
        result.setSuccess(true);
        result.setData(resultJson.toString());
        result.setError(null);
        return result;
    }

}
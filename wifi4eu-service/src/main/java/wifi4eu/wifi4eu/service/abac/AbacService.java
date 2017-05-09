package wifi4eu.wifi4eu.service.abac;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.repository.supplier.SupplierRepository;
import wifi4eu.wifi4eu.service.beneficiary.BeneficiaryService;
import wifi4eu.wifi4eu.service.supplier.SupplierService;

import javax.json.*;
import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

/**
 * Created by jmagrinc on 08/05/2017.
 */
@Service
public class AbacService {
    private final static Logger _log = Logger.getLogger(AbacService.class);
    private final static String _version = "beta-0";
    @Autowired
    private SupplierService supplierService;

    @Autowired
    private BeneficiaryService beneficiaryService;

    public JsonObject exportAbacInformation() {
        _log.info("Creating exportAbacInformation...");

        Map<String, Object> config = new HashMap<String, Object>();
        config.put("javax.json.stream.JsonGenerator.prettyPrinting", Boolean.valueOf(true));

        JsonBuilderFactory factory = Json.createBuilderFactory(config);
        JsonObjectBuilder jsonBase = factory.createObjectBuilder();
        jsonBase.add("version", _version);
        jsonBase.add("createTime", new Date().getTime());

        List<SupplierDTO> allSuppliers = supplierService.getAllSuppliers();
        //List<BeneficiaryDTO> allBeneficiary = beneficiaryService.getAll();

        ObjectMapper mapper = new ObjectMapper();

        if (allSuppliers != null && !allSuppliers.isEmpty()) {
            JsonArrayBuilder suppliersArray = factory.createArrayBuilder();
            try {
                for (SupplierDTO item : allSuppliers) {
                    suppliersArray.add(mapper.writeValueAsString(item));
                }
            } catch (Exception ex) {
                _log.error("Error on object serialization to JSON");
            }

            jsonBase.add("suppliers", suppliersArray);
        }

        _log.info("Creating exportAbacInformation...");
        return jsonBase.build();
    }

}

package wifi4eu.wifi4eu.web.rest.financial;

import javax.json.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.BenPubSupDTO;
import wifi4eu.wifi4eu.common.dto.model.LauDTO;
import wifi4eu.wifi4eu.common.dto.model.LegalEntityDTO;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.dgconn.DgconnService;
import wifi4eu.wifi4eu.service.location.LocationService;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/dgconn", description = "DgconnResource")
@RequestMapping("dgconn")
public class DgconnResource {

    Logger _log = Logger.getLogger(DgconnResource.class);

    @Autowired
    private DgconnService dgconnService;

    @Autowired
    private LocationService locationService;

    @ApiOperation(value = "Distribute vouchers")
    @RequestMapping(value = "/distribute", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public ResponseDTO distribute() {
        try {
            List<BenPubSupDTO> benPubSupDTOList = dgconnService.distribute();
            return new ResponseDTO(true, benPubSupDTOList, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }

    @ApiOperation(value = "Get countries voucher info")
    @RequestMapping(value = "/getCountriesVoucherInfo", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getCountriesVoucherInfo() {
        try {
            // Prepare the Json stuff
            Map<String, Object> config = new HashMap<String, Object>();
            config.put("javax.json.stream.JsonGenerator.prettyPrinting", Boolean.valueOf(true));
            JsonBuilderFactory factory = Json.createBuilderFactory(config);
            JsonObjectBuilder builder = factory.createObjectBuilder();
            
            // Get all the countries on the DB
            List<NutsDTO> countriesList = locationService.getNutsByLevel(0);
            for (NutsDTO country : countriesList) {
                int municipalities = 0;
                int requests = 0;
                int awarded = 0;
                //String name = country.getName();
                String name = "";
                List<LauDTO> municipalitiesList = locationService.getLauByCountryCode(country.getCountryCode());
                municipalities = municipalitiesList.size();
                List<BenPubSupDTO> requestsList = dgconnService.getAllRequests();
                List<LegalEntityDTO> legalEntitiesList = dgconnService.getAllLegalEntitiesByCountryCode(country.getCountryCode());
                for (BenPubSupDTO request : requestsList) {
                    for (LegalEntityDTO entity : legalEntitiesList) {
                        if (request.getBeneficiaryId().equals(entity.getLegalEntityId())) {
                            requests++;
                            if (request.isAwarded()) {
                                awarded++;
                            }
                        }
                    }
                }
                builder.add(country.getCountryCode(), factory.createObjectBuilder()
                    .add("name", name)
                    .add("municipalities", municipalities)
                    .add("requests", requests)
                    .add("awarded", awarded));
            }
            return new ResponseDTO(true, builder.build().toString(), null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }
    
}

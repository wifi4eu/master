package wifi4eu.wifi4eu.service.access_point;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.entity.access_point.AccessPoint;
import wifi4eu.wifi4eu.repository.access_point.AccessPointRepository;
import wifi4eu.wifi4eu.repository.installation.InstallationSiteRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccessPointService {

    @Autowired
    AccessPointRepository accessPointRepository;

    @Autowired
    InstallationSiteRepository installationSiteRepository;

    // TODO missing field number (not appears on DB)
    // TODO missing device_type field
    private String[] FIELDS_ACCESS_POINTS_ORDER = {"id", "location", "location_type", "device_brand", "device_type", "model_number", "serial_number", "mac_address"};

    public ResponseDTO findAccessPointsPerInstallationSite(Map<String, Object> map){
        ResponseDTO response = new ResponseDTO();

        // we should check if it's null. We don't have the class Validation
        if (!map.isEmpty()){
            String order = "asc";
            String field = "device_brand";
            int id_installationSite = 0;
            int page = 0;
            int delta = 10;

            if (map.containsKey("id_installationSite") && installationSiteRepository.countInstallationSiteById((int) map.get("id_installationSite")) == 1) {

                id_installationSite = (int) map.get("id_installationSite");

                try {

                if (map.containsKey("page") && (int) map.get("page") > 0) {
                    page = (int) map.get("page");
                }

                if (map.containsKey("delta") && (int) map.get("delta") > 0) {
                    delta = (int) map.get("delta");
                }

                if (map.containsKey("order")) {
                    if (String.valueOf(map.get("order")).equalsIgnoreCase("desc")) {
                        order = "desc";
                    }
                }

                if (map.containsKey("fieldOrder")) {
                    field = acceptFieldNameQueryInstallationSites(String.valueOf(map.get("fieldOrder")));
                }


                Map<String, Object> mapResult = new HashMap<String, Object>();

                ArrayList<AccessPoint> installationSites = Lists.newArrayList(accessPointRepository.searchAccessPointByInstallationSite(page, delta, id_installationSite, field, order));
                int countResults = accessPointRepository.countAccessPointByInstallationSite(page, delta, id_installationSite, field, order);
                mapResult.put("data", installationSites);
                mapResult.put("count", countResults);
                response.setSuccess(true);
                response.setData(mapResult);

                } catch (Exception ex) {
                    response.setSuccess(false);
                    response.setError(new ErrorDTO(404, "Error - Invalid integers / fields"));
                }
            } else {
                response.setSuccess(false);
                response.setError(new ErrorDTO(404, "Installation Site not found"));
            }
        } else {
            response.setSuccess(false);
            response.setError(new ErrorDTO(404,"Empty body"));
        }

        return response;
    }

    private String acceptFieldNameQueryInstallationSites(String fieldEntry) {
        String field = "device_brand";
        String fieldJson = fieldEntry;
        for (int i = 0; i < FIELDS_ACCESS_POINTS_ORDER.length; i++) {
            if (fieldJson.equals(FIELDS_ACCESS_POINTS_ORDER[i])) {
                field = fieldJson;
                break;
            }
        }
        return field;
    }


}

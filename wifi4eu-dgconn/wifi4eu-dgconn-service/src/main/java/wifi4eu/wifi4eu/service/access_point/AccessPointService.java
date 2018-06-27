package wifi4eu.wifi4eu.service.access_point;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.entity.access_point.AccessPoint;
import wifi4eu.wifi4eu.repository.access_point.AccessPointRepository;
import wifi4eu.wifi4eu.repository.installation.InstallationSiteRepository;
import wifi4eu.wifi4eu.service.installation.InstallationSiteService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccessPointService {

    @Autowired
    AccessPointRepository accessPointRepository;

    @Autowired
    InstallationSiteRepository installationSiteRepository;

    @Autowired
    PermissionChecker permissionChecker;

    @Autowired
    InstallationSiteService installationSiteService;
    // TODO missing device_type field
    private String[] FIELDS_ACCESS_POINTS_ORDER = {"number", "location", "location_type", "device_brand", "device_type", "model_number", "serial_number", "mac_address","isIndoor"};




    @Transactional
    public ResponseDTO getAccessPointById(int id) {
        ResponseDTO response = new ResponseDTO();
        AccessPoint accessPoint = accessPointRepository.findOne(id);
        if (accessPoint != null) {

            if (!checkPermissions(accessPoint.getIdInstallationSite(), id))
                return permissionChecker.getAccessDeniedResponse();

            response.setSuccess(true);
            response.setData(accessPoint);
        } else {
            response.setSuccess(false);
            response.setData("Error");
            response.setError(new ErrorDTO(404, "Access Point not found. ID : " + id));
        }
        return response;
    }

    @Transactional
    public ResponseDTO findAccessPointsPerInstallationSite(Map<String, Object> map) {
        ResponseDTO response = new ResponseDTO();
        // we should check if it's null. We don't have the class Validation
        if (!map.isEmpty()) {
            String order = "asc";
            String field = "device_brand";
            int id_installationSite = 0;
            int page = 0;
            int delta = 10;

            if (map.containsKey("id_installationSite") && installationSiteRepository.countInstallationSiteById((int) map.get("id_installationSite")) == 1) {

                id_installationSite = (int) map.get("id_installationSite");

                if (!checkPermissions(id_installationSite, null))
                    return permissionChecker.getAccessDeniedResponse();

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
            response.setError(new ErrorDTO(404, "Empty body"));
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

    public boolean checkPermissions(Integer idInstSite, Integer idAccessPoint) throws AccessDeniedException {
        //we already verify that this id exists before this point
        try {
            Integer idMunicipality = installationSiteRepository.findOne(idInstSite).getMunicipality();

            if (!installationSiteService.checkPermissions(idMunicipality, idInstSite) ||  (idAccessPoint != null && accessPointRepository
                    .findAccessPointByIdAndIdInstallationSite(idAccessPoint, idInstSite) == null)) {
                throw new AccessDeniedException("403 FORBIDDEN");
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }


}

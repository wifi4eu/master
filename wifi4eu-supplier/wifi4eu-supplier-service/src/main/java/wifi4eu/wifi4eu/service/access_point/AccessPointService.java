package wifi4eu.wifi4eu.service.access_point;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.entity.access_point.AccessPoint;
import wifi4eu.wifi4eu.repository.access_point.AccessPointRepository;
import wifi4eu.wifi4eu.repository.installation.InstallationSiteRepository;

import javax.xml.ws.Response;
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
    private String[] FIELDS_ACCESS_POINTS_ORDER = {"number", "location", "location_type", "device_brand", "device_type", "model_number", "serial_number", "mac_address","isIndoor"};




    @Transactional
    public ResponseDTO deleteAccessPointById(int id){
        ResponseDTO response = new ResponseDTO();
        if (accessPointRepository.findOne(id) != null){
            accessPointRepository.delete(id);
            response.setSuccess(true);
            response.setData("Deleted successfully");
        } else {
            response.setSuccess(false);
            response.setData("Error");
            response.setError(new ErrorDTO(404, "error.404.AccessPointNotFound"));
        }
        return response;
    }

    @Transactional
    public ResponseDTO getAccessPointById(int id){
        ResponseDTO response = new ResponseDTO();
        if (accessPointRepository.findOne(id) != null){
            response.setSuccess(true);
            response.setData(accessPointRepository.findOne(id));
        } else {
            response.setSuccess(false);
            response.setData("Error");
            response.setError(new ErrorDTO(404, "error.404.AccessPointNotFound"));
        }
        return response;
    }

    @Transactional
    public ResponseDTO addOrUpdateAccessPoint(Map<String, Object> map){
        ResponseDTO response = new ResponseDTO();
        if (!map.isEmpty()){
            if (map.containsKey("idInstallationSite") && installationSiteRepository.countInstallationSiteById((int) map.get("idInstallationSite")) == 1){
                if (map.containsKey("id") && (int) map.get("id") > 0){
                    // update access point
                    AccessPoint accessPoint = accessPointRepository.findOne((int) map.get("id"));
                    if (accessPoint != null){
                        if (setAccessPointFields(map,accessPoint,false)){
                            accessPointRepository.save(accessPoint);
                            response.setSuccess(true);
                            response.setData(accessPoint);
                        } else {
                            response.setSuccess(false);
                            response.setError(new ErrorDTO(400,"error.400.invalidFields"));
                        }
                    } else {
                        response.setSuccess(false);
                        response.setError(new ErrorDTO(404,"error.404.AccessPointNotFound"));
                    }
                } else {
                    // add new access point
                    AccessPoint accessPoint = new AccessPoint();
                    if (setAccessPointFields(map,accessPoint,true)){
                        accessPointRepository.save(accessPoint);
                        response.setSuccess(true);
                        response.setData(accessPoint);
                    } else {
                        response.setSuccess(false);
                        response.setError(new ErrorDTO(400,"error.400.invalidFields"));
                    }
                }
            } else {
                response.setSuccess(false);
                response.setError(new ErrorDTO(404,"error.404.InstallationSitesNotFound"));
            }
        } else {
            response.setSuccess(false);
            response.setError(new ErrorDTO(400,"error.400.noData"));
        }

        return response;
    }

    private boolean setAccessPointFields(Map<String,Object> map, AccessPoint accessPoint, boolean sumar){
        boolean control = true;
        /*
        String[] fieldsAccessPoint = {"","","","",""};
        for (int i = 0; i < fieldsAccessPoint.length; i++){
            if (!map.containsKey(fieldsAccessPoint[i])){
                control = false;
                break;
            }
        }
        */

        if (control){
            // passed validation of fields, now we edit the object accesspoint
            accessPoint.setModelNumber((String) map.get("modelNumber"));
            accessPoint.setSerialNumber((String) map.get("serialNumber"));
            accessPoint.setInstallationSite((int) map.get("idInstallationSite"));
            accessPoint.setIndoor((boolean) map.get("indoor"));
            accessPoint.setDeviceBrand((String) map.get("deviceBrand"));
            accessPoint.setLocation((String) map.get("location"));
            accessPoint.setLocationType((String) map.get("locationType"));
            accessPoint.setLatitude(map.get("latitude").toString());
            accessPoint.setLongitude(map.get("longitude").toString());
            String regExMac = "([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$";
            String macAddress = (String) map.get("macAddress");
            if (macAddress.matches(regExMac)){
                accessPoint.setMacAddress((String) map.get("macAddress"));
            } else {
                // what we should do ? Add and empty field?
                accessPoint.setMacAddress((String) map.get("macAddress"));
            }
            if (sumar) {
                accessPoint.setNumber(getNextAccessPointPerInstallationSite((int) map.get("idInstallationSite")));
            }
        }
        return control;
    }

    private int getNextAccessPointPerInstallationSite(int id_installation_site){
        Long currentLong = accessPointRepository.selectMaxNumberAccessPointByIdInstallationSite(id_installation_site);
        if (currentLong != null){
            currentLong++;
            return Integer.parseInt(currentLong.toString());
        } else {
            return 1;
        }
    }

    @Transactional
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
                    response.setError(new ErrorDTO(400, "error.400.invalidFields"));
                }
            } else {
                response.setSuccess(false);
                response.setError(new ErrorDTO(404, "error.404.InstallationSitesNotFound"));
            }
        } else {
            response.setSuccess(false);
            response.setError(new ErrorDTO(400,"error.400.noData"));
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

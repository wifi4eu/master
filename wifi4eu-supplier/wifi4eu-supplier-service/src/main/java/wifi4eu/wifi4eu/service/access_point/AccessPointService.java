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

import javax.persistence.Access;
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

    @Autowired
    InstallationSiteService installationSiteService;

    @Autowired
    PermissionChecker permissionChecker;

    // TODO missing field number (not appears on DB)
    // TODO missing device_type field
    private String[] FIELDS_ACCESS_POINTS_ORDER = {"number", "location", "location_type", "device_brand",
            "device_type", "model_number", "serial_number", "mac_address", "isIndoor"};


    @Transactional
    public ResponseDTO deleteAccessPointById(int id) {
        ResponseDTO response = new ResponseDTO();
        AccessPoint accessPoint = accessPointRepository.findOne(id);
        if (accessPoint != null) {
            if (!checkPermissions(accessPoint.getIdInstallationSite(), id))
                return permissionChecker.getAccessDeniedResponse();
            accessPointRepository.delete(id);
            response.setSuccess(true);
            response.setData("Deleted successfully");
        } else {
            response.setSuccess(false);
            response.setData("Error");
            response.setError(new ErrorDTO(404, "error.404.accessPointNotFound"));
        }
        return response;
    }

    @Transactional
    public ResponseDTO getAccessPointById(int id) {
        ResponseDTO response = new ResponseDTO();
        AccessPoint accessPoint = accessPointRepository.findOne(id);
        if (accessPoint!= null) {

            if (!checkPermissions(accessPoint.getIdInstallationSite(), id))
                return permissionChecker.getAccessDeniedResponse();

            response.setSuccess(true);
            response.setData(accessPointRepository.findOne(id));
        } else {
            response.setSuccess(false);
            response.setData("Error");
            response.setError(new ErrorDTO(404, "error.404.accessPointNotFound"));
        }
        return response;
    }

    @Transactional
    public ResponseDTO addOrUpdateAccessPoint(Map<String, Object> map) {
        ResponseDTO response = new ResponseDTO();
        if (!map.isEmpty()) {
            if (map.containsKey("idInstallationSite") && installationSiteRepository.countInstallationSiteById((int)
                    map.get("idInstallationSite")) == 1) {
                if (map.containsKey("id") && (int) map.get("id") > 0) {
                    // update access point
                    AccessPoint accessPoint = accessPointRepository.findOne((int) map.get("id"));
                    if (accessPoint != null) {
                        if (!checkPermissions(accessPoint.getIdInstallationSite(), accessPoint.getId()))
                            return permissionChecker.getAccessDeniedResponse();

                        if (setAccessPointFields(map, accessPoint, false)) {
                            accessPointRepository.save(accessPoint);
                            response.setSuccess(true);
                            response.setData(accessPoint);
                        } else {
                            response.setSuccess(false);
                            response.setError(new ErrorDTO(400, "error.400.invalidFields"));
                        }
                    } else {
                        response.setSuccess(false);
                        response.setError(new ErrorDTO(404, "error.404.accessPointNotFound"));
                    }
                } else {
                    if (!checkPermissions((int) map.get("idInstallationSite"), null))
                        return permissionChecker.getAccessDeniedResponse();

                    // add new access point
                    AccessPoint accessPoint = new AccessPoint();
                    if (setAccessPointFields(map, accessPoint, true)) {
                        accessPointRepository.save(accessPoint);
                        response.setSuccess(true);
                        response.setData(accessPoint);
                    } else {
                        response.setSuccess(false);
                        response.setError(new ErrorDTO(400, "error.400.invalidFields"));
                    }
                }
            } else {
                response.setSuccess(false);
                response.setError(new ErrorDTO(404, "error.404.installationSitesNotFound"));
            }
        } else {
            response.setSuccess(false);
            response.setError(new ErrorDTO(400, "error.400.noData"));
        }

        return response;
    }

    private boolean setAccessPointFields(Map<String, Object> map, AccessPoint accessPoint, boolean sumar) {
        boolean control = true;
        //checking all required camps
        String[] fieldsAccessPoint = {"modelNumber", "serialNumber", "indoor", "deviceBrand",
                "location", "locationType", "latitude", "longitude", "macAddress"};
        for (int i = 0; i < fieldsAccessPoint.length; i++) {
            if (!map.containsKey(fieldsAccessPoint[i])) {
                control = false;
                break;
            }
        }

        //checking if macAddress complies with the regex
        String regExMac = "([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$";
        String macAddress = (String) map.get("macAddress");
        if (macAddress!= null && macAddress.matches(regExMac)) {
            accessPoint.setMacAddress(macAddress);
        } else {
            control = false;
        }

        //checking if latitude and longitud complies with the regex
        String regExLocation = "^([-+]?)([0-9]{1,2})\\.([0-9]{6})$";
        String latitude = (String) map.get("latitude");
        String longitude = (String) map.get("longitude");
        if (control && latitude.matches(regExLocation) && longitude.matches(regExLocation)) {
            accessPoint.setLatitude(latitude);
            accessPoint.setLongitude(longitude);
        } else {
            control = false;
        }

        if (control) {
            try {
                // passed validation of fields, now we edit the object accesspoint
                accessPoint.setModelNumber((String) map.get("modelNumber"));
                accessPoint.setSerialNumber((String) map.get("serialNumber"));
                accessPoint.setInstallationSite((int) map.get("idInstallationSite"));
                accessPoint.setIndoor((boolean) map.get("indoor"));
                accessPoint.setDeviceBrand((String) map.get("deviceBrand"));
                accessPoint.setLocation((String) map.get("location"));
                accessPoint.setLocationType((String) map.get("locationType"));
                if (sumar) {
                    accessPoint.setNumber(getNextAccessPointPerInstallationSite((int) map.get("idInstallationSite")));
                }
            } catch (Exception ex) {
                return false;
            }
        }
        return control;
    }

    private int getNextAccessPointPerInstallationSite(int id_installation_site) {
        Long currentLong = accessPointRepository.selectMaxNumberAccessPointByIdInstallationSite(id_installation_site);
        if (currentLong != null) {
            currentLong++;
            return Integer.parseInt(currentLong.toString());
        } else {
            return 1;
        }
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

            if (map.containsKey("id_installationSite") && installationSiteRepository.countInstallationSiteById((int)
                    map.get("id_installationSite")) == 1) {

                id_installationSite = (int) map.get("id_installationSite");

                if (!checkPermissions((int) map.get("id_installationSite"), null))
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

                    ArrayList<AccessPoint> installationSites = Lists.newArrayList(accessPointRepository
                            .searchAccessPointByInstallationSite(page, delta, id_installationSite, field, order));
                    int countResults = accessPointRepository.countAccessPointByInstallationSite(page, delta,
                            id_installationSite, field, order);
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
                response.setError(new ErrorDTO(404, "error.404.installationSitesNotFound"));
            }
        } else {
            response.setSuccess(false);
            response.setError(new ErrorDTO(400, "error.400.noData"));
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

            if (!installationSiteService.checkPermissions(idMunicipality, idInstSite) || (idAccessPoint != null &&
                    accessPointRepository.findAccessPointByIdAndIdInstallationSite(idAccessPoint, idInstSite) ==
                            null)) {
                throw new AccessDeniedException("403 FORBIDDEN");
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}

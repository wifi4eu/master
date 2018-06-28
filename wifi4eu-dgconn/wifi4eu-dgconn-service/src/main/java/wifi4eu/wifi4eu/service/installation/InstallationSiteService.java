package wifi4eu.wifi4eu.service.installation;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.installation.InstallationSite;
import wifi4eu.wifi4eu.repository.installation.InstallationSiteRepository;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//import wifi4eu.wifi4eu.repository.status.StatusRepository;

@Service
public class InstallationSiteService {


    @Autowired
    InstallationSiteRepository installationSiteRepository;

    @Autowired
    MunicipalityRepository municipalityRepository;

//    @Autowired
//    StatusRepository statusRepository;

    @Autowired
    private PermissionChecker permissionChecker;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    MunicipalityService municipalityService;

    @Autowired
    UserService userService;
    Logger _log = LogManager.getLogger(InstallationSiteService.class);

    // TODO missing field number (not appears on DB)
    private String[] FIELDS_INSTALLATION_SITE_ACCEPT = {"name", "domain_name", "number"};

    public ResponseDTO findInstallationSitesByBeneficiariesOrdered(Map<String, Object> map) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Finding installation sites by beneficiaries ordered");
        ResponseDTO response = new ResponseDTO();
        if (!map.isEmpty()) {
            String order = "asc";
            String field = "name";
            int id_beneficiary = 0;
            int page = 0;
            int delta = 10;

            if (map.containsKey("id_beneficiary") && municipalityRepository.countMunicipalitiesById((Integer) map.get
                    ("id_beneficiary")) == 1) {

                id_beneficiary = (int) map.get("id_beneficiary");

                if (!checkPermissions(id_beneficiary, null))
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

                    ArrayList<InstallationSite> installationSites = Lists.newArrayList(installationSiteRepository.searchInstallationSitesByBeneficiary(page, delta, id_beneficiary, field, order));
                    int countResults = installationSiteRepository.countInstallationSitesByBeneficiary(page, delta, id_beneficiary, field, order);
                    mapResult.put("data", installationSites);
                    mapResult.put("count", countResults);
                    response.setSuccess(true);
                    response.setData(mapResult);

                } catch (Exception ex) {
                    response.setSuccess(false);
                    response.setError(new ErrorDTO(404, "Error - Invalid integers / fields"));
                    _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The fields are invalid", ex);
                }
            } else {
                response.setSuccess(false);
                response.setError(new ErrorDTO(404, "Municipality not found"));
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The municipality is not found");
            }

        } else {
            response.setSuccess(false);
            response.setError(new ErrorDTO(404, "Error json query"));
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Json query is invalid");
        }

        return response;
    }

    private String acceptFieldNameQueryInstallationSites(String fieldEntry) {
        String field = "name";
        String fieldJson = fieldEntry;
        for (int i = 0; i < FIELDS_INSTALLATION_SITE_ACCEPT.length; i++) {
            if (fieldJson.equals(FIELDS_INSTALLATION_SITE_ACCEPT[i])) {
                field = fieldJson;
                break;
            }
        }
        return field;
    }

    public ResponseDTO getInstallationReport(int id) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving installations report with id "+ id);
        ResponseDTO response = new ResponseDTO();
        InstallationSite installationSite = installationSiteRepository.findInstallationSiteById(id);
        if (installationSite != null) {
            if (!checkPermissions(installationSite.getMunicipality(), id)){
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permission to retrieve this installation site");
                return permissionChecker.getAccessDeniedResponse();
            }

            response.setSuccess(true);
            response.setData(installationSite);
        } else {
            response.setSuccess(false);
            response.setError(new ErrorDTO(404, "Installation site not found"));
        }
        return response;
    }

    public boolean checkPermissions(int idMunicipality, Integer idInstSite) throws AccessDeniedException {
        try {
            //first we check if the municipality corresponds to this user and then we check if the municipality has
            // any relation to this installation site
            if (!municipalityService.checkPermissions(idMunicipality) ||
                    (idInstSite != null && installationSiteRepository.findInstallationSiteByIdAndMunicipality
                            (idInstSite, idMunicipality) == null)) {
                throw new AccessDeniedException("403 FORBIDDEN");
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }

}

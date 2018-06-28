package wifi4eu.wifi4eu.service.installation;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.token.TokenGenerator;
import wifi4eu.wifi4eu.entity.installation.InstallationSite;
import wifi4eu.wifi4eu.entity.installation.InstallationSiteWhitelist;
import wifi4eu.wifi4eu.repository.installation.InstallationSiteRepository;
import wifi4eu.wifi4eu.repository.installation.InstallationSiteWhitelistRepository;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.beneficiary.BeneficiaryDisplayedListService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.*;

@Service
public class InstallationSiteService {

    @Autowired
    InstallationSiteRepository installationSiteRepository;

    @Autowired
    MunicipalityRepository municipalityRepository;

    @Autowired
    InstallationSiteWhitelistRepository whitelistRepository;

    @Autowired
    InstallationSiteWhitelistRepository installationSiteWhitelistRepository;

    @Autowired
    PermissionChecker permissionChecker;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    UserService userService;

    private final Logger _log = LogManager.getLogger(InstallationSiteService.class);

    // TODO missing field number (not appears on DB)
    private String[] FIELDS_INSTALLATION_SITE_ACCEPT = {"name", "domain_name", "number"};

    public ResponseDTO findInstallationSitesByBeneficiariesOrdered(Map<String, Object> map) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);

        ResponseDTO response = new ResponseDTO();
        if (!map.isEmpty()) {
            String order = "asc";
            String field = "name";
            int id_beneficiary = 0;
            int page = 0;
            int delta = 10;

            if (map.containsKey("id_beneficiary") && municipalityRepository.countMunicipalitiesById((int) map.get
                    ("id_beneficiary")) == 1) {

                id_beneficiary = (int) map.get("id_beneficiary");
                _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Searching installation site by " +
                        "municipality id: ", id_beneficiary);

                // check permissions
                if (!checkPermissions((int) map.get("id_beneficiary"), null)) {
                    _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permissions to " +
                            "access");
                    return permissionChecker.getAccessDeniedResponse();
                }

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


                    ArrayList<InstallationSite> installationSites = Lists.newArrayList(installationSiteRepository
                            .searchInstallationSitesByBeneficiary(page, delta, id_beneficiary, field, order));
                    int countResults = installationSiteRepository.countInstallationSitesByBeneficiary(page, delta,
                            id_beneficiary, field, order);
                    mapResult.put("data", installationSites);
                    mapResult.put("count", countResults);
                    response.setSuccess(true);
                    response.setData(mapResult);
                    _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Installation Sites retrieved " +
                            "successfully");

                } catch (Exception ex) {
                    _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Invalid fields when searching" +
                            " installation sites by municipality id:" + id_beneficiary + " . ERROR:", ex);
                    response.setSuccess(false);
                    response.setError(new ErrorDTO(400, "error.400.invalidFields"));
                }
            } else {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Beneficiary not found");
                response.setSuccess(false);
                response.setError(new ErrorDTO(404, "error.404.beneficiaryNotFound"));
            }
        } else {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - No data");
            response.setSuccess(false);
            response.setError(new ErrorDTO(400, "error.400.noData"));
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

    public ResponseDTO addAndUpdateInstallationSite(Map<String, Object> map) {
        ResponseDTO response = new ResponseDTO();
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        if (!map.isEmpty()) {

            boolean control = true;
            //checking all required camps
            String[] fieldsAccessPoint = {"municipality", "name", "url"};
            for (int i = 0; i < fieldsAccessPoint.length; i++) {
                if (!map.containsKey(fieldsAccessPoint[i])) {
                    control = false;
                    break;
                }
            }
            String regExURL = "^[^- ]([a-z0-9-:/.]+\\.)[a-z0-9-:/]*[^-]$";
            String url = (String) map.get("url");
            if (url != null && !url.matches(regExURL)) {
                control = false;
            }

            if (control) {
                InstallationSite installationSite;
                //if there's no id, we have to create a new installation site
                if (!map.containsKey("id")) {
                    _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Adding a new installationSite" +
                            ".");

                    //check permissions
                    if (!checkPermissions((int) map.get("municipality"), null)) {
                        _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permissions " +
                                "to access");
                        return permissionChecker.getAccessDeniedResponse();
                    }

                    //system should check the URL of the captive portal is unique.
                    if (url != null && installationSiteRepository.countInstallationSiteByUrl(url) >= 1) {
                        _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Duplicated URL");
                        response.setSuccess(false);
                        response.setError(new ErrorDTO(409, "error.409.duplicatedUrl"));
                        return response;
                    }

                    installationSite = new InstallationSite();
                    Calendar calendar = Calendar.getInstance();
                    Date now = calendar.getTime();
                    Timestamp currentTimestamp = new Timestamp(now.getTime());
                    installationSite.setDateRegistered(currentTimestamp);
                    installationSite.setNumber(getNextNumberPerInstallationSiteByBeneficiaryId((int) map.get
                            ("municipality")));

                    //We create a crypted token for the network snippet id and verify that is unique
                    String token = new TokenGenerator().generate();
                    while (installationSiteRepository.countInstallationSiteByIdNetworkSnippet(token) > 0) {
                        token = new TokenGenerator().generate();
                    }
                    installationSite.setIdNetworkSnippet(token);
                    installationSite.setMunicipality((int) map.get("municipality"));
                    installationSite.setStatus(1);

                } else {
                    _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Updating the installationSite" +
                            " with the id: " + (int) map.get("id"));

                    // check permissions
                    if (!checkPermissions((int) map.get("municipality"), (int) map.get("id"))) {
                        _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permissions " +
                                "to access");
                        return permissionChecker.getAccessDeniedResponse();
                    }

                    //system should check the URL of the captive portal is unique.
                    if (url != null && installationSiteRepository.countInstallationSiteByUrlAndIdNotIn(url, (int) map
                            .get("id")) >= 1) {
                        _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Duplicated URL");
                        response.setSuccess(false);
                        response.setError(new ErrorDTO(409, "error.409.duplicatedUrl"));
                        return response;
                    }
                    installationSite = installationSiteRepository.findInstallationSiteById((int) map.get("id"));
                }

                String domain;
                try {
                    String tempUrl = !url.startsWith("http") ? "http://" + url : url;
                    URL uri = new URL(tempUrl);
                    domain = uri.getHost().startsWith("www.") ? uri.getHost().substring(4) : uri.getHost();
                } catch (MalformedURLException ex) {
                    _log.warn("ECAS Username: " + userConnected.getEcasUsername() + " - Malformed URL.");
                    domain = url;
                }

                // the domain will be added to whitelist
                if (whitelistRepository.countInstallationSiteWhitelistByOrigin(domain) == 0) {
                    InstallationSiteWhitelist whitelist = new InstallationSiteWhitelist();
                    whitelist.setOrigin(domain);
                    whitelist.setActive(1);
                    whitelistRepository.save(whitelist);
                }

                installationSite.setName((String) map.get("name"));
                installationSite.setUrl(url);
                installationSite.setDomainName(domain);
                installationSiteRepository.save(installationSite);
                response.setSuccess(true);
                response.setData(installationSite);

                _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Successfully added/updated " +
                        "installationSite!");

            } else {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Invalid Fields");
                response.setSuccess(false);
                response.setError(new ErrorDTO(400, "error.400.invalidFields"));
            }
        } else {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - No data");
            response.setSuccess(false);
            response.setError(new ErrorDTO(400, "error.400.noData"));
        }
        return response;
    }

    private int getNextNumberPerInstallationSiteByBeneficiaryId(int id_beneficiary) {
        Long currentLong = installationSiteRepository.selectMaxNumberInstallationSiteByMunicipalityId(id_beneficiary);
        if (currentLong != null) {
            currentLong++;
            return Integer.parseInt(currentLong.toString());
        } else {
            return 1;
        }
    }

    public ResponseDTO getInstallationReport(int id) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        ResponseDTO response = new ResponseDTO();
        InstallationSite installationSite = installationSiteRepository.findInstallationSiteById(id);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " -  Trying to view the installation site " +
                "details: " + id);
        if (installationSite != null) {
            // check permissions
            if (!checkPermissions(installationSite.getMunicipality(), id)) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permissions to " +
                        "access");
                return permissionChecker.getAccessDeniedResponse();
            }

            response.setSuccess(true);
            response.setData(installationSite);

            _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Installation site details retrieved successfully");
        } else {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Installation site not found, id: " +
                    id);
            response.setSuccess(false);
            response.setError(new ErrorDTO(404, "error.404.installationSitesNotFound"));
        }
        return response;
    }

    public ResponseDTO removeInstallationReport(int id) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " -  Trying to remove the installation site: " +
                "" + id);

        ResponseDTO response = new ResponseDTO();
        InstallationSite installationSite = installationSiteRepository.findInstallationSiteById(id);
        if (installationSite != null) {
            // check permissions
            if (!checkPermissions(installationSite.getMunicipality(), id)) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permissions to " +
                        "access");
                return permissionChecker.getAccessDeniedResponse();
            }
            // the domain will be removed from the whitelist
            if (installationSiteRepository.countInstallationSiteByDomainName(installationSite.getDomainName()) == 1L) {
                InstallationSiteWhitelist whitelist = installationSiteWhitelistRepository
                        .findInstallationSiteWhitelistByOrigin(installationSite.getDomainName());
                whitelistRepository.delete(whitelist);
            }
            installationSiteRepository.delete(id);
            response.setSuccess(true);
            response.setData("Deleted successfully");
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Removed the installation site successfully: " +
                    "" + id);

        } else {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Installation site not found, id: " +
                    id);
            response.setSuccess(false);
            response.setError(new ErrorDTO(404, "error.404.installationSitesNotFound"));
        }
        return response;
    }

    public boolean checkPermissions(int idMunicipality, Integer idInstSite) throws AccessDeniedException {
        try {
            //first we check if user logged in is a supplier
            SupplierDTO supplier = permissionChecker.checkSupplierPermission();
            //and then we check that it has a relation to this installation site's municipality
            RegistrationDTO registration = registrationService.getRegistrationByMunicipalityId(idMunicipality);
            if (registration == null || applicationService.getApplicationBySupplierIdAndRegistrationId(supplier.getId
                    (), registration.getId()) == null || (idInstSite != null && installationSiteRepository
                    .findInstallationSiteByIdAndMunicipality(idInstSite, idMunicipality) == null)) {
                throw new AccessDeniedException("403 FORBIDDEN");
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }
}

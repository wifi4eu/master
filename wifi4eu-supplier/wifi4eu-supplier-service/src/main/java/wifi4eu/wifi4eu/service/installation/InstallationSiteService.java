package wifi4eu.wifi4eu.service.installation;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.entity.installation.InstallationSite;
import wifi4eu.wifi4eu.repository.installation.InstallationSiteRepository;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.repository.status.StatusRepository;

import java.sql.Timestamp;
import java.util.*;

@Service
public class InstallationSiteService {


    @Autowired
    InstallationSiteRepository installationSiteRepository;

    @Autowired
    MunicipalityRepository municipalityRepository;

    @Autowired
    StatusRepository statusRepository;


    private final Logger _log = LoggerFactory.getLogger(InstallationSiteService.class);

    // TODO missing field number (not appears on DB)
    private String[] FIELDS_INSTALLATION_SITE_ACCEPT = {"name", "domain_name", "number"};

    public ResponseDTO findInstallationSitesByBeneficiariesOrdered(Map<String, Object> map) {
        ResponseDTO response = new ResponseDTO();
        if (!map.isEmpty()) {
            String order = "asc";
            String field = "name";
            int id_beneficiary = 0;
            int page = 0;
            int delta = 10;

            if (map.containsKey("id_beneficiary") && municipalityRepository.countMunicipalitiesById((int) map.get("id_beneficiary")) == 1) {

                id_beneficiary = (int) map.get("id_beneficiary");

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
                    response.setError(new ErrorDTO(400, "error.400.invalidFields"));
                }
            } else {
                response.setSuccess(false);
                response.setError(new ErrorDTO(404, "error.404.beneficiaryNotFound"));
            }

        } else {
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
        if (!map.isEmpty()) {
            // if (map.get("url").equals(map.get("url_confirmation"))) {
                InstallationSite installationSite;
                if (!map.containsKey("id")) {
                    installationSite = new InstallationSite();
                    Calendar calendar = Calendar.getInstance();
                    Date now = calendar.getTime();
                    Timestamp currentTimestamp = new Timestamp(now.getTime());
                    installationSite.setDateRegistered(currentTimestamp);
                    installationSite.setNumber(getNextNumberPerInstallationSiteByBeneficiaryId((int) map.get("municipality")));
                } else {
                    installationSite = installationSiteRepository.findInstallationSiteById((int) map.get("id"));
                }
                installationSite.setMunicipality((int) map.get("municipality"));
                // installationSite.setMunicipality(municipalityRepository.findMuncipalityById((int) map.get("id_beneficiary")));
                installationSite.setName((String) map.get("name"));
                installationSite.setUrl((String) map.get("url"));
                installationSite.setDomainName((String) map.get("url"));
                installationSite.setIdNetworkSnippet((String) map.get("name") + 123);
                installationSite.setStatus(1);
                // installationSite.setId_status(statusRepository.findStatudById(1));
                installationSiteRepository.save(installationSite);
                response.setSuccess(true);
                response.setData(installationSite);
            // }

        } else {
            response.setSuccess(false);
            response.setError(new ErrorDTO(400, "error.400.noData"));
        }
        return response;
    }

    private int getNextNumberPerInstallationSiteByBeneficiaryId(int id_beneficiary){
        Long currentLong = installationSiteRepository.selectMaxNumberInstallationSiteByMunicipalityId(id_beneficiary);
        if (currentLong != null){
            currentLong++;
            return Integer.parseInt(currentLong.toString());
        } else {
            return 1;
        }
    }

    public ResponseDTO getInstallationReport(int id) {
        ResponseDTO response = new ResponseDTO();
        InstallationSite installationSite = installationSiteRepository.findInstallationSiteById(id);
        if (installationSite != null) {
            response.setSuccess(true);
            response.setData(installationSite);
        } else {
            response.setSuccess(false);
            response.setError(new ErrorDTO(404, "error.404.InstallationSitesNotFound"));
        }
        return response;
    }

    public ResponseDTO removeInstallationReport(int id) {
        ResponseDTO response = new ResponseDTO();
        if (installationSiteRepository.findInstallationSiteById(id) != null) {
            installationSiteRepository.delete(id);
            response.setSuccess(true);
            response.setData("Deleted successfully");
        } else {
            response.setSuccess(false);
            response.setError(new ErrorDTO(404, "error.404.InstallationSitesNotFound"));
        }
        return response;
    }

}

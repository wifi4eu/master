package wifi4eu.wifi4eu.service.installation;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.entity.installation.InstallationSite;
import wifi4eu.wifi4eu.mapper.installation.InstallationSiteMapper;
import wifi4eu.wifi4eu.repository.installation.InstallationSiteRepository;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class InstallationSiteService {

    @Autowired
    InstallationSiteMapper installationSiteMapper;

    @Autowired
    InstallationSiteRepository installationSiteRepository;

    @Autowired
    MunicipalityRepository municipalityRepository;


    private final Logger _log = LoggerFactory.getLogger(InstallationSiteService.class);

    // TODO missing field number (not appears on DB)
    private String[] FIELDS_INSTALLATION_SITE_ACCEPT = {"name", "domain_name", "id"};

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
                    response.setError(new ErrorDTO(404, "Error - Invalid integers / fields"));
                }
            } else {
                response.setSuccess(false);
                response.setError(new ErrorDTO(404, "Municipality not found"));
            }

        } else {
            response.setSuccess(false);
            response.setError(new ErrorDTO(404, "Error json query"));
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

}

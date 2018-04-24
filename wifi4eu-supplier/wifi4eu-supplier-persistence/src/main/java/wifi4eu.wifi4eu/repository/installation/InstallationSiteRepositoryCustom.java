package wifi4eu.wifi4eu.repository.installation;

import wifi4eu.wifi4eu.entity.installation.InstallationSite;

import java.util.List;

public interface InstallationSiteRepositoryCustom {

    List<InstallationSite> searchInstallationSitesByBeneficiary(int page, int delta, int id_beneficiary, String fieldName, String orderField);

    int countInstallationSitesByBeneficiary(int page, int delta, int id_beneficiary, String fieldName, String orderField);
}

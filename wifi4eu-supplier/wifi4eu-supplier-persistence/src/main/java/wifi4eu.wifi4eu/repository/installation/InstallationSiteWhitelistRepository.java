package wifi4eu.wifi4eu.repository.installation;

import org.springframework.data.repository.PagingAndSortingRepository;
import wifi4eu.wifi4eu.entity.installation.InstallationSiteWhitelist;

public interface InstallationSiteWhitelistRepository extends PagingAndSortingRepository<InstallationSiteWhitelist, Integer> {

    Long countInstallationSiteWhitelistByOrigin(String origin);

    InstallationSiteWhitelist findInstallationSiteWhitelistByOrigin(String origin);
}

package wifi4eu.wifi4eu.repository.installation;

import org.springframework.data.repository.PagingAndSortingRepository;
import wifi4eu.wifi4eu.entity.installation.InstallationSite;

public interface InstallationSiteRepository extends PagingAndSortingRepository<InstallationSite, Integer>, InstallationSiteRepositoryCustom {
}

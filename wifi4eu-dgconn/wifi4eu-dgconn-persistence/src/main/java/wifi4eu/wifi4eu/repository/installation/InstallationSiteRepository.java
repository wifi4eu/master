package wifi4eu.wifi4eu.repository.installation;

import org.springframework.data.repository.PagingAndSortingRepository;
import wifi4eu.wifi4eu.entity.installation.InstallationSite;

public interface InstallationSiteRepository extends PagingAndSortingRepository<InstallationSite, Integer>, InstallationSiteRepositoryCustom {

    Long countInstallationSiteById(Integer id);

    InstallationSite findInstallationSiteById(Integer id);

    InstallationSite findInstallationSiteByIdAndMunicipality(Integer id, Integer municipality);
}

package wifi4eu.wifi4eu.repository.installation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import wifi4eu.wifi4eu.entity.installation.InstallationSite;

public interface InstallationSiteRepository extends PagingAndSortingRepository<InstallationSite, Integer>, InstallationSiteRepositoryCustom {

    Long countInstallationSiteById(Integer id);

    @Query(value = "SELECT MAX(number) FROM installation_site WHERE id_municipality = ?1", nativeQuery = true)
    Long selectMaxNumberInstallationSiteByMunicipalityId(Integer id);

    InstallationSite findInstallationSiteById(Integer id);

    InstallationSite findInstallationSiteByIdAndMunicipality(Integer id, Integer municipality);

    Long countInstallationSiteByUrlAndIdNotIn(String url, Integer id);

    Long countInstallationSiteByUrl(String url);

    Long countInstallationSiteByIdNetworkSnippet(String url);

    Long countInstallationSiteByDomainName(String domainName);

}

package wifi4eu.wifi4eu.repository.installation;

import org.springframework.data.repository.PagingAndSortingRepository;
import wifi4eu.wifi4eu.entity.installation.InstallationSite;

public interface InstallationSiteRepository extends PagingAndSortingRepository<InstallationSite, Integer>, InstallationSiteRepositoryCustom {

    /*
    @Query(value = "SELECT * FROM installation_site i INNER JOIN municipalities m ON m.id = i.id_municipality", nativeQuery=true)
    List<InstallationSite> findInstallationSitesByBeneficiary(Pageable pageable);
    */

}

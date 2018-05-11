package wifi4eu.wifi4eu.repository.installation;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import wifi4eu.wifi4eu.entity.installation.InstallationSite;

import java.util.List;

public interface InstallationSiteRepository extends PagingAndSortingRepository<InstallationSite, Integer>, InstallationSiteRepositoryCustom {

/*
    @Query(value = "SELECT * FROM installation_site i INNER JOIN municipalities m ON m.id = i.id_municipality", nativeQuery=true)
    List<InstallationSite> findInstallationSitesByBeneficiary(Pageable pageable);
*/

    /*@Query(value = "SELECT i.number, i.name, i.url, i.domain_name, i.date_registered FROM installation_site i INNER JOIN municipalities m ON m.id = i.id_municipality INNER JOIN registrations r ON r.municipality = m.id INNER JOIN users u ON u.id = r._user WHERE u.id = ?1", nativeQuery = true)
    List<InstallationSite> findInstallationSitesByBeneficiary(Integer id);*/



    /*@Query(value = "SELECT * FROM installation_site i INNER JOIN municipalities m ON m.id = i.id_municipality INNER JOIN registrations r ON r.municipality = m.id INNER JOIN users u ON u.id = r._user WHERE u.id = ?1", nativeQuery = true)
    List<InstallationSite> findInstallationSitesByBeneficiary(Integer id);*/

    Long countInstallationSiteById(Integer id);

    /*
    @Query(value = "SELECT COUNT(id) FROM installation_site WHERE id_municipality = ?1" , nativeQuery = true)
    Long countInstallationSiteByMunicipality(Integer id);
    */

    @Query(value = "SELECT MAX(number) FROM installation_site WHERE id_municipality = ?1" , nativeQuery = true)
    Long selectMaxNumberInstallationSiteByMunicipalityId(Integer id);

    InstallationSite findInstallationSiteById(Integer id);

    Long countInstallationSiteByUrl(String url);
    Long countInstallationSiteByIdNetworkSnippet(String url);

}

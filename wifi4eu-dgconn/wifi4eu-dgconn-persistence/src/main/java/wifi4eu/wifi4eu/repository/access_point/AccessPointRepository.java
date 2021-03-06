package wifi4eu.wifi4eu.repository.access_point;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import wifi4eu.wifi4eu.entity.access_point.AccessPoint;

public interface AccessPointRepository extends PagingAndSortingRepository<AccessPoint, Integer>, AccessPointRepositoryCustom{

    // Long countAccessPointByIdInstallationSite(Integer idInstallationSite);

    @Query(value = "SELECT MAX(number) FROM access_points WHERE id_installation_site = ?1" , nativeQuery = true)
    Long selectMaxNumberAccessPointByIdInstallationSite(Integer id);

    AccessPoint findAccessPointByIdAndIdInstallationSite(Integer id, Integer idInstallationSite);

    @Query(value = "SELECT count(a.id) FROM access_points a " +
            "INNER JOIN installation_site i ON a.id_installation_site = i.id " +
            "INNER JOIN municipalities m ON m.id = i.id_municipality " +
            "WHERE a.isIndoor = ?1 AND m.id = ?2",nativeQuery = true)
    Long countAccessPointsByTypeIndoorAndMunicipality(boolean indoor, long idMunicipality);
}

package wifi4eu.wifi4eu.repository.access_point;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import wifi4eu.wifi4eu.entity.access_point.AccessPoint;
import wifi4eu.wifi4eu.entity.installation.InstallationSite;

public interface AccessPointRepository extends PagingAndSortingRepository<AccessPoint, Integer>, AccessPointRepositoryCustom{

    // Long countAccessPointByIdInstallationSite(Integer idInstallationSite);

    @Query(value = "SELECT MAX(number) FROM access_points WHERE id_installation_site = ?1" , nativeQuery = true)
    Long selectMaxNumberAccessPointByIdInstallationSite(Integer id);

    AccessPoint findAccessPointByIdAndIdInstallationSite(Integer id, Integer idInstallationSite);
}
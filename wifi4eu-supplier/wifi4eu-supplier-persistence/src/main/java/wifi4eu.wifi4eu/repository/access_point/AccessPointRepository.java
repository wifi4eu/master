package wifi4eu.wifi4eu.repository.access_point;

import org.springframework.data.repository.PagingAndSortingRepository;
import wifi4eu.wifi4eu.entity.access_point.AccessPoint;

public interface AccessPointRepository extends PagingAndSortingRepository<AccessPoint, Integer>, AccessPointRepositoryCustom{

    Long countAccessPointByIdInstallationSite(Integer idInstallationSite);
}

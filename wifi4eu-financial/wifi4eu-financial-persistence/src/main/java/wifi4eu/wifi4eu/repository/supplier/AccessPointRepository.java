package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.supplier.AccessPoint;

import java.util.List;

public interface AccessPointRepository extends CrudRepository<AccessPoint, Long> {
    List<AccessPoint> findByInstallationId(Long installationId);
}

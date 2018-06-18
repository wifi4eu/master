package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.supplier.SuppliedRegion;

public interface SuppliedRegionRepository  extends CrudRepository<SuppliedRegion,Integer> {
    @Query(value = "SELECT COUNT(id), region FROM supplied_regions GROUP BY region", nativeQuery = true)
    Iterable<Object> findSuppliedRegionsCountGroupedByRegionId();
    Iterable<SuppliedRegion> findBySupplierId(Integer supplierId);
}
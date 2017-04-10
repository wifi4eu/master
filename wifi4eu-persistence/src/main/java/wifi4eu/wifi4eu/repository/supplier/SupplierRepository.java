package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;
import wifi4eu.wifi4eu.entity.location.Nuts;
import wifi4eu.wifi4eu.entity.supplier.Supplier;

import java.util.List;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {
    List<Nuts> findSelectedMeBySupplierId(Long supplierId);
}

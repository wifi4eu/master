package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.supplier.BenPubSup;

public interface BenPubSupRepository extends CrudRepository<BenPubSup, Long> {
    BenPubSup findSelectedMeBySupplierId(Long supplierId);
}

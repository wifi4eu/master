package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.supplier.BenPubSup;

public interface BenPubSupRepository extends CrudRepository<BenPubSup, Long> {
    Iterable<BenPubSup> findSelectedMeBySupplierId(Long supplierId);
    Iterable<BenPubSup> findAllByAwarded(boolean awarded);
}

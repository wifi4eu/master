package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.supplier.BenPubSup;

import java.util.List;

public interface BenPubSupRepository extends CrudRepository<BenPubSup, Long> {
    Iterable<BenPubSup> findSelectedMeBySupplierId(Long supplierId);

    Iterable<BenPubSup> findAllByAwarded(boolean awarded);

    BenPubSup findByBeneficiaryIdAndPublicationId(Long beneficiaryId, Long publicationId);

    List<BenPubSup> findByPublicationId(long publicationId);
}


package wifi4eu.wifi4eu.repository.audit;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.audit.AuditData;


public interface AuditRepository extends CrudRepository<AuditData,Long> {
}

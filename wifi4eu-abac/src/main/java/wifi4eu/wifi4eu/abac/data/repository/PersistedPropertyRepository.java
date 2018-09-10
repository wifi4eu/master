package wifi4eu.wifi4eu.abac.data.repository;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.abac.data.entity.PersistedProperty;

public interface PersistedPropertyRepository extends CrudRepository<PersistedProperty, Long> {

    PersistedProperty findFirstByNameEquals(String key);
}

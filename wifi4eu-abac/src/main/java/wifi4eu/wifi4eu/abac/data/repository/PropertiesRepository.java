package wifi4eu.wifi4eu.abac.data.repository;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.abac.data.entity.Properties;

public interface PropertiesRepository extends CrudRepository<Properties, Long> {

    String findFirstByNameEquals(String key);
}

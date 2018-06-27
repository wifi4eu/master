package wifi4eu.wifi4eu.repository.location;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.location.Municipality;

public interface MunicipalityRepository extends CrudRepository<Municipality, Long> {
	Municipality findByJagateKey(String jagateKey);
}

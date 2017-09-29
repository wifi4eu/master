package wifi4eu.wifi4eu.repository;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.Registration;

public interface RegistrationRepository extends CrudRepository<Registration,Integer> {
}
package wifi4eu.wifi4eu.repository.registration;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.registration.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, Integer> {
    Iterable<Registration> findByUserId(Integer userId);
    Iterable<Registration> findByMunicipalityId(Integer municipalityId);
    Registration findByUserIdAndMunicipalityId(Integer userId, Integer municipalityId);
}
package wifi4eu.wifi4eu.repository.registration;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.registration.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, Integer> {
    Registration findByMunicipalityId(Integer municipalityId);

    Registration findByMunicipalityIdAndStatus(Integer municipalityId, Integer status);
}
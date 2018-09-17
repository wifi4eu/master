package wifi4eu.wifi4eu.repository.municipality;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.municipality.Municipality;

public interface MunicipalityRepository extends CrudRepository<Municipality, Integer> {
    @Query(value =  "SELECT m.* FROM municipalities m JOIN registrations r ON m.id = r.municipality WHERE r.id = ?1", nativeQuery = true)
    Municipality findByRegistrationId(int registrationId);
}
package wifi4eu.wifi4eu.repository.warning;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.warnings.RegistrationWarning;

import java.util.List;

public interface RegistrationWarningRepository extends CrudRepository<RegistrationWarning, Integer> {
    @Query(value = "SELECT * FROM registration_warnings where registration_id = ?1 ORDER BY warning", nativeQuery = true)
    List<RegistrationWarning> findAllByRegistrationId(Integer registrationId);

    @Query(value = "SELECT distinct(rw.warning) FROM registration_warnings rw inner join registrations r on r.id = rw.registration_id inner join municipalities m on r.municipality = m.id where m.lau = ?1", nativeQuery = true)
    List<Integer> findAllByLauId(Integer registrationId);

    Integer countByRegistrationAndWarning(Integer registration, Integer warning);

    Integer countByRegistration(Integer registration);
}

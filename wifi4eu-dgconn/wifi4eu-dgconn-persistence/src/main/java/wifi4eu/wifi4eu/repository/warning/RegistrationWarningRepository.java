package wifi4eu.wifi4eu.repository.warning;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.warnings.RegistrationWarning;

import java.util.List;

public interface RegistrationWarningRepository extends CrudRepository<RegistrationWarning, Integer> {
    @Query(value = "SELECT * FROM registration_warnings where registration_id = ?1 ORDER BY warning", nativeQuery = true)
    List<RegistrationWarning> findAllByRegistrationId(Integer registrationId);
}

package wifi4eu.wifi4eu.repository.warning;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.warnings.WarningsNumber;

public interface WarningsNumberRepository extends CrudRepository<WarningsNumber, Integer> {

    @Query(value = "SELECT(SELECT DISTINCT id FROM registrations WHERE id = ?#{[0]}) as registration_id," +
            "(SELECT COUNT(1) FROM registration_warnings WHERE warning = 1 AND registration_id = ?#{[0]}) as warning1," +
            "(SELECT COUNT(1) FROM registration_warnings WHERE warning = 2 AND registration_id = ?#{[0]}) as warning2," +
            "(SELECT COUNT(1) FROM registration_warnings WHERE warning = 3 AND registration_id = ?#{[0]}) as warning3", nativeQuery = true)
    WarningsNumber countWarningsNumberByRegistration(Integer registrationId);

}

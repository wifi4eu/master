package wifi4eu.wifi4eu.repository.registration;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.registration.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, Integer> {
    @Query(value = "SELECT r.* FROM registrations r INNER JOIN registration_users ru ON ru.registration = r.id WHERE ru._user = ?#{[0]}", nativeQuery = true)
    Iterable<Registration> findByUserId(Integer userId);
}
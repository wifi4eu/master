package wifi4eu.wifi4eu.repository.application;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.application.ApplicationAuthorizedPerson;

public interface ApplicationAuthorizedPersonRepository extends CrudRepository<ApplicationAuthorizedPerson, Integer> {
    ApplicationAuthorizedPerson findByApplicationIdAndAuthorizedPerson(Integer applicationId, Integer authorizedPerson);

    @Query(value = "SELECT CAST(case when COUNT(*) > 0 THEN 1 ELSE 0 END AS bit) FROM applications a " +
            "INNER JOIN registrations r ON r.id = a.registration " +
            "INNER JOIN registration_users ru ON ru.registration = r.id " +
            "WHERE a.id = ?1 " +
            "AND ru.main = 1 " +
            "AND ru._user = ?2", nativeQuery = true)
    boolean findByApplicationUserAuthorized(Integer applicationId, Integer userId);
}
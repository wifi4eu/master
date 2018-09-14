package wifi4eu.wifi4eu.repository.application;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.entity.application.ApplicationAuthorizedPerson;

import java.util.List;


public interface ApplicationAuthorizedPersonRepository extends CrudRepository<ApplicationAuthorizedPerson, Integer> {
    ApplicationAuthorizedPerson findByApplicationIdAndAuthorizedPerson(Integer applicationId, Integer authorizedPerson);

    List<ApplicationAuthorizedPerson> findByApplicationIdOrderByAuthorizedPerson(Integer applicationId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM authorized_person_application WHERE authorized_person = ?#{[0]} AND application_id = ?#{[1]}", nativeQuery = true)
    int deleteByUserIdAndApplicationId(int userId, int applicationId);
}
package wifi4eu.wifi4eu.repository.application;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.application.ApplicationAuthorizedPerson;

public interface ApplicationAuthorizedPersonRepository extends CrudRepository<ApplicationAuthorizedPerson, Integer> {
    ApplicationAuthorizedPerson findByApplicationIdAndAuthorizedPerson(Integer applicationId, Integer authorizedPerson);
}
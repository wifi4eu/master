package wifi4eu.wifi4eu.repository.voucher;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.voucher.SimpleRegistration;

import java.util.List;

public interface SimpleRegistrationRepository extends CrudRepository<SimpleRegistration,Integer> {

    @Query(value = "SELECT registrations.id, registrations.municipality FROM registrations INNER JOIN applications ON registrations.id = applications.registration", nativeQuery = true)
    List<SimpleRegistration> findAllSimpleRegistrationsFromApplications();

}

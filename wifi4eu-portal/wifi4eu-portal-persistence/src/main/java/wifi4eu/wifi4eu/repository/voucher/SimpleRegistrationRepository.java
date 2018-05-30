package wifi4eu.wifi4eu.repository.voucher;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.entity.voucher.SimpleRegistration;

import java.util.List;

public interface SimpleRegistrationRepository extends CrudRepository<Registration,Integer> {

    @Query(value = "select registrations.id, registrations.municipality from registrations " +
            "INNER JOIN applications ON registrations.id = applications.registration", nativeQuery = true)
    List<SimpleRegistration> findAllSimpleRegistrations();

}

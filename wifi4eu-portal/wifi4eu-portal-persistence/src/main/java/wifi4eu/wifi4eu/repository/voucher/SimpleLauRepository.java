package wifi4eu.wifi4eu.repository.voucher;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.voucher.SimpleLau;

import java.util.List;

public interface SimpleLauRepository extends CrudRepository<SimpleLau, Integer> {

    @Query(value = "SELECT laus.id, laus.country_code FROM laus INNER JOIN municipalities ON municipalities.lau = laus.id INNER JOIN registrations ON municipalities.id = registrations.municipality INNER JOIN applications ON registrations.id = applications.registration WHERE laus.country_code IS NOT NULL", nativeQuery = true)
    List<SimpleLau> findAllLausFromApplications();
}

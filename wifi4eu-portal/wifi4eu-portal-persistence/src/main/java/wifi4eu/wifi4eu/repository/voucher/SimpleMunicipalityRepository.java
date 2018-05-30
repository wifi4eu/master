package wifi4eu.wifi4eu.repository.voucher;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.voucher.SimpleMunicipality;

import java.util.List;


public interface SimpleMunicipalityRepository extends CrudRepository<SimpleMunicipality, Integer> {

    @Query(value = "SELECT municipalities.id, municipalities.country, municipalities.lau FROM municipalities INNER JOIN registrations ON municipalities.id = registrations.municipality INNER JOIN applications ON registrations.id = applications.registration", nativeQuery = true)
    List<SimpleMunicipality> findAllMunicipalitiesFromApplications();
}

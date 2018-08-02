package wifi4eu.wifi4eu.repository.voucher;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.voucher.SimpleMunicipality;

import java.util.List;


public interface SimpleMunicipalityRepository extends CrudRepository<SimpleMunicipality, Integer> {

    @Query(value = "SELECT municipalities.id, municipalities.country, municipalities.lau, municipalities.name FROM municipalities INNER JOIN registrations ON municipalities.id = registrations.municipality INNER JOIN applications ON registrations.id = applications.registration WHERE municipalities.country IS NOT NULL AND municipalities.name IS NOT NULL", nativeQuery = true)
    List<SimpleMunicipality> findAllMunicipalitiesFromApplications();

    // @Query(value = "SELECT municipalities.id, municipalities.country, municipalities.lau, municipalities.name FROM municipalities INNER JOIN registrations ON municipalities.id = registrations.municipality INNER JOIN applications ON registrations.id = applications.registration WHERE municipalities.country IS NOT NULL AND municipalities.name IS NOT NULL AND municipalities.id = ?1", nativeQuery = true)
    // SimpleMunicipality findMunicipalityById(Integer municipalityId);

    @Query(value = "SELECT municipalities.id, municipalities.country, municipalities.lau, municipalities.name FROM municipalities WHERE municipalities.country IS NOT NULL AND municipalities.name IS NOT NULL AND municipalities.id = ?1", nativeQuery = true)
    SimpleMunicipality findMunicipalityById(Integer municipalityId);
}

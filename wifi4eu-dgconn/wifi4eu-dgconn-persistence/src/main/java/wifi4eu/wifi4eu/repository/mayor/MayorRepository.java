package wifi4eu.wifi4eu.repository.mayor;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.mayor.Mayor;

public interface MayorRepository extends CrudRepository<Mayor,Integer> {
    Mayor findByMunicipalityId(Integer municipalityId);

    /*@Query(value = "SELECT m.* FROM mayors m JOIN registrations r ON m.municipality = r.municipality WHERE r.id = ?#{[0]}", nativeQuery = true)
    Mayor findByRegistrationId(Integer registrationId);*/
}
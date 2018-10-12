package wifi4eu.wifi4eu.repository.registration;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import wifi4eu.wifi4eu.entity.registration.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, Integer> {

    Registration findByMunicipalityId(Integer municipalityId);

    @Query(value = "select r.id from Registration r where r.municipality.id = :municipalityId")
    Integer findIdByMunicipalityId(@Param("municipalityId") Integer municipalityId);

    Iterable<Registration> findByIpRegistration(String ipRegistration);
}
package wifi4eu.wifi4eu.repository.municipality;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import wifi4eu.wifi4eu.entity.municipality.Municipality;

import java.util.List;

public interface MunicipalityRepository extends CrudRepository<Municipality, Integer> {
    @Query(value = "SELECT COUNT(id),lau FROM municipalities GROUP BY lau", nativeQuery = true)
    Iterable<Object> findMunicipalitiesCountGroupedByLauId();

    @Query("SELECT m.name FROM Municipality m INNER JOIN Lau l ON m.lau.id = l.id AND l.nuts3 =:code GROUP BY m.name")
    List<String> getMunicipalitiesRegisteredByRegion(@Param("code") String code);

}
package wifi4eu.wifi4eu.repository.municipality;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.municipality.Municipality;

public interface MunicipalityRepository extends CrudRepository<Municipality, Integer> {
    Iterable<Municipality> findByLauId(Integer lauId);
    @Query(value = "SELECT COUNT(id),lau FROM municipalities GROUP BY lau", nativeQuery = true)
    Iterable<Object> findMunicipalitiesCountGroupedByLauId();
    @Query(
            value = "SELECT COUNT(DISTINCT(m.lau)) FROM municipalities m",
            nativeQuery = true)
    Integer countDistinctMunicipalities();
    @Query(
            value = "SELECT COUNT(DISTINCT(m.lau)) as lauId FROM municipalities m WHERE LOWER(m.name) LIKE LOWER(CONCAT('%',?#{[0]},'%'))",
            nativeQuery = true)
    Integer countDistinctMunicipalitiesContainingName(String name);
}
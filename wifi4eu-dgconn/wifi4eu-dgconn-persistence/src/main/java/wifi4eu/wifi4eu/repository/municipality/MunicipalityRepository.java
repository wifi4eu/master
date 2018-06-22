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

    @Query(
            value = "SELECT COUNT(DISTINCT(m1.lau)) FROM municipalities m1 INNER JOIN registrations reg ON reg.municipality = m1.id INNER JOIN applications app ON app.registration = reg.id INNER JOIN laus l ON l.id = m1.lau WHERE l.country_code LIKE ?#{[1]} AND app.call_id = ?#{[0]}",
            nativeQuery = true
    )
    Integer countDistinctMunicipalitiesThatAppliedCall(Integer callId, String country);
    @Query(
            value = "SELECT COUNT(DISTINCT(m1.lau)) FROM municipalities m1 INNER JOIN registrations reg ON reg.municipality = m1.id INNER JOIN applications app ON app.registration = reg.id INNER JOIN laus l ON l.id = m1.lau WHERE l.country_code LIKE ?#{[1]} AND app.call_id = ?#{[0]} AND LOWER(m1.name) LIKE LOWER(CONCAT('%',?#{[2]},'%'))",
            nativeQuery = true
    )
    Integer countDistinctMunicipalitiesThatAppliedCallContainingName(Integer callId, String country, String name);
}
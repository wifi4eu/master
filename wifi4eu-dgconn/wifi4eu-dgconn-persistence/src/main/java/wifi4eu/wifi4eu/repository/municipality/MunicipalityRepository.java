package wifi4eu.wifi4eu.repository.municipality;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.municipality.Municipality;

import java.util.ArrayList;
import java.util.List;

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

    Long countMunicipalitiesById(Integer id);

    @Query(value = "SELECT m.* FROM registrations r " +
            // "INNER JOIN users u ON r._user = u.id " +
            "INNER JOIN registration_users ru ON ru.registration = r.id " +
            "INNER JOIN users u ON ru._user = u.id " +
            "INNER JOIN municipalities m ON r.municipality = m.id " +
            "INNER JOIN applications a ON a.registration = r.id " +
            "INNER JOIN calls c ON c.id = a.call_id " +
            "INNER JOIN laus l ON l.id = m.lau " +
            "INNER JOIN nuts n ON l.country_code = n.country_code " +
            "WHERE n.level = 0 AND n.id = ?1 AND ru.main = 1", nativeQuery = true)
    ArrayList<Municipality> findAllByNut(int idNut);

    @Query(value = "SELECT m.* FROM registrations r " +
            // "INNER JOIN users u ON r._user = u.id " +
            "INNER JOIN registration_users ru ON ru.registration = r.id " +
            "INNER JOIN users u ON ru._user = u.id " +
            "INNER JOIN municipalities m ON r.municipality = m.id " +
            "INNER JOIN applications a ON a.registration = r.id " +
            "INNER JOIN calls c ON c.id = a.call_id INNER JOIN laus l ON l.id = m.lau " +
            "INNER JOIN nuts n ON l.country_code = n.country_code " +
            "WHERE n.level = 0 AND c.id = ?1 AND n.id = ?2 AND ru.main = 1", nativeQuery = true)
    ArrayList<Municipality> findAllByCallAndNut(int idCall, int idNut);

    @Query(value = "SELECT DISTINCT m.name FROM municipalities m " +
            "INNER JOIN laus l ON l.id = m.lau " +
            "INNER JOIN nuts n ON n.country_code = l.country_code " +
            "INNER JOIN registrations r ON r.municipality = m.id " +
            "INNER JOIN applications a ON a.registration = r.id " +
            "INNER JOIN calls c ON c.id = a.call_id " +
            "WHERE cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 BETWEEN start_date AND end_date AND n.id = ?1 GROUP BY m.name", nativeQuery = true)
    List<String> findAllMunicipalitiesByCountry(int idNut);
}
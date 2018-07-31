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

    Long countMunicipalitiesById(Integer id);

    @Query(value = "SELECT count(m.id) FROM registrations r INNER JOIN municipalities m ON m.id = r.municipality INNER JOIN registration_users ru on ru.registration = r.id WHERE ru._user = ?1", nativeQuery = true)
    Long countMunicipalitiesByUserId(long idUser);

    /* if value 1 = DISABLE EDIT, if value = 0 ENABLE EDIT*/
    /*
    @Query(value = "SELECT CASE WHEN EXISTS(SELECT a.id FROM applications a INNER JOIN registrations r ON a.registration = r.id INNER JOIN municipalities m ON r.municipality = m.id INNER JOIN calls c ON a.call_id = c.id WHERE (CONVERT(bigint, getdate(), 121) BETWEEN c.start_date AND c.end_date) AND m.id = ?1) THEN 1 ELSE 0 END", nativeQuery = true)
    Integer checkMunicipalityEditPermissionsCallOpen(int municipalityId);
    */

    /* if value 1 = ENABLE EDIT, if value = 0 DISABLE EDIT*/
    /*
    @Query(value = "SELECT CASE WHEN EXISTS(SELECT a.id FROM applications a INNER JOIN registrations r ON a.registration = r.id INNER JOIN municipalities m ON r.municipality = m.id INNER JOIN calls c ON a.call_id = c.id INNER JOIN voucher_simulations va ON va.municipality = m.id WHERE (CONVERT(bigint, getdate(), 121) > c.end_date) AND m.id = ?1 AND va.selection_status != 1 AND va.selection_status != 3) THEN 1 ELSE 0 END", nativeQuery = true)
    Integer checkMunicipalityEditPermissionsCallClosed(int municipalityId);
    */

    /* IF VALUE = 1 ENABLE EDIT, IF VALUE = 0 DISABLE EDIT */
    @Query(value = "SELECT CASE WHEN EXISTS(SELECT a.id FROM applications a INNER JOIN registrations r ON a.registration = r.id INNER JOIN municipalities m ON r.municipality = m.id INNER JOIN calls c ON a.call_id = c.id WHERE m.id = ?1) THEN (SELECT CASE WHEN EXISTS(SELECT a.id FROM applications a INNER JOIN registrations r ON a.registration = r.id INNER JOIN municipalities m ON r.municipality = m.id INNER JOIN calls c ON a.call_id = c.id WHERE (CONVERT(bigint, getdate(), 121) BETWEEN c.start_date AND c.end_date) AND m.id = ?1) THEN 0 ELSE (SELECT CASE WHEN EXISTS(SELECT a.id FROM applications a INNER JOIN registrations r ON a.registration = r.id INNER JOIN municipalities m ON r.municipality = m.id INNER JOIN calls c ON a.call_id = c.id INNER JOIN voucher_simulations va ON va.municipality = m.id WHERE (CONVERT(bigint, getdate(), 121) > c.end_date) AND m.id = ?1 AND va.selection_status != 1 AND va.selection_status != 3) THEN 1 ELSE 0 END) END) ELSE 1 END", nativeQuery = true)
    Integer checkMunicipalityEditPermission(int municipalityId);

    /*
    SELECT CASE WHEN EXISTS(SELECT a.id FROM applications a INNER JOIN registrations r ON a.registration = r.id INNER JOIN municipalities m ON r.municipality = m.id INNER JOIN calls c ON a.call_id = c.id INNER JOIN voucher_simulations va ON va.municipality = m.id WHERE (CONVERT(bigint, getdate(), 121) > c.end_date) AND m.id = ?1)THEN 1 ELSE 0 END
     */

}
package wifi4eu.wifi4eu.repository.municipality;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wifi4eu.wifi4eu.entity.exportImport.BeneficiaryInformation;
import wifi4eu.wifi4eu.entity.municipality.Municipality;

import java.util.ArrayList;
import java.util.List;

public interface MunicipalityRepository extends JpaRepository<Municipality, Integer> {

    List<Municipality> findByLauId(Integer lauId);

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

    @Query(value = "select new wifi4eu.wifi4eu.entity.exportImport.BeneficiaryInformation(" +
            "m.id, m.name, m.address, m.addressNum, m.postalCode, " +
            "m.lau.name2, m.lau.countryCode, r.id, " +
            "lf.id, lf.fileName, lf.fileName, lf.fileMime, lf.uploadTime, lf.fileType, lf.azureUri, " +
            "ma.abacReference, ma.abacStandarName, va.call.id, " +
            "u.lang" +
            ") from Municipality m " +
            "inner join m.registrations r " +
            "inner join r.applications a " +
            "inner join r.legalFiles lf on lf.fileType = 1 " +
            "inner join m.voucherSimulations vs on (vs.selectionStatus = 1 or vs.selectionStatus = 3) " +
            "inner join vs.voucherAssignment va on va.status = 3 " +
            "left join m.municipalitiesAbac ma " +
            "left join r.users u " +
            "where m.name is not null and (m.municipalitiesAbac is empty or ma.abacReference is null)")
    List<BeneficiaryInformation> findBeneficiaryInformation();
}
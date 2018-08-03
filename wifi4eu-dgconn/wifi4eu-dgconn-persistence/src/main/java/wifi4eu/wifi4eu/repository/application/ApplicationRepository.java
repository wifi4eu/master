package wifi4eu.wifi4eu.repository.application;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.application.Application;

import java.util.List;

public interface ApplicationRepository extends CrudRepository<Application,Integer> {
    Iterable<Application> findBySupplierId(Integer supplierId);
    Application findByCallIdAndRegistrationId(Integer callId, Integer registrationId);
    Iterable<Application> findByRegistrationId(Integer registrationId);
    Application findByRegistrationIdAndCallId(Integer registrationId, Integer callId);

    Iterable<Application> findByCallId(Integer callId);
    Iterable<Application> findByCallIdOrderByIdAsc(Integer callId);
    List<Application> findByCallIdOrderByDateAsc(Integer callId);
    List<Application> findByCallIdAndStatus(Integer callId, Integer status);

    @Query(value = "SELECT ap.* FROM applications ap INNER JOIN registrations r ON ap.registration = r.id WHERE r._status != 1 AND ap.call_id = ?1", nativeQuery = true)
//    AND r.allFilesFlag = 1
    List<Application> findApplicationsByRegistrationNotInvalidated(int callId);

    @Query(value = "SELECT count(*) FROM applications ap WHERE ap._status != 1 AND ap.call_id = ?1", nativeQuery = true)
    Integer findApplicationsNotInvalidated(int callId);

    @Query(value = "SELECT ap.* FROM applications ap INNER JOIN registrations r ON ap.registration = r.id INNER JOIN municipalities m ON r.municipality = m.id " +
            "INNER JOIN laus l ON m.lau = l.id WHERE ap._status != 1 AND ap.call_id = ?1 AND l.country_code = ?2  AND ap.date >= ?3 order by ap.date ASC", nativeQuery = true)
    List<Application> findApplicationsByCountry(int callId, String countryCode, Long startDate);

    @Query(value = "SELECT count(*) FROM applications ap INNER JOIN registrations r ON ap.registration = r.id INNER JOIN municipalities m ON r.municipality = m.id " +
            "WHERE m.lau = ?1 AND m.id = ?2", nativeQuery = true)
    Integer findApplicationsWithSameLau(int lauId, int municipalityId);

    @Query(value = "SELECT a.* FROM applications a INNER JOIN registrations r ON a.registration = r.id INNER JOIN municipalities m ON r.municipality = m.id " +
            "WHERE m.country = ?1 AND a.call_id = ?2 ORDER BY a.date ASC", nativeQuery = true)
    List<Application> findApplicationsCountry(String country, int callId);

    @Query(value = "SELECT a.id FROM applications a INNER JOIN registrations r ON a.registration = r.id INNER JOIN municipalities m ON r.municipality = m.id " +
            "WHERE m.country = ?1 AND a.call_id = ?2 AND a.date >= ?3 ORDER BY a.date ASC", nativeQuery = true)
    List<Integer> findIdApplications(String country, int callId, Long date);

    @Query(value = "SELECT count(a.id) FROM applications a INNER JOIN registrations r ON a.registration = r.id INNER JOIN municipalities m ON r.municipality = m.id " +
            "WHERE m.lau = ?1 AND a._status != 1 AND a.call_id = ?2 AND a.date >= ?3", nativeQuery = true)
    Integer countApplicationsBySameMunicipality(int lauId, int callId, long date);

    @Query(value = "SELECT a.* from applications a INNER JOIN registrations r ON a.registration = r.id WHERE a.call_id = ?1 AND a.date >= ?2 ORDER BY a.date ASC", nativeQuery = true)
    List<Application> findByCallIdOrderByDateBAsc(Integer callId, Long startDate);

    @Query(value = "SELECT app.* FROM applications app INNER JOIN registrations reg ON reg.id = app.registration INNER JOIN municipalities mun ON mun.id = reg.municipality WHERE app.call_id = ?#{[0]} AND mun.lau = ?#{[1]} AND app._status = ?#{[2]}", nativeQuery = true)
    List<Application> findByCallIdAndLauIdAndStatus(Integer callId, Integer lauId, Integer status);


    @Query(value = "SELECT app.* FROM applications app INNER JOIN registrations reg ON reg.id = app.registration INNER JOIN municipalities mun ON mun.id = reg.municipality WHERE app.call_id = ?#{[0]} AND mun.lau = ?#{[1]}", nativeQuery = true)
    List<Application> findByCallIdAndLauId(Integer callId, Integer lauId);

    @Query(value = "SELECT * FROM applications app LEFT JOIN registrations reg ON reg.id = app.registration LEFT JOIN municipalities mun ON mun.id = reg.municipality WHERE app.call_id = ?#{[0]} AND mun.lau = ?#{[1]} ORDER BY app.date ASC", nativeQuery = true)
    List<Application> findByCallIdAndLauIdOrderByDateAsc(Integer callId, Integer lauId);

    @Query(value = "SELECT a.* FROM applications a INNER JOIN registrations r ON a.registration = r.id INNER JOIN registration_users ru ON ru.registration = r.id INNER JOIN users u ON ru._user = u.id WHERE a.id NOT IN (SELECT vs.application FROM voucher_simulations vs WHERE vs.voucher_assignment = ?2) AND a.call_id = ?1", nativeQuery = true)
    List<Application> getApplicationsNotSelectedInVoucherAssignment(Integer callId, Integer voucherAssignmentId);

    @Query(value = "SELECT a.* FROM applications a INNER JOIN registrations r ON a.registration = r.id INNER JOIN registration_users ru ON ru.registration = r.id INNER JOIN users u ON ru._user = u.id WHERE a.id IN (SELECT vs.application FROM voucher_simulations vs WHERE vs.voucher_assignment = ?1 AND vs.selection_status = ?2)", nativeQuery = true)
    List<Application> getApplicationsSelectedInVoucherAssignment(Integer voucherAssignmentId, Integer selectionStatus);
}
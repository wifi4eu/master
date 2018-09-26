package wifi4eu.wifi4eu.repository.application;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.entity.application.Application;

import java.util.Date;
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

//    @Modifying
//    @Transactional
//    @Query(value = "UPDATE applications SET sent_email = ?#{[0]}, sent_email_date = ?#{[1]} WHERE id = ?#{[2]}", nativeQuery = true)
//    int updateSentEmailByApplicationId(boolean sentEmail, Date sentEmailDate, int applicationId);

    @Query(value = "SELECT count(a.id) FROM applications a WHERE a.call_id = ?1", nativeQuery = true)
    Long countApplicationsForCallId(int idCall);

    @Query(value = "SELECT count(r.id) FROM registrations r " +
            // "INNER JOIN users u ON r._user = u.id " +
            "INNER JOIN registration_users ru ON ru.registration = r.id " +
            "INNER JOIN users u ON ru._user = u.id " +
            "INNER JOIN municipalities m ON r.municipality = m.id " +
            "INNER JOIN applications a ON a.registration = r.id " +
            "INNER JOIN calls c ON c.id = a.call_id " +
            "INNER JOIN laus l ON l.id = m.lau " +
            "INNER JOIN nuts n ON l.country_code = n.country_code " +
            "WHERE n.level = 0 AND c.id = ?1 AND n.id = ?2 AND ru.main = 1", nativeQuery = true)
    Long getNumberBeneficiariesByCallIdAndNut(int idCall, int idNut);

    @Query(value = "SELECT count(i.id) FROM installation_site i " +
            "INNER JOIN municipalities m ON m.id = i.id_municipality " +
            "INNER JOIN registrations r ON r.municipality = m.id " +
            "INNER JOIN applications a ON a.registration = r.id " +
            "INNER JOIN calls c ON c.id = a.call_id " +
            "INNER JOIN laus l ON l.id = m.lau " +
            "INNER JOIN nuts n ON n.country_code = l.country_code " +
            "WHERE n.level = 0 AND r.is_confirmation IS NOT NULL AND c.id = ?1 AND n.id = ?2", nativeQuery = true)
    Long countInstallationSitesValidatedForCurrentCallAndNut(int idCall, int idNut);

    @Query(value = "SELECT count(ap.id) FROM access_points ap " +
            "INNER JOIN installation_site i ON i.id = ap.id_installation_site " +
            "INNER JOIN municipalities m ON m.id = i.id_municipality " +
            "INNER JOIN registrations r ON m.id = r.municipality " +
            "INNER JOIN applications a ON a.registration = r.id " +
            "INNER JOIN calls c ON c.id = a.call_id " +
            "INNER JOIN laus l ON l.id = m.lau " +
            "INNER JOIN nuts n ON n.country_code = l.country_code " +
            "WHERE n.level = 0 AND ap.isIndoor= ?1 AND c.id = ?2 AND n.id = ?3", nativeQuery = true)
    Long countAccessPointsForCurrentCallAndNut(boolean indoor, int idCall, int idNut);

    @Query(value = "SELECT count(r.id) FROM registrations r " +
            // "INNER JOIN users u ON r._user = u.id " +
            "INNER JOIN registration_users ru ON ru.registration = r.id " +
            "INNER JOIN users u ON ru._user = u.id " +
            "INNER JOIN municipalities m ON r.municipality = m.id " +
            "INNER JOIN applications a ON a.registration = r.id " +
            "INNER JOIN calls c ON c.id = a.call_id " +
            "INNER JOIN laus l ON l.id = m.lau " +
            "INNER JOIN nuts n ON l.country_code = n.country_code " +
            "WHERE n.level = 0 AND n.id = ?1 AND ru.main = 1", nativeQuery = true)
    Long getNumberBeneficiariesByNut(int idNut);

    @Query(value = "SELECT count(i.id) FROM installation_site i " +
            "INNER JOIN municipalities m ON m.id = i.id_municipality " +
            "INNER JOIN registrations r ON r.municipality = m.id " +
            "INNER JOIN applications a ON a.registration = r.id " +
            "INNER JOIN calls c ON c.id = a.call_id " +
            "INNER JOIN laus l ON l.id = m.lau " +
            "INNER JOIN nuts n ON n.country_code = l.country_code " +
            "WHERE n.level = 0 AND r.is_confirmation IS NOT NULL AND n.id = ?1", nativeQuery = true)
    Long countInstallationSitesValidatedForNut(int idNut);

    @Query(value = "SELECT count(ap.id) FROM access_points ap " +
            "INNER JOIN installation_site i ON i.id = ap.id_installation_site " +
            "INNER JOIN municipalities m ON m.id = i.id_municipality " +
            "INNER JOIN registrations r ON m.id = r.municipality " +
            "INNER JOIN applications a ON a.registration = r.id " +
            "INNER JOIN calls c ON c.id = a.call_id " +
            "INNER JOIN laus l ON l.id = m.lau " +
            "INNER JOIN nuts n ON n.country_code = l.country_code " +
            "WHERE n.level = 0 AND ap.isIndoor= ?1 AND n.id = ?2", nativeQuery = true)
    Long countAccessPointsForNut(boolean indoor, int idNut);

    @Query(value = "SELECT a.* FROM applications a " +
            "INNER JOIN calls c ON c.id = a.call_id " +
            "WHERE cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 BETWEEN start_date AND end_date", nativeQuery = true)
    List<Application> findApplicationsForCurrentCall();

    @Query(value = "SELECT a.* FROM applications a " +
            "INNER JOIN calls c ON c.id = a.call_id " +
            "INNER JOIN registrations r ON r.id = a.registration " +
            "INNER JOIN municipalities m ON m.id = r.municipality " +
            "INNER JOIN laus l ON l.id = m.lau " +
            "INNER JOIN nuts n ON l.country_code = n.country_code " +
            "WHERE cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 BETWEEN start_date AND end_date AND n.level = 0 AND n.id = ?1", nativeQuery = true)
    List<Application> findApplicationsForCurrentCall(int idNut);

    @Query(value = "SELECT count(a.id) FROM applications a " +
            "INNER JOIN calls c ON c.id = a.call_id " +
            "WHERE cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 BETWEEN start_date AND end_date", nativeQuery = true)
    long countApplicationsForCurrentCall();

    @Query(value = "SELECT count(a.id) FROM applications a " +
            "INNER JOIN calls c ON c.id = a.call_id " +
            "INNER JOIN registrations r ON r.id = a.registration " +
            "INNER JOIN municipalities m ON m.id = r.municipality " +
            "INNER JOIN laus l ON l.id = m.lau " +
            "INNER JOIN nuts n ON l.country_code = n.country_code " +
            "WHERE cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 BETWEEN start_date AND end_date AND n.level = 0 AND n.id = ?1", nativeQuery = true)
    long countApplicationsForCurrentCall(int idNut);

    @Query(value = "SELECT count(a.id) FROM applications a WHERE a.call_id = ?#{[0]}", nativeQuery = true)
    Integer countApplicationsForSelectedCall(Integer callId);

    @Query(value = "SELECT count(a.id) FROM applications a " +
            "INNER JOIN registrations r ON r.id = a.registration " +
            "INNER JOIN municipalities m ON m.id = r.municipality " +
            "INNER JOIN laus l ON l.id = m.lau " +
            "INNER JOIN nuts n ON l.country_code = n.country_code " +
            "WHERE a.call_id = ?#{[0]} AND n.level = 0 AND n.id = ?#{[1]}", nativeQuery = true)
    Integer countApplicationsForSelectedCall(Integer callId, Integer idNut);

    @Query(value = "SELECT count(a.id) FROM applications a " +
            "INNER JOIN calls c ON c.id = a.call_id " +
            "INNER JOIN registrations r ON r.id = a.registration " +
            "INNER JOIN municipalities m ON m.id = r.municipality " +
            "INNER JOIN laus l ON l.id = m.lau " +
            "INNER JOIN nuts n ON l.country_code = n.country_code " +
            "WHERE cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 BETWEEN start_date AND end_date AND n.level = 0 AND n.id = ?1 AND a._status = 1", nativeQuery = true)
    long countApplicationsForCurrentCallInvalidated(int idNut);

    @Query(value = "SELECT count(a.id) FROM applications a " +
            "INNER JOIN calls c ON c.id = a.call_id " +
            "INNER JOIN registrations r ON r.id = a.registration " +
            "INNER JOIN municipalities m ON m.id = r.municipality " +
            "INNER JOIN laus l ON l.id = m.lau " +
            "INNER JOIN nuts n ON l.country_code = n.country_code " +
            "WHERE cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 BETWEEN start_date AND end_date AND n.level = 0 AND a._status = 1", nativeQuery = true)
    long countApplicationsForCurrentCallInvalidated();

    @Query(value = "SELECT count (a.id) FROM applications a " +
            "INNER JOIN calls c ON c.id = a.call_id " +
            "INNER JOIN registrations r ON r.id = a.registration " +
            "INNER JOIN municipalities m ON m.id = r.municipality " +
            "WHERE cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 BETWEEN start_date AND end_date GROUP BY m.name HAVING COUNT(*) > 1", nativeQuery = true)
    List<Integer> countAplicationsDuplicatedForCall();

    @Query(value = "SELECT count (a.id) FROM applications a " +
            "INNER JOIN calls c ON c.id = a.call_id " +
            "INNER JOIN registrations r ON r.id = a.registration " +
            "INNER JOIN municipalities m ON m.id = r.municipality " +
            "INNER JOIN laus l ON l.id = m.lau " +
            "INNER JOIN nuts n ON n.country_code = l.country_code " +
            "WHERE cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 BETWEEN start_date AND end_date AND n.id = ?1 AND m.name = ?2", nativeQuery = true)
    Long countApplicationsForMunicipalityByCountry(int idNut, String munName);

    @Query(value = "SELECT count (a.id) FROM applications a " +
            "INNER JOIN calls c ON c.id = a.call_id " +
            "INNER JOIN registrations r ON r.id = a.registration " +
            "INNER JOIN municipalities m ON m.id = r.municipality " +
            "WHERE cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 BETWEEN start_date AND end_date " +
            "AND a._status = 1 GROUP BY m.name HAVING COUNT(*) > 1", nativeQuery = true)
    List<Integer> countAplicationsDuplicatedForCallInvalidated();

    @Query(value = "SELECT count (a.id) FROM applications a " +
            "INNER JOIN calls c ON c.id = a.call_id " +
            "INNER JOIN registrations r ON r.id = a.registration " +
            "INNER JOIN municipalities m ON m.id = r.municipality " +
            "INNER JOIN laus l ON l.id = m.lau " +
            "INNER JOIN nuts n ON n.country_code = l.country_code " +
            "WHERE cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 BETWEEN start_date AND end_date " +
            "AND n.id = ?1 AND m.name = ?2 AND a._status = 1", nativeQuery = true)
    Long countApplicationsForMunicipalityByCountryInvalidated(int idNut, String munName);

    @Query(value = "SELECT count(air.id) FROM application_invalidate_reason air " +
            "INNER JOIN applications a ON a.id = air.application_id " +
            "INNER JOIN calls c ON c.id = a.call_id " +
            "WHERE a._status = 1 AND a.call_id = ?1 AND air.reason = ?2", nativeQuery = true)
    Integer findApplicationInvalidatedByCallAndReason(int idCall, int reason);

    @Query(value = "SELECT count(air.id) FROM application_invalidate_reason air " +
            "INNER JOIN applications a ON a.id = air.application_id " +
            "INNER JOIN calls c ON c.id = a.call_id " +
            "INNER JOIN registrations r ON r.id = a.registration " +
            "INNER JOIN municipalities m ON m.id = r.municipality " +
            "INNER JOIN laus l ON l.id = m.lau " +
            "INNER JOIN nuts n ON l.country_code = n.country_code " +
            "WHERE a._status = 1 AND a.call_id = ?1 AND air.reason = ?2 AND n.id = ?3", nativeQuery = true)
    Integer findApplicationsInvalidatedByCallAndReasonAndNut(int idCall, int reason, int idNut);

    @Query(value = "SELECT count(*) FROM applications ap WHERE ap._status = 2 AND ap.call_id = ?1", nativeQuery = true)
    Integer countValidatedApplicationsByCall(Integer callId);


    @Query(value = "SELECT count(*) FROM applications ap WHERE ap._pre_selected_flag = 1 AND ap.call_id = ?#{[0]}", nativeQuery = true)
    Integer countPreSelectedApplicationsByCall(Integer callId);

    @Query(value = "SELECT count(*) FROM applications ap " +
            "INNER JOIN registrations r ON r.id = ap.registration " +
            "INNER JOIN municipalities m ON m.id = r.municipality " +
            "INNER JOIN laus l ON l.id = m.lau " +
            "INNER JOIN nuts n ON l.country_code = n.country_code " +
            "WHERE ap.pre_selected_flag = 1 AND ap.call_id = ?#{[0]} AND n.level = 0 AND n.id = ?#{[1]} ", nativeQuery = true)
    Integer countPreSelectedApplicationsByCall(Integer callId, Integer idNut);


    @Query(value = "SELECT count(*) FROM applications ap " +
            "INNER JOIN voucher_simulations vs ON vs.application = ap.id " +
            "WHERE ap.call_id = ?#{[0]} AND vs.selection_status = ?#{[1]}", nativeQuery = true)
    Integer countApplicationsSelectedInVoucherAssignmentByCall(Integer callId, Integer status);

    @Query(value = "SELECT count(*) FROM applications ap " +
            "INNER JOIN voucher_simulations vs ON vs.application = ap.id " +
            "INNER JOIN registrations r ON r.id = ap.registration " +
            "INNER JOIN municipalities m ON m.id = r.municipality " +
            "INNER JOIN laus l ON l.id = m.lau " +
            "INNER JOIN nuts n ON l.country_code = n.country_code " +
            "WHERE ap.call_id = ?#{[0]} AND n.level = 0 AND n.id = ?#{[1]} AND vs.selection_status = ?#{[2]} ", nativeQuery = true)
    Integer countApplicationsSelectedInVoucherAssignmentByCall(Integer callId, Integer idNut, Integer status);


}
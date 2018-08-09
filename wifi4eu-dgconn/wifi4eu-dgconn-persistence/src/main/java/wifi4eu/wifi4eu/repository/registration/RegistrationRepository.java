package wifi4eu.wifi4eu.repository.registration;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.registration.Registration;

import java.util.List;

public interface RegistrationRepository extends CrudRepository<Registration, Integer> {
    @Query(value = "SELECT r.* FROM registrations r INNER JOIN registration_users ru ON ru.registration = r.id WHERE ru._user = ?#{[0]}", nativeQuery = true)
    Iterable<Registration> findByUserId(Integer userId);

    Registration findByMunicipalityId(Integer municipalityId);

    @Query(value = "SELECT r.* FROM registrations r INNER JOIN registration_users ru ON ru.registration = r.id WHERE ru._user = ?#{[0]} AND r.municipality = ?#{[1]}", nativeQuery = true)
    Registration findByUserIdAndMunicipalityId(Integer userId, Integer municipalityId);

    Iterable<Registration> findByIpRegistration(String ipRegistration);

    @Query(value = "SELECT DISTINCT(lf.type) FROM log_emails le JOIN registrations r ON le.municipalityId = r.municipality JOIN legal_files lf ON lf.registration = r.id JOIN legal_files_correction_reason lcr  ON lf.registration = lcr.registration AND lf.type = lcr.type WHERE r.id = ?#{[0]} AND lcr.request_correction = 1 GROUP BY lf.type, lcr.type HAVING (CAST(Datediff(s, '1970-01-01', MAX(lcr.request_correction_date)) AS BIGINT) + 2 * 60 * 60) *1000  > MAX(le.sent_date) AND MAX(lcr.request_correction_date) > MAX(lf.upload_time)", nativeQuery = true)
    List<Integer> findTypeFilesWaitingUploadByRegistration(Integer registrationId);
}
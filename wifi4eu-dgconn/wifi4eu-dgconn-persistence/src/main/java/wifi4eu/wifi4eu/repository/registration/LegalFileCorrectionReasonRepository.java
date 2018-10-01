package wifi4eu.wifi4eu.repository.registration;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.entity.registration.LegalFileCorrectionReason;

import java.util.List;

public interface LegalFileCorrectionReasonRepository extends CrudRepository<LegalFileCorrectionReason, Integer> {
    List<LegalFileCorrectionReason> findByRegistrationIdOrderByTypeAsc(Integer registrationId);

    @Query(value = "SELECT * FROM legal_files_correction_reason cr JOIN legal_files lf ON cr.id_legal_file = lf.id WHERE cr.type = ?#{[0]} AND cr.registration = ?#{[1]} AND lf.id_user = ?#{[2]}", nativeQuery = true)
    List<LegalFileCorrectionReason> getByRegistrationIdAndTypeAndUserId(Integer registrationId, int type, int userId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE legal_files_correction_reason SET request_correction = ?1 WHERE registration = ?2", nativeQuery = true)
    void updateLegalFileCorrectionStatusByRegistrationId(int status, int registrationId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM legal_files_correction_reason WHERE registration = ?1", nativeQuery = true)
    void deleteLegalFileCorrectionByRegistrationId(int registrationId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE legal_files_correction_reason SET request_correction = 0, correction_reason = NULL WHERE registration =  ?#{[0]} AND type =  ?#{[1]}", nativeQuery = true)
    void clearCorrectionReason(int registrationId, int type);

    @Query(value = "SELECT COUNT(*) FROM legal_files_correction_reason WHERE request_correction IS NOT NULL AND request_correction = 1 AND correction_reason IS NOT NULL AND request_correction_date IS NOT NULL AND request_correction_date > ?#{[0]}", nativeQuery = true)
    int countLegalFileCorrectionsAfterDate(Long dateInMilis);

    @Query(value = "SELECT * FROM legal_files_correction_reason WHERE request_correction IS NOT NULL AND request_correction = 1 AND correction_reason IS NOT NULL AND request_correction_date IS NOT NULL AND request_correction_date > ?#{[0]} AND registration = ?#{[1]}", nativeQuery = true)
    List<LegalFileCorrectionReason> findLegalFileCorrectionsAfterDateByRegistrationId(Long dateInMilis, int registrationId);

    @Query(value = "SELECT lfcr.type FROM legal_files_correction_reason lfcr"
            + " JOIN legal_files lf ON lfcr.registration = lf.registration AND lfcr.type = lf.type"
            + " LEFT JOIN log_emails le  ON le.action = ?#{[1]}"
            + " WHERE lfcr.request_correction IS NOT NULL AND lfcr.request_correction = 1 AND lfcr.correction_reason"
            + " IS NOT NULL AND lfcr.request_correction_date IS NOT NULL AND lfcr.registration = ?#{[0]}"
            + " GROUP BY lfcr.type"
            + " HAVING MAX(lf.upload_time) < max(le.sent_date)"
            + " AND max(lfcr.request_correction_date) < max(COALESCE(le.sent_date,0))"
            + " AND max(lfcr.request_correction_date) > max(lf.upload_time)", nativeQuery = true)
    List<Integer> findTypeFilesWaitingUploadByRegistration(int registrationId, String emailAction);
}
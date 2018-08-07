package wifi4eu.wifi4eu.repository.registration;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.entity.registration.LegalFileCorrectionReason;

import java.util.Date;
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

    @Query(value = "SELECT COUNT(0) FROM legal_files_correction_reason WHERE request_correction IS NOT NULL AND request_correction = 1 AND correction_reason IS NOT NULL AND request_correction_date IS NOT NULL AND request_correction_date > ?#{[0]}", nativeQuery = true)
    int countLegalFileCorrectionsAfterDate(Date date);
}
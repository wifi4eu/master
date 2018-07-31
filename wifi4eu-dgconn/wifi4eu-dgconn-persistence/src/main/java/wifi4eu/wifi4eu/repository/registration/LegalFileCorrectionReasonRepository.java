package wifi4eu.wifi4eu.repository.registration;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.entity.registration.LegalFileCorrectionReason;

import java.util.List;

public interface LegalFileCorrectionReasonRepository extends CrudRepository<LegalFileCorrectionReason, Integer> {
    List<LegalFileCorrectionReason> findByRegistrationIdOrderByTypeAsc(Integer registrationId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE legal_files_correction_reason SET request_correction = ?1 WHERE registration = ?2", nativeQuery = true)
    void updateLegalFileCorrectionStatusByRegistrationId(int status, int registrationId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM legal_files_correction_reason WHERE registration = ?1", nativeQuery = true)
    void deleteLegalFileCorrectionByRegistrationId(int registrationId);
}
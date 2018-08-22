package wifi4eu.wifi4eu.repository.registration;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.registration.LegalFileCorrectionReason;

import java.util.List;

public interface LegalFileCorrectionReasonRepository extends CrudRepository<LegalFileCorrectionReason, Integer> {
    List<LegalFileCorrectionReason> findByRegistrationIdOrderByTypeAsc(Integer registrationId);
    List<LegalFileCorrectionReason> findByRegistrationAndType(Integer registrationId, Integer type);

    //independent of user
    @Query(value = "select * from legal_files_correction_reason where id_legal_file in (select l.id from legal_files l where registration = ?1 and upload_time =(select max(upload_time) from legal_files l2 where l2.registration = ?1 and l.type = l2.type  group by type) and (type =1 or type = 3)) and request_correction = 1", nativeQuery = true)
    List<LegalFileCorrectionReason> findLastRequiredLegalFilesCorrectionByRegistration(Integer registrationId);

    //get last per registration, user and type
    @Query(value = "select * from legal_files_correction_reason where id_legal_file = (select l.id from legal_files l where registration = ?1 and upload_time =(select max(upload_time) from legal_files l2 where l2.registration = ?1 and id_user= ?2 and l.type = l2.type and type = ?3 group by type)) and request_correction = 1", nativeQuery = true)
    LegalFileCorrectionReason findLastCorrectionByRegistrationAndUserAndType(Integer registrationId, Integer userId, Integer type);

    //get ALL per registration, user and type
    @Query(value = "select * from legal_files_correction_reason where registration = ?#{[0]} and type = ?#{[1]}", nativeQuery = true)
    List<LegalFileCorrectionReason> findAllCorrectionByRegistrationAndUserAndType(Integer registrationId, Integer type);

    //get last per registration and user
    @Query(value = "select * from legal_files_correction_reason where id_legal_file in (select l.id from legal_files l where registration = ?1 and upload_time =(select max(upload_time) from legal_files l2 where l2.registration = ?1 and id_user= ?2 and l.type = l2.type group by type)) and request_correction = 1", nativeQuery = true)
    List<LegalFileCorrectionReason> findLastLegalFilesByRegistrationAndUserCorrection(Integer registrationId, Integer userId);
}
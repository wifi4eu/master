package wifi4eu.wifi4eu.repository.registration;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.registration.LegalFileCorrectionReason;

import java.util.List;

public interface LegalFileCorrectionReasonRepository extends CrudRepository<LegalFileCorrectionReason, Integer> {
    List<LegalFileCorrectionReason> findByRegistrationIdOrderByTypeAsc(Integer registrationId);
}
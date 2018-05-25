package wifi4eu.wifi4eu.repository.registration;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.registration.LegalFile;

import java.util.List;

public interface LegalFileRepository extends CrudRepository<LegalFile, Integer> {
    List<LegalFile> findByRegistrationIdOrderByTypeAsc(Integer registrationId);
    LegalFile findByRegistrationIdAndType(Integer registrationId, Integer type);
}
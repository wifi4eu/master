package wifi4eu.wifi4eu.repository.registration.legal_files;

import org.springframework.data.repository.*;
import wifi4eu.wifi4eu.entity.registration.*;

public interface LegalFilesRepository extends CrudRepository<Registration, Integer> {
	RegistrationFiles findByRegistrationIdAndFileIndex(Integer registrationId, Integer fileIndex);
}

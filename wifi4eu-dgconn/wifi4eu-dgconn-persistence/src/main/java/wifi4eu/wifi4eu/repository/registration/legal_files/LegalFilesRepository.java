package wifi4eu.wifi4eu.repository.registration.legal_files;

import org.springframework.data.repository.*;
import wifi4eu.wifi4eu.entity.registration.*;

import java.util.List;

public interface LegalFilesRepository extends CrudRepository<LegalFiles, Integer> {
	LegalFiles findByRegistrationAndFileType(Integer registrationId, Integer fileType);
	void deleteByRegistration(Integer registrationId);
	void deleteByRegistrationAndFileType(Integer registrationId, Integer fileType);
	List<LegalFiles> findAllByRegistration(Integer registrationId);
}

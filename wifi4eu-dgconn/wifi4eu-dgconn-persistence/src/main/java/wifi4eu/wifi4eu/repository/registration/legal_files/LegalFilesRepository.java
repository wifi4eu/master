package wifi4eu.wifi4eu.repository.registration.legal_files;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import wifi4eu.wifi4eu.entity.registration.*;

public interface LegalFilesRepository extends CrudRepository<LegalFiles, Integer> {
	LegalFiles findByRegistrationAndFileType(Integer registrationId, Integer fileType);
	void deleteByRegistration(Integer registrationId);
	void deleteByRegistrationAndFileType(Integer registrationId, Integer fileType);

	@Query(value = "SELECT registration, type, upload_time from legal_files where registration = ?1 order by type asc", nativeQuery = true)
	Iterable<Object> findUploadedTimeByRegistrationId(Integer registrationId);


}

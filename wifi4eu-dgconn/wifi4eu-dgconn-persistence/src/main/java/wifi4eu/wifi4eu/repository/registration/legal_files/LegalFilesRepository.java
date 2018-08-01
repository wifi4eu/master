package wifi4eu.wifi4eu.repository.registration.legal_files;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import wifi4eu.wifi4eu.entity.registration.*;

import java.util.List;

public interface LegalFilesRepository extends CrudRepository<LegalFile, Integer> {
	LegalFile findByRegistrationAndFileType(Integer registrationId, Integer fileType);
	void deleteByRegistration(Integer registrationId);
	void deleteByRegistrationAndFileType(Integer registrationId, Integer fileType);
 	 List<LegalFile> findAllByRegistration(Integer registrationId);

	@Query(value = "select id, registration, type, upload_time, id_user, file_size, file_mime, file_name from legal_files where registration = ?1 order by type, upload_time desc", nativeQuery = true)
	List<LegalFile> findHistoryAll(Integer registrationId);

}

package wifi4eu.wifi4eu.repository.registration.legal_files;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import wifi4eu.wifi4eu.entity.registration.*;

import java.util.List;

public interface LegalFilesRepository extends CrudRepository<LegalFile, Integer> {
	List<LegalFile> findAllByRegistration(Integer registrationId);
	List<LegalFile> findByRegistration(Integer registrationId);
	LegalFile findByRegistrationAndFileType(Integer registrationId, Integer fileType);
	void deleteByRegistration(Integer registrationId);
	void deleteByRegistrationAndFileType(Integer registrationId, Integer fileType);
	LegalFile findByIdAndUserId(Integer registrationId, Integer userId);

	@Query(value = "select id, registration, type, upload_time, id_user, file_size, file_mime, file_name from legal_files where registration = ?1 order by type, upload_time desc", nativeQuery = true)
	List<LegalFile> findHistoryAll(Integer registrationId);

    //independent of user (type 1 and 3)
    @Query(value = "select l.* from legal_files l where registration = ?1 " +
            "and upload_time =(select max(upload_time) from legal_files l2 " +
            "where l2.registration = ?1 and l.type = l2.type  group by type) " +
            "and (type =1 or type = 3) order by type desc", nativeQuery = true)
    List<LegalFile> findLastRequiredLegalFilesByRegistration(Integer registrationId);

    //doesnt return all files uploaded for mayor documents !!!!!
    @Query(value = "select id, registration, type, upload_time, id_user, " +
            "file_size, file_mime, file_name " +
            "from legal_files where registration = ?1 " +
            "and type = ?3 and id_user = ?2 order by type, upload_time desc", nativeQuery = true)
    List<LegalFile> findHistoryForType(Integer registrationId, Integer userId, Integer type);

    @Query(value = "select id, registration, type, upload_time, id_user, " +
            "file_size, file_mime, file_name " +
            "from legal_files where registration = ?1 " +
            "and type = ?2 order by type, upload_time desc", nativeQuery = true)
    List<LegalFile> findHistoryRequiredType(Integer registrationId, Integer type);

    @Query(value = "select id, registration, type, upload_time, id_user, " +
            "file_size, file_mime, file_name from legal_files where registration = ?1 " +
            "and (type=1 or type = 3 or id_user = ?2 ) order by type, upload_time desc", nativeQuery = true)
    List<LegalFile> findHistoryAll(Integer registrationId, Integer userId);

/*	@Query(nativeQuery = true, value = "select * from legal_files where registration in (select top 30 r.id from registrations r \n" +
			"inner join municipalities m on r.municipality = m.id \n" +
			"inner join laus l on m.lau = l.id\n" +
			"inner join applications a on r.id = a.registration\n" +
			"where l.country_code = ?#{[0]} and r.legal_file1_mime = ?#{[1]} " +
			"and r.legal_file2_mime = ?#{[1]} and r.legal_file3_mime = ?#{[1]} " +
			"and r.legal_file4_mime = ?#{[1]})")
	List<LegalFile> getAllFilesForCountryTop30Registrations(String countryCode, String fileType);

	@Query(nativeQuery = true, value = "select * from legal_files where registration in (select top 30 r.id from registrations r \n" +
			"inner join municipalities m on r.municipality = m.id \n" +
			"inner join laus l on m.lau = l.id\n" +
			"inner join applications a on r.id = a.registration\n" +
			"where l.country_code = ?#{[0]} and r.legal_file1_mime = ?#{[1]})")
	List<LegalFile> getAllFilesForCountryTop30RegistrationsF1F3(String countryCode, String fileType);*/

}

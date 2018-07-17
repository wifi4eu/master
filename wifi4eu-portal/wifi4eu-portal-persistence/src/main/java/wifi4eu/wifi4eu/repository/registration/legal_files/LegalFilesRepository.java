package wifi4eu.wifi4eu.repository.registration.legal_files;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import wifi4eu.wifi4eu.entity.registration.*;

import java.util.List;

public interface LegalFilesRepository extends CrudRepository<LegalFiles, Integer> {
	LegalFiles findByRegistrationAndFileType(Integer registrationId, Integer fileType);
	void deleteByRegistration(Integer registrationId);
	void deleteByRegistrationAndFileType(Integer registrationId, Integer fileType);

/*	@Query(nativeQuery = true, value = "select * from legal_files where registration in (select top 30 r.id from registrations r \n" +
			"inner join municipalities m on r.municipality = m.id \n" +
			"inner join laus l on m.lau = l.id\n" +
			"inner join applications a on r.id = a.registration\n" +
			"where l.country_code = ?#{[0]} and r.legal_file1_mime = ?#{[1]} " +
			"and r.legal_file2_mime = ?#{[1]} and r.legal_file3_mime = ?#{[1]} " +
			"and r.legal_file4_mime = ?#{[1]})")
	List<LegalFiles> getAllFilesForCountryTop30Registrations(String countryCode, String fileType);

	@Query(nativeQuery = true, value = "select * from legal_files where registration in (select top 30 r.id from registrations r \n" +
			"inner join municipalities m on r.municipality = m.id \n" +
			"inner join laus l on m.lau = l.id\n" +
			"inner join applications a on r.id = a.registration\n" +
			"where l.country_code = ?#{[0]} and r.legal_file1_mime = ?#{[1]})")
	List<LegalFiles> getAllFilesForCountryTop30RegistrationsF1F3(String countryCode, String fileType);*/
}

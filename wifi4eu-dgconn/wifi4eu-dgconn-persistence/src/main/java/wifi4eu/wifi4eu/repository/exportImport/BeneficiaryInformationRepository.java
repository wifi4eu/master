package wifi4eu.wifi4eu.repository.exportImport;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.exportImport.BeneficiaryInformation;

import java.util.List;

public interface BeneficiaryInformationRepository extends CrudRepository<BeneficiaryInformation, Integer> {

	@Query(value = "select r.id as id, "
			+ "m.id as mun_id, "
			+ "m.name as mun_name, "
			+ "concat(m.address, ', ', m.address_num) as mun_address, "
			+ "m.postal_code as mun_postalCode, "
			+ "l.name2 as mun_city, "
			+ "l.country_code as mun_countryCodeISO, "
			+ "r.id as mun_registrationNumber, "

			// TODO: missing data mun_languageCodeISO.
			/*+ "m.mun_languageCodeISO as mun_languageCodeISO, "*/

			// This looks like an incorrect place to take these data from.
			/*+ "ga.id as doc_portalId, "
			+ "ga.document_language as mun_languageCodeISO, "
			+ "ga.date_signature as doc_date, "
			+ "ga.document_location as doc_location, "
			+ "'GRANT AGREEMENT' as doc_type, "*/

			+ "lf.id as doc_portalId, "
			+ "lf.file_name as doc_fileName, "
			+ "lf.file_mime as doc_mimeType, "
			+ "lf.upload_time as doc_date, "
			+ "lf.type as doc_type, "
			+ "lf.azure_uri as azureUri, "

			// TODO: missing data: ares_reference.
				/*+ "lf.ares_reference as ares_reference, "*/

			+ "ma.abacReference as mun_abacReference, "
			+ "ma.abacStandarName as mun_abacName, "
			+ "va.call as mun_callNumber "

			+ "from applications as a "
			+ "left join registrations as r on a.registration = r.id "
			+ "left join municipalities as m on r.municipality = m.id "
			+ "left join municipalities_abac as ma on ma.municipality = m.id "
			+ "left join laus as l on m.lau = l.id "

//			+ "left join GRANT_AGREEMENT as ga on ga.application_id = a.id "
			+ "left join legal_files as lf on lf.registration = r.id "

			+ "inner join voucher_simulations as vs on vs.municipality = m.id "
			+ "inner join voucher_assignments as va on va.id = vs.voucher_assignment "
			+ "where m.name is not null and va.status = 3", nativeQuery = true)
	List<BeneficiaryInformation> getBeneficiariesInformationSignedAndNotCounterSigned();

}

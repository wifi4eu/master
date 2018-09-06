package wifi4eu.wifi4eu.repository.exportImport;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.exportImport.BeneficiaryInformation;

import java.util.List;

public interface BeneficiaryInformationRepository extends CrudRepository<BeneficiaryInformation, Integer> {

	@Query(value = "select r.id as id, m.id as mun_id, m.name as mun_name, concat(m.address, ', ', m.address_num) as mun_address, "
			+ "m.postal_code as mun_postalCode, l.name2 as mun_city, l.country_code as mun_countryCodeISO, "
			+ "ga.document_language as mun_languageCodeISO, r.id as mun_registrationNumber, ga.id as doc_portalId, "
			+ "ga.date_signature as doc_date, ga.document_location as doc_location, 'GRANT AGREEMENT' as doc_type "
			+ "from applications as a left join registrations as r on a.registration = r.id "
			+ "left join municipalities as m on r.municipality = m.id "
			+ "left join laus as l on m.lau = l.id "
			+ "left join GRANT_AGREEMENT as ga on ga.application_id = a.id "
			+ "where m.name is not null "
			+ "and ga.date_signature is not null "
			+ "and ga.date_counter_signature is null", nativeQuery = true)
	List<BeneficiaryInformation> getBeneficiariesInformationSignedAndNotCounterSigned();
}

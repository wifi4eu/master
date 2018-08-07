package wifi4eu.wifi4eu.repository.exportImport;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import wifi4eu.wifi4eu.entity.exportImport.BeneficiaryInformation;
import wifi4eu.wifi4eu.entity.exportImport.ExportImportBeneficiaryInformation;

public interface ExportImportBeneficiaryInformationRepository
		extends CrudRepository<ExportImportBeneficiaryInformation, Integer> {
	@Query(value = "select \n" + "r.id as id, \n" + "m.name as mun_OfficialName, \n"
			+ "m.address as mun_OfficialAddress, \n" + "o.name as org_Name, \n" + "o.type as org_TypeCode, \n"
			+ "s.name as sup_Name, \n" + "s.account_number as sup_BankAccount, \n" + "r.id as reg_RegistartionNumber \n"
			+ "from \n" + "registrations as r \n" + "left join \n" + "municipalities as m on r.municipality = m.id\n"
			+ "left join\n" + "organizations as o on r.organisation_id = o.id\n" + "left join\n"
			+ "users as u on r._user = u.id\n" + "left join\n" + "applications as a on r.id=a.registration\n"
			+ "left join\n" + "suppliers s on a.supplier=s.id\n"
			+ "where u.type is not null and m.name is not null", nativeQuery = true)
	Iterable<ExportImportBeneficiaryInformation> findExportImportBI();
	
}

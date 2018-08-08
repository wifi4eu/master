package wifi4eu.wifi4eu.abac.data.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.dto.IMonitoringRowProjection;
import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;
import wifi4eu.wifi4eu.abac.data.entity.Country;

public interface LegalEntityRepository extends CrudRepository<LegalEntity, Integer> {

	LegalEntity findByMid(Long mid);

	LegalEntity findByOfficialName(String officialName);

	@Query(value = "FROM LegalEntity le WHERE le.abacFelId is not null order by le.officialName asc")
	List<LegalEntity> findLegalEntitiesProcessedInAbac();

	List<LegalEntity> findByWfStatusOrderByDateCreated(AbacWorkflowStatus status, Pageable pageable);

	@Procedure(name = "CREATE_LEF_IN_ABAC")
	void createFinancialLegalEntity(@Param("LEGALENTITYID") Long legalEntityID);

	@Procedure(name = "UPDATE_LEF_STATUS_FROM_ABAC")
	//void updateFinancialLegalEntitiesStatuses(@Param("ROWS_AFFECTED") Long rowsAffected);
	void updateFinancialLegalEntitiesStatuses();

	@Query(
		value=
			"SELECT " +
			"le.id, le.country_code AS countryCode, le.official_name AS municipality, le.registration_number AS registrationNumber, " +
			"le.signature_date AS signatureDate, le.wf_status AS lefStatus, bc.wf_status AS bcStatus, lc.wf_status AS lcStatus " +
			"FROM WIF_LEGAL_ENTITY le " +
			"LEFT JOIN wif_budgetary_commitment bc ON (le.id = bc.id_le) " +
			"LEFT JOIN wif_legal_commitment lc ON (le.id = lc.id_le)",
		nativeQuery = true
	)
	List<IMonitoringRowProjection> findMonitoringData();
	
	@Query(value = "SELECT c FROM Country c WHERE c.euMember = 'Y' ORDER BY c.name")
	List<Country> findCountries();
}

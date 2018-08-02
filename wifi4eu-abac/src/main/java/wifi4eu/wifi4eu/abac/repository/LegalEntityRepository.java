package wifi4eu.wifi4eu.abac.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import wifi4eu.wifi4eu.abac.entity.Country;
import wifi4eu.wifi4eu.abac.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.entity.MonitoringRow;
import wifi4eu.wifi4eu.abac.service.AbacWorkflowStatusEnum;

public interface LegalEntityRepository extends CrudRepository<LegalEntity, Integer> {

	LegalEntity findByMid(Integer mid);

	LegalEntity findByOfficialName(String officialName);

	@Query(value = "SELECT le FROM LegalEntity le WHERE le.abacFelId is not null")
	List<LegalEntity> findLegalEntitiesProcessedInAbac();

	List<LegalEntity> findByWfStatusOrderByDateCreated(AbacWorkflowStatusEnum status, Pageable pageable);

	@Procedure(name = "CREATE_LEF_IN_ABAC")
	void createFinancialLegalEntity(@Param("LEGALENTITYID") Long legalEntityID);

	@Procedure(name = "UPDATE_LEF_STATUS_FROM_ABAC")
	//void updateFinancialLegalEntitiesStatuses(@Param("ROWS_AFFECTED") Long rowsAffected);
	void updateFinancialLegalEntitiesStatuses();

	@Query(
		value =
			"SELECT new wifi4eu.wifi4eu.abac.entity.MonitoringRow(" +
					"le.id, le.countryCode, le.officialName, le.registrationNumber, le.wfStatus, le.signatureDate" +
			") FROM LegalEntity le"
	)
	List<MonitoringRow> findMonitoringData();
	
	@Query(value = "SELECT c FROM Country c ORDER BY c.name")
	List<Country> findCountries();
}

package wifi4eu.wifi4eu.abac.data.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.dto.MonitoringRow;
import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;
import wifi4eu.wifi4eu.abac.data.enums.DocumentType;

public interface LegalEntityRepository extends CrudRepository<LegalEntity, Integer> {

	LegalEntity findByMid(Long mid);

	LegalEntity findByOfficialName(String officialName);

	@Query(value = "FROM LegalEntity le WHERE le.wfStatus in ('ABAC_VALID', 'ABAC_ERROR' ,'ABAC_REJECTED') order by le.officialName asc")
	List<LegalEntity> findLegalEntitiesProcessedInAbac();

	List<LegalEntity> findByWfStatusOrderByDateCreated(AbacWorkflowStatus status, Pageable pageable);

	@Procedure(name = "CREATE_LEF_IN_ABAC")
	void createFinancialLegalEntity(@Param("LEGALENTITYID") Long legalEntityID);

	@Procedure(name = "UPDATE_LEF_STATUS_FROM_ABAC")
	void updateFinancialLegalEntitiesStatuses();
	
	@Query(value =
			"SELECT new wifi4eu.wifi4eu.abac.data.dto.MonitoringRow(le, bc, lc, doc) " +
			"FROM LegalEntity le " +
			"LEFT JOIN BudgetaryCommitment bc on bc.legalEntity.id = le.id " +
			"LEFT JOIN LegalCommitment lc on lc.legalEntity.id = le.id " +
			"LEFT JOIN Document doc on le.id = doc.legalEntity.id and doc.type = 'GRANT_AGREEMENT'"
	)
	List<MonitoringRow> findMonitoringData();
	
	@Query("select bc.legalEntity from BudgetaryCommitment bc where bc.wfStatus = 'READY_FOR_ABAC'")
	List<LegalEntity> findAvailableLegalEntitiesForBudgetaryCommitmentCreation();

	Long countAllByWfStatusNotInAndBatchRefEquals(List<AbacWorkflowStatus> wfStatuses, String batchRef);

	List<LegalEntity> findAllByWfStatusEquals(AbacWorkflowStatus wfStatus);

    List<LegalEntity> findAllByWfStatusIn(List<AbacWorkflowStatus> wfStatuses);
}

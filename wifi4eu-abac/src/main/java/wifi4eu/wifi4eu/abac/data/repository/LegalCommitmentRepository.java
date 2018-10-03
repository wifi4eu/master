package wifi4eu.wifi4eu.abac.data.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import wifi4eu.wifi4eu.abac.data.entity.BudgetaryCommitment;
import wifi4eu.wifi4eu.abac.data.entity.LegalCommitment;
import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;
import wifi4eu.wifi4eu.abac.data.enums.LegalCommitmentWorkflowStatus;

public interface LegalCommitmentRepository extends CrudRepository<LegalCommitment, Integer> {

	@Query(value = "SELECT lc FROM LegalCommitment lc WHERE lc.wfStatus in ('ABAC_VALID', 'ABAC_ERROR')")
	List<LegalCommitment> findLCFinishedInAbac();
	
	LegalCommitment findByLegalEntityMid(Long municipalityPortalId);

	List<LegalCommitment> findByWfStatus(LegalCommitmentWorkflowStatus readyForAbac);
	List<LegalCommitment> findByWfStatus(LegalCommitmentWorkflowStatus readyForAbac, Pageable pageable);

	@Procedure(name = "CREATE_LC_IN_ABAC")
	void createLegalCommitmentInABAC(@Param("LEGAL_COMMITMENT_ID") Long legalCommitmentId);

	@Procedure(name = "UPDATE_LC_STATUS_FROM_ABAC")
	void updateLegalCommitmentStatuses();

	LegalCommitment findByLegalEntityIdAndWfStatus(Long legalEntityId, LegalCommitmentWorkflowStatus legalCommitmentStatus);

	Long countAllByWfStatusNotInAndBatchRefEquals(List<LegalCommitmentWorkflowStatus> wfStatuses, String batchRef);

	List<LegalCommitment> findAllByBatchRefEquals(String batchRef);

	@Query("select lc from LegalCommitment lc where lc.wfStatus = 'COUNTERSIGNED' and lc.legalEntity.budgetaryCommitment.wfStatus = 'ABAC_VALID'")
	List<LegalCommitment> findLegalCommitmentsAvailableForCreation(Pageable pageable);

	@Query(value = "FROM LegalCommitment lc WHERE lc.wfStatus in ('ABAC_VALID', 'ABAC_ERROR' ,'ABAC_REJECTED') order by lc.dateExported desc, lc.batchRef desc, lc.legalEntity.mid asc")
	List<LegalCommitment> findLegalCommitmentsProcessedInAbac();
}

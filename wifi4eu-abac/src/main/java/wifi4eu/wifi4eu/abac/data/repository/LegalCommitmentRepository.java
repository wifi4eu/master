package wifi4eu.wifi4eu.abac.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import wifi4eu.wifi4eu.abac.data.entity.BudgetaryCommitment;
import wifi4eu.wifi4eu.abac.data.entity.LegalCommitment;
import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;
import wifi4eu.wifi4eu.abac.data.enums.LegalCommitmentWorkflowStatus;

public interface LegalCommitmentRepository extends CrudRepository<LegalCommitment, Integer> {

	@Query(value = "SELECT lc FROM LegalCommitment lc WHERE lc.wfStatus in ('ABAC_FINISH', 'ABAC_ERROR')")
	List<LegalCommitment> findLCFinishedInAbac();
	
	LegalCommitment findByLegalEntityMid(Long municipalityPortalId);

	List<LegalCommitment> findByWfStatus(LegalCommitmentWorkflowStatus readyForAbac);

	@Procedure(name = "CREATE_LC_IN_ABAC")
	void createLegalCommitmentInABAC(@Param("LEGAL_COMMITMENT_ID") Long legalCommitmentId);

	@Procedure(name = "UPDATE_LC_STATUS_FROM_ABAC")
	void updateLegalCommitmentStatuses();
}

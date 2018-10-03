package wifi4eu.wifi4eu.abac.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import wifi4eu.wifi4eu.abac.data.entity.BudgetaryCommitment;
import wifi4eu.wifi4eu.abac.data.entity.BudgetaryCommitmentPosition;

import java.util.List;

public interface BudgetaryCommitmentPositionRepository extends CrudRepository<BudgetaryCommitmentPosition, Integer> {

	BudgetaryCommitmentPosition findByBudgetaryCommitmentLegalEntityMidAndCommitmentLevel2Position(Long municipalityPortalId, Integer abacCommitmentLevel2Position);


	@Query(value = "FROM BudgetaryCommitmentPosition bcp WHERE bcp.budgetaryCommitment.wfStatus in ('ABAC_VALID', 'ABAC_ERROR' ,'ABAC_REJECTED') order by bcp.budgetaryCommitment.dateExported desc")
	List<BudgetaryCommitmentPosition> findBudgetaryCommitmentsProcessedInABAC();
}

package wifi4eu.wifi4eu.abac.data.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import wifi4eu.wifi4eu.abac.data.entity.BudgetaryCommitment;
import wifi4eu.wifi4eu.abac.data.entity.BudgetaryCommitmentPosition;

public interface BudgetaryCommitmentPositionRepository extends CrudRepository<BudgetaryCommitmentPosition, Integer> {

	BudgetaryCommitmentPosition findByBudgetaryCommitmentLegalEntityMidAndCommitmentLevel2Position(Long municipalityPortalId, Integer abacCommitmentLevel2Position);
}

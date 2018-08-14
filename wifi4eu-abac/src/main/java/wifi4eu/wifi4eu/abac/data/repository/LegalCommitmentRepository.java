package wifi4eu.wifi4eu.abac.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import wifi4eu.wifi4eu.abac.data.entity.BudgetaryCommitment;
import wifi4eu.wifi4eu.abac.data.entity.LegalCommitment;

public interface LegalCommitmentRepository extends CrudRepository<LegalCommitment, Integer> {

	@Query(value = "SELECT lc FROM LegalCommitment lc WHERE lc.wfStatus in ('ABAC_FINISH', 'ABAC_ERROR')")
	List<LegalCommitment> findLCFinishedInAbac();
	
	LegalCommitment findByLegalEntityMid(Long municipalityPortalId);

}

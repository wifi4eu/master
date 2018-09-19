package wifi4eu.wifi4eu.repository.exportImport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wifi4eu.wifi4eu.entity.exportImport.BudgetaryCommitment;

public interface BudgetaryCommitmentRepository extends JpaRepository<BudgetaryCommitment, Integer> {

    @Query(value = "select sum(bc.ammount) from BudgetaryCommitment bc where bc.global_commitment = :globalCommitmentId")
    Integer totalSpentForGlobalCommitment(Integer globalCommitmentId);

    BudgetaryCommitment findByMunicipalityIdAndPositionAndAmmount(Integer municipalityId, Integer position, Integer ammount);
}

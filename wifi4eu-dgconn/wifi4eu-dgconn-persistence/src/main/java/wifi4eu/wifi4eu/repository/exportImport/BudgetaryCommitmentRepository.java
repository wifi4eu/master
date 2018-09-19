package wifi4eu.wifi4eu.repository.exportImport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wifi4eu.wifi4eu.entity.exportImport.BudgetaryCommitment;

public interface BudgetaryCommitmentRepository extends JpaRepository<BudgetaryCommitment, Integer> {

    @Query(value = "select coalesce(sum(bc.ammount),0) from BudgetaryCommitment bc where bc.globalCommitment.id = :globalCommitmentId")
    int totalSpentForGlobalCommitment(@Param("globalCommitmentId") Integer globalCommitmentId);

    BudgetaryCommitment findByMunicipalityIdAndPositionAndAmmount(Integer municipalityId, Integer position, Integer ammount);
}

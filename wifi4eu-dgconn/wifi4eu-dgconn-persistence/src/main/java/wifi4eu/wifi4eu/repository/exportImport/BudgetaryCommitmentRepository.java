package wifi4eu.wifi4eu.repository.exportImport;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.exportImport.BudgetaryCommitment;

public interface BudgetaryCommitmentRepository extends CrudRepository<BudgetaryCommitment, Integer> {

    @Query(value = "select sum(ammount) from BudgetaryCommitment where GlobalCommitment.id = :globalCommitmentId")
    Integer totalSpentForGlobalCommitment(Integer globalCommitmentId);
}

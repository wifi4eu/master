package wifi4eu.wifi4eu.abac.data.entity;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "BUDGETARY_COMMITMENT")
public class BudgetaryCommitmentAbacRequest extends AbacRequest {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BC_ID")
    private BudgetaryCommitment budgetaryCommitment;

    public BudgetaryCommitment getBudgetaryCommitment() {
        return budgetaryCommitment;
    }

    public void setBudgetaryCommitment(BudgetaryCommitment budgetaryCommitment) {
        this.budgetaryCommitment = budgetaryCommitment;
    }
}

package wifi4eu.wifi4eu.entity.exportImport;

import wifi4eu.wifi4eu.entity.municipality.Municipality;

public final class BudgetaryCommitmentBuilder {
    private Integer id;
    private Municipality municipality;
    private GlobalCommitment globalCommitment;
    private Integer position;
    private Integer ammount;
    private String abacBcKey;
    private String abacLcKey;

    private BudgetaryCommitmentBuilder() {
    }

    public static BudgetaryCommitmentBuilder aBudgetaryCommitment() {
        return new BudgetaryCommitmentBuilder();
    }

    public BudgetaryCommitmentBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public BudgetaryCommitmentBuilder withMunicipality(Municipality municipality) {
        this.municipality = municipality;
        return this;
    }

    public BudgetaryCommitmentBuilder withGlobalCommitment(GlobalCommitment globalCommitment) {
        this.globalCommitment = globalCommitment;
        return this;
    }

    public BudgetaryCommitmentBuilder withPosition(Integer position) {
        this.position = position;
        return this;
    }

    public BudgetaryCommitmentBuilder withAmmount(Integer ammount) {
        this.ammount = ammount;
        return this;
    }

    public BudgetaryCommitmentBuilder withAbacBcKey(String abacBcKey) {
        this.abacBcKey = abacBcKey;
        return this;
    }

    public BudgetaryCommitmentBuilder withAbacLcKey(String abacLcKey) {
        this.abacLcKey = abacLcKey;
        return this;
    }

    public BudgetaryCommitment build() {
        BudgetaryCommitment budgetaryCommitment = new BudgetaryCommitment();
        budgetaryCommitment.setId(id);
        budgetaryCommitment.setMunicipality(municipality);
        budgetaryCommitment.setGlobalCommitment(globalCommitment);
        budgetaryCommitment.setPosition(position);
        budgetaryCommitment.setAmmount(ammount);
        budgetaryCommitment.setAbacBcKey(abacBcKey);
        budgetaryCommitment.setAbacLcKey(abacLcKey);
        return budgetaryCommitment;
    }
}

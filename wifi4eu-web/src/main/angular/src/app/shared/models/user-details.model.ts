import {EntityDetails} from "../../+entity/entity-details.model";
import {BeneficiaryDetails} from "../../+beneficiary/beneficiary-details.model";

export class UserDetails {
    entity: EntityDetails;
    beneficiary: BeneficiaryDetails;

    constructor() {
        this.entity = new EntityDetails();
        this.beneficiary = new BeneficiaryDetails();
    }
}
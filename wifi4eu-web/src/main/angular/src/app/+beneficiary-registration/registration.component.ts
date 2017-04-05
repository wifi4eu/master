import {Component, ViewChild} from "@angular/core";
import {BeneficiaryDTOBase} from "../shared/swagger/model/BeneficiaryDTO";
import {NutsDTOBase} from "../shared/swagger/model/NutsDTO";
import {LauDTOBase} from "../shared/swagger/model/LauDTO";
import {LegalEntityDTOBase} from "../shared/swagger/model/LegalEntityDTO";
import {MayorDTOBase} from "../shared/swagger/model/MayorDTO";
import {RepresentativeDTOBase} from "../shared/swagger/model/RepresentativeDTO";
import {EntityComponent} from "./+beneficiary-registration-step1/legal-entity.component";

@Component({templateUrl: 'registration.component.html'})
export class RegistrationComponent {
    @ViewChild(EntityComponent) legalEntityComponent: EntityComponent;

    private beneficiaryDTO: BeneficiaryDTOBase;
    private nutsDTO: NutsDTOBase;
    private lausDTO: LauDTOBase;

    private selection: boolean[];
    private completed: boolean[];
    private active: boolean[];
    private successRegistration: boolean;
    private failureRegistration: boolean;

    constructor() {
        this.beneficiaryDTO = new BeneficiaryDTOBase();
        this.beneficiaryDTO.legalEntityDTO = new LegalEntityDTOBase();
        this.beneficiaryDTO.mayorDTO = new MayorDTOBase();
        this.beneficiaryDTO.representativeDTO = new RepresentativeDTOBase();

        this.selection = [true, false];
        this.completed = [false, false, false];
        this.active = [true, false, false];
        this.successRegistration = false;
        this.failureRegistration = false;
    }

    onNext(step: number) {
        if (step == 1) {
            this.nutsDTO = this.legalEntityComponent.nutsDTO;
            this.lausDTO = this.legalEntityComponent.lausDTO;
            this.beneficiaryDTO.legalEntityDTO.countryCode = this.nutsDTO.countryCode;
            this.beneficiaryDTO.legalEntityDTO.municipalityCode = this.lausDTO.lau2;
        }
        this.completed[step - 1] = true;
        this.active[step - 1] = false;
        this.active[step] = true;
    }

    gotoStep(step: number) {
        switch (step) {
            case 1:
                this.completed = [false, false, false];
                this.active = [true, false, false];
                break;
            case 2:
                this.completed = [true, false, false];
                this.active = [false, true, false];
                break;
            case 3:
                this.completed = [true, true, false];
                this.active = [false, false, true];
                break;
        }
    }

    onBack(step: number) {
        this.completed[step - 1] = false;
        this.active[step - 1] = true;
        this.active[step] = false;
    }

    onSuccess(value: boolean) {
        this.successRegistration = value;
    }

    onFailure(value: boolean) {
        this.failureRegistration = value;
    }
}
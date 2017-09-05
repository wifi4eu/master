import {Component, ViewChild} from "@angular/core";
import {BeneficiaryDTOBase} from "../shared/swagger/model/BeneficiaryDTO";
import {NutsDTO, NutsDTOBase} from "../shared/swagger/model/NutsDTO";
import {LauDTOBase} from "../shared/swagger/model/LauDTO";
import {LegalEntityDTOBase} from "../shared/swagger/model/LegalEntityDTO";
import {MayorDTOBase} from "../shared/swagger/model/MayorDTO";
import {RepresentativeDTOBase} from "../shared/swagger/model/RepresentativeDTO";
import {BeneficiaryComponent} from "./+beneficiary-registration-step1/beneficiary.component";
import {EntityComponent} from "./+beneficiary-registration-step2/legal-entity.component";

@Component({templateUrl: 'registration.component.html'})
export class RegistrationComponent {
    @ViewChild(BeneficiaryComponent) beneficiaryEntity: BeneficiaryComponent;
    @ViewChild(EntityComponent) legalEntityComponent: EntityComponent;

    private beneficiaryDTO: BeneficiaryDTOBase;
    private nutsDTO: NutsDTOBase;
    private lausDTO: LauDTOBase;
    private allCountries: NutsDTO[];
    private allMunicipalities: NutsDTO[][];

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

        this.allCountries = [];
        this.allMunicipalities = [];
    }

    onNext(step: number) {
        // if (step == 2) {
        //     this.lausDTO = this.legalEntityComponent.lausDTO;
        //     this.beneficiaryDTO.legalEntityDTO.countryCode = this.nutsDTO.countryCode;
        //     this.beneficiaryDTO.legalEntityDTO.municipalityCode = this.lausDTO.lau2;
        //     this.allCountries = this.legalEntityComponent.allCountries;
        //     this.allMunicipalities = this.legalEntityComponent.allMunicipalities;
        // }
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

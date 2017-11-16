import {Component, EventEmitter, Input, Output} from "@angular/core";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";
import {OrganizationDTOBase} from "../../shared/swagger/model/OrganizationDTO";

@Component({
    selector: 'beneficiary-registration-step1', templateUrl: 'beneficiary-registration-step1.component.html'
})

export class BeneficiaryRegistrationStep1Component {
    @Input('country') private country: NutsDTOBase;
    @Output() private countryChange: EventEmitter<NutsDTOBase>;
    @Input('countries') private countries: NutsDTOBase[];
    @Input('multipleMunicipalities') private multipleMunicipalities: boolean;
    @Output() private multipleMunicipalitiesChange: EventEmitter<boolean>;
    @Input('organizations') private organizations: OrganizationDTOBase[];
    @Output() private onNext: EventEmitter<any>;
    private countrySelected: boolean = false;
    private singleMunicipalityCheckbox: boolean = false;
    private multipleMunicipalityCheckbox: boolean = false;

    constructor() {
        this.countryChange = new EventEmitter<NutsDTOBase>();
        this.multipleMunicipalitiesChange = new EventEmitter<boolean>();
        this.onNext = new EventEmitter<any>();
    }

    private selectCountry(event: any) {
        this.singleMunicipalityCheckbox = false;
        this.multipleMunicipalityCheckbox = false;
        this.countrySelected = true;
        this.countryChange.emit(this.country);
    }

    private chooseSingleMunicipality(checked: boolean) {
        this.singleMunicipalityCheckbox = false;
        this.multipleMunicipalityCheckbox = false;
        if (checked) {
            this.singleMunicipalityCheckbox = true;
        }
    }

    private chooseMultipleMunicipality(checked: boolean) {
        this.singleMunicipalityCheckbox = false;
        this.multipleMunicipalityCheckbox = false;
        if (checked) {
            this.multipleMunicipalityCheckbox = true;
        }
    }

    private submit() {
        if (this.singleMunicipalityCheckbox) {
            this.multipleMunicipalities = false;
        } else if (this.multipleMunicipalityCheckbox) {
            this.multipleMunicipalities = true;
        }
        this.countryChange.emit(this.country);
        this.multipleMunicipalitiesChange.emit(this.multipleMunicipalities);
        this.onNext.emit();
    }
}
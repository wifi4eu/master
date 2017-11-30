import {Component, EventEmitter, Input, Output} from "@angular/core";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";
import {OrganizationDTOBase} from "../../shared/swagger/model/OrganizationDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {MayorDTOBase} from "../../shared/swagger/model/MayorDTO";
import {LauDTOBase} from "../../shared/swagger/model/LauDTO";

@Component({
    selector: 'beneficiary-registration-step1', templateUrl: 'beneficiary-registration-step1.component.html'
})

export class BeneficiaryRegistrationStep1Component {
    @Input('country') private country: NutsDTOBase;
    @Output() private countryChange: EventEmitter<NutsDTOBase>;
    @Input('countries') private countries: NutsDTOBase[];
    @Input('mayors') private mayors: MayorDTOBase[];
    @Input('municipalities') private municipalities: MunicipalityDTOBase[];
    @Output() private mayorsChange: EventEmitter<MayorDTOBase[]>;
    @Output() private municipalitiesChange: EventEmitter<MunicipalityDTOBase[]>;
    @Input('multipleMunicipalities') private multipleMunicipalities: boolean;
    @Output() private multipleMunicipalitiesChange: EventEmitter<boolean>;
    @Input('organizations') private organizations: OrganizationDTOBase[];
    @Output() private onNext: EventEmitter<any>;
    @Input('laus') private laus: LauDTOBase[];
    @Output() private lausChange: EventEmitter<LauDTOBase[]>;
    @Input('initialUser') private initialUser: UserDTOBase;
    @Output() private initialUserChange: EventEmitter<UserDTOBase>;
    private countrySelected: boolean = false;
    private singleMunicipalityCheckbox: boolean = false;
    private multipleMunicipalityCheckbox: boolean = false;

    constructor() {
        this.countryChange = new EventEmitter<NutsDTOBase>();
        this.multipleMunicipalitiesChange = new EventEmitter<boolean>();
        this.municipalitiesChange = new EventEmitter<MunicipalityDTOBase[]>();
        this.mayorsChange = new EventEmitter<UserDTOBase[]>();
        this.lausChange = new EventEmitter<LauDTOBase[]>();
        this.initialUserChange = new EventEmitter<UserDTOBase>();
        this.onNext = new EventEmitter<any>();
    }

    private selectCountry(event: any) {
        this.municipalities = [{}];
        this.mayors = [{}];
        this.laus = [{}];
        this.initialUser = new UserDTOBase();

        this.municipalitiesChange.emit(this.municipalities);
        this.mayorsChange.emit(this.mayors);
        this.lausChange.emit(this.laus);
        this.initialUserChange.emit(this.initialUser);

        this.singleMunicipalityCheckbox = false;
        this.multipleMunicipalityCheckbox = false;
        if (this.country != null) {
            this.countrySelected = true;
            this.countryChange.emit(this.country);
        }
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
import {Component, EventEmitter, Input, Output, OnInit} from "@angular/core";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {LauDTOBase} from "../../shared/swagger/model/LauDTO";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";

@Component({
    selector: 'beneficiary-registration-step2', templateUrl: 'beneficiary-registration-step2.component.html'
})

export class BeneficiaryRegistrationStep2Component {
    // @Input('initialUser') private initialUser: UserDTOBase;
    // @Output() private initialUserChange: EventEmitter<UserDTOBase>;
    // @Input('representing') private representing: boolean;
    // @Output() private representingChange: EventEmitter<boolean>;
    // @Output() private onNext: EventEmitter<any>;
    // private mayorUser: UserDTOBase;
    // private representativeUser: UserDTOBase;
    // private mayorEmails: string[] = ['', ''];
    // private representativeEmails: string[] = ['', ''];
    //
    // private laus: NutsDTOBase[] = [];
    // private countriesSuggestions: NutsDTOBase[] = [];
    // private countrySelected: boolean = false;


    @Input('country') private country: NutsDTOBase;
    @Input('laus') private laus: LauDTOBase[][];
    @Input('multipleMunicipalities') private multipleMunicipalities: boolean;
    @Input('users') private users: UserDTOBase[];
    @Input('municipalities') private municipalities: MunicipalityDTOBase[];
    @Output() private usersChange: EventEmitter<UserDTOBase[]>;
    @Output() private municipalitiesChange: EventEmitter<MunicipalityDTOBase[]>;
    @Output() private onNext: EventEmitter<any>;
    @Output() private onBack: EventEmitter<any>;
    private municipalitiesSelected: boolean[] = [false];
    private lauSuggestions: LauDTOBase[] = [];
    private emailConfirmations: string[] = [''];
    //private municipality: MunicipalityDTOBase;

    constructor() {
        this.usersChange = new EventEmitter<UserDTOBase[]>();
        this.municipalitiesChange = new EventEmitter<MunicipalityDTOBase[]>();
        this.onNext = new EventEmitter<any>();
        this.onBack = new EventEmitter<any>();
    }

    private search(event: any, index: number) {
        if (this.country != null) {
            this.municipalitiesSelected[index] = false;
            this.lauSuggestions = [];
            for (let lau of this.laus[this.country.countryCode]) {
                if (lau.name1.toLowerCase().startsWith(event.query.toLowerCase())) {
                    this.lauSuggestions.push(lau);
                }
            }
        }
    }

    private selectMunicipality(selected: boolean, index: number) {
        this.municipalitiesSelected[index] = selected;
    }

    private findIfValidMunicipality(index: number) {
        if (this.country != null) {
            for (let lau of this.laus[this.country.countryCode]) {
                if (lau.name1.toLowerCase() === this.municipalities[index].toString().toLowerCase()) {
                    this.municipalities[index] = lau;
                    this.municipalitiesSelected[index] = true;
                }
            }
        }
    }

    private addMunicipality() {
        if (this.multipleMunicipalities) {
            this.municipalities.push(new MunicipalityDTOBase());
            this.users.push(new UserDTOBase());
            this.municipalitiesSelected.push(false);
        }
    }

    private removeMunicipality(index: number) {
        if (this.multipleMunicipalities) {
            this.municipalities.splice(index);
            this.users.splice(index);
        }
    }

    submit() {
        this.usersChange.emit(this.users);
        this.municipalitiesChange.emit(this.municipalities);
        this.onNext.emit();
    }

    back() {
        this.onBack.emit();
    }
}
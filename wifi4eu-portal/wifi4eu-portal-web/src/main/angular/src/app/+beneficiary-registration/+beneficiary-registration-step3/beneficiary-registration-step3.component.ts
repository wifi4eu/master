import {Component, EventEmitter, Input, Output, OnInit} from "@angular/core";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {MayorDTOBase} from "../../shared/swagger/model/MayorDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";


@Component({
    selector: 'beneficiary-registration-step3',
    templateUrl: 'beneficiary-registration-step3.component.html'
})

export class BeneficiaryRegistrationStep3Component {

    @Input('initialUser') private initialUser: UserDTOBase;
    @Input('multipleMunicipalities') private multipleMunicipalities: boolean;
    @Input('mayors') private mayors: MayorDTOBase[];
    @Input('municipalities') private municipalities: MunicipalityDTOBase[];
    private imMayor: boolean;
    private repeatEmail: string;
    private userEmailMatches: boolean;
    @Output() private onNext: EventEmitter<any>;
    @Output() private onBack: EventEmitter<any>;


    constructor() {
        this.onNext = new EventEmitter<any>();
        this.onBack = new EventEmitter<any>();
        this.imMayor = false;
        this.userEmailMatches = false;
    }

    private fillMayorData() {
        if (!this.imMayor) {
            this.imMayor = true;
            this.initialUser.name = this.mayors[0].name;
            this.initialUser.surname = this.mayors[0].surname;
            this.initialUser.address = this.municipalities[0].address;
            this.initialUser.addressNum = this.municipalities[0].addressNum;
            this.initialUser.postalCode = this.municipalities[0].postalCode;
            this.initialUser.email = this.mayors[0].email;
            this.userEmailMatches = true;
        } else {
            this.imMayor = false;
            this.initialUser.name = '';
            this.initialUser.surname = '';
            this.initialUser.address = '';
            this.initialUser.addressNum = '';
            this.initialUser.postalCode = '';
            this.initialUser.email = '';
            this.repeatEmail = '';
        }
    }

    private checkEmailsMatch() {
        this.userEmailMatches = false;
        if (this.initialUser.email === this.repeatEmail) {
            this.userEmailMatches = true;
        }
    }

    private back() {
        this.onBack.emit();
        this.repeatEmail = '';
    }

    private submit() {
        this.onNext.emit();
        this.repeatEmail = '';
    }

    private preventPaste(event: any) {
        return false;
    }
}
import {Component, EventEmitter, Input, Output} from "@angular/core";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {LauDTOBase} from "../../shared/swagger/model/LauDTO";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";

@Component({
    selector: 'beneficiary-registration-step2', templateUrl: 'beneficiary-registration-step2.component.html'
})

export class BeneficiaryRegistrationStep2Component {
    @Input('country') private country: NutsDTOBase;
    @Input('laus') private laus: LauDTOBase[][];
    @Input('multipleMunicipalities') private multipleMunicipalities: boolean;
    @Input('users') private users: UserDTOBase[];
    @Input('municipalities') private municipalities: MunicipalityDTOBase[];
    @Output() private usersChange: EventEmitter<UserDTOBase[]>;
    @Output() private municipalitiesChange: EventEmitter<MunicipalityDTOBase[]>;
    @Output() private onNext: EventEmitter<any>;
    @Output() private onBack: EventEmitter<any>;
    private selectedLaus: LauDTOBase[] = [new LauDTOBase()];
    private lauSuggestions: LauDTOBase[] = [];
    private municipalitiesSelected: boolean[] = [false];
    private addressFields: string[] = [''];
    private addressNumFields: string[] = [''];
    private postalCodeFields: string[] = [''];
    private emailConfirmations: string[] = [''];

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
                if (lau.name1.toLowerCase() === this.selectedLaus[index].toString().toLowerCase()) {
                    this.selectedLaus[index] = lau;
                    this.municipalitiesSelected[index] = true;
                }
            }
        }
    }

    private addMunicipality() {
        if (this.multipleMunicipalities) {
            this.municipalities.push(new MunicipalityDTOBase());
            this.selectedLaus.push(new LauDTOBase());
            this.users.push(new UserDTOBase());
            this.municipalitiesSelected.push(false);
            this.addressFields.push('');
            this.addressNumFields.push('');
            this.postalCodeFields.push('');
            this.emailConfirmations.push('');
        }
    }

    private removeMunicipality(index: number) {
        if (this.multipleMunicipalities && this.municipalities.length > 1) {
            this.municipalities.splice(index, 1);
            this.selectedLaus.splice(index, 1);
            this.users.splice(index, 1);
            this.municipalitiesSelected.splice(index, 1);
            this.addressFields.splice(index, 1);
            this.addressNumFields.splice(index, 1);
            this.postalCodeFields.splice(index, 1);
            this.emailConfirmations.splice(index, 1);
        }
    }

    private submit() {
        for (let i = 0; i < this.municipalities.length; i++) {
            this.municipalities[i].name = this.selectedLaus[i].name1;
            this.municipalities[i].country = this.country.label;
            this.municipalities[i].address = this.addressFields[i];
            this.municipalities[i].addressNum = this.addressNumFields[i];
            this.municipalities[i].postalCode = this.postalCodeFields[i];
            this.municipalities[i].lauId = this.selectedLaus[i].id;
        }
        this.usersChange.emit(this.users);
        this.municipalitiesChange.emit(this.municipalities);
        this.onNext.emit();
    }

    private back() {
        for (let i = 0; i < this.municipalities.length; i++) {
            this.municipalities[i].country = this.country.label;
            this.municipalities[i].address = this.addressFields[i];
            this.municipalities[i].addressNum = this.addressNumFields[i];
            this.municipalities[i].postalCode = this.postalCodeFields[i];
        }
        this.usersChange.emit(this.users);
        this.municipalitiesChange.emit(this.municipalities);
        this.onBack.emit();
    }
}
import {Component, EventEmitter, Input, Output} from "@angular/core";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {LauDTOBase} from "../../shared/swagger/model/LauDTO";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";
import {LauApi} from "../../shared/swagger/api/LauApi";
import {MayorDTOBase} from "../../shared/swagger/model/MayorDTO";

@Component({
    selector: 'beneficiary-registration-step2',
    templateUrl: 'beneficiary-registration-step2.component.html',
    providers: [LauApi]
})

export class BeneficiaryRegistrationStep2Component {
    @Input('country') private country: NutsDTOBase;
    @Input('multipleMunicipalities') private multipleMunicipalities: boolean;
    @Input('mayors') private mayors: MayorDTOBase[];
    @Input('municipalities') private municipalities: MunicipalityDTOBase[];
    @Output() private mayorsChange: EventEmitter<MayorDTOBase[]>;
    @Output() private municipalitiesChange: EventEmitter<MunicipalityDTOBase[]>;
    @Output() private findLaus: EventEmitter<string>;
    @Output() private onNext: EventEmitter<any>;
    @Output() private onBack: EventEmitter<any>;
    private selectedLaus: LauDTOBase[] = [];
    private lauSuggestions: LauDTOBase[] = [];
    private municipalitiesSelected: boolean = false;
    private addressFields: string[] = [''];
    private addressNumFields: string[] = [''];
    private postalCodeFields: string[] = [''];
    private emailConfirmations: string[] = [''];
    private readonly MAX_LENGTH = 2;
    private emailsMatch: boolean = false;
    private css_class: string = "";

    constructor(private lauApi: LauApi) {
        this.mayorsChange = new EventEmitter<UserDTOBase[]>();
        this.municipalitiesChange = new EventEmitter<MunicipalityDTOBase[]>();
        this.findLaus = new EventEmitter<string>();
        this.onNext = new EventEmitter<any>();
        this.onBack = new EventEmitter<any>();
    }

    private search(event: any, index: number) {
        let query = event.query;
        if (this.country != null && query.length >= this.MAX_LENGTH) {
            this.lauApi.getLausByCountryCodeAndName1StartingWithIgnoreCase(this.country.countryCode, query).subscribe(
                (laus: LauDTOBase[]) => {
                    this.lauSuggestions = laus;
                }
            );
        } else {
            this.lauSuggestions = [];
        }
    }


    private checkMunicipalitiesSelected() {
        for (let lau of this.selectedLaus) {
            if (!lau.id) {
                this.municipalitiesSelected = false;
                this.css_class = "notValid";
                return;
            }
        }
        this.municipalitiesSelected = true;
        this.css_class = "isValid";
    }

    private checkEmailsMatch() {
        this.emailsMatch = false;
        if (this.mayors[0].email === this.emailConfirmations[0]) {
            this.emailsMatch = true;
        }
    }

    private addMunicipality() {
        if (this.multipleMunicipalities) {
            this.municipalities.push(new MunicipalityDTOBase());
            this.selectedLaus.push();
            this.mayors.push(new UserDTOBase());
            this.addressFields.push('');
            this.addressNumFields.push('');
            this.postalCodeFields.push('');
            this.emailConfirmations.push('');
        }
        this.checkMunicipalitiesSelected();
    }

    private removeMunicipality(index: number) {
        if (this.multipleMunicipalities && this.municipalities.length > 1) {
            this.municipalities.splice(index, 1);
            this.selectedLaus.splice(index, 1);
            this.mayors.splice(index, 1);
            this.addressFields.splice(index, 1);
            this.addressNumFields.splice(index, 1);
            this.postalCodeFields.splice(index, 1);
            this.emailConfirmations.splice(index, 1);
        }
        this.checkMunicipalitiesSelected();
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
        this.mayorsChange.emit(this.mayors);
        this.municipalitiesChange.emit(this.municipalities);
        this.onNext.emit();
        this.emailConfirmations = [''];
    }

    private back() {
        for (let i = 0; i < this.municipalities.length; i++) {
            this.municipalities[i].country = this.country.label;
            this.municipalities[i].address = this.addressFields[i];
            this.municipalities[i].addressNum = this.addressNumFields[i];
            this.municipalities[i].postalCode = this.postalCodeFields[i];
        }
        this.mayorsChange.emit(this.mayors);
        this.municipalitiesChange.emit(this.municipalities);
        this.onBack.emit();
        this.emailConfirmations = [''];
    }

    private preventPaste(event: any) {
        return false;
    }
}
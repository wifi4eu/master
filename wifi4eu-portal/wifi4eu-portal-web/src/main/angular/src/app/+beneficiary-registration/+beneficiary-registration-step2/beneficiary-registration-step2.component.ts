import {Component, EventEmitter, Input, OnChanges, Output, SimpleChanges} from "@angular/core";
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

export class BeneficiaryRegistrationStep2Component implements OnChanges {
    @Input('country') private country: NutsDTOBase;
    @Input('multipleMunicipalities') private multipleMunicipalities: boolean;
    @Input('mayors') private mayors: MayorDTOBase[];
    @Input('municipalities') private municipalities: MunicipalityDTOBase[];
    @Input('laus') private laus: LauDTOBase[];
    @Output() private mayorsChange: EventEmitter<MayorDTOBase[]>;
    @Output() private municipalitiesChange: EventEmitter<MunicipalityDTOBase[]>;
    @Output() private findLaus: EventEmitter<string>;
    @Output() private onNext: EventEmitter<any>;
    @Output() private onBack: EventEmitter<any>;
    @Output() private lausChange: EventEmitter<LauDTOBase[]>;
    private lauSuggestions: LauDTOBase[] = [];
    private municipalitiesSelected: boolean = false;
    private addressFields: string[] = [''];
    private addressNumFields: string[] = [''];
    private postalCodeFields: string[] = [''];
    private emailConfirmations: string[] = [''];
    private readonly MAX_LENGTH = 2;
    private emailsMatch: boolean = false;
    private css_class_municipalities: string = "";
    private css_class_email: string[] = [];

    constructor(private lauApi: LauApi) {
        this.mayorsChange = new EventEmitter<UserDTOBase[]>();
        this.municipalitiesChange = new EventEmitter<MunicipalityDTOBase[]>();
        this.lausChange = new EventEmitter<LauDTOBase[]>();
        this.findLaus = new EventEmitter<string>();
        this.onNext = new EventEmitter<any>();
        this.onBack = new EventEmitter<any>();
    }

    ngOnChanges(changes: SimpleChanges): void {
        if (changes.hasOwnProperty("multipleMunicipalities")) {
            if (!this.multipleMunicipalities)
                this.removeMunicipality(1, this.municipalities.length - 1);
        }
    }

    private search(event: any) {
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
                this.css_class_municipalities = "notValid";
                return;
            }
        }
        this.municipalitiesSelected = true;
        this.css_class_municipalities = "isValid";
    }

    private checkEmailsMatch(counterMayor: number) {
        this.emailsMatch = false;
        if (this.mayors[counterMayor].email === this.emailConfirmations[counterMayor] && this.emailConfirmations[counterMayor].length > 0) {
            this.emailsMatch = true;
            this.css_class_email[counterMayor] = "isValid";
        } else {
            this.css_class_email[counterMayor] = "notValid";
        }
    }

    private addMunicipality() {
        if (this.multipleMunicipalities) {
            this.municipalities.push(new MunicipalityDTOBase());
            this.laus.push();
            this.mayors.push(new UserDTOBase());
            this.municipalitiesSelected.push(false);
            this.emailConfirmations.push('');
        }
        this.checkMunicipalitiesSelected();
    }

    private removeMunicipality(index: number) {
        if (this.multipleMunicipalities && this.municipalities.length > 1) {
            this.municipalities.splice(index, 1);
            this.laus.splice(index, 1);
            this.mayors.splice(index, 1);
            this.municipalitiesSelected.splice(index, 1);
            this.emailConfirmations.splice(index, 1);
        }
        this.checkMunicipalitiesSelected();
    }

    private submit() {
        for (let i = 0; i < this.municipalities.length; i++) {
            this.municipalities[i].name = this.laus[i].name1;
            this.municipalities[i].country = this.country.label;
            this.municipalities[i].lauId = this.laus[i].id;
        }
        this.mayorsChange.emit(this.mayors);
        this.municipalitiesChange.emit(this.municipalities);
        this.lausChange.emit(this.laus);
        this.onNext.emit();
        this.emailConfirmations = [''];
    }

    private back() {
        for (let i = 0; i < this.municipalities.length; i++) {
            this.municipalities[i].country = this.country.label;
        }
        this.mayorsChange.emit(this.mayors);
        this.municipalitiesChange.emit(this.municipalities);
        this.lausChange.emit(this.laus);
        this.onBack.emit();
        this.emailConfirmations = [''];
    }

    private preventPaste(event: any) {
        return false;
    }
}
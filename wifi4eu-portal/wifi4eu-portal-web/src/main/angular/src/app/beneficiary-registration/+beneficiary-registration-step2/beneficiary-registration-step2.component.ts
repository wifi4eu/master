import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from "@angular/core";
import { UserDTOBase } from "../../shared/swagger/model/UserDTO";
import { MunicipalityDTOBase } from "../../shared/swagger/model/MunicipalityDTO";
import { LauDTOBase } from "../../shared/swagger/model/LauDTO";
import { NutsDTOBase } from "../../shared/swagger/model/NutsDTO";
import { LauApi } from "../../shared/swagger/api/LauApi";
import { MayorDTOBase } from "../../shared/swagger/model/MayorDTO";
import { ViewChild } from "@angular/core";
import { NgForm } from "@angular/forms";
import { LocalStorageService } from "angular-2-local-storage/dist/local-storage.service";
import { Observable } from "rxjs/Observable";
import { SharedService } from "app/shared/shared.service";

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
    @Input('emailConfirmations') private emailConfirmations: string[] = [''];
    @Input('css_class_email') private css_class_email: string[] = ['notValid'];
    @Input('buttonEnabledStep2') private buttonEnabledStep2: boolean = false;

    @Output() private mayorsChange: EventEmitter<MayorDTOBase[]>;
    @Output() private municipalitiesChange: EventEmitter<MunicipalityDTOBase[]>;
    @Output() private findLaus: EventEmitter<string>;
    @Output() private onNext: EventEmitter<any>;
    @Output() private onBack: EventEmitter<any>;
    @Output() private lausChange: EventEmitter<LauDTOBase[]>;
    @Output() private emailConfirmationsChanged: EventEmitter<string[]>;
    private lauSuggestions: LauDTOBase[] = [];
    private readonly MAX_LENGTH = 2;
    private css_class_municipalities: string[] = ['notValid'];
    private emailPattern = new RegExp("(?:[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])*\")@(?:(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-zA-Z0-9-]*[a-zA-Z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\\])");
    private userEcas: UserDTOBase;
    private municipalityIsSelected: boolean[] = [false];

    constructor(private lauApi: LauApi, private localStorage: LocalStorageService, private sharedService: SharedService) {
        this.mayorsChange = new EventEmitter<UserDTOBase[]>();
        this.municipalitiesChange = new EventEmitter<MunicipalityDTOBase[]>();
        this.lausChange = new EventEmitter<LauDTOBase[]>();
        this.emailConfirmationsChanged = new EventEmitter();
        this.findLaus = new EventEmitter<string>();
        this.onNext = new EventEmitter<any>();
        this.onBack = new EventEmitter<any>();
    }

    ngOnChanges(changes: SimpleChanges): void {
        if (changes.hasOwnProperty('multipleMunicipalities')) {
            if (!this.multipleMunicipalities)
                this.removeMunicipality(1, this.municipalities.length - 1);
        }
    }

    private search(event: any) {
        let query = encodeURIComponent(event.query);
        if (this.country != null && query.length >= this.MAX_LENGTH) {
            this.lauApi.getLausByCountryCodeAndName1ContainingIgnoreCase(this.country.countryCode, query).subscribe(
                (laus: LauDTOBase[]) => {
                    this.lauSuggestions = laus;
                }
            );
        } else {
            this.lauSuggestions = [];
        }
    }

    clearMunicipality(index) {
        if (typeof this.laus[index] == "string") {
            this.laus[index] = null;
            this.css_class_municipalities[index] = 'notValid';
        }
    }

    private checButtonNextEnabled(){
        this.buttonEnabledStep2 = true;
        for (let i = 0; i < this.municipalities.length; i++) {
            if (this.isEmpty(this.municipalities[i].address) || this.isEmpty(this.municipalities[i].postalCode) || this.isEmpty(this.mayors[i].name) || this.isEmpty(this.mayors[i].surname)){
                this.buttonEnabledStep2 = false;
                break;
            }
        }
    }

    private checkMunicipalities(){
        if (this.laus.length != this.municipalities.length){
            this.buttonEnabledStep2 = false
        }else{
            for (let i = 0; i < this.laus.length; i++) {
                if (!this.laus[i] || !this.laus[i].id){
                     this.buttonEnabledStep2 = false
                    break;
                }
            }
        }    
    } 

    private checkMunicipalitySelector(event, i : number){
        if (event.type == "input"){
            this.css_class_municipalities[i] = 'notValid';
            this.municipalityIsSelected[i] = false;
        }else{
            this.css_class_municipalities[i] = 'isValid';
            this.municipalityIsSelected[i] = true;
        }

        this.checkButtonEnabled(event, i);
    }

    private checkEmailsMatch() {
        for (let i = 0; i < this.mayors.length; i++) {
            if (this.mayors[i] && this.emailConfirmations[i]) {
                if (this.mayors[i].email != this.emailConfirmations[i] || this.emailConfirmations[i].length < 1) {
                    this.buttonEnabledStep2 = false;
                    this.css_class_email[i] = 'notValid';
                } else if (this.emailPattern.test(this.emailConfirmations[i])) {
                    this.css_class_email[i] = 'isValid';
                }
                this.emailConfirmationsChanged.emit(this.css_class_email);
            }else{
                this.buttonEnabledStep2 = false;
            }
        }
    }



    private addMunicipality() {
        if (this.multipleMunicipalities) {
            this.municipalities.push(new MunicipalityDTOBase());
            this.municipalityIsSelected.push(false);
            //this.laus.push();
            this.mayors.push(new UserDTOBase());
            this.emailConfirmations.push('');
            this.css_class_email.push('notValid');
            this.css_class_municipalities.push('notValid');
            this.checkButtonEnabled(null);
        }
    }

    private removeMunicipality(index: number, deleteCount: number = 1) {
        this.municipalities.splice(index, deleteCount);
        this.municipalityIsSelected.splice(index, deleteCount);
        this.laus.splice(index, deleteCount);
        this.mayors.splice(index, deleteCount);
        this.emailConfirmations.splice(index, deleteCount);
        this.css_class_email.splice(index, deleteCount);
        this.css_class_municipalities.splice(index, deleteCount);
        this.checkButtonEnabled(null);

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
        this.emailConfirmationsChanged.emit(this.emailConfirmations);
        this.onNext.emit();
    }

    private back() {
        this.mayorsChange.emit(this.mayors);
        this.municipalitiesChange.emit(this.municipalities);
        this.lausChange.emit(this.laus);
        this.onBack.emit();
    }

    private preventPaste(event: any) {
        return false;
    }

    private checkButtonEnabled(event, i?) {
        if (this.municipalities) {
            this.checButtonNextEnabled();
            this.checkMunicipalities()
            this.checkEmailsMatch();
        }
    }

    private isEmpty(string: String) : boolean{
        return string == null || string.trim() == "";
    }

}
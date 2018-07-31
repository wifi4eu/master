import {Component, EventEmitter, Input, OnChanges, Output, SimpleChanges} from "@angular/core";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {LauDTOBase} from "../../shared/swagger/model/LauDTO";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";
import {LauApi} from "../../shared/swagger/api/LauApi";
import {MayorDTOBase} from "../../shared/swagger/model/MayorDTO";
import {ViewChild} from "@angular/core";
import {NgForm} from "@angular/forms";
import {LocalStorageService} from "angular-2-local-storage/dist/local-storage.service";
import {Observable} from "rxjs/Observable";
import {SharedService} from "app/shared/shared.service";

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
    @ViewChild('municipalityForm') private municipalityForms: NgForm;
    private lauSuggestions: LauDTOBase[] = [];
    private municipalitiesSelected: boolean = false;
    private emailsMatch: boolean = false;
    private emailConfirmations: string[] = [''];
    private readonly MAX_LENGTH = 2;
    private css_class_municipalities: string[] = ['notValid'];
    private css_class_email: string[] = ['notValid'];
    private emailPattern = new RegExp("(?:[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])*\")@(?:(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-zA-Z0-9-]*[a-zA-Z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\\])");
    private buttonEnabled : boolean = false;
    private userEcas: UserDTOBase;

    @ViewChild('municipalityForm') municipalityForm: NgForm;

    constructor(private lauApi: LauApi, private localStorage: LocalStorageService, private sharedService: SharedService) {
        this.mayorsChange = new EventEmitter<UserDTOBase[]>();
        this.municipalitiesChange = new EventEmitter<MunicipalityDTOBase[]>();
        this.lausChange = new EventEmitter<LauDTOBase[]>();
        this.findLaus = new EventEmitter<string>();
        this.onNext = new EventEmitter<any>();
        this.onBack = new EventEmitter<any>();

        this.emailsMatch = true;
        this.sharedService.cleanEmitter.subscribe(
            () => {
                for (let i = 0; i < this.municipalities.length; i++) {
                    this.emailConfirmations[i] = '';
                    this.css_class_email[i] = 'notValid';
                }
            }
        )
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
        }
    }

    private checkMunicipalitiesSelected() {
        this.municipalitiesSelected = false;
        for (let i = 0; i < this.laus.length; i++) {
            if (!this.laus[i].id) {
                this.municipalitiesSelected = false;
                if (!this.multipleMunicipalities) {
                    this.municipalityForm.controls['municipality'].setErrors({'incorrect': true});
                }
                else {
                    this.municipalityForm.controls[`municipality-${i}`].setErrors({'incorrect': true});
                }
                this.css_class_municipalities[i] = 'notValid';
            } else {
                if (!this.multipleMunicipalities) {
                    if (this.municipalityForm.controls['municipality'] != undefined) this.municipalityForm.controls['municipality'].setErrors(null);
                }
                else {
                    this.municipalityForm.controls[`municipality-${i}`].setErrors(null);
                }
                this.css_class_municipalities[i] = 'isValid';
                this.municipalitiesSelected = true;
            }
        }
    }

    private checkEmailsMatch() {
        this.emailsMatch = false;
        for (let i = 0; i < this.mayors.length; i++) {
            if (this.mayors[i].email != this.emailConfirmations[i] || this.emailConfirmations[i].length < 1) {
                this.emailsMatch = false;
                this.css_class_email[i] = 'notValid';
            } else if (this.emailPattern.test(this.emailConfirmations[i])) {
                this.css_class_email[i] = 'isValid';
                this.emailsMatch = true;
            }
        }
      if (this.municipalitiesSelected && this.emailsMatch) {
            const keys = Object.keys(this.municipalityForm.controls);
            keys.forEach(key => {
                this.municipalityForm.controls[key].setErrors({'incorrect': true});
                this.municipalityForm.controls[key].setErrors(null);
            });
        } 
    }

    private addMunicipality() {
        if (this.multipleMunicipalities) {
            this.municipalities.push(new MunicipalityDTOBase());
            //this.laus.push();
            this.mayors.push(new UserDTOBase());
            this.emailConfirmations.push('');
            this.css_class_email.push('notValid');
            this.css_class_municipalities.push('notValid');
        }
        this.checkMunicipalitiesSelected();
    }

    private removeMunicipality(index: number, deleteCount: number = 1) {
        this.municipalities.splice(index, deleteCount);
        this.laus.splice(index, deleteCount);
        this.mayors.splice(index, deleteCount);
        this.emailConfirmations.splice(index, deleteCount);
        this.css_class_email.splice(index, deleteCount);
        this.css_class_municipalities.splice(index, deleteCount);
        if (this.mayors.length < 1) {
            this.checkMunicipalitiesSelected();
            this.municipalitiesSelected = true;
        } else {
            this.municipalitiesSelected = true;
            this.checkMunicipalitiesSelected();
        }
        this.checkEmailsMatch();

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
            this.emailsMatch = false;
    }

    private back() {
        this.mayorsChange.emit(this.mayors);
        this.municipalitiesChange.emit(this.municipalities);
        this.lausChange.emit(this.laus);
        this.onBack.emit();
        for (let i = 0; i < this.emailConfirmations.length; i++) {
            this.emailConfirmations[i] = '';
            this.css_class_email[i] = 'notValid';
        }
        this.emailsMatch = false;
    }

    private preventPaste(event: any) {
        return false;
    }

    private checkButtonEnabled(event){
            this.buttonEnabled = true;
        for (let i = 0; i < this.municipalities.length; i++) {
            if(this.municipalities[i].address != null && this.municipalities[i].addressNum != null && this.municipalities[i].postalCode != null && this.mayors[i].name != null && this.mayors[i].surname != null 
                && this.municipalities[i].address.trim() != "" && this.municipalities[i].addressNum.trim() != "" && this.municipalities[i].postalCode.trim() != "" && this.mayors[i].name.trim() != "" && this.mayors[i].surname.trim() != ""){
                    continue;
            } else {
                this.buttonEnabled = false;
                //this.municipalityForms.controls[`address-${i}`].setErrors(null);
               
            }
           /*  if(this.municipalities[i].address != null && this.municipalities[i].address.trim() != ""){
                setTimeout(()=>{this.municipalityForms.controls[`address-${i}`].setErrors(null);} ,5);

            }else {
                setTimeout(()=>{this.municipalityForms.controls[`address-${i}`].setErrors({'invalid': true});} ,5);
            }
            //custom addressNum validator
             if(this.municipalities[i].addressNum != null && this.municipalities[i].addressNum.trim() != ""){
                setTimeout(()=>{this.municipalityForms.controls[`addressNum-${i}`].setErrors(null);} ,5);
            }else {
                setTimeout(()=>{this.municipalityForms.controls[`addressNum-${i}`].setErrors({'invalid': true});} ,5);
            }
            //custom postalCode validator
            if(this.municipalities[i].postalCode != null && this.municipalities[i].postalCode.trim() != ""){
                setTimeout(()=>{this.municipalityForms.controls[`postalCode-${i}`].setErrors(null);} ,5);
            }else {
                setTimeout(()=>{this.municipalityForms.controls[`postalCode-${i}`].setErrors({'invalid': true});} ,5);
            }
             //custom name validator
             if(this.mayors[i].name != null && this.mayors[i].name.trim() != ""){
                setTimeout(()=>{this.municipalityForms.controls[`name-${i}`].setErrors(null);} ,5);
            }else {
                setTimeout(()=>{this.municipalityForms.controls[`name-${i}`].setErrors({'invalid': true});} ,5);
            }
             //custom surname validator
             if(this.mayors[i].surname != null && this.mayors[i].surname.trim() != ""){
                setTimeout(()=>{this.municipalityForms.controls[`surname-${i}`].setErrors(null);} ,5);
            }else {
                setTimeout(()=>{this.municipalityForms.controls[`surname-${i}`].setErrors({'invalid': true});} ,5);
            }  */
        }
    }
}
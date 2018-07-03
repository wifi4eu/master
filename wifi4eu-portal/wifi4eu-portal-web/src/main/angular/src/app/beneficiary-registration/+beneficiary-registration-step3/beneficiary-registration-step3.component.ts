import {Component, EventEmitter, Input, Output, OnInit} from "@angular/core";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {MayorDTOBase} from "../../shared/swagger/model/MayorDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {SharedService} from "../../shared/shared.service";
import {LocalStorageService} from "angular-2-local-storage/dist/local-storage.service";

@Component({
    selector: 'beneficiary-registration-step3',
    templateUrl: 'beneficiary-registration-step3.component.html'
})

export class BeneficiaryRegistrationStep3Component {
    @Input('initialUser') private initialUser: UserDTOBase;
    @Input('multipleMunicipalities') private multipleMunicipalities: boolean;
    @Input('mayors') private mayors: MayorDTOBase[];
    @Input('municipalities') private municipalities: MunicipalityDTOBase[];
    @Input('sameDetails') private sameDetails: boolean;
    @Input('associationName') private associationName: string;

    private imMayor: boolean;
    private repeatEmail: string;
    private userEmailMatches: boolean;
    private buttonEnabled: boolean = false;

    @Output() private onNext: EventEmitter<any>;
    @Output() private onBack: EventEmitter<any>;
    @Output() private associationNameChange: EventEmitter<string>;

    private css_class_email: string = '';
    /* private emailPattern = '^[a-zA-Z0-9](\\.?[a-zA-Z0-9_-]){0,}@[a-zA-Z0-9-]+\\.([a-zA-Z]{1,6}\\.)?[a-zA-Z]{2,6}$'; */
    private emailPattern = new RegExp(/^[a-z0-9_-]+(?:\.[a-z0-9_-]+)*@(?:[a-z0-9]{2,6}?\.)+[a-z0-9]{2,6}?$/i);

    constructor(private sharedService: SharedService, private localStorage: LocalStorageService) {
        this.onNext = new EventEmitter<any>();
        this.onBack = new EventEmitter<any>();
        this.associationNameChange = new EventEmitter<string>();
        this.imMayor = false;
        this.userEmailMatches = true;
        this.sameDetails = false;
        this.sharedService.cleanEmitter.subscribe(() => { this.reset(); });
    }

    private fillMayorData() {
        if (!this.imMayor) {
            this.imMayor = true;
            this.initialUser.name = this.mayors[0].name;
            this.initialUser.surname = this.mayors[0].surname;
            this.initialUser.address = this.municipalities[0].address;
            this.initialUser.addressNum = this.municipalities[0].addressNum;
            this.initialUser.postalCode = this.municipalities[0].postalCode;
            this.userEmailMatches = true;
            this.css_class_email = '';
        } else {
            this.imMayor = false;
            this.initialUser.name = '';
            this.initialUser.surname = '';
            this.initialUser.address = '';
            this.initialUser.addressNum = '';
            this.userEmailMatches = true;
            this.initialUser.postalCode = '';
            /* this.checkEmailsMatch(); */
        }
    }

    private checkEmailsMatch() {
        this.userEmailMatches = false;
        if (this.initialUser.email === this.repeatEmail && this.repeatEmail.length > 0) {
            this.userEmailMatches = true;
            this.css_class_email = 'isValid';
        } else {
            this.css_class_email = 'notValid';
        }
    }

    private back() {
        this.onBack.emit();
        this.associationNameChange.emit(this.associationName);
        this.repeatEmail = '';
        this.sharedService.clean();
        /* this.checkEmailsMatch(); */
    }

    private reset() {
        if (this.imMayor) {
            this.sameDetails = this.imMayor = false;
            this.initialUser.name = '';
            this.initialUser.surname = '';
            this.initialUser.address = '';
            this.initialUser.addressNum = '';
            this.initialUser.postalCode = '';
            this.userEmailMatches = true;
            this.associationName = '';
        }
    }

    private submit() {
        const storedUser = this.localStorage.get('user');
        const userEcas = storedUser ? JSON.parse(storedUser.toString()) : null;
        this.initialUser.email = userEcas.ecasEmail;
        this.initialUser.ecasEmail = userEcas.ecasEmail;
        this.onNext.emit();
        this.associationNameChange.emit(this.associationName);
    }

    private preventPaste(event: any) {
        return false;
    }

    private checkButtonEnabled(event){
        for (let i = 0; i < this.municipalities.length; i++) {
            if(this.initialUser.surname != null && this.initialUser.name != null && this.initialUser.addressNum != null && this.initialUser.address != null  && this.initialUser.postalCode != null
                 && this.initialUser.surname.trim() != "" && this.initialUser.name.trim() != "" && this.initialUser.addressNum.trim() != "" && this.initialUser.address.trim() != "" && this.initialUser.postalCode.trim() != ""){
                    this.buttonEnabled = true;
            }
        }
    }
}
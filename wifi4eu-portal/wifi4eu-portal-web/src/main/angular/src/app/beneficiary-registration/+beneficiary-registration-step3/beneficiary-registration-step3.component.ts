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
    private repeatEmail: string = '';
    private userEmailMatches: boolean = false;
    private hasEcasEmail: boolean = false;
    private storedUser;
    private userEcas;
    private emailPattern = new RegExp("(?:[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])*\")@(?:(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-zA-Z0-9-]*[a-zA-Z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\\])");
    

    @Output() private onNext: EventEmitter<any>;
    @Output() private onBack: EventEmitter<any>;
    @Output() private associationNameChange: EventEmitter<string>;

    private css_class_email: string = '';

    constructor(private sharedService: SharedService, private localStorage: LocalStorageService) {
        this.onNext = new EventEmitter<any>();
        this.onBack = new EventEmitter<any>();
        this.associationNameChange = new EventEmitter<string>();
        this.imMayor = false;
        this.sameDetails = false;
        this.sharedService.cleanEmitter.subscribe(() => {     
            if (!this.imMayor){
                this.repeatEmail = '';
            }    
        });
        this.storedUser = this.localStorage.get('user');
        this.userEcas = this.storedUser ? JSON.parse(this.storedUser.toString()) : null;
        if (this.userEcas.ecasEmail){
            this.hasEcasEmail = true;
            this.userEmailMatches = true;
        }
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
            this.initialUser.ecasEmail = this.mayors[0].email;
            this.repeatEmail = this.mayors[0].email;
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
            this.initialUser.ecasEmail = '';
            this.repeatEmail = '';
            /* this.checkEmailsMatch(); */
        }
    }

    private checkEmailsMatch() {
        if (this.initialUser.ecasEmail === this.repeatEmail && this.repeatEmail.length > 0) {
            this.userEmailMatches = true;
            this.css_class_email = 'isValid';
        } else {
            this.userEmailMatches = false;
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
            this.initialUser.email = '';
            this.initialUser.ecasEmail = '';
            this.repeatEmail = '';
            this.initialUser.ecasUsername = '';
            this.userEmailMatches = true;
            this.associationName = '';
        }
    }

    private submit() {
        if (this.userEcas.ecasEmail){
            this.initialUser.ecasEmail = this.userEcas.ecasEmail;
            this.initialUser.email = this.userEcas.ecasEmail;
        } else {
            this.initialUser.email = this.initialUser.ecasEmail;
        }
        this.onNext.emit();
        this.associationNameChange.emit(this.associationName);
    }

    private preventPaste(event: any) {
        return false;
    }
}
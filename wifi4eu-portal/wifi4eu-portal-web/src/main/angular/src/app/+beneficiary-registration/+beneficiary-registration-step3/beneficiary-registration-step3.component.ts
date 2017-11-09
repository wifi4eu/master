import {Component, EventEmitter, Input, Output, OnInit} from "@angular/core";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";


@Component({
    selector: 'beneficiary-registration-step3',
    templateUrl: 'beneficiary-registration-step3.component.html'
})

export class BeneficiaryRegistrationStep3Component implements OnInit {

    @Input('initialUser') private initialUser: UserDTOBase;
    @Input('multipleMunicipalities') private multipleMunicipalities: boolean;
    @Input('users') private users: UserDTOBase[];
    @Input('userAddress') private userAddress: string;
    @Input('addressNum') private addressNum: string;
    @Input('municipalities') private municipalities: MunicipalityDTOBase[];
    @Input('postalCode') private postalCode: string;


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
        this.userAddress = "";
        this.addressNum = "";
        this.postalCode = "";

    }

    ngOnInit() {
    }

    fillMayorData() {
        if (!this.imMayor) {
            this.imMayor = true;
            this.initialUser.name = this.users[0].name;
            this.initialUser.surname = this.users[0].surname;
            this.initialUser.email = this.users[0].email;
            this.userEmailMatches = true;
            this.postalCode = this.municipalities[0].postalCode;
            this.addressNum = this.municipalities[0].addressNum;
            this.userAddress = this.municipalities[0].address;
        } else {
            this.imMayor = false;
            this.initialUser.name = "";
            this.initialUser.surname = "";
            this.initialUser.email = "";
            this.userAddress = "";
            this.repeatEmail = "";
            this.addressNum = "";
            this.userAddress = "";
            this.postalCode = "";
        }

    }

    onKey(event: any) {
        this.userEmailMatches = false;
        if (this.initialUser.email === this.repeatEmail) {
            this.userEmailMatches = true;
        }
    }

    back() {
        this.onBack.emit();
    }

    submit(step: number) {
        this.onNext.emit(step);
    }
}
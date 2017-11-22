import {Component, EventEmitter, Input, Output, OnInit} from "@angular/core";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {MayorDTOBase} from "../../shared/swagger/model/MayorDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";


@Component({
    selector: 'beneficiary-registration-step3',
    templateUrl: 'beneficiary-registration-step3.component.html'
})

export class BeneficiaryRegistrationStep3Component implements OnInit {

    @Input('initialUser') private initialUser: UserDTOBase;
    @Input('multipleMunicipalities') private multipleMunicipalities: boolean;
    @Input('mayors') private mayors: MayorDTOBase[];
    @Input('userAddress') private userAddress: string;
    @Input('addressNum') private addressNum: string;
    @Input('municipalities') private municipalities: MunicipalityDTOBase[];
    @Input('postalCode') private postalCode: string;
    @Output() private addressNumChange: EventEmitter<string>;
    @Output() private userAddressChange: EventEmitter<string>;
    @Output() private postalCodeChange: EventEmitter<string>;


    private imMayor: boolean;
    private repeatEmail: string;
    private userEmailMatches: boolean;

    @Output() private onNext: EventEmitter<any>;
    @Output() private onBack: EventEmitter<any>;


    constructor() {
        this.onNext = new EventEmitter<any>();
        this.onBack = new EventEmitter<any>();
        this.addressNumChange = new EventEmitter<string>();
        this.userAddressChange = new EventEmitter<string>();
        this.postalCodeChange = new EventEmitter<string>();
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
            this.initialUser.name = this.mayors[0].name;
            this.initialUser.surname = this.mayors[0].surname;
            this.initialUser.email = this.mayors[0].email;
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
        this.addressNumChange.emit(this.addressNum);
        this.userAddressChange.emit(this.userAddress);
        this.postalCodeChange.emit(this.postalCode);
        this.onBack.emit();
        this.repeatEmail = "";
    }

    submit(step: number) {
        this.addressNumChange.emit(this.addressNum);
        this.userAddressChange.emit(this.userAddress);
        this.postalCodeChange.emit(this.postalCode);
        this.onNext.emit(step);
        this.repeatEmail = "";
    }
}
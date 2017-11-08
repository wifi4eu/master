import {Component, EventEmitter, Input, Output, OnInit} from "@angular/core";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";


@Component({
    selector: 'beneficiary-registration-step3',
    templateUrl: 'beneficiary-registration-step3.component.html'
})

export class BeneficiaryRegistrationStep3Component implements OnInit {

    @Input('initialUser') private initialUser: UserDTOBase;
    @Input('multipleMunicipalities') private multipleMunicipalities: boolean;
    @Input('users') private users: UserDTOBase[];
    @Input('userAddress') private userAddress: string;

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

    }

    ngOnInit() {

    }

    fillMayorData(event: boolean) {
        if (event) {
            this.imMayor = true;

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
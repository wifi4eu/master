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

    private checked: boolean;
    private repeatEmail: string;
    private userEmailMatches: boolean;

    @Output() private onNext: EventEmitter<any>;
    @Output() private onBack: EventEmitter<any>;


    constructor() {
        this.onNext = new EventEmitter<any>();
        this.onBack = new EventEmitter<any>();
        this.checked = false;
        this.userEmailMatches = false;
        this.userAddress = "";

    }

    ngOnInit() {

    }

    fillMayorData(event: boolean) {
        if (event) {
            this.checked = true;
            this.initialUser.name = this.users[0].name;
            this.initialUser.surname = this.users[0].surname;
            this.initialUser.email = this.users[0].email;
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
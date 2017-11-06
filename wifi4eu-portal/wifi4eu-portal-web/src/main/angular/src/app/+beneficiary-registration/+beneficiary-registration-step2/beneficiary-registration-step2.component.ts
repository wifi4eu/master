import {Component, EventEmitter, Input, Output, OnInit} from "@angular/core";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";

@Component({
    selector: 'beneficiary-registration-step2', templateUrl: 'beneficiary-registration-step2.component.html'
})

export class BeneficiaryRegistrationStep2Component implements OnInit {
    @Input('initialUser') private initialUser: UserDTOBase;
    @Output() private initialUserChange: EventEmitter<UserDTOBase>;
    @Output() private representingChange: EventEmitter<boolean>;
    @Output() private onNext: EventEmitter<any>;
    private mayorUser: UserDTOBase;
    private representativeUser: UserDTOBase;

    @Input('municipalities') private municipalities: MunicipalityDTOBase[];
    @Output() private municipalitiesChange: EventEmitter<MunicipalityDTOBase[]>;
    @Input('users') private users: UserDTOBase[];
    @Output() private usersChange: EventEmitter<UserDTOBase[]>;
    @Input('representing') private representing: boolean;
    @Output() private onBack: EventEmitter<any>;


    constructor() {
        this.initialUserChange = new EventEmitter<UserDTOBase>();
        this.representingChange = new EventEmitter<boolean>();
        this.onNext = new EventEmitter<any>();
    }


    ngOnInit() {

        this.mayorUser = new UserDTOBase();
        this.mayorUser.type = 2;
        this.representativeUser = new UserDTOBase();
        this.representativeUser.type = 3;
    }

    onSubmit(step: number) {
        this.onNext.emit(step);
    }
}
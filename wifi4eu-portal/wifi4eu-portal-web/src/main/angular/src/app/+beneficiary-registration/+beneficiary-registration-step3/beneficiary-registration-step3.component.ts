import {Component, Input, Output, EventEmitter} from "@angular/core";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";

@Component({
    selector: 'beneficiary-registration-step3', templateUrl: 'beneficiary-registration-step3.component.html'
})

export class BeneficiaryRegistrationStep3Component {
    @Input('initialUser') initialUser: UserDTOBase;
    @Output() initialUserChange: EventEmitter<UserDTOBase>;
    @Input('municipalities') municipalities: MunicipalityDTOBase[];
    @Output() municipalitiesChange: EventEmitter<MunicipalityDTOBase[]>;
    @Input('users') users: UserDTOBase[];
    @Output() usersChange: EventEmitter<UserDTOBase[]>;
    @Input('representing') representing: boolean;
    @Output() onNext: EventEmitter<any>;
    @Output() onBack: EventEmitter<any>;
    @Output() onEdit: EventEmitter<number>;

    constructor(private uxService: UxService) {
        this.initialUserChange = new EventEmitter<UserDTOBase>();
        this.municipalitiesChange = new EventEmitter<MunicipalityDTOBase[]>();
        this.usersChange = new EventEmitter<UserDTOBase[]>();
        this.onNext = new EventEmitter<any>();
        this.onBack = new EventEmitter<any>();
        this.onEdit = new EventEmitter<any>();
    }

    submit() {
        this.onNext.emit();
    }

    back() {
        this.onBack.emit();
    }
}
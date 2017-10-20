import {Component} from "@angular/core";
import {UserDTOBase} from "../shared/swagger/model/UserDTO";
import {MayorDTOBase} from "../shared/swagger/model/MayorDTO";
import {MunicipalityDTOBase} from "../shared/swagger/model/MunicipalityDTO";
import {RepresentationDTOBase} from "../shared/swagger/model/RepresentationDTO";
import {RegistrationDTOBase} from "../shared/swagger/model/RegistrationDTO";
import {NutsDTOBase} from "../shared/swagger/model/NutsDTO";
import {LauDTOBase} from "../shared/swagger/model/LauDTO";

@Component({
    selector: 'beneficiary-registration.component', templateUrl: 'beneficiary-registration.component.html'
})

export class BeneficiaryRegistrationComponent {
    private successRegistration: boolean = false;
    private failureRegistration: boolean = false;
    private completed: boolean[] = [false, false, false];
    private active: boolean[] = [true, false, false];
    private users: UserDTOBase[] = [];
    private mayors: MayorDTOBase[] = [];
    private municipalities: MunicipalityDTOBase[] = [];
    private representations: RepresentationDTOBase[] = [];
    private registrations: RegistrationDTOBase[] = [];
    private representing: boolean = false;

    navigateTo(step: number, representing: boolean) {
        this.representing = representing;
        switch (step) {
            case 1:
                this.completed = [false, false, false];
                this.active = [true, false, false];
                break;
            case 2:
                this.completed = [true, false, false];
                this.active = [false, true, false];
                break;
            case 3:
                this.completed = [true, true, false];
                this.active = [false, false, true];
                break;
        }
    }

    completeRegistration() {
    }
}
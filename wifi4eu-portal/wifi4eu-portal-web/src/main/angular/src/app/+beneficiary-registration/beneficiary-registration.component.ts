import {Component} from "@angular/core";
import {UserDTOBase} from "../shared/swagger/model/UserDTO";
import {MunicipalityDTOBase} from "../shared/swagger/model/MunicipalityDTO";
import {RegistrationDTOBase} from "../shared/swagger/model/RegistrationDTO";
import {BeneficiaryDTOBase} from "../shared/swagger/model/BeneficiaryDTO";
import {BeneficiaryApi} from "../shared/swagger/api/BeneficiaryApi";

@Component({
    selector: 'beneficiary-registration', templateUrl: 'beneficiary-registration.component.html', providers: [BeneficiaryApi]
})

export class BeneficiaryRegistrationComponent {
    private successRegistration: boolean = false;
    private failureRegistration: boolean = false;
    private completed: boolean[] = [false, false, false];
    private active: boolean[] = [true, false, false];
    private representing: boolean = false;
    private initialUser: UserDTOBase = new UserDTOBase();
    private users: UserDTOBase[] = [];
    private municipalities: MunicipalityDTOBase[] = [];
    private registrations: RegistrationDTOBase[] = [];
    private finalBeneficiary: BeneficiaryDTOBase = new BeneficiaryDTOBase();

    constructor(private beneficiaryApi: BeneficiaryApi) {
    }

    navigate(step: number) {
        console.log("this.representing");
        console.log(this.representing);
        console.log("this.initialUser");
        console.log(this.initialUser);
        console.log("this.users");
        console.log(this.users);
        console.log("this.municipalities");
        console.log(this.municipalities);
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

    submitRegistration() {
        this.finalBeneficiary.representing = this.representing;
        this.finalBeneficiary.users = [];
        this.finalBeneficiary.municipalities = [];
        this.finalBeneficiary.users.push(this.initialUser);
        for (let user of this.users) {
            this.finalBeneficiary.users.push(user);
        }
        for (let municipality of this.municipalities) {
            this.finalBeneficiary.municipalities.push(municipality);
        }
        this.beneficiaryApi.submitBeneficiaryRegistration(this.finalBeneficiary).subscribe(
            data => {
                console.log(data);
            }, error => {
                console.log(error);
            }
        );
    }
}
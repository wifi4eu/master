import {Component} from "@angular/core";
import {ContactPersonDTOBase} from "../shared/swagger/model/ContactPersonDTO";
import {CompanyDTOBase} from "../shared/swagger/model/CompanyDTO";
import {SupplierRegstration} from "./supplier-registration.model";

@Component({templateUrl: 'supplier-registration.component.html'})
export class SupplierRegistrationComponent {

    // private contactPerson: ContactPersonDTOBase;
    // private company: CompanyDTOBase;
    private registration: SupplierRegstration;

    private selection: boolean[];
    private completed: boolean[];
    private active: boolean[];
    private successRegistration: boolean;
    private failureRegistration: boolean;

    constructor() {
        this.selection = [true, false];
        this.completed = [false, false, false, false];
        this.active = [true, false, false, false];
        this.successRegistration = false;
        this.failureRegistration = false;
        this.registration = new SupplierRegstration();
    }

    onNext(step: number) {
        this.completed[step - 1] = true;
        this.active[step - 1] = false;
        this.active[step] = true;
    }

    gotoStep(step: number) {
        switch (step) {
            case 1:
                this.completed = [false, false, false, false];
                this.active = [true, false, false, false];
                break;
            case 2:
                this.completed = [true, false, false, false];
                this.active = [false, true, false, false];
                break;
            case 3:
                this.completed = [true, true, false, false];
                this.active = [false, false, true, false];
                break;
            case 4:
                this.completed = [true, true, true, false];
                this.active = [false, false, false, true];
                break;
        }
    }

    onBack(step: number) {
        this.completed[step - 1] = false;
        this.active[step - 1] = true;
        this.active[step] = false;
    }

    onSuccess(value: boolean) {
        this.successRegistration = value;
    }

    onFailure(value: boolean) {
        this.failureRegistration = value;
    }
}
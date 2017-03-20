import {Component} from "@angular/core";

@Component({templateUrl: 'supplier-registration.component.html'})
export class SupplierRegistrationComponent {


    private selection: boolean[];
    private completed: boolean[];
    private active: boolean[];
    private successRegistration: boolean;
    private failureRegistration: boolean;

    constructor() {
        this.selection = [true, false];
        this.completed = [false, false, false];
        this.active = [true, false, false];
        this.successRegistration = false;
        this.failureRegistration = false;
    }

    onNext(step: number) {
        this.completed[step - 1] = true;
        this.active[step - 1] = false;
        this.active[step] = true;
    }

    gotoStep(step: number) {
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
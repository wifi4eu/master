import {Component, Input} from '@angular/core';
import {UserDetails} from './user-details.module'

@Component({selector: 'app-home', templateUrl: 'home.component.html'})
export class HomeComponent {
    @Input('userDetails') userDetails: UserDetails = new UserDetails();
    displayConfirmingData: boolean = false;

    onSubmit() {
        let that = this;
        this.displayConfirmingData = true;
        setTimeout(function () {
            that.displayConfirmingData = false;
        }, 2000);
    }
}
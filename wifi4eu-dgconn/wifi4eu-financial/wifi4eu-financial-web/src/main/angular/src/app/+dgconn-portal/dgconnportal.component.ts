import {Component, Input} from "@angular/core";
import {DgConnDetails} from "./dgconnportal-details.model";

@Component({templateUrl: 'dgconnportal.component.html'})
export class DgConnPortalComponent {

    @Input('dgConnDetails') dgConnDetails: DgConnDetails;

    constructor() {
        this.dgConnDetails = new DgConnDetails();
    }
}

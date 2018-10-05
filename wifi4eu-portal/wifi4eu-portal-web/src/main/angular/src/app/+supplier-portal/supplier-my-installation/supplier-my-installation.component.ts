import {Component} from "@angular/core";
import { SharedService } from "../../shared/shared.service";

@Component({
    selector: 'supplier-my-installation',
    templateUrl: 'supplier-my-installation.component.html',
})

export class SupplierMyInstallationComponent {
    constructor(private sharedService: SharedService) {
   
    }

}
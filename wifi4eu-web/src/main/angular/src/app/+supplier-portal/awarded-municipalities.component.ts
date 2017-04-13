import {Component} from "@angular/core";
import {LocalStorageService} from "angular-2-local-storage";
import {UserDTO} from "../shared/swagger/model/UserDTO";
import {SupplierApi} from "../shared/swagger/api/SupplierApi";

@Component({
    selector: 'awarded-municipalities',
    templateUrl: 'awarded-municipalities.component.html',
    providers: [SupplierApi]
})
export class AwardedMunicipalitiesComponent {
    private user: UserDTO;

    constructor(private localStorage: LocalStorageService, private supplierApi: SupplierApi) {
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
    }
}
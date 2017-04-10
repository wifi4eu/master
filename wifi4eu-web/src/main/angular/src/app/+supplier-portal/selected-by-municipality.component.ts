import {Component} from "@angular/core";
import {UserDTO} from "../shared/swagger/model/UserDTO";
import {LocalStorageService} from "angular-2-local-storage";
import {SupplierApi} from "../shared/swagger/api/SupplierApi";

@Component({
    selector: 'selected-by-municipality',
    templateUrl: 'selected-by-municipality.component.html',
    providers: [SupplierApi]
})
export class SelectedByMunicipalityComponent {
    private user: UserDTO;

    constructor(private localStorage: LocalStorageService, private supplierApi: SupplierApi) {
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
    }


}

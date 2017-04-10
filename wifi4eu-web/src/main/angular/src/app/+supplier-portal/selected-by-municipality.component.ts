import {Component} from "@angular/core";
import {UserDTO} from "../shared/swagger/model/UserDTO";
import {LocalStorageService} from "angular-2-local-storage";

@Component({
    selector: 'selected-by-municipality', templateUrl: 'selected-by-municipality.component.html', providers: []
})
export class SelectedByMunicipalityComponent {
    private user: UserDTO;

    constructor(private localStorage: LocalStorageService) {
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;

    }


}

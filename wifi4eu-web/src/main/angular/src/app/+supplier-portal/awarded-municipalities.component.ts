import {Component} from "@angular/core";
import {LocalStorageService} from "angular-2-local-storage";
import {UserDTO} from "../shared/swagger/model/UserDTO";

@Component({
    selector: 'awarded-municipalities',
    templateUrl: 'awarded-municipalities.component.html',
    providers: []
})
export class AwardedMunicipalitiesComponent {
    private user: UserDTO;
    constructor(private localStorage: LocalStorageService) {
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
    }


}
import {Component} from "@angular/core";
import {LocalStorageService} from "angular-2-local-storage";
import {UserDTO} from "../shared/swagger/model/UserDTO";
import {LegalEntityDTO} from "../+beneficiary-registration/+beneficiary-registration-step3/legalEntityDTO.model";
import {BeneficiaryApi} from "../shared/swagger/api/BeneficiaryApi";

@Component({
    selector: 'awarded-municipalities',
    templateUrl: 'awarded-municipalities.component.html',
    providers: [BeneficiaryApi]
})
export class AwardedMunicipalitiesComponent {
    private user: UserDTO;
    private municipalities: LegalEntityDTO[];

    constructor(private localStorage: LocalStorageService, private beneficiaryApi: BeneficiaryApi) {
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;

        this.beneficiaryApi.getAwardedMunicipalities().subscribe(
            (data: LegalEntityDTO[]) => {
                this.municipalities = data;
            },
            error => {
                console.log(error);
            }
        );

    }
}
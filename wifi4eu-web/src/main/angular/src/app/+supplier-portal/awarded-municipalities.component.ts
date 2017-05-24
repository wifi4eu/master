import {Component} from "@angular/core";
import {LocalStorageService} from "angular-2-local-storage";
import {UserDTO} from "../shared/swagger/model/UserDTO";
import {LegalEntityDTO} from "../+beneficiary-registration/+beneficiary-registration-step3/legalEntityDTO.model";
import {BeneficiaryApi} from "../shared/swagger/api/BeneficiaryApi";
import {NutsDTOBase} from "../shared/swagger/model/NutsDTO";
import {LauDTOBase} from "../shared/swagger/model/LauDTO";
import {NutsApi} from "../shared/swagger/api/NutsApi";
import {LauApi} from "../shared/swagger/api/LauApi";

@Component({
    selector: 'awarded-municipalities',
    templateUrl: 'awarded-municipalities.component.html',
    providers: [BeneficiaryApi, NutsApi, LauApi]
})
export class AwardedMunicipalitiesComponent {
    private user: UserDTO;
    private municipalities: LegalEntityDTO[];
    private countryNames: string[];
    private municipalitiesNames: string[];

    constructor(private localStorage: LocalStorageService, private beneficiaryApi: BeneficiaryApi, private nutsApi: NutsApi, private lauApi: LauApi) {
        this.countryNames = [];
        this.municipalitiesNames = [];

        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
    }

    ngOnInit() {
        this.beneficiaryApi.getAwardedMunicipalities().subscribe(
            (data: LegalEntityDTO[]) => {
                this.municipalities = data;
                for (let i = 0; i < this.municipalities.length; i++) {
                    this.nutsApi.findNutsByLevel(0).subscribe(
                        (nuts: NutsDTOBase[]) => {
                            for (let i = 0; i < nuts.length; i++) {
                                if (this.municipalities[i].countryCode == nuts[i].countryCode) {
                                    this.countryNames.push(nuts[i].name);
                                    break;
                                }
                            }
                        }, error => {
                            console.log(error);
                            this.countryNames.push("");
                        }
                    );
                    this.lauApi.findLauByLau2(this.municipalities[i].municipalityCode).subscribe(
                        (result: LauDTOBase) => {
                            this.municipalitiesNames.push(result.name1);
                        },
                        error => {
                            console.log(error);
                            this.municipalitiesNames.push("");
                        }
                    );
                }
            },
            error => {
                console.log(error);
            }
        );
    }
}
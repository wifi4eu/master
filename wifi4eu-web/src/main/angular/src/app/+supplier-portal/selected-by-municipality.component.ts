import {Component} from "@angular/core";
import {UserDTO} from "../shared/swagger/model/UserDTO";
import {LocalStorageService} from "angular-2-local-storage";
import {SupplierApi} from "../shared/swagger/api/SupplierApi";
import {LegalEntityDTO} from "../shared/swagger/model/LegalEntityDTO";
import {BenPubSupDTO} from "../shared/swagger/model/BenPubSupDTO";
import {BeneficiaryApi} from "../shared/swagger/api/BeneficiaryApi";
import {CallApi} from "../shared/swagger/api/CallApi";
import {CallDTO} from "../shared/swagger/model/CallDTO";
import {LauApi} from "../shared/swagger/api/LauApi";
import {NutsApi} from "../shared/swagger/api/NutsApi";
import {NutsDTOBase} from "../shared/swagger/model/NutsDTO";
import {LauDTOBase} from "../shared/swagger/model/LauDTO";
import {DgconnApi} from "../shared/swagger/api/DgconnApi";

@Component({
    selector: 'selected-by-municipality',
    templateUrl: 'selected-by-municipality.component.html',
    providers: [SupplierApi, BeneficiaryApi, CallApi, NutsApi, LauApi, DgconnApi]
})
export class SelectedByMunicipalityComponent {
    private user: UserDTO;
    private municipalities: LegalEntityDTO[];
    private currentCall: CallDTO;
    private installationIds: number[];
    private countryNames: string[];
    private municipalitiesNames: string[];

    constructor(private localStorage: LocalStorageService, private supplierApi: SupplierApi, private beneficiaryApi: BeneficiaryApi, private callApi: CallApi, private nutsApi: NutsApi, private lauApi: LauApi, private dgconnApi: DgconnApi) {
        this.installationIds = [];
        this.countryNames = [];
        this.municipalitiesNames = [];

        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
    }

    ngOnInit() {
        this.callApi.allCalls().subscribe(
            calls => {
                this.currentCall = calls[0];
                if (this.user != null) {
                    this.supplierApi.getSelectedMeBySupplierId(this.user.userTypeId).subscribe(
                        data => {
                            this.municipalities = data;
                            for (let i = 0; i < data.length; i++) {
                                this.beneficiaryApi.findByBeneficiaryIdAndPublicationId(this.municipalities[i].legalEntityId, this.currentCall.callId).subscribe(
                                    (result: BenPubSupDTO) => {
                                        this.installationIds.push(result.benPubSubId);
                                        this.lauApi.findLauByLau2(this.municipalities[i].municipalityCode).subscribe(
                                            (result: LauDTOBase) => {
                                                this.municipalitiesNames.push(result.name1);
                                            },
                                            error => {
                                                this.municipalitiesNames.push("");
                                            }
                                        );
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
                                    }, error => {
                                        console.log(error);
                                    }
                                );
                            }
                        },
                        error => {
                            console.log(error);
                        }
                    );
                } else {
                    this.municipalities = [];
                }
            }, error => {
                console.log(error);
                this.currentCall = null;
            }
        );
    }
    
}

import {Component} from "@angular/core";
import {UserDTO} from "../shared/swagger/model/UserDTO";
import {LocalStorageService} from "angular-2-local-storage";
import {SupplierApi} from "../shared/swagger/api/SupplierApi";
import {LegalEntityDTO} from "../shared/swagger/model/LegalEntityDTO";
import {BenPubSupDTO} from "../shared/swagger/model/BenPubSupDTO";
import {BeneficiaryApi} from "../shared/swagger/api/BeneficiaryApi";
import {CallApi} from "../shared/swagger/api/CallApi";
import {CallDTO} from "../shared/swagger/model/CallDTO";

@Component({
    selector: 'selected-by-municipality',
    templateUrl: 'selected-by-municipality.component.html',
    providers: [SupplierApi, BeneficiaryApi, CallApi]
})
export class SelectedByMunicipalityComponent {
    private user: UserDTO;
    private municipalities: LegalEntityDTO[];
    private currentCall: CallDTO;
    private installationIds: number[];

    constructor(private localStorage: LocalStorageService, private supplierApi: SupplierApi, private beneficiaryApi: BeneficiaryApi, private callApi: CallApi) {
        this.installationIds = [];
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;

        this.callApi.allCalls().subscribe(
            calls => {
                this.currentCall = calls[0];
            }, error => {
                console.log(error);
                this.currentCall = null;
            }
        );


        if (this.user != null) {
            this.supplierApi.getSelectedMeBySupplierId(this.user.userTypeId).subscribe(
                data => {
                    this.municipalities = data;
                    for(let i = 0; i < this.municipalities.length; i++){
                        this.beneficiaryApi.findByBeneficiaryIdAndPublicationId(this.municipalities[i].legalEntityId, this.currentCall.callId).subscribe(
                            (result: BenPubSupDTO) => {
                                this.installationIds[i] = result.benPubSubId;
                            }, error =>{
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
    }


}

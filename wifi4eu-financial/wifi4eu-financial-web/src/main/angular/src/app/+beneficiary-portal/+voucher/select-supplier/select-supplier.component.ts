import {Component, Input} from "@angular/core";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {LegalEntityDTO, LegalEntityDTOBase} from "../../../shared/swagger/model/LegalEntityDTO";
import {SupplierDTO, SupplierDTOBase} from "../../../shared/swagger/model/SupplierDTO";
import {NutsDTO} from "../../../shared/swagger/model/NutsDTO";
import {SupplierApi} from "../../../shared/swagger/api/SupplierApi";
import {BeneficiaryApi} from "../../../shared/swagger/api/BeneficiaryApi";
import {CallApi} from "../../../shared/swagger/api/CallApi";
import {LocalStorageService} from "angular-2-local-storage";

@Component({selector: 'select-supplier-component', templateUrl: 'select-supplier.component.html', providers: [SupplierApi, BeneficiaryApi, CallApi]})
export class SelectSupplierComponent {
    private suppliers: SupplierDTOBase[];
    private selectedSupplier: SupplierDTOBase;
    private display: boolean;
    private user;
    @Input('publicationId') private publicationId;
    @Input('myMunicipality') private myMunicipality;
    //@Input('municipalityId') private municipalityId;

    constructor(private localStorage: LocalStorageService, private supplierApi: SupplierApi, private beneficiaryApi: BeneficiaryApi, private callApi: CallApi, private uxService: UxService) {
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        this.suppliers = [];
        this.selectedSupplier = new SupplierDTOBase();
        this.display = false;
        this.supplierApi.allSuppliers().subscribe(
            (suppliers: SupplierDTOBase[]) => {
                for (let i = 0; i < suppliers.length; i++) {
                    let countriesPart = suppliers[i].nutsIds.split(";");
                    for (let f = 0; f < countriesPart.length; f++) {
                        let regionPart = countriesPart[f].split(',');
                        for (let g = 0; g < regionPart.length; g++) {
                            if (regionPart[g] == this.myMunicipality.countryCode) {
                                this.suppliers.push(suppliers[i]);
                                break;
                            }
                        }
                    }
                }
            }, error => console.log(error)
        );
    }

    openModal() {
        this.display = true;
    }

    viewSupplierDetails(rowIndex: number) {
        this.selectedSupplier = this.suppliers[rowIndex];
        this.display = true;
    }

    selectSupplier() {
        if (this.selectedSupplier.supplierId == null) {
            this.uxService.growl({
                severity: 'warn',
                summary: 'WARNING',
                detail: 'You have to select a supplier first.'
            });
        } else {
            if (this.user != null) {
                this.beneficiaryApi.selectSupplier(this.myMunicipality.legalEntityId, this.publicationId, this.selectedSupplier.supplierId).subscribe(
                    data => {
                        this.uxService.growl({
                            severity: 'success',
                            summary: 'SUCCESS',
                            detail: 'You selected ' + this.selectedSupplier.name + ' as your supplier.'
                        });
                        this.display = false;
                    }, error => {
                        console.log(error);
                        this.display = false;
                    }
                );
            }
        }
    }

}

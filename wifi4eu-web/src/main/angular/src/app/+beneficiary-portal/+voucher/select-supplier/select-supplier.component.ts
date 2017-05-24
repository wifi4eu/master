import {Component, Input} from "@angular/core";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {SupplierDTO, SupplierDTOBase} from "../../../shared/swagger/model/SupplierDTO";
import {SupplierApi} from "../../../shared/swagger/api/SupplierApi";
import {BeneficiaryApi} from "../../../shared/swagger/api/BeneficiaryApi";
import {CallApi} from "../../../shared/swagger/api/CallApi";
import {LocalStorageService} from "angular-2-local-storage";

@Component({selector: 'select-supplier-component', templateUrl: 'select-supplier.component.html', providers: [SupplierApi, BeneficiaryApi, CallApi]})
export class SelectSupplierComponent {
    private suppliers: SupplierDTOBase[];
    private selectedSuppliers: SupplierDTOBase[];
    private selectedSupplier: SupplierDTOBase;
    private display: boolean;
    private user;
    @Input('publicationId') private publicationId;
    @Input('municipalityId') private municipalityId;

    constructor(private localStorage: LocalStorageService, private supplierApi: SupplierApi, private beneficiaryApi: BeneficiaryApi, private callApi: CallApi, private uxService: UxService) {
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        this.selectedSupplier = new SupplierDTOBase();
        this.display = false;
        this.supplierApi.allSuppliers().subscribe(
            suppliers => this.suppliers = suppliers,
            error => console.log(error)
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
        if (this.user != null) {
            this.beneficiaryApi.selectSupplier(this.municipalityId, this.publicationId, this.selectedSupplier.supplierId).subscribe(
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

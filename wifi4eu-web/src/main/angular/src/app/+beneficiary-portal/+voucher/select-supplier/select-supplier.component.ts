import {Component} from "@angular/core";
import {SupplierDTO, SupplierDTOBase} from "../../../shared/swagger/model/SupplierDTO";
import {SupplierApi} from "../../../shared/swagger/api/SupplierApi";
import {BeneficiaryApi} from "../../../shared/swagger/api/BeneficiaryApi";
import {LocalStorageService} from "angular-2-local-storage";

@Component({templateUrl: 'select-supplier.component.html', providers: [SupplierApi, BeneficiaryApi]})
export class SelectSupplierComponent {
    private suppliers: SupplierDTOBase[];
    private selectedSuppliers: SupplierDTOBase[];
    private selectedSupplier: SupplierDTOBase;
    private display: boolean;
    private publicationId;
    private user;

    constructor(private localStorage: LocalStorageService, private supplierApi: SupplierApi, private beneficiaryApi: BeneficiaryApi) {
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        // The Publication Call id is hardcoded now, but we should remove it later.
        this.publicationId = 201;
        this.selectedSupplier = new SupplierDTOBase();
        this.display = false;
        this.supplierApi.allSuppliers().subscribe(
            suppliers => this.suppliers = this.checkIfNull(suppliers),
            error => console.log(error)
        );
    }

    openModal() {
        this.display = true;
    }

    formatTimestamp(timestamp) {
        let date = new Date(timestamp);
        return date.getDate() + "/" + (date.getMonth() + 1) + "/" + date.getFullYear() + " " + date.getHours() + ":" + ((date.getMinutes() < 10) ? ("0" + date.getMinutes()) : date.getMinutes());
    }

    viewSupplierDetails(rowIndex: number) {
        this.selectedSupplier = this.suppliers[rowIndex];
        this.display = true;
    }

    checkIfNull(suppliers: SupplierDTOBase[]) {
        return suppliers;
    }

    selectSupplier() {
        if (this.user != null) {
            this.beneficiaryApi.selectSupplier(this.user.userTypeId, this.publicationId, this.selectedSupplier.supplierId).subscribe(
                data => {
                    console.log(data);
                    this.display = false;
                }, error => {
                    console.log(error);
                    this.display = false;
                }
            );
        }
    }

}

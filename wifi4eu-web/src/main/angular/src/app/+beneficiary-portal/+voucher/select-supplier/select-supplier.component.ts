import {Component} from "@angular/core";
import {SupplierDTO, SupplierDTOBase} from "../../../shared/swagger/model/SupplierDTO";
import {SupplierApi} from "../../../shared/swagger/api/SupplierApi";

@Component({templateUrl: 'select-supplier.component.html', providers: [SupplierApi]})
export class SelectSupplierComponent {
    private suppliers: SupplierDTOBase[];
    private selectedSuppliers: SupplierDTOBase[];
    private selectedSupplier: SupplierDTOBase;
    private display: boolean;

    constructor(private supplierApi: SupplierApi) {
        this.display = false;
        this.supplierApi.allSuppliers().subscribe(
            suppliers => this.suppliers = this.checkIfNull(suppliers),
            error => console.log(error)
        );
        this.selectedSupplier = new SupplierDTOBase();
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

}

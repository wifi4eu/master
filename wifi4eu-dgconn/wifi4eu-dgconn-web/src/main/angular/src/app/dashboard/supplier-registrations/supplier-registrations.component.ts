import { Component } from "@angular/core";
import { SupplierApi } from "../../shared/swagger/api/SupplierApi";
import { SupplierDTOBase } from "../../shared/swagger/model/SupplierDTO";

@Component({
    templateUrl: 'supplier-registrations.component.html', providers: [SupplierApi]
})

export class DgConnSupplierRegistrationsComponent {
    private suppliers: SupplierDTOBase[] = [];
    private numRegistrations: number[] = [];
    private displayedSuppliers: SupplierDTOBase[] = [];
    private searchSuppliersInput: string = '';

    constructor(private supplierApi: SupplierApi) {
        this.supplierApi.allSuppliers().subscribe(
            (suppliers: SupplierDTOBase[]) => {
                for (let i = 0; i < suppliers.length; i++) {
                    this.supplierApi.findSimilarSuppliers(suppliers[i].id).subscribe(
                        (similarSuppliers: SupplierDTOBase[]) => {
                            if (similarSuppliers != null) {
                                this.numRegistrations.push(1 + similarSuppliers.length);
                                this.suppliers.push(suppliers[i]);
                                this.displayedSuppliers.push(suppliers[i]);
                            }
                        }
                    );
                }
            }
        );
    }

    private searchSuppliers() {
        if (this.searchSuppliersInput.length > 0) {
            this.displayedSuppliers = [];
            for (let supplier of this.suppliers) {
                if (supplier.name.toLowerCase().indexOf(this.searchSuppliersInput.toLowerCase()) != -1 ||
                    supplier.website.toLowerCase().indexOf(this.searchSuppliersInput.toLowerCase()) != -1 ||
                    supplier.vat.toLowerCase().indexOf(this.searchSuppliersInput.toLowerCase()) != -1) {
                    this.displayedSuppliers.push(supplier);
                }
            }
        } else {
            this.displayedSuppliers = this.suppliers;
        }
    }
}
import {Component, Input, IterableDifferFactory} from "@angular/core";
import {LauApi} from "../../shared/swagger/api/LauApi";

import {SelectItem} from "primeng/primeng";
import {SupplierApi} from "../../shared/swagger/api/SupplierApi";
import {SupplierDTO} from "../../shared/swagger/model/SupplierDTO";


@Component({
    templateUrl: 'supplier-registrations.component.html', providers: [SupplierApi, LauApi]
})

export class DgConnSupplierRegistrationsComponent {
    private suppliers: Array<Object>;
    private status: SelectItem[];
    private selectStatus: any[];
    private finalStatus: Array<String> = new Array<String>();
    private rowRegions: string[];


    constructor(private supplierApi: SupplierApi, private lauApi: LauApi) {

        this.selectStatus = [];
        this.status = [];
        this.status.push({label: 'Undefined', value: {id: 1, name: 'Undefined', code: 'UF'}});
        this.status.push({label: 'Active', value: {id: 2, name: 'Active', code: 'OK'}});
        this.status.push({label: 'Declined', value: {id: 3, name: 'Declined', code: 'KO'}});
        this.suppliers = [];


        this.supplierApi.allSuppliers().subscribe(
            (suppliers: SupplierDTO[]) => {
                let countriesCountArray = [];
                for (let supplier of suppliers) {
                    let tableRow = {
                        name: supplier.name,
                        nuts: supplier.nutsIds.split(';')[1],
                        address: supplier.address,
                        status: this.status,
                        duplicated: false,
                        supplier: supplier
                    };

                    let nutsParts = tableRow['nuts'].split(',');

                    for (let i = 0; i < this.suppliers.length; i++) {
                        for (let nutsPart of nutsParts) {
                            if (this.suppliers[i]['nuts'].search(nutsPart) != -1 && tableRow['name'] == this.suppliers[i]['name']) {
                                let editedRow = this.suppliers[i];
                                tableRow['duplicated'] = true;
                                editedRow['duplicated'] = true;
                                this.suppliers[i] = editedRow;
                            }
                        }
                    }
                    this.suppliers.push(tableRow);
                }
            }
        );
    }


    uploadData(index: number) {
        let updateSupplier: SupplierDTO = this.suppliers[index]['supplier'];
        updateSupplier.status = this.selectStatus[index]['code'];
        this.supplierApi.saveSupplier(updateSupplier).subscribe(
            result => {
            }, error => {
                console.log(error);
            }
        );
    }
}

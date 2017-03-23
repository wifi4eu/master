import {Component} from "@angular/core";
import {TimelineComponent} from '../shared/components/timeline/timeline.component';
import {CustomTimelineAccordionBoxComponent} from "../shared/components/timeline/custom-timeline-accordion-box.component";
import {SupplierDTO, SupplierDTOBase} from '../shared/swagger/model/SupplierDTO';
import {CompanyDTO, CompanyDTOBase} from '../shared/swagger/model/CompanyDTO';
import {ContactPersonDTO, ContactPersonDTOBase} from '../shared/swagger/model/ContactPersonDTO';
import {SupplierApi} from '../shared/swagger/api/SupplierApi';

@Component({templateUrl: 'supplier-portal.component.html', providers: [SupplierApi]})
export class SupplierPortalComponent {
    private suppliers: SupplierDTO[];
    private selectedSuppliers: SupplierDTO[];
    private selectedSupplier: SupplierDTOBase;
    private display: boolean;

    constructor(private supplierApi: SupplierApi) {
        this.display = false;
        this.supplierApi.allSuppliers().subscribe(
            suppliers => this.suppliers = this.checkIfNull(suppliers),
            error => console.log(error)
        );
        this.selectedSupplier = new SupplierDTOBase();
        this.selectedSupplier.companyDTO = new CompanyDTOBase();
        this.selectedSupplier.contactPersonDTO = new ContactPersonDTOBase();
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
        for (let i = 0; i++; i < suppliers.length) {
            if (suppliers[i].contactPersonDTO == null) {
                suppliers[i].contactPersonDTO = new ContactPersonDTOBase();
            }
            if (suppliers[i].companyDTO == null) {
                suppliers[i].companyDTO = new CompanyDTOBase();
            }
        }
        return suppliers;
    }

}

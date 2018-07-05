import { Component } from "@angular/core";
import { SupplierApi } from "../../../shared/swagger/api/SupplierApi";
import { UserDTOBase } from "../../../shared/swagger/model/UserDTO";
import { SupplierDTOBase } from "../../../shared/swagger/model/SupplierDTO";
import { SharedService } from "../../../shared/shared.service";

@Component({
    selector: 'supplier-edit-profile',
    templateUrl: 'edit-profile.component.html',
    styleUrls: ['edit-profile.component.scss'],
    providers: [SupplierApi]
})

export class SupplierEditProfileComponent {
    private user: UserDTOBase;
    private supplier: SupplierDTOBase;
    private websitePattern: string = "(([wW][wW][wW]\\.)|([hH][tT][tT][pP][sS]?:\\/\\/([wW][wW][wW]\\.)?))?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,256}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";
    private allDataFetched: boolean = false;

    constructor(private sharedService: SharedService, private supplierApi: SupplierApi) {
        let allow = true;
        if (this.sharedService.user) {
            this.user = this.sharedService.user;
            this.getSupplierData();
        } else {
            this.sharedService.loginEmitter.map(() => {
                this.user = this.sharedService.user;
                this.getSupplierData();
            });
        }
    }

    private getSupplierData() {
        this.supplierApi.getSupplierByUserId(this.user.id).subscribe(
            (supplier: SupplierDTOBase) => {
                if (supplier != null) {
                    this.supplier = supplier;
                }
            }
        );
    }
}
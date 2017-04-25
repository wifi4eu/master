import {Component} from "@angular/core";
import {InstallationDTOBase} from "../../shared/swagger/model/InstallationDTO";
import {SupplierApi} from "../../shared/swagger/api/SupplierApi";
import {LocalStorageService} from "angular-2-local-storage";

@Component({templateUrl: 'supplier-installation.component.html', providers: [SupplierApi]})

export class SupplierInstallationComponent {
    private installations: InstallationDTOBase[];
    private selectedInstallations: InstallationDTOBase[];
    private bidding: InstallationDTOBase;
    private user;

    constructor(private localStorage: LocalStorageService, private supplierApi: SupplierApi) {
        this.bidding = new InstallationDTOBase();
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        if (this.user != null) {
            this.supplierApi.getInstallationBySupplierId(this.user.userTypeId).subscribe(
                installation => {
                    this.bidding = installation;
                },
                error => {
                    console.log(error);
                }
            );
        }
    }
}


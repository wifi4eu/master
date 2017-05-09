import {Component} from "@angular/core";
import {InstallationDTOBase} from "../../shared/swagger/model/InstallationDTO";
import {SupplierApi} from "../../shared/swagger/api/SupplierApi";
import {LocalStorageService} from "angular-2-local-storage";
import {AccessPointDTOBase} from "../../shared/swagger/model/AccessPointDTO";

@Component({templateUrl: 'supplier-installation.component.html', providers: [SupplierApi]})

export class SupplierInstallationComponent {
    private installation: InstallationDTOBase;
    private selectedAccesPoints: AccessPointDTOBase[];
    private installationId: number;
    private user: string;

    constructor(private localStorage: LocalStorageService, private supplierApi: SupplierApi) {
        // The 'installationId' is hardcoded right now, but we should delete this next statement when we can.
        this.installationId = 4;
        this.installation = new InstallationDTOBase();
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        if (this.user != null) {
            this.supplierApi.getInstallationById(this.installationId).subscribe(
                installation => {
                    if (installation != null) {
                        this.installation = installation;
                    }
                },
                error => {
                    console.log(error);
                }
            );
        }
    }
}


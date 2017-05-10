import {Component} from "@angular/core";
import {InstallationDTOBase} from "../../shared/swagger/model/InstallationDTO";
import {SupplierApi} from "../../shared/swagger/api/SupplierApi";
import {LocalStorageService} from "angular-2-local-storage";
import {AccessPointDTOBase} from "../../shared/swagger/model/AccessPointDTO";
import {ActivatedRoute} from "@angular/router";

@Component({templateUrl: 'supplier-installation.component.html', providers: [SupplierApi]})

export class SupplierInstallationComponent {
    private installation: InstallationDTOBase;
    private selectedAccesPoints: AccessPointDTOBase[];
    private installationId: number;
    private user: string;
    private displayModal: boolean;
    private newAccessPoint: AccessPointDTOBase;

    constructor(private localStorage: LocalStorageService, private supplierApi: SupplierApi, private route: ActivatedRoute) {
        this.newAccessPoint = new AccessPointDTOBase();
        this.route.params.subscribe(params => this.installationId = params['id']);
        this.installation = new InstallationDTOBase();
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
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

    addNewElement() {
        this.displayModal = true;
    }

    closeModal() {
        this.displayModal = false;
        this.newAccessPoint = new AccessPointDTOBase();
    }

    createInstallation() {
        this.supplierApi.createAccessPoint(this.newAccessPoint).subscribe(
            response => {
                this.installation.accessPoints.push(response);
                this.displayModal = false;
                this.newAccessPoint = new AccessPointDTOBase();
            }, error => {
                console.log(error);
            }
        );
    }
}


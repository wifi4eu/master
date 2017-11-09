import {Component} from "@angular/core";
// import {InstallationDTOBase} from "../../shared/swagger/model/InstallationDTO";
import {LauApi} from "../../shared/swagger/api/LauApi";
import {SupplierApi} from "../../shared/swagger/api/SupplierApi";
import {LocalStorageService} from "angular-2-local-storage";
// import {AccessPointDTOBase} from "../../shared/swagger/model/AccessPointDTO";
import {ActivatedRoute} from "@angular/router";
import {UserDTO} from "../../shared/swagger/model/UserDTO";
import {LauDTO} from "../../shared/swagger/model/LauDTO";
import {ResponseDTO} from "../../shared/swagger/model/ResponseDTO";

@Component({templateUrl: 'supplier-installation.component.html', providers: [SupplierApi, LauApi]})

export class SupplierInstallationComponent {
    //TODO:Create Entity Installation and AccessPoint
    // private installation: InstallationDTOBase;
    // private selectedAccesPoints: AccessPointDTOBase[];
    private installationId: number;
    private user: UserDTO;
    private displayModal: boolean;
    // private newAccessPoint: AccessPointDTOBase;
    private municipalityName: string = '';
    private outdoorCount: number;
    private indoorCount: number;

    constructor(private localStorage: LocalStorageService, private supplierApi: SupplierApi, private lauApi: LauApi, private route: ActivatedRoute) {
        this.route.params.subscribe(params => this.installationId = params['id']);
        // this.installation = new InstallationDTOBase();
        //this.newAccessPoint = new AccessPointDTOBase();
        //this.newAccessPoint.installationId = this.installationId;
        this.outdoorCount = 0;
        this.indoorCount = 0;

        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;

        // this.supplierApi.getInstallationById(this.installationId).subscribe(
        //     installation => {
        //         if (installation != null) {
        //             this.installation = installation;
        //             for (let i = 0; i < this.installation.accessPoints.length; i++) {
        //                 if (this.installation.accessPoints[i].indoor) {
        //                     this.indoorCount++;
        //                 } else {
        //                     this.outdoorCount++;
        //                 }
        //             }
        //             this.supplierApi.getLegalEntityByInstallationId(this.installationId).subscribe(
        //                 (municipality: LegalEntityDTO) => {
        //                     this.lauApi.findLauByLau2AndCountryCode(municipality.municipalityCode, municipality.countryCode).subscribe(
        //                         (lau: LauDTO) => {
        //                             this.municipalityName = lau.name1;
        //                         }
        //                     );
        //                 }
        //             )
        //         }
        //     },
        //     error => {
        //         console.log(error);
        //     }
        // );
    }

    addNewElement() {
        this.displayModal = true;
    }

    closeModal() {
        this.displayModal = false;
        //this.newAccessPoint = new AccessPointDTOBase();
        //this.newAccessPoint.installationId = this.installationId;
    }

    createInstallation() {
        // this.supplierApi.createAccessPoint(this.newAccessPoint).subscribe(
        //     (response: ResponseDTO) => {
        //         this.installation.accessPoints.push(response.data);
        //         this.displayModal = false;
        //         this.newAccessPoint = new AccessPointDTOBase();
        //         this.newAccessPoint.installationId = this.installationId;

        //         if (response.data.indoor) {
        //             this.indoorCount++;
        //         } else {
        //             this.outdoorCount++;
        //         }

        //     }, error => {
        //         console.log(error);
        //     }
        // );
    }
}


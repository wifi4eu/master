import {Component, Input, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from "@angular/router";
import {Location} from '@angular/common';
import {BeneficiaryDisplayedListDTOBase} from "../../shared/swagger/model/BeneficiaryDisplayedListDTO";
import {AccessPointBase} from "../../shared/swagger/model/AccessPoint";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";
import {ErrorHandlingService} from "../../core/services/error.service";
import {BeneficiaryService} from "../../core/services/beneficiary-service";
import {AccesspointsApi} from "../../shared/swagger/api/AccesspointsApi";
import {InstallationsiteApi} from "../../shared/swagger/api/InstallationsiteApi";
import {MunicipalityApi} from "../../shared/swagger/api/MunicipalityApi";
import { SharedService } from '../../shared/shared.service';


@Component({
    templateUrl: './access-point-details.component.html',
    providers: [ ErrorHandlingService, AccesspointsApi, InstallationsiteApi, MunicipalityApi]
})
export class AccessPointDetailsComponent implements OnInit {

    private beneficiary: BeneficiaryDisplayedListDTOBase = new BeneficiaryDisplayedListDTOBase;
    private installationSiteName: string;

    private accessPoint: AccessPointBase = new AccessPointBase();
    private accessPoints;
    //observable that gets the id from route params
    private idSub: any;
    private number: String;
    private locationType: String;
    private locationAP: String;
    private latitude: String;
    private longitude: String;
    private indoor: boolean = false;
    private outdoor: boolean = false;
    private deviceBrand: String;
    private modelNumber: String;
    private serialNumber: String;
    private macAddress: String;
    private municipalityName: String;
    private installationSite: number;

    constructor(private uxService: UxService, private router: Router, private location: Location, private route: ActivatedRoute,
                private beneficiaryService: BeneficiaryService, private accessPointService: AccesspointsApi, private sharedService: SharedService,
                private errorHandlingService: ErrorHandlingService, private installationsiteApi: InstallationsiteApi, private municipalityApi: MunicipalityApi) {
        let id;
        if (this.beneficiaryService.beneficiarySelected != undefined) {
            this.municipalityName = this.beneficiaryService.beneficiarySelected.name;
        } else {
            this.router.navigateByUrl('/home');
            this.sharedService.growlTranslation('You are not logged in!', 'error.404.AccessPointNotFound', 'warn');
        }
        this.route.params.subscribe(params => id = params['id']);
        this.accessPointService.getAccessPointById(id).subscribe(
            accessPoint => {
                this.accessPoints = accessPoint['data'];
                this.number = this.accessPoints['number'];
                this.locationType = this.accessPoints['locationType'];
                this.locationAP = this.accessPoints['location'];
                this.latitude = this.accessPoints['latitude'];
                this.longitude = this.accessPoints['longitude'];
                this.indoor = this.accessPoints['indoor'];
                this.deviceBrand = this.accessPoints['deviceBrand'];
                this.modelNumber = this.accessPoints['modelNumber'];
                this.macAddress = this.accessPoints['macAddress'];
                this.serialNumber = this.accessPoints['serialNumber'];
                this.installationSite = this.accessPoints['idInstallationSite'];
                this.installationsiteApi.getInstallationSite(this.installationSite).subscribe(
                    installation => {
                        this.installationSiteName = installation['data'].name;
                    }, error => {
                        console.log(error);
                    }
                );

            }, error => {
            }
        );

    }

    ngOnInit() {
        this.route.data.subscribe((data: { accessPoint: AccessPointBase }) => {
            if (data.accessPoint)
                this.accessPoint = data.accessPoint;
        }, error => {
            console.log(error);
            return this.errorHandlingService.handleError(error);
        });
    }

    goBack() {
        this.location.back()
    }

}

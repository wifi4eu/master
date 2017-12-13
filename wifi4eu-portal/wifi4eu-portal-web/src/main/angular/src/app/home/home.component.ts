import {Component} from "@angular/core";
import {MunicipalityDTO, MunicipalityDTOBase} from "../shared/swagger/model/MunicipalityDTO";
import {MunicipalityApi} from "../shared/swagger/api/MunicipalityApi";
import {SupplierApi} from "../shared/swagger/api/SupplierApi";
import {SuppliedRegionApi} from "../shared/swagger/api/SuppliedRegionApi";
import {UserDTO} from "../shared/swagger/model/UserDTO";
import {CallDTOBase} from "../shared/swagger/model/CallDTO";
import {SupplierDTO, SupplierDTOBase} from "../shared/swagger/model/SupplierDTO";
import {LocalStorageService} from "angular-2-local-storage";
import {CallApi} from "../shared/swagger/api/CallApi";

@Component({
    selector: 'app-home',
    templateUrl: 'home.component.html',
    providers: [MunicipalityApi, SuppliedRegionApi, CallApi, SupplierApi]
})
export class HomeComponent {
    // private municipalities: MunicipalityDTOBase[] = [];
    private municipalitiesCounter: number;
    private suppliersCounter: number;
    private voucherCompetitionState: number;
    private user: UserDTO;
    private currentCall: CallDTOBase;
    private dateNumber: string;
    private hourNumber: string;
    private supplierInfo: SupplierDTO;
    private municipalitiesThatSelectedMe: MunicipalityDTO[];
    private showTimeline: boolean = false;


    private errorCause: string;

    constructor(private municipalityApi: MunicipalityApi, private suppliedRegionApi: SuppliedRegionApi, private localStorage: LocalStorageService, private callApi: CallApi, private supplierApi: SupplierApi) {
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        this.currentCall = new CallDTOBase();
        this.supplierInfo = new SupplierDTOBase();
        this.municipalitiesThatSelectedMe = [];

        this.municipalityApi.getMunicipalitiesGroupedByLauId().subscribe(
            municipalities => {
                this.municipalitiesCounter = municipalities.length;
            }, error => {
                console.log(error);
            }
        );


        this.suppliedRegionApi.getSuppliedRegionsGroupedByRegionId().subscribe(
            suppliers => {
                this.suppliersCounter = suppliers.length;
            }, error => {
                console.log(error);
            }
        );

        this.checkForCalls();
    }

    checkForCalls() {
        this.callApi.allCalls().subscribe(
            calls => {
                console.log("CALLS", calls);
                console.log("call 0", calls[0]);
                this.currentCall = calls[0];
                this.showTimeline = true;
                //
                // var month = new Date(this.currentCall.startDate).getMonth();
                // console.log(month);
                // var day = new Date(this.currentCall.startDate).getDay();
                // console.log(day);
                // var year = new Date(this.currentCall.startDate).getFullYear();
                // console.log(year);
                //
                // this.dateNumber = month + "/" + day + "/" + year;
                // console.log("DATENUMBER;", this.dateNumber);
                //
                // // this.dateNumber = new Date(this.currentCall.startDate).toDateString();
                // this.hourNumber = new Date(this.currentCall.startDate).toTimeString();
                //
                // console.log("date ", this.dateNumber);
                // console.log("houur", this.hourNumber);
            }, error => {
                console.log(error);
                this.currentCall = null;
                this.voucherCompetitionState = 0;
            }
        );
    }

    checkIfSelected() {
        this.supplierApi.getSupplierByUserId(this.user.id).subscribe(
            (entities: MunicipalityDTO[]) => {
                if (entities.length > 0) {
                    this.municipalitiesThatSelectedMe = entities;
                    // Display the 'municipalities' screen
                    this.voucherCompetitionState = 3;
                } else {
                    this.voucherCompetitionState = 2;
                }
            }, error => {
                console.log(error);
                this.supplierInfo = null;
                this.voucherCompetitionState = -1;
                this.errorCause = "supplierportal.couldntgetselectedmunicipalities";
            }
        );
    }

}
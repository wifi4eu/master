import { Component } from "@angular/core";
import { MunicipalityApi } from "../shared/swagger/api/MunicipalityApi";
import { SupplierApi } from "../shared/swagger/api/SupplierApi";
import { UserDTOBase } from "../shared/swagger/model/UserDTO";
import { CallDTOBase } from "../shared/swagger/model/CallDTO";
import { LocalStorageService } from "angular-2-local-storage";
import { CallApi } from "../shared/swagger/api/CallApi";
import {ResponseDTOBase} from "../shared/swagger/model/ResponseDTO";

@Component({
    selector: 'app-home',
    templateUrl: 'home.component.html',
    providers: [MunicipalityApi, CallApi, SupplierApi]
})

export class HomeComponent {
    private municipalitiesCounter: number;
    private user: UserDTOBase;
    private currentCall: CallDTOBase;
    private dateNumber: string;
    private hourNumber: string;
    private showTimeline: boolean = false;
    private showTimer: boolean = false;

    constructor(private municipalityApi: MunicipalityApi, private localStorage: LocalStorageService, private callApi: CallApi, private supplierApi: SupplierApi) {
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        this.currentCall = new CallDTOBase();

        this.municipalityApi.getMunicipalitiesCountGroupedByLauId().subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.municipalitiesCounter = response.data.length;
                }
            }, error => {
                console.log(error);
            }
        );
        this.checkForCalls();
    }

    checkForCalls() {
        this.callApi.allCalls().subscribe(
            calls => {
                this.currentCall = calls[0];
                if (this.currentCall) {
                    this.showTimeline = true;
                    this.showTimer = true;
                    let date = new Date(this.currentCall.startDate);
                    this.dateNumber = ('0' + date.getUTCDate()).slice(-2) + "/" + ('0' + (date.getMonth() + 1)).slice(-2) + "/" + date.getFullYear();
                    this.hourNumber = ('0' + date.getHours()).slice(-2) + ":" + ('0' + date.getMinutes()).slice(-2);
                } else {
                    this.showTimeline = false;
                    this.showTimer = false;
                }
            }, error => {
                console.log(error);
                this.currentCall = null;
            }
        );
    }

    private hideTimer() {
        this.showTimer = false;
    }

    private goToTop() {
        window.scrollTo(0, 0);
    }

}
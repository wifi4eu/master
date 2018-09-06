import {Component} from "@angular/core";
import {MunicipalityApi} from "../shared/swagger/api/MunicipalityApi";
import {UserDTOBase} from "../shared/swagger/model/UserDTO";
import {CallDTOBase} from "../shared/swagger/model/CallDTO";
import {LocalStorageService} from "angular-2-local-storage";
import {CallApi} from "../shared/swagger/api/CallApi";
import {ResponseDTOBase} from "../shared/swagger/model/ResponseDTO";

@Component({
    selector: 'app-home',
    templateUrl: 'home.component.html',
    providers: [MunicipalityApi, CallApi]
})

export class HomeComponent {
    private municipalitiesCounter: number;
    private user: UserDTOBase;
    private currentCall: CallDTOBase;
    private dateNumber: string;
    private hourNumber: string;
    private showTimeline: boolean = false;
    private showTimer: boolean = false;
    private noCall: boolean = false;

    constructor(private municipalityApi: MunicipalityApi, private localStorage: LocalStorageService, private callApi: CallApi) {
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        this.currentCall = new CallDTOBase();

        this.municipalityApi.getMunicipalitiesCountGroupedByLauId().subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.municipalitiesCounter = response.data;
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
                if (this.currentCall.startDate > Date.now()) {
                    this.showTimeline = true;
                    this.showTimer = true;
                    let date = new Date(this.currentCall.startDate);
                    this.dateNumber = ('0' + date.getUTCDate()).toString().slice(-2) + "/" + ('0' + (date.getUTCMonth() + 1)).slice(-2) + "/" + date.getUTCFullYear();
                    this.hourNumber = ('0' + (date.getUTCHours() + 2)).toString().slice(-2) + ":" + ('0' + date.getUTCMinutes()).slice(-2);
                    this.noCall = false;
                } else if(this.currentCall.endDate > Date.now()) {
                    this.showTimeline = false;
                    this.showTimer = false;
                    this.noCall = false;
                } else {
                    this.showTimeline = false;
                    this.showTimer = false;
                    this.noCall = true;
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
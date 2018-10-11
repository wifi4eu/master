import {Component} from "@angular/core";
import {MunicipalityApi} from "../shared/swagger/api/MunicipalityApi";
import {UserDTOBase} from "../shared/swagger/model/UserDTO";
import {CallDTOBase} from "../shared/swagger/model/CallDTO";
import {LocalStorageService} from "angular-2-local-storage";
import {ResponseDTOBase} from "../shared/swagger/model/ResponseDTO";
import {CallcustomApi, CallCustomBase} from "../shared/swagger";
import { TranslateService } from "ng2-translate";

@Component({
    selector: 'app-home',
    templateUrl: 'home.component.html',
    providers: [MunicipalityApi, CallcustomApi]
})

export class HomeComponent {
    /*
    -- callState values --
    0 = There are no calls created
    1 = There is a call created, but not started. DISPLAY TIME
    2 & 3 = There is a call created, already started. DISPLAY CALL OPEN
    */
    private municipalitiesCounter: number;
    private user: UserDTOBase;
    private currentCall: CallCustomBase;
    private dateNumber: string;
    private hourNumber: string;
    private showTimer: boolean = false;
    private callState: number;

    constructor(private municipalityApi: MunicipalityApi, private localStorage: LocalStorageService, private callCustomApi: CallcustomApi, private translate: TranslateService) {

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
        this.detectIE();
    }

    checkForCalls() {
        this.callCustomApi.getCallForApply(new Date().getTime()).subscribe(
            (call: CallCustomBase) => {
                this.currentCall = call;
                if (this.currentCall) {
                    this.callState = this.currentCall.voucherCompetitionState;
                    if (this.callState >= 1) {
                        let date = new Date(this.currentCall.startDate);
                        this.dateNumber = ('0' + date.getUTCDate()).toString().slice(-2) + "/" + ('0' + (date.getUTCMonth() + 1)).slice(-2) + "/" + date.getUTCFullYear();
                        this.hourNumber = ('0' + (date.getUTCHours() + 2)).toString().slice(-2) + ":" + ('0' + date.getUTCMinutes()).slice(-2);
                        this.showTimer = true;
                    }
                } else {
                    this.callState = 0;
                    this.showTimer = false;
                }
            }, error => {
                this.callState = 0;
                this.showTimer = false;
            }
        );
    }

    private hideTimer() {
        this.showTimer = false;
    }

    private goToTop() {
        window.scrollTo(0, 0);
    }

    private detectIE() {
        let ua = window.navigator.userAgent;
        let msie = ua.indexOf('MSIE ');
        let trident = ua.indexOf('Trident/');

        if (msie >0 || trident >0){
            this.translate.get('shared.ie.alert').subscribe(
                (translation: any) => {
                    alert(translation);
                }
            )
        }
    }

}
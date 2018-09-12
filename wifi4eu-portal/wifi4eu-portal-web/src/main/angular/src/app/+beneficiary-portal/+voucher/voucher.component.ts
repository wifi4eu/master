import { Component } from '@angular/core';
import { CallcustomApi } from "../../shared/swagger/api/CallcustomApi";
import { CallCustomBase } from "../../shared/swagger/model/CallCustom";
import { UserDTOBase } from "../../shared/swagger/model/UserDTO";
import { LocalStorageService } from "angular-2-local-storage";
import { ConditionsAgreementApi } from "../../shared/swagger/api/ConditionsAgreementApi";
import { ConditionsAgreementDTOBase } from "../../shared/swagger/model/ConditionsAgreementDTO";
import { ResponseDTOBase } from "../../shared/swagger/model/ResponseDTO";
import { ApplyvoucherApi } from "../../shared/swagger/api/ApplyvoucherApi";
import { SharedService } from "../../shared/shared.service";
import { ActivatedRoute, Router } from "@angular/router";
import { Http, RequestOptions, Headers } from "@angular/http";
import { ApplyVoucherBase } from '../../shared/swagger/model/ApplyVoucher'
import { CookieService } from 'ngx-cookie-service';
import { environment } from '../../../environments/environment';
import * as moment from 'moment';
import 'moment-timezone';
import{ AppConstants} from '../../shared/constants/AppConstants';

@Component({
    templateUrl: 'voucher.component.html',
    providers: [CallcustomApi, ApplyvoucherApi, ConditionsAgreementApi]
})

export class VoucherComponent {
    /* 
    -- voucherCompetitionState values --
    0 = There are no calls created
    1 = There is a call created, but not started. DISPLAY TIMER
    2 = There is a call created, already started. You can 'Apply For Voucher'
    3 = Call created & started. You clicked 'Apply For Voucher' and are waiting for the approvement.
    */
    private voucherCompetitionState: number;
    private user: UserDTOBase;
    private currentCall: CallCustomBase = new CallCustomBase();
    private applyVouchersData: ApplyVoucherBase[] = [];
    private startDate: string;
    private startHour: string;
    private endDate: string;
    private endHour: string;
    private uploadDateTime = {};
    private uploadHourTime = {};
    private applyDateTime = {};
    private applyHourTime = {};
    private uploadDate: string[] = [];
    private uploadHour: string[] = [];
    private displayError = false;
    private displayCallClosed = false;
    private errorMessage = null;
    private rabbitmqURI: string = `${environment.applyVoucherUrl}/calls/`;
    private openedCalls: string = "";
    private voucherApplied: string = "";
    private csrfTokenCookieName: string = "XSRF-TOKEN";
    private nameCookieApply: string = "hasRequested";
    private allRequestCompleted = false;

    private httpOptions = {
        headers: new Headers({
            'Content-Type': 'application/json'
        })
    };

    constructor(private cookieService: CookieService, private callCustomApi: CallcustomApi, private router: Router, private route: ActivatedRoute, private applyVoucherApi: ApplyvoucherApi, private localStorage: LocalStorageService, private conditionsAgreementApi: ConditionsAgreementApi, private sharedService: SharedService, private http: Http) {
        let storedUser = this.localStorage.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        if (this.user != null) {
            this.callCustomApi.getCallForApply().subscribe(
                (call: CallCustomBase) => {
                    this.currentCall = call;
                    if (this.currentCall) {
                        this.voucherCompetitionState = this.currentCall.voucherCompetitionState;
                        if (this.voucherCompetitionState == 2) {
                            this.openedCalls = "greyImage";
                        }
                        this.loadVoucherData();
                    } else {
                        this.voucherCompetitionState = 0;
                        this.loadVoucherDataWithoutCall(-1);
                    }
                },
                error => {
                    this.voucherCompetitionState = 0;
                }
            );
        }
    }

    private isVoucherApplied(idRegistration: number) {
        if (this.cookieService.check(this.nameCookieApply + "_" + idRegistration)) {
            if (this.cookieService.get(this.nameCookieApply + "_" + idRegistration) == "true") {
                return true;
            }
        }
        return false;
    }

    private loadVoucherDataWithoutCall(callId) {
        this.allRequestCompleted = false;
        this.applyVoucherApi.getDataForApplyVoucherByUserIdAndCallId(this.user.id, callId)
            .finally(() => this.allRequestCompleted = true)
            .subscribe(
                (applyVoucher: ApplyVoucherBase[]) => {
                    this.applyVouchersData = applyVoucher;
                    for (let i = 0; i < this.applyVouchersData.length; i++) {
                        if (this.applyVouchersData[i].filesUploaded == 1) {
                            let uploaddate = new Date(this.applyVouchersData[i].uploadTime);
                            let applydate = new Date(this.applyVouchersData[i].applyTime)
                            this.uploadDateTime[this.applyVouchersData[i].idMunicipality] = ('0' + uploaddate.getUTCDate()).toString().slice(-2) + "/" + ('0' + (uploaddate.getMonth() + 1)).slice(-2) + "/" + uploaddate.getFullYear();
                            this.uploadHourTime[this.applyVouchersData[i].idMunicipality] = ('0' + uploaddate.getHours()).toString().slice(-2) + ":" + ('0' + uploaddate.getMinutes()).slice(-2);
                            this.applyDateTime[this.applyVouchersData[i].idMunicipality] = ('0' + applydate.getUTCDate()).toString().slice(-2) + "/" + ('0' + (applydate.getMonth() + 1)).slice(-2) + "/" + applydate.getFullYear();
                            this.applyHourTime[this.applyVouchersData[i].idMunicipality] = ('0' + applydate.getHours()).toString().slice(-2) + ":" + ('0' + applydate.getMinutes()).slice(-2);
                        }
                    }
                },
                error => {
                    this.sharedService.growlTranslation(
                        "An error occurred while trying to retrieve the data from the server. Please, try again later.",
                        "shared.error.api.generic",
                        "error"
                    );
                }
            );
    }
    private loadVoucherData() {
        this.allRequestCompleted = false;
        let startDateCall= moment(this.currentCall.startDate).tz(AppConstants.timezone);
        let endDateCall = moment(this.currentCall.endDate).tz(AppConstants.timezone);
        this.startDate = startDateCall.format("DD/MM/YYYY");
        this.startHour = startDateCall.format("HH:mm");
        this.endDate = endDateCall.format("DD/MM/YYYY");
        this.endHour = endDateCall.format("HH:mm");
        
        this.applyVoucherApi.getDataForApplyVoucherByUserIdAndCallId(this.user.id, this.currentCall.id)
            .finally(() => this.allRequestCompleted = true)
            .subscribe(
                (applyVoucher: ApplyVoucherBase[]) => {
                    this.applyVouchersData = applyVoucher;
                    for (let i = 0; i < this.applyVouchersData.length; i++) {
                        if (this.applyVouchersData[i].filesUploaded == 1) {
                            let uploaddate = new Date(this.applyVouchersData[i].uploadTime);
                            this.uploadDateTime[this.applyVouchersData[i].idMunicipality] = ('0' + uploaddate.getUTCDate()).toString().slice(-2) + "/" + ('0' + (uploaddate.getMonth() + 1)).slice(-2) + "/" + uploaddate.getFullYear();
                            this.uploadHourTime[this.applyVouchersData[i].idMunicipality] = ('0' + uploaddate.getHours()).toString().slice(-2) + ":" + ('0' + uploaddate.getMinutes()).slice(-2);
                        }
                    }
                },
                error => {
                    this.sharedService.growlTranslation(
                        "An error occurred while trying to retrieve the data from the server. Please, try again later.",
                        "shared.error.api.generic",
                        "error"
                    );
                }
            );
    }

    private goToDocuments(municipalityId: number) {
        this.router.navigate(['../additional-info/', municipalityId], { relativeTo: this.route });
    }

    private applyForVoucher(applyVoucher: ApplyVoucherBase) {
        // we just need to check this variable
        // voucherCompetitionState is 2 then call is open
        // or when timer component emits that has finished
        if (this.voucherCompetitionState != null && this.voucherCompetitionState != 0) {
            if (applyVoucher && applyVoucher.idRegistration && applyVoucher.idMunicipality && this.currentCall.id && this.user.id) {
                if (applyVoucher.conditionAgreement && applyVoucher.filesUploaded) {
                    let urlQueue = this.rabbitmqURI + this.currentCall.id + "/apply/" + applyVoucher.idRegistration + "/" + this.user.id + "/" + applyVoucher.idMunicipality;
                    // put the following code to set the cookie and test the validation with true or false values
                    // this.cookieService.set(this.nameCookieApply, 'true');
                    let headers = new Headers();
                    headers.append('X-XSRF-TOKEN', this.cookieService.get(this.csrfTokenCookieName));
                    this.http.get(urlQueue, { headers: headers }).subscribe(
                        data => {
                            this.cookieService.set(this.nameCookieApply + "_" + applyVoucher.idRegistration, 'true');
                            this.voucherApplied = "greyImage";
                            this.sharedService.growlTranslation(
                                "Your request for voucher has been submitted successfully. Wifi4Eu will soon let you know if you got a voucher for free wi-fi.",
                                "benefPortal.voucher.statusmessage5",
                                "success"
                            );
                        },
                        error => {
                            if (error.status == 401 && error._body === "Call is not active") {
                                this.displayCallClosed = true;
                            } else {
                                this.sharedService.growlTranslation(
                                    "An error occurred and your application could not be received.",
                                    "shared.registration.update.error",
                                    "error"
                                );
                            }
                            this.cookieService.set(this.nameCookieApply + "_" + applyVoucher.idRegistration, 'false');
                        }
                    );
                } else {
                    this.sharedService.growlTranslation(
                        "Please accept the conditions agreement and upload all the required documents to proceed with the apply for voucher",
                        "shared.registration.update.erroragreement",
                        "error"
                    );
                }
            } else {
                this.sharedService.growlTranslation(
                    "An error occurred and your application could not be received.",
                    "shared.registration.update.error",
                    "error"
                );
            }
        } else {
            this.sharedService.growlTranslation(
                "An error occurred and your application could not be received.",
                "shared.registration.update.error",
                "error"
            );
        }
    }

    private closeModal() {
        this.errorMessage = null;
        this.displayError = false;
        this.displayCallClosed = false;
    }

    private openApplyForVoucher() {
        this.voucherCompetitionState = 2;
    }

    private changeConditionsAgreement(applyVoucherData: ApplyVoucherBase) {
        let conditionsAgreement = new ConditionsAgreementDTOBase();
        conditionsAgreement.registrationId = applyVoucherData.idRegistration;
        applyVoucherData.conditionAgreement == 0 ? conditionsAgreement.status = 1 : conditionsAgreement.status = 0;
        this.conditionsAgreementApi.changeConditionsAgreementStatus(conditionsAgreement).subscribe(
            (data: ResponseDTOBase) => {
                if (data.success) {
                    for (let i = 0; i < this.applyVouchersData.length; i++) {
                        if (applyVoucherData.idRegistration == this.applyVouchersData[i].idRegistration) {
                            this.applyVouchersData[i].conditionAgreement = data.data;
                            break;
                        }
                    }
                    this.sharedService.growlTranslation('Your registration was successfully saved.', 'shared.registration.update.success', 'success');
                } else {
                    this.sharedService.growlTranslation('An error occurred and your registration could not be updated.', 'shared.registration.update.error', 'error');
                }
            }, error => {
                this.sharedService.growlTranslation('An error occurred and your registration could not be updated.', 'shared.registration.update.error', 'error');
            }
        );
    }

}

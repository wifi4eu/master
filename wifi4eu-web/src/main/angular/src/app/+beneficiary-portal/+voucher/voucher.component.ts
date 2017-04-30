import {Component, Output, ViewChild} from '@angular/core';
import {CallDTOBase} from "../../shared/swagger/model/CallDTO";
import {BeneficiaryApi} from "../../shared/swagger/api/BeneficiaryApi";
import {UserDTO} from "../../shared/swagger/model/UserDTO";
import {LocalStorageService} from "angular-2-local-storage";
import {CallApi} from "../../shared/swagger/api/CallApi";

@Component({
    templateUrl: 'voucher.component.html',
    providers: [BeneficiaryApi, CallApi]
})
export class VoucherComponent {
    private voucherCompetitionState: number;
    private currentCall: CallDTOBase;
    private user: UserDTO;

    constructor(private localStorage: LocalStorageService, private beneficiaryApi: BeneficiaryApi, private callApi: CallApi) {
        this.voucherCompetitionState = -1;
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        this.callApi.allCalls().subscribe(
            calls => {
                this.currentCall = calls[0];
                if (this.currentCall != null) {
                    this.voucherCompetitionState = 0;
                }
            },
            error => {
                console.log(error);
                this.currentCall = null;
                this.voucherCompetitionState = 3;
            }
        );
    }

    beginCompetition() {
        this.voucherCompetitionState = 1;
        this.checkIfAlreadyApplied();
    }

    applyForVoucher() {
        this.beneficiaryApi.apply(this.user.userTypeId, this.currentCall.callId).subscribe(
            data => {
                this.voucherCompetitionState = 2;
            },
            error => {
                console.log(error);
                this.voucherCompetitionState = 3;
            }
        );
    }

    checkIfAlreadyApplied() {
        this.beneficiaryApi.findIfApplied(this.user.userTypeId, this.currentCall.callId).subscribe(
            call => {
                if (call != null) {
                    this.voucherCompetitionState = 4;
                }
            },
            error => {
                console.log(error);
                this.voucherCompetitionState = 3;
            }
        );
    }
}
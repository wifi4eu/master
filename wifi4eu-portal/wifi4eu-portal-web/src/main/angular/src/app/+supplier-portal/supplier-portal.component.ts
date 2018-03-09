import {Component} from "@angular/core";
import {LocalStorageService} from "angular-2-local-storage";
import {UserDTOBase} from "../shared/swagger/model/UserDTO";
import {CallApi} from "../shared/swagger/api/CallApi";
import {CallDTOBase} from "../shared/swagger/model/CallDTO";

@Component({
    templateUrl: 'supplier-portal.component.html',
    providers: [CallApi]
})

export class SupplierPortalComponent {
    /* -- voucherCompetitionState values --
    0 = There are no calls created
    1 = There is a call created, but not started. DISPLAY TIMER
    2 = There is a call created, already started.
    3 = Call created & started. Someone has selected you as his supplier.
     */
    private voucherCompetitionState: number;
    private user: UserDTOBase;
    private currentCall: CallDTOBase = new CallDTOBase();

    constructor(private localStorage: LocalStorageService, private callApi: CallApi) {
        let storedUser = this.localStorage.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        // Check if there are Calls
        if (this.user != null) {
            this.checkForCalls();
        }
    }

    private checkForCalls() {
        this.callApi.allCalls().subscribe(
            calls => {
                if (calls[0] != null) {
                    this.currentCall = calls[0];
                    this.voucherCompetitionState = 1;
                } else {
                    this.currentCall = null;
                    this.voucherCompetitionState = 0;
                }
            },
            error => {
                console.log(error);
                this.currentCall = null;
                this.voucherCompetitionState = 0;
            }
        );
    }

    private openCall() {
        this.voucherCompetitionState = 0;
    }
}
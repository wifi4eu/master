import { Component } from '@angular/core';
import { animate, style, transition, trigger } from "@angular/animations";
import { SharedService } from "../../shared/shared.service";
import { ApplicationDTOBase } from "../../shared/swagger/model/ApplicationDTO";
import { CallApi } from "../../shared/swagger/api/CallApi";
import { CallDTOBase } from "../../shared/swagger/model/CallDTO";
import { RegistrationDTOBase } from "../../shared/swagger/model/RegistrationDTO";
import { UserDTOBase } from "../../shared/swagger/model/UserDTO";
import { BeneficiaryApi } from "../../shared/swagger/api/BeneficiaryApi";
import { UserHistoryActionDTOBase } from "../../shared/swagger/model/UserHistoryActionDTO";

@Component({
    templateUrl: 'my-history.component.html',
    providers: [CallApi, BeneficiaryApi],
    animations: [
        trigger(
            'enterSpinner', [
                transition(':enter', [
                    style({opacity: 0}),
                    animate('200ms', style({opacity: 1}))
                ]),
                transition(':leave', [
                    style({opacity: 1}),
                    animate('200ms', style({opacity: 0}))
                ])
            ]
        )
    ]
})

export class MyHistoryComponent {
    private user : UserDTOBase = null;
    private registrations : RegistrationDTOBase[] = [];
    private municipalities : string[] = [];
    private calls : CallDTOBase[] = [];
    private currentIndex : number = 0;
    private historyItems : UserHistoryActionDTOBase[][] = [];
    private fetchingData : boolean = false;
    private changingCalls : boolean = false;

    constructor(private sharedService: SharedService, private callApi: CallApi, private beneficiaryApi: BeneficiaryApi) {
        this.fetchingData = true;
        if (this.sharedService.user) {
            this.user = this.sharedService.user;
            this.fetchData();
        } else {
            this.sharedService.loginEmitter.map(() => {
                this.user = this.sharedService.user;
                this.fetchData();
            });
        }
    }

    private fetchData() {
        this.callApi.allCalls().subscribe(
            (calls : CallDTOBase[]) => {
                this.calls = calls;
                this.fetchHistoryData();
            }
        );
    }

    private fetchHistoryData() {
        this.beneficiaryApi.getUserHistoryActionsByUserIdAnCallId(this.user.id, this.calls[this.currentIndex].id).subscribe(
            (actions : UserHistoryActionDTOBase[]) => {
                for (let action of actions) {
                    if (this.municipalities.indexOf(action.municipality) == -1) {
                        this.municipalities.push(action.municipality);
                        this.historyItems[action.municipality] = [];
                    }
                    this.historyItems[action.municipality].push(action);
                }
                this.fetchingData = false;
                this.changingCalls = false;
            }
        );
    }

    private changeCall(event) {
        if (event['index'] != null) {
            let index = event['index'];
            if (this.calls[index]) {
                this.changingCalls = true;
                this.currentIndex = index;
                this.historyItems = [];
                this.municipalities = [];
                this.registrations = [];
                this.fetchHistoryData();
            }
        }
    }
}
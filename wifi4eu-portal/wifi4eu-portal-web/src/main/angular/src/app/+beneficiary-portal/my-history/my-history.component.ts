import { Component } from '@angular/core';
import { animate, style, transition, trigger } from "@angular/animations";
import { SharedService } from "../../shared/shared.service";
import { ApplicationApi } from "../../shared/swagger/api/ApplicationApi";
import { ApplicationDTOBase } from "../../shared/swagger/model/ApplicationDTO";
import { CallApi } from "../../shared/swagger/api/CallApi";
import { CallDTOBase } from "../../shared/swagger/model/CallDTO";
import { MunicipalityApi } from "../../shared/swagger/api/MunicipalityApi";
import { MunicipalityDTOBase } from "../../shared/swagger/model/MunicipalityDTO";
import { RegistrationApi } from "../../shared/swagger/api/RegistrationApi";
import { RegistrationDTOBase } from "../../shared/swagger/model/RegistrationDTO";
import { UserApi } from "../../shared/swagger/api/UserApi";
import { UserDTOBase } from "../../shared/swagger/model/UserDTO";

@Component({
    templateUrl: 'my-history.component.html',
    providers: [ApplicationApi, CallApi, MunicipalityApi],
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
    private municipalities : MunicipalityDTOBase[] = [];
    private calls : CallDTOBase[] = [];
    private currentIndex : number = 0;
    private historyItems = [];
    private fetchingData : boolean = false;

    constructor(private sharedService: SharedService, private applicationApi: ApplicationApi, private callApi: CallApi, private municipalityApi: MunicipalityApi, private registrationApi: RegistrationApi) {
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
        this.registrationApi.getRegistrationsByUserId(this.user.id, new Date().getTime()).subscribe(
            (registrations : RegistrationDTOBase[]) => {
                if (registrations.length > 0) {
                    for (let i = 0; i < registrations.length; i++) {
                        let registration = registrations[i];
                        this.municipalityApi.getMunicipalityById(registration.municipalityId).subscribe(
                            (municipality : MunicipalityDTOBase) => {
                                this.applicationApi.getApplicationByCallIdAndRegistrationId(this.calls[this.currentIndex].id, registration.id).subscribe(
                                    (application : ApplicationDTOBase) => {
                                        let historyItems = [];
                                        if (registration.uploadTime) {
                                            let historyItem = {
                                                action: "benefPortal.myHistory.actionPerformed.supportingDocumentsUploaded",
                                                date: registration.uploadTime
                                            }
                                            historyItems.push(historyItem);
                                        }
                                        if (application.id != 0) {
                                            let historyItem = {
                                                action: "benefPortal.myHistory.actionPerformed.applicationSubmitted",
                                                date: application.date
                                            }
                                            historyItems.push(historyItem);
                                        }
                                        this.historyItems.push(historyItems);
                                        this.municipalities.push(municipality);
                                        this.registrations.push(registration);
                                        if (this.registrations.length == registrations.length) {
                                            this.fetchingData = false;
                                        }
                                    }
                                );
                            }
                        );
                    }
                }
            }
        );
    }

    private changeCall(event) {
        if (event['index'] != null) {
            let index = event['index'];
            if (this.calls[index]) {
                this.currentIndex = index;
                this.historyItems = [];
                this.municipalities = [];
                this.registrations = [];
                this.fetchHistoryData();
            }
        }
    }
}
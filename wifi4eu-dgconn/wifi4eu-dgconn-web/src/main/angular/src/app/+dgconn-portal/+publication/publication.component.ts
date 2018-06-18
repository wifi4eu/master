import {Component, Input} from "@angular/core";
import {DgConnDetails} from "../dgconnportal-details.model";
import {CallDTO, CallDTOBase} from "../../shared/swagger/model/CallDTO";
import {CallApi} from "../../shared/swagger/api/CallApi";
import {VoucherManagementDTO} from "../../shared/swagger/model/VoucherManagementDTO";
import {SharedService} from "../../shared/shared.service";

@Component({
    templateUrl: 'publication.component.html', providers: [CallApi]
})

export class DgConnPublicationComponent {
    @Input('dgConnDetails') dgConnDetails: DgConnDetails;
    private event: string;
    private startDate: Date;
    private endDate: Date;
    private startTime: Date;
    private endTime: Date;
    private display: boolean;
    private calls: CallDTO[];
    private call: CallDTO;
    private newElementForm: boolean;
    private indexRow: number;
    private today: Date;
    private callId: number;
    private displayTable: boolean = false;
    private enableButton: boolean = false;
    private voucherManagements: VoucherManagementDTO[] = [];
    private voucherManagementsFirst: VoucherManagementDTO[] = [];
    private voucherManagementsSecond: VoucherManagementDTO[] = [];
    private editableField: boolean = false;

    constructor(private callApi: CallApi, private sharedService: SharedService) {
        this.display = false;
        this.dgConnDetails = new DgConnDetails();
        this.callApi.allCalls().subscribe(
            calls => {
                this.calls = calls;
                this.voucherManagements = this.calls[0].voucherManagements;
                this.displayTable = false;
                this.voucherManagementsFirst = [];
                this.voucherManagementsSecond = [];
                for (let i = 0; this.voucherManagements.length > i; i++) {
                    if (i < 15) {
                        this.voucherManagementsFirst.push(this.voucherManagements[i]);
                    } else {
                        this.voucherManagementsSecond.push(this.voucherManagements[i]);
                        this.displayTable = true;
                    }
                }

            },
            error => console.log(error)
        );
        this.newElementForm = false;
    }

    changeCall(event) {
        this.voucherManagementsFirst = [];
        this.voucherManagementsSecond = [];
        this.displayTable = false;
        this.voucherManagements = this.calls[event.index].voucherManagements;
        for (let i = 0; this.voucherManagements.length > i; i++) {
            if (i < 15) {
                this.voucherManagementsFirst.push(this.voucherManagements[i]);
            } else {
                this.voucherManagementsSecond.push(this.voucherManagements[i]);
                this.displayTable = true;
            }
        }

    }

    displayInfo(index) {
        this.call = this.calls[index];
        this.indexRow = index + 1;
        this.startTime = new Date(this.calls[index].startDate);
        this.endTime = new Date(this.calls[index].endDate);
        this.startDate = new Date(this.calls[index].startDate);
        this.endDate = new Date(this.calls[index].endDate);
        this.newElementForm = false;
        this.display = true;
        this.callId = this.calls[index].id;
        this.checkStartDate();
    }

    cancelPublication() {
        this.newElementForm = false;
        this.display = false;
    }
/*
    createPublication() {
        let call = (this.call) ? this.call : new CallDTOBase();
        let finalStartDate = this.startDate;
        let finalEndDate = this.endDate;
        call.event = this.event;
        finalStartDate.setHours(this.startTime.getHours());
        finalStartDate.setMinutes(this.startTime.getMinutes());
        call.startDate = finalStartDate.getTime();
        finalEndDate.setHours(this.endTime.getHours());
        finalEndDate.setMinutes(this.endTime.getMinutes());
        call.endDate = finalEndDate.getTime();

        this.callApi.createCall(call).subscribe(
            data => {
                this.callApi.allCalls().subscribe(
                    calls => {
                        this.calls = calls;
                        this.newElementForm = false;
                        this.display = false;
                    }, error => {
                        console.log(error);
                        this.newElementForm = false;
                        this.display = false;
                    }
                );
            },
            error => {
                console.log(error)
                this.newElementForm = false;
                this.display = false;
            }
        );
        this.call = null;
    }
*/
    checkStartDate() {
        this.today = new Date();
        if (this.startDate < this.today)
            this.editableField = true;
    }

    checkDate() {

        this.editableField = false;
        if (this.startDate && this.startDate) {
            let finalStartDate = this.startDate;
            let finalEndDate = this.endDate;
            finalStartDate.setHours(this.startTime.getHours());
            finalStartDate.setMinutes(this.startTime.getMinutes());
            finalEndDate.setHours(this.endTime.getHours());
            finalEndDate.setMinutes(this.endTime.getMinutes());

            let calendarEndDate = this.endDate.getTime();
            let calendarStartDate = this.startDate.getTime();
            let todayFormated = this.today.getTime();
            if (calendarEndDate > todayFormated) {
                if (calendarStartDate < calendarEndDate)
                    if (calendarStartDate < calendarEndDate) {
                        for (let i = 0; this.calls.length > i; i++) {
                            if (this.calls[i].id != this.callId) {
                                if (calendarStartDate < this.calls[i].startDate && calendarEndDate < this.calls[i].startDate) {
                                    this.enableButton = true;
                                } else {
                                    if (calendarStartDate > this.calls[i].endDate) {
                                        this.enableButton = true;
                                    } else {
                                        this.sharedService.growlTranslation('Wrong period for the call', 'dgConn.wrongDate1', 'warn');
                                        this.enableButton = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }

            } else {
                this.sharedService.growlTranslation('The end date must be later than today.', 'dgConn.wrongDate2', 'warn');
            }
        }
        this.checkStartDate();
    }
}

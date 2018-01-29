import {Component, Input} from "@angular/core";
import {DgConnDetails} from "../dgconnportal-details.model";
import {CallDTO, CallDTOBase} from "../../shared/swagger/model/CallDTO";
import {CallApi} from "../../shared/swagger/api/CallApi";

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

    constructor(private callApi: CallApi) {
        this.display = false;
        this.dgConnDetails = new DgConnDetails();
        this.callApi.allCalls().subscribe(
            calls => this.calls = calls,
            error => console.log(error)
        );
        this.newElementForm = false;
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
    }

    cancelPublication() {
        this.newElementForm = false;
        this.display = false;
    }

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

    checkDate() {
        if (this.startDate && this.startDate) {
            let finalStartDate = this.startDate;
            let finalEndDate = this.endDate;
            finalStartDate.setHours(this.startTime.getHours());
            finalStartDate.setMinutes(this.startTime.getMinutes());
            finalEndDate.setHours(this.endTime.getHours());
            finalEndDate.setMinutes(this.endTime.getMinutes());
            this.today = new Date();
            if (finalStartDate > this.today)
                return finalStartDate < finalEndDate;
        }
        return false;
    }
}

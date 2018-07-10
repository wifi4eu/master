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

    constructor(private callApi: CallApi) {
        this.display = false;
        this.dgConnDetails = new DgConnDetails();
        this.callApi.allCalls().subscribe(
            calls => this.calls = calls,
            error => console.log(error)
        );
        this.newElementForm = false;
    }

    addNewElement() {
        this.event = '';
        this.startDate = null;
        this.endDate = null;
        this.startTime = null;
        this.endTime = null;
        this.newElementForm = true;
        this.display = true;
        this.callApi.allCalls().subscribe(
            calls => this.calls = calls,
            error => console.log(error)
        );
    }

    displayInfo(rowData: CallDTO) {
        this.call = rowData;
        this.event = rowData.event;
        this.startTime = new Date(rowData.startDate);
        this.endTime = new Date(rowData.endDate);
        this.startDate = new Date(rowData.startDate);
        this.endDate = new Date(rowData.endDate);
        this.newElementForm = false;
        this.display = true;
        this.callApi.allCalls().subscribe(
            calls => this.calls = calls,
            error => console.log(error)
        );
    }

    deleteElement(rowData: number) {
        this.callApi.deleteCall(this.calls[rowData].id).subscribe(
            data => {
                this.callApi.allCalls().subscribe(
                    calls => this.calls = calls,
                    error => console.log(error)
                );
            },
            error => console.log(error)
        );
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
            return finalStartDate < finalEndDate;
        }
        return false;
    }
}
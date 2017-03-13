import {Component, Input} from "@angular/core";
import {DgConnDetails} from "../dgconnportal-details.model";
import {Call} from "../../shared/models/call-details.model";
import {CallDTO, CallDTOBase} from '../../shared/swagger/model/CallDTO';
import {CallApi} from '../../shared/swagger/api/CallApi';

@Component({
    templateUrl: 'publication.component.html', providers: [CallApi]
})

export class DgConnPublicationComponent {
    @Input('dgConnDetails') dgConnDetails: DgConnDetails;
    private display: boolean;
    private calls: CallDTOBase[];
    private selectedCall: Call;
    private originalCall: CallDTOBase;
    private index: number;
    private newElementForm: boolean;

    constructor(private callApi: CallApi) {
        this.display = false;
        this.dgConnDetails = new DgConnDetails();
        this.callApi.allCalls().subscribe(
            calls => this.calls = calls,
            error => console.log(error)
        );
        this.selectedCall = new Call();
        this.originalCall = new CallDTOBase();
        this.newElementForm = false;
    }

    addNewElement() {
        this.newElementForm = true;
        this.display = true;
        this.selectedCall = new Call();
        this.selectedCall.setCallId(null);
    }

    displayInfo(element: CallDTOBase, rowElement: number) {
        this.display = true;
        this.selectedCall = this.convertDTOToCall(element);
        this.index = rowElement;
    }

    cancelPublication() {
        this.newElementForm = false;
        this.display = false;
        this.callApi.allCalls().subscribe(
            calls => this.calls = calls,
            error => console.log(error)
        );
    }

    createPublication() {
        this.callApi.createCall(this.convertCallToDTO(this.selectedCall)).subscribe();
        this.newElementForm = false;
        this.display = false;
        this.callApi.allCalls().subscribe(
            calls => this.calls = calls,
            error => console.log(error)
        );
    }

    convertCallToDTO(call: Call) {
        console.log("call", call);
        let dto = new CallDTOBase();
        dto.callId = call.getCallId();
        dto.startDate = new Date(call.getStartDate());
        if (dto.startDate != null) {
            let startTime = call.getStartTime().split(":");
            dto.startDate.setHours(parseInt(startTime[0]));
            dto.startDate.setMinutes(parseInt(startTime[1]));
        }
        dto.endDate = new Date(call.getEndDate());
        if (dto.endDate != null) {
            let endTime = call.getEndTime().split(":");
            dto.endDate.setHours(parseInt(endTime[0]));
            dto.endDate.setMinutes(parseInt(endTime[1]));
        }
        dto.event = call.getEvent();
        return dto;
    }

    convertDTOToCall(dto: CallDTOBase) {
        let call = new Call();
        call.setCallId(dto.callId);
        call.setStartDate(new Date(dto.startDate));
        call.setEndDate(new Date(dto.endDate));
        if (dto.startDate != null) {
            call.setStartTime(call.getStartDate().getHours() + ":" + ((call.getStartDate().getMinutes() < 10) ? ("0" + call.getStartDate().getMinutes()) : call.getStartDate().getMinutes()));
        }
        if (dto.endDate != null) {
            call.setEndTime(call.getEndDate().getHours() + ":" + ((call.getEndDate().getMinutes() < 10) ? ("0" + call.getEndDate().getMinutes()) : call.getEndDate().getMinutes()));
        }
        call.setEvent(dto.event);
        return call;
    }

    formatTimestamp(timestamp) {
        let date = new Date(timestamp);
        return date.getDate() + "/" + (date.getMonth() + 1) + "/" + date.getFullYear() + " " + date.getHours() + ":" + ((date.getMinutes() < 10) ? ("0" + date.getMinutes()) : date.getMinutes());
    }

    keyPress(event: any) {
        const pattern = /[0-9\:]/;
        let inputChar = String.fromCharCode(event.charCode);

        if (!pattern.test(inputChar)) {
            event.preventDefault();
        }
    }
}
import {Component, Input, OnInit} from "@angular/core";
import {DgConnDetails} from "../dgconnportal-details.model";
import {Call} from "../../shared/models/call-details.model";
import {CallDTO, CallDTOBase} from "../../shared/swagger/model/CallDTO";
import {CallApi} from "../../shared/swagger/api/CallApi";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";

@Component({
    templateUrl: 'publication.component.html', providers: [CallApi]
})

export class DgConnPublicationComponent implements OnInit {
    @Input('dgConnDetails') dgConnDetails: DgConnDetails;
    private display: boolean;
    private calls: CallDTO[];
    private selectedCall: Call;
    private originalCall: CallDTO;
    private newElementForm: boolean;

    constructor(private callApi: CallApi, private uxService: UxService) {
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

    ngOnInit() {
        this.callApi.allCalls().subscribe(
            calls => this.calls = calls,
            error => console.log(error)
        );
    }

    addNewElement() {
        this.newElementForm = true;
        this.display = true;
        this.selectedCall = new Call();
        this.selectedCall.setCallId(null);
        this.callApi.allCalls().subscribe(
            calls => this.calls = calls,
            error => console.log(error)
        );
    }

    displayInfo(rowElement: number) {
        this.callApi.allCalls().subscribe(
            calls => {
                this.calls = calls;
                this.selectedCall = this.convertDTOToCall(this.calls[rowElement]);
                this.display = true;
            },
            error => console.log(error)
        );
    }

    deleteElement(rowElement: number) {
        this.callApi.deleteCall(this.calls[rowElement].callId).subscribe(
            data => {
                this.callApi.allCalls().subscribe(
                    calls => this.calls = calls
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
        this.callApi.createCall(this.convertCallToDTO(this.selectedCall)).subscribe(
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
    }

    convertCallToDTO(call: Call) {
        let dto = new CallDTOBase();
        dto.callId = call.getCallId();
        let startDate = new Date(call.getStartDate());
        if (startDate != null) {
            let startTime = call.getStartTime().split(":");
            startDate.setHours(parseInt(startTime[0]));
            startDate.setMinutes(parseInt(startTime[1]));
            dto.startDate = startDate.getTime();
        }
        let endDate = new Date(call.getEndDate());
        if (endDate != null) {
            let endTime = call.getEndTime().split(":");
            endDate.setHours(parseInt(endTime[0]));
            endDate.setMinutes(parseInt(endTime[1]));
            dto.endDate = endDate.getTime();
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
import {Component, Input} from "@angular/core";
import {DgConnDetails} from "../dgconnportal-details.model";
import {TimelineElement} from "../../shared/models/timeline-element.model";
import {TimelineDTO, TimelineDTOBase} from "../../shared/swagger/model/TimelineDTO";
import {TimelineApi} from "../../shared/swagger/api/TimelineApi";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";

@Component({
    templateUrl: 'timeline.component.html', providers: [TimelineApi]
})

export class DgConnTimelineComponent {
    @Input('dgConnDetails') dgConnDetails: DgConnDetails;
    private display: boolean;
    private timelines: TimelineDTO[];
    private selectedTimeline: TimelineElement;
    private originalTimeline: TimelineDTO;
    private newElementForm: boolean;


    constructor(private timelineApi: TimelineApi, private uxService: UxService) {
        this.display = false;
        this.dgConnDetails = new DgConnDetails();
        this.timelineApi.allTimelines().subscribe(
            timelines => this.timelines = timelines,
            error => console.log(error)
        );
        this.selectedTimeline = new TimelineElement();
        this.originalTimeline = new TimelineDTOBase();
        this.newElementForm = false;
    }

    addNewElement() {
        this.newElementForm = true;
        this.display = true;
        this.selectedTimeline = new TimelineElement();
        this.selectedTimeline.setTimelineId(null);
        this.timelineApi.allTimelines().subscribe(
            timelines => this.timelines = timelines,
            error => console.log(error)
        );
    }
    
    displayInfo(rowElement: number) {
        this.timelineApi.allTimelines().subscribe(
            timelines => {
                this.timelines = timelines;
                this.selectedTimeline = this.convertDTOToTimelineElement(this.timelines[rowElement]);
                this.display = true;
            },
            error => console.log(error)
        );
    }

    deleteElement(rowElement: number) {
        this.timelineApi.deleteTimeline(this.timelines[rowElement].timelineId).subscribe(
            data => {
                console.log("data: ", data);
                console.log("this.timelines[rowElement]:", this.timelines[rowElement]);
            },
            error => console.log(error)
        );
    }

    cancelPublication() {
        this.newElementForm = false;
        this.display = false;
    }

    createPublication() {
        this.timelineApi.createTimeline(this.convertTimelineElementToDTO(this.selectedTimeline)).subscribe(
            data => {
                this.newElementForm = false;
                this.display = false;
                if (data == "error") {
                    this.uxService.growl({
                        severity: 'error',
                        summary: 'ERROR',
                    });
                    console.log('ERROR: Could not login, with these user password');
                } else if (data == "success") {
                    this.uxService.growl({
                        severity: 'success',
                        summary: 'SUCCESS',
                    });
                }
            },
            error => console.log(error)
        );
    }

    convertTimelineElementToDTO(call: TimelineElement) {
        let dto = new TimelineDTOBase();
        dto.timelineId = call.getTimelineId();
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

    convertDTOToTimelineElement(dto: TimelineDTOBase) {
        let timeline = new TimelineElement();
        timeline.setTimelineId(dto.timelineId);
        timeline.setStartDate(new Date(dto.startDate));
        timeline.setEndDate(new Date(dto.endDate));
        if (dto.startDate != null) {
            timeline.setStartTime(timeline.getStartDate().getHours() + ":" + ((timeline.getStartDate().getMinutes() < 10) ? ("0" + timeline.getStartDate().getMinutes()) : timeline.getStartDate().getMinutes()));
        }
        if (dto.endDate != null) {
            timeline.setEndTime(timeline.getEndDate().getHours() + ":" + ((timeline.getEndDate().getMinutes() < 10) ? ("0" + timeline.getEndDate().getMinutes()) : timeline.getEndDate().getMinutes()));
        }
        timeline.setEvent(dto.event);
        return timeline;
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
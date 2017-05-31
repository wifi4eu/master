import {Component, Input} from "@angular/core";
import {DgConnDetails} from "../dgconnportal-details.model";
import {TimelineDTO, TimelineDTOBase} from "../../shared/swagger/model/TimelineDTO";
import {TimelineApi} from "../../shared/swagger/api/TimelineApi";

@Component({
    templateUrl: 'timeline.component.html', providers: [TimelineApi]
})

export class DgConnTimelineComponent {
    @Input('dgConnDetails') dgConnDetails: DgConnDetails;
    private event: string;
    private startDate: Date;
    private endDate: Date;
    private startTime: Date;
    private endTime: Date;
    private display: boolean;
    private timelines: TimelineDTO[];
    private timeline: TimelineDTO;
    private newElementForm: boolean;

    constructor(private timelineApi: TimelineApi) {
        this.display = false;
        this.dgConnDetails = new DgConnDetails();
        this.timelineApi.allTimelines().subscribe(
            timelines => this.timelines = timelines,
            error => console.log(error)
        );
        this.newElementForm = false;
        this.startDate = new Date();
        this.endDate = new Date();
        this.startTime = new Date();
        this.endTime = new Date();
    }

    addNewElement() {
        this.event = '';
        this.startDate = null;
        this.endDate = null;
        this.newElementForm = true;
        this.display = true;
        this.timelineApi.allTimelines().subscribe(
            timelines => this.timelines = timelines,
            error => console.log(error)
        );
    }

    displayInfo(rowData: TimelineDTO) {
        this.timeline = rowData;
        this.event = rowData.event;
        this.startTime = new Date(rowData.startDate);
        this.endTime = new Date(rowData.endDate);
        this.startDate = new Date(rowData.startDate);
        this.endDate = new Date(rowData.endDate);
        this.display = true;
    }

    deleteElement(rowData: number) {
        console.log("rowData:", rowData);
        this.timelineApi.deleteTimeline(this.timelines[rowData]).subscribe(
            data => {
                this.timelineApi.allTimelines().subscribe(
                    timelines => this.timelines = timelines,
                    error => console.log(error)
                );
            },
            error => console.log(error)
        );
    }

    cancelTimeline() {
        this.newElementForm = false;
        this.display = false;
    }

    createTimeline() {
        let timeline = (this.timeline) ? this.timeline : new TimelineDTOBase();
        timeline.event = this.event;
        let finalStartDate = this.startDate;
        finalStartDate.setHours(this.startTime.getHours());
        finalStartDate.setMinutes(this.startTime.getMinutes());
        timeline.startDate = finalStartDate.getTime();
        let finalEndDate = this.endDate;
        finalEndDate.setHours(this.endTime.getHours());
        finalEndDate.setMinutes(this.endTime.getMinutes());
        timeline.endDate = finalEndDate.getTime();

        this.timelineApi.createTimeline(timeline).subscribe(
            data => {
                this.newElementForm = false;
                this.display = false;
                this.timelineApi.allTimelines().subscribe(
                    timelines => this.timelines = timelines,
                    error => console.log(error)
                );
            },
            error => console.log(error)
        );
        this.timeline = null;
    }

    checkDate() {
        let finalStartDate = this.startDate;
        finalStartDate.setHours(this.startTime.getHours());
        finalStartDate.setMinutes(this.startTime.getMinutes());
        let finalEndDate = this.endDate;
        finalEndDate.setHours(this.endTime.getHours());
        finalEndDate.setMinutes(this.endTime.getMinutes());
        return finalStartDate < finalEndDate;
    }
    
}
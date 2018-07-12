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
    }

    addNewElement() {
        this.event = '';
        this.startDate = null;
        this.endDate = null;
        this.startTime = null;
        this.endTime = null;
        this.newElementForm = true;
        this.display = true;
        this.timelineApi.allTimelines().subscribe(
            timelines => this.timelines = timelines,
            error => console.log(error)
        );
    }

    displayInfo(rowData: TimelineDTO) {
        this.timeline = rowData;
        //this.event = rowData.event;
        this.startDate = new Date(rowData.startDate);
        this.endDate = new Date(rowData.endDate);
        this.startTime = new Date(rowData.startDate);
        this.endTime = new Date(rowData.endDate);
        this.newElementForm = false;
        this.display = true;
        this.timelineApi.allTimelines().subscribe(
            timelines => this.timelines = timelines,
            error => console.log(error)
        );
    }

    deleteElement(rowData: number) {
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
        let finalStartDate = this.startDate;
        let finalEndDate = this.endDate;
        //timeline.event = this.event;
        finalStartDate.setHours(this.startTime.getHours());
        finalStartDate.setMinutes(this.startTime.getMinutes());
        timeline.startDate = finalStartDate.getTime();
        finalEndDate.setHours(this.endTime.getHours());
        finalEndDate.setMinutes(this.endTime.getMinutes());
        timeline.endDate = finalEndDate.getTime();

        this.timelineApi.createTimeline(timeline).subscribe(
            data => {
                this.timelineApi.allTimelines().subscribe(
                    timelines => {
                        this.timelines = timelines;
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
        this.timeline = null;
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
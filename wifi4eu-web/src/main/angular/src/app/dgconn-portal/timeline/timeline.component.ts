import {Component, Input, OnInit} from "@angular/core";
import {DgConnDetails} from "../dgconnportal-details.model";
import {TimelineElement} from "../../shared/models/timeline-element.model";

@Component({
    templateUrl: 'timeline.component.html'
})


export class DgConnTimelineComponent implements OnInit {

    @Input('dgConnDetails') dgConnDetails: DgConnDetails;

    private timelineElements: TimelineElement[];
    private display: boolean;

    constructor() {
        this.display = false;
        this.dgConnDetails = new DgConnDetails();
        this.timelineElements = [
            new TimelineElement(),
            new TimelineElement()
        ];
        this.timelineElements[0].createTimelineForDgconn('Registration of Mayor and Supplier', '01/01/2017', '00:01', '31/12/2017', '23:59', 'Edit');
        this.timelineElements[1].createTimelineForDgconn('Registration of Mayor and Supplier2', '012/01/2017', '020:01', '31/12/2017', '23:59', 'Edit');
    }

    ngOnInit() {
    }

    addTimeline() {
        this.display = true;
    }
}


import {Component, ViewChild} from '@angular/core';
//import {TimelineDTO, TimelineDTOBase} from '../../swagger/model/TimelineDTO';
import {CustomTimelineAccordionBoxComponent} from './custom-timeline-accordion-box.component';
import {TimelineApi} from '../../swagger/api/TimelineApi';
import {TimelineElement} from "../../models/timeline-element.model";

@Component({selector: 'timeline-component', templateUrl: 'timeline.component.html', providers: [TimelineApi]})
export class TimelineComponent {
    private expandHideString: string;
    private expandHideClass: string;
    private timelineVisible: boolean;
    private timelineElements: TimelineElement[];

    constructor(private timelineApi: TimelineApi) {
        this.expandHideString = "Expand";
        this.expandHideClass = "fa fa-2x fa-angle-down";
        this.timelineVisible = false;
        this.timelineElements = [new TimelineElement(), new TimelineElement()];
        this.timelineElements[0].createTimelineForDgconn('Registration of Mayor and Supplier', '00:01', '01/01/2017', '31/12/2017', '23:59');
        this.timelineElements[1].createTimelineForDgconn('Opening of the call', '20:01', '12/01/2017', '31/12/2017', '23:59');
        // this.timelineElements[0].timelineId = 1;
        // this.timelineElements[0].eventTitle = "Opening";
        // this.timelineElements[0].startDate = new Date(1489489763000);
        // this.timelineElements[0].endDate = new Date(1490353814000);
        // this.timelineElements[1].timelineId = 2;
        // this.timelineElements[1].eventTitle = "Closing";
        // this.timelineElements[1].startDate = new Date(1490353814000);
        // this.timelineElements[1].endDate = new Date(1490440214000);
        // this.timelineApi.allTimelines().subscribe(elements => this.timelineElements = elements);
    }

    displayTimeline() {
        this.timelineVisible = !this.timelineVisible;
        if (this.timelineVisible) {
            this.expandHideString = "Hide timeline";
            this.expandHideClass = "fa fa-2x fa-angle-up";
        } else {
            this.expandHideString = "Expand";
            this.expandHideClass = "fa fa-2x fa-angle-down";
        }
    }
}

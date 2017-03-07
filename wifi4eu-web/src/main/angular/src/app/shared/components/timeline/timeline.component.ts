import {Component, ViewChild} from '@angular/core';
import {TimelineDTO,TimelineDTOBase} from '../../swagger/model/TimelineDTO';
import {CustomUxAccordionBoxComponent} from './custom-ux-accordion-box.component';
import {TimelineApi} from '../../swagger/api/TimelineApi';

@Component({selector: 'timeline-component', templateUrl: 'timeline.component.html',providers:[TimelineApi]})
export class TimelineComponent {
    private expandHideString: string;
    private expandHideClass: string;
    private timelineVisible: boolean;
    private timelineElements: TimelineDTO[];

    constructor(private timelineApi:TimelineApi) {
        this.expandHideString = "Expand";
        this.expandHideClass = "fa fa-2x fa-angle-down";
        this.timelineVisible = false;
       this.timelineApi.allTimelines().subscribe(elements => this.timelineElements = elements);
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

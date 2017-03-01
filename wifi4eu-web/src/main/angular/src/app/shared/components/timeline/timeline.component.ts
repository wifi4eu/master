import {Component, ViewChild} from '@angular/core';
import {TimelineElement} from '../../models/timeline-element.model';
import {CustomUxAccordionBoxComponent} from './custom-ux-accordion-box.component';

@Component({selector: 'timeline-component', templateUrl: 'timeline.component.html'})
export class TimelineComponent {
    private expandHideString: string;
    private expandHideClass: string;
    private timelineVisible: boolean;
    private timelineElements: TimelineElement[];

    constructor() {
        this.expandHideString = "Expand";
        this.expandHideClass = "fa fa-2x fa-angle-down";
        this.timelineVisible = false;
        this.timelineElements = [
            new TimelineElement("30/04/2017", "Opening", "Registration open for Mayors, Representative and Suppliers", "success"),
            new TimelineElement("15/06/2017", "Closing", "Registration closed for Mayors, Representative and Suppliers", "success"),
            new TimelineElement("30/09/2017", "Opening", "Opening the call", "info"),
            new TimelineElement("20/10/2017", "Payment", "First round of payments", "")
        ];
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

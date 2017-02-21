import {Component} from '@angular/core';

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
            new TimelineElement("30/09/2017", "Payment", "First round of payments", "")
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

export class TimelineElement {
    private date: string;
    private label: string;
    private subLabel: string;
    private styleClass: string;

    constructor(date?: string, label?: string, subLabel?: string, styleClass?: string) {
        this.date = date;
        this.label = label;
        this.subLabel = subLabel;
        this.styleClass = styleClass;
    }
}
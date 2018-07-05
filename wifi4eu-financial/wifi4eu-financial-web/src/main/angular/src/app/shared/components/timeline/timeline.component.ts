import {Component, ViewChild} from '@angular/core';
import {TimelineDTO, TimelineDTOBase} from '../../swagger/model/TimelineDTO';
import {CustomTimelineAccordionBoxComponent} from './custom-timeline-accordion-box.component';
import {TimelineApi} from '../../swagger/api/TimelineApi';

export class TimelineItem {
    private date: string;
    private label: string;
    private styleClass: string;

    public getDate() {
        return this.date;
    }

    public setDate(value: string) {
        this.date = value;
    }

    public getLabel() {
        return this.label;
    }

    public setLabel(value: string) {
        this.label = value;
    }

    public getStyleClass() {
        return this.styleClass;
    }

    public setStyleClass(value: string) {
        this.styleClass = value;
    }
}

@Component({selector: 'timeline-component', templateUrl: 'timeline.component.html', providers: [TimelineApi]})
export class TimelineComponent {
    private expandHideString: string;
    private expandHideClass: string;
    private timelineVisible: boolean;
    private timelineItems: TimelineItem[];

    constructor(private timelineApi: TimelineApi) {
        this.expandHideString = "Expand";
        this.expandHideClass = "fa fa-2x fa-angle-down";
        this.timelineVisible = false;
        this.timelineApi.allTimelines().subscribe(elements => {
            this.timelineItems = [];
            for (let i = 0; i < elements.length; i++) {
                this.timelineItems.push(this.timelineDTOToTimelineItem(elements[i]));
            }
        }, error => console.log(error));
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

    public timelineDTOToTimelineItem(dto: TimelineDTOBase) {
        let item = new TimelineItem();
        //item.setLabel(dto.event);
        let timelineDate = new Date(dto.startDate);
        item.setDate(timelineDate.getDate() + "/" + (timelineDate.getMonth() + 1) + "/" + timelineDate.getFullYear());
        let currentDate = new Date();
        if (currentDate.getTime() > dto.startDate && currentDate.getTime() < dto.endDate) {
            item.setStyleClass("primary");
        } else if (currentDate.getTime() > dto.startDate && currentDate.getTime() > dto.endDate) {
            item.setStyleClass("success");
        } else {
            item.setStyleClass("");
        }
        return item;
    }
}

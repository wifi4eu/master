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
    private elementSelected: TimelineElement;
    private elementSelectedOriginal: TimelineElement;
    private elementIndex: number;
    private newElementForm: boolean;

    constructor() {
        this.display = false;
        this.dgConnDetails = new DgConnDetails();
        this.timelineElements = [
            new TimelineElement(),
            new TimelineElement()
        ];
        this.timelineElements[0].createTimelineForDgconn('Registration of Mayor and Supplier', '00:01', '01/01/2017', '31/12/2017', '23:59');
        this.timelineElements[1].createTimelineForDgconn('Registration of Mayor and Supplier2', '20:01', '12/01/2017', '31/12/2017', '23:59');
        this.elementSelected = new TimelineElement();
        this.elementSelectedOriginal = new TimelineElement();
        this.newElementForm = false;
    }

    ngOnInit() {
    }

    addTimeline() {
        this.display = true;
    }

    cancelTimeline() {
        this.display = false;
        this.timelineElements[this.elementIndex] = this.elementSelectedOriginal;
        this.elementSelected = new TimelineElement();
    }

    saveChanges() {
        this.timelineElements[this.elementIndex] = this.elementSelected;
        this.elementSelected = new TimelineElement();
        this.display = false;
    }

    displayInfo(element: TimelineElement, rowElement: number) {
        this.display = true;
        this.elementSelected = element;
        this.elementIndex = rowElement;
        this.elementSelectedMakeCopy(element);
    }

    elementSelectedMakeCopy(element: TimelineElement) {
        this.elementSelectedOriginal = new TimelineElement();
        this.elementSelectedOriginal.createTimelineForDgconn(element.getEvent(), element.getStartTime(), element.getStartDate(), element.getEndDate(), element.getEndTime());
    }

    createTimeline() {
        this.timelineElements.push(this.elementSelected);
        this.newElementForm = false;
        this.display = false;
        console.log(this.timelineElements);
        this.elementSelected = new TimelineElement();
    }

    addNewElement() {
        this.newElementForm = true;
        this.display = true;
        this.elementSelected = new TimelineElement();
    }

    keyPress(event: any) {
        const pattern = /[0-9\:]/;
        let inputChar = String.fromCharCode(event.charCode);
        if (!pattern.test(inputChar)) {
            event.preventDefault();
        }
    }

    changeDateStart() {
        var date = new Date(this.timelineElements[this.elementIndex].getStartDate());
        this.timelineElements[this.elementIndex].setStartDate(date.getDate() + "/" + (date.getMonth() + 1) + "/" + date.getFullYear());
    }

    changeDateEnd() {
        var date = new Date(this.timelineElements[this.elementIndex].getEndDate());
        this.timelineElements[this.elementIndex].setEndDate(date.getDate() + "/" + (date.getMonth() + 1) + "/" + date.getFullYear());
    }


}


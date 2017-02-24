import {Component, Input} from "@angular/core";


@Component({templateUrl: 'timeline.component.html'})
export class DgConnTimelineComponent {

    @Input('dgConnTimelineComponent') dgConnTimelineComponent: DgConnTimelineComponent;

    constructor() {
        this.dgConnTimelineComponent = new DgConnTimelineComponent();
    }

    onSubmit() {

    }

}

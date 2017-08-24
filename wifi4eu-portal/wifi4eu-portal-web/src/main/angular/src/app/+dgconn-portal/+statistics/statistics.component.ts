import {Component, Input} from "@angular/core";
import {StatisticsDetails} from "./statistics-details.component";

@Component({templateUrl: 'statistics.component.html'})
export class DgConnStatisticsComponent {

    @Input('statisticsDetails') statisticsDetails: StatisticsDetails;

    constructor() {
        this.statisticsDetails = new StatisticsDetails();
    }
}


import {Component} from "@angular/core";
import {TimelineComponent} from '../shared/components/timeline/timeline.component';
import {CustomTimelineAccordionBoxComponent} from "../shared/components/timeline/custom-timeline-accordion-box.component";

@Component({templateUrl: 'supplier-portal.component.html'})
export class SupplierPortalComponent {
    private display: boolean;

    constructor() {
        this.display = false;
    }

    openModal() {
        this.display = true;
    }
}

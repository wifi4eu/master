import {Component, Input} from "@angular/core";
import {DgConnDetails} from "../dgconnportal-details.model";
import {PublicationElement} from "../../shared/models/pubilcation-element.model";

@Component({
    templateUrl: 'publication.component.html'
})

export class DgConnPublicationComponent {

    @Input('dgConnDetails') dgConnDetails: DgConnDetails;

    private publicationElement: PublicationElement[];
    private display: boolean;
    private displayTable: boolean;
    private elementSelected: PublicationElement;
    private elementIndex: number;

    constructor() {
        this.display = false;
        this.displayTable = false;
        this.dgConnDetails = new DgConnDetails();
        this.publicationElement = [
            new PublicationElement(),
            new PublicationElement()
        ];
        this.publicationElement[0].createPublicationForDgconn('Registration of Mayor and Supplier', '00:01', '01/01/2017', '31/12/2017', '23:59', 'Edit');
        this.publicationElement[1].createPublicationForDgconn('Registration of Mayor and Supplier2', '20:01', '12/01/2017', '31/12/2017', '23:59', 'Edit');
        this.elementSelected = new PublicationElement();
    }

    ngOnInit() {
    }

    addPublication() {
        this.display = true;
    }

    displayInfo(element: PublicationElement, rowElement: number) {
        this.displayTable = true;
        this.elementSelected = element;
        this.elementIndex = rowElement;
    }
}
import {Component, Input} from "@angular/core";
import {DgConnDetails} from "../dgconnportal-details.model";
import {PublicationElement} from "../../shared/models/pubilcation-element.model";

@Component({
    templateUrl: 'publication.component.html'
})

export class DgConnPublicationComponent {

    @Input('dgConnDetails') dgConnDetails: DgConnDetails;

    private publicationElements: PublicationElement[];
    private display: boolean;
    private elementSelected: PublicationElement;
    private elementSelectedOriginal: PublicationElement;
    private elementIndex: number;
    private newElementForm: boolean;

    constructor() {
        this.display = false;
        this.dgConnDetails = new DgConnDetails();
        this.publicationElements = [
            new PublicationElement(),
            new PublicationElement()
        ];
        this.publicationElements[0].createPublicationForDgconn('Registration of Mayor and Supplier', '00:01', '01/01/2017', '31/12/2017', '23:59');
        this.publicationElements[1].createPublicationForDgconn('Registration of Mayor and Supplier2', '20:01', '12/01/2017', '31/12/2017', '23:59');
        this.elementSelected = new PublicationElement();
        this.newElementForm = false;
    }

    ngOnInit() {
    }

    addPublication() {
        this.display = true;
    }

    cancelPublication() {
        this.display = false;
        this.publicationElements[this.elementIndex] = this.elementSelectedOriginal;
        this.elementSelected = new PublicationElement();
    }

    saveChanges() {
        this.publicationElements[this.elementIndex] = this.elementSelected;
        this.elementSelected = new PublicationElement();
        this.display = false;
    }

    displayInfo(element: PublicationElement, rowElement: number) {
        this.display = true;
        this.elementSelected = element;
        this.elementIndex = rowElement;
        this.elementSelectedMakeCopy(element);
    }

    elementSelectedMakeCopy(element: PublicationElement) {
        this.elementSelectedOriginal = new PublicationElement();
        this.elementSelectedOriginal.createPublicationForDgconn(element.getEvent(), element.getStartTime(), element.getStartDate(), element.getEndDate(), element.getEndTime());
    }

    createPublication() {
        this.publicationElements.push(this.elementSelected);
        this.newElementForm = false;
        this.display = false;
        console.log(this.publicationElements);
        this.elementSelected = new PublicationElement();
    }

    addNewElement() {
        this.newElementForm = true;
        this.display = true;
        this.elementSelected = new PublicationElement();
    }

    keyPress(event: any) {
        const pattern = /[0-9\:]/;
        let inputChar = String.fromCharCode(event.charCode);

        if (!pattern.test(inputChar)) {
            // invalid character, prevent input
            event.preventDefault();
        }
    }

    changeDateStart() {
        var date = new Date(this.publicationElements[this.elementIndex].getStartDate());
        this.publicationElements[this.elementIndex].setStartDate(date.getDate() + "/" + (date.getMonth() + 1) + "/" + date.getFullYear());
    }

    changeDateEnd() {
        var date = new Date(this.publicationElements[this.elementIndex].getEndDate());
        this.publicationElements[this.elementIndex].setEndDate(date.getDate() + "/" + (date.getMonth() + 1) + "/" + date.getFullYear());
    }
}
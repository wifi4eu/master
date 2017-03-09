import {Component, Input} from "@angular/core";
import {DgConnDetails} from "../dgconnportal-details.model";
import {PublicationElement} from "../../shared/models/pubilcation-element.model";
import {PublicationCallDTO, PublicationCallDTOBase} from '../../shared/swagger/model/PublicationCallDTO';
import {CallApi} from '../../shared/swagger/api/CallApi';

@Component({
    templateUrl: 'publication.component.html', providers: [CallApi]
})

export class DgConnPublicationComponent {

    @Input('dgConnDetails') dgConnDetails: DgConnDetails;

    private publicationElements: PublicationElement[];
    private display: boolean;
    private elementSelected: PublicationElement;
    private elementSelectedOriginal: PublicationElement;
    private elementIndex: number;
    private newElementForm: boolean;

    constructor(private callApi: CallApi) {
        this.display = false;
        this.dgConnDetails = new DgConnDetails();
        this.publicationElements = [];
        this.callApi.allCalls().subscribe(
            calls => this.mapElement(calls),
            error => console.log(error)
        );
        this.elementSelected = new PublicationElement();
        this.newElementForm = false;
    }

    mapElement(calls: PublicationCallDTOBase[]) {
        console.log("Calls:", calls);
        for (let i = 0; i < calls.length; i++) {
            this.publicationElements.push(this.transformDTOToElement(calls[i]));
        }
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
        this.elementSelectedOriginal.setUrl(element.getUrl());
        this.elementSelectedOriginal.setStartDate(element.getStartDate());
        this.elementSelectedOriginal.setStartTime(element.getStartTime());
        this.elementSelectedOriginal.setEndDate(element.getEndDate());
        this.elementSelectedOriginal.setEndTime(element.getEndTime());
    }

    createPublication() {
        this.publicationElements.push(this.elementSelected);
        this.newElementForm = false;
        this.display = false;
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

    transformDTOToElement(dto: PublicationCallDTOBase) {
        let element = new PublicationElement();
        element.setId(dto.callId);
        element.setUrl(dto.url);
        let startDate = new Date(dto.startDate);
        let endDate = new Date(dto.endDate);
        element.setStartDate(startDate.getDate() + "/" + (startDate.getMonth() + 1) + "/" + startDate.getFullYear());
        element.setStartTime(startDate.getHours() + ":" + startDate.getMinutes());
        element.setEndDate(endDate.getDate() + "/" + (endDate.getMonth() + 1) + "/" + endDate.getFullYear());
        element.setEndTime(endDate.getHours() + ":" + endDate.getMinutes());
        console.log("Element:", element);
        return element;
    }

    transformElementToDTO(element: PublicationElement) {
        let dto = new PublicationCallDTOBase();
        dto.callId = element.getId();
        dto.url = element.getUrl();
        dto.startDate = new Date(element.getStartDate() + " " + element.getStartTime());
        dto.endDate = new Date(element.getEndDate() + " " + element.getEndTime());
        return dto;
    }
}
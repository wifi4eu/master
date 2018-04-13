import { Component } from "@angular/core";
import { animate, style, transition, trigger } from "@angular/animations";
import { BeneficiaryListItemDTOBase } from "../../shared/swagger/model/BeneficiaryListItemDTO";

@Component({
    templateUrl: 'applicant-registrations.component.html',
    animations: [
        trigger(
            'enterSpinner', [
                transition(':enter', [
                    style({opacity: 0}),
                    animate('200ms', style({opacity: 1}))
                ]),
                transition(':leave', [
                    style({opacity: 1}),
                    animate('200ms', style({opacity: 0}))
                ])
            ]
        )
    ]
})

export class DgConnApplicantRegistrationsComponent {
    private inputSearch: string = '';
    private beneficiaryListItems: BeneficiaryListItemDTOBase[] = [];
    private totalItems: number = 0;
    private page: number = 0;
    private itemsPerPage: number = 5;
    private totalPages: number = 1;
    private rowsPerPageOptions: number[] = [5, 10, 20];
    private sortField: string = 'name';
    private sortOrder: number = 1;
    private loadingData: boolean = false;

    constructor() {
    }
}
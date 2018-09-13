import { Component } from '@angular/core';
import { TranslateService } from 'ng2-translate';
import { ResponseDTOBase } from '../../../shared/swagger/model/ResponseDTO';
import { LegalEntitiesService } from '../../../services/legal-entities-service';
import { SharedService } from '../../../shared/shared.service';
import { animate, style, transition, trigger } from '@angular/animations';

@Component({
    templateUrl: 'importBudgetaryCommitment.component.html',
    providers: [LegalEntitiesService],
    animations: [
        trigger(
            'enterSpinner', [
                transition(':enter', [
                    style({ opacity: 0 }),
                    animate('200ms', style({ opacity: 1 }))
                ]),
                transition(':leave', [
                    style({ opacity: 1 }),
                    animate('200ms', style({ opacity: 0 }))
                ])
            ]
        )
    ]
})
export class ImportBudgetaryCommitmentComponent {

    processingOperation: boolean = false;

    constructor(private translateService: TranslateService, private legalEntitiesService: LegalEntitiesService, private sharedService: SharedService) {
    }

    sendFormData(importFile) {
        this.processingOperation = true;

        this.legalEntitiesService.importBudgetaryCommitment(importFile)
            .subscribe(
                (response: ResponseDTOBase) => {
                    this.processingOperation = false;
                    if (response.success) {
                        this.sharedService.growlTranslation(
                            'Your file have been imported correctly!',
                            'dgconn.dashboard.card.messageImport',
                            'success');
                    } else {
                        this.sharedService.growlTranslation(
                            'An error occurred while trying to retrieve the data from the server. Please, try again later.',
                            'shared.error.api.generic',
                            'error');
                    }
                }, error => {
                    this.processingOperation = false;
                    this.sharedService.growlTranslation(
                        'An error occurred while trying to retrieve the data from the server. Please, try again later.',
                        'shared.error.api.generic',
                        'error');
                }
            );
    }

}
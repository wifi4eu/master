import { Component } from '@angular/core';
import { TranslateService } from 'ng2-translate';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Location } from '@angular/common';
import { ResponseDTOBase } from '../../../shared/swagger/model/ResponseDTO';
import { LegalEntitiesService } from '../../../services/legal-entities-service';
import { SharedService } from '../../../shared/shared.service';
import { animate, style, transition, trigger } from '@angular/animations';

@Component({
    templateUrl: 'importLef.component.html',
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
export class ImportLefComponent {

    processingOperation: boolean = false;

    form: FormGroup;

    constructor(private translateService: TranslateService, private formBuilder: FormBuilder, private location: Location,
                private legalEntitiesService: LegalEntitiesService, private sharedService: SharedService) {
        this.form = this.formBuilder.group({
            importFile: [null, Validators.required]
        });
    }

    onFileChange(event) {
        if (event.target.files.length > 0) {
            let file = event.target.files[0];
            this.form.get('importFile').setValue(file);
        }
    }

    importLegalEntityFile() {
        if (this.form.valid) {
            this.sendFormData();
        } else {
            this.sharedService.growlTranslation(
                'An error occurred while trying to retrieve the data from the server. Please, try again later.',
                'shared.error.api.generic',
                'error'
            );
        }
    }

    private sendFormData() {
        this.processingOperation = true;

        const importFile: FormData = this.prepareSave();

        this.legalEntitiesService.importLef(importFile)
            .subscribe(
                (response: ResponseDTOBase) => {
                    this.processingOperation = false;
                    if (response.success) {
                        this.clearFileInput();

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

    private clearFileInput() {
        this.form.get('importFile').setValue(null);
    }

    private prepareSave(): any {
        const input = new FormData();
        input.append('importFile', this.form.get('importFile').value);
        return input;
    }
}
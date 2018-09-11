import { Component } from '@angular/core';
import { TranslateService } from 'ng2-translate';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Location } from '@angular/common';
import { ResponseDTOBase } from '../../../shared/swagger/model/ResponseDTO';
import { LegalEntitiesService } from '../../../services/legal-entities-service';
import { SharedService } from '../../../shared/shared.service';

@Component({
    templateUrl: 'importLef.component.html',
    providers: [LegalEntitiesService]
})
export class ImportLefComponent {

    processingOperation: boolean = false;

    form: FormGroup;

    constructor(private translateService: TranslateService, private formBuilder: FormBuilder, private location: Location,
                private legalEntitiesService: LegalEntitiesService, private sharedService: SharedService) {
        this.form = this.formBuilder.group({
            importFile: null
        });
    }

    onFileChange(event) {
        if (event.target.files.length > 0) {
            let file = event.target.files[0];
            this.form.get('importFile').setValue(file);
        }
    }

    onBack(): void {
        this.location.back();
    }

    importLegalEntityFile() {
        this.processingOperation = true;

        const importFile: FormData = this.prepareSave();

        this.legalEntitiesService.importLef(importFile)
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

    private prepareSave(): any {
        const input = new FormData();
        input.append('importFile', this.form.get('importFile').value);
        return input;
    }
}
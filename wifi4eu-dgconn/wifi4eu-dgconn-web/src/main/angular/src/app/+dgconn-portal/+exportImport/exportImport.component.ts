import { ChangeDetectionStrategy, Component } from '@angular/core';
import { animate, style, transition, trigger } from '@angular/animations';
import { Http } from '@angular/http';
import { ExportImportApi } from '../../shared/swagger/api/ExportImportApi';
import { SharedService } from '../../shared/shared.service';
import { ApplicationApi } from '../../shared/swagger/api/ApplicationApi';
import { CallApi } from '../../shared/swagger/api/CallApi';
import { ResponseDTOBase } from '../../shared/swagger/model/ResponseDTO';
import { TranslateService } from 'ng2-translate';
import * as FileSaver from 'file-saver';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
    templateUrl: 'exportImport.component.html',
    styleUrls: ['./exportImport.component.scss'],
    providers: [CallApi, ApplicationApi, ExportImportApi],
    preserveWhitespaces: false,
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
export class DgConnExportImportComponent {

    processingOperation: boolean = false;

    constructor(private http: Http, private exportImportApi: ExportImportApi, private sharedService: SharedService,
                private translateService: TranslateService,
                private router: Router, private route: ActivatedRoute) {
    }

    onNavigateToImportLefFile(): void {
        this.router.navigate(['lef'], {relativeTo: this.route});
    }

    onNavigateToImportBcFile(): void {
        this.router.navigate(['bc'], {relativeTo: this.route});
    }

    onNavigateToImportLcFile(): void {
        this.router.navigate(['lc'], {relativeTo: this.route});
    }

    exportRegistrationData() {
        this.processingOperation = true;
        this.exportImportApi.exportRegistrationData().subscribe(
            (response: ResponseDTOBase) => {
                if (response.success)
                    this.sharedService.growlTranslation('Your file have been exported correctly!', 'dgconn.dashboard.card.messageExport', 'success');
                else
                    this.sharedService.growlTranslation('An error occurred while trying to retrieve the data from the server. Please, try again later.', 'shared.error.api.generic', 'error');
                this.processingOperation = false;
            }, error => {
                this.sharedService.growlTranslation('An error occurred while trying to retrieve the data from the server. Please, try again later.', 'shared.error.api.generic', 'error');
                this.processingOperation = false;
            }
        );
    }

    importRegistrationData() {
        this.processingOperation = true;

        this.exportImportApi.importRegistrationData().subscribe(
            (response: ResponseDTOBase) => {
                if (response.success)
                    this.sharedService.growlTranslation('Your file have been imported correctly!', 'dgconn.dashboard.card.messageImport', 'success');
                else
                    this.sharedService.growlTranslation('An error occurred while trying to retrieve the data from the server. Please, try again later.', 'shared.error.api.generic', 'error');
                this.processingOperation = false;
            }, error => {
                this.sharedService.growlTranslation('An error occurred while trying to retrieve the data from the server. Please, try again later.', 'shared.error.api.generic', 'error');
                this.processingOperation = false;
            }
        );
    }

    exportBeneficiaryInformation() {
        this.processingOperation = true;
        this.exportImportApi.exportBeneficiaryInformation().subscribe(
            (response) => {
                let blob = new Blob([response], { type: 'text/zip' });
                FileSaver.saveAs(blob, 'portal_exportBeneficiaryInformation.zip');
                this.sharedService.growlTranslation('Your file have been exported correctly!', 'dgconn.dashboard.card.messageExport', 'success');
                this.processingOperation = false;
            }, error => {
                this.sharedService.growlTranslation('An error occurred while trying to retrieve the data from the server. Please, try again later.', 'shared.error.api.generic', 'error');
                this.processingOperation = false;
            }
        );
    }

    exportBudgetaryCommitment() {
        this.processingOperation = true;
        this.exportImportApi.exportBudgetaryCommitment().subscribe(
            (response) => {
                let blob = new Blob([response], { type: 'text/csv' });
                FileSaver.saveAs(blob, 'ExportBudgetaryCommitment.csv');
                this.sharedService.growlTranslation('Your file have been exported correctly!', 'dgconn.dashboard.card.messageExport', 'success');
                this.processingOperation = false;
            }, error => {
                this.sharedService.growlTranslation('An error occurred while trying to retrieve the data from the server. Please, try again later.', 'shared.error.api.generic', 'error');
                this.processingOperation = false;
            }
        );
    }

}
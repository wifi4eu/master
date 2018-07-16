import {Component} from "@angular/core";
import {animate, style, transition, trigger} from "@angular/animations";
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs";
import {ExportImportApi} from "../../shared/swagger/api/ExportImportApi";
import {SharedService} from "../../shared/shared.service";
import {ApplicationApi} from "../../shared/swagger/api/ApplicationApi";
import {CallApi} from "../../shared/swagger/api/CallApi";
import {ResponseDTOBase} from '../../shared/swagger/model/ResponseDTO';
import {TranslateService} from "ng2-translate";
import * as FileSaver from 'file-saver';

@Component({
    templateUrl: 'exportImport.component.html',
    styleUrls: ['./exportImport.component.scss'],
    providers: [CallApi, ApplicationApi, ExportImportApi],
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

export class DgConnExportImportComponent {
     private processingOperation: boolean = false;

     constructor(private http: Http, private exportImportApi: ExportImportApi, private sharedService: SharedService, private translateService: TranslateService) {
     }

     private exportRegistrationData() {
        this.processingOperation = true;
        this.exportImportApi.exportRegistrationData().subscribe(
            (response: ResponseDTOBase) => {
                if (response.success)
                    this.sharedService.growlTranslation("Your file have been exported correctly!", "dgconn.dashboard.card.messageExport", "success");
                else
                    this.sharedService.growlTranslation("An error occurred while trying to retrieve the data from the server. Please, try again later.", "shared.error.api.generic", "error");
                this.processingOperation = false;
            }, error => {
                this.sharedService.growlTranslation("An error occurred while trying to retrieve the data from the server. Please, try again later.", "shared.error.api.generic", "error");
                this.processingOperation = false;
            }
        );
     }

     private importRegistrationData(){
        this.processingOperation = true;
        this.exportImportApi.importRegistrationData().subscribe(
            (response: ResponseDTOBase) => {
                if (response.success)
                    this.sharedService.growlTranslation("Your file have been imported correctly!", "dgconn.dashboard.card.messageImport", "success");
                else
                    this.sharedService.growlTranslation("An error occurred while trying to retrieve the data from the server. Please, try again later.", "shared.error.api.generic", "error");
                this.processingOperation = false;
            }, error => {
                this.sharedService.growlTranslation("An error occurred while trying to retrieve the data from the server. Please, try again later.", "shared.error.api.generic", "error");
                this.processingOperation = false;
            }
        );
     }

      private exportBeneficiaryInformation() {
        this.processingOperation = true;
        //-- WIFIFOREU-2540
        this.exportImportApi.exportBeneficiaryInformation().subscribe(          
            (response) => {
                let blob = new Blob([response], {type: 'text/zip'});
                FileSaver.saveAs(blob, 'exportBeneficiaryInformation.zip');
                this.sharedService.growlTranslation("Your file have been exported correctly!", "dgconn.dashboard.card.messageExport", "success");
                this.processingOperation = false;              
            }, error => {
                this.sharedService.growlTranslation("An error occurred while trying to retrieve the data from the server. Please, try again later.", "shared.error.api.generic", "error");
                this.processingOperation = false;
            }
        );
      }

     private exportBudgetaryCommitment() {
        this.processingOperation = true;
        // WIFIFOREU-2498 JSON -> CSV       
        this.exportImportApi.exportBudgetaryCommitment().subscribe(
            (response) => {
                let blob = new Blob([response], {type: 'text/csv'});
                FileSaver.saveAs(blob, 'ExportBudgetaryCommitment.csv');
                this.sharedService.growlTranslation("Your file have been exported correctly!", "dgconn.dashboard.card.messageExport", "success");
                this.processingOperation = false;              
            }, error => {
                this.sharedService.growlTranslation("An error occurred while trying to retrieve the data from the server. Please, try again later.", "shared.error.api.generic", "error");
                this.processingOperation = false;
            }          
        );
     }

     private importLegalEntityFBCValidate() {
        this.processingOperation = true;
        this.exportImportApi.importLegalEntityFBCValidate().subscribe(
            (response: ResponseDTOBase) => {
                if (response.success)
                    this.sharedService.growlTranslation("Your file have been imported correctly!", "dgconn.dashboard.card.messageImport", "success");
                else
                    this.sharedService.growlTranslation("An error occurred while trying to retrieve the data from the server. Please, try again later.", "shared.error.api.generic", "error");
                this.processingOperation = false;
            }, error => {
                this.sharedService.growlTranslation("An error occurred while trying to retrieve the data from the server. Please, try again later.", "shared.error.api.generic", "error");
                this.processingOperation = false;
            }
        );
     }

//     private importLegalEntityFBCValidate(event: any) {
//        this.processingOperation = true;
//        if (event.target.files[0]) {
//            if (event.target.files[0].type == "application/json") {
//                let file = event.target.files[0];
//                console.log(file);
//                let reader = new FileReader();
//                reader.onload = (e) => {
//                    this.exportImportApi.importLegalEntityFBCValidate(reader.result).subscribe(
//                        (response: ResponseDTOBase) => {
//                            if (response.success)
//                                this.sharedService.growlTranslation("Your file have been imported correctly!", "dgconn.dashboard.card.messageImport", "success");
//                            else
//                                this.sharedService.growlTranslation("An error occurred while trying to retrieve the data from the server. Please, try again later.", "shared.error.api.generic", "error");
//                            this.processingOperation = false;
//                        }, error => {
//                            this.sharedService.growlTranslation("An error occurred while trying to retrieve the data from the server. Please, try again later.", "shared.error.api.generic", "error");
//                            this.processingOperation = false;
//                        }
//                    );
//                };
//                reader.readAsText(file);
//            }
//        }
//     }
}
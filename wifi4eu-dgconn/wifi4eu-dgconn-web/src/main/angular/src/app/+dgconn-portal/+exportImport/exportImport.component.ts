import {Component} from "@angular/core";
import {animate, style, transition, trigger} from "@angular/animations";
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs";
import * as FileSaver from 'file-saver';
import {ExportImportApi} from "../../shared/swagger/api/ExportImportApi";
import {SharedService} from "../../shared/shared.service";
import {ApplicationApi} from "../../shared/swagger/api/ApplicationApi";
import {CallApi} from "../../shared/swagger/api/CallApi";
import {ResponseDTOBase} from '../../shared/swagger/model/ResponseDTO';
import {TranslateService} from "ng2-translate";


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
     private exportEnabled: boolean = false;
     private jsonFile: File;
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
//            this.exportImportApi.exportRegistrationData().subscribe(
//                (response: ResponseDTO)  => {
//                    if(response.success){
//                        this.sharedService.growlTranslation("Your file have been exported correctly!", "dgconn.dashboard.card.messageExport", "success");
//                        this.translateService.get("dgconn.dashboard.card.messageExport").subscribe(
//                            (translation: string) => {
//                                if (translation) {
//                                    window.alert(translation);
//                                }
//                            }
//                        );
//                    }
//                },
//                error => {
//                }
//            );
     }

     private importRegistrationData(){
        this.processingOperation = true;
        this.exportImportApi.importRegistrationData().subscribe(
            (response: ResponseDTOBase) => {
                console.log('importRegistrationData result: ', response);
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

//            this.exportImportApi.importRegistrationData().subscribe(
//                (response: ResponseDTO)  => {
//                    if(response.success){
//                        this.sharedService.growlTranslation("Your file have been imported correctly!", "dgconn.dashboard.card.messageImport", "success");
//                        this.translateService.get("dgconn.dashboard.card.messageImport").subscribe(
//                            (translation: string) => {
//                                if (translation) {
//                                    window.alert(translation);
//                                }
//                            }
//                        );
//                    }
//                },
//                error => {
//                }
//            );
     }

      private exportBeneficiaryInformation() {
        this.processingOperation = true;
        this.exportImportApi.exportBeneficiaryInformation().subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    let blob = new Blob([response.data], {type: 'application/json'});
                    FileSaver.saveAs(blob, "ExportBeneficiaryInformation.json");
                    this.sharedService.growlTranslation("Your file have been exported correctly!", "dgconn.dashboard.card.messageExport", "success");
                } else {
                    this.sharedService.growlTranslation("An error occurred while trying to retrieve the data from the server. Please, try again later.", "shared.error.api.generic", "error");
                }
                this.processingOperation = false;
            }, error => {
                this.sharedService.growlTranslation("An error occurred while trying to retrieve the data from the server. Please, try again later.", "shared.error.api.generic", "error");
                this.processingOperation = false;
            }
        );
//             var myWindow =window.open("http://localhost:8080/wifi4eu/alertExport.jsp","mywindow","status=1,width=350,height=150");
//             this.exportImportApi.exportBeneficiaryInformation().subscribe(
//                 (response: ResponseDTO) => {
//                     if (response.success) {
//                         let blob = new Blob([response.data], {type: 'application/json'});
//                         FileSaver.saveAs(blob, "ExportBeneficiaryInformation.json");
//                         myWindow.close();
//                         window.alert("Export succesful!");
//                     } else {
//                         myWindow.close();
//                         window.alert("Export failed!");
//                     }
//                 }, error => {
//                     console.log(error);
//                     myWindow.close();
//                     window.alert("Something went wrong.");
//                 }
//             );
      }

     private exportBudgetaryCommitment() {
        this.processingOperation = true;
        this.exportImportApi.exportBudgetaryCommitment().subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    let blob = new Blob([response.data], {type: 'application/json'});
                    FileSaver.saveAs(blob, "ExportBudgetaryCommitment.json");
                    this.sharedService.growlTranslation("Your file have been exported correctly!", "dgconn.dashboard.card.messageExport", "success");
                } else {
                    this.sharedService.growlTranslation("An error occurred while trying to retrieve the data from the server. Please, try again later.", "shared.error.api.generic", "error");
                }
                this.processingOperation = false;
            }, error => {
                this.sharedService.growlTranslation("An error occurred while trying to retrieve the data from the server. Please, try again later.", "shared.error.api.generic", "error");
                this.processingOperation = false;
            }
        );
//              var myWindow =window.open("http://localhost:8080/wifi4eu/alertExport.jsp","mywindow","status=1,width=350,height=150");
//              this.exportImportApi.exportBudgetaryCommitment().subscribe(
//                  (response: ResponseDTO) => {
//                      if (response.success) {
//                          let blob = new Blob([response.data], {type: 'application/json'});
//                          FileSaver.saveAs(blob, "ExportBudgetaryCommitment.json");
//                          myWindow.close();
//                          window.alert("Export succesful!");
//                      } else {
//                          myWindow.close();
//                          window.alert("Export failed!");
//                      }
//                  }, error => {
//                      console.log(error);
//                      myWindow.close();
//                      window.alert("Something went wrong.");
//                  }
//              );
     }

     private importLegalEntityFBCValidate(event: any) {
        this.processingOperation = true;
        if (event.target.files[0]) {
            if (event.target.files[0].type == "application/json") {
                let file = event.target.files[0];
                console.log(file);
                let reader = new FileReader();
                reader.onload = (e) => {
                    this.exportImportApi.importLegalEntityFBCValidate(reader.result).subscribe(
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
                };
                reader.readAsText(file);
            }
        }
//             this.exportEnabled = false;
//             if (event && event.target && event.target.files && event.target.files.length == 1) {
//                 this.jsonFile = event.target.files['0'];
//                 let reader = new FileReader();
//                 reader.onload = (e) => {
//                     var myWindow =window.open("http://localhost:8080/wifi4eu/alertImport.jsp","mywindow","status=1,width=350,height=150");
//                     this.exportImportApi.importLegalEntityFBCValidate(reader.result).subscribe(
//                         (response: ResponseDTO) => {
//                             if (response.success) {
//                                 this.exportEnabled = true;
//                                 //this.sharedService.growlTranslation("Your file have been imported correctly!", "dgconn.dashboard.card.messageImport", "success");
//                                 //this.translateService.get("dgconn.dashboard.card.messageImport").subscribe(
//                                 myWindow.close();
//                                 window.alert("Import succesful!");
//                             } else {
//                                 myWindow.close();
//                                 window.alert("Import failed!");
//                             }
//                         }, error => {
//                             console.log(error);
//                             myWindow.close();
//                             window.alert("Import failed! Make sure that the file you are uploading has the correct format.");
//                         }
//                     );
//                 }
//                 reader.readAsText(this.jsonFile);
//                 //reader.readAsBinaryString(this.excelFile);
//             }
     }
}
import {Component} from "@angular/core";
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs";
import * as FileSaver from 'file-saver';
import {ExportImportApi} from "../../shared/swagger/api/ExportImportApi";
import {SharedService} from "../../shared/shared.service";
import {CallApi} from "../../shared/swagger/api/CallApi";
import {ApplicationApi} from "../../shared/swagger/api/ApplicationApi";
import { ResponseDTO } from '../../shared/swagger/model/ResponseDTO';
import {TranslateService} from "ng2-translate";


@Component({
    templateUrl: 'exportImport.component.html',
    providers: [CallApi, ApplicationApi, ExportImportApi]
})

export class DgConnExportImportComponent {
     private exportEnabled: boolean;
     private jsonFile: File;

     constructor(private http: Http, private exportImportApi: ExportImportApi, private sharedService: SharedService, private translateService: TranslateService) {
        this.exportEnabled = false;
     }

     exportRegistrationData(){
            this.exportImportApi.exportRegistrationData().subscribe(
                (response: ResponseDTO)  => {
                    if(response.success){
                        this.sharedService.growlTranslation("Your file have been exported correctly!", "dgconn.dashboard.card.messageExport", "success");
                        this.translateService.get("dgconn.dashboard.card.messageExport").subscribe(
                            (translation: string) => {
                                if (translation) {
                                    window.alert(translation);
                                }
                            }
                        );
                    }
                },
                error => {
                }
            );
     }

     importRegistrationData(){
            this.exportImportApi.importRegistrationData().subscribe(
                (response: ResponseDTO)  => {
                    if(response.success){
                        this.sharedService.growlTranslation("Your file have been imported correctly!", "dgconn.dashboard.card.messageImport", "success");
                        this.translateService.get("dgconn.dashboard.card.messageImport").subscribe(
                            (translation: string) => {
                                if (translation) {
                                    window.alert(translation);
                                }
                            }
                        );
                    }
                },
                error => {
                }
            );
     }

     //exportBeneficiaryInformation(){
             //this.exportImportApi.exportBeneficiaryInformation().subscribe(
                 //(response: ResponseDTO)  => {
                     //if(response.success){
                         //this.sharedService.growlTranslation("Your file have been exported correctly!", "dgconn.dashboard.card.messageExport", "success");
                         //this.translateService.get("dgconn.dashboard.card.messageExport").subscribe(
                             //(translation: string) => {
                                 //if (translation) {
                                     //window.alert(translation);
                                 //}
                             //}
                         //);
                     //}
                 //},
                 //error => {
                 //}
              //);
     //}

      exportBeneficiaryInformation() {
      debugger;
             var myWindow =window.open("http://localhost:7001/wifi4eu/alertExport.jsp","mywindow","status=1,width=350,height=150");
             this.exportImportApi.exportBeneficiaryInformation().subscribe(
                 (response: ResponseDTO) => {
                     if (response.success) {
                         let blob = new Blob([response.data], {type: 'application/json'});
                         FileSaver.saveAs(blob, "ExportBeneficiaryInformation.json");
                         myWindow.close();
                         window.alert("Export succesful!");
                     } else {
                         myWindow.close();
                         window.alert("Export failed!");
                     }
                 }, error => {
                     console.log(error);
                     myWindow.close();
                     window.alert("Something went wrong.");
                 }
             );
      }

     //exportBudgetaryCommitment(){
             //this.exportImportApi.exportBudgetaryCommitment().subscribe(
                  //(response: ResponseDTO)  => {
                      //if(response.success){
                          //this.sharedService.growlTranslation("Your file have been exported correctly!", "dgconn.dashboard.card.messageExport", "success");
                          //this.translateService.get("dgconn.dashboard.card.messageExport").subscribe(
                              //(translation: string) => {
                                  //if (translation) {
                                      //window.alert(translation);
                                  //}
                              //}
                          //);
                      //}
                  //},
                  //error => {
                  //}
               //);
     //}

     exportBudgetaryCommitment() {
              var myWindow =window.open("http://localhost:7001/wifi4eu/alertExport.jsp","mywindow","status=1,width=350,height=150");
              this.exportImportApi.exportBudgetaryCommitment().subscribe(
                  (response: ResponseDTO) => {
                      if (response.success) {
                          let blob = new Blob([response.data], {type: 'application/json'});
                          FileSaver.saveAs(blob, "ExportBudgetaryCommitment.json");
                          myWindow.close();
                          window.alert("Export succesful!");
                      } else {
                          myWindow.close();
                          window.alert("Export failed!");
                      }
                  }, error => {
                      console.log(error);
                      myWindow.close();
                      window.alert("Something went wrong.");
                  }
              );
     }

     importLegalEntityFBCValidate(event){
             this.exportEnabled = false;
             if (event && event.target && event.target.files && event.target.files.length == 1) {
                 this.jsonFile = event.target.files['0'];
                 let reader = new FileReader();
                 reader.onload = (e) => {
                     var myWindow =window.open("http://localhost:7001/wifi4eu/alertImport.jsp","mywindow","status=1,width=350,height=150");
                     this.exportImportApi.importLegalEntityFBCValidate(reader.result).subscribe(
                         (response: ResponseDTO) => {
                             if (response.success) {
                                 this.exportEnabled = true;
                                 //this.sharedService.growlTranslation("Your file have been imported correctly!", "dgconn.dashboard.card.messageImport", "success");
                                 //this.translateService.get("dgconn.dashboard.card.messageImport").subscribe(
                                 myWindow.close();
                                 window.alert("Import succesful!");
                             } else {
                                 myWindow.close();
                                 window.alert("Import failed!");
                             }
                         }, error => {
                             console.log(error);
                             myWindow.close();
                             window.alert("Import failed! Make sure that the file you are uploading has the correct format.");
                         }
                     );
                 }
                 reader.readAsText(this.jsonFile);
                 //reader.readAsBinaryString(this.excelFile);
             }

          //this.exportImportApi.importLegalEntityFBCValidate().subscribe(
               //(response: ResponseDTO)  => {
                   //if(response.success){
                       //this.sharedService.growlTranslation("Your file have been imported correctly!", "dgconn.dashboard.card.messageImport", "success");
                       //this.translateService.get("dgconn.dashboard.card.messageImport").subscribe(
                           //(translation: string) => {
                               //if (translation) {
                                   //window.alert(translation);
                               //}
                           //}
                       //);
                   //}
               //},
               //error => {
               //}
          //);
     }
}
import {Component} from "@angular/core";
import {CallApi} from "../../shared/swagger/api/CallApi";
import {ApplicationApi} from "../../shared/swagger/api/ApplicationApi";
import {ExportImportApi} from "../../shared/swagger/api/ExportImportApi";
import {SharedService} from "../../shared/shared.service";
import { ResponseDTO } from '../../shared/swagger/model/ResponseDTO';
import {TranslateService} from "ng2-translate";

@Component({
    templateUrl: 'exportImport.component.html',
    providers: [CallApi, ApplicationApi, ExportImportApi]
})

export class DgConnExportImportComponent {

     constructor(private exportImportApi: ExportImportApi, private sharedService: SharedService, private translateService: TranslateService) {}

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

     exportBeneficiaryInformation(){
             this.exportImportApi.exportBeneficiaryInformation().subscribe(
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

     exportBudgetaryCommitment(){
             this.exportImportApi.exportBudgetaryCommitment().subscribe(
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

     importLegalEntityFBCValidate(){
     }
}
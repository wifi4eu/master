import {Component} from "@angular/core";
import {CallApi} from "../../shared/swagger/api/CallApi";
import {ApplicationApi} from "../../shared/swagger/api/ApplicationApi";
import {ExportImportApi} from "../../shared/swagger/api/ExportImportApi";
import {SharedService} from "../../shared/shared.service";
import { ResponseDTO } from '../../shared/swagger/model/ResponseDTO';

@Component({
    templateUrl: 'exportImport.component.html', providers: [CallApi, ApplicationApi, ExportImportApi]
})

export class DgConnExportImportComponent {

     constructor(private exportImportApi: ExportImportApi, private sharedService: SharedService) {}

     export(){
            this.exportImportApi.exportRegistrationData().subscribe(
                (response: ResponseDTO)  => {
                    if(response.success){
                        this.sharedService.growlTranslation("Your file have been exported correctly!", "dgconn.dashboard.card.messageExport", "success");
                    }
                },
                //response => {},
                error => {
                }
            );
     }

     import(){
            this.exportImportApi.importRegistrationData().subscribe(
                (response: ResponseDTO)  => {
                    if(response.success){
                        this.sharedService.growlTranslation("Your file have been imported correctly!", "dgconn.dashboard.card.messageImport", "success");
                    }
                },
                //response => {},
                error => {
                }
            );
     }
}
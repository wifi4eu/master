import {Component} from "@angular/core";
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs";
import {CallApi} from "../../../shared/swagger/api/CallApi";
import {ApplicationApi} from "../../../shared/swagger/api/ApplicationApi";
import { ResponseDTO } from '../../../shared/swagger/model/ResponseDTO';
import {TranslateService} from "ng2-translate";
import {ConfigureGlobalCommitmentsApi} from "../../../shared/swagger/api/ConfigureGlobalCommitmentsApi";


@Component({
    templateUrl: 'configureGlobalCommitments.component.html',
    providers: [CallApi, ApplicationApi, ConfigureGlobalCommitmentsApi]
})

export class DgConfigureGlobalCommitmentsComponent {
     constructor(private http: Http, private configureGlobalCommitmentsApi: ConfigureGlobalCommitmentsApi) {
     }

     configureGlobalCommitments(){
         this.configureGlobalCommitmentsApi.configureGlobalCommitments().subscribe(
             (response: ResponseDTO)  => {
                 if(response.success){
                     //this.sharedService.growlTranslation("Your file have been exported correctly!", "dgconn.dashboard.card.messageExport", "success");
                     //this.translateService.get("dgconn.dashboard.card.messageExport").subscribe(
                         //(translation: string) => {
                             //if (translation) {
                                 //window.alert(translation);
                             //}
                         //}
                     //);
                 }
             },
             error => {
             }
         );
     }
}
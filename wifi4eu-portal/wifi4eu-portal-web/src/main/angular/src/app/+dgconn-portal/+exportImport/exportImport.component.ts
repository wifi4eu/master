import {Component} from "@angular/core";
import {CallApi} from "../../shared/swagger/api/CallApi";
import {ApplicationApi} from "../../shared/swagger/api/ApplicationApi";
import {ExportImportApi} from "../../shared/swagger/api/ExportImportApi";


@Component({
    templateUrl: 'exportImport.component.html', providers: [CallApi, ApplicationApi, ExportImportApi]
})

export class DgConnExportImportComponent {


     constructor(private exportImportApi: ExportImportApi) {}

     export(){
            this.exportImportApi.exportRegistrationData().subscribe(
                response => {
                },
                error => {
                }
            );
            //this.threadApi.getThreadByTypeAndReason(1, String(this.lauId)).subscribe(
                //(thread: ThreadDTOBase) => {
                    //if (thread) {
                        //this.discussionThread = thread;
                        //this.displayedMessages = thread.messages;
                    //}
                //}
            //);
     }

     import(){
            this.exportImportApi.importRegistrationData().subscribe(
                            response => {
                            },
                            error => {
                            }
            );
            //this.threadApi.getThreadByTypeAndReason(1, String(this.lauId)).subscribe(
                //(thread: ThreadDTOBase) => {
                    //if (thread) {
                        //this.discussionThread = thread;
                        //this.displayedMessages = thread.messages;
                    //}
                //}
            //);
     }
}
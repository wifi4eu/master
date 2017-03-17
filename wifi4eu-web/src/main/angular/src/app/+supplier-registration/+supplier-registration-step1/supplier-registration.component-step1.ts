import {Component, Input} from "@angular/core";
import {SupplierRegstration} from "../supplier-registration.model";
// import Message = ts.server.protocol.Message;

@Component({templateUrl: 'supplier-registration.component-step1.html'})
export class SupplierRegistrationComponent {
    @Input('company') company: SupplierRegstration;
}
// export class FileUploadDemo {
//
//     msgs: Message[];
//
//     uploadedFiles: any[] = [];
//
//     onUpload(event) {
//         for (let file of event.files) {
//             this.uploadedFiles.push(file);
//         }
//
//         this.msgs = [];
//         this.msgs.push({severity: 'info', summary: 'File Uploaded', detail: ''});
//     }
// }

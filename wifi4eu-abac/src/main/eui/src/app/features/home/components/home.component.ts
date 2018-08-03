import { Component } from '@angular/core';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { ApiModule } from '../../../shared/api.module';
import { ResponseDTO } from '../../../shared/model/ResponseDTO';
import { UxMessageBoxComponent } from '@eui/ux-commons';
import { UxService } from '@eui/ux-core';
 
@Component({
    templateUrl: './home.component.html'
})
export class HomeComponent{
  
    private lefUploadProgress: number;
    private bcUploadProgress: number;
    private lcUploadProgress: number;
  
    constructor(protected api: ApiModule, protected uxService: UxService){
    }
  
    importLegalEntity(event){
        if (event && event.target && event.target.files && event.target.files.length === 1) {
            let file: File = event.target.files['0'];
            this.api.importLegalEntity(file).subscribe(
                uploadEvent => {
                    if (uploadEvent.type === HttpEventType.UploadProgress) {
                        this.lefUploadProgress = Math.round(100 * uploadEvent.loaded / uploadEvent.total);
                    } else if (uploadEvent instanceof HttpResponse) {
                        this.uxService.openMessageBox('messagebox_file_import_success');
                    }
                },
                (err) => {
                    this.uxService.openMessageBox('messagebox_file_import_fail');
                }
            );
            
        }
    }
  
    importBudgetaryCommitment(event){
        if (event && event.target && event.target.files && event.target.files.length === 1) {
            let file: File = event.target.files['0'];
            this.api.importBudgetaryCommitment(file).subscribe(
                uploadEvent => {
                    if (uploadEvent.type === HttpEventType.UploadProgress) {
                        this.bcUploadProgress = Math.round(100 * uploadEvent.loaded / uploadEvent.total);
                    } else if (uploadEvent instanceof HttpResponse) {
                        this.uxService.openMessageBox('messagebox_file_import_success');
                    }
                },
                (err) => {
                    this.uxService.openMessageBox('messagebox_file_import_fail');
                }
            );
            
        }
    }
  
    importLegalCommitment(event){
        if (event && event.target && event.target.files && event.target.files.length === 1) {
            let file: File = event.target.files['0'];
            this.api.importLegalCommitment(file).subscribe(
                uploadEvent => {
                    if (uploadEvent.type === HttpEventType.UploadProgress) {
                        this.lcUploadProgress = Math.round(100 * uploadEvent.loaded / uploadEvent.total);
                    } else if (uploadEvent instanceof HttpResponse) {
                        this.uxService.openMessageBox('messagebox_file_import_success');
                    }
                },
                (err) => {
                    this.uxService.openMessageBox('messagebox_file_import_fail');
                }
            );
        }
    }
  
    importBankAccount(event){
        alert('importBankAccount: Not implemented yet');
    }
    
    showUpload(fieldClass: string){
        let element: HTMLElement = document.getElementById('abac-upload-' + fieldClass);
        element.setAttribute('value', null);
        element.click();
    }
  
    todo(event){
        alert('Implementation pending...');
    }
}

import { Component } from '@angular/core';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { ApiModule } from '../../../shared/api.module';
import { ResponseDTO } from '../../../shared/model/DTOs';
import { UxMessageBoxComponent } from '@eui/ux-commons';
import { UxService } from '@eui/ux-core';
 
@Component({
    templateUrl: './home.component.html'
})
export class HomeComponent{
  
    private errorMessage: string;
    private uploadProgress: number;
  
    constructor(protected api: ApiModule, protected uxService: UxService){
    }
  
    importLegalEntity(event){
        this.errorMessage = undefined;
        if (event && event.target && event.target.files && event.target.files.length === 1) {
            let file: File = event.target.files['0'];
            this.api.importLegalEntity(file).subscribe(
                uploadEvent => {
                    if (uploadEvent.type === HttpEventType.UploadProgress) {
                        this.uploadProgress = Math.round(100 * uploadEvent.loaded / uploadEvent.total);
                    } else if (uploadEvent instanceof HttpResponse) {
                        this.handleResponse(uploadEvent.body);
                    }
                },
                (err) => {
                    this.showError(undefined);
                }
            );
            
        }
    }
  
    importBudgetaryCommitment(event){
        this.errorMessage = undefined;
        if (event && event.target && event.target.files && event.target.files.length === 1) {
            let file: File = event.target.files['0'];
            this.api.importBudgetaryCommitment(file).subscribe(
                uploadEvent => {
                    if (uploadEvent.type === HttpEventType.UploadProgress) {
                        this.uploadProgress = Math.round(100 * uploadEvent.loaded / uploadEvent.total);
                    } else if (uploadEvent instanceof HttpResponse) {
                        this.handleResponse(uploadEvent.body);
                    }
                },
                (err) => {
                    this.showError(undefined);
                }
            );
            
        }
    }
  
    importLegalCommitment(event){
        this.errorMessage = undefined;
        if (event && event.target && event.target.files && event.target.files.length === 1) {
            let file: File = event.target.files['0'];
            this.api.importLegalCommitment(file).subscribe(
                uploadEvent => {
                    if (uploadEvent.type === HttpEventType.UploadProgress) {
                        this.uploadProgress = Math.round(100 * uploadEvent.loaded / uploadEvent.total);
                    } else if (uploadEvent instanceof HttpResponse) {
                        this.handleResponse(uploadEvent.body);
                    }
                },
                (err) => {
                    this.showError(undefined);
                }
            );
        }
    }
  
    importBankAccount(event){
        alert('importBankAccount: Not implemented yet');
    }
  
    handleResponse(response: ResponseDTO){
        this.errorMessage = undefined;
        if (response.success) {
            this.showSuccess();
        } else {
            this.showError(response.message);
        }
    }
    
    showError(message: string){
        this.errorMessage = message;
        this.uxService.openMessageBox('messagebox_file_import_fail');
    }
  
    showSuccess(){
        this.uxService.openMessageBox('messagebox_file_import_success');
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

import { Component } from '@angular/core';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { ApiModule } from '../../../shared/api.module';
import { ResponseDTO } from '../../../shared/model/DTOs';
import { UxService } from '@eui/ux-core';
 
@Component({
    templateUrl: './home.component.html'
})
export class HomeComponent{
  
    public errorMessage: string;
    public errorBatchRef: string;
    public uploadProgress: number;
  
    constructor(protected api: ApiModule, protected uxService: UxService){
    }
  
    importLegalEntity(event){
        if (event && event.target && event.target.files && event.target.files.length === 1) {
            this.showProgress();
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
                    this.hideProgress();
                    this.showError();
                }
            );
        }
    }
  
    importBudgetaryCommitment(event){
        if (event && event.target && event.target.files && event.target.files.length === 1) {
            this.showProgress();
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
                    this.hideProgress();
                    this.showError();
                }
            );
            
        }
    }
  
    importLegalCommitment(event){
        if (event && event.target && event.target.files && event.target.files.length === 1) {
            this.showProgress();          
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
                    this.hideProgress();
                    this.showError();
                }
            );
        }
    }
  
    importBankAccount(event){
        if (event && event.target && event.target.files && event.target.files.length === 1) {
            this.showProgress();
            let file: File = event.target.files['0'];
            this.api.importBankAccount(file).subscribe(
                uploadEvent => {
                    if (uploadEvent.type === HttpEventType.UploadProgress) {
                        this.uploadProgress = Math.round(100 * uploadEvent.loaded / uploadEvent.total);
                    } else if (uploadEvent instanceof HttpResponse) {
                        this.handleResponse(uploadEvent.body);
                    }
                },
                (err) => {
                    this.hideProgress();
                    this.showError();
                }
            );
        }
    }
  
    handleResponse(response: ResponseDTO){
        this.errorMessage = undefined;
        this.errorBatchRef = undefined;
        this.hideProgress();
        if (response.success) {
            this.showSuccess();
        } else {
            this.showError(response.message, response.batchRef);
        }
    }
    
    showError(message?: string, batchRef?: string){
        this.errorMessage = message ? message : undefined;
        this.errorBatchRef = batchRef ? batchRef : undefined;
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
  
    showProgress(){
        this.uploadProgress = 0;
        this.uxService.openMessageBox('messagebox_upload_progress');
    }
  
    hideProgress(){
        this.uxService.closeMessageBox('messagebox_upload_progress');
    }
}

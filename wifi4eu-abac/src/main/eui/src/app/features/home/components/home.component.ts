import { Component } from '@angular/core';
import { ApiModule } from '../../../shared/api.module';
import { ResponseDTO } from '../../../shared/model/ResponseDTO';
import { UxMessageBoxComponent } from '@eui/ux-commons';
import { UxService } from '@eui/ux-core';
 
@Component({
    templateUrl: './home.component.html'
})
export class HomeComponent{
  
    private importFile: File;

    constructor(protected api: ApiModule, protected uxService: UxService){
    }
  
    importLegalEntity(event){
        if (event && event.target && event.target.files && event.target.files.length === 1) {
            this.importFile = event.target.files['0'];
            let reader = new FileReader();
            reader.onload = (e) => {
                this.api.importLegalEntity(reader.result).subscribe(
                    (response: ResponseDTO) => {
                        if (response.success) {
                            this.uxService.openMessageBox('messagebox_file_import_success');
                        } else {
                            this.uxService.openMessageBox('messagebox_file_import_fail');
                        }
                    }, error => {
                        this.uxService.openMessageBox('messagebox_file_import_fail');
                    }
                );
            };
            reader.readAsText(this.importFile);
        }
    }
  
    importBudgetaryCommitment(event){
        if (event && event.target && event.target.files && event.target.files.length === 1) {
            this.importFile = event.target.files['0'];
            let reader = new FileReader();
            reader.onload = (e) => {
                this.api.importBudgetaryCommitment(reader.result).subscribe(
                    (response: ResponseDTO) => {
                        if (response.success) {
                            this.uxService.openMessageBox('messagebox_file_import_success');
                        } else {
                            this.uxService.openMessageBox('messagebox_file_import_fail');
                        }
                    }, error => {
                        this.uxService.openMessageBox('messagebox_file_import_fail');
                    }
                );
            };
            reader.readAsText(this.importFile);
        }
    }
  
    importLegalCommitment(event){
        if (event && event.target && event.target.files && event.target.files.length === 1) {
            this.importFile = event.target.files['0'];
            let reader = new FileReader();
            reader.onload = (e) => {
                this.api.importLegalCommitment(reader.result).subscribe(
                    (response: ResponseDTO) => {
                        if (response.success) {
                            this.uxService.openMessageBox('messagebox_file_import_success');
                        } else {
                            this.uxService.openMessageBox('messagebox_file_import_fail');
                        }
                    }, error => {
                        this.uxService.openMessageBox('messagebox_file_import_fail');
                    }
                );
            };
            reader.readAsText(this.importFile);
        }
    }
  
    importBankAccount(event){
        alert('importBankAccount: Not implemented yet');
    }
    
    showUpload(fieldClass: string){        
        document.getElementById('abac-upload-' + fieldClass).click();
    }
  
    todo(event){
        alert('Implementation pending...');
    }
}

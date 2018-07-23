import { Component } from '@angular/core';

@Component({
    templateUrl: './home.component.html'
})
export class HomeComponent{

    showUpload(fieldClass: string){        
        document.getElementById('abac-upload-' + fieldClass).click();
    }
  
    importLegalEntity(event){
        alert('importLegalEntity clicked');
    }

    exportLegalEntity(event){
        alert('exportLegalEntity clicked');
    }
  
    importBudgetaryCommitment(event){
        alert('importBudgetaryCommitment clicked');
    }
  
    exportBudgetaryCommitment(event){
        alert('exportBudgetaryCommitment clicked');
    }
  
    importLegalCommitment(event){
        alert('importLegalCommitment clicked');
    }
  
    exportLegalCommitment(event){
        alert('exportLegalCommitment clicked');
    }
  
    importBankAccount(event){
        alert('importBankAccount clicked');
    }
  
    exportBankAccount(event){
        alert('exportBankAccount clicked');
    }
  
    private importFile(endpoint: string){
        
    }
}

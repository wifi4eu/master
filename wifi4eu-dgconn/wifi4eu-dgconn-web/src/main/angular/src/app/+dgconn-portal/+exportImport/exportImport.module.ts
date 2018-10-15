import { NgModule } from '@angular/core';
import { SharedModule } from '../../shared/shared.module';
import { ImportLefComponent } from './lef/importLef.component';
import { ExportImportRoutingModule } from './exportImport-routing.module';
import { DgConnExportImportComponent } from './exportImport.component';
import { ImportBudgetaryCommitmentComponent } from './budgetaryCommitment/importBudgetaryCommitment.component';
import { FileSelectorComponent } from './shared/fileSelector/fileSelector.component';
import { ImportLegalCommitmentComponent } from 'app/+dgconn-portal/+exportImport/legalCommitment/importLegalCommitment.component';
import { ImportFileComponent } from './shared/importFile/importFile.component';
import { PanelButtonComponent } from './shared/panelButton/panelButton.component';

@NgModule({
    imports: [
        SharedModule,
        ExportImportRoutingModule
    ],
    declarations: [
        ImportLefComponent,
        ImportBudgetaryCommitmentComponent,
        ImportLegalCommitmentComponent,
        DgConnExportImportComponent,
        FileSelectorComponent,
        ImportFileComponent,
        PanelButtonComponent
    ],
    bootstrap: [DgConnExportImportComponent]
})
export class ExportImportModule {
}
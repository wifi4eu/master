import { NgModule } from '@angular/core';
import { SharedModule } from '../../shared/shared.module';
import { ImportLefComponent } from './lef/importLef.component';
import { ExportImportRoutingModule } from './exportImport-routing.module';
import { DgConnExportImportComponent } from './exportImport.component';
import { ImportBudgetaryCommitmentComponent } from './budgetaryCommitment/importBudgetaryCommitment.component';
import { FileSelectorComponent } from './shared/fileSelector.component';

@NgModule({
    imports: [
        SharedModule,
        ExportImportRoutingModule
    ],
    declarations: [
        ImportLefComponent,
        ImportBudgetaryCommitmentComponent,
        DgConnExportImportComponent,
        FileSelectorComponent
    ],
    bootstrap: [DgConnExportImportComponent]
})
export class ExportImportModule {
}
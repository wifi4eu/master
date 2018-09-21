import { NgModule } from '@angular/core';
import { DgConnExportImportComponent } from './exportImport.component';
import { ImportLefComponent } from './lef/importLef.component';
import { RouterModule, Routes } from '@angular/router';
import { ImportBudgetaryCommitmentComponent } from './budgetaryCommitment/importBudgetaryCommitment.component';
import { ImportLegalCommitmentComponent } from './legalCommitment/importLegalCommitment.component';
import { ImportDgBudgFinalListComponent } from './dgBudgFinalList/importDgBudgFinalList.component';

const exportImportRoutes: Routes = [
    {
        path: '',
        component: DgConnExportImportComponent,
    },
    {
        path: 'lef',
        component: ImportLefComponent
    },
    {
        path: 'bc',
        component: ImportBudgetaryCommitmentComponent
    },
    {
        path: 'lc',
        component: ImportLegalCommitmentComponent
    },
    {
        path: 'dgBudg',
        component: ImportDgBudgFinalListComponent
    }
];

@NgModule({
    imports: [
        RouterModule.forChild(exportImportRoutes)
    ],
    exports: [
        RouterModule
    ]
})
export class ExportImportRoutingModule {
}
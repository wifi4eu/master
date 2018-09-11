import { NgModule } from '@angular/core';
import { DgConnExportImportComponent } from './exportImport.component';
import { ImportLefComponent } from './fileSelector/importLef.component';
import { RouterModule, Routes } from '@angular/router';

const exportImportRoutes: Routes = [
    {
        path: '',
        component: DgConnExportImportComponent,
    },
    {
        path: 'lef',
        component: ImportLefComponent
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
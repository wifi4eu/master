import { NgModule } from '@angular/core';
import { SharedModule } from '../../shared/shared.module';
import { ImportLefComponent } from './fileSelector/importLef.component';
import { ExportImportRoutingModule } from './exportImport-routing.module';
import { DgConnExportImportComponent } from './exportImport.component';

@NgModule({
    imports: [
        SharedModule,
        ExportImportRoutingModule
    ],
    declarations: [
        ImportLefComponent,
        DgConnExportImportComponent
    ],
    bootstrap: [DgConnExportImportComponent]
})
export class ExportImportModule {
}
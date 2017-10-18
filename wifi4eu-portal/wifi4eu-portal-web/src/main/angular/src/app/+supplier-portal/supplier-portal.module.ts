import {NgModule} from "@angular/core";
import {SharedModule} from "../shared/shared.module";
import {SupplierProfileComponent} from "./profile/profile.component";
import {SupplierPortalRoutingModule} from "./supplier-portal-routing.module";
import {FileUploadModule} from "primeng/primeng";


@NgModule({
    imports: [
        SharedModule,
        SupplierPortalRoutingModule,
        FileUploadModule
    ],
    declarations: [
        //SupplierPortalComponent,
        // SupplierInstallationComponent,
        // SupplierMunicipalitiesComponent,
        SupplierProfileComponent
    ]
})
export class SupplierPortalModule {
}
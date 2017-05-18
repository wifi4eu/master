import {NgModule} from "@angular/core";
import {SharedModule} from "../shared/shared.module";
import {SupplierPortalComponent} from "./supplier-portal.component";
import {SupplierInstallationComponent} from "./installation/supplier-installation.component";
import {SupplierMunicipalitiesComponent} from "./municipalities/supplier-municipalities.component";
import {SupplierProfileComponent} from "./profile/profile.component";
import {SupplierPortalRoutingModule} from "./supplier-portal-routing.module";
import {SelectedByMunicipalityComponent} from "./selected-by-municipality.component";
import {AwardedMunicipalitiesComponent} from "./awarded-municipalities.component";
import {FileUploadModule} from 'primeng/primeng';

@NgModule({
    imports: [
        SharedModule,
        SupplierPortalRoutingModule,
        FileUploadModule
    ],
    declarations: [
        SupplierPortalComponent,
        SupplierInstallationComponent,
        SupplierMunicipalitiesComponent,
        SupplierProfileComponent,
        SelectedByMunicipalityComponent,
        AwardedMunicipalitiesComponent
    ],
    bootstrap: [SupplierPortalComponent]
})
export class SupplierPortalModule {
}
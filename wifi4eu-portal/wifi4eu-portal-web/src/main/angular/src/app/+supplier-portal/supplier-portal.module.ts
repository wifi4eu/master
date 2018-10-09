import {NgModule} from "@angular/core";
import {SharedModule} from "../shared/shared.module";
import {SupplierPortalComponent} from "./supplier-portal.component";
import {SupplierInstallationComponent} from "./installation/supplier-installation.component";
import {SupplierMunicipalitiesComponent} from "./municipalities/supplier-municipalities.component";
import {SupplierProfileComponent} from "./profile/profile.component";
import {BankAccountComponent} from "./profile/bank-account/bank-account.component";
import {SupplierEditProfileComponent} from "./profile/edit/edit-profile.component";
import {SupplierPortalRoutingModule} from "./supplier-portal-routing.module";
import {AdditionalInfoComponent} from "./+additional-info/additional-info.component";
import {DiscussionComponent} from "./+discussion/discussion.component";
import { SupplierMyInstallationComponent } from "./supplier-my-installation/supplier-my-installation.component";

@NgModule({
    imports: [
        SharedModule, SupplierPortalRoutingModule
    ],
    declarations: [
        SupplierPortalComponent,
        SupplierInstallationComponent,
        SupplierMunicipalitiesComponent,
        SupplierProfileComponent,
        BankAccountComponent,
        SupplierEditProfileComponent,
        AdditionalInfoComponent,
        DiscussionComponent,
        SupplierMyInstallationComponent
    ],
    bootstrap: [SupplierPortalComponent]
})
export class SupplierPortalModule {
}
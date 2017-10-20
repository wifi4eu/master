import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {SupplierProfileComponent} from "./profile/profile.component";

@NgModule({
    imports: [RouterModule.forChild([
        {
            //  path: '',
            //  component: SupplierPortalComponent,
            //  }, {
            //     path: 'installation/:id',
            //     component: SupplierInstallationComponent,
            // }, {
            path: 'profile',
            component: SupplierProfileComponent,
        }
    ])],
    exports: [RouterModule]
})
export class SupplierPortalRoutingModule {
}
import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {SupplierRegistrationComponent} from "./supplier-registration.component";

@NgModule({
    imports: [RouterModule.forChild([
        {
            path: '',
            component: SupplierRegistrationComponent,
        }
    ])],
    exports: [RouterModule]
})
export class SupplierRegistrationRoutingModule {}
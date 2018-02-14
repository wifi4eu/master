import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {BeneficiaryRegistrationComponent} from "./beneficiary-registration.component";
import { EcasLoginResolver } from "app/shared/shared.service";

@NgModule({
    imports: [RouterModule.forChild([
        {
            path: '',
            component: BeneficiaryRegistrationComponent
        }
    ])], exports: [RouterModule]
})

export class BeneficiaryRegistrationRoutingModule {
}
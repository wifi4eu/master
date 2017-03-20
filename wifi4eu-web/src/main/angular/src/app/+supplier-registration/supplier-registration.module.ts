import {NgModule} from "@angular/core";
import {SharedModule} from "../shared/shared.module";
import {SuccessComponent} from "../shared/components/success/success.component";
import {FailureComponent} from "../shared/components/failure/failure.component";
import {HelpdeskFormComponent} from "../shared/components/helpdesk-form/helpdesk-form.component";
import {Ng2GoogleRecaptchaModule} from "ng2-google-recaptcha";
import {SupplierRegistrationComponent} from "./supplier-registration.component";
import {SupplierRegistrationComponentStep1} from "./+supplier-registration-step1/supplier-registration-step1.component";
import {SupplierRegistrationComponentStep2} from "./+supplier-registration-step2/supplier-registration-step2.component";
import {SupplierRegistrationComponentStep3} from "./+supplier-registration-step3/supplier-registration-step3.component";
import {SupplierRegistrationComponentStep4} from "./+supplier-registration-step4/supplier-registration-step4.component";
import {SupplierRegistrationRoutingModule} from "./supplier-registration-routing.module";


@NgModule({
    imports: [
        SharedModule, SupplierRegistrationRoutingModule, Ng2GoogleRecaptchaModule
    ],
    declarations: [
        SupplierRegistrationComponent, SupplierRegistrationComponentStep1, SupplierRegistrationComponentStep2, SupplierRegistrationComponentStep3, SupplierRegistrationComponentStep4, SuccessComponent, FailureComponent, HelpdeskFormComponent
    ],
    bootstrap: [SupplierRegistrationComponent]
})
export class SupplierRegistrationModule {
}
import {NgModule} from "@angular/core";
import {SharedModule} from "../shared/shared.module";
import {Ng2GoogleRecaptchaModule} from "ng2-google-recaptcha";
import {SupplierRegistrationComponent} from "./supplier-registration.component";
import {SupplierRegistrationStep1Component} from "./+supplier-registration-step1/supplier-registration-step1.component";
import {SupplierRegistrationStep2Component} from "./+supplier-registration-step2/supplier-registration-step2.component";
import {SupplierRegistrationStep3Component} from "./+supplier-registration-step3/supplier-registration-step3.component";
import {SupplierRegistrationStep4Component} from "./+supplier-registration-step4/supplier-registration-step4.component";
import {SupplierRegistrationRoutingModule} from "./supplier-registration-routing.module";
import {FileUploadModule} from 'primeng/primeng';

@NgModule({
    imports: [
        SharedModule, SupplierRegistrationRoutingModule, Ng2GoogleRecaptchaModule, FileUploadModule
    ],
    declarations: [
        SupplierRegistrationComponent, SupplierRegistrationStep1Component, SupplierRegistrationStep2Component, SupplierRegistrationStep3Component, SupplierRegistrationStep4Component
    ],
    bootstrap: [SupplierRegistrationComponent]
})
export class SupplierRegistrationModule {
}
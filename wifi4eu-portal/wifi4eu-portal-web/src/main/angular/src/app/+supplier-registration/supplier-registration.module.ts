import {NgModule} from "@angular/core";
import {SharedModule} from "../shared/shared.module";
import {Ng2GoogleRecaptchaModule} from "ng2-google-recaptcha";
import {SupplierRegistrationComponent} from "./supplier-registration.component";
import {SupplierRegistrationComponentStep1} from "./+supplier-registration-step1/supplier-registration-step1.component";
import {SupplierRegistrationComponentStep2} from "./+supplier-registration-step2/supplier-registration-step2.component";
import {SupplierRegistrationComponentStep3} from "./+supplier-registration-step3/supplier-registration-step3.component";
import {SupplierRegistrationComponentStep4} from "./+supplier-registration-step4/supplier-registration-step4.component";
import {SupplierRegistrationRoutingModule} from "./supplier-registration-routing.module";
import {FileUploadModule} from 'primeng/primeng';

@NgModule({
    imports: [
        SharedModule, SupplierRegistrationRoutingModule, Ng2GoogleRecaptchaModule, FileUploadModule
    ],
    declarations: [
        SupplierRegistrationComponent, SupplierRegistrationComponentStep1, SupplierRegistrationComponentStep2, SupplierRegistrationComponentStep3, SupplierRegistrationComponentStep4
    ],
    bootstrap: [SupplierRegistrationComponent]
})
export class SupplierRegistrationModule {
}
import {NgModule} from "@angular/core";
import {BeneficiaryRegistrationComponent} from "./beneficiary-registration.component";
import {BeneficiaryRegistrationRoutingModule} from "./beneficiary-registration-routing.module";
import {BeneficiaryRegistrationStep1Component} from "./+beneficiary-registration-step1/beneficiary-registration-step1.component";
import {BeneficiaryRegistrationStep2Component} from "./+beneficiary-registration-step2/beneficiary-registration-step2.component";
import {BeneficiaryRegistrationStep3Component} from "./+beneficiary-registration-step3/beneficiary-registration-step3.component";
import {SharedModule} from "../shared/shared.module";

// import {Ng2GoogleRecaptchaModule} from "ng2-google-recaptcha";

@NgModule({
    imports: [BeneficiaryRegistrationRoutingModule, SharedModule]
    ,
    declarations: [BeneficiaryRegistrationComponent, BeneficiaryRegistrationStep1Component, BeneficiaryRegistrationStep2Component, BeneficiaryRegistrationStep3Component]
    ,
    bootstrap: [BeneficiaryRegistrationComponent]
})

export class BeneficiaryRegistrationModule {
}
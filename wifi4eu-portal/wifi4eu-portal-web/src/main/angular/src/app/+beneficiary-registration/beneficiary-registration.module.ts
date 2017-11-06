import {NgModule} from "@angular/core";
import {BeneficiaryRegistrationComponent} from "./beneficiary-registration.component";
import {BeneficiaryRegistrationRoutingModule} from "./beneficiary-registration-routing.module";
import {SharedModule} from "../shared/shared.module";
import {BeneficiaryRegistrationStep4Component} from "./+beneficiary-registration-step4/beneficiary-registration-step4.component";
import {BeneficiaryRegistrationStep2Component} from "./+beneficiary-registration-step2/beneficiary-registration-step2.component";
import {BeneficiaryRegistrationStep3Component} from "./+beneficiary-registration-step3/beneficiary-registration-step3.component";

// import {Ng2GoogleRecaptchaModule} from "ng2-google-recaptcha";

@NgModule({
    imports: [BeneficiaryRegistrationRoutingModule, SharedModule]
    ,
    declarations: [BeneficiaryRegistrationComponent, BeneficiaryRegistrationStep4Component, BeneficiaryRegistrationStep2Component, BeneficiaryRegistrationStep3Component]
    ,
    bootstrap: [BeneficiaryRegistrationComponent]
})

export class BeneficiaryRegistrationModule {
}
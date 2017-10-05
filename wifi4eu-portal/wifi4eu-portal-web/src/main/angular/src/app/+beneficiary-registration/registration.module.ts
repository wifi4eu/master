import {NgModule} from "@angular/core";
import {SharedModule} from "../shared/shared.module";
import {RegistrationRoutingModule} from "./registration-routing.module";
import {RegistrationComponent} from "./registration.component";
import {EntityComponent} from "./+beneficiary-registration-step2/legal-entity.component";
import {BeneficiaryComponent} from "./+beneficiary-registration-step1/beneficiary.component";
import {ReviewComponent} from "./+beneficiary-registration-step3/review.component";
import {Ng2GoogleRecaptchaModule} from "ng2-google-recaptcha";
import {Ng2Bs3ModalModule} from "ng2-bs3-modal/ng2-bs3-modal";

@NgModule({
    imports: [
        SharedModule, RegistrationRoutingModule, Ng2GoogleRecaptchaModule, Ng2Bs3ModalModule
    ],
    declarations: [
        RegistrationComponent, EntityComponent, BeneficiaryComponent, ReviewComponent
    ],
    bootstrap: [RegistrationComponent]
})
export class RegistrationModule {
}
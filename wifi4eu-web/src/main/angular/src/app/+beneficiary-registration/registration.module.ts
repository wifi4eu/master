import {NgModule} from '@angular/core';
import {SharedModule} from '../shared/shared.module';
import {RegistrationRoutingModule} from './registration-routing.module';
import {RegistrationComponent} from './registration.component';
import {EntityComponent} from './+beneficiary-registration-step1/legal-entity.component';
import {BeneficiaryComponent} from './+beneficiary-registration-step2/beneficiary.component';
import {ReviewComponent} from './+beneficiary-registration-step3/review.component';
import {SuccessRegistrationComponent} from '../shared/components/success-registration/success.registration.component';
import {SuccessComponent} from '../shared/components/success/success.component';
import {FailureComponent} from '../shared/components/failure/failure.component';
import {HelpdeskFormComponent} from '../shared/components/helpdesk-form/helpdesk-form.component';
import {Ng2GoogleRecaptchaModule} from 'ng2-google-recaptcha';

@NgModule({
    imports: [
        SharedModule, RegistrationRoutingModule, Ng2GoogleRecaptchaModule
    ],
    declarations: [
        RegistrationComponent, EntityComponent, BeneficiaryComponent, ReviewComponent, SuccessRegistrationComponent, SuccessComponent, FailureComponent, HelpdeskFormComponent
    ],
    bootstrap: [RegistrationComponent]
})
export class RegistrationModule {
}
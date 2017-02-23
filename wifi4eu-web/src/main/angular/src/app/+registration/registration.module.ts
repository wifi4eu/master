import {NgModule} from '@angular/core';
import {SharedModule} from '../shared/shared.module';
import {RegistrationRoutingModule} from './registration-routing.module';
import {RegistrationComponent} from './registration.component';
import {EntityComponent} from '../+entity/entity.component';
import {BeneficiaryComponent} from '../+beneficiary/beneficiary.component';
import {ReviewComponent} from '../+review/review.component';
import {SuccessRegistrationComponent} from './success.registration.component';
import {SuccessComponent} from '../+review/success.component';
import {FailureComponent} from '../+review/failure.component';
import {Ng2GoogleRecaptchaModule} from 'ng2-google-recaptcha';

@NgModule({
    imports: [
        SharedModule, RegistrationRoutingModule, Ng2GoogleRecaptchaModule
    ],
    declarations: [
        RegistrationComponent, EntityComponent, BeneficiaryComponent, ReviewComponent, SuccessRegistrationComponent, SuccessComponent, FailureComponent
    ],
    bootstrap: [RegistrationComponent]
})
export class RegistrationModule {
}
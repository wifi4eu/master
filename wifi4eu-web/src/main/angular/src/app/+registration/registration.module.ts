import {NgModule} from '@angular/core';
import {SharedModule} from '../shared/shared.module';
import {RegistrationRoutingModule} from './registration-routing.module';
import {RegistrationComponent} from './registration.component';
import {EntityComponent} from '../+entity/entity.component';
import {BeneficiaryComponent} from '../+beneficiary/beneficiary.component';
import {ReviewComponent} from '../+review/review.component';
import {SuccessRegistrationComponent} from './success.registration.component';

@NgModule({
  imports: [
    SharedModule, RegistrationRoutingModule
  ],
  declarations: [
    RegistrationComponent, EntityComponent, BeneficiaryComponent, ReviewComponent, SuccessRegistrationComponent
  ],
  bootstrap: [RegistrationComponent]
})
export class RegistrationModule {}
import {NgModule} from '@angular/core';
import {SharedModule} from '../shared/shared.module';
import {RegistrationRoutingModule} from './registration-routing.module';
import {RegistrationComponent} from './registration.component';
import {EntityComponent} from '../+entity/entity.component';
import {BeneficiaryComponent} from '../+beneficiary/beneficiary.component';

@NgModule({
  imports: [
    SharedModule, RegistrationRoutingModule
  ],
  declarations: [
    RegistrationComponent, EntityComponent, BeneficiaryComponent
  ],
  bootstrap: [RegistrationComponent]
})
export class RegistrationModule {}
import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {RegistrationComponent} from './registration.component';
import {SuccessRegistrationComponent} from '../shared/components/success-registration/success.registration.component'

@NgModule({
  imports: [RouterModule.forChild([
      {
        path: '',
        component: RegistrationComponent,
      },
      {
          path: 'success',
          component: SuccessRegistrationComponent,
      }
    ])],
  exports: [RouterModule]
})
export class RegistrationRoutingModule {}
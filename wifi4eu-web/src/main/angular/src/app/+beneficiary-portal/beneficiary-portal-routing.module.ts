import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {VoucherComponent} from './+voucher/voucher.component';
import {} from './';

@NgModule({
  imports: [RouterModule.forChild([
      {
        path: '',
        component: VoucherComponent,
      },
      {
          path: 'voucher',
          component: VoucherComponent,
      }
    ])],
  exports: [RouterModule]
})
export class BeneficiaryPortalRoutingModule {}
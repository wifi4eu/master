import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {VoucherComponent} from './voucher.component'

@NgModule({
    imports: [RouterModule.forChild([
        {
            path: '',
            component: VoucherComponent,
        }
    ])],
    exports: [RouterModule]
})
export class VoucherRoutingModule {
}
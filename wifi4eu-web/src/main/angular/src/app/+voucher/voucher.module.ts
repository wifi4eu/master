import {NgModule} from '@angular/core';
import {SharedModule} from '../shared/shared.module';
import {VoucherRoutingModule} from './voucher-routing.module';
import {VoucherComponent} from './voucher.component';

@NgModule({
    imports: [
        SharedModule, VoucherRoutingModule
    ],
    declarations: [
        VoucherComponent
    ],
    bootstrap: [VoucherComponent]
})
export class VoucherModule {
}
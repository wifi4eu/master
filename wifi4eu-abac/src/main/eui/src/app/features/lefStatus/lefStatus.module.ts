import { NgModule } from '@angular/core';
import { LefStatusRoutingModule } from './lefStatus-routing.module';
import { LefStatusComponent } from './lefStatus.component';

import { ApiModule } from '../../shared/api.module';

@NgModule({
    imports: [
        ApiModule,
        LefStatusRoutingModule
    ],
    declarations: [
        LefStatusComponent
    ],
    bootstrap: [
        LefStatusComponent
    ]
})
export class LefStatusModule {
}

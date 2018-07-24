import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { LefStatusComponent } from './lefStatus.component';

@NgModule({
    imports: [
        RouterModule.forChild([
            { path: '', component: LefStatusComponent }
        ])
    ],
    exports: [
        RouterModule
    ]
})
export class LefStatusRoutingModule {

}

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AccessPointListComponent } from './components/access-point-list/access-point-list.component';

@NgModule({
    imports: [
        RouterModule.forChild([
            { path: '', component: AccessPointListComponent }
        ])
    ],
    exports: [
        RouterModule
    ]
})
export class AccessPointRoutingModule {

}

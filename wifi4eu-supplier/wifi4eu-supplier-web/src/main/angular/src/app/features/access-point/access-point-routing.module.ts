import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AccessPointListComponent } from './components/access-point-list/access-point-list.component';
import { AccessPointDetailsComponent } from './components/access-point-details/access-point-details.component';

@NgModule({
    imports: [
        RouterModule.forChild([
            { path: '', component: AccessPointListComponent },
            { path: 'details/:ap', component: AccessPointDetailsComponent }
        ])
    ],
    exports: [
        RouterModule
    ]
})
export class AccessPointRoutingModule {

}

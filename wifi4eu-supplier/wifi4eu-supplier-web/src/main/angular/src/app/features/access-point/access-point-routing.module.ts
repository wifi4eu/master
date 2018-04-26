import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AccessPointListComponent } from './components/access-point-list/access-point-list.component';
import { AccessPointDetailsComponent } from './components/access-point-details/access-point-details.component';
import { AccessPointDetailsResolver } from '../../core/services/access-point-service';

@NgModule({
    imports: [
        RouterModule.forChild([
            { path: '', component: AccessPointListComponent },
            { path: 'details/:ap', component: AccessPointDetailsComponent, resolve: {
                accessPoint : AccessPointDetailsResolver
            } }
        ])
    ],
    exports: [
        RouterModule
    ]
})
export class AccessPointRoutingModule {

}

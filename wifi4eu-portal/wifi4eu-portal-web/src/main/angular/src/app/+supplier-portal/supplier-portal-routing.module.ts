import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { SupplierPortalComponent } from "./supplier-portal.component";
import { SupplierInstallationComponent } from "./installation/supplier-installation.component";
import { SupplierProfileComponent } from "./profile/profile.component";
import { SupplierEditProfileComponent } from "./profile/edit/edit-profile.component";
import { AdditionalInfoComponent } from "./+additional-info/additional-info.component";
import {DiscussionComponent} from "./+discussion/discussion.component";
import { SupplierMyInstallationComponent } from './supplier-my-installation/supplier-my-installation.component';

@NgModule({
    imports: [RouterModule.forChild([
        {
            path: '',
            redirectTo: 'voucher'
        }/* , 
        {
            path: 'voucher',
            component: SupplierPortalComponent,
        } */,{
            path: 'installation/:id',
            component: SupplierInstallationComponent,
        }, {
            path: 'discussion-forum/:threadId',
            component: DiscussionComponent
        }, {
            path: 'profile',
            component: SupplierProfileComponent,
        }, {
            path: 'profile/edit',
            component: SupplierEditProfileComponent,
        }, {
            path: 'additional-info',
            component: AdditionalInfoComponent
        }, {
            path: 'my-installation',
            component: SupplierMyInstallationComponent,
        }
    ])],
    exports: [RouterModule]
})
export class SupplierPortalRoutingModule {
}
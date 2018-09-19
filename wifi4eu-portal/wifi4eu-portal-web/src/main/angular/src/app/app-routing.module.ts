import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import { AppGuard } from "./app.guard";
import { HomeComponent } from "./home/home.component";
import { NotFoundComponent } from "./not-found/not-found.component";
import {ActivationComponent} from "./activation/activation.component";
import {ForgotComponent} from "./+forgot/forgot.component";
// import { HelpdeskComponent } from "./+helpdesk/helpdesk.component";
import { ListSuppliersComponent } from "./list-suppliers/list-suppliers.component";
import { InvitedContactDetailsComponent } from "./invited-contact-details/invited-contact-details.component";
import { DeactivatedUserComponent } from "./deactivated-user/deactivated-user.component";
import { ConfirmationService } from "primeng/primeng";

// import {EcasComponent} from "./+ecas/ecas.component";

@NgModule({
    imports: [RouterModule.forRoot([
        {
            path: '',
            redirectTo: 'home',
            pathMatch: 'full'
        }, {
            path: 'home',
            component: HomeComponent,
            canActivate: [AppGuard]
        }, {
            path: 'index.jsp',
            redirectTo: 'beneficiary-portal',
            canActivate: [AppGuard]
        }, {
            path: 'activation',
            component: ActivationComponent
        }, {
            path: 'forgot',
            component: ForgotComponent
        }, {
            path: 'beneficiary-portal',
            loadChildren: 'app/+beneficiary-portal/beneficiary-portal.module#BeneficiaryPortalModule',
            canActivate: [AppGuard]
        }, {
		/*
            path: 'helpdesk',
            component: HelpdeskComponent,
            canActivate: [AppGuard]
        }, {
		*/
            path: 'beneficiary-registration',
            loadChildren: 'app/beneficiary-registration/beneficiary-registration.module#BeneficiaryRegistrationModule',
            canActivate: [AppGuard]
        }, {
            path: 'supplier-registration',
            loadChildren: 'app/supplier-registration/supplier-registration.module#SupplierRegistrationModule',
            canActivate: [AppGuard]
        }, {
            path: 'supplier-portal',
            loadChildren: 'app/+supplier-portal/supplier-portal.module#SupplierPortalModule',
            canActivate: [AppGuard]
        }, {
            path: 'list-suppliers',
            component: ListSuppliersComponent
        }, {
            path: 'notfound',
            component: NotFoundComponent
        },/*{
            path: 'invited-contact-details',
            component: InvitedContactDetailsComponent
        },*/{
            path: 'deactivated-user',
            component: DeactivatedUserComponent
        
		/*
        }, {
            path: '**',
            redirectTo: 'home'
		*/
        }, {
            path: '**',
            redirectTo: 'notfound'
        }
    ], {useHash: true})],
    providers: [AppGuard, ConfirmationService],
    exports: [RouterModule]
})
export class AppRoutingModule {
}

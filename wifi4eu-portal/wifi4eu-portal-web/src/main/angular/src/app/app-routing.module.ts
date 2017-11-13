import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {ActivationComponent} from "./+activation/activation.component";
import {LoginComponent} from "./+login/login.component";
// import {ForgotComponent} from "./+forgot/forgot.component";
import {HelpdeskComponent} from "./+helpdesk/helpdesk.component";
import {NotFoundComponent} from "./not-found/not-found.component"
import {AppGuard} from "./app.guard";
// import {AppGuard} from "./app.guard";
// import {AbacComponent} from "./+abac/abac.component";
// import {EcasComponent} from "./+ecas/ecas.component";

@NgModule({
    imports: [RouterModule.forRoot([
        {
            path: '',
            redirectTo: 'home',
            pathMatch: 'full'
        }, {
            path: 'index.jsp',
            redirectTo: 'home'
        }, {
            path: 'home',
            component: HomeComponent
        }, {
            path: 'activation',
            component: ActivationComponent
        }, {
            path: 'login',
            component: LoginComponent
            // }, {
            //     path: 'forgot',
            //     component: ForgotComponent
        }, {
            path: 'beneficiary-portal',
            loadChildren: 'app/+beneficiary-portal/beneficiary-portal.module#BeneficiaryPortalModule',
            //     canActivate: [AppGuard]
             }, {
                 path: 'helpdesk',
                 component: HelpdeskComponent,
            //     canActivate: [AppGuard]
        }, {
            path: 'dgconn-portal',
            loadChildren: 'app/+dgconn-portal/dgconnportal.module#DgConnPortalModule',
            //     canActivate: [AppGuard]
        }, {
            path: 'beneficiary-registration',
            loadChildren: 'app/+beneficiary-registration/beneficiary-registration.module#BeneficiaryRegistrationModule'
        }, {
            path: 'supplier-registration',
            loadChildren: 'app/+supplier-registration/supplier-registration.module#SupplierRegistrationModule'
        }, {
            path: 'supplier-portal',
            loadChildren: 'app/+supplier-portal/supplier-portal.module#SupplierPortalModule',
            // canActivate: [AppGuard]
            // }, {
            //     path: 'abac',
            //     component: AbacComponent
        }, {
            path: 'notfound',
            component: NotFoundComponent
        }, {
            path: '**',
            redirectTo: 'notfound'
        }
    ], {useHash: true})],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
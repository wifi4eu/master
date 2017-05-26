import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {MapComponent} from "./+dgconn-portal/+map/map.component";
import {ActivationComponent} from "./+activation/activation.component";
import {LoginComponent} from "./+login/login.component";
import {ForgotComponent} from "./+forgot/forgot.component";
import {HelpdeskComponent} from "./+helpdesk/helpdesk.component";
import {DgConnPortalComponent} from "./+dgconn-portal/dgconnportal.component";
import {DgConnTimelineComponent} from "./+dgconn-portal/+timeline/timeline.component";
import {DgConnPublicationComponent} from "./+dgconn-portal/+publication/publication.component";
import {NotFoundComponent} from "./not-found/not-found.component"
import {AppGuard} from "./app.guard";

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
            path: 'map',
            component: MapComponent,
            canActivate: [AppGuard]
        }, {
            path: 'activation',
            component: ActivationComponent
        }, {
            path: 'login',
            component: LoginComponent
        }, {
            path: 'forgot',
            component: ForgotComponent
        }, {
            path: 'registration',
            loadChildren: 'app/+beneficiary-registration/registration.module#RegistrationModule'
        }, {
            path: 'beneficiary-portal',
            loadChildren: 'app/+beneficiary-portal/beneficiary-portal.module#BeneficiaryPortalModule',
            canActivate: [AppGuard]
        }, {
            path: 'helpdesk',
            component: HelpdeskComponent,
            canActivate: [AppGuard]
        }, {
            path: 'dgconn-portal',
            loadChildren: 'app/+dgconn-portal/dgconnportal.module#DgConnPortalModule',
            canActivate: [AppGuard]
        }, {
            path: 'supplier-registration',
            loadChildren: 'app/+supplier-registration/supplier-registration.module#SupplierRegistrationModule'
        }, {
            path: 'supplier-portal',
            loadChildren: 'app/+supplier-portal/supplier-portal.module#SupplierPortalModule',
            canActivate: [AppGuard]
        }, {
            path: '**',
            component: NotFoundComponent
        }
    ], {useHash: true})],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
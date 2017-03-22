import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {MapComponent} from "./+beneficiary-portal/+voucher/+map/map.component";
import {ActivationComponent} from "./+activation/activation.component";
import {LoginComponent} from "./+login/login.component";
import {ForgotComponent} from "./+forgot/forgot.component";
import {HelpdeskComponent} from "./+helpdesk/helpdesk.component";
import {DgConnPortalComponent} from "./+dgconn-portal/dgconnportal.component";
import {DgConnTimelineComponent} from "./+dgconn-portal/+timeline/timeline.component";
import {DgConnPublicationComponent} from "./+dgconn-portal/+publication/publication.component";
import {SupplierPortalComponent} from "./+supplier-portal/supplier-portal.component";
import {SupplierInstallationComponent} from "./+supplier-portal/installation/supplier-installation.component";
import {SupplierMunicipalitiesComponent} from "./+supplier-portal/municipalities/supplier-municipalities.component";

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
            component: MapComponent
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
            loadChildren: 'app/+beneficiary-portal/beneficiary-portal.module#BeneficiaryPortalModule'
        }, {
            path: 'helpdesk',
            component: HelpdeskComponent
        }, {
            path: 'dgconn-portal',
            component: DgConnPortalComponent
        }, {
            path: 'dgconn-portal/timeline',
            component: DgConnTimelineComponent
        }, {
            path: 'dgconn-portal/publication',
            component: DgConnPublicationComponent
        }, {
            path: 'supplier-portal',
            component: SupplierPortalComponent
        }, {
            path: 'supplier-portal/installation',
            component: SupplierInstallationComponent
        }, {
            path: 'supplier-portal/municipalities',
            component: SupplierMunicipalitiesComponent
        }
    ], {useHash: true})],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {VoucherComponent} from "./+voucher/voucher.component";
import {MapComponent} from "./+map/map.component";
import {ActivationComponent} from "./activation/activation.component";
import {LoginComponent} from "./+login/login.component";
import {BeneficiaryProfileComponent} from "./+beneficiary/profile/profile.component";

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
            path: 'registration',
            loadChildren: 'app/+registration/registration.module#RegistrationModule'
        }, {
            path: 'voucher',
            component: VoucherComponent
        }
    ], {useHash: true})],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
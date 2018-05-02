import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {LoginComponent} from "./+login/login.component";
import {ForgotComponent} from "./+forgot/forgot.component";
import {NotFoundComponent} from "./not-found/not-found.component"
import {AppGuard} from "./app.guard";
import {AbacComponent} from "./+abac/abac.component";
import {EcasComponent} from "./+ecas/ecas.component";

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
            path: 'login',
            component: LoginComponent
        }, {
            path: 'forgot',
            component: ForgotComponent
        }, {
            path: 'dgconn-portal',
            //loadChildren: 'app/+dgconn-portal/dgconnportal.module#DgConnPortalModule',
            loadChildren: 'app/+dgconn-portal/dgconnportal.module#DgConnPortalModule'
            //canActivate: [AppGuard]
        }, {
            path: 'abac',
            component: AbacComponent
        }, {
            path: 'ecas',
            component: EcasComponent
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
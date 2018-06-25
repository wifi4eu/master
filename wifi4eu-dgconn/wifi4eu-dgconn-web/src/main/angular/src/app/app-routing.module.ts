import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { AppGuard } from "./app.guard";
import { HomeComponent } from "./home/home.component";
import { NotFoundComponent } from "./not-found/not-found.component";
//import { ActivationComponent } from "./activation/activation.component";
//import { ForgotComponent } from "./+forgot/forgot.component";
import { HelpdeskComponent } from "./+helpdesk/helpdesk.component";
//import { ListSuppliersComponent } from "./list-suppliers/list-suppliers.component";
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
            path: 'dgconn-portal',
            loadChildren: 'app/+dgconn-portal/dgconnportal.module#DgConnPortalModule',
            canActivate: [AppGuard]
        }, {
            path: 'helpdesk',
            component: HelpdeskComponent,
            canActivate: [AppGuard]
        }, {
            path: 'notfound',
            component: NotFoundComponent
        }, {
            path: '**',
            redirectTo: 'notfound'
        }        
    ], { useHash: true })],
    providers: [AppGuard],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
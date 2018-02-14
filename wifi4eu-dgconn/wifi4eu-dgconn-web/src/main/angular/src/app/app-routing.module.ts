import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {NotFoundComponent} from "./not-found/not-found.component"
import {AppGuard} from "./app.guard";
// import {AppGuard} from "./app.guard";
// import {EcasComponent} from "./+ecas/ecas.component";

@NgModule({
    imports: [RouterModule.forRoot([
        {
            path: '',
            loadChildren: 'app/dashboard/dgconn.dashboard.module#DgConnDashboardModule'
            // canActivate: [AppGuard],
        }, {
            path: 'home',
            redirectTo: ''
        }, {
            path: 'index.jsp',
            redirectTo: ''
        }, {
            path: 'notfound',
            component: NotFoundComponent
        }, {
            path: '**',
            redirectTo: 'notfound'
        }
    ], {useHash: true})],
    providers: [AppGuard],
    exports: [RouterModule]
})

export class AppRoutingModule {
}
import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {MapComponent} from "./+map/map.component";

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
            path: 'registration',
            loadChildren: 'app/+registration/registration.module#RegistrationModule'
        }
    ], {useHash: true})],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
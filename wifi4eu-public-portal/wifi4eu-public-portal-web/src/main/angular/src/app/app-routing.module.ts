import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { HomeComponent } from "./home/home.component";
import { LoginComponent } from "./+login/login.component";
import { NotFoundComponent } from "./not-found/not-found.component"
import { AppGuard } from "./app.guard";
import { BeneficiaryLandingComponent } from "./+beneficiary-landing/beneficiary-landing.component";
import { SupplierLandingComponent } from "./+supplier-landing/supplier-landing.component";

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
            path: 'beneficiary-landing',
            component: BeneficiaryLandingComponent
        }, {
            path: 'supplier-landing',
            component: SupplierLandingComponent
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
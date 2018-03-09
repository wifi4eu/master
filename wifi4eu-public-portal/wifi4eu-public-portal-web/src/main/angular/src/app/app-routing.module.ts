import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { HomeComponent } from "./home/home.component";
import { NotFoundComponent } from "./not-found/not-found.component"
import { BeneficiaryLandingComponent } from "./+beneficiary-landing/beneficiary-landing.component";
import { SupplierLandingComponent } from "./+supplier-landing/supplier-landing.component";
import { ListMunicipalitiesComponent } from "app/list-municipalities/list-municipalities.component";

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
            path: 'beneficiary-landing',
            component: BeneficiaryLandingComponent
        }, {              
            path: 'list-municipalities',
            component: ListMunicipalitiesComponent
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
    exports: [RouterModule]
})
export class AppRoutingModule {
}
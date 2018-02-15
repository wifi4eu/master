import { Http } from "@angular/http";
import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { UxService } from "@ec-digit-uxatec/eui-angular2-ux-commons";
import { TranslateLoader, TranslateModule, TranslateStaticLoader } from "ng2-translate";
import { LocalStorageModule } from "angular-2-local-storage";
import { HomeComponent } from "./home/home.component";
import { NotFoundComponent } from "./not-found/not-found.component"
import { BeneficiaryLandingComponent } from "./+beneficiary-landing/beneficiary-landing.component";
import { SupplierLandingComponent } from "./+supplier-landing/supplier-landing.component";
import { AppComponent } from "./app.component";
import { AppRoutingModule } from "./app-routing.module";
import { CoreModule } from "./core/core.module";
import { SharedService } from "./shared/shared.service";
import { DataGridModule } from "primeng/primeng";
import { ListMunicipalitiesComponent } from "app/list-municipalities/list-municipalities.component";

// import { BrowserModule } from "@angular/platform-browser";
// import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
// import { NgModule } from "@angular/core";
// import { FormsModule } from "@angular/forms";
// import { Http } from "@angular/http";
// import { TranslateModule, TranslateLoader, TranslateStaticLoader } from "ng2-translate/ng2-translate";
// import { UxService } from "@ec-digit-uxatec/eui-angular2-ux-commons";
// import { CoreModule } from "./core/core.module";
// import { CoreService } from "./core/core.service";
// import { AppComponent } from "./app.component";
// import { AppRoutingModule } from "./app-routing.module";
// import { HomeComponent } from "./home/home.component";
// import { Ng2Bs3ModalModule } from "ng2-bs3-modal/ng2-bs3-modal";
// import { NotFoundComponent } from "./not-found/not-found.component"
// import { LocalStorageModule } from 'angular-2-local-storage';
// import { SharedService } from "./shared/shared.service";
// import { ChartsModule } from "ng2-charts";
// import { AppGuard } from "./app.guard";
// import { BeneficiaryLandingComponent } from "./+beneficiary-landing/beneficiary-landing.component";
// import { SupplierLandingComponent } from "./+supplier-landing/supplier-landing.component";

export function translateFactory(http: Http) {
    return new TranslateStaticLoader(http, './assets/i18n', '.json');
}

@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        NotFoundComponent,
        BeneficiaryLandingComponent,
        SupplierLandingComponent,
        ListMunicipalitiesComponent
    ],
    exports: [
        NotFoundComponent,
    ],
    imports: [
        CoreModule,
        BrowserModule,
        DataGridModule,
        // BrowserAnimationsModule,
        TranslateModule.forRoot({
            provide: TranslateLoader,
            useFactory: translateFactory,
            deps: [Http]
        }),
        AppRoutingModule,
        // FormsModule,
        // Ng2Bs3ModalModule,
        LocalStorageModule.withConfig({
            prefix: 'wifi4eu',
            storageType: 'localStorage'
        })
        // }),
        // ChartsModule
    ],
    providers: [
        // UxService,
        // CoreService,
        // AppGuard,
        UxService,
        SharedService
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}

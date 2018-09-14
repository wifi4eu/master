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
import { SharedModule } from "./shared/shared.module";
import { SharedService } from "./shared/shared.service";
import { DataGridModule } from "primeng/primeng";
import { ListMunicipalitiesComponent } from "app/list-municipalities/list-municipalities.component";
import { CustomUxTrackScrollDirective } from "./shared/components/custom-track-scroll/custom-track-scroll.directive";

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
        ListMunicipalitiesComponent,
        CustomUxTrackScrollDirective
    ],
    exports: [
        NotFoundComponent,
        SharedModule
    ],
    imports: [
        BrowserModule,
        DataGridModule,
        TranslateModule.forRoot({
            provide: TranslateLoader,
            useFactory: translateFactory,
            deps: [Http]
        }),
        AppRoutingModule,
        LocalStorageModule.withConfig({
            prefix: 'wifi4eu',
            storageType: 'localStorage'
        }),
        SharedModule
    ],
    providers: [
        UxService,
        SharedService
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}

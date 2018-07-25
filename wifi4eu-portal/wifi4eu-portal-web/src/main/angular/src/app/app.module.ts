import { BrowserModule } from "@angular/platform-browser";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { Http, RequestOptions } from "@angular/http";
import { TranslateModule, TranslateLoader, TranslateStaticLoader } from "ng2-translate/ng2-translate";
import { UxService } from "@ec-digit-uxatec/eui-angular2-ux-commons";
import { CoreModule } from "./core/core.module";
import { CoreService } from "./core/core.service";
import { AppComponent } from "./app.component";
import { AppRoutingModule } from "./app-routing.module";
// import {MapComponent} from "./+dgconn-portal/+map/map.component";
import { ActivationComponent } from "./activation/activation.component";
// import {ForgotComponent} from "./+forgot/forgot.component";
import {Ng2Bs3ModalModule} from "ng2-bs3-modal/ng2-bs3-modal";
// import {HelpdeskComponent} from "./+helpdesk/helpdesk.component";
import {NotFoundComponent} from "./not-found/not-found.component"
// import {AppGuard} from "./app.guard";
import {LocalStorageModule} from 'angular-2-local-storage';
import {CustomRequestOptions, SharedService} from "./shared/shared.service";
// import {AbacComponent} from "./+abac/abac.component";
// import {EcasComponent} from "./+ecas/ecas.component";
import { HomeComponent } from "./home/home.component";
import { ChartsModule } from "ng2-charts";
import { ForgotComponent } from "./+forgot/forgot.component";
import { AppGuard } from "./app.guard";
import { ListSuppliersComponent } from './list-suppliers/list-suppliers.component';
import { DataGridModule, PaginatorModule } from "primeng/primeng";
import {CookieService} from 'ngx-cookie-service';

export function translateFactory(http: Http) {
    return new TranslateStaticLoader(http, './assets/i18n', '.json');
}

@NgModule({
    declarations: [
        AppComponent,
        ActivationComponent,
        ForgotComponent,
        // HelpdeskComponent,
        HomeComponent,
        // EcasComponent,
        NotFoundComponent,
        ListSuppliersComponent
    ],
    exports: [
        // MapComponent,
        ActivationComponent,
        ForgotComponent,
        // HelpdeskComponent,
        HomeComponent,
        // EcasComponent,
        NotFoundComponent,
    ],
    imports: [
        CoreModule,
        BrowserModule,
        BrowserAnimationsModule,
        DataGridModule,
        PaginatorModule,
        TranslateModule.forRoot({
            provide: TranslateLoader,
            useFactory: translateFactory,
            deps: [Http]
        }),
        AppRoutingModule,
        FormsModule,
        Ng2Bs3ModalModule,
        LocalStorageModule.withConfig({
            prefix: 'wifi4eu',
            storageType: 'localStorage'
        }),
        ChartsModule
    ],
    providers: [
        UxService,
        CoreService,
        AppGuard,
        SharedService,
        {provide: RequestOptions, useClass: CustomRequestOptions},
        SharedService,
        CookieService
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
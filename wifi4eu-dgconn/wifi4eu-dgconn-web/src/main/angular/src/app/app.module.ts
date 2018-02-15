import {BrowserModule} from "@angular/platform-browser";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {Http} from "@angular/http";
import {LocalStorageModule} from 'angular-2-local-storage';
import {TranslateModule, TranslateLoader, TranslateStaticLoader} from "ng2-translate/ng2-translate";
import {Ng2Bs3ModalModule} from "ng2-bs3-modal/ng2-bs3-modal";
import {ChartsModule} from "ng2-charts";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {CoreModule} from "./core/core.module";
import {CoreService} from "./core/core.service";
import {AppGuard} from "./app.guard";
import {AppComponent} from "./app.component";
import {AppRoutingModule} from "./app-routing.module";
import {NotFoundComponent} from "./not-found/not-found.component"
import {SharedService} from "./shared/shared.service";

export function translateFactory(http: Http) {
    return new TranslateStaticLoader(http, './assets/i18n', '.json');
}

@NgModule({
    declarations: [
        AppComponent,
        NotFoundComponent
    ],
    exports: [
        NotFoundComponent
    ],
    imports: [
        CoreModule,
        BrowserModule,
        BrowserAnimationsModule,
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
        SharedService
    ],
    bootstrap: [AppComponent]
})

export class AppModule {
}
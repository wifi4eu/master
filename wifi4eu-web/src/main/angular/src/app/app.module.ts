///<reference path="+activation/activation.component.ts"/>
import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {Http} from "@angular/http";
import {TranslateModule, TranslateLoader, TranslateStaticLoader} from "ng2-translate/ng2-translate";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {CoreModule} from "./core/core.module";
import {CoreService} from "./core/core.service";
import {AppComponent} from "./app.component";
import {AppRoutingModule} from "./app-routing.module";
import {HomeComponent} from "./home/home.component";
import {MapComponent} from "./+map/map.component";
import {ActivationComponent} from "./+activation/activation.component";
import {LoginComponent} from "./+login/login.component";
import {ForgotComponent} from "./+forgot/forgot.component";
import {DgConnPortalComponent} from "./dgconn-portal/dgconnportal.component";
import {DgConnTimelineComponent} from "./dgconn-portal/timeline/timeline.component";
import {Ng2Bs3ModalModule} from "ng2-bs3-modal/ng2-bs3-modal";
import {DgConnPublicationComponent} from "./dgconn-portal/publication/publication.component";


export function translateFactory(http: Http) {
    return new TranslateStaticLoader(http, './assets/i18n', '.json');
}

@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        MapComponent,
        ActivationComponent,
        LoginComponent,
        ForgotComponent,
        DgConnPortalComponent,
        DgConnTimelineComponent,
        DgConnPublicationComponent
    ],
    exports: [
        MapComponent,
        DgConnPortalComponent,
        DgConnTimelineComponent,
        ActivationComponent,
        LoginComponent,
        ForgotComponent,
        DgConnPublicationComponent
    ],
    imports: [
        CoreModule,
        BrowserModule,
        TranslateModule.forRoot({
            provide: TranslateLoader,
            useFactory: translateFactory,
            deps: [Http]
        }),
        AppRoutingModule,
        FormsModule,
        Ng2Bs3ModalModule
    ],
    providers: [
        UxService,
        CoreService
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
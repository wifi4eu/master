import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {Http, XHRBackend, RequestOptions, HttpModule} from "@angular/http";
import {UxHttp} from "@ec-digit-uxatec/eui-angular2-ux-http-interceptor";
import {UxModule, UX_DIRECTIVES} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {UxLanguageSelectorComponent} from "@ec-digit-uxatec/eui-angular2-ux-language-selector";
import {UxSearchInputComponent} from "@ec-digit-uxatec/eui-angular2-ux-search-input";
import {
    CheckboxModule,
    GrowlModule,
    BlockUIModule,
    AutoCompleteModule,
    DialogModule,
    DataTableModule,
    CalendarModule
} from "primeng/primeng";
import {APP_DIRECTIVES} from "./components/index";
import {TimelineComponent} from "./components/timeline/timeline.component";
import {CustomUxAccordionBoxComponent} from "./components/timeline/custom-ux-accordion-box.component";
import {Ng2GoogleRecaptchaModule} from "ng2-google-recaptcha";
export function httpFactory(backend: XHRBackend, defaultOptions: RequestOptions) {
    return new UxHttp(backend, defaultOptions);
}

@NgModule({
    imports: [
        RouterModule,
        UxModule,
        CheckboxModule,
        GrowlModule,
        BlockUIModule,
        HttpModule,
        AutoCompleteModule,
        DialogModule,
        DataTableModule,
        CalendarModule,
        Ng2GoogleRecaptchaModule,

    ],
    declarations: [
        UX_DIRECTIVES,
        UxLanguageSelectorComponent,
        UxSearchInputComponent,
        TimelineComponent,
        CustomUxAccordionBoxComponent,
        APP_DIRECTIVES
    ],
    exports: [
        UX_DIRECTIVES,
        UxLanguageSelectorComponent,
        UxSearchInputComponent,
        UxModule,
        APP_DIRECTIVES,
        CheckboxModule,
        GrowlModule,
        BlockUIModule,
        HttpModule,
        AutoCompleteModule,
        DialogModule,
        DataTableModule,
        CalendarModule,
        TimelineComponent,
        CustomUxAccordionBoxComponent
    ],
    providers: [
        {
            provide: Http,
            useFactory: httpFactory,
            deps: [XHRBackend, RequestOptions]
        }
    ]
})
export class SharedModule {
}
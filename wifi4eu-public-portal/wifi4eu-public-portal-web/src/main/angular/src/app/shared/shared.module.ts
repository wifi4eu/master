import { NgModule } from "@angular/core";
import { Http, XHRBackend, RequestOptions, HttpModule } from "@angular/http";
import { UxHttp } from "@ec-digit-uxatec/eui-angular2-ux-http-interceptor";
import { UX_DIRECTIVES } from "@ec-digit-uxatec/eui-angular2-ux-commons";
import { UxLanguageSelectorComponent } from "@ec-digit-uxatec/eui-angular2-ux-language-selector";
import { UxSearchInputComponent } from "@ec-digit-uxatec/eui-angular2-ux-search-input";
import { UxModule } from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.module";
import { GrowlModule, BlockUIModule } from "primeng/primeng";
import { TimerComponent } from "../shared/components/timer/timer.component";
import { CustomLayoutHeaderComponent } from "./components/custom-layout-header/custom-layout-header";
import { CustomLayoutNavBarActionItemComponent } from "./components/custom-layout-nav-bar-action-item/custom-layout-nav-bar-action-item";
import { CustomLayoutNavBarTopMenuComponent } from "./components/custom-layout-nav-bar-top-menu/custom-layout-nav-bar-top-menu.component";

export function httpFactory(backend: XHRBackend, defaultOptions: RequestOptions) {
    return new UxHttp(backend, defaultOptions);
}

@NgModule({
    imports: [
        UxModule,
        GrowlModule,
        BlockUIModule,
        HttpModule
    ],
    declarations: [
        UX_DIRECTIVES,
        UxLanguageSelectorComponent,
        UxSearchInputComponent,
        CustomLayoutHeaderComponent,
        CustomLayoutNavBarActionItemComponent,
        CustomLayoutNavBarTopMenuComponent,
        TimerComponent
    ],
    exports: [
        UX_DIRECTIVES,
        UxLanguageSelectorComponent,
        UxSearchInputComponent,
        UxModule,
        GrowlModule,
        BlockUIModule,
        HttpModule,
        CustomLayoutHeaderComponent,
        CustomLayoutNavBarActionItemComponent,
        CustomLayoutNavBarTopMenuComponent,
        TimerComponent
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
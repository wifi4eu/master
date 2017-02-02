import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {Http, XHRBackend, RequestOptions, HttpModule} from '@angular/http';
import {UxHttp} from '@ec-digit-uxatec/eui-angular2-ux-http-interceptor';
import {UxModule, UX_DIRECTIVES} from '@ec-digit-uxatec/eui-angular2-ux-commons';
import {UxLanguageSelectorComponent} from '@ec-digit-uxatec/eui-angular2-ux-language-selector';
import {UxSearchInputComponent} from '@ec-digit-uxatec/eui-angular2-ux-search-input';

import {CheckboxModule, GrowlModule, BlockUIModule, AutoCompleteModule} from 'primeng/primeng';

import {APP_DIRECTIVES} from './components/index';

export function httpFactory(backend : XHRBackend, defaultOptions : RequestOptions) {
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
    AutoCompleteModule
  ],
  declarations: [
    UX_DIRECTIVES, UxLanguageSelectorComponent, UxSearchInputComponent, APP_DIRECTIVES
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
    AutoCompleteModule
  ],
  providers: [
    {
      provide: Http,
      useFactory: httpFactory,
      deps: [XHRBackend, RequestOptions]
    }
  ]
})
export class SharedModule {}
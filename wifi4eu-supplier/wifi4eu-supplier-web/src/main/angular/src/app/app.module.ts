import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { CoreModule } from './core/core.module';

import { HttpClientModule, HttpClient, HttpHandler } from '@angular/common/http';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { createTranslateLoader } from './shared/translate/translate.factory';

import { LocalStorageModule } from 'angular-2-local-storage';
import {CookieService} from 'ngx-cookie-service';

@NgModule({
    declarations: [
        AppComponent,
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        CoreModule,
        AppRoutingModule,
        HttpClientModule,
        TranslateModule.forRoot({
            loader: {
                provide: TranslateLoader,
                useFactory: createTranslateLoader,
                deps: [HttpClient]
            }
        }),
        LocalStorageModule.withConfig({
            prefix: 'wifi4eu',
            storageType: 'localStorage'
        }),
    ],
    exports: [
    ],
    providers: [
        CookieService
    ],
    bootstrap: [
        AppComponent
    ],
})
export class AppModule { }

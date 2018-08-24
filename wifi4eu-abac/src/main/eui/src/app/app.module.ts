import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CoreModule } from './core/core.module';

import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { RequestErrorInterceptor } from '@eui/ux-core';

@NgModule({
    declarations: [
        AppComponent,
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        CoreModule,
        AppRoutingModule
    ],
    bootstrap: [
        AppComponent
    ],
    providers: [
        {
            provide: HTTP_INTERCEPTORS,
            useClass: RequestErrorInterceptor,
            multi: true,
        }
    ]
})
export class AppModule { }

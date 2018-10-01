import { NgModule } from '@angular/core';
import { StoreModule } from '@ngrx/store';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';
import { TranslateModule } from '@ngx-translate/core';

import './operators';

import { CoreModule as UxCoreModule, translateConfig } from '@eui/ux-core';

import { appConfig } from '../../config/index';
import { environment } from '../../environments/environment';

import { rootReducer } from './reducers/index';

import { UserDetailsService } from './services/user-details.service';

import { HomeComponent } from './components/home/home.component';
import { SearchInputComponent } from './components/shell/search-input/search-input.component';

import { SharedModule } from '../shared/shared.module';
import { BeneficiaryService } from './services/beneficiary-service';
import { ErrorHandlingService } from './services/error.service';

@NgModule({
    imports: [
        SharedModule,
        UxCoreModule.forRoot({ appConfig: appConfig, environment: environment }),
        StoreModule.provideStore(rootReducer),
        StoreDevtoolsModule.instrumentOnlyWithExtension(),
        TranslateModule.forRoot(translateConfig),
    ],
    declarations: [
        HomeComponent,
        SearchInputComponent
    ],
    exports: [
        SharedModule,
        HomeComponent,
        SearchInputComponent
    ],
    providers: [
        UserDetailsService,
        BeneficiaryService,
        ErrorHandlingService
    ]
})
export class CoreModule {

}

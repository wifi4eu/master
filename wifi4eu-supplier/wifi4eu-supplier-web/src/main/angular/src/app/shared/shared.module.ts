import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { UxAllModule } from '@eui/ux-commons';

import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { EmptyStringsValidator } from '../core/directives/validate-empty-string.directive';

@NgModule({
    imports: [
        UxAllModule,
    ],
    declarations: [
        EmptyStringsValidator
    ],
    exports: [
        UxAllModule,
        TranslateModule,
        EmptyStringsValidator
    ]
})
export class SharedModule {

}

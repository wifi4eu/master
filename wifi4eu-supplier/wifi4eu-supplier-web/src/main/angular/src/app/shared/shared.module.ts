import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { UxAllModule } from '@eui/ux-commons';

import { TranslateModule, TranslateLoader } from '@ngx-translate/core';

@NgModule({
    imports: [
        UxAllModule,
    ],
    declarations: [
    ],
    exports: [
        UxAllModule,
        TranslateModule
    ]
})
export class SharedModule {

}

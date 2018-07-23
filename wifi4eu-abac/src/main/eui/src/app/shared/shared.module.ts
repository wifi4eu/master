import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';

import { UxAllModule } from '@eui/ux-commons';

@NgModule({
    imports: [
        UxAllModule,
        TranslateModule,
    ],
    declarations: [
    ],
    exports: [
        UxAllModule,
        TranslateModule,
    ]
})
export class SharedModule {

}

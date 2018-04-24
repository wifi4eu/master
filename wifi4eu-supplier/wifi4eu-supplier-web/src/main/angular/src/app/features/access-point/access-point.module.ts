import { NgModule } from '@angular/core';
import { AccessPointRoutingModule } from './access-point-routing.module';
import { AccessPointComponent } from './access-point.component';

import { SharedModule } from '../../shared/shared.module';
import { AccessPointListComponent } from './components/access-point-list/access-point-list.component';
import { DataTableModule} from "primeng/primeng";
import { SearchParametersService } from '../../core/services/search-parameters.service';

@NgModule({
    imports: [
        SharedModule,
        AccessPointRoutingModule,
        DataTableModule
    ],
    declarations: [
        AccessPointComponent,
        AccessPointListComponent
    ],
    providers: [
        SearchParametersService
    ],
    bootstrap: [
        AccessPointComponent
    ]
})
export class AccessPointModule {
}

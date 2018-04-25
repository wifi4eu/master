import { NgModule } from '@angular/core';
import { AccessPointRoutingModule } from './access-point-routing.module';
import { AccessPointComponent } from './access-point.component';

import { SharedModule } from '../../shared/shared.module';
import { AccessPointListComponent } from './components/access-point-list/access-point-list.component';
import { DataTableModule, DropdownModule} from "primeng/primeng";
import { SearchParametersService } from '../../core/services/search-parameters.service';
import { UpdateAccessPoint } from './components/update-access-point/update-access-point.component';

@NgModule({
    imports: [
        SharedModule,
        AccessPointRoutingModule,
        DataTableModule, 
        DropdownModule
    ],
    declarations: [
        AccessPointComponent,
        AccessPointListComponent,
        UpdateAccessPoint
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

import { NgModule } from '@angular/core';
import { AccessPointRoutingModule } from './access-point-routing.module';
import { AccessPointComponent } from './access-point.component';

import { SharedModule } from '../../shared/shared.module';
import { AccessPointListComponent } from './components/access-point-list/access-point-list.component';
import { DataTableModule, DropdownModule} from "primeng/primeng";
import { SearchParametersService } from '../../core/services/search-parameters.service';
import { UpdateAccessPoint } from './components/update-access-point/update-access-point.component';
import { AccesspointsApi } from '../../shared/swagger/api/AccesspointsApi';
import { AccessPointDetailsComponent } from './components/access-point-details/access-point-details.component';
import { AccessPointDetailsResolver } from '../../core/services/access-point-service';

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
        AccessPointDetailsComponent,
        UpdateAccessPoint
    ],
    providers: [
        AccessPointDetailsResolver,
        SearchParametersService,
        AccesspointsApi
    ],
    bootstrap: [
        AccessPointComponent
    ]
})
export class AccessPointModule {
}

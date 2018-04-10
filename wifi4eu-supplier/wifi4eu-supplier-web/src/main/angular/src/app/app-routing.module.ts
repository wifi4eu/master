import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { InstallationReportComponent } from "./installation-report/installation-report.component";
import { AccessPointComponent } from "./access-point/access-point.component";


@NgModule({
    imports:[RouterModule.forRoot([
        {
            path: '',
            redirectTo: 'home',
            pathMatch: 'full'
        },{
            path: 'installation-report',
            component: InstallationReportComponent
        },{
            path: 'access-point',
            component: AccessPointComponent
        }
    ])],
    providers: [],
    exports: [RouterModule]
})
export class AppRoutingModule{

}
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InstallationReportComponent } from './installation-report/installation-report.component';
import { AccessPointComponent } from './access-point/access-point.component';
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  imports: [
    CommonModule,
    AppRoutingModule
  ],
  declarations: [InstallationReportComponent, AccessPointComponent]
})
export class AppModule {
  
 }

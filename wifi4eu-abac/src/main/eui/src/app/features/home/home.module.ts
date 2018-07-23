import { NgModule } from '@angular/core';

import { SharedModule } from '../../shared/shared.module';

import { HomeRoutingModule } from './home-routing.module';

import { HomeComponent } from './components/home.component';

@NgModule({
    imports: [
        SharedModule,
        HomeRoutingModule,
    ],
    declarations: [
        HomeComponent,
    ],
    providers: [
    ],
})
export class HomeModule {
}

import { NgModule } from '@angular/core';

import { ApiModule } from '../../shared/api.module';

import { HomeRoutingModule } from './home-routing.module';

import { HomeComponent } from './components/home.component';

@NgModule({
    imports: [
        ApiModule,
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

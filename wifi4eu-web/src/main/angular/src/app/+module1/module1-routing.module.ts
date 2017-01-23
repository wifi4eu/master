import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Page2Component } from './page2/page2.component';
import { Page1Component } from './page1/page1.component';
import { Module1Component } from './module1.component';

@NgModule({
    imports: [
        RouterModule.forChild([
            {path: '', component: Module1Component},
            {path: 'page1', component: Page1Component},
            {path: 'page2', component: Page2Component}
        ])
    ],
    exports: [
        RouterModule
    ]
})
export class Module1RoutingModule {

}
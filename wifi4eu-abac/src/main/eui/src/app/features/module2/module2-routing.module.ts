import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Module2Component } from './module2.component';

@NgModule({
    imports: [
        RouterModule.forChild([
            { path: '', component: Module2Component }
        ])
    ],
    exports: [
        RouterModule
    ]
})
export class Module2RoutingModule {

}

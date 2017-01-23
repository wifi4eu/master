import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
 
@NgModule({
    imports: [
        RouterModule.forRoot([
            { path: '', redirectTo: 'screen/home', pathMatch: 'full' },
            { path: 'index.jsp', redirectTo: 'screen/home' },
            { path: 'screen/home', component: HomeComponent },
            { path: 'screen/module1', loadChildren: 'app/+module1/module1.module#Module1Module' },
            { path: 'screen/module2', loadChildren: 'app/+module2/module2.module#Module2Module' }
        ])
    ],
    exports: [
        RouterModule
    ]
})
export class AppRoutingModule {}
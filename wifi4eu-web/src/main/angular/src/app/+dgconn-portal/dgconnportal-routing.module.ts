import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {DgConnPortalComponent} from "./dgconnportal.component";
import {DgConnTimelineComponent} from "./+timeline/timeline.component";
import {DgConnPublicationComponent} from "./+publication/publication.component";

@NgModule({
    imports: [RouterModule.forChild([
        {
            path: '',
            component: DgConnPortalComponent,
        }, {
            path: 'timeline',
            component: DgConnTimelineComponent
        }, {
            path: 'publication',
            component: DgConnPublicationComponent
        },
    ])],
    exports: [RouterModule]
})
export class DgConnectPortalRoutingModule {
}
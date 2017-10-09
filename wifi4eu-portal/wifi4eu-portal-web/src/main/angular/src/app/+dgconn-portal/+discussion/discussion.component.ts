import {Component, Input} from "@angular/core";
import {DgConnDetails} from "../dgconnportal-details.model";
import {CallDTO, CallDTOBase} from "../../shared/swagger/model/CallDTO";
import {CallApi} from "../../shared/swagger/api/CallApi";

@Component({
    templateUrl: 'discussion.component.html', providers: [CallApi]
})

export class DgConnDiscussionComponent {
    constructor(){

    }
}

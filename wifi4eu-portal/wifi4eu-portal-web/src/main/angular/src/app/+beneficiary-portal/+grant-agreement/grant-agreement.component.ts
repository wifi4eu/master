import {Component, ViewChild} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {LocalStorageService} from "angular-2-local-storage";
import {Observable} from "rxjs/Observable";
import {SharedService} from "../../shared/shared.service";



@Component({
    selector: 'grant-agreement.component',
    templateUrl: 'grant-agreement.component.html'
})

export class GrantAgreementComponent {
    constructor( private sharedService: SharedService, private router: Router, private route: ActivatedRoute,) {
    }

    private goToSignGrantAgreement(){
        this.router.navigate(['../grant-agreement/sign-grant-agreement'], { relativeTo: this.route });
    }
    
}
import { Component } from "@angular/core";
import {LocalStorageService} from "angular-2-local-storage";

@Component({
    selector: 'beneficiary-landing', templateUrl: 'beneficiary-landing.component.html', 
    styles: [`
      @media (max-width: 768px) {
        button.cancel-button, button.publish-button{
          width: 100%;
        }
      }
    `]
})

export class BeneficiaryLandingComponent {
    constructor(private localStorageService: LocalStorageService) {
    }

    private storeRedirectionCookie() {
        this.localStorageService.set("public-redirection", "/beneficiary-registration");
    }
}
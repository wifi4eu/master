import { Component } from "@angular/core";
import {LocalStorageService} from "angular-2-local-storage";

@Component({
    selector: 'supplier-landing', templateUrl: 'supplier-landing.component.html',
    styles: [`
      @media (max-width: 768px) {
        button.cancel-button, button.publish-button{
          width: 100%;
        }
      }
    `]
})

export class SupplierLandingComponent {
    constructor(private localStorageService: LocalStorageService) {
    }

    private storeRedirectionCookie() {
        this.localStorageService.set("public-redirection", "/supplier-registration");
    }
}
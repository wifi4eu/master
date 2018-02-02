import { Component } from "@angular/core";

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
}
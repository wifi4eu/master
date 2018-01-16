import {Component} from "@angular/core";
import {SharedModule} from "../shared/shared.module";

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
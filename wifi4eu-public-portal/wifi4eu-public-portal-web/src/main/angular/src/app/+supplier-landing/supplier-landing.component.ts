import {Component} from "@angular/core";
import {SharedModule} from "../shared/shared.module";

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

}
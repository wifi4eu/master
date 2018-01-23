import { Component } from "@angular/core";

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
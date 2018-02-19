import {Component, ContentChildren, Input, QueryList} from "@angular/core";
import {UxWizardStepsComponent} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/ux-ui-elements/ux-wizard-step/ux-wizard-steps.component";
import {UxWizardStepComponent} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/ux-ui-elements/ux-wizard-step/ux-wizard-step.component";

@Component({
    selector: 'custom-wizard-steps',
    template: `
    <ul class="progress-indicator">
        <li style="cursor: default;" *ngFor="let step of steps" [class.completed]="step.isCompleted" (click)="selectStep(step)" (keypress)="selectStep(step)" [class.active]="step.isActive" tabindex="0">
            <span class="bubble"></span>
            <i class="fa fa-check-circle"></i>
            {{step.label}}
        </li>
    </ul>    
    <div class="step-content">
        <ng-content></ng-content>
    </div>        
  `
})
export class CustomWizardStepsComponent extends UxWizardStepsComponent {
    @Input() isCustomContent: boolean = false;
    @Input() isShowStepTitle: boolean = true;
    @ContentChildren(UxWizardStepComponent) steps:QueryList<UxWizardStepComponent>;

    selectStep(step:UxWizardStepComponent) {
    }
}

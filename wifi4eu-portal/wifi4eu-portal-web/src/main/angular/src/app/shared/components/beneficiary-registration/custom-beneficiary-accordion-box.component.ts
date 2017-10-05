import {Component, Input} from "@angular/core";
import {UxAccordionBoxComponent} from "@ec-digit-uxatec/eui-angular2-ux-commons";

@Component({
    selector: 'custom-beneficiary-accordion-box',
    template: `
    <div *ngIf=!isExpanded class="box accordion-box" [class.expanded]="isExpanded">
        <div class="header" (click)="toggle()">
            <span class="title" [style.padding]="rightSide ? '0.65rem 1rem 0 0' : '0.65rem 0 0 1rem'"
            [style.float]="rightSide ? 'right' : 'left'">{{'expand.label' | translate}}
            <i [class]="getExpandHideClass()" style="font-size: 15px; margin-left: 3px;"></i></span>
        </div>
        <div class="content" (click)="clickInside($event)">
            <ng-content></ng-content>
        </div>
    </div>
    <div *ngIf=isExpanded class="box accordion-box" [class.expanded]="isExpanded">
        <div class="header" (click)="toggle()">
            <span class="title" [style.padding]="rightSide ? '0.65rem 1rem 0 0' : '0.65rem 0 0 1rem'"
            [style.float]="rightSide ? 'right' : 'left'">{{'hide.label' | translate}}
            <i [class]="getExpandHideClass()" style="font-size: 15px; margin-left: 3px;" (click)="toggle()"></i></span>
        </div>
        <div class="content" (click)="clickInside($event)">
            <ng-content></ng-content>
        </div>
    </div>
  `
})

export class CustomBeneficiaryAccordionBoxComponent extends UxAccordionBoxComponent {
    @Input() rightSide: boolean = false;
    @Input() isExpanded: boolean;

    toggle() {
        super.toggle();
        if (this.isExpanded) {
            this.label = "Hide";
        } else {
            this.label = "Expand";
        }
    }

    getExpandHideClass() {
        if (this.isExpanded) {
            return "fa fa-2x fa-chevron-up";
        } else {
            return "fa fa-2x fa-chevron-down";
        }
    }

    clickInside(event: any) {
        return event.preventDefault();
    }
}
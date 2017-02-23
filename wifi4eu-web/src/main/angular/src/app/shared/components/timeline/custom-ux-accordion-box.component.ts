import {Component, Input, Host, forwardRef, Inject} from '@angular/core';
import {UxAccordionBoxComponent} from '@ec-digit-uxatec/eui-angular2-ux-commons';

@Component({
    selector: 'custom-ux-accordion-box',
    template: `
    <div class="box accordion-box" [class.expanded]="isExpanded" (click)="toggle()">
        <div class="header">
            <span class="title" [style.padding]="rightSide ? '0.65rem 1rem 0 0' : '0.65rem 0 0 1rem'"
            [style.float]="rightSide ? 'right' : 'left'">{{label}} 
            <i [class]="getExpandHideClass()" style="font-size: 15px; margin-left: 3px;"></i></span>
        </div>
        <div class="content">
            <ng-content></ng-content>
        </div>
    </div>
  `
})

export class CustomUxAccordionBoxComponent extends UxAccordionBoxComponent {
    @Input() rightSide: boolean = false;

    toggle() {
        super.toggle();
        if (this.isExpanded) {
            this.label = "Hide timeline";
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
}
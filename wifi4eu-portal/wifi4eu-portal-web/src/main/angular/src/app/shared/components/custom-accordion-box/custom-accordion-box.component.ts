import {Component, EventEmitter, Input, Output} from "@angular/core";
import {UxAccordionBoxComponent} from "@ec-digit-uxatec/eui-angular2-ux-commons";

@Component({
    selector: 'custom-accordion-box',
    template: `
        <div class="box accordion-box" [class.expanded]="isExpanded">
            <div class="header" style="cursor: default;">
                <span *ngIf="closable" class="closable" [style.padding]="rightSide ? '0.65rem 0 0 1rem' : '0.65rem 1rem 0 0'"
                      style="cursor: pointer;" [style.float]="rightSide ? 'left' : 'right'"(click)="close()"><i class="fa fa-times"></i></span>
                <span class="title" [style.padding]="rightSide ? '0.65rem 1rem 0 0' : '0.65rem 0 0 1rem'"
                      style="cursor: pointer;" [style.float]="rightSide ? 'right' : 'left'" (click)="toggle()">{{ label | translate}}
                    <i [class]="expandHideClass" style="font-size: 15px; margin-left: 3px;"></i></span>
            </div>
            <div class="content" (click)="clickInside($event)">
                <ng-content></ng-content>
            </div>
        </div>
  `
})

export class CustomAccordionBoxComponent extends UxAccordionBoxComponent {
    @Input() rightSide: boolean = false;
    @Input() isExpanded: boolean = false;
    @Input() closable: boolean = false;
    @Input() label: string = this.isExpanded ? 'hide.label' : 'expand.label';
    expandHideClass: string = this.isExpanded ? 'fa fa-2x fa-chevron-up' : 'fa fa-2x fa-chevron-down';
    @Output('onClose') onClose: EventEmitter<any> = new EventEmitter();

    toggle() {
        super.toggle();
        if (this.isExpanded) {
            this.label = 'Hide';
            this.expandHideClass = 'fa fa-2x fa-chevron-up';
        } else {
            this.label = 'Expand';
            this.expandHideClass = 'fa fa-2x fa-chevron-down';
        }
    }

    clickInside(event: any) {
        return event.preventDefault();
    }

    close() {
        this.onClose.emit();
    }
}